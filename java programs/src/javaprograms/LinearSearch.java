package javaprograms;

public class LinearSearch {

	public static void main(String[] args) {
	int[] arr= {10,45,78,23,90};
    int search_ele=80;
    boolean status=false;
    for(int i=0;i<arr.length;i++) {
    	if(arr[i]==search_ele) {
    		status=true;
    		System.out.println("element found at : "+i);
    		break;
    	}
    }
    if(status==false) {
    	System.out.println("element is not found...");
    }
	}

}
