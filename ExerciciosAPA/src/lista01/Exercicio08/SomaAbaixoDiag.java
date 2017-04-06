package lista01.Exercicio08;

import custom.Objects.MatrizInt;

public class SomaAbaixoDiag {

	/*
	 *Escreva um algoritmo que preencha uma matriz 10 x 10 com números reais gerados
	 *randomicamente. O algoritmo deve somar os elementos abaixo da diagonal principal.
	 */


	private MatrizInt matrizNumeros;
	int tamanhoMatriz;


	public SomaAbaixoDiag(int tamanho){

		matrizNumeros = new MatrizInt(tamanho);
		tamanhoMatriz = tamanho;
		matrizNumeros.preencherAleatorio();
	}	

	public SomaAbaixoDiag(int[][] matriz){

		matrizNumeros = new MatrizInt(matriz);
		tamanhoMatriz = matriz.length;
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void somaElementos(){

		int somaAbaixoDiag = 0;

		for (int i = 1; i < tamanhoMatriz; i ++){
			for (int j = 0; j < i; j++){

				somaAbaixoDiag += matrizNumeros.getValor(i, j);
			}
		}

		System.out.println("\nA soma dos elementos abaixo da diagonal principal é: " + somaAbaixoDiag);
	}


	public static void somaElementos(int[][] matriz){

		int tamanho = matriz.length;
		int somaAbaixoDiag = 0;

		for (int i = 1; i < tamanho; i ++){
			for (int j = 0; j < i; j++){

				somaAbaixoDiag += matriz[i][j];
			}
		}

		System.out.println("\nA soma dos elementos abaixo da diagonal principal é: " + somaAbaixoDiag);
	}


	/*<--------------------------------------------------------------------------------------->*/


	public MatrizInt getMatrizInt() {
		return matrizNumeros;
	}


	/*<--------------------------------------------------------------------------------------->*/

}