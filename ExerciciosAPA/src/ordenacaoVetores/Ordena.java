package ordenacaoVetores;

import java.security.SecureRandom;

public abstract class Ordena {

	private Item[] vetor;
	int tamanhoVetor = 0;

	
	/*<--------------------------------------------------------------------------------------->*/
	
	
	public void printVetor(){

		for (int i = 0; i < this.tamanhoVetor; i ++){

			System.out.print(this.vetor[i] + ", ");
		}
	}

	
	/*<--------------------------------------------------------------------------------------->*/
	
	
	private int[] preencherAleatorio(int[] vetor){

		SecureRandom aleatorio = new SecureRandom();

		for (int i = 0; i < this.tamanhoVetor; i++){

			Item numero = new Item(aleatorio.nextInt(1000));
			vetor[i] = numero.getChave();
		}

		return vetor;
	}
	

	/*<--------------------------------------------------------------------------------------->*/
	
	
	public Item[] getVetor() {
		return vetor;
	}

	public void setVetor(Item[] vetor) {
		this.vetor = vetor;
	}

	
	/*<--------------------------------------------------------------------------------------->*/
	
	
	public int getTamanhoVetor() {
		return tamanhoVetor;
	}

	public void setTamanhoVetor(int tamanhoVetor) {
		this.tamanhoVetor = tamanhoVetor;
	}

	
	/*<--------------------------------------------------------------------------------------->*/
}
