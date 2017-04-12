package buscaVetores;

public class BuscaBinaria {

	private int[] vetorBusca;
	private int comparacoes = 0;


	/*<--------------------------------------------------------------------------------------->*/


	public BuscaBinaria(int[] vetor){

		this.vetorBusca = vetor;
	}


	/*<--------------------------------------------------------------------------------------->*/


	public int search (int v, int l, int r) {

		while (l <= r) {

			int m = (l + r) / 2;

			if (v == this.vetorBusca[m]){

				return m;
			}
			else if (v < this.vetorBusca[m]){

				r = m - 1;
			}
			else l = m + 1;
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
