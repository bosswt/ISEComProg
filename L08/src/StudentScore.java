public class StudentScore {
	public String id;
	public int[] scores;

	public StudentScore(String csvLine) {
		String[] tokens = csvLine.split(",");
		scores = new int[tokens.length - 1];
		id = tokens[0];
		for (int i = 0; i < scores.length; i++) {
			scores[i] = Integer.parseInt(tokens[i + 1]);
		}
	}

	public int getScore(int n) {
		if (n < 0 || n >= scores.length) {
			return -1;
		} else {
			return scores[n];
		}
	}

	public int getTotalScore() {
		int total = 0;
		for (int i = 0; i < scores.length; i++) {
			total += scores[i];
		}
		return total;
	}

	public void printScore(boolean withHeader) {
		if (withHeader) {
			System.out.print("Student ID");
			for (int i = 0; i < scores.length; i++) {
				System.out.print("\tQ" + i);
			}
			System.out.println("\tTotal");
		}
		System.out.print(id);
		for (int i = 0; i < scores.length; i++) {
			System.out.print("\t" + scores[i]);
		}
		System.out.println("\t" + this.getTotalScore());
	}
}