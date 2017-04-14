package ordenacaoVetores;

import custom.Objects.VetorItems;

public abstract class Ordena {

	protected VetorItems vetorOrdena;

	protected int comparacoes = 0;
	protected int trocas = 0;


	/*<--------------------------------------------------------------------------------------->*/

	
	public VetorItems getVetor() {
		
		return vetorOrdena;
	}
	
	public int getComparacoes() {
		return comparacoes;
	}

	public int getTrocas() {
		
		return trocas;
	}
	

	/*<--------------------------------------------------------------------------------------->*/

}
