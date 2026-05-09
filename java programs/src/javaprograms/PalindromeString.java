package javaprograms;

public class PalindromeString {

	public static void main(String[] args) {
		String str="madam";
		String rev="";
		for(int i=str.length()-1;i>=0;i--) {
			rev=rev+str.charAt(i);
		}
		System.out.println("revverse string is :"+rev);
		if(str.equals(rev)) {
			System.out.println("strings are palindrome...");
		}else {
			System.out.println("strings are not palindrome...");
		}
	}

}
