package pacoteFuncionarios;

public class Vendedor extends Funcionario {

	int salario = 0;
	
	public Vendedor (){

		QuantFuncionario++;
		custoTotal += salario;
	}
}
