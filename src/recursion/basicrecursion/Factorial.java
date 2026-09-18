package recursion.basicrecursion;

import java.util.Scanner;

// Parameterized Way

class Factorial {
	public static void main(String... ar) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int fact = 1;
   		getFact(n, fact);
	}
	static void getFact(int n, int fact) {
		if(n < 1) {
			System.out.println("The facorial of the number is :" + fact);
			return;
		}
		fact *= n;
		getFact(n-1, fact);
	}
}

// Functional Way

class Factorial {
	public static void main(String... ar) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int fact = 1;
   		return getFact(n, fact);
	}
	static int getFact(int n, int fact) {
		if(n < 1) {
			return fact;
		}
		fact *= n;
		return getFact(n-1, fact);
	}
}
