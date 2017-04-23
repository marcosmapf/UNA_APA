package mainProgram;

import java.util.InputMismatchException;
import java.util.Scanner;

import buscaVetores.Busca;
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
			int posicaoS = sequencial.search(codigo, 0, tamanho);

			printResultado(sequencial, codigo, posicaoS, tempoInicial);
			break;

		case 2:

			BuscaSequencialSentinela sequencialSentinela = new BuscaSequencialSentinela(tamanho);
			int posicaoSS = sequencialSentinela.search(codigo, 0, tamanho - 1);

			printResultado(sequencialSentinela, codigo, posicaoSS, tempoInicial);
			break;

		case 3:

			BuscaBinaria binaria = new BuscaBinaria(tamanho);
			int posicaoB = binaria.search(codigo, 0 , tamanho - 1);

			printResultado(binaria, codigo, posicaoB, tempoInicial);
			break;
		}	
	}


	/*<--------------------------------------------------------------------------------------->*/


	public static int leituraOpcao(int min, int max) {

		int exercicio = 0;

		while (true){

			try {

				System.out.print("Opcao: ");
				exercicio = entrada.nextInt();					

				if (exercicio < min || exercicio > max){
					throw new OutOfBoundsException();
				}

				return exercicio;
			} 
			catch (OutOfBoundsException e){}
			catch (InputMismatchException e){ System.out.println("Você inseriu um caractere invalido. Insira um exercício válido"); entrada.next();}
			catch(Exception e){ e.printStackTrace();}
		}
	}


	/*<--------------------------------------------------------------------------------------->*/


	public static int leituraTamanho(){

		int tamanho = 0;

		while (true){
			try{

				System.out.print("Insira o tamanho do vetor a ser gerado: ");
				tamanho = entrada.nextInt();

				if (tamanho < 1 || tamanho > 13000){
					throw new OutOfBoundsException();
				}

				return tamanho;
			}
			catch(OutOfBoundsException e){}
			catch(InputMismatchException e){ System.out.println("Voce inseriu um caractere incorreto."); entrada.next();}
			catch(Exception e){ e.printStackTrace();}
		}
	}


	/*<--------------------------------------------------------------------------------------->*/


	public static int leituraCodigo(){

		int codigo = 0;

		while (true){

			try{

				System.out.print("Insira o codigo do cartao a ser procurado: ");
				codigo = entrada.nextInt();

				if (codigo < 1 || codigo > 20000){
					throw new OutOfBoundsException();
				}

				return codigo;
			}
			catch(OutOfBoundsException e){}
			catch(InputMismatchException e){ System.out.println("Voce inseriu um caractere incorreto."); entrada.next();}
			catch(Exception e){ e.printStackTrace();}
		}
	}


	/*<--------------------------------------------------------------------------------------->*/


	public static void printResultado(Busca busca, int codigo, int posicao, double tempoInicial){

		if (posicao == -1){

			System.out.println("O valor não foi encontrado no vetor\n");
		}
		else System.out.printf("O valor %d foi encontrado na posicao %d do vetor.\n", codigo, posicao);

		System.out.printf("\nNumero de comparações: %d", busca.getComparacoes());
		System.out.printf("\nTempo de operacao: %.0fms", (System.currentTimeMillis() - tempoInicial));
	}
}
