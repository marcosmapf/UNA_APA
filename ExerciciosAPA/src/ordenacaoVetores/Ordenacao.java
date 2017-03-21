package ordenacaoVetores;

import java.security.SecureRandom;

public class Ordenacao {

	private int[] vetor;
	int tamanhoVetor = 0;

	public void printVetor(){

		for (int i = 0; i < this.tamanhoVetor; i ++){

			System.out.print(this.vetor[i] + ", ");
		}

	}
}