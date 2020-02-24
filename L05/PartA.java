import java.util.Scanner;

public class PartA {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = kb.nextLine();
        if (username.length() >= 4 && username.length() <= 255) {
            if (Character.isLetter(username.charAt(0))) {
                for (int i = 0; i < username.length(); i++) {
                    if (username.contains(" ") || username.contains("\\"))
                        return;
                    if (i != username.length() - 1) {
                        if (username.charAt(i) == '.' && username.charAt(i) == username.charAt(i + 1)) {
                            return;
                        }
                    }
                }
                System.out.print("Enter password: ");
                String password = kb.nextLine();
                if (password.length() >= 4 && password.length() <= 255) {
                    if (password.toLowerCase().contains(username.toLowerCase()))
                        return;
                    int numcount = 0;
                    int symcount = 0;
                    for (int i = 0; i < password.length(); i++) {
                        if (password.contains("*") || password.contains(" ") || password.contains("\\"))
                            return;
                        if (password.length() < 8) {

                            if (Character.isDigit(password.charAt(i)))
                                numcount++;
                            if (password.contains("!") || password.contains("@") || password.contains("#")
                                    || password.contains("$") || password.contains("%"))
                                symcount++;
                        }
                    }
                    if (password.length() < 8) {
                        if (numcount < 2 || symcount < 1)
                            return;
                    }
                    System.out.print("Re-enter password: ");
                    String repwd = kb.nextLine();
                    if (repwd.equals(password))
                        System.out.print("Account has successfully been created.");
                    else
                        return;
                }
            }
        }
    }
}