import java.util.*;
import java.io.*;

public class ccc03_s4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int t = 0; t < N; t++) {
			String s = br.readLine();
//			Set<String> hello = new HashSet<>();
			int count = 0;
//			hello.clear();
//			hello.add("");

			//length of 1 - 5000...
			// n(n+1)/2 substrings (+1 when considering empty set)
			/*
			 * n	1
			 * n-1	2
			 * n-2	3
			 * ..
			 * 1	n
			 * 
			 * 1+2..+n= n(n+1)/2
			 * 
			 * brute force likely not possible for full marks, but let's see how far it goes
			 */
			for (int i = 0; i <= s.length(); i++) {
				for (int j = i+1; j <= s.length(); j++) {
//					System.out.println(":" + s.substring(i,j));
//					hello.add(s.substring(i,j));
					String w = s.substring(i,j);
					if (s.indexOf(w) == i) {
						count++;
					}
					//check for first occurences.. etc.
				}
			}
			count++;
//			System.out.println(hello.size());
			System.out.println(count);
			
		}
	}

}