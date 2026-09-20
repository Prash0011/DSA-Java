package recursion.basicrecursion;

import java.util.Scanner;

// Parameterized Way

class FibonacciNumber {
	public static void main(String... ar) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int f0 = 0;
		int f1 = 1;
		int i = 2;
		nthFibonacci(n, f0, f1, i);
	}
	static void nthFibonacci(int n, int f0, int f1, int i) {
		if(i == n) {
			System.out.println("The" + n + "th fibonacci number is:" +f0+f1);
			return;
		}
		nthFibonacci(n, f1, f0+f1, i+1);
	}
}


class FibonacciNumber {
	public static int main(String... ar) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int f0 = 0;
		int f1 = 1;
		int i = 2;
		return nthFibonacci(n, f0, f1, i);
	}
	static int nthFibonacci(int n, int f0, int f1, int i) {
		if(n <= 1) {
	        return n;
	    }
		if(i == n) {
			return f0+f1;
		}
		return nthFibonacci(n, f1, f0+f1, i+1);
	}
}