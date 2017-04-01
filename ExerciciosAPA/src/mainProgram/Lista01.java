package mainProgram;

import java.util.InputMismatchException;
import java.util.Scanner;

import custom.Exceptions.OutOfBoundsException;
import lista01.Exercicio01.Somatorios;
import lista01.Exercicio02.Produtorios;
import lista01.Exercicio03.VetorParImpar;
import lista01.Exercicio04.alternandoNumeros;
import lista01.Exercicio05.QuantParImpar;
import lista01.Exercicio06.MatrizDiags;
import lista01.Exercicio07.MatrizTransposta;
import lista01.Exercicio08.SomaAbaixoDiag;
import lista01.Exercicio09.MultiplicacaoMatriz;
import lista01.Exercicio10.Cinema;
import lista01.Exercicio11.Cidades;

public class Lista01 {

	static Scanner entrada = new Scanner(System.in);
	
	public static void main(String[] args) {


		System.out.println("Informe qual exercicio você deseja rodar:\n"
				+ "1  -> Calculo de somatórios\n"
				+ "2  -> Calculo de produtórios\n"
				+ "3  -> Vetor de numeros aleatorios\n"
				+ "4  -> Vetor numeros aleatorios alternados\n"
				+ "5  -> Elementos pares e impares em vetor\n"
				+ "6  -> Diagonal Principal e Secundária de matriz aleatória\n"
				+ "7  -> Matriz transposta de uma matriz aleatória\n"
				+ "8  -> Somar elementos abaixo da diagonal principal de uma matriz aleatória\n"
				+ "9  -> Multiplicação de matrizes aleatórias\n"
				+ "10 -> Venda de ingressos em sala de cinema\n"
				+ "11 -> Distance entre estradas de cidades vizinhas\n");

		int opcao = leituraOpcao(1, 11);
		escolherAtividade(opcao);
	}


	/*<--------------------------------------------------------------------------------------->*/


	public static void escolherAtividade (int opcao){

		int atividade;

		switch (opcao){

		case 1:

			System.out.println("\n**Insira o exercício (de 1 a 3) a ser inicializado**");
			atividade = leituraOpcao(1, 4);

			switch(atividade){
			case 1: Somatorios somatorio1 = new Somatorios(); somatorio1.somatorioA(); break;
			case 2: Somatorios somatorio2 = new Somatorios(); somatorio2.somatorioB(); break;
			case 3: Somatorios somatorio3 = new Somatorios(); somatorio3.somatorioC(); break;
			}
			break;

		case 2:

			System.out.println("\n**Insira o exercício (de 1 a 3) a ser inicializado**");
			atividade = leituraOpcao(1, 4);

			switch(atividade){
			case 1: Produtorios produtorio1 = new Produtorios(); produtorio1.produtorioA(); break;
			case 2: Produtorios produtorio2 = new Produtorios(); produtorio2.produtorioB(); break;
			case 3: Produtorios produtorio3 = new Produtorios(); produtorio3.produtorioC(); break;
			}
			break;


		case 3: VetorParImpar parImpar = new VetorParImpar(10); parImpar.getVetorInt().preencherAleatorio(); parImpar.parImpar(); break;

		case 4: alternandoNumeros alternando = new alternandoNumeros(10); alternando.printVetor(); alternando.flipFlop(); alternando.printVetor(); break;

		case 5: QuantParImpar quanParImpar = new QuantParImpar(10); quanParImpar.printVetor(); quanParImpar.countParImpar(); break;

		case 6: MatrizDiags diagonais = new MatrizDiags(10); diagonais.printMatriz(); diagonais.diagPri(); diagonais.diagSec(); break;

		case 7: MatrizTransposta transposta = new MatrizTransposta(5); transposta.gerarTransposta(); break;

		case 8: SomaAbaixoDiag abaixoDiag = new SomaAbaixoDiag(10); abaixoDiag.printMatriz(); abaixoDiag.somaElementos(); break;

		case 9: MultiplicacaoMatriz multiplicacaoMatriz = new MultiplicacaoMatriz(3); multiplicacaoMatriz.prodMatriz(); break;

		case 10: Cinema salaCinema = new Cinema(); salaCinema.novaCompra(); salaCinema.printMatrix(); salaCinema.totalTicket(); break;

		case 11: Cidades estradaCidades = new Cidades(4); estradaCidades.printMatriz(); estradaCidades.checarDistancia(3, 4); break;
		}

	}

	
	/*<--------------------------------------------------------------------------------------->*/
	
	
	public static int leituraOpcao(int min, int max) {

		int exercicio = 0;
		boolean repeate = true;

		while (repeate == true){

			try {

				System.out.print("Opcao: ");
				exercicio = entrada.nextInt();					

				if (exercicio < min || exercicio > max){
					throw new OutOfBoundsException();
				}

				repeate = false;
			} 
			catch (OutOfBoundsException e){}
			catch (InputMismatchException e){ System.out.println("Você inseriu um caractere invalido. Insira um exercício válido"); entrada.next();}
			catch(Exception e){ e.printStackTrace();}

		}

		return exercicio;
	}
}