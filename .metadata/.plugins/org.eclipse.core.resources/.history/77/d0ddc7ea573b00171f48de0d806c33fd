package mainProgram;

import ordenacaoVetores.OrdenacaoQuicksort;

public class Lista04 {

	public static void main(String[] args) {

		System.out.println("***Ordenação Quicksort***\n");
		double tempoInicial = System.currentTimeMillis();
		//int[] vetor = {96,1,59,35,81,58,16,55,84,61,87,83};

		OrdenacaoQuicksort quickSort = new OrdenacaoQuicksort(10);
		quickSort.getVetor().preencherAleatorio(1000);

		System.out.print("\nVetor aleatorio: ");
		quickSort.getVetor().printVetor();  

		quickSort.ordenar(0, 9); 
		System.out.print("Vetor ordenado: ");
		quickSort.getVetor().printVetor(); 

		System.out.printf("\nNumero de comparacoes: %d\nNumero de trocas: %d", quickSort.getComparacoes(), quickSort.getTrocas());
		System.out.println("\nDuracao da ordenacao: " + (System.currentTimeMillis() - tempoInicial) + " ms.");
	}
}