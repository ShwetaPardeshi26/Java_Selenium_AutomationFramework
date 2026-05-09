package javaprograms;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr= {43,20,1,50,3};//2 4 1 5 3// 2 1 4 5 3//2 1 4 5 3//2 1 4 3 5 - pass 1
         int temp;
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-1;j++) {
				if(arr[j]>arr[j+1]) {
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		System.out.println("sorted array is : "+Arrays.toString(arr));
	}

}
