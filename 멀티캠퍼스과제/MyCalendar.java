package mc.ys.assignment1;

import java.util.Scanner;

public class MyCalendar {

	public static void main(String[] args) {
		MyCalendar cm = new MyCalendar();
		cm.start();
	}
	public void start() {
		Scanner scan = new Scanner(System.in);
		boolean flag = false;
		while(!flag) {
			System.out.print("연도를 입력해 주세요. >>> ");
			int cmd1 = scan.nextInt();
			System.out.print("월을 입력해 주세요. >>> ");
			int cmd2 = scan.nextInt();
			
			makeCalendar(cmd1, cmd2);
			
			System.out.print("계속하시겠습니까? [Yes: 1, no: 0] >>> ");
			int cmd3 = scan.nextInt();
			if(cmd3 == 0) {
				System.out.println("종료합니다!!");
				flag = true;
			}
		}
		scan.close();
	}
	void makeCalendar(int year, int month) {
		// 월별 마지막 날짜
		int[] lastDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int lastDay = lastDays[month - 1];
		// 윤년판단 로직
		if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
			lastDay = 29;
		// 작년 12월 space값 다음 해 1월 space 값을 구하기 위해 필요 
		// 입력 값의 전년도 12월 space값
		int spaceOf12 = 5;
		for(int i = 1; i < year; i++) {
			if((i % 4 == 0 && i % 100 != 0) || i % 400 == 0)
				spaceOf12 +=2;
			else
				spaceOf12++;
			spaceOf12 %= 7;
		}
		int[] spaces = new int[12];
		// space를 구하기 위해선 전 달 space, lastDay 값이 필요
		spaces[0] = (spaceOf12 + 31) % 7;
		for(int i = 1; i < 12; i++) {
			spaces[i] = (spaces[i-1] + lastDays[i-1]) % 7;
		}
		int space = spaces[month - 1];
		// 달력 출력
		System.out.println();
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
		System.out.println("\n");
	}
}
