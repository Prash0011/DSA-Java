package recursion.basicrecursion;

import java.util.Scanner;

// Method 1

class ReverseArray {
	public static void main(String... ar) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the size of the array");
		int size = in.nextInt();
		int numbers [] = new int[size];
		for(int i = 0; i < size; i++) {
			numbers[i] = in.nextInt();
		}
		int left = 0;
		int right = numbers.length-1;
   		reverse(numbers,left, right);
	}
	static void reverse(int [] arr, int left, int right) {
		if(left >= right) {
			return;
		}
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
		reverse(arr, left+1, right-1);
	}
}

// Method 2

class ReverseArray {
	public static void main(String... ar) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the size of the array");
		int size = in.nextInt();
		int numbers [] = new int[size];
		for(int i = 0; i < size; i++) {
			numbers[i] = in.nextInt();
		}
		int i = 0;
   		reverse(numbers, i, numbers.length-i-1);
	}
	static void reverse(int [] arr, int i, int j) {
		if(i >= arr.length/2) {
			return;
		}
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		reverse(arr, i+1, j-1);
	}
}

