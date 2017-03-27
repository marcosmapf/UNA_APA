package lista01Exercicio07;

import java.util.Random;

public class MatrizTransposta {

	/* 
	 * Escreva um algoritmo que preencha uma matriz 5 x 5 com números inteiros gerados
	 * randomicamente. O algoritmo deve apresentar a transposta da matriz gerada. Exemplo:
	 */


	private int[][] matrizNumeros;
	int tamanhoMatriz;


	public MatrizTransposta(int tamanho){

		matrizNumeros = preencherAleatorio(tamanho);
		tamanhoMatriz = tamanho;

		System.out.println("\nA matriz aleatoria gerada é:\n");
		printMatriz(matrizNumeros);
	}

	public MatrizTransposta(int[][] matriz){

		matrizNumeros = matriz;
		tamanhoMatriz = matriz.length;

		System.out.println("\nA matriz inserida é:\n");
		printMatriz(matrizNumeros);
	}


	/*<--------------------------------------------------------------------------------------->*/


	public static int[][] preencherAleatorio(int tamanho){


		int [][] matrizAleatoria = new int[tamanho][tamanho];
		Random aleatorio = new Random(System.currentTimeMillis());

		for (int i = 0; i < tamanho; i++){

			for (int j = 0; j < tamanho; j ++){

				matrizAleatoria[i][j] = aleatorio.nextInt(200);
			}
		}

		return matrizAleatoria;
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void gerarTransposta(){

		int[][] matrizTransposta = new int[tamanhoMatriz][tamanhoMatriz];

		for (int i = 0; i < tamanhoMatriz; i ++){
			for (int j = 0; j < tamanhoMatriz; j++){

				matrizTransposta[i][j] = matrizNumeros[j][i];
			}
		}

		System.out.println("\nA matriz transposta é:\n");
		printMatriz(matrizTransposta);
	}


	/*<--------------------------------------------------------------------------------------->*/


	private void printMatriz(int[][] matriz){

		for (int i = 0; i < tamanhoMatriz; i++){
			for (int j = 0; j < tamanhoMatriz; j++){

				System.out.print(matriz[i][j] + " ");
			}

			System.out.println();
		}
	}


	/*<--------------------------------------------------------------------------------------->*/

}