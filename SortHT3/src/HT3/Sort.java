
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
    int numeros[] = new int[3000];
    
    int ordenado[] = new int[3000];
    
    
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
            int x = numeros[i];
            //wr.write(String.valueOf(x));
            wr.println(String.valueOf(x));
            
        }  
        
        wr.close();
        bw.close();
            
        }catch(Exception e){
            System.out.println("Hay un problema con el metodo: generarNumeros");
        }

    }
    
    public void gnomeSort(){
        
    }
    
    
    public void mergeSort(){
        
    }
    
    
    public void quickSort(){
        
    }
    
    
    public void radixSort(){
        
    }
    
    
    public void cocktailShakerSort(){
        
    }
}
