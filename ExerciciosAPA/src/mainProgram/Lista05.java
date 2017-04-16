package mainProgram;

import java.util.InputMismatchException;
import java.util.Scanner;

import buscaVetores.BuscaBinaria;
import buscaVetores.BuscaSequencial;
import buscaVetores.BuscaSequencialSentinela;
import custom.Exceptions.OutOfBoundsException;

public class Lista05 {

	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Informe qual exercicio você deseja rodar:\n"
				+ "1  -> Busca Sequencial\n"
				+ "2  -> Busca Sequencial com sentinela\n"
				+ "3  -> Busca Binaria\n");

		int opcao = leituraOpcao(1, 3);
		escolherAtividade(opcao);	
	}


	/*<--------------------------------------------------------------------------------------->*/

	
	public static void escolherAtividade (int opcao){

		//int[] vetor = new int[tamanho];
		//VetorInt.preencherAleatorio(vetor, 2000);

		int tamanho = leituraTamanho();
		int codigo = leituraCodigo();

		double tempoInicial = System.currentTimeMillis();

		switch (opcao){
		case 1:

			BuscaSequencial sequencial = new BuscaSequencial(tamanho);			
			int posicaoS = sequencial.search(codigo, 0, tamanho - 1);

			if (posicaoS == -1){

				System.out.println("O valor não foi encontrado no vetor\n");
			}
			else System.out.printf("O valor %d foi encontrado na posicao %d do vetor.\n", codigo, posicaoS);

			System.out.printf("\nNumero de comparações: %d", sequencial.getComparacoes());
			System.out.printf("\nTempo de operacao: %.0fms", (System.currentTimeMillis() - tempoInicial));
			break;

		case 2:

			BuscaSequencialSentinela sequencialSentinela = new BuscaSequencialSentinela(tamanho);
			int posicaoSS = sequencialSentinela.search(codigo, 0, tamanho - 1);

			if (posicaoSS == -1){

				System.out.println("O valor não foi encontrado no vetor\n");
			}
			else System.out.printf("O valor %d foi encontrado na posicao %d do vetor.\n", codigo, posicaoSS);

			System.out.printf("\nNumero de comparações: %d", sequencialSentinela.getComparacoes());
			System.out.printf("\nTempo de operacao: %.0fms", (System.currentTimeMillis() - tempoInicial));
			break;

		case 3:

			BuscaBinaria binaria = new BuscaBinaria(tamanho);
			int posicaoB = binaria.search(codigo, 0 , tamanho - 1);

			if (posicaoB == -1){

				System.out.println("O valor não foi encontrado no vetor\n");
			}
			else System.out.printf("O valor %d foi encontrado na posicao %d do vetor.\n", codigo, posicaoB);

			System.out.printf("\nNumero de comparações: %d", binaria.getComparacoes());
			System.out.printf("\nTempo de operacao: %.0fms", (System.currentTimeMillis() - tempoInicial));
			break;
		}	
	}


	/*<--------------------------------------------------------------------------------------->*/


	public static int leituraOpcao(int min, int max) {

		int exercicio = 0;
		boolean repetir = true;

		while (repetir == true){

			try {

				System.out.print("Opcao: ");
				exercicio = entrada.nextInt();					

				if (exercicio < min || exercicio > max){
					throw new OutOfBoundsException();
				}

				repetir = false;
			} 
			catch (OutOfBoundsException e){}
			catch (InputMismatchException e){ System.out.println("Você inseriu um caractere invalido. Insira um exercício válido"); entrada.next();}
			catch(Exception e){ e.printStackTrace();}

		}

		return exercicio;
	}


	/*<--------------------------------------------------------------------------------------->*/


	public static int leituraTamanho(){

		int tamanho = 0;
		boolean repetir = true;

		while (repetir == true){
			try{

				System.out.print("\nInsira o tamanho do vetor a ser gerado: ");
				tamanho = entrada.nextInt();

				if (tamanho < 1 || tamanho > 13000){
					throw new OutOfBoundsException();
				}

				repetir = false;
			}
			catch(OutOfBoundsException e){}
			catch(InputMismatchException e){ System.out.println("Voce inseriu um caractere incorreto."); entrada.next();}
			catch(Exception e){ e.printStackTrace();}
		}

		return tamanho;
	}


	/*<--------------------------------------------------------------------------------------->*/


	public static int leituraCodigo(){

		int codigo = 0;
		boolean repetir = true;

		while (repetir == true){

			try{

				System.out.print("\nInsira o codigo do cartao a ser procurado: ");
				codigo = entrada.nextInt();

				if (codigo < 1 || codigo > 20000){
					throw new OutOfBoundsException();
				}
				
				repetir = false;
			}
			catch(OutOfBoundsException e){}
			catch(InputMismatchException e){ System.out.println("Voce inseriu um caractere incorreto."); entrada.next();}
			catch(Exception e){ e.printStackTrace();}
		}

		return codigo;
	}
}
