import java.util.Scanner;

public class Recursive {
    static double[] num = new double[501];
    static int called = 0;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println("f(" + n + ") :" + computeF(n));
        System.out.println("Called: " + called + " times");
    }

    public static double computeF(int n) {
        called++;
        if (n < 3)
            return 1;
        if (num[n] != 0)
            return num[n];
        num[n] = computeF(n - 1) + computeF(n - 2) + computeF(n - 3);
        return num[n];
    }
}