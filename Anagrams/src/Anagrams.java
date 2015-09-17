import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Paul
 * Find all anagrams of a word in a file. 
 * Input -  only file name and word. Output - all set of word in file that 
 * are anagrams of word. Write production quality code.
 *
 *Algorithm:
 * 1) Use a hashmap with string as key and list<string> as value where list of 
 * strings contain all anagrams of a key string.
 * 2) For each word in the file, find beta string which is its sorted 
 * version ex abd is sorted version of bad, adb and dba. 
 * Put this word to that list whose key is this beta string. 
 * If it does not exist then create a new list with the beta string as key in map.
 * 3) Finally print all strings from the list whose key is the 
 * input word(sorted/beta string).
 */
public class Anagrams {
	

	public static void main(String[] args) {
		String beta = args[1];
		
		try {
			HashMap<String, List<String>> map =
					new HashMap<String, List<String>>();
			
			Scanner s = new Scanner(new File(args[0]));
			while(s.hasNext()) {
				String word = s.next();
				String alpha = sorting(word);
				List<String> list = map.get(alpha);
				
				if(list == null) {
					map.put(alpha,  list = new ArrayList<String>());
				}
				list.add(word);
			}
			s.close();
			List<String> list = map.get(sorting(beta));
			Object[] arr = list.toArray();
			for(int i = 0; i < arr.length; i++) {
				System.out.println(arr[i]);
			}
		} catch (Exception e) {
			System.out.println(e);
			System.exit(1);
		}

	}
	
	private static String sorting (String s) {
		char[] a = s.toCharArray();
		Arrays.sort(a);
		return new String(a);
	}

}
