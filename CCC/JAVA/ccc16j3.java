import java.io.*;
import java.util.*;

public class Main {
	public static boolean isPalindrome(String str) {
		if (str.length() == 0) {
			return true;
		}
		//even
		else if (str.length() % 2 == 0) {
			
			for (int i = 0; i < str.length()/2; i++) {
				if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
					return false;
				}
			}
			return true;
		}
		//odd
		else {
			for (int i = 0; i < str.length()/2; i++) {
				if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
					return false;
				}
			}
			return true;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		//full length
		
		int max = 0;
		String current = "";
		
		bob:
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j <= i; j++) {
				current = str.substring(j,str.length() - i + j);
				if (isPalindrome(current)) {
					max = current.length();
					break bob;
				}
			}
		}
		
		System.out.println(max);
//		System.out.println(current);
		
		//remove one
		
		//substring(0,str.length - 1) 
		//substring (1, str.length)
		
		//remove two
		
//		s(0, L - 2)
//		s(1, L - 1)
//		s(2, L)
	}


}