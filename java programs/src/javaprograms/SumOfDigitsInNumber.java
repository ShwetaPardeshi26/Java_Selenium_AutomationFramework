package javaprograms;

public class SumOfDigitsInNumber {

	public static void main(String[] args) {
		int num=34562;
		int sum=0;
		while(num !=0) {
			sum=sum+num%10;//6+5+4+3
			num=num/10;//345 34 3
		}
		System.out.println("sum of digits is : "+sum);

	}

}
