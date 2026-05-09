package javaprograms;

public class NumberOfDigitsInNumber {

	public static void main(String[] args) {
		int num=66778878;
		int count=0;
		while(num!=0){
			num=num/10;//66778 
			count++;
		}
		System.out.println("number of digits in a nummber are :"+count);

	}

}
