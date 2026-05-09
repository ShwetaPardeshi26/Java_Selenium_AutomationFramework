package javaprograms;

public class RemoveWhiteSpacesFromString {

	public static void main(String[] args) {
		String str="welcome   to java     programming";
		
		str=str.replaceAll("\\s", "");
		System.out.println(str);

	}

}
