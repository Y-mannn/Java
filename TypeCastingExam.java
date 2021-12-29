package JavaStudy;

public class TypeCastingExam {

	public static void main(String[] args) {
//		byte < short, char < int < long < float < double
//		묵시적 형변환
		int x1 = 50000;
		long y1 = x1;
		System.out.println(x1);
		System.out.println(y1);
		
//		강제 형변환
		long x2 = 5;
		int y2 = (int) x2;
		System.out.println(x2);
		System.out.println(y2);
	}
	
}