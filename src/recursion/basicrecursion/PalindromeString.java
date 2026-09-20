package recursion.basicrecursion;

import java.util.Scanner;

class PalindromeString {
	public static boolean main(String... ar) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		int left = 0;
		int right = str.length()-1;
   		return isPalindrome(str,left, right);
	}
	static boolean isPalindrome(String str, int left, int right) {
		if(left >= right ) {
			return true;
		}
		if(str.charAt(left) != str.charAt(right)) {
			return false;
		}
		return isPalindrome(str, left+1, right-1);
	}
}
