package custom.Objects;

import java.security.SecureRandom;

public class MatrizItems {

	private int tamanhoMatriz = 0;
	private Item[][] matrizItems;

	public MatrizItems(int tamanho){

		this.matrizItems = new Item[tamanho][tamanho];
		this.tamanhoMatriz = tamanho;
		zerarMatriz(matrizItems);
	}

	public MatrizItems(int[][] vetor){

		this.tamanhoMatriz = vetor.length;
		this.matrizItems = new Item[this.tamanhoMatriz][this.tamanhoMatriz];

		for (int i = 0; i < this.tamanhoMatriz; i++){
			for (int j = 0; j < this.tamanhoMatriz; j++){

				this.matrizItems[i][j] = new Item(vetor[i][j]);
			}
		}
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void printMatriz(){

		for (int i = 0; i < this.tamanhoMatriz; i ++){
			for (int j = 0; j < this.tamanhoMatriz - 1; j++){

				System.out.print(this.matrizItems[i][j].getChave()+ ", ");
			}

			System.out.println(this.matrizItems[i][this.tamanhoMatriz].getChave());
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


	public void preencherAleatorio(int limite){

		SecureRandom aleatorio = new SecureRandom();

		for (int i = 0; i < this.tamanhoMatriz; i++){
			for (int j = 0; j < this.tamanhoMatriz; j++)

				this.matrizItems[i][j].setChave(aleatorio.nextInt(limite));
		}
	}


	public static Item[][] preencherAleatorio(Item[][] matriz, int limite){

		int tamanho = matriz.length;
		SecureRandom aleatorio = new SecureRandom();

		for (int i = 0; i < tamanho; i++){
			for (int j = 0; j < tamanho; j++){

				matriz[i][j].setChave(aleatorio.nextInt(limite));
			}
		}

		return matriz;
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void zerarMatriz(){

		for (int i = 0; i < this.tamanhoMatriz; i++){
			for (int j = 0; j < this.tamanhoMatriz; j++)

				this.matrizItems[i][j].setChave(0);
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


	public void setChaveOfItem(int i, int j, int valor){

		this.matrizItems[i][j].setChave(valor);
	}

	public int getChaveOfItem(int i, int j){

		return this.matrizItems[i][j].getChave();
	}

	public void setItem(int i, int j, Item item){

		this.matrizItems[i][j] = item;
	}

	public Item getItem(int i, int j){

		return this.matrizItems[i][j];
	}

	public int getTamanhoMatriz(){

		return this.tamanhoMatriz;
	}

	public Item[][] getMatrizItems(){

		return this.matrizItems;
	}

	public void setMatrizItems(Item[][] matriz){

		this.matrizItems = matriz;
		this.tamanhoMatriz = matriz.length;
	}

}
