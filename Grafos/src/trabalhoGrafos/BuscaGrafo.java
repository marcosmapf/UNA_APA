package trabalhoGrafos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BuscaGrafo {

	static int [][] grafo;
	static int tamanho;

	static int tempo = 0;

	//-----------------------------------------------------//

	static void leituraGrafo() throws FileNotFoundException{

		// Utiliza um try para evitar erros na abertura do arquivo (caso não exista, etc)

		try{


			/*Cria um novo objeto do tipo File que irá abrir o arquivo indicado em seu argumento, e então
			 * faz uso de um Scanner para fazer a leitura da primeira linha do arquivo.
			 * Como é garantido que o arquivo lido sempre será uma matriz quadrática (porque, senão, não é 
			 * um grafo) então o tamanho da primeira linha também será o tamanho da coluna. Portanto, sabe-se
			 * o tamanho total do grafo. Após a leitura, fecha-se o arquivo.
			 */

			Scanner leituraArquivo = new Scanner(new File("C:\\Users\\marco\\workspace\\Grafos\\BuscaProfundidade.txt"));
			String[] linhaGrafo = leituraArquivo.nextLine().trim().split("\\s+");
			tamanho = linhaGrafo.length;
			leituraArquivo.close();


			/*É criada uma matriz que vai segurar os valores lidos pelo arquivo (que será aberto novamente)
			 * e é utilizada uma variável contadorLinhas para iterar pelas linhas do arquivo.
			 * O arquivo precisou ser fechado pois a primeira linha não seria aproveitada e capturada pelo programa
			 * se ele rodasse tudo de uma única vez.
			 * 
			 */

			int matrizGrafo[][] = new int [tamanho][tamanho];
			int contadorLinhas = 0;
			leituraArquivo = new Scanner(new File("C:\\Users\\marco\\workspace\\Grafos\\BuscaProfundidade.txt"));

			/*hasNextLine verifica se o arquivo possui uma próxima linha, .trim() retira os espaços em branco
			 * do arquivo (0 1 2 3 por exemplo torna-se  0123) e .split separa cada numero encontrado no meu
			 * arquivo em uma variável na minha matriz de strings [], e adiciona cada um dele a um indice
			 * finalmente, Integer.parseInt transforma os numeros (que antes eram considerados Strings) em int 
			 */

			while (leituraArquivo.hasNextLine()){

				linhaGrafo = leituraArquivo.nextLine().trim().split("\\s+");

				for (int i = 0; i < tamanho; i++){

					matrizGrafo[contadorLinhas][i] = Integer.parseInt(linhaGrafo[i]);

				}

				contadorLinhas++;

			}

			grafo = matrizGrafo;
			leituraArquivo.close();
		}

		finally {}

	}

	//-----------------------------------------------------//

	static void imprimeConsole(){

		//impressão simples de uma matriz no console.

		System.out.println("** --------- Matriz --------- **");

		for (int i = 0; i < tamanho; i++)
		{
			for (int j = 0; j < tamanho; j++){

				System.out.print(grafo[i][j] + " ");
			}

			System.out.println();
		}
	}

	//-----------------------------------------------------//

	static void BuscaProfundidade (){

		/*Método para fazer a Busca em Profundidade no grafo fornecido.
		 * Comportamento do método:
		 * 
		 * -> Inicia variáveis 'encontrouVert', 'terminouVert' e 'pai' com 'Null' (quer dizer, -1) e 'cor' com 'White',
		 * para sinalizar os vértices que ainda não foram utilizados e/ou terminados.
		 * 
		 * -> Faz a leitura do vertice inicial usando a função LeituraVertice(). O vertice é, portanto, fornecido pelo usuário.
		 * 
		 * -> Verifica se ainda existem vertices não utilizados, e se a cor for 'Branco' (white) chama a função
		 * visitaVert() para inserir esse vértice no resultado. Se a cor for diferente de Branco (no caso, 'Preta',
		 * quer dizer, 'Black') então itera pelos vértices restantes até encontrar um que ainda seja 'Branco'.
		 * 
		 * Após iterar por todos os vértices, chama a função ResultadoProfundidade para imprimir o resultado no console do usuário.
		 *   
		 */

		int vertice = LeituraVertice();

		int [] encontrouVert = new int [tamanho];
		int [] terminouVert = new int [tamanho];		
		int [] pai = new int [tamanho];
		String [] cor = new String[tamanho];

		//-----------------------------------------------------//

		//Insere em toos os indices do vetor indicado (primeiro parâmetro) o valor indicado (segundo parâmetro)

		Arrays.fill(cor, "white");
		Arrays.fill(pai, -1);
		Arrays.fill(encontrouVert, -1);
		Arrays.fill(terminouVert, -1);


		//-----------------------------------------------------//

		//Iteração por todos os vertices e processamento da Busca em Profundidade.

		while (restVet(cor) == true){

			if (cor[vertice] == "white"){

				visitaVert(vertice, cor, encontrouVert, terminouVert, pai);
			}
			else {

				vertice = 0;

				while (cor[vertice] != "white"){

					vertice++;
				}

				tempo++;
			}
		}

		ResultadoProfundidade(encontrouVert, terminouVert, pai);
		salvarProfundidade(encontrouVert, terminouVert, pai);
	}

	//-----------------------------------------------------//

	static void ResultadoProfundidade(int[] encontrouVert, int [] terminouVert, int[] pai){

		//Método para imprimir o resultado da busca em profundidade no console do usuário

		System.out.println("\n" + "** Na busca por profundidade: **" + "\n");

		for (int i = 0; i < tamanho; i++){

			System.out.println("Tempo de descoberta do " + i + "º vértice = " + encontrouVert[i] + "  || Pai do Vértice = " + pai[i]);
			System.out.println("Tempo de finalização do " + i + "º vértice = " + terminouVert[i] + "\n");
		}
	}

	//-----------------------------------------------------//

	static void salvarProfundidade (int [] encontrouVert, int [] terminouVert, int[] pai){

		String separator = System.getProperty("line.separator");

		try{		

			FileWriter file = new FileWriter("resultadoProfundidade.txt");
			BufferedWriter buffer = new BufferedWriter (file);

			buffer.write(separator + "** Na busca por profundidade: **" + separator);

			for (int i = 0; i < tamanho; i++){

				buffer.write("Tempo de descoberta do " + i + "º vértice = " + encontrouVert[i] + "  || Pai do Vértice = " + pai[i]);
				buffer.newLine();
				buffer.write("Tempo de finalização do " + i + "º vértice = " + terminouVert[i] + "\n");
				buffer.newLine();
				buffer.newLine();
			}

			buffer.close();	
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void BuscaLargura (){

		/*Método para fazer a Busca em Largura no grafo fornecido.
		 * Comportamento do método:
		 * 
		 *-> Inicia variáveis 'pai' e 'distancia' com o valor 'Null' (quer dizer, -1) e 'cor' com 'White',
		 * para sinalizar os vértices que ainda não foram utilizados e/ou terminados
		 * 
		 * -> Faz a leitura do vertice inicial usando a função LeituraVertice(). O vertice é, portanto, fornecido pelo usuário.
		 * 
		 * -> Inicia uma Fila de elementos chamando o método InserirElemento() que existe na classe "Filas" (inserida no pacote)
		 * e passa o primeiro vértice como o primeiro elemento da fila.
		 * 
		 * -> Verifica quais vértices se encontram adjacentes ao vertice atual, e adiciona eles como novos elementos da fila
		 * PS: Como a fila adiciona todos os elementos adjacentes ao mesmo tempo (ao contrário da Busca em Profundidade, que só
		 * adiciona o primeiro adjacente) a busca se torna mais "esparsa" (quer dizer, pode percorrer por diferentes galhos 
		 * da arvore ao mesmo tempo)
		 * 
		 * -> Após iterar por todos os vértices, chama a função ResultadoLargura para imprimir o resultado no console do usuário.	
		 *   
		 */

		int [] pai = new int [tamanho];
		int [] distancia = new int[tamanho];
		String [] cor = new String [tamanho];
		int vertice = LeituraVertice();

		//-----------------------------------------------------//

		//Insere em toos os indices do vetor indicado (primeiro parâmetro) o valor indicado (segundo parâmetro)

		Arrays.fill(pai, -1);
		Arrays.fill(distancia, -1);
		Arrays.fill(cor, "White");

		pai[vertice] = -1;
		cor[vertice] = "Black";
		distancia[vertice] = 0;

		//-----------------------------------------------------//

		//Inicia a fila com o vertice fornecido pelo usuário

		Filas.InserirElemento(vertice);

		//Iteração por todos os vértices e processamento da Busca em Largura.

		while (Filas.getComeco() != null){

			//Filas.ConsultarFila();

			vertice = Filas.getComeco().numero;

			for (int i = 0; i < grafo.length; i++){

				if (grafo[vertice][i] != 0 && cor[i] == "White"){

					Filas.InserirElemento(i);
					pai[i] = vertice;
					distancia[i] = distancia[vertice] +1;
					cor[i] = "Black";

				}
			}

			//Remove o vertice atual da fila para fazer a análise do próximo vértice
			Filas.RemoverElemento();
		}

		//-----------------------------------------------------//	

		ResultadoLargura(distancia, pai);
		salvarLargura(distancia, pai);
	}

	//-----------------------------------------------------//

	static void ResultadoLargura(int [] distancia, int [] pai){

		//Imprime o resultado da Busca em Largura no console do usuário.

		System.out.println("\n" + "** Na busca por largura: **" + "\n");

		for (int i = 0; i < tamanho; i++){

			if (distancia[i] != -1){

				System.out.println("Vertice: " + i + "\n" + "Pai: " + pai[i] + "\n" + "Distância: " + distancia[i] + "\n");
			}
		}
	}

	//-----------------------------------------------------//

	static void salvarLargura(int [] distancia, int [] pai){

		String separator = System.getProperty("line.separator");

		try {			

			FileWriter file = new FileWriter("resultadoLargura.txt");
			BufferedWriter buffer = new BufferedWriter (file);

			buffer.write(separator + "** Na busca por largura: **" + separator);

			for (int i = 0; i < tamanho; i++){

				if (distancia[i] != -1){

					buffer.write("Vertice: " + i + separator + "Pai: " + pai[i] + separator + "Distância: " + distancia[i] + separator);
					buffer.newLine();
				}
			}

			buffer.close();	
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	//-----------------------------------------------------//


	static boolean restVet(String[] cor){

		/*Verifica se ainda existem vertices disponiveis para serem utilizados no
		 * vetor cor[] iterando por todo o vetor e verificando se há um valor 
		 * "branco" ou "cinza" restante, que simboliza um vértice não visitado (branco), 
		 * ou visita mas não completado (cinza). 
		 */

		for (int i = 0; i < cor.length; i++){

			if (cor[i] == "white" || cor[i] == "gray"){

				return true;
			}
		}
		return false;
	}

	//-----------------------------------------------------//

	static void visitaVert(int vertice, String[] cor, int[] encontrouVert, int[] terminouVert, int[] pai){

		//System.out.printf("\n" + "Tempo: %d, Vertice: %d, Cor: %s", tempo, vertice, cor[vertice]);

		cor[vertice] = "gray";
		encontrouVert[vertice] = tempo;

		//System.out.printf("\n" + "Tempo: %d, Vertice: %d, Cor: %s", tempo, vertice, cor[vertice]);

		tempo++;

		for (int i = vertice; i < tamanho; i++){

			if (grafo[vertice][i] != 0 && cor[i] != "black"){

				pai [i] = vertice;
				grafo[vertice][i] = 0;
				grafo[i][vertice] = 0;
				vertice = i;

				visitaVert(vertice, cor, encontrouVert, terminouVert, pai); 

				//System.out.printf("\n" + "Tempo: %d, Vertice: %d, Cor: %s", tempo, vertice, cor[vertice]);

				vertice = pai[vertice];
				tempo++;
			}

			cor[vertice] = "black";
			terminouVert[vertice] = tempo;
		}
	}

	//-----------------------------------------------------//

	static int LeituraVertice (){

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

				while (vertice < 0 || vertice >= tamanho){

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

	public static void main(String[] args) throws InputMismatchException, FileNotFoundException {

		leituraGrafo();
		imprimeConsole();
		BuscaLargura();

	}
}
