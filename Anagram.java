import java.util.Random;

/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		// Replace the following statement with your code
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		char[] c1 = str1.toCharArray();
		char[] c2 = str2.toCharArray();
		boolean flag;
		for (int i = 0; i < c1.length; i++) {
			flag = true;
			char letter = c1[i];
			for (int j = 0; j < c2.length; j++) {
				if (c2[j] == letter){
					flag = false;
					//we already cleared all numbers so its safe to use as keyword for marking purposes.
					c2[j] = 0;
					break;
				}
			}
			if (flag)
				return false;
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		// Replace the following statement with your code
		str = str.toLowerCase();
		str = str.replaceAll("[^a-z ]", "");
		return str;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		// Replace the following statement with your code
		char[] letters = str.toCharArray();
		char[] anagram = new char[letters.length];
		Random rnd = new Random();
		int remainings = letters.length;
		for (int i = 0; i < anagram.length; i++) {
			int index = rnd.nextInt(remainings);
			anagram[i] = letters[index];
			//moving the entire char array
			letters[index] = letters[remainings - 1];
			remainings--;
		}
		return new String(anagram);
	}
}
