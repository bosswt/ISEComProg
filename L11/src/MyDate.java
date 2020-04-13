public class MyDate {

    // Attributes
    private int year;
    private int month;
    private int day;
    private static final String[] strMonths = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug",
            "Sep", "Oct", "Nov", "Dec" };
    private static final String[] strDays = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday",
            "Friday", "Saturday" };
    private static final int[] daysInMonths = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    // Methods
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static boolean isValidDate(int year, int month, int day) {
        return (year >= 1 && year <= 9999) && (month >= 1 && month <= 12)
                && (day >= 1 && day <= ((month == 2 && MyDate.isLeapYear(year)) ? 29 : MyDate.daysInMonths[month - 1]));
    }

    public static int getDayOfWeek(int year, int month, int day) {
        return DayOfWeek.getDayOfWeek(day, month, year);
    }

    public MyDate(int year, int month, int day) {
        this.setDate(year, month, day);
    }

    public void setDate(int year, int month, int day) {
        if (!MyDate.isValidDate(year, month, day))
            System.out.println("Invalid year, month, or day!");
        else {
            this.year = year;
            this.month = month;
            this.day = day;
        }
    }

    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }

    public void setYear(int year) throws IllegalArgumentException {
        if (!MyDate.isValidDate(year, this.month, this.day))
            throw new IllegalArgumentException("Invalid year!");
        this.year = year;
    }

    public void setMonth(int month) throws IllegalArgumentException {
        if (!MyDate.isValidDate(this.year, month, this.day))
            throw new IllegalArgumentException("Invalid month!");
        this.month = month;
    }

    public void setDay(int day) throws IllegalArgumentException {
        if (!MyDate.isValidDate(this.year, this.month, day))
            throw new IllegalArgumentException("Invalid day!");
        this.day = day;
    }

    public String toString() {
        return MyDate.strDays[MyDate.getDayOfWeek(this.year, this.month, this.day)] + " " + getDay() + " "
                + MyDate.strMonths[getMonth() - 1] + " " + getYear();
    }

    public MyDate nextDay() {
        if (isValidDate(this.year, this.month, this.day + 1))
            return new MyDate(this.year, this.month, this.day + 1);
        return this.nextMonth();
    }

    public MyDate nextMonth() {
        if (isValidDate(this.year, this.month + 1, 1))
            return new MyDate(this.year, this.month + 1, 1);
        return this.nextYear();
    }

    public MyDate nextYear() {
        return new MyDate(this.year + 1, 1, 1);
    }

    public MyDate previousDay() {
        if (isValidDate(this.year, this.month, this.day - 1))
            return new MyDate(this.year, this.month, this.day - 1);
        else if (isValidDate(this.year, this.month - 1, 1)) {
            return new MyDate(this.year, this.month - 1,
                    ((this.month - 1 == 2 && MyDate.isLeapYear(this.year)) ? 29 : MyDate.daysInMonths[this.month - 2]));
        } else
            return new MyDate(this.year - 1, 12, 31);
    }

    public MyDate previousMonth() {
        if (isValidDate(this.year, this.month - 1, 1))
            return new MyDate(this.year, this.month - 1, 1);
        return new MyDate(this.year - 1, 12, 1);
    }

    public MyDate previousYear() {
        return new MyDate(this.year - 1, 1, 1);
    }
}