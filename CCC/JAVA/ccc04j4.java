import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String key = br.readLine();
		
		// X Y Z
		// 0 1 2 
		// 3 4 5
		
		// %3 == 0// %3 = 1 // %3 == 2
		String word = br.readLine();
		
		word = String.join("",word.split(" "));
		
		String newWord = "";
		
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) > 'Z' || word.charAt(i) < 'A') {
			
			}
			else {				
				newWord += word.charAt(i);
			}
		}
		word = newWord;
		
// 		System.out.println(word);
		
		String output = "";
		//process it
		
		for (int i = 0; i < word.length();i++) {
//			if (i % 3 == 0) {
//				char current = word.charAt(i);
//				
//				current += key.charAt(0);
//			}
//			else if (i % 3 == 1) {
//				
//			}
//			//%3 == 2
//			else if (i % 3 == 2) {
//				
//			}
			for (int j = 0 ; j < key.length(); j++) {
				if (i % key.length() == j) {
					char current = word.charAt(i);
					current += key.charAt(j) - 'A';
					
					if (current > 'Z') {
						current = (char) (((current - 'Z') % 26) + 'A' - 1);						
					}
					output += current;
				}
			}
		}
		System.out.println(output);
		
	}
}