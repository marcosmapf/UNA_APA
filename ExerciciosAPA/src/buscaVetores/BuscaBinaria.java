package buscaVetores;

import custom.Objects.VetorInt;
import ordenacaoVetores.OrdenacaoSelecao;

public class BuscaBinaria extends Busca {

	private int[] vetorBusca;
	private int comparacoes = 0;


	/*<--------------------------------------------------------------------------------------->*/


	public BuscaBinaria(int tamanho){

		this.vetorBusca = VetorInt.preencherAleatorio(new int[tamanho], 200);
		OrdenacaoSelecao.ordenar(vetorBusca);
	}

	public BuscaBinaria(int[] vetor){

		this.vetorBusca = vetor;
	}


	/*<--------------------------------------------------------------------------------------->*/


	public int search (int valor, int comeco, int posicaoFinal) {

		this.comparacoes = 0;
		int pivo = 0;		

		while (comeco <= posicaoFinal) {

			pivo = (comeco + posicaoFinal) / 2;
			this.comparacoes++;

			if (valor < this.vetorBusca[pivo]){

				posicaoFinal = pivo - 1;
			}
			else if (valor > this.vetorBusca[pivo]){

				comeco = pivo + 1;
			}
			else return pivo;
		}

		return -1;
	}


	public static int search (int[] vetor, int valor, int comeco, int posicaoFinal) {

		while (comeco <= posicaoFinal) {

			int pivo = (comeco + posicaoFinal) / 2;

			if (valor < vetor[pivo]){

				posicaoFinal = pivo - 1;
			}
			else if (valor > vetor[pivo]){

				comeco = pivo + 1;
			}
			else return pivo;
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
