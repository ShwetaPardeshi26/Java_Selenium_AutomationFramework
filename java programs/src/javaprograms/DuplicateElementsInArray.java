package javaprograms;

import java.util.HashSet;
import java.util.Set;

public class DuplicateElementsInArray {

	public static void main(String[] args) {
		String[] arr = { "java", "c#", "ruby", "java", "python","python" };
		//approach 1:
//		boolean status = false;
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = i + 1; j < arr.length; j++) {
//				if (arr[i]==arr[j]) {
//					System.out.println("duplicate element found at :" + arr[i]);
//					status = true;
//				}
//			}
//		}
//		if (status == false) {
//			System.out.println("duplicate element not found");
//		}
       //approach 2
		boolean status=false;
		Set<String> set=new HashSet<String>();
		for(String st:arr) {
			if(set.add(st)==false) {
				System.out.println("duplicate element found :"+st);
				status=true;
			}
		}
		if(status==false) {
			System.out.println("duplicate element not fount");
		}
	}	

}
