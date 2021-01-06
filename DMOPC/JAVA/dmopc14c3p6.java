import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		
//		int N = Integer.parseInt(br.readLine());
//		int M = Integer.parseInt(st.nextToken());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N= Integer.parseInt(st.nextToken());
		int T= Integer.parseInt(st.nextToken());
		
		//for each N, three possible problem sets (P, A, G)
		//and P (prep time: min), V (value)
		//P <= A <= G
		
		//given limit T
		//find max profit
		int[][] v = new int[N+1][3+1];
		int[][] w = new int[N+1][3+1];
		
		//one 
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 3; j++) {
				w[i][j] = Integer.parseInt(st.nextToken());
				v[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= 3; j++) {
//				System.out.println(w[i][j] + "  "+ v[i][j]);
//			}
//		}
		int[][] dp = new int[2][T+1];
		//where k looks at the kth row of the values/weight array
		for (int k = 1; k <= N; k++) {
			for (int x = 0; x <= T; x++) {
				//going through each weight and value
				boolean ran = false;
				for (int a = 1; a <= 3; a++) {					
					if (w[k][a] > x) {
						
					}
					else {
						ran = true;
						dp[1][x] = Math.max(Math.max(dp[0][x],dp[0][x-w[k][a]] + v[k][a]),dp[1][x]);
					}
				}
				if (!ran) {
					dp[1][x] = dp[0][x];
				}
			}
			dp[0] = dp[1].clone();
//			for (int[] row: dp) {
//				for (int m: row) {
//					System.out.print(m + " ");
//				}
//				System.out.println();
//			}
		}
		
//		for (int[] row: dp) {
//			for (int m: row) {
//				System.out.print(m + " ");
//			}
//			System.out.println();
//		}
		System.out.println(dp[1][T]);
	}

}