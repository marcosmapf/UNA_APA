package ordenacaoVetores;

import custom.Objects.VetorItems;

public abstract class Ordena {

	protected VetorItems vetorOrdena;

	public int comparacoes = 0;
	public int trocas = 0;


	/*<--------------------------------------------------------------------------------------->*/


	public VetorItems getVetor() {
		return vetorOrdena;
	}


	/*<--------------------------------------------------------------------------------------->*/

}
