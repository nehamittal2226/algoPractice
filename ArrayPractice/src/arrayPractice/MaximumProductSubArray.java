package arrayPractice;

public class MaximumProductSubArray {

	public static void main(String[] args) {
		int Arr[] = {0, 3, -5, -2, 8, -7, -6, -2, -3, -9};
		int max=maxProduct(Arr);
		System.out.println(max);

	}

	private static int maxProduct(int[] arr) {
		int max=1,temp=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i] !=0) {
				max=max*arr[i];
			}else {
				temp=max;
				max=1;
			}
		}
		if(Math.abs(temp)>Math.abs(max)) {
			return Math.abs(temp);
		}else {
			return Math.abs(max);
		}
		
		
		
	}

}
