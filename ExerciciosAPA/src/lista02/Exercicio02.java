package lista02;

import java.util.Random;

public class Exercicio02 {

	/*Escreva um algoritmo em Java que instancie um vetor de 10 posições. O algoritmo deve
	 * preencher todas as posições do vetor com números randômicos. Crie um contador para
	 * contabilizar o número de valores inseridos no vetor. Ao final da execução, o algoritmo deve
	 * imprimir o tamanho do vetor seguido do valor do contador. Em seguida, repita o experimento
	 * com vetores de tamanho 100, 1.000, 10.000, 100.000 e 1.000.000. Construa um gráfico
	 * "Tamanho do Vetor (N)" X "Número de Operações (OP)" no Excel.
	 */

	int[] vetorAleatorio;
	int tamanhoVetor;

	public Exercicio02(int tamanho){

		tamanhoVetor = tamanho;
		int[] vetor = new int[tamanho];

		preencherVetor(vetor);
	}
	
	
	/*<--------------------------------------------------------------------------------------->*/
	
	

	private void preencherVetor(int[] vetor){

		Random aleatorio = new Random(System.currentTimeMillis());
		int contador = 0;

		for (int i = 0; i < tamanhoVetor; i ++){
			vetor[i] = aleatorio.nextInt(1000);
			contador++;

		}	

		printResultados(contador);
	}

	
	/*<--------------------------------------------------------------------------------------->*/
	
	
	private void printResultados(int contador){

		System.out.println("\nTamanho do vetor:  " + tamanhoVetor);
		System.out.println("Valor do contador: " + contador + "\n");
	}
}