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


		System.out.println("Informe qual exercicio você deseja rodar:\n"
				+ "1  -> Calculo de somatórios\n"
				+ "2  -> Calculo de produtórios\n"
				+ "3  -> Vetor de numeros aleatorios\n"
				+ "4  -> Vetor numeros aleatorios alternados\n");

		int opcao = leituraOpcao(1, 4);
		escolherAtividade(opcao);
	}


	/*<--------------------------------------------------------------------------------------->*/


	public static void escolherAtividade (int opcao){

		switch (opcao){

		case 1: Exercicio01 exercicio01 = new Exercicio01(100000); exercicio01.printResultado(); break;

		case 2: Exercicio02 exercicio02 = new Exercicio02(1000000); exercicio02.printResultado(); break;

		case 3: Exercicio03 exercicio03 = new Exercicio03(10000); exercicio03.printResultado(); break;

		case 4: 

			double tempoInicial = System.currentTimeMillis();
			//int[] vetor = {1,2,3,4,5,6,7,8,9,10};
			//int[] vetor = {10,9,8,7,6,5,4,3,2,1};
			//OrdenacaoBolha bolha = new OrdenacaoBolha(vetor);

			OrdenacaoBolha bolha = new OrdenacaoBolha(10); 

			System.out.print("\nVetor aleatorio: ");
			bolha.getVetor().printVetor();  

			bolha.ordenarBolha(); 
			System.out.print("Vetor ordenado: ");
			bolha.getVetor().printVetor(); 

			System.out.printf("\nNumero de comparacoes: %d\nNumero de trocas: %d", bolha.comparacoes, bolha.trocas);
			System.out.println("\nDuracao da ordenacao: " + (System.currentTimeMillis() - tempoInicial) + " ms.");
			break;
		}
	}


	/*<--------------------------------------------------------------------------------------->*/


	public static int leituraOpcao(int min, int max) {

		int exercicio = 0;
		boolean repeate = true;

		while (repeate == true){

			try {

				System.out.print("Opcao: ");
				exercicio = entrada.nextInt();					

				if (exercicio < min || exercicio > max){
					throw new OutOfBoundsException();
				}

				repeate = false;
			} 
			catch (OutOfBoundsException e){}
			catch (InputMismatchException e){ System.out.println("Você inseriu um caractere invalido. Insira um exercício válido"); entrada.next();}
			catch(Exception e){ e.printStackTrace();}

		}

		return exercicio;
	}
}