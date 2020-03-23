import java.io.*;
import java.util.Scanner;

public class ScoreSort {
	// Do not change main().
	public static void main(String[] args) throws IOException {
		StudentScore[] scores = readScoreFile(); // Read score data from "score.csv" and store the data in an array of
													// StudentScore
		sortByTotal(scores);
		listTop(scores, 25);
	}

	// List neccessary methods here.
	// Do not change method headers.
	public static StudentScore[] readScoreFile() throws IOException {
		Scanner sc = new Scanner(new File("score.csv"));
		sc.useDelimiter("\\r\\n|,");
		sc.nextLine();
		StudentScore[] score = new StudentScore[1000];
		int n = 0;
		while (sc.hasNext()) {
			String data = sc.nextLine();
			score[n++] = new StudentScore(data);
		}
		return score;
	}

	public static void sortByTotal(StudentScore[] data) {
		selectionSort(data);
	}

	public static void listTop(StudentScore[] sortedScores, int n) {
		for (int i = 999; i > 999 - n; i--) {
			if (i == 999)
				sortedScores[i].printScore(true);
			else
				sortedScores[i].printScore(false);
		}
	}

	public static int findMaxIndex(StudentScore[] data, int lastIndex) {
		int maxIndex = 0;
		for (int i = 1; i <= lastIndex; i++) {
			if (data[i].getTotalScore() > data[maxIndex].getTotalScore()) {
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	public static void swapData(StudentScore[] data, int a, int b) {
		StudentScore temp = data[a];
		data[a] = data[b];
		data[b] = temp;
	}

	public static void selectionSort(StudentScore[] data) {
		for (int lastIndex = data.length - 1; lastIndex > 0; lastIndex--) {
			int maxIndex = findMaxIndex(data, lastIndex);
			swapData(data, maxIndex, lastIndex);
		}
	}

}