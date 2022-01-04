package mc.ys.assignment1;
import java.util.Arrays;
import java.util.Scanner;

public class MyBaseBall {

	public static void main(String[] args) {
		MyBaseBall my = new MyBaseBall();
		my.gameStarter();
	}
	Scanner scan = new Scanner(System.in);
	void gameStarter() {
		boolean flag = false;
		while(!flag) {
			System.out.println("숫자를 입력해 주세요. >>> ");
			int cmd1 = compareNumber();
			if(cmd1==4) {
				System.out.println("4스트라이크 입니다. 게임을 종료합니다!!");
				flag = true;
			}
			System.out.println("기권하시겠습니까? [yes: 1, no: 2] >>> ");
			int cmd2 = scan.nextInt();
			if(cmd2==1) {
				System.out.println("게임을 종료합니다!!");
				flag = true;
			}
		}	
	}
	int[] makeNumber() {
		int[] a = new int[4];
		a[1] = (int)(Math.random()*9) + 1;
		for(int i=0; i<a.length; i++) {
			while(true) {
				int n=0;
				int randomNumber = (int)(Math.random()*10);
				for(int j=0; j<a.length; j++) {
					if(a[j] == randomNumber) {
						n=j;
						break;
					}
				}
				if(a[n]==randomNumber)
					continue;
				a[i] = randomNumber;
				break;
			}
		}
		return a;
	}
	int[] inputNumber() {
		int[] b = new int[4];
		for(int i=0; i<b.length; i++) {
			b[i] = scan.nextInt();
		}
		return b;
	}
	int compareNumber() {
		int[] a = makeNumber();
		int[] b = inputNumber();
		int ballCount=0;
		int strikeCount=0;
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<b.length; j++) {
				if(a[i]==b[j]) {
					if(i==j)
						strikeCount++;
					else
						ballCount++;
				}
			}
		}
		System.out.println(Arrays.toString(a));
		System.out.println("결과는 "+strikeCount+"스트라이크 "+ballCount+"볼");
		return strikeCount;
	}

	
}
