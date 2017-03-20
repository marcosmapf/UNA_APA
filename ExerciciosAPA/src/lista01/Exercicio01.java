package lista01;

import java.util.InputMismatchException;
import java.util.Scanner;

import customExceptions.OutOfBoundsException;

public class Exercicio01 {

	/* Escreva um algoritmo que leia um limite natural n a partir do teclado e que calcule os
somatórios abaixo. O algoritmo deve imprimir cada termo e os resultados dos
somatórios. 
	 */

	static Scanner entrada = new Scanner(System.in);
	private int limite;
	

	public Exercicio01(){

		int numero = leituraLimite();
		this.limite = numero;
	}

	public void somatorioA(){

		int soma = 0;

		for (int i = 0; i <= this.limite; i++){

			soma += i;
			System.out.println("Etapa: " + (i) + " Soma: " + soma);
		}
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void somatorioB (){

		int soma = 0;

		for (int i = 0; i <= this.limite; i++){

			soma += i + 5;
			System.out.println("Etapa: " + (i) + " Soma: " + soma);
		}
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void somatorioC (){

		double soma = 0;

		for (int i = 2; i <= this.limite; i++){

			soma += (Math.pow(i-3, 2)) / (i-1);
			System.out.printf("\nEtapa: %d   Soma: %.2f", (i-2), soma);

		}
	}


	/*<--------------------------------------------------------------------------------------->*/


	public int leituraLimite(){

		int limite = 0;

		try{

			System.out.print("\nInsira o limite natural do somatorio: ");
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