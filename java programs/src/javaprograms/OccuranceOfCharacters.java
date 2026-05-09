package javaprograms;

public class OccuranceOfCharacters {

	public static void main(String[] args) {
		String str="Welcome to java programming";
		occuranceOfCharacter(str,'a');
		occuranceOfCharacter(str,'m');
		occuranceOfCharacter(str,'W');
	}
	public static void occuranceOfCharacter(String str,char val) {
		int count=0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)==val) {
				count++;
			}
		}
		System.out.println("occurance of character "+val+" is "+count);
	}
}
