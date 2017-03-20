package lista01;

import java.util.Random;

public class Exercicio09 {

	/*
	 * Escreva um algoritmo que preencha uma matriz 4 x 4 com números reais gerados
	 * randomicamente. O algoritmo deve apresentar o resultado da multiplicação da primeira
	 * matriz pela segunda.
	 */

	//Observação: O método CurrentTimeMillis(), usado como parâmetro da intância de classe Random() estava retornando
	//uma seed idêntica à anterior na segunda criação de Random() já que o intervalo de tempo era muito pequeno e, então,
	//foi necessário preencher ambas as matrizes simultaneamente dentro do método randomFill().

	private int[][] primeiraMatriz, segundaMatriz;	

	public Exercicio09(){

		randomFill();
	}


	/*<--------------------------------------------------------------------------------------->*/


	private void randomFill(){

		Random aleatorio = new Random(System.currentTimeMillis());

		int[][] matriz1 = new int [4][4];
		int[][] matriz2 = new int [4][4];		

		for (int i = 0; i < matriz1.length; i++){

			for (int j = 0; j < matriz1[0].length; j ++){

				matriz1[i][j] = aleatorio.nextInt(10);
				matriz2[i][j] = aleatorio.nextInt(10);
			}
		}

		setPrimeiraMatriz(matriz1);
		setSegundaMatriz(matriz2);
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void prodMatrix(){

		int[][] matriz1 = getPrimeiraMatriz(), matriz2 = getSegundaMatriz();

		int tamanhoLinha = matriz2.length, tamanhoColuna = matriz1.length;
		int[][] matrizResultado = new int[tamanhoLinha][tamanhoColuna];


		for (int k = 0; k < tamanhoColuna; k++){
			for (int i = 0; i < tamanhoLinha; i ++){
				for (int j = 0; j < tamanhoColuna; j++){

					matrizResultado[i][k] += matriz1[j][k] * matriz2[i][j];
				}
			}
		}

		printMatrix(matrizResultado);
	}


	/*<--------------------------------------------------------------------------------------->*/


	private void printMatrix(int[][] matrizResultado){

		int[][] matriz1 = getPrimeiraMatriz();
		int[][] matriz2 = getSegundaMatriz();

		System.out.println ("\nA primeira matriz gerada é:\n");

		for (int i = 0; i < matriz1.length; i++){
			for (int j = 0; j < matriz1.length; j++){

				System.out.print(matriz1[i][j] + " ");
			}

			System.out.println();
		}

		System.out.println ("\nA segunda matriz gerada é:\n");

		for (int i = 0; i < matriz2.length; i++){
			for (int j = 0; j < matriz2.length; j++){

				System.out.print(matriz2[i][j] + " ");
			}

			System.out.println();
		}	

		System.out.println ("\nA matriz produto (resultado) é:\n");

		for (int i = 0; i < matrizResultado.length; i++){
			for (int j = 0; j < matrizResultado.length; j++){

				System.out.print(matrizResultado[i][j] + " ");
			}

			System.out.println();
		}	
	}


	/*<--------------------------------------------------------------------------------------->*/


	public int[][] getPrimeiraMatriz() {
		return primeiraMatriz;
	}

	public void setPrimeiraMatriz(int[][] matrizNumeros) {
		this.primeiraMatriz = matrizNumeros;
	}

	public int[][] getSegundaMatriz() {
		return segundaMatriz;
	}

	public void setSegundaMatriz(int[][] matrizNumeros) {
		this.segundaMatriz = matrizNumeros;
	}
}