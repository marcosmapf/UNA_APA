package lista02.Exercicio02;

import java.util.Random;

public class Exercicio02 {

	/*Escreva um algoritmo em Java que instancie um vetor de 10 posições. O algoritmo deve
	 * preencher todas as posições do vetor com números randômicos. Crie um contador para
	 * contabilizar o número de valores inseridos no vetor. Ao final da execução, o algoritmo deve
	 * imprimir o tamanho do vetor seguido do valor do contador. Em seguida, repita o experimento
	 * com vetores de tamanho 100, 1.000, 10.000, 100.000 e 1.000.000. Construa um gráfico
	 * "Tamanho do Vetor (N)" X "Número de Operações (OP)" no Excel.
	 */

	int[] vetorNumeros;
	int tamanhoVetor = 0;
	int contador = 0;

	public Exercicio02(int tamanho){

		vetorNumeros = preencherVetor(tamanho);
		tamanhoVetor = tamanho;
	}
	
	
	/*<--------------------------------------------------------------------------------------->*/
		

	private int[] preencherVetor(int tamanho){

		int[] vetorAleatorio = new int[tamanho];
		Random aleatorio = new Random(System.currentTimeMillis());
		contador = 0;

		for (int i = 0; i < tamanho; i ++){
			
			vetorAleatorio[i] = aleatorio.nextInt(1000);
			contador++;
		}	

		return vetorAleatorio;
	}

	
	/*<--------------------------------------------------------------------------------------->*/
	
	
	public void printResultado(){

		System.out.println("\nTamanho do vetor:  " + tamanhoVetor);
		System.out.println("Valor do contador: " + contador);
	}
}