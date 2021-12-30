package my.ys.lesson1.test;
import java.util.Scanner;

public class CalendarService {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 2020 ~ 2024년의 달력생성 --> 2019년 12월 빈칸정보
		int standardyear = 2019;
		System.out.println("2020 ~ 2024 사이의 연도를 입력해 주세요.");
		int year = sc.nextInt();
		System.out.println("월을 입력해 주세요.");
		int month = sc.nextInt();
		
		// 월별 마지막 날짜
		int[] lastDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int lastDay = lastDays[month - 1];
		// 윤년판단 로직
		if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
			lastDay = 29;
		
		// 연도별 12월 space값 다음 해 1월 space 값을 구하기 위해 필요 
		int[] lastspaces = {0, 2, 3, 4, 5};
		int[] spaces = new int[12];
		// space를 구하기 위해선 전 달 space, lastDay 값이 필요
		for(int i = 0; i < spaces.length; i++) {
			if(i == 0) {
				spaces[i] = (lastspaces[year - (standardyear + 1)] + 31) % 7;
				continue;
			}
			spaces[i] = (spaces[i-1] + lastDays[i-1]) % 7;
		}
		int space = spaces[month - 1];
		
		System.out.println(year + "년 " + month + "월");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		for(int i = 0; i < space; i++) {
			System.out.print("\t");
		}
		int day = 1;
		for(int i = 0; i < lastDay; i++) {
			System.out.print(day + "\t");
			if((space + day) % 7 == 0) {
				System.out.println();
			}
			day += 1;
		}
		System.out.println();
		sc.close();
	}

}
