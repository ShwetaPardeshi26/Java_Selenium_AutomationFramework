package javaprograms;

import java.util.Scanner;

public class FactoriaLOFNumber {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();
		int fact=1;
		for(int i=1;i<=number;i++) {
			fact=fact*i;
		}
		System.out.println("factorial of number is :"+fact);

	}

}
