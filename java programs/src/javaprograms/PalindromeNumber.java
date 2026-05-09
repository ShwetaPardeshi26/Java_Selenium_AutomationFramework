package javaprograms;

public class PalindromeNumber {

	public static void main(String[] args) {
		int num=456544;
		int rev=0;int org=num;
		while(num!=0) {
			rev=rev*10+num%10;
			num=num/10;
		}
		System.out.println("reverse number is : "+rev);
      if(org==rev) {
    	  System.out.println("given number is palindrome");
      }else {
    	  System.out.println("number is not palindrome");
      }
	}

}
