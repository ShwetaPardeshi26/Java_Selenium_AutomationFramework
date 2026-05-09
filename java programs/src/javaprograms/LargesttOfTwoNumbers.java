package javaprograms;

public class LargesttOfTwoNumbers {

	public static void main(String[] args) {
		int num1=233,num2=887,num3=88;
		
//		if(num1>num2 && num1>num3) {
//			System.out.println("num1 is the largest");
//		}else if(num2>num1 && num2>num3) {
//			System.out.println("num2 is the largest");
//		}else {
//			System.out.println("num3 is the largest");
//		}
		
		int large=(num1>num2) ? num1 :num2;
		int largest= large> num3 ? large : num3;
		System.out.println("largesst number is : "+largest);

	}

}
