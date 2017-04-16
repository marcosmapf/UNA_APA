package lista01.Exercicio07;

import custom.Objects.MatrizInt;

public class MatrizTransposta {

	/* 
	 * Escreva um algoritmo que preencha uma matriz 5 x 5 com números inteiros gerados
	 * randomicamente. O algoritmo deve apresentar a transposta da matriz gerada. Exemplo:
	 */


	private MatrizInt matrizNumeros;

	public MatrizTransposta(int tamanho){

		this.matrizNumeros = new MatrizInt(tamanho);
	}

	public MatrizTransposta(int[][] matriz){

		this.matrizNumeros = new MatrizInt(matriz);

		System.out.println("\nA matriz inserida é:\n");
		this.matrizNumeros.printMatriz();;
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void gerarTransposta(){

		int[][] matrizTransposta = new int[this.matrizNumeros.getTamanhoMatriz()][this.matrizNumeros.getTamanhoMatriz()];

		for (int i = 0; i < this.matrizNumeros.getTamanhoMatriz(); i ++){
			for (int j = 0; j < this.matrizNumeros.getTamanhoMatriz(); j++){

				matrizTransposta[i][j] = this.matrizNumeros.getValor(j, i);
			}
		}

		System.out.println("\nA matriz transposta é:\n");
		MatrizInt.printMatriz(matrizTransposta);
	}


	/*<--------------------------------------------------------------------------------------->*/


	public MatrizInt getMatrizInt() {
		
		return this.matrizNumeros;
	}


	/*<--------------------------------------------------------------------------------------->*/

}