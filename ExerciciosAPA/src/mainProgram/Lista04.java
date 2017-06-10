package mainProgram;

import java.util.InputMismatchException;
import java.util.Scanner;

import custom.Exceptions.OutOfBoundsException;
import ordenacaoVetores.OrdenacaoQuicksort;

public class Lista04 {

	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {

		while(true){

			System.out.println("***Ordena��o Quicksort***\n");

			//int[] vetor = {96,1,59,35,81,58,16,55,84,61,87,83};
			int tamanho = requisitarTamanho();
			double tempoInicial = System.currentTimeMillis();

			OrdenacaoQuicksort quickSort = new OrdenacaoQuicksort(tamanho);
			quickSort.getVetor().preencherAleatorio(1000);

			System.out.print("\nVetor aleatorio: ");
			quickSort.getVetor().printVetor();  

			quickSort.ordenar(0, tamanho-1); 
			System.out.print("Vetor ordenado: ");
			quickSort.getVetor().printVetor(); 

			System.out.printf("\nNumero de comparacoes: %d\nNumero de trocas: %d", quickSort.getComparacoes(), quickSort.getTrocas());
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
			catch (InputMismatchException e){ System.out.println("Voc� inseriu um caractere invalido. Insira um exerc�cio v�lido"); entrada.next();}
			catch(Exception e){ e.printStackTrace();}
		}
	}
}