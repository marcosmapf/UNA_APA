package lista01Exercicio05;

import java.util.Random;

public class QuantParImpar {

	/*
	 *  Escreva um algoritmo que preencha um vetor de 10 posições com números inteiros
	 * gerados randomicamente. O algoritmo deve apresentar a quantidade de números pares 
	 * e a quantidade de números ímpares armazenados no vetor.
	 */

	private int[] vetorNumeros;
	int tamanhoVetor;


	public QuantParImpar(int tamanho){

		vetorNumeros = preencherAleatorio(tamanho);
		tamanhoVetor = tamanho;
	}


	public QuantParImpar(int[] vetor){

		vetorNumeros = vetor;
		tamanhoVetor = vetor.length;
	}

	/*<--------------------------------------------------------------------------------------->*/


	public static int[] preencherAleatorio(int tamanho){

		int[] vetorAleatorio = new int[tamanho];
		Random aleatorio = new Random(System.currentTimeMillis());

		for (int i = 0; i < tamanho; i++){

			vetorAleatorio[i] = aleatorio.nextInt(200);
		}

		return vetorAleatorio;
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void printVetor(){

		System.out.print("\nO vetor gerado possui os números: ");
		
		for (int i = 0; i < tamanhoVetor - 1; i++){
			System.out.print(vetorNumeros[i] + ", ");
		}

		System.out.println(vetorNumeros[tamanhoVetor - 1] + ".");
	}


	/*<--------------------------------------------------------------------------------------->*/
	
	
	public void countParImpar(){

		int par = 0, impar = 0;

		for (int i = 0; i < tamanhoVetor; i++){

			if (vetorNumeros[i] % 2 == 0){
				par ++;
			}
			else impar ++;
		}

		System.out.println("\nO vetor possui " + par + " numeros pares e " + impar + " numeros impares.");
	}


	/*<--------------------------------------------------------------------------------------->*/


}