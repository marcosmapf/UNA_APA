package lista01.Exercicio11;

import java.util.InputMismatchException;
import java.util.Scanner;

import custom.Exceptions.OutOfBoundsException;

public class Cidades {

	/*11) Escreva um algoritmo que armazene em uma matriz a distância das estradas que ligam 4
	 * cidades vizinhas. O algoritmo deve:
	 * a) Possuir um método para inserir a distância entre duas cidades na matriz.
	 * b) Possuir um método para contar quantas estradas ligam as cidades.
	 * c) Possuir um método para imprimir a matriz.
	 * d) Possuir um método que receba a identificação de duas cidades adjacentes como
	 * parâmetro e:
	 * i. Retornar a distância entre as cidades, se houver uma estrada entre elas.
	 * ii. Retornar zero, se não houver uma estrada ligando as duas cidades.
	 * */

	static Scanner entrada = new Scanner(System.in);
	private double[][] matrizEstradas;

	public Cidades(int tamanho){

		this.matrizEstradas = new double[tamanho][tamanho];
		this.preencherMatriz();
	}

	public Cidades (double[][] matriz){

		this.matrizEstradas = matriz;
	}


	/*<--------------------------------------------------------------------------------------->*/


	private void preencherMatriz(){

		for (int i = 0; i < matrizEstradas.length; i++){
			for (int j = i + 1; j < matrizEstradas.length; j++){

				System.out.print("Insira a distancia entra as cidades " + (i+1) + " e " + (j+1) + ": ");
				this.matrizEstradas[i][j] = lerDistancia();
				this.matrizEstradas[j][i] = this.matrizEstradas[i][j];
			}
		}
	}


	/*<--------------------------------------------------------------------------------------->*/


	private double lerDistancia(){

		double distancia = 0;
		boolean repeat = true;

		while (repeat == true){

			try{

				distancia = entrada.nextDouble();

				if (distancia < 0){

					throw new OutOfBoundsException();
				}

				repeat = false;
			}
			catch(OutOfBoundsException e){}
			catch(InputMismatchException e){System.out.println("Você inseriu um caractere invalido, tente novamente"); entrada.next();}
			catch(Exception e){ e.printStackTrace();}
		}

		return distancia;
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void contarEstradas(){

		int roadCount = 0;

		for (int i = 0; i < this.matrizEstradas.length; i ++){
			for (int j = i + 1; j < this.matrizEstradas.length; j++){

				if (this.matrizEstradas[i][j] > 0) { 

					roadCount += 1;
				}
			}
		}

		System.out.println("\nExistem + " + roadCount + " estradas entre as cidades.");
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void printMatriz(){


		System.out.println("\n**Matriz Resultado**\n");

		for (int i = 0; i < this.matrizEstradas.length; i++){
			for(int j = 0; j < this.matrizEstradas.length; j++){

				System.out.print(this.matrizEstradas[i][j] + " ");
			}

			System.out.println();
		}

	}


	/*<--------------------------------------------------------------------------------------->*/


	public void checarDistancia(){

		System.out.println("\n*** Checando a distância entre duas cidades ***\n");
		
		boolean diferente = false;
		int cidade1 = 0;
		int cidade2 = 0;
		
		while (diferente == false){
			
			cidade1 = perguntarCidade();
			cidade2 = perguntarCidade();
			
			if (cidade1 != cidade2) diferente = true;
			else System.out.println("Você inseriu a mesma cidade duas vezes, tente novamente.\n");
		}

		if (matrizEstradas[cidade1 -1][cidade2 -1] > 0){

			System.out.printf("\nA distancia entre as cidades %d e %d e %.2fkm.", cidade1, cidade2, matrizEstradas[cidade1 - 1][cidade2 - 1]);
		}		
		else System.out.print("\nNão existe estrada entre as cidades");
	}


	/*<--------------------------------------------------------------------------------------->*/


	private int perguntarCidade(){

		int cidade = 0;

		while (true){

			try{

				System.out.print("Insira a cidade: ");
				cidade = entrada.nextInt();

				if (cidade < 0 || cidade > this.matrizEstradas.length){
					throw new OutOfBoundsException();
				}

				return cidade;
			}
			catch(OutOfBoundsException e){}
			catch(InputMismatchException e){ System.out.println("Voce inseriu um caractere incorreto."); entrada.next();}
			catch(Exception e){ e.printStackTrace();}
		}
	}


	/*<--------------------------------------------------------------------------------------->*/
}