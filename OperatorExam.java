package JavaStudy;

public class OperatorExam {

	public static void main(String[] args) {
		int i1 = -5;
		int i2 = +i1;
		int i3 = -i1;
		
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i3);
		
		int i4 = ++i3; // i3 = i3 + 1;
		System.out.println(i4);
		System.out.println(i3);
		int i5 = i3++; // i3 = i3 + 1;
		System.out.println(i5); // i5에 먼저 i3을 대입 후 i3에 1을 더함
		System.out.println(i3);
		
		int i = 5;
		int j = 2;
		System.out.println(i + j);
		System.out.println(i - j);
		System.out.println(i * j);
		System.out.println(i / j); // 정수형끼리의 연산은 정수형으로 리턴
		System.out.println(i / (double) j);
		System.out.println(i % j);
		
	}

}
