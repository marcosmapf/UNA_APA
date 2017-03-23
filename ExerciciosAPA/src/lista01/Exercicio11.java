package lista01;

import java.util.InputMismatchException;
import java.util.Scanner;

import customExceptions.OutOfBoundsException;

public class Exercicio11 {

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

	double[][] roadMatrix;
	int sizeMatrix = 0;
	int roadCount = 0;

	public Exercicio11(){

		double[][] mapaCidades = new double[4][4];
		this.sizeMatrix = mapaCidades.length;
		this.roadMatrix = matrixFill(mapaCidades);

	}


	/*<--------------------------------------------------------------------------------------->*/


	private double[][] matrixFill(double[][] matriz){

		for (int i = 0; i < sizeMatrix; i++){
			for (int j = i + 1; j < sizeMatrix; j++){

				System.out.print("Insira a distancia entra as cidades " + (i+1) + " e " + (j+1) + ": ");
				matriz[i][j] = readDistance();
				matriz[j][i] = matriz[i][j];
			}
		}

		return matriz;
	}


	/*<--------------------------------------------------------------------------------------->*/


	private double readDistance(){

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


	public void countRoad(){

		int roadCount = 0;

		for (int i = 0; i < sizeMatrix; i ++){
			for (int j = i + 1; j < sizeMatrix; j++){

				if (this.roadMatrix[i][j] > 0) { 

					roadCount += 1;
				}
			}
		}

		this.roadCount = roadCount;
		System.out.println("\nExistem + " + roadCount + " estradas entre as cidades.");
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void printMatrix(){


		System.out.println("\n**Matriz Resultado**\n");

		for (int i = 0; i < this.sizeMatrix; i++){
			for(int j = 0; j < this.sizeMatrix; j++){

				System.out.print(this.roadMatrix[i][j] + " ");
			}

			System.out.println();
		}

	}


	/*<--------------------------------------------------------------------------------------->*/


	public void checkDistance(int cidade1, int cidade2){

		if (roadMatrix[cidade1][cidade2] > 0){

			System.out.println("\nA distancia entre as cidades é " + roadMatrix[cidade1][cidade2] + ".");
		}		
	}


	/*<--------------------------------------------------------------------------------------->*/


}