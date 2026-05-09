package javaprograms;

public class MissingNumberInArray {

	public static void main(String[] args) {
		int[] arr= {1,2,4,5};
		int sum1=0,sum2=0;
		
		for(int i=0;i<=5;i++) {
			sum1=sum1+i;
		}
		
		for(int i=0;i<arr.length;i++) {
			sum2=sum2+arr[i];
		}
		System.out.println("missing number in array is :"+(sum1-sum2));
	}

}
