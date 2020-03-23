public class TestStudentScore{
	public static void main(String [] args){
		boolean withHeader = true;
		StudentScore s1 = new StudentScore("5630000021,10,10,9,8,7");
		s1.printScore(withHeader);
		
		withHeader = false;
		StudentScore s2 = new StudentScore("5630000121,8,8,10,6,5");
		s2.printScore(withHeader);
	}
}