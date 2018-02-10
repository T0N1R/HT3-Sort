
package HT3;
import java.util.Random;
import java.io.*;

/**
 * Guatemala 8 de febrero, 2018
 * Algoritmos y Estructuras de Datos
 * Hoja de Trabajo 3
 * @author Antonio
 */
public class Sort {
    /**
     * Se crean dos arreglos, un arreglo donde se colocaran los 3000 numeros aleatorios.
     * El otro arreglo se encargara de ordenarlos (se utilizaran diferentes sorts).
     */
    Comparable[] numeros = new Comparable[3000];
    
    

    
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
    public void gnomeSort(Comparable[] arreglo, String texto){
        /**En el gnome Sort, se empieza contando desde el segundo número
         */
        int i =0;
        int pos = 1;
        while(i < arreglo.length){
            if(i==0){
                i++;
            }
                
            if(arreglo[i-1].compareTo(arreglo[i])<=0){
                i=pos;
                pos++;
            }else{
                Comparable numMenor = arreglo[i];
                Comparable numMayor = arreglo[i-1];
                
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
        
    }
    
    
    public Comparable[] mergeSort(Comparable [] arreglo, String texto){    
        /**Se crea una variable int cuyo valor es el centro del array, 
         * esto servirá para poder dividir el array con los numero aleatorios
         * en dos.
         */
        int medio = arreglo.length/2;
        
        Comparable[] mitadIzquierda = new Comparable[medio];
        Comparable[] mitadDerecha = new Comparable[medio];
        Comparable[] nuevoOrden = new Comparable[arreglo.length];
        
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
        
        //return nuevoOrden;
        
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
                Comparable x = nuevoOrden[y];
                wr.println(String.valueOf(x));
            }
        }catch(IOException e){
            System.out.println("Hay un problema con el metodo");
        }
        return null;
    }
    
    public Comparable[] merge(Comparable[] mitadIzquierda, Comparable[] mitadDerecha){
        int largo = mitadIzquierda.length + mitadDerecha.length;
        Comparable[] ordenado = new Comparable[largo];
        int contadorIzq = 0;
        int contadorDer = 0;
        int contadorOrdenado = 0;
        
        while(contadorIzq < mitadIzquierda.length || contadorDer < mitadDerecha.length){
            if(contadorIzq < mitadIzquierda.length && contadorDer < mitadDerecha.length){
                if(mitadIzquierda[contadorIzq].compareTo(mitadDerecha[contadorDer])<=0){
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
    
    
    public void quickSort(){
        
    }
    
    
    public void radixSort(){
        
    }
    
    
    public void bubbleSort(Comparable[] arreglo, String texto){
        for(int i = 1; i < arreglo.length; i++){
            for(int j = 0; j<arreglo.length-i;j++){
                if(arreglo[j].compareTo(arreglo[j+1])>0){
                    Comparable numMayor = arreglo[j];
                    Comparable numMenor = arreglo[j+1];
                    
                
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
                Comparable x = arreglo[y];
                wr.println(String.valueOf(x));
            }
        }catch(IOException e){
            System.out.println("Hay un problema con el metodo");
        }
        
        
    }
    

    
    
}
