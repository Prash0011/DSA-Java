package recursion.basicrecursion;

import java.util.Scanner;

public class PrintSomeThing {
	public static void main(String... ar) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		printName(n);
	}
	static void printName(int n) {
		if(n < 1) return;
		System.out.println("Print Someone's Name");
		printName(n-1);
	}
}
