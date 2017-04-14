package buscaVetores;

import custom.Objects.VetorInt;

public class BuscaSequencialSentinela extends Busca {

	private int[] vetorBusca;
	private int comparacoes = 0;


	/*<--------------------------------------------------------------------------------------->*/


	public BuscaSequencialSentinela(int tamanho){

		this.vetorBusca = VetorInt.preencherAleatorio(new int[tamanho + 1], 200);
	}

	public BuscaSequencialSentinela(int[] vetor){

		this.vetorBusca = VetorInt.extendVetor(vetor, 1);		
	}


	/*<--------------------------------------------------------------------------------------->*/


	public int search (int valor, int comeco, int posicaoFinal) {

		this.vetorBusca[vetorBusca.length -1] = valor;
		int i;		

		for (i = comeco, this.comparacoes = 1; this.vetorBusca[i] != valor && i < posicaoFinal; i++, comparacoes++);

		if (i < vetorBusca.length){
			return (i); /*Chave encontrada!*/
		}
		else return (-1); /*Sentinela encontrada.*/
	}


	public static int search (int[] vetor, int valor, int comeco, int posicaoFinal) {

		vetor = VetorInt.extendVetor(vetor, 1);
		vetor[vetor.length -1] = valor;

		int i = 0;		

		for (i = comeco; vetor[i] != valor && i < posicaoFinal; i++);

		if (i < vetor.length){
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
