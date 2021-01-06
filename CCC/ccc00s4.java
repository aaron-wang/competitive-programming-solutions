import java.util.*;
import java.io.*;

public class ccc00_s4_golf {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int distance = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int[] clubs = new int[n];
		int[] smop = new int[distance + 1];
		for (int i = 0; i < n; i++) {
			clubs[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 1; i < smop.length; i++)  {
			smop[i] = 5281;
		}
			
		smop[0] = 0;
		
		for (int i = 1; i <= distance; i++) {
			for (int j = 0; j < n; j++) {
				if (i >= clubs[j]) {
					smop[i] = Math.min(smop[i], smop[i - clubs[j]] + 1);
				}
			}
		}
		
		if (smop[distance] == 5281) { 
			System.out.println("Roberta acknowledges defeat.");
		}
		else {
			System.out.printf("Roberta wins in %d strokes.",smop[distance]);
		}
		
//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= distance; j++) {
//				if (i >= clubs[j]) {
//					smop[i];
//				}
//			}
//		}
	}
}