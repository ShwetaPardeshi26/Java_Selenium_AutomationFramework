package javaprograms;

public class CountEvenAndOdd {

	public static void main(String[] args) {
		int num=1236788342;
		int evenCount=0;
		int oddCount=0;
		while(num !=0 ) {
			num=num/10;
			if((num)%2==0) {
				evenCount++;
			}else {
				oddCount++;
			}
	
		}
		System.out.println(evenCount);
		System.out.println(oddCount);
	}

}
