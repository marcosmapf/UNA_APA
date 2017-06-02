package analisadorLexico;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		Analisador geradorToken = new Analisador();
		geradorToken.readFile();
		
	}
}

/* 
Token AND = new Token_AND();
Token Atribuicao = new Token_Atribuicao();
Token Cadeia_Caracteres = new Token_Cadeia_Caracteres();
Token Caracter = new Token_Caracter();
Token Comentario_Linha = new Token_Comentario_Linha();
Token Comparacao = new Token_Comparacao();
Token Divisao = new Token_Divisao();
Token Enquanto = new Token_Enquanto();
Token Entrada_Padrao = new Token_Entrada_Padrao();
Token Fim_Comando = new Token_Fim_Comando();
Token Fim_Comentario_Paragrafo = new Token_Fim_Comentario_Paragrafo();
Token Fim_Escopo = new Token_Fim_Escopo();
Token Fim_Parametro = new Token_Fim_Parametro();
Token Identificador = new Token_Identificador();
Token Inicio_Comentario_Paragrafo = new Token_Inicio_Comentario_Paragrafo();
Token Inicio_Escopo = new Token_Inicio_Escopo();
Token Inteiro = new Token_Inteiro();
Token Maior_Igual = new Token_Maior_Igual();
Token Maior = new Token_Maior();
Token Menor_Igual = new Token_Menor_Igual();
Token Menor = new Token_Menor();
Token Multiplicacao = new Token_Multiplicacao();
Token Not = new Token_NOT();
Token Or = new Token_OR();
Token Para = new Token_Para();
Token Potencia = new Token_Potencia();
Token Principal = new Token_Principal();
Token Real = new Token_Real();
Token Resto_Divisao = new Token_Resto_Divisao();
Token Retorno_Funcao = new Token_Retorno_Funcao();
Token Saida_Padrao = new Token_Saida_Padrao();
Token Se = new Token_Se();
Token Senao = new Token_Senao();
Token Soma = new Token_Soma();
Token Subtracao = new Token_Subtracao();
Token Tipo = new Token_Tipo();
Token Virgula = new Token_Virgula();
*/