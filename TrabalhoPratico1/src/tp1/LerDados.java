package tp1;

import java.util.Scanner;

public class LerDados {
	public static String lerString() {
		Scanner leitor = new Scanner(System.in);
		return leitor.nextLine();
	}
	
	public static int lerInt(int argumento) {
		try {
			Scanner leitor = new Scanner(System.in);
			argumento = leitor.nextInt();
		} catch (java.util.InputMismatchException exception) {
			System.out.print(">Digite um valor válido: ");
			argumento = lerInt(argumento);
		}
		return argumento;
	}
	
	public static double lerDouble(double argumento) {
		try {
			Scanner leitor = new Scanner(System.in);
			argumento = leitor.nextDouble();
		} catch (java.util.InputMismatchException exception) {
			System.out.print(">Digite um valor válido: ");
			argumento = lerDouble(argumento);
		}
		return argumento;
	}
	
	public static char lerChar(char argumento) {
		try {
			Scanner leitor = new Scanner(System.in);
			argumento = leitor.next().charAt(0);
		} catch (java.util.InputMismatchException exception) {
			System.out.print(">Digite um valor válido: ");
			argumento = lerChar(argumento);
		}
		return argumento;
	}

}
