package ordenacaoVetores;

import custom.Objects.VetorItems;

public abstract class Ordena {

	protected VetorItems vetorOrdena;
	int tamanhoVetor = 0;

	public int comparacoes = 0;
	public int trocas = 0;


	/*<--------------------------------------------------------------------------------------->*/


	public VetorItems getVetor() {
		return vetorOrdena;
	}


	/*<--------------------------------------------------------------------------------------->*/

}
