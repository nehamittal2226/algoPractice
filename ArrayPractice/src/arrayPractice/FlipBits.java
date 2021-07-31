package arrayPractice;

import java.util.Scanner;

/*Given an array arr[] consisting of 0’s and 1’s. A flip operation is one in which you turn 1 
into 0 and a 0 into 1.You have to do atmost one “Flip” operation of a subarray. 
Then finally display maximum number of 1 you can have in the array.*/

public class FlipBits {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int x = 0; x < t; x++) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
			}
			flipBits(arr);
		}


	}

	private static void flipBits(int[] arr) {
		
		
	}

}
