package lista02;

import java.util.InputMismatchException;
import java.util.Scanner;
import customExceptions.OutOfBoundsException;

public class Main {

	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Informe qual exercicio você deseja rodar:\n"
				+ "1  -> Calculo de somatórios\n"
				+ "2  -> Calculo de produtórios\n"
				+ "3  -> Vetor de numeros aleatorios\n"
				+ "4  -> Vetor numeros aleatorios alternados\n"
				+ "5  -> Elementos pares e impares em vetor\n"
				+ "6  -> Diagonal Principal e Secundária de matriz aleatória\n"
				+ "7  -> Matriz transposta de uma matriz aleatória\n"
				+ "8  -> Somar elementos abaixo da diagonal principal de uma matriz aleatória\n"
				+ "9  -> Multiplicação de matrizes aleatórias\n"
				+ "10 -> Venda de ingressos em sala de cinema\n"
				+ "11 -> Distance entre estradas de cidades vizinhas\n");

		int opcao = leituraOpcao(1, 11);
		escolherAtividade(opcao);
	}


	/*<--------------------------------------------------------------------------------------->*/


	public static void escolherAtividade (int opcao){

		switch (opcao){

		case 1: 

			Exercicio01 cincoAleatorios1 = new Exercicio01(10);
			Exercicio01 cincoAleatorios2 = new Exercicio01(100);
			Exercicio01 cincoAleatorios3 = new Exercicio01(1000);
			Exercicio01 cincoAleatorios4 = new Exercicio01(10000);
			Exercicio01 cincoAleatorios5 = new Exercicio01(100000);
			Exercicio01 cincoAleatorios6 = new Exercicio01(1000000);
			break;

		case 2:

			Exercicio02 vetorAleatorios1 = new Exercicio02(10);
			Exercicio02 vetorAleatorios2 = new Exercicio02(100);
			Exercicio02 vetorAleatorios3 = new Exercicio02(1000);
			Exercicio02 vetorAleatorios4 = new Exercicio02(10000);
			Exercicio02 vetorAleatorios5 = new Exercicio02(100000);
			Exercicio02 vetorAleatorios6 = new Exercicio02(1000000);
			break;


		case 3: 

			Exercicio03 matrizAleatoria01 = new Exercicio03(68);
			Exercicio03 matrizAleatoria02 = new Exercicio03(100);
			Exercicio03 matrizAleatoria03 = new Exercicio03(1000);
			Exercicio03 matrizAleatoria04 = new Exercicio03(10000);
			Exercicio03 matrizAleatoria05 = new Exercicio03(100000);
			Exercicio03 matrizAleatoria06 = new Exercicio03(1000000);
			break;
		}
	}

		/*
		case 4: Exercicio04 vetorTroca = new Exercicio04(); vetorTroca.flipFlop(); break;

		case 5: Exercicio05 vetorParImpar = new Exercicio05(); vetorParImpar.countParImpar(); break;

		case 6: Exercicio06 vetorDiags = new Exercicio06(); vetorDiags.mainDiag(); vetorDiags.secDiag(); break;

		case 7: Exercicio07 matrizTransposta = new Exercicio07(); matrizTransposta.transposedMatrix(); break;

		case 8: Exercicio08 abaixoDiag = new Exercicio08(); abaixoDiag.printMatrix(); abaixoDiag.somaElementos(); break;

		case 9: Exercicio09 multiplicacaoMatriz = new Exercicio09(); multiplicacaoMatriz.prodMatrix(); break;

		case 10: Exercicio10 salaCinema = new Exercicio10(); salaCinema.novaCompra(); salaCinema.printMatrix(); salaCinema.totalTicket(); break;

		case 11: Exercicio11 estradaCidades = new Exercicio11(); estradaCidades.printMatrix(); estradaCidades.checkDistance(3, 4); break;
		}

		 */


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