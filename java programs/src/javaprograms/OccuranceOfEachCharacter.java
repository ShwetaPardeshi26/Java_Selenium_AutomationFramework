package javaprograms;

import java.util.HashMap;
import java.util.Map;

public class OccuranceOfEachCharacter {

	public static void main(String[] args) {
		ocuranceOfEachCharacter("test");
		ocuranceOfEachCharacter("test test test");
	}
	public static void ocuranceOfEachCharacter(String str) {
		Map<Character,Integer> map=new HashMap<Character,Integer>();
		char[] arr=str.toCharArray();
		
		for(char c:arr) {
			if(!String.valueOf(c).isBlank()) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}else {
				map.put(c, 1);
			}
			}
		}
		System.out.println(str+" : "+map);
		
	}

}
