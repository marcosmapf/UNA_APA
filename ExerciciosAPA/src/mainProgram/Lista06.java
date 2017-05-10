package mainProgram;

import java.util.Scanner;
import ordenacaoVetores.OrdenacaoHeapsort;

public class Lista06 {

	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {

		double tempoInicial = System.currentTimeMillis();

		OrdenacaoHeapsort heapsort = new OrdenacaoHeapsort(10);
		heapsort.getVetor().preencherAleatorio(1000);

		System.out.print("\nVetor aleatorio: ");
		heapsort.getVetor().printVetor();  

		heapsort.ordenar(); 
		System.out.print("Vetor ordenado: ");
		heapsort.getVetor().printVetor(); 

		//System.out.printf("\nNumero de comparacoes: %d\nNumero de trocas: %d", heapsort.getComparacoes(), heapsort.getTrocas());
		//System.out.println("\nDuracao da ordenacao: " + (System.currentTimeMillis() - tempoInicial) + " ms.");
	}
}