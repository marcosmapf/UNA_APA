package aula2202;

import java.util.Random;

public class Exercicio05 {
	
	/*
	 *  Escreva um algoritmo que preencha um vetor de 10 posições com números inteiros
	 * gerados randomicamente. O algoritmo deve apresentar a quantidade de números pares 
	 * e a quantidade de números ímpares armazenados no vetor.
	 */

	private int[] vetorNumeros;

	public Exercicio05(){

		int[] vetorAleatorio = new int [10];
		setVetorNumeros(randomFill(vetorAleatorio));
	}


	/*<--------------------------------------------------------------------------------------->*/


	private int[] randomFill(int [] vetorNumeros){

		Random aleatorio = new Random(System.currentTimeMillis());

		for (int i = 0; i < vetorNumeros.length; i++){

			vetorNumeros[i] = aleatorio.nextInt();
		}

		return vetorNumeros;
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void countParImpar(){

		int[] vetor = getVetorNumeros();
		
		int par = 0, impar = 0;

		for (int i = 0; i < vetor.length; i++){

			if (vetor[i] % 2 == 0){
				par ++;
			}
			else impar ++;
		}

		System.out.println("\nO vetor possui " + par + " numeros pares e " + impar + " numeros impares.");
	}
	
	
	/*<--------------------------------------------------------------------------------------->*/
	
	
	public int[] getVetorNumeros() {
		
		return vetorNumeros;
	}


	public void setVetorNumeros(int[] vetorNumeros) {
		
		this.vetorNumeros = vetorNumeros;
	}

}