package mc.ys.assignment;
import java.util.Scanner;
import java.util.Arrays;

public class MyLotto {

	public static void main(String[] args) {
		/*
		 * 로또 프로그램
		 * 1. 로또번호는 총 6개를 추출한다.
		 * 2. 6개 당첨시 1등, 5개 2등, 4개 3등, 3개 4등, 이외 꽝
		 * 3. 랜덤객체를 사용해서 랜덤 정수값 6세트를 생성한다. (1 ~ 45 정수범위)
		 * 4. 랜덤번호와 당첨번호를 비교하여 맞은 갯수를 카운트한 후 등수를 매긴다.
		 * */
		Lotto my = new Lotto();
		int[] myNumber = my.MyLotto();
		int[] winningNumber =my.WinningLotto();
		int count = my.Compare(myNumber, winningNumber);
		my.Rank(count);
	}
}

class Lotto {
	Scanner sc = new Scanner(System.in);
	public int[] WinningLotto() {									// 당첨 번호 생성 메소드
		int[] winningNumber = new int[6];
		for(int i = 0; i < winningNumber.length; i++) {
			while(true) {
				int n = 0;
				int number = (int) (Math.random() * 45) + 1;		// 랜덤 숫자 생성
				for(int j = 0; j < winningNumber.length; j++) {		// 
					if (winningNumber[j] == number) {				// 생성된 랜덤 숫자가 기존 당첨 번호와 중복된다면 for문 종료
						n = j;
						break;
					}
				}
				if (winningNumber[n] == number)						// while문으로 이동, 새로운 랜덤 숫자 발생, 중복 제거 반복
					continue;
				winningNumber[i] = number;							// 이미 입력된 당첨번호와 중복되지 않는다면 새로운 당첨번호에 입력
				break;
			}
		}
		return winningNumber;
	}
	public int[] MyLotto() {										// 내 번호 입력 메소드
		int[] myNumber = new int[6];
		System.out.println("로또번호를 입력해 주세요.");
		for(int i = 0; i < myNumber.length; i++) {					// 키보드로 입력
			myNumber[i] = sc.nextInt();
		}
		return myNumber;
	}
	public int Compare(int[] myNumber, int[] winningNumber) {		// 내 번호와 당첨번호 비교 메소드
		int count = 0;
		for(int i = 0; i <myNumber.length; i++) {
			for(int j = 0; j <winningNumber.length; j++) {
				if(myNumber[i] == winningNumber[j])					// 맞은 개수 카운트
					count++;
			}
		}
		System.out.println("입력 번호는 " + Arrays.toString(myNumber) + "입니다.");
		System.out.println("당첨 번호는 " + Arrays.toString(winningNumber) + "입니다.");
		return count;
	}
	public void Rank(int count) {
		switch(count) {
			case 6:
				System.out.println("1등 입니다. 축하합니다.");
				break;
			case 5:
				System.out.println("2등 입니다. 축하합니다.");
				break;
			case 4:
				System.out.println("3등 입니다. 축하합니다.");
				break;
			case 3:
				System.out.println("4등 입니다. 축하합니다.");
				break;
			default:
				System.out.println("꽝 입니다. 다음기회에");
		}
	}
}
