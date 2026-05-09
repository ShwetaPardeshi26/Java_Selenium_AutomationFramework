package javaprograms;

import java.util.Arrays;

public class AnagramStrings {

	public static void main(String[] args) {
		String str1="listen";
		String str2="Silent";
		String s1=str1.replaceAll("\\s", "");
		String s2=str2.replaceAll("\\s", "");
		
		if(s1.length()==s2.length()) {
			char[] arr1=s1.toLowerCase().toCharArray();
			char[] arr2=s2.toLowerCase().toCharArray();
			Arrays.sort(arr1);Arrays.sort(arr2);
			if(Arrays.equals(arr1, arr2)) {
				System.out.println("both arrays are equal");
			}else {
				System.out.println("both arrays are not equal");
			}
		}
		
	}

}
