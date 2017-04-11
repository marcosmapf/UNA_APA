package mainProgram;

import ordenacaoVetores.OrdenacaoSelecao;

public class Lista03 {

	public static void main(String[] args) {

		double tempoInicial = System.currentTimeMillis();
		OrdenacaoSelecao selecao = new OrdenacaoSelecao(10);
		
		System.out.print("\nVetor aleatorio: ");
		selecao.getVetor().printVetor();  

		selecao.ordenar(); 
		System.out.print("Vetor ordenado: ");
		selecao.getVetor().printVetor(); 

		System.out.printf("\nNumero de comparacoes: %d\nNumero de trocas: %d", selecao.comparacoes, selecao.trocas);
		System.out.println("\nDuracao da ordenacao: " + (System.currentTimeMillis() - tempoInicial) + " ms.");

	}
}
