package lista01Exercicio08;

import java.util.Random;

public class SomaAbaixoDiag {

	/*
	 *Escreva um algoritmo que preencha uma matriz 10 x 10 com números reais gerados
	 *randomicamente. O algoritmo deve somar os elementos abaixo da diagonal principal.
	 */


	private int[][] matrizNumeros;
	int tamanhoMatriz;


	public SomaAbaixoDiag(int tamanho){

		matrizNumeros = preencherAleatorio(tamanho);
		tamanhoMatriz = tamanho;
	}	
	
	public SomaAbaixoDiag(int[][] matriz){

		matrizNumeros = matriz;
		tamanhoMatriz = matriz.length;
	}


	/*<--------------------------------------------------------------------------------------->*/


	public static int[][] preencherAleatorio(int tamanho){

		int[][] matrizAleatoria = new int [tamanho][tamanho];	
		Random aleatorio = new Random(System.currentTimeMillis());

		for (int i = 0; i < tamanho; i++){
			for (int j = 0; j < tamanho; j ++){

				matrizAleatoria[i][j] = aleatorio.nextInt(200);
			}
		}

		return matrizAleatoria;
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void somaElementos(){

		int somaAbaixoDiag = 0;

		for (int i = 1; i < tamanhoMatriz; i ++){
			for (int j = 0; j < i; j++){

				somaAbaixoDiag += matrizNumeros[i][j];
			}
		}

		System.out.println("\nA soma dos elementos abaixo da diagonal principal é: " + somaAbaixoDiag);
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void printMatriz(){

		System.out.println ("\nA matriz gerada é:\n");

		for (int i = 0; i < tamanhoMatriz; i++){
			for (int j = 0; j < tamanhoMatriz; j++){

				System.out.print(matrizNumeros[i][j] + " ");
			}

			System.out.println();
		}
	}

	/*<--------------------------------------------------------------------------------------->*/

}