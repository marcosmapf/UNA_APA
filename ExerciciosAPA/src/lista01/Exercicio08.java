package lista01;

import java.util.Random;

public class Exercicio08 {

	/*
	 *Escreva um algoritmo que preencha uma matriz 10 x 10 com números reais gerados
	 *randomicamente. O algoritmo deve somar os elementos abaixo da diagonal principal
	 *(região amarela na figura abaixo).
	 */


	private int[][] matrizNumeros;


	public Exercicio08(){

		int[][] matrizAleatoria = new int [10][10];
		setMatrizNumeros(randomFill(matrizAleatoria));
	}


	/*<--------------------------------------------------------------------------------------->*/


	private int[][] randomFill(int [][] matrizNumeros){

		Random aleatorio = new Random(System.currentTimeMillis());

		for (int i = 0; i < matrizNumeros.length; i++){

			for (int j = 0; j < matrizNumeros[0].length; j ++){

				matrizNumeros[i][j] = aleatorio.nextInt(200) - 100;
			}
		}

		return matrizNumeros;
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void somaElementos(){

		int somaAbaixoDiag = 0;
		int[][] matriz = getMatrizNumeros();

		for (int i = 1; i < matriz.length; i ++){
			for (int j = 0; j < i; j++){

				somaAbaixoDiag += matriz[i][j];
			}
		}

		System.out.println("\nA soma dos elementos abaixo da diagonal principal é: " + somaAbaixoDiag);
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void printMatrix(){

		int[][] matriz = getMatrizNumeros();

		System.out.println ("\nA matriz gerada é:\n");

		for (int i = 0; i < matriz.length; i++){
			for (int j = 0; j < matriz.length; j++){

				System.out.print(matriz[i][j] + " ");
			}

			System.out.println();
		}
	}

	/*<--------------------------------------------------------------------------------------->*/


	public int[][] getMatrizNumeros() {
		return matrizNumeros;
	}


	public void setMatrizNumeros(int[][] matrizNumeros) {
		this.matrizNumeros = matrizNumeros;
	}
}