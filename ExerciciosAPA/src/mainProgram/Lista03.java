package mainProgram;

import ordenacaoVetores.OrdenacaoSelecao;

public class Lista03 {

	public static void main(String[] args) {

		double tempoInicial = System.currentTimeMillis();
		//int[] vetor = {1,2,3,4,5,6,7,8,9,10};
		//int[] vetor = {10,9,8,7,6,5,4,3,2,1};
		//OrdenacaoSelecao bolha = new OrdenacaoSelecao(vetor);

		OrdenacaoSelecao selecao = new OrdenacaoSelecao(10);
		selecao.getVetor().preencherAleatorio(1000);

		System.out.print("\nVetor aleatorio: ");
		selecao.getVetor().printVetor();  

		selecao.ordenar(); 
		System.out.print("Vetor ordenado: ");
		selecao.getVetor().printVetor(); 

		System.out.printf("\nNumero de comparacoes: %d\nNumero de trocas: %d", selecao.getComparacoes(), selecao.getTrocas());
		System.out.println("\nDuracao da ordenacao: " + (System.currentTimeMillis() - tempoInicial) + " ms.");
	}
}
