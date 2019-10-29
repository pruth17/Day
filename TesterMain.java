
public class TesterMain {
	
	public static void main(String[] args) {
		TesterClass today = new TesterClass(2019,10,14);
		today.testAdd(today);
		today.testDaysFrom(today);
		TesterClass SpecialCase = new TesterClass(1582,10,4);
		Day special = SpecialCase.addDays(1);
		System.out.println("Should print: October 15, 1582");
		special.print();
		
		
	}

}
