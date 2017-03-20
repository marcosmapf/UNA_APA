package customExceptions;

public class OutOfBoundsException extends Exception {

	private static final long serialVersionUID = 1L;

	public OutOfBoundsException() {

		System.out.println("O valor inserido não é válido, tente novamente \n");
		
	}
}
