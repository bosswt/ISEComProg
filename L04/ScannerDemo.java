import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int x = kb.nextInt();
        double y = kb.nextDouble();
        System.out.println(x * y);
        kb.close();
    }
}