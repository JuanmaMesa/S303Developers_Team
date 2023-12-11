
import java.util.InputMismatchException;
import java.util.Scanner;

public class Input{

	public static Scanner input() {

		return new Scanner(System.in);
	}
	
	public static byte llegirByte(String msj) throws InputMismatchException {
		Object num;
		byte numCorrecto;
		System.out.print(msj);
		
		num = input().nextByte();
		numCorrecto = (byte) num;
		
		return numCorrecto;
	}

	public static int llegirInt(String msj) throws InputMismatchException{
		Object obj;
		int num;
		
		System.out.print(msj);
		obj = input().nextInt();
		num = (int) obj;
		
		return num;
	}
	

	public static double llegirDouble(String msj) throws InputMismatchException{
		Object obj;
		double num;
		
		System.out.print(msj);
		obj = input().nextDouble();
		num = (double) obj;

		return num;
	}
	

	public static String llegirString(String msj) {
	
		System.out.print(msj);
		String texto = input().nextLine();

		return texto;
	}
	
}