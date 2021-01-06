import java.io.*;
import java.util.*;

public class ccc05_j5_bananas {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word;
		do {
			boolean isMonkeyWord = true;
			word = br.readLine();
			while (word.indexOf("ANA") != -1 || word.indexOf("BAS") != -1 ) {
				word = word.replaceAll("ANA", "A");
				word = word.replaceAll("BAS", "A");
//				System.out.println(word);
			}
			if (word.equals("A")) {
				isMonkeyWord = true;
			}
			else {
				isMonkeyWord = false;
			}
//			if (word.charAt(0) == 'A') {
//				
//			}
//			else if (word.charAt(0) == 'B' && word.charAt(word.length() - 1) == 'S') {
//				word = word.substring(1,word.length() - 1);
////				System.out.println(word);
//			}
//			else {
//				isMonkeyWord = false;
//			}
			
			
//			final printing
			if (isMonkeyWord) {
				System.out.println("YES");
			}
			else if (word.equals("X")) {
				return;
			}
			else {
				System.out.println("NO");
			}
		} while (!word.equals("X"));
	}

}