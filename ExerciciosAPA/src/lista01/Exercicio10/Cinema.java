package lista01.Exercicio10;

import java.util.InputMismatchException;
import java.util.Scanner;

import custom.Exceptions.OutOfBoundsException;
import custom.Objects.MatrizInt;

public class Cinema {

	/* Escreva um algoritmo para venda de ingressos em uma sala de cinema. A sala de cinema deve ser representada 
	 * como uma matriz 10 x 10 de inteiros. O algoritmo deve: 
	 * a) Possuir um método para iniciar a matriz com o valor 0 que indica lugares vazios. 
	 * b) Possuir um método para venda de lugares na sala, marcando o assento vendido com o valor 1. 
	 * c) Possuir um método que imprima a matriz. 
	 * d) Possuir um método que receba o valor do ingresso como parâmetro e retorne o total apurado numa seção.
	 */

	private Scanner entrada = new Scanner(System.in);
	MatrizInt secaoCinema;

	public Cinema(int tamanho){

		this.secaoCinema = new MatrizInt(tamanho);
	}


	public Cinema(int[][] matriz){

		this.secaoCinema = new MatrizInt(matriz);
	}

	/*<--------------------------------------------------------------------------------------->*/


	public void novaCompra(){

		int fileira = 0, assento = 0;
		int repeat = 1;

		while (repeat == 1){

			boolean available = false;

			while (available == false){

				System.out.print("\nInsira a fileira (de 1 a " + secaoCinema.getTamanhoMatriz() + ") que deseja sentar");
				fileira = requererAssento(secaoCinema.getTamanhoMatriz()) -1;

				System.out.print("\nAssentos livres na fileira: ");
				available = verificarDisponibilidade(fileira);
			}

			System.out.print("\nInsira o assento (de 1 a " + secaoCinema.getTamanhoMatriz() + ")");
			assento = requererAssento(secaoCinema.getTamanhoMatriz()) -1;

			if (secaoCinema.getValor(fileira, assento) == 1){

				System.out.println("Este assento esta ocupado. Por favor, escolha novamente.\n");
			}
			else {
				secaoCinema.setValor(fileira, assento, 1);
				System.out.print("\nSeu assento foi reservado na fileira " + (fileira +1) + ", assento " + (assento+ 1));

				repeat = requererNovaCompra();
			}
		}
	}


	/*<--------------------------------------------------------------------------------------->*/


	private int requererAssento(int tamanhoSala){

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


	private boolean verificarDisponibilidade(int fileira){

		int assentosLivres = 0;

		for (int i = 0; i < secaoCinema.getTamanhoMatriz(); i++){

			if (secaoCinema.getValor(fileira, i) == 0){

				assentosLivres += 1;
				System.out.print(i + 1 + ", ");
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


	public void totalTicket(){

		double ticket = valorTicket();
		double total = 0;

		for (int i = 0; i < secaoCinema.getTamanhoMatriz(); i++){
			for (int j = 0; j < secaoCinema.getTamanhoMatriz(); j++){

				if (secaoCinema.getValor(i, j) == 1){
					total += ticket;
				}
			}
		}

		System.out.println("O ticket total da secao foi: " + total);
	}


	/*<--------------------------------------------------------------------------------------->*/


	private double valorTicket(){

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


	private int requererNovaCompra(){

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


	public MatrizInt getSecao() {
		
		return this.secaoCinema;
	}

	/*<--------------------------------------------------------------------------------------->*/

}
