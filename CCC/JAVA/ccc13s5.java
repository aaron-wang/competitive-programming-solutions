import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		int M = Integer.parseInt(st.nextToken());
//		StringTokenizer st = new StringTokenizer(br.readLine());


		int N = Integer.parseInt(br.readLine());
		/*
		c 	| 	a x b
		a+c |	a x b + a = a(b+1)
		
		incur cost b, add a to c, add one to "lowest"
		...
		reverse:
		c | a(b+1)
		c-a| a(b) 
		
		incur cost b, minus a from c, subtract one from "lowest"
		
		final:
		"flip" when b is 1
		 */
		int ans = 0;
		int a = 0;
		int b = 0;
		//note the cost incurred will be "b-1" but that is implied in the loop 
		//once we initially subtract a from N
		//and divide a for how many times possible, for our total "b"
		while (N >= 2) {			
			for (int i = 2; i <= N; i++) {
				if (N % i == 0) {
					a = N/i;
					N-= a;
					b = N/a;
					ans += b;
					break;
				}
			}
//			System.out.println(N + "  " + a + " x "+ b + " current cost:" + ans);
		}
		System.out.println(ans);
//		System.out.println(N);
		
		
	}

}