package custom.Objects;

import java.security.SecureRandom;

public class VetorInt {

	private int tamanhoVetor = 0;
	private int[] vetorInteiros;

	public VetorInt(int tamanho){

		this.vetorInteiros = new int[tamanho];
		tamanhoVetor = tamanho;
		zerarVetor(vetorInteiros);		
	}

	public VetorInt(int[] vetor){

		this.vetorInteiros = vetor;
		tamanhoVetor = vetor.length;
		zerarVetor(vetorInteiros);			
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void printVetor(){

		for (int i = 0; i < tamanhoVetor - 1; i ++){

			System.out.print(vetorInteiros[i]+ ", ");
		}

		System.out.println(vetorInteiros[tamanhoVetor -1]);
	}



	public static void printVetor(int[] vetor){

		int tamanho = vetor.length;

		for (int i = 0; i < tamanho - 1; i ++){

			System.out.print(vetor[i]+ ", ");
		}

		System.out.println(vetor[tamanho -1]);
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void preencherAleatorio(int limite){

		SecureRandom aleatorio = new SecureRandom();

		for (int i = 0; i < tamanhoVetor; i++){

			vetorInteiros[i] = aleatorio.nextInt(limite);
		}
	}


	public static int[] preencherAleatorio(int[] vetor, int limite){

		int tamanho = vetor.length;
		SecureRandom aleatorio = new SecureRandom();

		for (int i = 0; i < tamanho; i++){

			vetor[i] = aleatorio.nextInt(limite);
		}

		return vetor;
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void zerarVetor(){

		for (int i = 0; i < tamanhoVetor; i++){

			vetorInteiros[i] = 0;
		}
	}

	public static int[] zerarVetor(int[] vetor){

		int tamanho = vetor.length;

		for (int i = 0; i < tamanho; i++){

			vetor[i] = 0;
		}

		return vetor;
	}


	/*<--------------------------------------------------------------------------------------->*/


	public static int[] extendVetor(int[] vetor, int aumentoTamanho){

		int[] novoVetor = new int[vetor.length + aumentoTamanho];

		for (int i = 0; i < vetor.length; i++){

			novoVetor[i] = vetor[i];
		}

		return novoVetor;
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void setValor(int i, int valor){

		this.vetorInteiros[i] = valor;
	}

	public int getValor(int i){

		return this.vetorInteiros[i];
	}

	public int getTamanhoVetor() {

		return tamanhoVetor;
	}

	public int[] getVetorInteiros(){

		return this.vetorInteiros;
	}

	public void setVetorInteiros(int[] vetor){

		this.vetorInteiros = vetor;
		this.tamanhoVetor = vetor.length;
	}
}
