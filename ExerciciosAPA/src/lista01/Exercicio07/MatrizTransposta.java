package lista01.Exercicio07;

import custom.Objects.MatrizInt;

public class MatrizTransposta {

	/* 
	 * Escreva um algoritmo que preencha uma matriz 5 x 5 com números inteiros gerados
	 * randomicamente. O algoritmo deve apresentar a transposta da matriz gerada. Exemplo:
	 */


	private MatrizInt matrizNumeros;
	private MatrizInt matrizTransposta;

	public MatrizTransposta(int tamanho){

		this.matrizNumeros = new MatrizInt(tamanho);
		this.matrizNumeros.preencherAleatorio(200);
	}

	public MatrizTransposta(int[][] matriz){

		this.matrizNumeros = new MatrizInt(matriz);

		System.out.println("\nA matriz inserida é:\n");
		this.matrizNumeros.printMatriz();
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void gerarTransposta(){

		this.matrizTransposta = new MatrizInt(this.matrizNumeros.getTamanhoMatriz());

		for (int i = 0; i < this.matrizNumeros.getTamanhoMatriz(); i ++){
			for (int j = 0; j < this.matrizNumeros.getTamanhoMatriz(); j++){

				matrizTransposta.setValor(i, j, this.matrizNumeros.getValor(j, i));
			}
		}
	}


	/*<--------------------------------------------------------------------------------------->*/


	public MatrizInt getMatrizInt() {

		return this.matrizNumeros;
	}

	public MatrizInt getMatrizTransposta(){

		try {

			if (matrizTransposta == null){

				throw new NullPointerException();
			}
			return this.matrizTransposta;
		}
		catch (NullPointerException e){

			System.out.println("A matriz transposta ainda não foi gerada\n");
			this.matrizTransposta = new MatrizInt(matrizNumeros.getTamanhoMatriz());
			return matrizTransposta;
		}
	}

	/*<--------------------------------------------------------------------------------------->*/
}