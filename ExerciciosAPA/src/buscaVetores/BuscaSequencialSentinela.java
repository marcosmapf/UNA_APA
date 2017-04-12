package buscaVetores;

public class BuscaSequencialSentinela {

	private int[] vetorBusca;
	private int comparacoes = 0;


	/*<--------------------------------------------------------------------------------------->*/


	public BuscaSequencialSentinela(int[] vetor){

		int[] novoVetor = new int[vetor.length + 1];
		this.vetorBusca = novoVetor;
	}


	/*<--------------------------------------------------------------------------------------->*/


	public int search (int v, int l, int r) {

		int i, n = r;
		this.vetorBusca[n] = v;

		for (i = l; v != this.vetorBusca[i] && v < this.vetorBusca.length; i++);

		if (i < n){
			return (i); /*Chave encontrada!*/
		}
		else return (-1); /*Sentinela encontrada.*/
	}


	/*<--------------------------------------------------------------------------------------->*/


	public int getComparacoes(){

		return this.comparacoes;
	}

	public int[] getVetorBusca(){

		return this.getVetorBusca();
	}
}
