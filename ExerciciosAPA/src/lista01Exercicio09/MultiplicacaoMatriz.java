package lista01Exercicio09;

import java.security.SecureRandom;
import java.util.Random;

public class MultiplicacaoMatriz {

	/*
	 * Escreva um algoritmo que preencha uma matriz 4 x 4 com números reais gerados
	 * randomicamente. O algoritmo deve apresentar o resultado da multiplicação da primeira
	 * matriz pela segunda.
	 */

	private int[][] primeiraMatriz, segundaMatriz;	
	private int tamanhoPrimeira, tamanhoSegunda;

	public MultiplicacaoMatriz(int tamanho){

		primeiraMatriz = preencherAleatorio(tamanho);
		segundaMatriz = preencherAleatorio(tamanho);		
		tamanhoPrimeira = tamanho; 
		tamanhoSegunda = tamanho;
		
		System.out.println("\nA primeira matriz gerada é:\n");
		printMatriz(primeiraMatriz);
		System.out.println("\nA segunda matriz gerada é:\n");
		printMatriz(segundaMatriz);
	}

	public MultiplicacaoMatriz(int[][] matriz1, int[][] matriz2){

		primeiraMatriz = matriz1;
		segundaMatriz = matriz2;		
		tamanhoPrimeira = matriz1.length;
		tamanhoSegunda = matriz2.length; 
		
		System.out.println("\nA primeira matriz inserida é:\n");
		printMatriz(primeiraMatriz);
		System.out.println("\nA segunda matriz inserida é:\n");
		printMatriz(segundaMatriz);
	}


	/*<--------------------------------------------------------------------------------------->*/


	public static int[][] preencherAleatorio(int tamanho){

		int[][] matrizAleatoria = new int[tamanho][tamanho];
		SecureRandom aleatorio = new SecureRandom();

		for (int i = 0; i < tamanho; i++){

			for (int j = 0; j < tamanho; j ++){

				matrizAleatoria[i][j] = aleatorio.nextInt(200);
			}
		}

		return matrizAleatoria;
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void prodMatriz(){

		int[][] matrizResultado = new int[tamanhoPrimeira][tamanhoSegunda];

		for (int k = 0; k < tamanhoSegunda; k++){
			for (int i = 0; i < tamanhoPrimeira; i ++){
				for (int j = 0; j < tamanhoSegunda; j++){

					matrizResultado[i][k] += primeiraMatriz[i][j] * segundaMatriz[j][k];
				}
			}
		}

		System.out.println("\nA matriz produto gerada é:\n");
		printMatriz(matrizResultado);
	}


	/*<--------------------------------------------------------------------------------------->*/


	private void printMatriz(int[][] matriz){

		for (int i = 0; i < matriz.length; i++){
			for (int j = 0; j < matriz.length; j++){

				System.out.print(matriz[i][j] + " ");
			}

			System.out.println();
		}
	}


	/*<--------------------------------------------------------------------------------------->*/

}