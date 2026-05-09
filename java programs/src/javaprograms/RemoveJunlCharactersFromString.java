package javaprograms;

public class RemoveJunlCharactersFromString {

	public static void main(String[] args) {
		String str="   ****$$$%% welcome **& to java**#$";
		str=str.replaceAll("[^1-9a-zA-Z]","");
		System.out.println(str);

	}

}
