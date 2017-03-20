package lista01;

import java.util.Random;

public class Exercicio04 {
	
	/*
	 * Escreva um algoritmo que preencha um vetor de 10 posições com números inteiros
	 * gerados randomicamente. O algoritmo deve trocar o elemento da primeira posição do
	 * vetor com o elemento da última posição do vetor. O algoritmo deve imprimir os
	 * números da primeira e da última posição do vetor antes e após a troca.
	 */

	private int[] vetorNumeros;


	public Exercicio04(){

		int[] vetorAleatorio = new int[10];
		setVetorNumeros(randomFill(vetorAleatorio));
	}


	/*<--------------------------------------------------------------------------------------->*/


	public int[] randomFill(int[] vetorAleatorio){

		Random rand = new Random(System.currentTimeMillis());

		for (int i = 0; i < vetorAleatorio.length; i++){

			vetorAleatorio[i] = rand.nextInt();
		}

		return vetorAleatorio;
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void flipFlop(){

		int[] vetor = getVetorNumeros();
		int tamanho = vetor.length;
		int hold = vetor[0];

		System.out.println("\nO primeiro numero do vetor e: " + vetor[0] + " e o ultimo número e: " + vetor[tamanho-1]);
		System.out.println("Alternando o primeiro e o ultimo numeros");		

		vetor[0] = vetor[tamanho-1];
		vetor[tamanho-1] = hold;

		System.out.println("O primeiro numero do vetor e: " + vetor[0] + " e o ultimo número e: " + vetor[tamanho-1]);
	}


	/*<--------------------------------------------------------------------------------------->*/


	public int[] getVetorNumeros() {
		return vetorNumeros;
	}


	public void setVetorNumeros(int[] vetorNumeros) {
		this.vetorNumeros = vetorNumeros;
	}
}