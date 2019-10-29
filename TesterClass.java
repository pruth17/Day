
public class TesterClass extends Day {

	public TesterClass(int year1, int month1, int date1) {
		
		super(year1, month1, date1);
		// TODO Auto-generated constructor stub
	}

	public void testAdd(Day d1) {

		int n = 1000;
		Day d2 = d1.addDays(n);

		if (d2.daysFrom(d1) == n) 
			System.out.println("AddDays function works correctly.");
		else 
			System.out.println("AddDays function doesn't works correctly.");
		
		int m = 1000000;
		Day d3 = d1.addDays(m);
		if (d3.daysFrom(d1) == m) 
			System.out.println("AddDays function works correctly.");
		else 
			System.out.println("AddDays function doesn't works correctly.");
		int o = 0;
		Day d4 = d1.addDays(o);
		if (d4.daysFrom(d1) == o) 
			System.out.println("AddDays function works correctly.");
		else 
			System.out.println("AddDays function doesn't works correctly.");
		int p = -5;
		Day d5 = d1.addDays(p);
		if (d5.daysFrom(d1) == p) 
			System.out.println("AddDays function works correctly.");
		else 
			System.out.println("AddDays function doesn't works correctly.");
		}
	
	public void testDaysFrom(Day d1) {
		Day d2 = new Day(2019,10,15);
		int n = d2.daysFrom(d1);
		Day temp = d1.addDays(n);
		
		if(d2.equal(temp))
			System.out.println("DaysFrom function works correctly.");
		else
			System.out.println("DaysFrom function doesn't works correctly.");
		
		Day d3 = new Day(2020,3,28);
		int m = d3.daysFrom(d1);
		Day temp1 = d1.addDays(m);
		if(d3.equal(temp1))
			System.out.println("DaysFrom function works correctly.");
		else
			System.out.println("DaysFrom function doesn't works correctly.");
		
		Day d4 = new Day(2010,12,3);
		int p = d4.daysFrom(d1);
		Day temp2 = d1.addDays(p);
		if(d4.equal(temp2))
			System.out.println("DaysFrom function works correctly.");
		else
			System.out.println("DaysFrom function doesn't works correctly.");
		
		Day d5 = new Day(2019,10,14);
		int q = d5.daysFrom(d1);
		Day temp3 = d1.addDays(q);
		if(d5.equal(temp3))
			System.out.println("DaysFrom function works correctly.");
		else
			System.out.println("DaysFrom function doesn't works correctly.");
		
			
		
			
		
		
	}

}
