package javaprograms;

import java.util.Arrays;
import java.util.Collections;

public class SortElementsInArray {

	public static void main(String[] args) {
		Integer[] arr= {20,67,32,1,90,21,78};
//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
//        Arrays.parallelSort(arr);
//        System.out.println(Arrays.toString(arr));
		  Arrays.sort(arr,Collections.reverseOrder());
		  System.out.println(Arrays.toString(arr));
	}

}
