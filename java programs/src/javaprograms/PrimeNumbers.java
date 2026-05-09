package javaprograms;

import java.util.Scanner;

public class PrimeNumbers {

	public static void main(String[] args) {
		System.out.println("enter a number : ");
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int count=0;
		if(num>1) {
			for(int i=1;i<=num;i++) {
				if(num % i==0) {
					count++;
				}
			}
			
		}
		if(count == 2) {
			System.out.println("number is prime number..");
		}else {
			System.out.println("number is not a prime number...");
		}
		
		
		

	}

}
