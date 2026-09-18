package recursion.basicrecursion;

import java.util.Scanner;

// Method 1- Normal Recursion

class PrintNTo1 {
	public static void main(String... ar) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		printNTo1(n);
	}
	static void printNTo1(int n) {
		if(n < 1) {
			return;
		}
		System.out.println(n);
		printNTo1(n);	
	}
}

// Method 2- Backtracking

class PrintNTo1 {
	public static void main(String... ar) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int i = 1;
		printNTo1(n, i);
	}
	static void printNTo1(int n, int i) {
		if(i > n) {
			return;
		}
		printNTo1(n, i+1);
		System.out.println(i);
	}
}
