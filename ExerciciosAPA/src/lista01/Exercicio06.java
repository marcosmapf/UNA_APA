package lista01;

import java.util.Random;

public class Exercicio06 {

	/* 
	 * Escreva um algoritmo que preencha uma matriz 10 x 10 com números reais gerados
	 * randomicamente. O algoritmo deve apresentar os elementos da diagonal principal e da
	 * diagonal secundária da matriz. Exemplo:
	 */
	
	private int[][] matrizNumeros;

	public Exercicio06(){

		int[][] matrizAleatoria = new int [10][10];
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


	public void mainDiag(){

		int matriz[][] = getMatrizNumeros();
		int tamanho = matriz.length;

		System.out.print("\nOs valores da diagonal principal são: ");
		for (int i = 0; i < tamanho -1; i++){

			System.out.print(matriz[i][i] + ", ");
		}	

		System.out.print(matriz[tamanho-1][tamanho-1] + ".");
	}

	/*<--------------------------------------------------------------------------------------->*/


	public void secDiag(){

		int matriz[][] = getMatrizNumeros();
		int tamanho = matriz.length;

		System.out.print("\nOs valores da diagonal secundaria são: ");
		for (int i = 0; i < tamanho - 1; i++){

			System.out.print(matriz[i][tamanho-i - 1] + ", ");
		}

		System.out.print(matriz[tamanho-1][0] + ".");
	}	


	/*<--------------------------------------------------------------------------------------->*/


	public int[][] getMatrizNumeros() {
		return matrizNumeros;
	}


	public void setMatrizNumeros(int[][] matrizNumeros) {
		this.matrizNumeros = matrizNumeros;
	}
}