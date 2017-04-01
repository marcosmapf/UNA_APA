package lista02.Exercicio03;

import java.util.Random;

public class Exercicio03 {

	/*Escreva um algoritmo em Java que instancie uma matriz N x N. O algoritmo deve preencher
	 * 	todas as posições da Matriz com números randômicos. Crie um contador para contabilizar o
	 * 	número de valores inseridos na Matriz. Ao final da execução, o algoritmo deve imprimir o valor
	 * 	de N seguido do valor do contador. Em seguida, repita o experimento com matrizes de tamanho
	 * 	100, 1.000, 10.000, 100.000 e 1.000.000. Construa um gráfico "Tamanho do Vetor (N)" X
	 * 	"Número de Operações (OP)" no Excel.
	 */

	int[][] matrizNumeros;
	int tamanhoMatriz = 0;
	int contador = 0;
	

	public Exercicio03(int tamanho){

		matrizNumeros = preencherMatriz(tamanho);
		tamanhoMatriz = tamanho;
	}
	
	public Exercicio03(int[][] matriz){
		
		matrizNumeros = matriz;
		tamanhoMatriz = matriz.length;
	}
	
	
	/*<--------------------------------------------------------------------------------------->*/
	
	
	private int[][] preencherMatriz(int tamanho){

		int[][] matrizAleatoria = new int[tamanho][tamanho];
		Random aleatorio = new Random(System.currentTimeMillis());
		contador = 0;

		for (int i = 0; i < tamanho; i ++){
			for (int j = 0; j < tamanho; j ++){

				matrizAleatoria[i][j] = aleatorio.nextInt(1000);
				contador++;
			}	
		}

		return matrizAleatoria;
	}
	
	
	/*<--------------------------------------------------------------------------------------->*/
	
	
	public void printResultado(){

		System.out.println("\nTamanho da matriz: " + tamanhoMatriz);
		System.out.println("Valor do contador: " + contador);
	}
}