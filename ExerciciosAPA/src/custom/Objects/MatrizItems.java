package custom.Objects;

import java.security.SecureRandom;

public class MatrizItems {

	int tamanhoMatriz = 0;
	Item[][] matrizItems;

	public MatrizItems(int tamanho){

		this.matrizItems = new Item[tamanho][tamanho];
		tamanhoMatriz = tamanho;
		zerarMatriz(matrizItems);
	}

	public MatrizItems(int[][] vetor){

		tamanhoMatriz = vetor.length;
		matrizItems = new Item[tamanhoMatriz][tamanhoMatriz];

		for (int i = 0; i < tamanhoMatriz; i++){
			for (int j = 0; j < tamanhoMatriz; j++){

				matrizItems[i][j] = new Item(vetor[i][j]);
			}
		}
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void printMatriz(){

		for (int i = 0; i < tamanhoMatriz; i ++){
			for (int j = 0; j < tamanhoMatriz - 1; j++){

				System.out.print(matrizItems[i][j].getChave()+ ", ");
			}

			System.out.println(matrizItems[i][tamanhoMatriz].getChave());
		}
	}


	public static void printMatriz(Item[][] matriz){

		int tamanho = matriz.length;

		for (int i = 0; i < tamanho; i ++){
			for(int j = 0; j < tamanho - 1; j++){

				System.out.print(matriz[i][j].getChave()+ ", ");
			}

			System.out.println(matriz[i][tamanho].getChave());
		}
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void preencherAleatorio(){

		SecureRandom aleatorio = new SecureRandom();

		for (int i = 0; i < tamanhoMatriz; i++){
			for (int j = 0; j < tamanhoMatriz; j++)

				matrizItems[i][j].setChave(aleatorio.nextInt(1000));
		}
	}


	public static Item[][] preencherAleatorio(Item[][] matriz){

		int tamanho = matriz.length;
		SecureRandom aleatorio = new SecureRandom();

		for (int i = 0; i < tamanho; i++){
			for (int j = 0; j < tamanho; j++){

				matriz[i][j].setChave(aleatorio.nextInt(1000));
			}
		}

		return matriz;
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void zerarMatriz(){

		for (int i = 0; i < tamanhoMatriz; i++){
			for (int j = 0; j < tamanhoMatriz; j++)

				matrizItems[i][j].setChave(0);
		}
	}


	public static Item[][] zerarMatriz(Item[][] matriz){

		int tamanho = matriz.length;

		for (int i = 0; i < tamanho; i++){
			for (int j = 0; j < tamanho; j++){

				matriz[i][j].setChave(0);
			}
		}

		return matriz;
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void setChave(int i, int j, int valor){

		this.matrizItems[i][j].setChave(valor);
	}

	public int getChave(int i, int j){

		return this.matrizItems[i][j].getChave();
	}
}
