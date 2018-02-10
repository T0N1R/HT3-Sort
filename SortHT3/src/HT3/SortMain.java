package HT3;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Antonio
 * @author Claude Calewart
 */
public class SortMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Sort main = new Sort();
        int[] numeros = main.numeros;
        int[] ordenados = main.ordenados;
        
        Scanner scan = new Scanner(System.in);
        boolean salida = false;
        System.out.println(main.numeros.length);
        while(salida == false){
            System.out.println("Ingrese la accion que se desea realizar: ");
            System.out.println("1---Generar los numeros aleatorios");
            System.out.println("2---Ordenar los numeros por Gnome Sort");
            System.out.println("3---Ordenar los numeros por Bubble Sort");
            System.out.println("4---Ordenar los numeros por Merge Sort");
            System.out.println("4---Ordenar los numeros por Quick Sort");
            String eleccion = scan.nextLine();
            
            switch(eleccion){
                
                case "0":{
                    salida = true;
                    break;
                }
                
                case "1":{
                    main.generarNumeros("texto.txt");
                    System.out.println("Se generaron los numeros aleatorios");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("---------------------------------------");
                    break;
                }
            
                case "2":{
                    System.out.println("numeros ordenados por GnomeSort");
                    main.gnomeSort(main.numeros, "texto.txt");
                    break;
                }
                
                case "3":{
                    System.out.println("Numeros ordenados por bubbleSort");
                    main.bubbleSort(main.numeros, "texto.txt");
                    break;
                }
                
                case "4":{
                    System.out.println("Numeros ordenados por MergeSort");
                    main.mergeSort(main.numeros, "texto.txt");
                    break;
                }
                
                case "5":{
                    System.out.println("Numeros ordenados por Quicksort");
                    main.quicksort(numeros);
                    ordenados = numeros;
                }
                
                
            }
        }
        
        
        
        
    }
    
}
