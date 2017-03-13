package aula2202;

import java.util.Random;

public class Exercicio03 {

	/*
	 * Escreva um algoritmo que preencha um vetor de 10 posições com números inteiros
	 * gerados randomicamente. O algoritmo deve informar se o primeiro elemento do vetor é
	 * par ou impar.
	 */

	private int[] vetorNumeros;


	public Exercicio03(){

		int[] vetorAleatorio = new int[10];
		setVetorNumeros(randomFill(vetorAleatorio));
	}


	/*<--------------------------------------------------------------------------------------->*/


	private int[] randomFill(int[] vetorAleatorio){

		Random rand = new Random(System.currentTimeMillis());

		for (int i = 0; i < vetorAleatorio.length; i++){

			vetorAleatorio[i] = rand.nextInt();
		}

		return vetorAleatorio;
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void parImpar(){

		int[] vetor = getVetorNumeros();
		int resto = vetor[0] % 2;

		switch (resto){

		case(0): System.out.println("O primeiro numero do vetor e " + vetor[0] + " e, portanto, e par"); break;		
		case(1): System.out.println("O primeiro numero do vetor e " + vetor[0] + " e, portanto, e impar"); break;
		}
	}


	/*<--------------------------------------------------------------------------------------->*/


	public int[] getVetorNumeros() {
		return vetorNumeros;
	}


	public void setVetorNumeros(int[] vetorNumeros) {
		this.vetorNumeros = vetorNumeros;
	}
}