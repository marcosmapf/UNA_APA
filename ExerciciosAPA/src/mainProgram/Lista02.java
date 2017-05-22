package mainProgram;

import java.util.InputMismatchException;
import java.util.Scanner;

import custom.Exceptions.OutOfBoundsException;
import lista02.Exercicio01.Exercicio01;
import lista02.Exercicio02.Exercicio02;
import lista02.Exercicio03.Exercicio03;
import ordenacaoVetores.OrdenacaoBolha;

public class Lista02 {

	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {

		while (true){
			
			System.out.println("Informe qual exercicio você deseja rodar:\n"
					+ "1  -> Preenchendo 5 posicoes de um vetor de N espacos\n"
					+ "2  -> Preenchendo N posicoes de vetor de N espacos\n"
					+ "3  -> Preenchendo NxN posicoes de uma matriz de NxN espacos\n"
					+ "4  -> Ordenação de Algoritmos pelo método Bolha\n");

			int opcao = leituraOpcao(1, 4);
			escolherAtividade(opcao);
		}
	}


	/*<--------------------------------------------------------------------------------------->*/


	public static void escolherAtividade (int opcao){

		int tamanho = requisitarTamanho();

		switch (opcao){

		case 1: Exercicio01 complexidadeConstante = new Exercicio01(tamanho); complexidadeConstante.preencherVetor(); complexidadeConstante.printResultado(); break;

		case 2: Exercicio02 complexidadeLinear = new Exercicio02(tamanho); complexidadeLinear.preencherVetor(); complexidadeLinear.printResultado(); break;

		case 3: Exercicio03 complexidadeQuadratica = new Exercicio03(tamanho); complexidadeQuadratica.preencherMatriz(); complexidadeQuadratica.printResultado(); break;

		case 4: 

			double tempoInicial = System.currentTimeMillis();
			//int[] vetor = {1,2,3,4,5,6,7,8,9,10};
			//int[] vetor = {10,9,8,7,6,5,4,3,2,1};
			//OrdenacaoBolha bolha = new OrdenacaoBolha(vetor);

			OrdenacaoBolha bolha = new OrdenacaoBolha(tamanho);
			bolha.getVetor().preencherAleatorio(1000);

			System.out.print("\nVetor aleatorio: ");
			bolha.getVetor().printVetor();  

			bolha.ordenar(); 
			System.out.print("Vetor ordenado: ");
			bolha.getVetor().printVetor(); 

			System.out.printf("\nNumero de comparacoes: %d\nNumero de trocas: %d", bolha.getComparacoes(), bolha.getTrocas());
			System.out.println("\nDuracao da ordenacao: " + (System.currentTimeMillis() - tempoInicial) + " ms.");
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


	public static int requisitarTamanho(){

		int tamanho = 0;

		while (true){

			try {

				System.out.print("Informe o tamanho do vetor: ");
				tamanho = entrada.nextInt();

				if (tamanho < 5 || tamanho > 13000){
					throw new OutOfBoundsException();
				}

				return tamanho;
			} 
			catch (OutOfBoundsException e){}
			catch (InputMismatchException e){ System.out.println("Você inseriu um caractere invalido. Insira um exercício válido"); entrada.next();}
			catch(Exception e){ e.printStackTrace();}
		}
	}
}