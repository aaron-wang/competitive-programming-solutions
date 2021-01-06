import java.util.*;
import java.io.*;

public class Main {
//	static int[][] dp; 
//	static Integer[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] scales = new int[H+1][W+1];
		
		for (int h = 1; h <= H; h++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= W; i++) {
				scales[h][i] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] sum = new int[H+1][W+1];
		sum[1][1] =scales[1][1];
		
		for (int h = 1; h <= H; h++) {
			for (int w= 1; w <= W; w++) {
				sum[h][w] = sum[h][w-1] + scales[h][w] + sum[h-1][w] - sum[h-1][w-1];
			}
		}
		int max = 0;
		for (int r = 1; r <= H; r++) {
			for (int c = 1; c <= W; c++) {
//				for (int y = 1; y <= H; y++) {
//					for (int x = 1; x <= W; x++) {
//						if ((y-r+1) * (x-c+1) <= N) {
//							max = Math.max(max,sum[y][x] - sum[y][c-1] - sum[r-1][x]+sum[r-1][c-1]);
//						}
//					}
//				}
				//with length b, go do width
				//<--->
				for (int b = 1; b <= W && (N/b > 0); b++) {
					int k = Math.min(N/b,H);
//					int y = b;
//					System.out.println(k * b);
					int x = Math.min(b + c-1,W);
					int y= Math.min(k + r-1,H);
//					System.out.printf("%d %d %d%n",k,x,y);
					max = Math.max(max,sum[y][x] - sum[y][c-1] - sum[r-1][x]+sum[r-1][c-1]);
				}
			}
		}
		System.out.println(max);
		
//		for (int[] m: sum) {
//			for (int mm: m) {
//				System.out.print(mm + " ");
//			}
//			System.out.println();
//		}
		
	
		
		
		
		
	}

}