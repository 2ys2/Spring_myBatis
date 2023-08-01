package ex01.java;

public class MainEntry {
	public static void main(String[] args) {
		Calc c = new Calc();
		System.out.println(c.add(1, 2));
		System.out.println(c.add(10, 22));
		System.out.println();
		System.out.println(c.mul(3, 5));
		System.out.println(c.mul(5, 7));
		System.out.println(c.mul(6, 9, 13));
		
	}
}

/*

7월 27, 2023 5:19:37 오후 ex01.java.Calc add
INFO: 타이머 시작
7월 27, 2023 5:19:37 오후 ex01.java.Calc add
INFO: 타이머 정지
7월 27, 2023 5:19:37 오후 ex01.java.Calc add
INFO: [TimerLOG] Method : add
7월 27, 2023 5:19:37 오후 ex01.java.Calc add
INFO: [TimerLog] process Time : 45
3

*/