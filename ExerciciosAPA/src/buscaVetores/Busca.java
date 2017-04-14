package buscaVetores;

public abstract class Busca {
	
	int[] vetorBusca;
	int comparacoes = 0;	
	
	/*<--------------------------------------------------------------------------------------->*/

	
	public int getComparacoes(){
		
		return this.comparacoes;
	}
	
	public int[] getVetorBusca(){
		
		return this.vetorBusca;
	}
	
	public void setVetorBusca(int[] vetor){
		
		this.vetorBusca = vetor;
	}
}
