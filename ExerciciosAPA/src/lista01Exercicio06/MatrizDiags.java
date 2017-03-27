package lista01Exercicio06;

import java.util.Random;

public class MatrizDiags {

	/* 
	 * Escreva um algoritmo que preencha uma matriz 10 x 10 com números reais gerados
	 * randomicamente. O algoritmo deve apresentar os elementos da diagonal principal e da
	 * diagonal secundária da matriz. Exemplo:
	 */
	
	private int[][] matrizNumeros;
	int tamanhoMatriz;

	public MatrizDiags(int tamanho){

		matrizNumeros = preencherAleatorio(tamanho);
		tamanhoMatriz = tamanho;
	}


	/*<--------------------------------------------------------------------------------------->*/


	public static int[][] preencherAleatorio(int tamanho){

		int[][] matrizAleatoria = new int[tamanho][tamanho];
		Random aleatorio = new Random(System.currentTimeMillis());

		for (int i = 0; i < tamanho; i++){

			for (int j = 0; j < tamanho; j ++){

				matrizAleatoria[i][j] = aleatorio.nextInt(200);
			}
		}

		return matrizAleatoria;
	}


	/*<--------------------------------------------------------------------------------------->*/
	

	public void printMatriz(){
	
		for (int i = 0; i < tamanhoMatriz; i ++){
			for (int j = 0; j < tamanhoMatriz; j++){
				
				System.out.print(matrizNumeros[i][j] + " ");
			}
			
			System.out.println();
		}
	}
	
	
	/*<--------------------------------------------------------------------------------------->*/
	

	public void diagPri(){

		System.out.print("\nOs valores da diagonal principal são: ");
		for (int i = 0; i < tamanhoMatriz -1; i++){

			System.out.print(matrizNumeros[i][i] + ", ");
		}	

		System.out.print(matrizNumeros[tamanhoMatriz-1][tamanhoMatriz-1] + ".");
	}

	/*<--------------------------------------------------------------------------------------->*/


	public void diagSec(){

		System.out.print("\nOs valores da diagonal secundaria são: ");
		for (int i = 0; i < tamanhoMatriz - 1; i++){

			System.out.print(matrizNumeros[i][tamanhoMatriz - i - 1] + ", ");
		}

		System.out.print(matrizNumeros[tamanhoMatriz - 1][0] + ".");
	}	


	/*<--------------------------------------------------------------------------------------->*/

}