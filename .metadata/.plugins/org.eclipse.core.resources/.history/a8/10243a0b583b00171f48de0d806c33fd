package mainProgram;

import java.util.Scanner;
import ordenacaoVetores.OrdenacaoHeapsort;

public class Lista06 {

	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("***Ordenação Quicksort***\n");
		double tempoInicial = System.currentTimeMillis();
		//int[] vetor = {96,1,59,35,81,58,16,55,84,61,87,83};
		
		OrdenacaoHeapsort heapsort = new OrdenacaoHeapsort(12);
		heapsort.getVetor().preencherAleatorio(100);

		System.out.print("\nVetor aleatorio: ");
		heapsort.getVetor().printVetor();  

		heapsort.ordenar(); 
		System.out.print("Vetor ordenado: ");
		heapsort.getVetor().printVetor(); 

		System.out.printf("\nNumero de comparacoes: %d\nNumero de trocas: %d", heapsort.getComparacoes(), heapsort.getTrocas());
		System.out.println("\nDuracao da ordenacao: " + (System.currentTimeMillis() - tempoInicial) + " ms.");
	}
}