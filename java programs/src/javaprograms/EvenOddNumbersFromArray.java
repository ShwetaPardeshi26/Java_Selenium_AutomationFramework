package javaprograms;

public class EvenOddNumbersFromArray {

	public static void main(String[] args) {
		int[] arr= {23,78,90,2,12,25};
		System.out.println("even numbers are :");
      for(int i=0;i<arr.length;i++) {
    	  if(arr[i] % 2 == 0 ) {
    		  System.out.println(arr[i]);
    	  }
      }
      System.out.println("odd numbers are :");
      for(int i=0;i<arr.length;i++) {
    	  if(arr[i] % 2 != 0 ) {
    		  System.out.println(arr[i]);
    	  }
      }
	}

}
