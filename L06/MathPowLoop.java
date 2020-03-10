import java.util.Scanner;
public class MathPowLoop{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("a=");
		double a = sc.nextDouble();
		System.out.print("b=");
		int b = sc.nextInt();
		double result1 = Math.pow(a,b);
		double result2;
		// result2 = ..
		System.out.println("Math.pow("+a+","+b+") = "+result1);
		System.out.println("Your loop a^b = "+result2);
	}
}