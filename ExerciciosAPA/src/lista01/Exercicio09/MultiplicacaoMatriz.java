package lista01.Exercicio09;

import custom.Objects.MatrizInt;

public class MultiplicacaoMatriz {

	/*
	 * Escreva um algoritmo que preencha uma matriz 4 x 4 com números reais gerados
	 * randomicamente. O algoritmo deve apresentar o resultado da multiplicação da primeira
	 * matriz pela segunda.
	 */

	private MatrizInt primeiraMatriz, segundaMatriz;
	private int tamanhoPrimeira, tamanhoSegunda;

	public MultiplicacaoMatriz(int tamanho){

		primeiraMatriz = new MatrizInt(tamanho);
		tamanhoPrimeira = tamanho;
		primeiraMatriz.preencherAleatorio();

		segundaMatriz = new MatrizInt(tamanho);
		tamanhoSegunda = tamanho;
		segundaMatriz.preencherAleatorio();		

		/*
		System.out.println("\nA primeira matriz gerada é:\n");
		printMatriz(primeiraMatriz);
		System.out.println("\nA segunda matriz gerada é:\n");
		printMatriz(segundaMatriz);
		 */
	}

	public MultiplicacaoMatriz(int[][] matriz1, int[][] matriz2){

		primeiraMatriz = new MatrizInt(matriz1);
		tamanhoPrimeira = matriz1.length;
		segundaMatriz = new MatrizInt(matriz2);
		tamanhoSegunda = matriz2.length; 		
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void prodMatriz(){

		int[][] matrizResultado = new int[tamanhoPrimeira][tamanhoSegunda];

		for (int k = 0; k < tamanhoSegunda; k++){
			for (int i = 0; i < tamanhoPrimeira; i ++){
				for (int j = 0; j < tamanhoSegunda; j++){

					matrizResultado[i][k] += primeiraMatriz.getValor(i, j) * segundaMatriz.getValor(j, k);
				}
			}
		}

		System.out.println("\nA matriz produto gerada é:\n");
		MatrizInt.printMatriz(matrizResultado);
	}


	/*<--------------------------------------------------------------------------------------->*/


	public MatrizInt getPrimeiraMatrizInt() {
		return primeiraMatriz;
	}

	public MatrizInt getSegundaMatrizInt() {
		return segundaMatriz;
	}


	/*<--------------------------------------------------------------------------------------->*/

}