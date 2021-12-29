package mc.ys.assignment;
import java.util.Scanner;

public class Mycalendar{
	
	public static void main(String[] args) throws Exception {
		Mycalendar c = new Mycalendar();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("2020 ~ 2024 사이의 연도를 입력해 주세요.");
		int year = sc.nextInt();
		System.out.println("월을 입력해 주세요.");
		int month = sc.nextInt();
		c.calender(year, month);
		System.out.println("2020 ~ 2024 사이의 연도를 입력해 주세요.");
		year = sc.nextInt();
		c.calender(year);
		sc.close();
	}
	
	public void day(int i) {
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		for (int day = 1; day < i; day++) {
			System.out.print(day + "\t");
			if(day % 7 == 0) {
				System.out.println();		
			}	
		}
	}
	public void month(int i) {
		if( i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
			this.day(32);
		}
		else if( i == 2) {
			this.day(29);
		}
		else {
			this.day(31);
		}
	}
	public void calender(int year) {
		if (year >= 2020 && year <= 2024) {
			for (int i = 1; i < 13; i ++) {
				System.out.println(year + "년\t" + i + "월");
				this.month(i);
				if(i != 2)
					System.out.println();
			}
		}else {
			System.out.println("잘못된 입력입니다.");
		}
	}
	public void calender(int year, int month) {
		if (year >= 2020 && year <= 2024) {
			System.out.println(year + "년\t" + month + "월");
			this.month(month);
			if(month != 2)
				System.out.println();
		}else {
			System.out.println("잘못된 입력입니다.");
		}	
	}
}