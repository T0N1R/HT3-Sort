package HT3;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SortsTest {

	Sort sorts = new Sort();
	int[] numeros = sorts.getNumeros();	

	
	//*****************************************************************************************//
	//------------------------------------ QUICKSORT TEST -------------------------------------//
	//*****************************************************************************************//
		
	@Test
	public void quickSortTest() {
	
		sorts.generarNumeros("texto.txt");
		
		//Crea el arreglo de valores esperados copiando y luego ordenando el arreglo de numeros aleatorios
		int[] expecteds = new int[3000];
		for (int i=0; i<expecteds.length; i++) {
			expecteds[i]=numeros[i];
		}
		
		Arrays.sort(expecteds); 
		
		//-------------------------------------------------------------------------------
		
		//Creal el arreglo de valores actuales devueltos por la funcion
		int[] actuals = numeros;
		Sort.quicksort(actuals);
		
		// *Comprobacion de los valores de expected y actuals* quitar comentarios para evaluar
		
		/*for (int i=0; i<expecteds.length; i++) {
			System.out.println(actuals[i] + "  -  " + expecteds[i]);
		}*/
		
		assertArrayEquals(expecteds, actuals); //Comparacion de igualdad
	}
	
	
	
	//*****************************************************************************************//
	//------------------------------------ GNOMESORT TEST -------------------------------------//
	//*****************************************************************************************//
	
	@Test
	public void gnomeSortTest() {
	
		sorts.generarNumeros("texto.txt");
		
		//Crea el arreglo de valores esperados copiando y luego ordenando el arreglo de numeros aleatorios
		int[] expecteds = new int[3000];
		for (int i=0; i<expecteds.length; i++) {
			expecteds[i]=numeros[i];
		}
		
		Arrays.sort(expecteds); 
		
		//-------------------------------------------------------------------------------
		
		//Creal el arreglo de valores actuales devueltos por la funcion
		int[] actuals = numeros;
		actuals = sorts.gnomeSort(numeros, "texto.txt");
		
		
		// *Comprobacion de los valores de expected y actuals* quitar comentarios para evaluar
		
		/*for (int i=0; i<expecteds.length; i++) {
			System.out.println(actuals[i] + "  -  " + expecteds[i]);
		}*/
		
		assertArrayEquals(expecteds, actuals); //Comparacion de igualdad
	}

	
	//*****************************************************************************************//
	//------------------------------------ MERGESORT TEST -------------------------------------//
	//*****************************************************************************************//
		
		@Test
		public void mergeSortTest() {
		
			sorts.generarNumeros("texto.txt");
			
			//Crea el arreglo de valores esperados copiando y luego ordenando el arreglo de numeros aleatorios
			int[] expecteds = new int[3000];
			for (int i=0; i<expecteds.length; i++) {
				expecteds[i]=numeros[i];
			}
			
			Arrays.sort(expecteds); 
			
			//-------------------------------------------------------------------------------
			
			//Creal el arreglo de valores actuales devueltos por la funcion
			int[] actuals = numeros;
			actuals = sorts.mergeSort(numeros, "texto.txt");
			
			
			// *Comprobacion de los valores de expected y actuals* quitar comentarios para evaluar
			
			for (int i=0; i<actuals.length; i++) {
				System.out.println(actuals[i] + "  -  " + expecteds[i]);
			}
			
			assertArrayEquals(expecteds, actuals); //Comparacion de igualdad
		}

		
		//*****************************************************************************************//
		//------------------------------------ BUBBLESORT TEST -------------------------------------//
		//*****************************************************************************************//
			
			@Test
			public void bubbleSortTest() {
			
				sorts.generarNumeros("texto.txt");
				
				//Crea el arreglo de valores esperados copiando y luego ordenando el arreglo de numeros aleatorios
				int[] expecteds = new int[3000];
				for (int i=0; i<expecteds.length; i++) {
					expecteds[i]=numeros[i];
				}
				
				Arrays.sort(expecteds); 
				
				//-------------------------------------------------------------------------------
				
				//Creal el arreglo de valores actuales devueltos por la funcion
				int[] actuals = numeros;
				actuals = sorts.bubbleSort(numeros, "texto.txt");
				
				
				// *Comprobacion de los valores de expected y actuals* quitar comentarios para evaluar
				
				for (int i=0; i<actuals.length; i++) {
					System.out.println(actuals[i] + "  -  " + expecteds[i]);
				}
				
				assertArrayEquals(expecteds, actuals); //Comparacion de igualdad
			}

}
