package mainProgram;

import ordenacaoVetores.OrdenacaoQuickSort;

public class Lista04 {

	public static void main(String[] args) {

		double tempoInicial = System.currentTimeMillis();

		OrdenacaoQuickSort quickSort = new OrdenacaoQuickSort(10);
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
