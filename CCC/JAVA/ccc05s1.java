import java.util.*;
import java.io.*;

public class ccc05_s1_snow_calls_V2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		String[] match = {"","","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};
		
		for (int i = 0; i < cases; i++) {
			String[] str = br.readLine().split("");
			String output = "";
			for (int j = 0; j < str.length; j++) {
				if (output.length() == 12) {
					break;
				}
				if (output.length() == 3 || output.length() == 7) {
					output += "-";
				}
				if (!str[j].equals("-")) {
					if (str[j].charAt(0) >= '0' && str[j].charAt(0) <= '9') {
						output+= str[j];
					}
					else {// find the letter
						for (int k = 0; k < match.length; k++) {
							if (match[k].indexOf(str[j].charAt(0)) >= 0) {
								output += k;
							}
						}
					}
				}
			}
			System.out.println(output);
		}
	}
}