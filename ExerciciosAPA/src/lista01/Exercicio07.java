package lista01;

import java.util.Random;

public class Exercicio07 {
	
	/*
	 * Escreva um algoritmo que preencha uma matriz 5 x 5 com números inteiros gerados
	 * randomicamente. O algoritmo deve apresentar a transposta da matriz gerada. Exemplo:
	 */


	private int[][] matrizNumeros;


	public Exercicio07(){

		int[][] matrizAleatoria = new int [5][5];
		setMatrizNumeros(randomFill(matrizAleatoria));
	}


	/*<--------------------------------------------------------------------------------------->*/


	private int[][] randomFill(int [][] matrizNumeros){

		Random aleatorio = new Random(System.currentTimeMillis());

		for (int i = 0; i < matrizNumeros.length; i++){

			for (int j = 0; j < matrizNumeros[0].length; j ++){

				matrizNumeros[i][j] = aleatorio.nextInt();
			}
		}

		return matrizNumeros;
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void transposedMatrix(){

		int[][] matriz = getMatrizNumeros();
		int[][] matrizTransposta = new int[5][5];

		for (int i = 0; i < matriz.length; i ++){
			for (int j = 0; j < matriz[0].length; j++){

				matrizTransposta[i][j] = matriz[j][i];
			}
		}

		printMatrix(matrizTransposta);
	}


	/*<--------------------------------------------------------------------------------------->*/


	private void printMatrix(int[][] matrizTransposta){

		int tamanho = matrizTransposta.length;


		System.out.println ("A matriz inicial é:\n");

		for (int i = 0; i < tamanho; i++){
			for (int j = 0; j < tamanho; j++){

				System.out.print(this.matrizNumeros[i][j] + " ");
			}

			System.out.println();
		}

		System.out.println("\nA matriz transposta é:\n");

		for (int i = 0; i < tamanho; i++){
			for (int j = 0; j < tamanho; j++){

				System.out.print(matrizTransposta[i][j] + " ");
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