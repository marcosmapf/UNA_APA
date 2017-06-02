package trabalhoGrafos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Dijkstra {

	private static String stringArquivo = "";

	private static int[][] leituraGrafo() throws FileNotFoundException{

		// Utiliza um try para evitar erros na abertura do arquivo (caso não exista, etc)

		int[][] matrizGrafo = null; 

		try{

			FileReader arquivo = new FileReader("Dijkstra.txt");			
			BufferedReader buffer = new BufferedReader(arquivo);

			String linha = buffer.readLine();
			String[] linhaGrafo = linha.trim().split("\\s+");

			arquivo.close();
			buffer.close();

			int tamanho = linhaGrafo.length;
			int Grafo[][] = new int [tamanho][tamanho];
			int contadorLinhas = 0;

			arquivo = new FileReader("Dijkstra.txt");
			buffer = new BufferedReader(arquivo);	

			linha = buffer.readLine();

			do{			

				linhaGrafo = linha.trim().split("\\s+");

				for (int i = 0; i < tamanho; i++){

					Grafo[contadorLinhas][i] = Integer.parseInt(linhaGrafo[i]);
				}

				contadorLinhas++;

				linha = buffer.readLine();

			}
			while (linha != null);

			arquivo.close();
			buffer.close();

			matrizGrafo = Grafo;

		}
		catch (Exception e){}

		finally {}

		return matrizGrafo;
	}

	//-----------------------------------------------------//

	private static void imprimeConsole(int matrizGrafo[][], int tamanho){

		//impressão simples de uma matriz no console.

		System.out.println("** --------- Matriz --------- **");

		for (int i = 0; i < tamanho; i++)
		{
			for (int j = 0; j < tamanho; j++){

				System.out.print(matrizGrafo[i][j] + " ");
			}

			System.out.println();
		}
	}

	//-----------------------------------------------------//

	private static int leituraVertice (int tamanho){

		/*Método para requisitar do usuário a partir de qual vértice começará a busca.
		 * Possui tratamento de erros (valores acima ou abaixo do esperado, ou caracteres invalidos)
		 */

		int vertice = -1;

		//-----------------------------------------------------//

		while (vertice == -1){

			try{

				Scanner entrada = new Scanner(System.in);
				System.out.print("\n" + "Informe o vértice inicial da busca: ");
				vertice = entrada.nextInt();

				while (vertice < 0 || vertice > tamanho){

					System.out.println("Vértice inexistente.");
					System.out.print("\n" + "Informe o vértice inicial da busca: ");
					vertice = entrada.nextInt();
				}
			}
			catch(InputMismatchException e){

				System.out.println("O vértice inserido é inválido.");
			}

		}

		return vertice;
	}

	//-----------------------------------------------------//

	private static boolean restVet(int provisorio[], int tamanho){

		for (int i = 0; i < tamanho; i++){

			if (provisorio[i] == 1){

				return true;
			}
		}

		return false;
	}

	//-----------------------------------------------------//

	private static int extrairMinimo(int tamanho, int distancia[], int provisorio[], int definitivo[]) {

		int menor = Integer.MAX_VALUE;
		int indice = -1;

		for (int i = 0; i < tamanho; i++){

			if (distancia[i] < menor && provisorio[i] == 1){

				menor = distancia[i];
				indice = i;
			}
		}

		provisorio[indice] = 0;
		definitivo[indice] = 1;
		return indice;

	}

	//-----------------------------------------------------//

	private static void relaxamento(int matrizGrafo[][], int pai[], int distancia[], int provisorio[], int vertice, int i) {

		pai[i] = vertice;
		distancia[i] = distancia[vertice] + matrizGrafo[vertice][i];
		matrizGrafo[vertice][i] = 0;
		matrizGrafo[i][vertice] = 0;
		provisorio[i] = 1;
	}

	//-----------------------------------------------------//

	private static void verifDist(int tamanho, int[] distancia) {

		for (int i = 0; i < tamanho; i++){
			if (distancia[i] == Integer.MAX_VALUE){
				distancia[i] = -1;
			}
		}
	}

	//-----------------------------------------------------//

	private static void imprimirVertices(int tamanho, int[] pai, int[] distancia, int inicial) {

		System.out.println("\n" + "Vértice inicial: " + inicial + "\n" + "\\/--------------------------------\\/"
				+ "\n");

		for (int i = 0; i < tamanho; i ++){

			System.out.println("Vértice:   " + i + "\n" 
					+ "Pai:       " + pai[i] + "\n" 
					+ "Distância: " + distancia[i] + "\n");
		}
	}

	//-----------------------------------------------------//

	private static void requisitaCaminho(int tamanho, int inicial, int pai[], int distancia[]){


		while (true){

			try{

				Scanner entrada = new Scanner (System.in);
				int repetir;

				System.out.print("Digite 0 para fechar o programa ou 1 para visualizar e gravar o caminho a um vértice específico: ");
				repetir = entrada.nextInt();

				while (repetir != 1 && repetir != 0){

					System.out.println("\n" + "Opção Inexistente.");
					System.out.print("Digite 0 para fechar o programa ou 1 para visualizar e gravar o caminho a um vértice específico: ");
					repetir = entrada.nextInt();
				}

				switch (repetir){

				case 0: System.exit(0);	break;
				case 1: caminhoVertice(entrada, tamanho, inicial, pai, distancia); break;
				}

			}
			catch (InputMismatchException e){

				System.out.println("Caracatere inválido." + "\n");


			}
		}
	}		

	//-----------------------------------------------------//

	private static void caminhoVertice(Scanner entrada, int tamanho, int inicial, int pai[], int distancia[]){		

		try{

			int destino;

			System.out.print("Digite o vértice de destino: ");
			destino = entrada.nextInt();

			while (destino < 0 || destino > tamanho){

				System.out.println("Vértice Inexistente.");
				System.out.print("Digite novamente o vértice: ");
				destino = entrada.nextInt();
			}

			int auxiliar = destino;

			System.out.println("\n" + "//---------------------------------------------------------------------//");

			switch (distancia[destino]){
			case -1:
				System.out.println("Não é possível fazer um caminho do vértice inicial ao vértice de destino"); 
				System.out.println("//---------------------------------------------------------------------//" + "\n");
				break;

			default:

				System.out.println("O caminho do vértice " + inicial + " até o vértice: " + destino + " é:");

				imprimirCaminho(inicial, destino, auxiliar, pai);
				System.out.print(destino);
				stringArquivo += destino;

				System.out.println("\n" + "//----------------------------------//");
				System.out.println("\n");

				salvarArquivo(inicial, destino, stringArquivo);

				break;
			}
		}
		catch(InputMismatchException e){

			System.out.println("O caractere inserido é inválido.");
		}
	}

	//-----------------------------------------------------//

	private static void imprimirCaminho(int inicial, int destino, int auxiliar, int pai []){


		if (auxiliar != inicial){

			auxiliar = pai[auxiliar];			
			imprimirCaminho(inicial, destino, auxiliar, pai);
			System.out.print(auxiliar + " ");
			stringArquivo += auxiliar + " ";
		}
	}

	//-----------------------------------------------------//

	private static void salvarArquivo(int inicial, int destino, String salvarArquivo){

		try {

			FileWriter file = new FileWriter("resultadoDijktra.txt", true);
			BufferedWriter buffer = new BufferedWriter(file);

			buffer.write("O caminho do vértice " + inicial + " até o vértice: " + destino + " é: " );
			buffer.newLine();
			buffer.write(salvarArquivo);
			buffer.newLine();
			buffer.newLine();

			stringArquivo = "";
			buffer.close();	

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	//-----------------------------------------------------//

	public static void main(String[] args) throws FileNotFoundException, InputMismatchException{

		int [][] matrizGrafo = leituraGrafo();
		int tamanho = matrizGrafo.length;

		imprimeConsole(matrizGrafo, tamanho);

		//-----------------------------------------------------//

		int pai[] = new int[tamanho];
		int distancia[] = new int[tamanho];
		int provisorio[] = new int[tamanho];
		int definitivo[] = new int[tamanho];

		Arrays.fill(pai, -1);
		Arrays.fill(distancia, Integer.MAX_VALUE);
		Arrays.fill(provisorio, 0);
		Arrays.fill(definitivo, 0);

		//-----------------------------------------------------//

		int vertice = leituraVertice(tamanho);
		int inicial = vertice;

		distancia[vertice] = 0;
		provisorio[vertice] = 1;

		//-----------------------------------------------------//

		while (restVet(provisorio, tamanho) == true){

			vertice = extrairMinimo(tamanho, distancia, provisorio, definitivo);

			for (int i = 0; i < tamanho; i++){

				if (matrizGrafo[vertice][i] != 0 && (distancia[vertice] + matrizGrafo[vertice][i]) < distancia[i]){

					relaxamento(matrizGrafo, pai, distancia, provisorio, vertice, i);
				}
			}				
		}

		//-----------------------------------------------------//

		verifDist(tamanho, distancia);
		imprimirVertices(tamanho, pai, distancia, inicial);
		requisitaCaminho(tamanho, inicial, pai, distancia);

		//-----------------------------------------------------//

	}
}
