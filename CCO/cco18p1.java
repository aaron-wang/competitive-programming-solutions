import java.util.*;
import java.io.*;

public class Main {
//	static int[][] dp; 
//	static Integer[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		//geese
		int[] a = new int[N+1];
		String A = br.readLine();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		//hawk
		int[] b = new int[N+1];
		String B = br.readLine();
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		long prev = 0;
		long[][] dp = new long[N+1][N+1];
		long[] best = new long[N+1];
		
		for (int i = 1; i <= N; i++) {
			char AA = A.charAt(i-1);
			for (int j = 1; j <= N; j++) {
				char BB = B.charAt(j-1);
				
//				prev = dp[i-1][j-1];
				dp[i][j] = best[j-1];
				
				if (AA != BB) {
//					System.out.println(AA + "  "+ BB);
					if (AA == 'W') {
//						System.out.println("A");
						if (a[i] > b[j]) {
							dp[i][j] += a[i] + b[j];
						}
					}
					//BB = 'W'
					else {
//						System.out.println("B");
						if (b[j] > a[i]) {
							dp[i][j] += a[i] + b[j];
						}
					}
//					System.out.println(AA + "  "+ BB);
				}
				else {
//					for (int m = 1; m<= j;m++) {						
//						dp[i][j] = Math.max(dp[i][j],dp[m][j]);
//					}
//					dp[i][j] = Math.max(dp[i][j],dp[i-1][j-1]);
				}
			}
			for (int k = 1; k <= N; k++) {
				best[k] = Math.max(Math.max(dp[i][k],best[k-1]),best[k]);
			}
		}
		System.out.println(best[N]);
		
//		for (long[] mm: dp) {
//			for (long m: mm) {
//				System.out.print(m + " ");
//			}
//			System.out.println();
//		}
		
	}

}