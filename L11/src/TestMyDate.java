
public class TestMyDate {
    public static void main(String[] args) {
        MyDate d1 = new MyDate(2012, 2, 28);
        System.out.println(d1); // Tuesday 28 Feb 2012
        System.out.println(d1.nextDay()); // Wednesday 29 Feb 2012
        System.out.println(d1.nextMonth()); // Thursday 1 Mar 2012 – must be “Day 1st”
        System.out.println(d1.nextYear()); // Tuesday 1 Jan 2013 – must be “Jan 1”

        MyDate d2 = new MyDate(2012, 1, 2);
        System.out.println(d2); // Monday 2 Jan 2012
        System.out.println(d2.previousDay()); // Sunday 1 Jan 2012
        System.out.println(d2.previousMonth()); // Thursday 1 Dec 2011
        System.out.println(d2.previousYear()); // Saturday 1 Jan 2011

        MyDate d3 = new MyDate(2012, 2, 29);
        System.out.println(d3.previousYear()); // Saturday 1 Jan 2011

        MyDate d4 = new MyDate(2099, 11, 31); // Invalid year, month, or day!
        MyDate d5 = new MyDate(2011, 2, 29); // Invalid year, month, or day!

    }
}