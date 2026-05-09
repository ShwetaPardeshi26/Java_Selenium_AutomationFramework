package javaprograms;

public class ReverseEachWordInString {

	public static void main(String[] args) {
			String str="Welcome to java";
			
			//approach 1 : 
//			String reverseString="";
//			String[] words=str.split(" ");
//			for(String w:words) {
//				String reverseWord=" ";
//				for(int i=w.length()-1;i>=0;i--) {
//					reverseWord=reverseWord+w.charAt(i);//emoclew
//				} 
//				reverseString=reverseString+reverseWord+" ";
//			}
//			System.out.println("reverse string is : "+reverseString);
			//approach 2 : 
			String[] words=str.split(" ");
			String reverseString=" ";
			for(String w:words) {
				StringBuilder sb=new StringBuilder(w);
				sb.reverse();
				reverseString=reverseString+sb.toString()+" ";
			}
			System.out.println("reverse string is : "+reverseString);
}
}