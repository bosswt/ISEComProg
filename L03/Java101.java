import java.util.Scanner;

public class Java101{
	public static double readDoubleFromKeyboard(String prompt){
		Scanner sc = new Scanner(System.in);
		System.out.print(prompt+":");
		double d = sc.nextDouble();
		return d;
	}
	public static String typeOf(byte b){
		return "byte";
	}
	public static String typeOf(short s){
		return "short";
	}
	public static String typeOf(int i){
		return "int";
	}
	public static String typeOf(long l){
		return "long";
	}
	public static String typeOf(boolean b){
		return "boolean";
	}
	public static String typeOf(float f){
		return "float";
	}
	public static String typeOf(double d){
		return "double";
	}
	public static String typeOf(char c){
		return "char";
	}
	public static String typeOf(String s){
		return "String";
	}
	public static String typeOf(Object o){
		return "Non-primitive";
	}

	public static void showRomanNumber(int i){
		if(i<1||i>10){
			System.out.println("Java101.showRomanNumber() says \"The input is out-of-range.\"");
			return;
		}
		System.out.println("--------");
		switch(i){
			case 1:
				System.out.println("|    I |");
				break;
			case 2:
				System.out.println("|   II |");
				break;
			case 3:
				System.out.println("|  III |");
				break;
			case 4:
				System.out.println("|   IV |");
				break;
			case 5:
				System.out.println("|    V |");
				break;
			case 6:
				System.out.println("|   VI |");
				break;
			case 7:
				System.out.println("|  VII |");
				break;
			case 8:
				System.out.println("| VIII |");
				break;
			case 9:
				System.out.println("|   IX |");
				break;
			case 10:
				System.out.println("|    X |");
				break;	
		}
		System.out.println("--------");
	} 

	public static void showRomanNumber(double d){
		System.out.println("Java101.showRomanNumber() only processes int input!");
	}
}
