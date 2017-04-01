package custom.Objects;

import java.security.SecureRandom;

public class VetorItems {

	int tamanhoVetor = 0;
	Item[] vetorItems;

	public VetorItems(int tamanho){

		this.vetorItems = new Item[tamanho];
		tamanhoVetor = tamanho;
		zerarVetor(vetorItems);		
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void printVetor(){

		for (int i = 0; i < tamanhoVetor - 1; i ++){

			System.out.print(vetorItems[i].getChave() + ", ");
		}

		System.out.println(vetorItems[tamanhoVetor].getChave());
	}



	public static void printVetor(int[] vetor){

		int tamanho = vetor.length;

		for (int i = 0; i < tamanho - 1; i ++){

			System.out.print(vetor[i]+ ", ");
		}

		System.out.println(vetor[tamanho]);
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void preencherAleatorio(){

		SecureRandom aleatorio = new SecureRandom();

		for (int i = 0; i < tamanhoVetor; i++){

			vetorItems[i].setChave(aleatorio.nextInt(1000));
		}
	}


	public static int[] preencherAleatorio(int[] vetor){

		int tamanho = vetor.length;
		SecureRandom aleatorio = new SecureRandom();

		for (int i = 0; i < tamanho; i++){

			vetor[i] = aleatorio.nextInt(1000);
		}

		return vetor;
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void zerarVetor(){

		for (int i = 0; i < tamanhoVetor; i++){

			vetorItems[i].setChave(0);
		}
	}

	public static Item[] zerarVetor(Item[] vetor){

		int tamanho = vetor.length;

		for (int i = 0; i < tamanho; i++){

			vetor[i].setChave(0);
		}

		return vetor;
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void adicionarValor(int i, int valor){

		this.vetorItems[i].setChave(valor);
	}
}
