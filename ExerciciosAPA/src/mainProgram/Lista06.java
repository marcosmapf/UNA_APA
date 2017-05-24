package mainProgram;

import java.util.InputMismatchException;
import java.util.Scanner;

import custom.Exceptions.OutOfBoundsException;
import ordenacaoVetores.OrdenacaoHeapsort;

public class Lista06 {

	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {

		while(true){
			System.out.println("***Ordenação Quicksort***\n");

			//int[] vetor = {96,1,59,35,81,58,16,55,84,61,87,83};
			int tamanho = requisitarTamanho();
			double tempoInicial = System.currentTimeMillis();

			OrdenacaoHeapsort heapsort = new OrdenacaoHeapsort(tamanho);
			heapsort.getVetor().preencherAleatorio(100);

			System.out.print("\nVetor aleatorio: ");
			heapsort.getVetor().printVetor();  

			heapsort.ordenar(); 
			System.out.print("Vetor ordenado: ");
			heapsort.getVetor().printVetor(); 

			System.out.printf("\nNumero de comparacoes: %d\nNumero de trocas: %d", heapsort.getComparacoes(), heapsort.getTrocas());
			System.out.println("\nDuracao da ordenacao: " + (System.currentTimeMillis() - tempoInicial) + " ms.\n");
		}
	}


	/*<--------------------------------------------------------------------------------------->*/


	public static int requisitarTamanho(){

		int tamanho = 0;

		while (true){

			try {

				System.out.print("Informe o tamanho do vetor: ");
				tamanho = entrada.nextInt();

				if (tamanho < 5 || tamanho > 13000){
					throw new OutOfBoundsException();
				}

				return tamanho;
			} 
			catch (OutOfBoundsException e){}
			catch (InputMismatchException e){ System.out.println("Você inseriu um caractere invalido. Insira um exercício válido"); entrada.next();}
			catch(Exception e){ e.printStackTrace();}
		}
	}
}