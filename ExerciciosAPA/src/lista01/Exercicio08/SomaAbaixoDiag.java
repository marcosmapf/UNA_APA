package lista01.Exercicio08;

import custom.Objects.MatrizInt;

public class SomaAbaixoDiag {

	/*
	 *Escreva um algoritmo que preencha uma matriz 10 x 10 com números reais gerados
	 *randomicamente. O algoritmo deve somar os elementos abaixo da diagonal principal.
	 */


	private MatrizInt matrizNumeros;

	public SomaAbaixoDiag(int tamanho){

		this.matrizNumeros = new MatrizInt(tamanho);
	}	

	public SomaAbaixoDiag(int[][] matriz){

		this.matrizNumeros = new MatrizInt(matriz);
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void somaElementos(){

		int somaAbaixoDiag = 0;

		for (int i = 1; i < this.matrizNumeros.getTamanhoMatriz(); i ++){
			for (int j = 0; j < i; j++){

				somaAbaixoDiag += this.matrizNumeros.getValor(i, j);
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

		return this.matrizNumeros;
	}


	/*<--------------------------------------------------------------------------------------->*/

}