package mainProgram;

import buscaVetores.BuscaBinaria;
import buscaVetores.BuscaSequencial;
import buscaVetores.BuscaSequencialSentinela;

public class Lista05 {

	public static void main(String[] args) {

		int valor = 113;

		int tamanho = 10000;		
		//int[] vetor = new int[tamanho];
		//VetorInt.preencherAleatorio(vetor, 2000);

		int exercicio = 3;		
		switch(exercicio){

		case 1:

			BuscaSequencial sequencial = new BuscaSequencial(tamanho);			
			int posicaoS = sequencial.search(valor, 0, 9999);

			if (posicaoS == -1){

				System.out.println("O valor não foi encontrado no vetor\n");
			}
			else System.out.printf("O valor %d foi encontrado na posicao %d do vetor.\n", valor, posicaoS);

			System.out.printf("Numero de comparações: %d", sequencial.getComparacoes());
			break;

		case 2:

			BuscaSequencialSentinela sequencialSentinela = new BuscaSequencialSentinela(tamanho);
			int posicaoSS = sequencialSentinela.search(valor, 0);

			if (posicaoSS == -1){

				System.out.println("O valor não foi encontrado no vetor\n");
			}
			else System.out.printf("O valor %d foi encontrado na posicao %d do vetor.\n", valor, posicaoSS);

			System.out.printf("Numero de comparações: %d", sequencialSentinela.getComparacoes());
			break;

		case 3:

			BuscaBinaria binaria = new BuscaBinaria(tamanho);
			int posicaoB = binaria.search(valor, 0 , 9999);

			if (posicaoB == -1){

				System.out.println("O valor não foi encontrado no vetor\n");
			}
			else System.out.printf("O valor %d foi encontrado na posicao %d do vetor.\n", valor, posicaoB);

			System.out.printf("Numero de comparações: %d", binaria.getComparacoes());
			break;
		}
	}
}
