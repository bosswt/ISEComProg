import java.util.Scanner;
import java.io.*;

public class ScoreLookup {
	public static void main(String[] args) throws IOException {
		String lookupString = constructLookupStringFromFile("score.csv");
		boolean toQuit = false;
		do {
			char choice = showMainMenu();
			switch (choice) {
				case 'L':
					commenceLookUpProcedure(lookupString);
					break;
				case 'Q':
					toQuit = true;
					break;
				default:
					System.out.println("Invalid choice. Quitting.");
					toQuit = true;
			}
		} while (!toQuit);
	}

	// Add static methods here.
	// The methods include, but not limited to
	// - constructLookUpStringFromFile(String)
	// - showMainMenu()
	// - commenceLookUpProcedure(String)
	public static String constructLookupStringFromFile(String a) throws IOException {
		Scanner sc = new Scanner(new File(a));
		sc.useDelimiter("\\r\\n|,");
		sc.nextLine();
		String score = "";
		while (sc.hasNext()) {
			String id = sc.next();
			int q1 = sc.nextInt();
			int q2 = sc.nextInt();
			int q3 = sc.nextInt();
			int q4 = sc.nextInt();
			int q5 = sc.nextInt();
			score += id + " " + q1 + " " + q2 + " " + q3 + " " + q4 + " " + q5 + ";";
		}
		return score;
	}

	public static char showMainMenu() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Main Menu");
		System.out.println("L) Look up score");
		System.out.println("Q) Quit");
		System.out.print(">>> ");
		char input = kb.next().charAt(0);
		return input;
	}

	public static void commenceLookUpProcedure(String x) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter Student ID: ");
		String lookup = kb.next();
		int startIndex = x.indexOf(lookup);
		int endIndex = x.indexOf(";", startIndex);
		String z = x.substring(startIndex, endIndex);
		Scanner as = new Scanner(z);
		String id = as.next();
		int q1 = as.nextInt();
		int q2 = as.nextInt();
		int q3 = as.nextInt();
		int q4 = as.nextInt();
		int q5 = as.nextInt();
		System.out.println("           Q1  Q2  Q3  Q4  Q5  TOTAL");
		System.out.println(
				id + "  " + q1 + "   " + q2 + "   " + q3 + "   " + q4 + "   " + q5 + "   " + (q1 + q2 + q3 + q4 + q5));
	}

}