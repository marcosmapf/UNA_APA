package lista01;

import java.util.InputMismatchException;
import java.util.Scanner;

import customExceptions.OutOfBoundsException;

public class Exercicio10 {

	/* Escreva um algoritmo para venda de ingressos em uma sala de cinema. A sala de cinema deve ser representada 
	 * como uma matriz 10 x 10 de inteiros. O algoritmo deve: 
	 * a) Possuir um método para iniciar a matriz com o valor 0 que indica lugares vazios. 
	 * b) Possuir um método para venda de lugares na sala, marcando o assento vendido com o valor 1. 
	 * c) Possuir um método que imprima a matriz. 
	 * d) Possuir um método que receba o valor do ingresso como parâmetro e retorne o total apurado numa seção.
	 */

	int[][] secaoCinema;
	int tamanhoSala;
	private Scanner entrada = new Scanner(System.in);

	public Exercicio10(){

		int[][] matriz = new int[10][10];
		setSecaoCinema(matrixFill(matriz));
		tamanhoSala = matriz.length;
	}

	/*<--------------------------------------------------------------------------------------->*/


	private int[][] matrixFill(int[][] matriz){

		for (int i = 0; i < matriz.length; i++){
			for (int j = 0; j < matriz[0].length; j++){

				matriz[i][j] = 0;
			}
		}
		return matriz;
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void novaCompra(){

		int fileira = 0, assento = 0;
		int repeat = 1;

		while (repeat == 1){

			boolean available = false;

			while (available == false){

				System.out.print("\nInsira a fileira (de 1 a " + tamanhoSala + ") que deseja sentar");
				fileira = requestSeat(tamanhoSala) -1;

				System.out.print("\nAssentos livres na fileira: ");
				available = verifyAvailability(fileira);
			}

			System.out.print("\nInsira o assento (de 1 a " + tamanhoSala + ")");
			assento = requestSeat(tamanhoSala) -1;

			if (secaoCinema[fileira][assento] == 1){

				System.out.println("Este assento esta ocupado. Por favor, escolha novamente.\n");
			}
			else {
				secaoCinema[fileira][assento] = 1;
				System.out.print("\nSeu assento foi reservado na fileira " + (fileira+1) + ", assento " + (assento+1));

				repeat = requestNewBuy();
			}
		}
	}


	/*<--------------------------------------------------------------------------------------->*/


	private int requestSeat(int tamanhoSala){

		boolean repeticao = true;
		int escolha = 0;

		do{
			try{

				System.out.print("\nOpcao: ");
				escolha = entrada.nextInt();

				if (escolha < 1 || escolha > 10){
					throw new OutOfBoundsException();
				}

				repeticao = false;

			}
			catch (OutOfBoundsException e){}
			catch (InputMismatchException e){ System.out.println("Você inseriu um caractere invalido, tente novamente"); entrada.next();}
			catch(Exception e){ e.printStackTrace();}

		}
		while (repeticao == true);
		return escolha;
	}


	/*<--------------------------------------------------------------------------------------->*/


	private boolean verifyAvailability(int row){

		int[][] sala = getSecaoCinema();
		int assentosLivres = 0;

		for (int i = 0; i < sala.length; i++){

			if (sala[row][i] == 0){

				assentosLivres += 1;
				System.out.print(i+1 + ", ");
			}
		}

		if (assentosLivres == 0){
			System.out.print("Nenhum. Por favor, verifique a disponibilidade em outra fileira");
			return false;
		}
		else {return true;}

		//return assentosLivres == 0? false : true;
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void printMatrix(){

		System.out.println("**Sala de cinema**\n\n");

		for (int i = 0; i < tamanhoSala; i++){
			for (int j = 0; j < tamanhoSala; j++){

				System.out.print(this.secaoCinema[i][j] + " ");
			}

			System.out.println();
		}
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void totalTicket(){

		double ticket = ticketValue();
		double total = 0;

		for (int i = 0; i < tamanhoSala; i++){
			for (int j = 0; j < tamanhoSala; j++){

				if (secaoCinema[i][j] == 1){
					total += ticket;
				}
			}
		}

		System.out.println("O ticket total da secao foi: " + total);
	}

	private double ticketValue(){

		boolean repeat = true;
		double ticket = 0;

		while (repeat == true){

			try{

				System.out.print("\nInsira o valor do ingresso: ");
				ticket = entrada.nextDouble();

				if (ticket < 0){

					throw new OutOfBoundsException();
				}

				repeat = false;
			}
			catch(OutOfBoundsException e){}
			catch(InputMismatchException e){System.out.println("Você inseriu um caractere invalido, tente novamente"); entrada.next();}
			catch(Exception e){ e.printStackTrace();}
		}

		return ticket;
	}


	/*<--------------------------------------------------------------------------------------->*/


	private int requestNewBuy(){

		int repeat = 0;

		while (true){

			try{

				System.out.print("\nDigite 1 para fazer uma nova compra ou 0 para terminar a secao: ");
				repeat = entrada.nextInt();

				if (repeat < 0 || repeat > 1){

					throw new OutOfBoundsException();
				}

				return repeat;
			}
			catch (OutOfBoundsException e){}
			catch (InputMismatchException e){System.out.println("Caractere invalido, tente novamente."); entrada.next();}
			catch (Exception e){}

		}
	}


	/*<--------------------------------------------------------------------------------------->*/



	public int[][] getSecaoCinema() {
		return secaoCinema;
	}

	public void setSecaoCinema(int[][] salaCinema) {
		this.secaoCinema = salaCinema;
	}
}
