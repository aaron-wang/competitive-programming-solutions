import java.util.*;

import java.io.*;

public class ccc96_s5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int max = 0;
			int[] X = new int[n];
			int[] Y = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int q = 0; q < n; q++) {
				X[q] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int q = 0; q < n; q++) {
				Y[q] = Integer.parseInt(st.nextToken());
			}
			
			//descending sequences
			
//			d(X[i]Y[j]) = j - i when j >= i and Y[j] > X[i], or 0 if not
			for (int m = 0; m < n; m++) {
				for (int k = m; k < n; k++) {
					if (k >= m && Y[k] >= X[m]) {
						max = Math.max(max,k - m);
					}
				}
			}
			System.out.println("The maximum distance is " + max);
		}
	}

}