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

	Scanner entrada = new Scanner(System.in);

	double[][] matrizEstradas;
	int roadCount = 0;

	public Cidades(int tamanho){

		this.matrizEstradas = preencherMatriz(tamanho);
	}
	
	public Cidades (double[][] matriz){
		
		this.matrizEstradas = matriz;
	}


	/*<--------------------------------------------------------------------------------------->*/


	private double[][] preencherMatriz(int tamanho){

		double[][] matriz = new double[tamanho][tamanho];

		for (int i = 0; i < tamanho; i++){
			for (int j = i + 1; j < tamanho; j++){

				System.out.print("Insira a distancia entra as cidades " + (i+1) + " e " + (j+1) + ": ");
				matriz[i][j] = lerDistancia();
				matriz[j][i] = matriz[i][j];
			}
		}

		return matriz;
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

		for (int i = 0; i < matrizEstradas.length; i ++){
			for (int j = i + 1; j < matrizEstradas.length; j++){

				if (this.matrizEstradas[i][j] > 0) { 

					roadCount += 1;
				}
			}
		}

		this.roadCount = roadCount;
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


	public void checarDistancia(int cidade1, int cidade2){

		if (matrizEstradas[cidade1 - 1][cidade2 - 1] > 0){

			System.out.printf("\nA distancia entre as cidades %d e %d e %.2fkm.", cidade1, cidade2, matrizEstradas[cidade1 - 1][cidade2 - 1]);
		}		
		else System.out.print("\nNão existe estrada entre as cidades");
	}


	/*<--------------------------------------------------------------------------------------->*/


}