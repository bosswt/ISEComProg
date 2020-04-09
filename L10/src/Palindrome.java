import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(check(str));
    }

    public static boolean check(String str) {
        if (str.length() < 2)
            return true;
        return (str.substring(0, 1).equals(str.substring(str.length() - 1)))
                && check(str.substring(1, str.length() - 1));
    }
}