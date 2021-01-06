import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(br.readLine());
		
		String[] wow = new String[k];
		
		for (int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			wow[i] = st.nextToken() + st.nextToken();
		}
		
		String seq = br.readLine();
		//inefficient.. but
		
		do {
			//go through all
			for (int j = 0; j < k; j++) {
				if (seq.length() == 0) break;
				
				String current = wow[j];
				
				if (seq.startsWith(current.substring(1,current.length()))) {
					System.out.print(current.charAt(0));
					seq = seq.substring(current.length() - 1,seq.length());
				}
			}
		} while (seq.length() > 0);
		
	}
}