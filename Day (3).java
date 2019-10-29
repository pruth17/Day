public class Day {

	private final int date;
	private final int month;
	private final int year;
	private static final int[] datesInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int GeorgianStartdate = 15;
	private static final int GeorgianStartMonth = 10;
	private static final int GeorgianStartYear = 1582;
	private static final int JulianEnddate = 4;
	private static final int January = 1;
	private static final int February = 2;
	private static final int December = 12;
	private static final String[] months = { "January", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December" };

	/**
	 * 
	 * 
	 * @param date  0 between 1 and 31 (inclusive).
	 * @param month between 1 and 12 (inclusive).
	 * @param year  any number except 0. This function is the constructor. It
	 *              constructs an object with the following date, month, year that
	 *              are passed on as the parameter. Julian Calendar was used before
	 *              October 15, 1582 and after that date Georgian calendar was used.
	 * @precondition year != 0, 0 < date < 28,29,30 or 31(depending on the month), 0
	 *               < month < 12.
	 * @postcondition Guaranteeing the user that the Day object will be created.
	 */
	public Day(int year1, int month1, int date1) {
		assert year1 != 0 : "Year can't be zero.";
		assert month1 > 0 && month1 < 13 : "Month can be only be between 1 and 12.";
		assert date1 > 0 && date1 <= datesInAMonth(year1, month1) : "Date can be between 1 and "
				+ datesInAMonth(year1, month1) + " only.";

		this.year = year1;
		this.date = date1;
		this.month = month1;

	}

	/**
	 * This function returns the date in the object.
	 * 
	 * @return the date.
	 * @postcondition date will be returned after the method is called.
	 */
	public int getdate() {
		return this.date;
	}

	/**
	 * This function returns the month in the object.
	 * 
	 * @return the month.
	 * @postcondition month will be returned after the method is called.
	 */

	public int getMonth() {
		return this.month;
	}

	/**
	 * This function returns the year in the object.
	 * 
	 * @return the year.
	 * @postcondition year will be returned after the method is called.
	 */
	public int getYear() {
		return this.year;
	}

	/**
	 * This function calculates the next date from the current date.
	 * 
	 * @return the date following this date.
	 */

	private Day nextdate() {
		int d = this.date;
		int m = this.month;
		int y = this.year;

		if (y == GeorgianStartYear && m == GeorgianStartMonth && d == JulianEnddate)
			d = GeorgianStartdate;

		else if (d < datesInAMonth(y, m)) {
			d++;
		}

		else {
			d = 1;
			m++;
			if (m > December) {
				m = January;
				y++;
				if (y == 0)
					y++;
			}

		}
		return new Day(y, m, d);

	}

	/**
	 * 
	 * @param y year
	 * @param m month
	 * @return returns the number of days in m month
	 */
	private static int datesInAMonth(int y, int m) {

		int dates = datesInMonth[m - 1];
		if (isLeapYear(y) & m == February)
			dates++;

		return dates;

	}

	/**
	 * 
	 * @param y year
	 * @return true if y is a leap year, otherwise false
	 */
	private static boolean isLeapYear(int y) {
		if (y % 4 != 0)
			return false;
		if (y < GeorgianStartYear)
			return false;
		return ((y % 100) != 0 || (y % 400 == 0));
	}

	/**
	 * Calculates the previous day
	 * 
	 * @return Day which was previous of this day
	 */
	private Day previousdate() {
		int d = this.date;
		int m = this.month;
		int y = this.year;

		if (y == GeorgianStartYear && m == GeorgianStartMonth && d == JulianEnddate)
			d = JulianEnddate;
		else if (d > 1)
			d--;
		else {
			m--;
			if (m < January) {
				m = December;
				y--;
				if (y == 0)
					y--;
			}
			d = datesInAMonth(y, m);

		}
		return new Day(y, m, d);

	}

	/**
	 * Compares this day with 'a' day
	 * 
	 * @param a day
	 * @return a positive number if this day comes after 'a' day negative if this
	 *         day comes after before 'a' day zero if both are identical days
	 */
	private int compareTo(Day a) {
		if (this.year > a.year)
			return 1;
		if (this.year < a.year)
			return -1;
		if (this.month > a.month)
			return 1;
		if (this.month < a.month)
			return -1;
		return this.date - a.date;
	}

	/**
	 * day object is returned that is certain number of day away from the current
	 * day
	 * 
	 * @param n the number of day.
	 * @return a day object that is n days away from the current one
	 * @postcondition guaranteed that n days will be added to the current day and returned.
	 */
	public Day addDays(int n) {

		Day result = this;
		while (n > 0) {
			result = result.nextdate();
			n--;
		}
		while (n < 0) {
			result = result.previousdate();
			n++;
		}

		return result;
	}

	/**
	 * 
	 * @param other the day object
	 * @return the number of days that the current day is away from other
	 * @postcondition will return the number of days that current day is away from other
	 */
	public int daysFrom(Day other) {
		int temp = 0;
		Day d = this;

		while (d.compareTo(other) > 0) {
			d = d.previousdate();
			temp++;
		}
		while (d.compareTo(other) < 0) {
			d = d.nextdate();
			temp--;
		}
		return temp;
	}

	/**
	 * Prints this day object In Month day, year format.
	 * @postcondition will print the current day to the console.
	 */
	public void print() {
		String currentMonth = Day.months[this.month - 1];

		System.out.println(currentMonth + " " + this.date + ", " + this.year);
	}
	/**
	 * 
	 * @param d2 the other day
	 * @return true if this day and d2 day are equal.
	 * @postcondition will return true if both the object have same date, month and year.
	 */
	
	public boolean equal(Day d2 ){
		if(this.date == d2.getdate() && this.month == d2.getMonth() && this.year == d2.getYear())
			return true;
		else
			return false;
		
	}


}
