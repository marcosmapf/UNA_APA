package custom.Objects;

import java.security.SecureRandom;

public class VetorItems {

	int tamanhoVetor = 0;
	private Item[] vetorItems;

	public VetorItems(int tamanho){

		this.vetorItems = new Item[tamanho];
		tamanhoVetor = tamanho;
		zerarVetor(vetorItems);
	}


	public VetorItems(int[] vetor){

		tamanhoVetor = vetor.length;
		vetorItems = new Item[tamanhoVetor];

		for (int i = 0; i < tamanhoVetor; i++){

			vetorItems[i] = new Item(vetor[i]);
		}
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void printVetor(){

		for (int i = 0; i < tamanhoVetor - 1; i ++){

			System.out.print(vetorItems[i].getChave() + ", ");
		}

		System.out.println(vetorItems[tamanhoVetor -1].getChave());
	}



	public static void printVetor(Item[] vetor){

		for (int i = 0; i < vetor.length - 1; i ++){

			System.out.print(vetor[i].getChave()+ ", ");
		}

		System.out.println(vetor[vetor.length - 1].getChave());
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void preencherAleatorio(int limite){

		SecureRandom aleatorio = new SecureRandom();

		for (int i = 0; i < tamanhoVetor; i++){

			vetorItems[i].setChave(aleatorio.nextInt(limite));
		}
	}


	public static Item[] preencherAleatorio(Item[] vetor, int limite){

		int tamanho = vetor.length;
		SecureRandom aleatorio = new SecureRandom();

		for (int i = 0; i < tamanho; i++){

			vetor[i] = new Item(aleatorio.nextInt(limite));
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

			vetor[i] = new Item(0);
		}

		return vetor;
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void setChaveOfItem(int i, int valor){

		this.vetorItems[i].setChave(valor);
	}

	public int getChaveOfItem(int i){

		return this.vetorItems[i].getChave();
	}

	public Item getItem(int i){

		return this.vetorItems[i];
	}

	public void setItem(int i, Item item){

		this.vetorItems[i] = item;
	}

	public int getTamanhoVetor() {
		
		return tamanhoVetor;
	}
}
