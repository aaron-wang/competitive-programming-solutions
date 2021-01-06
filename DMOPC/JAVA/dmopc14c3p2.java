import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] subs = new String[N];
		String[] output = new String[N];
		
		int countWA = 0; //first 30% down, rest same
		
		
		for (int i = 0; i < N; i++) {
			subs[i] = br.readLine();
			
			if (subs[i].equals("WA")) {
				countWA++;
			}
//			else if (subs[i].equals("IR")) {
//				countIR++;
//			}
			
		}
		
		int changeWA = (int) Math.floor(countWA * 0.3);
		
		int countIR = 0; //first 10 to AC, next 10 to WA, rest same
		
		for (int i = 0; i < subs.length; i++) {
			if (subs[i].equals("WA")) {
				if (changeWA > 0) {					
					output[i] = "AC";
					changeWA--;
				}
				else {
					output[i] = "WA";
				}
			}
			else if (subs[i].equals("IR")) {
				countIR++;
				if (countIR <= 10) {
					output[i] = "AC";
				}
				else if (countIR <= 20) {
					output[i] = "WA";
				}
				else {
					output[i] = "IR";
				}
			}
			else if (subs[i].equals("TLE")) {
				output[i] = "WA";
			}
			else {
				output[i] = "AC";
			}
		}
		
		for (String m: output) {
			System.out.println(m);
		}
	}
}