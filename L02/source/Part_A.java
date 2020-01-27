public class Part_A {
    public static void main(String[] args) {
        double a = 1;
        double b = -5;
        double c = 4;
        double ans1 = ((-1 * b) + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
        double ans2 = ((-1 * b) - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
        System.out.println(ans1);
        System.out.println(ans2);
    }
}