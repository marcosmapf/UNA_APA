package lista01.Exercicio04;

import custom.Objects.VetorInt;

public class alternandoNumeros {

	/*
	 * Escreva um algoritmo que preencha um vetor de 10 posições com números inteiros
	 * gerados randomicamente. O algoritmo deve trocar o elemento da primeira posição do
	 * vetor com o elemento da última posição do vetor. O algoritmo deve imprimir os
	 * números da primeira e da última posição do vetor antes e após a troca.
	 */

	private VetorInt vetorNumeros;
	int tamanhoVetor;

	public alternandoNumeros(int tamanho){

		vetorNumeros = new VetorInt(tamanho);
		tamanhoVetor = tamanho;
	}


	public alternandoNumeros(int[] vetor){

		vetorNumeros = new VetorInt(vetor);
		tamanhoVetor = vetor.length;
	}

	/*<--------------------------------------------------------------------------------------->*/


	public void flipFlop(){

		int auxiliar = vetorNumeros.getValor(0);

		System.out.println("\nAlternando o primeiro e o ultimo numeros");		

		vetorNumeros.setValor(0, vetorNumeros.getValor(tamanhoVetor - 1));
		vetorNumeros.setValor(tamanhoVetor - 1, auxiliar);
	}


	/*<--------------------------------------------------------------------------------------->*/


	public VetorInt getVetorInt() {
		return vetorNumeros;
	}


	/*<--------------------------------------------------------------------------------------->*/


}