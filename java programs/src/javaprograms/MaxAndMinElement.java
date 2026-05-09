package javaprograms;

public class MaxAndMinElement {

	public static void main(String[] args) {
		int[] arr= {23,78,90,23,45};
       int max=arr[0];
        for(int i=1;i<arr.length;i++) {
        	if(max<arr[i]) {
        		int temp=max;
        		max=arr[i];
        		arr[i]=temp;
        	}
        }
        System.out.println("max number in array is :"+max);
	}

}
