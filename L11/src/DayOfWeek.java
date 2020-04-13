public class DayOfWeek {

	public static void main(String[] args) {
		int dow = getDayOfWeek(1,1,2014);
		System.out.println(dow);
	}

	public static int getDayOfWeek(int day, int month, int year) {
		int dow = 0;
		int[] centuryIndex = { 6, 4, 2, 0 };
		int[] nonLeapYearMonthIndex = { 0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5 };
		int[] leapYearMonthIndex = { 6, 2, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5 };

		int year1 = (int) Math.floor(year / 100.0);
		int year2 = year % 100;
		int centuryNum = centuryIndex[(year1 % 4)];

		int monthNum = nonLeapYearMonthIndex[month-1];
		if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
			monthNum = leapYearMonthIndex[month-1];
		}

		dow = (centuryNum + year2 + (int) Math.floor(year2 / 4) + monthNum + day) % 7;
		return dow;
	}
}
