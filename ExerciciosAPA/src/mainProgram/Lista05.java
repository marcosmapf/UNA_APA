package mainProgram;

import buscaVetores.BuscaBinaria;
import buscaVetores.BuscaSequencial;
import buscaVetores.BuscaSequencialSentinela;
import custom.Objects.VetorInt;

public class Lista05 {

	public static void main(String[] args) {

		int v = 113;	
		int[] vetorAleatorio = new int[10000];			
		VetorInt.preencherAleatorio(vetorAleatorio, 2000);

		int exercicio = 2;		
		switch(exercicio){

		case 1:
			BuscaSequencial sequencial = new BuscaSequencial(vetorAleatorio);

			int posicaoS = sequencial.search(v, 0 , vetorAleatorio.length);

			if (posicaoS == -1){

				System.out.println("O valor não foi encontrado no vetor\n");
			}
			else System.out.printf("O valor %d foi encontrado na posicao %d do vetor.\n", v, posicaoS);

			System.out.printf("Numero de comparações: %d", sequencial.getComparacoes());
			break;

		case 2:

			BuscaSequencialSentinela sequencialSentinela = new BuscaSequencialSentinela(vetorAleatorio);

			int posicaoSS = sequencialSentinela.search(v, 0 , vetorAleatorio.length);

			if (posicaoSS == -1){

				System.out.println("O valor não foi encontrado no vetor\n");
			}
			else System.out.printf("O valor %d foi encontrado na posicao %d do vetor.\n", v, posicaoSS);

			System.out.printf("Numero de comparações: %d", sequencialSentinela.getComparacoes());
			break;

		case 3:

			BuscaBinaria binaria = new BuscaBinaria(vetorAleatorio);

			int posicaoB = binaria.search(v, 0 , vetorAleatorio.length);

			if (posicaoB == -1){

				System.out.println("O valor não foi encontrado no vetor\n");
			}
			else System.out.printf("O valor %d foi encontrado na posicao %d do vetor.\n", v, posicaoB);

			System.out.printf("Numero de comparações: %d", binaria.getComparacoes());
			break;
		}
	}
}
