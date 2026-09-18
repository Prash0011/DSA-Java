package recursion.basicrecursion;

import java.util.Scanner;

// Method 1- Parameterized Recursion using accumulator

class SumFirstNNaturalNumbers {
	public static void main(String... ar) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int sum = 0;
		getSum(n, sum);
	}
	static void getSum(int n, int sum) {
		if(n < 1) {
			System.out.println(sum);
			return;
		}
		sum += n;
		getSum(n-1, sum);
	}
}


//Method 2- Functional Recursion

class SumFirstNNaturalNumbers {
	public static void main(String... ar) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
   		return getSum(n, sum);
	}
	static int getSum(int n, int sum) {
		if(n < 1) {
			System.out.println(sum);
			return;
		}
		sum += n;
		getSum(n-1, sum);
	}
}
