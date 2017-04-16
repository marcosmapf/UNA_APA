package custom.Objects;

import java.security.SecureRandom;

public class MatrizInt {

	private int tamanhoMatriz = 0;
	private int[][] matrizInteiros;

	public MatrizInt(int tamanho){

		this.matrizInteiros = new int[tamanho][tamanho];
		this.tamanhoMatriz = tamanho;
		zerarMatriz(matrizInteiros);		
	}

	public MatrizInt(int[][] matriz){

		this.matrizInteiros = matriz;
		this.tamanhoMatriz = matriz.length;		
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void printMatriz(){

		for (int i = 0; i < tamanhoMatriz; i ++){
			for (int j = 0; j < tamanhoMatriz - 1; j++){

				System.out.print(this.matrizInteiros[i][j]+ ", ");
			}

			System.out.println(this.matrizInteiros[i][tamanhoMatriz - 1]);
		}
	}


	public static void printMatriz(int[][] matriz){

		int tamanho = matriz.length;

		for (int i = 0; i < tamanho; i ++){
			for(int j = 0; j < tamanho - 1; j++){

				System.out.print(matriz[i][j]+ ", ");
			}

			System.out.println(matriz[i][tamanho - 1]);
		}
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void preencherAleatorio(int limite){

		SecureRandom aleatorio = new SecureRandom();

		for (int i = 0; i < this.tamanhoMatriz; i++){
			for (int j = 0; j < this.tamanhoMatriz; j++)

				this.matrizInteiros[i][j] = aleatorio.nextInt(limite);
		}
	}


	public static int[][] preencherAleatorio(int[][] matriz, int limite){

		int tamanho = matriz.length;
		SecureRandom aleatorio = new SecureRandom();

		for (int i = 0; i < tamanho; i++){
			for (int j = 0; j < tamanho; j++){

				matriz[i][j] = aleatorio.nextInt(limite);
			}
		}

		return matriz;
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void zerarMatriz(){

		for (int i = 0; i < this.tamanhoMatriz; i++){
			for (int j = 0; j < this.tamanhoMatriz; j++)

				this.matrizInteiros[i][j] = 0;
		}
	}


	public static int[][] zerarMatriz(int[][] matriz){

		int tamanho = matriz.length;

		for (int i = 0; i < tamanho; i++){
			for (int j = 0; j < tamanho; j++){

				matriz[i][j] = 0;
			}
		}

		return matriz;
	}


	/*<--------------------------------------------------------------------------------------->*/

	public int getValor(int i, int j){

		return matrizInteiros[i][j];
	}

	public void setValor(int i, int j, int valor){

		this.matrizInteiros[i][j] = valor;
	}

	public int getTamanhoMatriz(){

		return this.tamanhoMatriz; 
	}

	public int[][] getMatrizInteiros(){

		return this.matrizInteiros;
	}

	public void setMatrizInteiros(int[][] matriz){

		this.matrizInteiros = matriz;
		this.tamanhoMatriz = matriz.length;
	}

}
