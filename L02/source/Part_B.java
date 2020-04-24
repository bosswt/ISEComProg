import java.lang.Math;

public class Part_B {
    public static void main(String[] args) {
        int a = 1;
        int b = -5;
        int c = 4;
        double ans1 = ((-1 * b) + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
        double ans2 = ((-1 * b) - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
        System.out.println(ans1);
        System.out.println(ans2);
    }
}