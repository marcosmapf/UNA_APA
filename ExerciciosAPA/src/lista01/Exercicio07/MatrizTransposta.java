package lista01.Exercicio07;

import custom.Objects.MatrizInt;

public class MatrizTransposta {

	/* 
	 * Escreva um algoritmo que preencha uma matriz 5 x 5 com números inteiros gerados
	 * randomicamente. O algoritmo deve apresentar a transposta da matriz gerada. Exemplo:
	 */


	private MatrizInt matrizNumeros;
	int tamanhoMatriz;


	public MatrizTransposta(int tamanho){

		this.matrizNumeros = new MatrizInt(tamanho);
		this.tamanhoMatriz = tamanho;

		System.out.println("\nA matriz aleatoria gerada é:\n");
		matrizNumeros.printMatriz();
	}

	public MatrizTransposta(int[][] matriz){

		matrizNumeros = new MatrizInt(matriz);
		tamanhoMatriz = matriz.length;

		System.out.println("\nA matriz inserida é:\n");
		matrizNumeros.printMatriz();;
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void gerarTransposta(){

		int[][] matrizTransposta = new int[tamanhoMatriz][tamanhoMatriz];

		for (int i = 0; i < tamanhoMatriz; i ++){
			for (int j = 0; j < tamanhoMatriz; j++){

				matrizTransposta[i][j] = matrizNumeros.getValor(j, i);
			}
		}

		System.out.println("\nA matriz transposta é:\n");
		MatrizInt.printMatriz(matrizTransposta);
	}


	/*<--------------------------------------------------------------------------------------->*/


	public MatrizInt getMatrizInt() {
		return matrizNumeros;
	}


	/*<--------------------------------------------------------------------------------------->*/

}