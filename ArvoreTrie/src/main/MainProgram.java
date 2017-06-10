package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;
import arvoreTrie.TrieSR;

public class MainProgram {

	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {

		TrieSR<Integer> trie = new TrieSR<Integer>();
		int opcao;
		int ultimoRA = 0;

	
		System.out.println("***Cadastro de Registro Academico de Faculdade***");

		while(true){
			System.out.print("\n\n**Menu**"
					+ "\n1> Adicionar um Cadastro"
					+ "\n2> Remover um Cadastro"
					+ "\n3> Buscar um Cadastro"
					+ "\n4> Finalizar o programa");

			opcao = retornarOpcao();
			
			switch (opcao){

			case 1: trie.adicionarChave(requisitarNome(), ultimoRA++); break;
			case 2: trie.removerChave(requisitarNome()); break;
			case 3: trie.buscarChave(requisitarNome()); break;
			case 4: System.exit(0); break;
			}
		}
		
		//trie.adicionarChave("Marcos", 0);
		//trie.buscarChave("Marcos");		
	}

	//---------------------------------------------------------//

	public static int retornarOpcao(){

		int opcao = -1;

		while(true){
			
			try{
				
				System.out.print("\n\nInsira a opcao: ");
				opcao = entrada.nextInt(); 

				if (opcao < 0 || opcao > 4)
					System.out.print("Você inseriu um valor invalido. Insira um valor entre 1 e 4");
				else return opcao;
			}
			catch(InputMismatchException e){System.err.print("Você inseriu um valor invalido. Insira um valor entre 1 e 4"); entrada.next();}
			catch(Exception e){System.err.print("Uma excecao nao esperada correu com o programa");}
		}
	}

	//---------------------------------------------------------//

	public static String requisitarNome(){

		String nome = "";
		
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader buffer = new BufferedReader(input);

		while(true){
			
			try{
				
				System.out.print("Insira o nome: ");
				//nome = entrada.next();
				nome = buffer.readLine();
			}
			catch(InputMismatchException e){System.err.println("Você inseriu um caractere invalido"); entrada.next();}
			catch(Exception e){System.err.println("Uma excecao nao esperada correu com o programa");}

			return nome;
		}
	}
}