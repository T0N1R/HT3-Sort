/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HT3;
import java.util.Random;

/**
 *
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
    public void generarNumeros(){
        Random aleatorio = new Random();
        for(int i=0; i<=2999; i++){
            numeros[i]= aleatorio.nextInt(3001);
        }
    }
}
