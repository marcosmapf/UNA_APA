package lista01.Exercicio02;

import java.util.InputMismatchException;
import java.util.Scanner;

import custom.Exceptions.OutOfBoundsException;

public class Produtorios {

	/*Escreva um algoritmo que leia um limite natural n a partir do teclado e que calcule os
	 * produtórios abaixo. O algoritmo deve imprimir cada termo e os resultados dos
	 * produtórios.
	 */

	static Scanner entrada = new Scanner(System.in);
	private int limite;


	public Produtorios(){

		this.limite = leituraLimite();
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void produtorioA(){

		int produto = 1;

		for (int i = 1; i <= this.limite; i++){

			produto *= i;
			System.out.println("Etapa: " + (i-1) + " Produto: " + produto + "\n");
		}
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void produtorioB(){

		int produto = 1;

		for (int i = 0; i <= this.limite; i++){

			produto *= i + 12;
			System.out.println("Etapa: " + (i) + " Produto: " + produto + "\n");
		}
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void produtorioC(){

		int produto = 1;

		for (int i = 3; i <= this.limite; i++){

			produto *= ((i/3)^4 / (i-2));
			System.out.println("Etapa: " + (i-3) + " Produto: " + produto + "\n");
		}
	}

	
	/*<--------------------------------------------------------------------------------------->*/
	
	
	public int leituraLimite(){

		int limite = 0;

		try{

			System.out.print("\nInsira o limite natural do produtorio: ");
			limite = entrada.nextInt();

			if (limite < 1 || limite > 10000){
				throw new OutOfBoundsException();
			}
		}
		catch(OutOfBoundsException e){}
		catch(InputMismatchException e){ System.out.println("Voce inseriu um caractere incorreto."); entrada.next();}
		catch(Exception e){ e.printStackTrace();}


		return limite;
	}
}