package lista01.Exercicio03;

import custom.Objects.VetorInt;

public class VetorParImpar {

	/*
	 * Escreva um algoritmo que preencha um vetor de 10 posições com números inteiros
	 * gerados randomicamente. O algoritmo deve informar se o primeiro elemento do vetor é
	 * par ou impar.
	 */

	private VetorInt vetorNumeros;

	public VetorParImpar(int tamanho){

		this.vetorNumeros = new VetorInt(tamanho);
	}

	public VetorParImpar(int[] vetor){

		this.vetorNumeros = new VetorInt(vetor);
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void parImpar(){

		int primeiro = vetorNumeros.getValor(0);

		switch (primeiro % 2){

		case(0): System.out.println("\nO primeiro numero do vetor e " + primeiro + " e, portanto, e par"); break;		
		case(1): System.out.println("\nO primeiro numero do vetor e " + primeiro + " e, portanto, e impar"); break;
		}
	}


	/*<--------------------------------------------------------------------------------------->*/


	public VetorInt getVetorInt() {

		return this.vetorNumeros;
	}
}