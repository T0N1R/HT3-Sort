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
 */
public class SortMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Sort main = new Sort();
        
        Scanner scan = new Scanner(System.in);
        boolean salida = false;
        
        while(salida == false){
            System.out.println("Ingrese la accion que se desea realizar: ");
            System.out.println("1---Generar los numeros aleatorios");
            System.out.println("2---Ordenar los numeros por Gnome Sort");
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
                    System.out.println(main.numeros[2999]);
                    break;
                }
            
                case "2":{
                    System.out.println("numeros ordenados por GnomeSort");
                    main.gnomeSort(main.numeros, "texto.txt");
                    break;
                }
            }
        }
        
        
        
        
    }
    
}
