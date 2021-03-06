import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;


public class StringQuestions {

	public static void main(String args[]) {
		printDuplicatesFromString("H");
	}

	/*Write code to check a String is palindrome or not*/
	public static boolean isPalindrome(String s) {
		if(s == null) { return false; }
		String buff = new StringBuffer(s).reverse().toString();
		if(buff.compareTo(s) == 0) { return true; }
		return false;
	}

	/* Remove character in string. */
	public static String removeChar(String s, char c) {
		String replaced = s.replace(c, '\0');
		return replaced;
	}

	public static String permutationsRecursive(String s) {
		return null;
	}

	public static void permutationsIterative(String s) {
		int inputLength = s.length();
		boolean[ ] used = new boolean[ inputLength ];
		StringBuffer outputString = new StringBuffer();
		char[ ] in = s.toCharArray( );
		doPermute ( in, outputString, used, inputLength, 0 );

	}
	public static void doPermute ( char[ ] in, StringBuffer outputString, 
			boolean[ ] used, int inputlength, int level)
	{
		if( level == inputlength) {
			System.out.println ( outputString.toString()); 
			return;
		}

		for( int i = 0; i < inputlength; ++i )
		{       

			if( used[i] ) continue;

			outputString.append( in[i] );      
			used[i] = true;       
			doPermute( in,   outputString, used, inputlength, level + 1 );       
			used[i] = false;       
			outputString.setLength(outputString.length() - 1 );   
		}
	}

	/* O(n^2) time and O(1) space */
	public static String longestPalindrome(String s) {
		if (s.isEmpty()) {
			return null;
		}

		if (s.length() == 1) {
			return s;
		}

		String longest = s.substring(0, 1);
		for (int i = 0; i < s.length(); i++) {
			// get longest palindrome with center of i
			String tmp = helper(s, i, i);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}

			// get longest palindrome with center of i, i+1
			tmp = helper(s, i, i + 1);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
		}

		return longest;
	}

	// Given a center, either one letter or two letter, 
	// Find longest palindrome
	public static String helper(String s, int begin, int end) {
		while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		return s.substring(begin + 1, end);
	}

	/* Finding the first occurrence of the non repeating character in s */
	/* * Using LinkedHashMap to find first non repeated character of String 
	 * 
	 * * Algorithm :
	 * * Step 1: get character array and loop through it to build a 
	 * * hash table with char and their count. 
	 * * Step 2: loop through LinkedHashMap to find an entry with 
	 * * value 1, that's your first non-repeated character, 
	 * * as LinkedHashMap maintains insertion order. */
	public static char firstNonRepeatedCharInString(String s) {
		if(s == null || s.length() == 0) { return '\0'; }
		// We use a linked hash map because it maintains the order in which we insert
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>(s.length());
		for(char c : s.toCharArray()) {
			map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
		}
		
		// Had we used a hash map, we would need to do a full iteration and check
		// because HashMap does not maintain order
		for(Entry<Character, Integer>entry : map.entrySet()) {
			if(entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		throw new RuntimeException("didn't find any non repeated character");
		
	}
	/* Count number of times a char appears in a word */
	public static int countOccurrenceOfCharInString(String s, char c) {
		if(s == null || s.length() == 0) { return 0; }
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		char[] s_arr = s.toCharArray();
		int count = 1;
		for(int i = 0; i < s_arr.length; i++) {
			if(s_arr[i] == c) {
				map.put(c, count++);
			}
		}
		return map.get(c);
	}
	/* If string one is an anagram of string two */
	public boolean checkAreAnagrams(String one, String two) {
		char[] one_chars = one.toCharArray();
		Arrays.sort(one_chars);
		char[] two_chars = two.toCharArray();
		Arrays.sort(two_chars);

		if(one_chars.toString().compareTo(two_chars.toString()) == 0) { return true; }
		return false;
	}
	
	/* Return the integer equivalent to the String */
	public int stringToInt(String s) {
		return Integer.parseInt(s);
	}
	
	public static void reverseStringInPlace(String s) {
		int firstPos=0;
		char[]myString = new char[s.length()];
		int lastPos=myString.length - 1;
		while (firstPos < lastPos)
		{
		  char temp=myString[firstPos];
		  myString[firstPos]=myString[lastPos];
		  myString[lastPos]=temp;
		  firstPos++;
		  lastPos--;
		}
	}
	
	public static void printDuplicatesFromString(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		if(s == null || s.length() == 1) { System.out.println("No duplicates in this input"); }
		char[] c = s.toCharArray();
		for(char cc : c) {
			map.put(cc, map.containsKey(cc) ? map.get(cc) + 1 : 1);
		}
		
		for(char ch : map.keySet()) {
			if(map.get(ch) > 1) {
				System.out.println(ch);
			}
		}
	}

}
