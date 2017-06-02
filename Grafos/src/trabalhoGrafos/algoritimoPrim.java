package trabalhoGrafos;
/*Algoritmo de Prim: Encontra a uma Minimal Spanning Tree (MST), ou 
 *arvore geradora mínima a partir de um dado grafo inserido no programa
 *(através de um arquivo .txt).
 *
 *É utilizado:
 *
 *-> int [][] GrafoArvore para guardar os dados do grafo inserido.
 *-> Classe arvoreMinimaX, que irá funcionar como uma Fila Encadeada para representar os valores da árvore mínima. Guarda os valores dos vértices e seus pais. 
 *-> int [] RestantesQ para guardar os vértices que ainda não fazem parte da árvore.
 *-> Int [] Chave guarda o menor peso que um vértice atual possui com outro.
 *
 *
 * -> GrafoArvore possui os valores dos pesos das arestas do grafo, além da informação de que existe uma aresta entre dois grafos.
 * -> arvoreMinimaX possui como variáveis o vértice que faz parte da árvore minima, e o seu pai (vertice que veio anteriormente).
 * -> RestantesQ está preenchido com 1 se um vértice não foi utilizado ainda e 0 se já foi utilizado.
 * -> Chave é preenchido com "Infinito" em todos os valores no começo do programa. Chave é comparado com o peso dos vértices.
 * em GrafoArvore 
 * 
 * Deve possuir o método:
 * 
 * -> extrairMinimo (RestantesQ[], chave[]), que usa os pesos de GrafoArvore e os valores de Chave e compara ambos. 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class algoritimoPrim {

	static int [][] leituraGrafo() throws FileNotFoundException{

		// Utiliza um try para evitar erros na abertura do arquivo (caso não exista, etc)

		int[][] matrizGrafo = null; 

		try{

			FileReader arquivo = new FileReader("ArvoreMinima.txt");			
			BufferedReader buffer = new BufferedReader(arquivo);

			String linha = buffer.readLine();
			String[] linhaGrafo = linha.trim().split("\\s+");

			arquivo.close();
			buffer.close();

			int tamanho = linhaGrafo.length;
			int Grafo[][] = new int [tamanho][tamanho];
			int contadorLinhas = 0;

			arquivo = new FileReader("ArvoreMinima.txt");
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

	static void imprimeMatriz(int [][] pesoGrafo){

		//impressão simples de uma matriz no console.

		System.out.println("** --------- Matriz --------- **");

		for (int i = 0; i < pesoGrafo.length; i++)
		{
			for (int j = 0; j < pesoGrafo.length; j++){

				System.out.print(pesoGrafo[i][j] + " ");
			}

			System.out.println();
		}
	}

	//-----------------------------------------------------//

	static int leituraVertice (int tamanhoG){

		/*Método para requisitar do usuário qual será o vertice inicial do Algoritmo de Prim.
		 * Possui tratamento de erros (valores acima ou abaixo do esperado, ou caracteres invalidos)
		 */

		int vertice = -1;

		//-----------------------------------------------------//

		while (vertice == -1){

			try{

				Scanner entrada = new Scanner(System.in);
				System.out.print("\n" + "Informe o vértice inicial da busca: ");
				vertice = entrada.nextInt();

				while (vertice < 0 || vertice > tamanhoG){

					System.out.println("Vértice inexistente.");
					System.out.print("\n" + "Informe o vértice inicial da busca: ");
					vertice = entrada.nextInt();
				}

				entrada.close();			

			}
			catch(InputMismatchException e){

				System.out.println("O vértice inserido é inválido.");
			}
		}

		return vertice;
	}

	//-----------------------------------------------------//

	static boolean restVet(int[] restantesQ){

		/*Verifica se ainda existem vertices disponiveis para serem utilizados no
		 * vetor restantesQ[] iterando por todo o vetor e verificando se há um valor 
		 * "1" restante, que simboliza um vértice não utilizado. 
		 */

		for (int i = 0; i < restantesQ.length; i++){

			if (restantesQ[i] == 1){

				return true;
			}
		}
		return false;
	}

	//-----------------------------------------------------//

	static int extrairMinimo(int[] restanteQ, int[] chave){

		/*O método verifica nos vértices restantes do grafo qual possui o menor peso entre as arestas
		 * e retorna esse vértice (seu indice) para arvoreMinimaX[], que irá adicionar ele na sequência de vértices.
		 * Integer.MAX_VALUE representa um valor Infinito (ou o maior possível) de uma integer (valor inteiro)
		 */

		int menor = Integer.MAX_VALUE;
		int indice = -1;

		for (int i = 0; i < restanteQ.length; i++){

			if (restanteQ[i] == 1 && chave[i] < menor){

				menor = chave[i];
				indice = i;
			}

		}

		restanteQ[indice] = 0;
		return indice;
	}

	//-----------------------------------------------------//

	static void imprimeArvore(int[] arvoreMinima, int[] pai, int tamanhoG, int inicial){

		System.out.println("A arvore mínima resultante, começando no vértice "
				+ inicial + " é: " + "\n");

		for (int i = 0; i < tamanhoG; i++){

			System.out.println("Vértice: " + arvoreMinima[i] + " Pai: " + pai[arvoreMinima[i]]);
		}

		gravarArvore(arvoreMinima, pai, tamanhoG, inicial);
	}

	//-----------------------------------------------------//

	static void gravarArvore(int [] arvoreMinima, int [] pai, int tamanhoG, int inicial){

		try {			

			FileWriter file = new FileWriter("resultadoPrim.txt");
			BufferedWriter buffer = new BufferedWriter (file);

			buffer.write("A arvore mínima resultante, começando no vértice " + inicial + " é: ");
			buffer.newLine();
			buffer.newLine();

			for (int i = 0; i < tamanhoG; i++){

				buffer.write("Vértice: " + arvoreMinima[i] + " Pai: " + pai[arvoreMinima[i]]);
				buffer.newLine();
			}
			buffer.close();	
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	//-----------------------------------------------------//

	public static void main(String[] args) throws FileNotFoundException{


		//Chama o método leituraGrafo para fazer a leitura do grafo fornecido no arquivo.
		//Guarda o grafo que foi lido pelo método leituraGrafo() e será usado no programa.

		int [][] pesoGrafo = leituraGrafo();
		imprimeMatriz(pesoGrafo);

		//-----------------------------------------------------//	
		
		//Declaração das variáveis.

		//Captura e guarda o tamanho do meu grafo lido pelo método leituraGrafo().
		final int tamanhoG = pesoGrafo.length;

		//Variável fornecida pelo usuário (através do método LeituraVertice) cujo valor indica qual vértice da árvore será o inicial		

		int vertice = leituraVertice(tamanhoG);
		final int inicial = vertice;

		//Variável resultado (final) que terá o os vértices da arvore em sequencia.
		int arvoreMinima[] = new int[tamanhoG];

		//Guarda os indices que correspondem aos pais dos vertices usados na arvore mínima.
		int pai[] = new int[tamanhoG];

		//Guarda os vértices que ainda não foram utilizados pelo programa para construir a árvore.
		int [] restantesQ = new int [tamanhoG];

		//guarda as chaves (menor peso) dos vértices do grafo.
		int [] chave = new int [tamanhoG];

		//Variável usada para iterar entre os indices de arvoreMinimaX.
		int contador = 0;


		//-----------------------------------------------------//	
		//inicialização das variáves.

		Arrays.fill(restantesQ,  1);
		Arrays.fill(chave, Integer.MAX_VALUE);
		Arrays.fill(pai, -1);
		Arrays.fill(arvoreMinima, -1);

		/*Sinaliza que a chave do primeiro vértice será 0, para que ele
		 * seja o primeiro escolhido pelo método extrairMinimo, já que
		 * nenhum outro vértice terá peso 0 ou menor que 0.
		 */

		chave[vertice] = 0;

		//-----------------------------------------------------//	
		
		//Iteração entre os vértices e processamento do Algoritmo de Prim

		/* Verifica se ainda existem valores dentro do vetor restVet,
		 * quer dizer, verifica se ainda existem vetores no grafo
		 * que não foram utilizados na árvore.
		 */

		while (restVet(restantesQ) == true){

			/*Usando o método extrairMinimo, atribui ao indice atual de arvoreMinimaX (o vetor resultante) a
			 * a posição (indice) do grafo que é adjacente a ele e possui menor peso
			 */
			arvoreMinima[contador] = extrairMinimo(restantesQ, chave);

			//atualiza o vertice analisado na seção for abaixo usando o indice encontrado em arvoreMinimaX[contador]
			vertice = arvoreMinima[contador];

			/*Verifica quais vértices estão adjacentes ao vértice atual e, se o peso deles for
			 * menor do que a chave (menor peso) atual, então atualiza o valor.
			 */

			for (int j = 0; j < tamanhoG; j++){

				if (pesoGrafo[vertice][j] != 0 && restantesQ[j] != 0 && pesoGrafo[vertice][j] < chave[j]){

					chave[j] = pesoGrafo[vertice][j];
					pai[j] = vertice;
				}
			}	
			
			//Aumenta o valor da variável que itera pelos indices de arvoreMinimaX.
			contador++;
		}

		imprimeArvore(arvoreMinima, pai, tamanhoG, inicial);

		//-----------------------------------------------------//	
	}
}