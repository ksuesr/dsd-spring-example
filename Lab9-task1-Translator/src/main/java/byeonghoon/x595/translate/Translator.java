package byeonghoon.x595.translate;

public class Translator {

	
	public static String translate(String word) {
		char firstLetter = word.charAt(0);
		
		String res = "";
		if(firstLetter == 'a' || firstLetter == 'e' || firstLetter == 'i' || firstLetter == 'o' || firstLetter == 'u') {
			
			res = word + "hay";
			
		} else {
			
			res = word.substring(1) + String.valueOf(firstLetter) + "ay";
		}
		
		return res;
	}
}
