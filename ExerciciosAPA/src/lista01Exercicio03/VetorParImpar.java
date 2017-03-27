package lista01Exercicio03;

import java.util.Random;

public class VetorParImpar {

	/*
	 * Escreva um algoritmo que preencha um vetor de 10 posições com números inteiros
	 * gerados randomicamente. O algoritmo deve informar se o primeiro elemento do vetor é
	 * par ou impar.
	 */

	private int[] vetorNumeros;
	int tamanhoVetor;


	public VetorParImpar(int tamanho){

		vetorNumeros = preencherAleatorio(tamanho);
		tamanhoVetor = tamanho;
		
	}

	public VetorParImpar(int[] vetor){

		vetorNumeros = vetor;
	}


	/*<--------------------------------------------------------------------------------------->*/


	public static int[] preencherAleatorio(int tamanho){

		int[] vetorAleatorio = new int[tamanho];
		
		Random rand = new Random(System.currentTimeMillis());

		for (int i = 0; i < tamanho; i++){

			vetorAleatorio[i] = rand.nextInt(200);
		}

		return vetorAleatorio;
	}


	/*<--------------------------------------------------------------------------------------->*/

	public void printVetor(){

		System.out.print("\nO vetor gerado possui os números: ");
		for (int i = 0; i < tamanhoVetor - 1; i ++){

			System.out.print(vetorNumeros[i] + ", ");
		}
		System.out.println(vetorNumeros[tamanhoVetor - 1] + ".");
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void parImpar(){

		int resto = vetorNumeros[0] % 2;

		switch (resto){

		case(0): System.out.println("\nO primeiro numero do vetor e " + vetorNumeros[0] + " e, portanto, e par"); break;		
		case(1): System.out.println("\nO primeiro numero do vetor e " + vetorNumeros[0] + " e, portanto, e impar"); break;
		}
	}


	/*<--------------------------------------------------------------------------------------->*/


}