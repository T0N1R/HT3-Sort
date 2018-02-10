
package HT3;
import java.util.Random;
import java.io.*;

/**
 * Guatemala 8 de febrero, 2018
 * Algoritmos y Estructuras de Datos
 * Hoja de Trabajo 3
 * @author Antonio
 * @author Claude Calewart
 */
public class Sort implements Comparable {
    /**
     * Se crean dos arreglos, un arreglo donde se colocaran los 3000 numeros aleatorios.
     * El otro arreglo se encargara de ordenarlos (se utilizaran diferentes sorts).
     */
    int[] numeros = new int[3000];
    
    int[] ordenados = new int[3000];

    //Getts and Setts
    
    public int[] getNumeros() {
		return numeros;
	}


	public void setNumeros(int[] numeros) {
		this.numeros = numeros;
	}


	public int[] getOrdenados() {
		return ordenados;
	}


	public void setOrdenados(int[] ordenados) {
		this.ordenados = ordenados;
	}


	/**
     * metodo generarNumeros se utiliza para generar numeros entre 0 y 3000
     * se crea un objeto tipo Random. aleatorio.nextInt(limite) creara un 
     * numero entero entre 0 y el numero agregado -1.
     */
    public void generarNumeros(String texto){ 
        
        File f;
        FileWriter w;
        BufferedWriter bw;
        PrintWriter wr;
        
        try{
            //se llama al archivo
            f = new File(texto);
            
            //
            w = new FileWriter(f);
            
            //
            bw = new BufferedWriter(w);
            
            //
            wr = new PrintWriter(bw);
            
        Random aleatorio = new Random();
        for(int i=0; i<=2999; i++){
            numeros[i]= aleatorio.nextInt(3001);
            int x = (int) numeros[i];
            //wr.write(String.valueOf(x));
            wr.println(String.valueOf(x));
            
        }  
        
        wr.close();
        bw.close();
            
        }catch(Exception e){
            System.out.println("Hay un problema con el metodo: generarNumeros");
        }

    }
    
    
    /**
     * El metodo ghomeSort se basa en el documento proveido en canvas
     * https://uvg.instructure.com/courses/4091/files/10778?module_item_id=7766
     * @param arreglo
     * @param texto 
     */
    public int[] gnomeSort(int[] arreglo, String texto){
        /**En el gnome Sort, se empieza contando desde el segundo número
         */
        int i =0;
        int pos = 1;
        while(i < arreglo.length){
            if(i==0){
                i++;
            }
                
            if(arreglo[i-1]<=arreglo[i]){
                i=pos;
                pos++;
            }else{
                int numMenor = arreglo[i];
                int numMayor = arreglo[i-1];
                
                arreglo[i-1] = numMenor;
                arreglo[i] = numMayor;
                i--;
                
            }
            
        }
        
        /**
         * Despues de ordenar todo el arreglo, se ingresaran todos los valores
         * en texto.txt.
         */
        File f;
        FileWriter w;
        BufferedWriter bw;
        PrintWriter wr;
        
        try{
            f = new File (texto);
            
            w = new FileWriter(f);
            
            bw = new BufferedWriter(w);
            
            wr = new PrintWriter(bw);
            
            for (int y=0 ; y<arreglo.length; y++){
                Comparable x = arreglo[y];
                wr.println(String.valueOf(x));
            }
        }catch(IOException e){
            System.out.println("Hay un problema con el metodo");
        }
		return arreglo;
        
    }
    
    
    public int[] mergeSort(int [] arreglo, String texto){    
        /**Se crea una variable int cuyo valor es el centro del array, 
         * esto servirá para poder dividir el array con los numero aleatorios
         * en dos.
         */
        int medio = arreglo.length/2;
        
        int[] mitadIzquierda = new int[medio];
        int[] mitadDerecha = new int[medio];
        int[] nuevoOrden = new int[arreglo.length];
        
        for(int i = 0; i<medio; i++){
            mitadIzquierda[i] = arreglo[i];
        }
        
        int variable = 0;
        for(int j = medio; j<arreglo.length; j++){
            mitadDerecha[variable] = arreglo[j];
            variable++;
        }
        
        mitadIzquierda = mergeSort(mitadIzquierda, null);
        mitadDerecha = mergeSort(mitadDerecha, null);
        
        nuevoOrden = merge(mitadIzquierda, mitadDerecha);
        
        
        
        File f;
        FileWriter w;
        BufferedWriter bw;
        PrintWriter wr;
        
        try{
            f = new File (texto);
            
            w = new FileWriter(f);
            
            bw = new BufferedWriter(w);
            
            wr = new PrintWriter(bw);
            
            for (int y=0 ; y<nuevoOrden.length; y++){
                int x = nuevoOrden[y];
                wr.println(String.valueOf(x));
            }
        }catch(IOException e){
            System.out.println("Hay un problema con el metodo");
        }
		return nuevoOrden;
        
    }
    
    public int[] merge(int[] mitadIzquierda, int[] mitadDerecha){
        int largo = mitadIzquierda.length + mitadDerecha.length;
        int[] ordenado = new int[largo];
        int contadorIzq = 0;
        int contadorDer = 0;
        int contadorOrdenado = 0;
        
        while(contadorIzq < mitadIzquierda.length || contadorDer < mitadDerecha.length){
            if(contadorIzq < mitadIzquierda.length && contadorDer < mitadDerecha.length){
                if(mitadIzquierda[contadorIzq]<=mitadDerecha[contadorDer]){
                    ordenado[contadorOrdenado] = mitadIzquierda[contadorIzq];
                    contadorIzq++;
                    contadorOrdenado++;
                }else{
                    ordenado[contadorOrdenado] = mitadDerecha[contadorDer];
                    contadorDer++;
                    contadorOrdenado++;
                }
            }
        }
        return ordenado;
    }
    
    
    //--------------------------------- QUICK SORT-----------------------------------//
    
    public static void intercambiar(int arreglo[], int i, int j) {
    	// ingresa: i<=0, j < arreglo.legth
    	// devuelve: intercambio entre i y j
    	
    	int temp;
    	temp = arreglo[i];
    	arreglo[i] = arreglo[j];
    	arreglo[j] = temp;
    }
    
    private static int particion(int arreglo[], int izq, int der) {
    	// ingresa: izq <= der
    	// devuelve: arreglo[izq] en la posicion (retornada) correcta
    	
    	while (true) {

    		// Mover puntero derecho hacia la izquierda
    		while (izq < der && arreglo[izq] < arreglo[der]) der--;
    		if (izq < der) intercambiar(arreglo,izq++,der);
    		else return izq;
    		
    		// Mover puntero izquierdo hacia la derecha
    		while (der < izq && arreglo[izq] < arreglo[der]) izq--;
    		if (izq < der) intercambiar(arreglo,izq,der--);
    		else return der;
    	}	
    }
    
    //----METODO QUICKSORT---//
    
    public static void quicksort(int[] arreglo){
    // devuelve: los valores en arreglo[] en orden ascendente

    	quickSortRecurrente(arreglo,0,arreglo.length-1);
    }
    
    private static void quickSortRecurrente(int arreglo[], int izq, int der) {
    	// ingresa: izquierda <= derecha
    	// devuelve: arreglo[] en orden ascendente
    	
    	int pivote; // la ubicacion final de la variable del extremo izquierdo
    	if (izq >= der) return;
    	pivote = particion(arreglo,izq,der); // lugar del pivote
    	quickSortRecurrente(arreglo, izq, pivote-1);
    	quickSortRecurrente(arreglo, pivote+1, der);
    }
    
    
    //--------------------------------- FIN QUICK SORT ----------------------------//

 
    
    
    public void radixSort(){
        
    }
    
    
    public int[] bubbleSort(int[] arreglo, String texto){
        for(int i = 1; i < arreglo.length; i++){
            for(int j = 0; j<arreglo.length-i;j++){
                if(arreglo[j]>arreglo[j+1]){
                    int numMayor = arreglo[j];
                    int numMenor = arreglo[j+1];
                    
                
                    arreglo[j+1] = numMayor;
                    arreglo[j] = numMenor;
                }
            }
        }
        
        for(int y =0; y<arreglo.length; y++){
            System.out.println(arreglo[y]);
        }
        
        /**
         * Despues de ordenar todo el arreglo, se ingresaran todos los valores
         * en texto.txt.
         */
        File f;
        FileWriter w;
        BufferedWriter bw;
        PrintWriter wr;
        
        try{
            f = new File (texto);
            
            w = new FileWriter(f);
            
            bw = new BufferedWriter(w);
            
            wr = new PrintWriter(bw);
            
            for (int y=0 ; y<arreglo.length; y++){
                int x = arreglo[y];
                wr.println(String.valueOf(x));
            }
        }catch(IOException e){
            System.out.println("Hay un problema con el metodo");
        }
		return arreglo;
        
        
    }


	//METODO COMPARABLE
    
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
    

    
    
}
