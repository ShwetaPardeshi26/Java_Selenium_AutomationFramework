package javaprograms;

import java.util.Arrays;

public class ArrayEquality {

	public static void main(String[] args) {
		int[] arr1= {10,20,67,89,34};
		int[] arr2= {10,20,67,890,34};
//		if(Arrays.equals(arr1, arr2)) {
//			System.out.println("arrays are equal");
//		}else {
//			System.out.println("arrays are not equal");
//		}
		boolean status=true;
		if(arr1.length==arr2.length) {
		for(int i=0;i<arr1.length;i++) {
			if(arr1[i]!=arr2[i]) {
				status=false;
			}
		}
		}else {
			status=false;
		}
		
		if(status==true) {
			System.out.println("arrays are equal");
		}else {
			System.out.println("arrays are not equal");
		}
		
	}

}
