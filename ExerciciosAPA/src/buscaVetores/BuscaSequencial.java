package buscaVetores;

public class BuscaSequencial {

	private int[] vetorBusca;
	private int comparacoes = 0;


	/*<--------------------------------------------------------------------------------------->*/


	public BuscaSequencial(int[] vetor){

		this.vetorBusca = vetor;
	}


	/*<--------------------------------------------------------------------------------------->*/


	public int search (int v, int l, int r) {

		for (int i = l; i < r; i++){

			this.comparacoes++;
			
			if (v == this.vetorBusca[i]){
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
