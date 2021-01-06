import java.util.*;
import java.io.*;

public class ccc07_s5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {			
			StringTokenizer st = new StringTokenizer(br.readLine());			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			int[] pins = new int[N+2];
			pins[0] = 0;
			pins[N+1] = 0;
			int max = pins[0];
			
			for (int j = 1; j <= N; j++) {
				pins[j] = Integer.parseInt(br.readLine());
//				if (pins[j] > max) max = pins[j];
			}
			
			int[] value = pins.clone();
			
			int[][] solve = new int[N+1][K+1];
			
//			solve[0][0] = 0;
			Arrays.fill(solve[0],0);
			for (int j = 0; j < K; j++) {
				solve[j][0] = 0;
			}
			
			//solve(x,k)
			//where x is first x pins
			//k is how many balls
			
			solve[1][1] = pins[1];
			
			
			//n - # of pins
			//k - how many bowling balls
			//w - how many adj pins can be hit by the ball
			for (int k = 1; k <= K; k++) {
				for (int x = 1; x <= N; x++) {
					int points = 0;
					for (int m = x; m > x - W; m--) {
						if (m >= 1) {
							points += pins[m];
						}
						else {
							break;
						}
					}
					if (x >= 1) {						
						solve[x][k] = Math.max(solve[x-1][k],0);
					}
					if (x - W>= 0) {
						solve[x][k] = Math.max(solve[x-W][k-1] + points,solve[x][k]);
					}
//					solve[x][k] = 2;
//					solve[x][k] = Math.max(0,solve[x][k-1]);
				}
			}
			System.out.println(solve[N][K]);
//			for (int[] arr: solve) {
//				for (int i2: arr) {
//					System.out.print(i2 + " ");
//				}
//				System.out.println();
//			}
		}
	}

}