package analisadorLexico;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;


//-----------------------------------------------------//


public class Analisador {

	void readFile(){

		try{

			FileReader arquivo = new FileReader("analisadorLexicoTeste.cpt");			
			BufferedReader buffer = new BufferedReader(arquivo);

			String conteudoArquivo = "";
			String linha;

			do{

				linha = buffer.readLine();
				conteudoArquivo += " " + linha; 
			}
			while (linha != null);

			arquivo.close();
			buffer.close();

			conteudoArquivo = conteudoArquivo.replace("  ", "@ ");

			System.out.println(conteudoArquivo);

			stringToChar(conteudoArquivo);

		}
		catch (Exception e){

			System.err.println("Erro na leitura de arquivo");
		}
	}


	//-----------------------------------------------------//


	void stringToChar(String arquivo){

		char[] caracteres = arquivo.toCharArray();
		analise(caracteres);
	}

	//-----------------------------------------------------//


	void analise(char[] caracteres){

		int tamanho = caracteres.length;
		String palavra = "";
		List<String> lexema = new ArrayList<String>();
		List<String> token = new ArrayList<String>();

		//Map<String,String> hashMap = new LinkedHashMap<String,String>();


		for (int i = 1; i < tamanho; i++){

			char charAnterior;


			//-----------------------------------------------------//			
			//Caso Atribuição Aspas Duplas String


			if (caracteres[i] == '"'){

				//Adiciona a aspas duplas de abertura à lista de lexemas e atribui o token atribuicao_Aspas
				palavra += caracteres[i];

				lexema.add(palavra);
				token.add("atribuicao_Aspas");

				palavra = "";

				i++;

				//Verifica se o próximo caractere é uma Aspas. Se não for, então irá ler o conteudo até achar uma aspas e atribuir o token cadeia_Caracteres
				if (caracteres[i] != '"'){
					while (caracteres[i] != '"'){

						palavra += caracteres[i];
						i++;
					}

					lexema.add(palavra);
					token.add("cadeia_Caracteres");

					palavra = "";
				}

				//Atribui à aspas duplas de fechamento o token atribuicao_Aspas 
				palavra += caracteres[i];

				lexema.add(palavra);
				token.add("atribuicao_Aspas");

				palavra = "";
			}	


			//-----------------------------------------------------//
			//Caso Barra


			else if (caracteres[i] == '/'){

				charAnterior = caracteres[i];
				i++;

				//Verifica se há um espaço após a barra. Se houver, então o lexema recebe o valor de token divisão
				if (caracteres[i] == ' '){

					palavra += charAnterior;

					lexema.add(palavra);
					token.add("divisao");

					palavra = "";

				}

				//Verifica se existe um asterisco após a barra. Se houver, então o conjunto /* recebe o token comentario_Paragrafo
				else if (caracteres[i] == '*'){

					palavra += charAnterior;
					palavra += caracteres[i];

					lexema.add(palavra);
					token.add("inicio_Comentario_Paragrafo");

					i++;				
					palavra = "";
					boolean fim = false;

					//Loop While para garantir que um possível * lido não seja identificado como fim de comentário ao invés de simbolo normal
					while (fim == false){

						if (caracteres[i] == '*'){

							charAnterior = caracteres[i];
							i++;

							if (caracteres[i] == '/'){

								lexema.add(palavra);
								token.add("cadeia_Caracteres");

								palavra = "";
								palavra += charAnterior; 
								palavra += caracteres[i];

								lexema.add(palavra);
								token.add("fim_Comentario_Paragrafo");

								fim = true;
								palavra = "";
							}							
							else {

								if (charAnterior != '@')
									palavra+= charAnterior;
							}
						}

						else {

							if (caracteres[i] != '@'){
								palavra+= caracteres[i];

							}
							i++;
						}
					}
				}


				//Caso sobre comentário-linha que não sabemos como encontrar o final
				else if (caracteres[i] == '/'){

				}
			}


			//if ((caracteres[i] >= 'a' && caracteres[i] <= 'z') || (caracteres[i] >= 'A' && caracteres[i] <= 'Z' )){

		}

		saveFile(lexema, token);
	}

	//-----------------------------------------------------//
   //Gravando o resultado em um arquivo

	void saveFile(List lexema, List token){

		try {			

			int tamanho = lexema.size();

			FileWriter file = new FileWriter("resultadoAnalisador.cpx");
			BufferedWriter buffer = new BufferedWriter (file);

			for (int i = 0; i < tamanho; i++){

				buffer.write("Lexema: " + lexema.get(i));
				buffer.newLine();
				buffer.write("Token:  " + token.get(i));
				buffer.newLine();
				buffer.newLine();
			}
			buffer.close();	
		} 
		catch (Exception e) {
			
			
			e.printStackTrace();
		}
	}

}