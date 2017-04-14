package buscaVetores;

import custom.Objects.VetorInt;

public class BuscaSequencial extends Busca {

	private int[] vetorBusca;
	private int comparacoes = 0;


	/*<--------------------------------------------------------------------------------------->*/


	public BuscaSequencial(int tamanho){

		this.vetorBusca = VetorInt.preencherAleatorio(new int[tamanho], 200);
	}

	public BuscaSequencial(int[] vetor){

		this.vetorBusca = vetor;
	}


	/*<--------------------------------------------------------------------------------------->*/


	public int search (int valor, int comeco, int posicaoFinal) {

		for (int i = comeco; i < posicaoFinal; i++){

			this.comparacoes++;

			if (valor == this.vetorBusca[i]){
				return i;
			}
		}
		return -1;
	}


	public static int search (int[] vetor, int valor, int comeco, int posicaoFinal) {

		for (int i = comeco; i < posicaoFinal; i++){

			if (valor == vetor[i]){
				return i;
			}
		}
		return -1;
	}


	/*<--------------------------------------------------------------------------------------->*/


	public int getComparacoes(){

		return this.comparacoes;
	}

	public int[] getVetorBusca(){

		return this.getVetorBusca();
	}
}
