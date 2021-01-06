import java.util.*;
import java.io.*;

public class ccc05_s3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<int[][]> q = new ArrayList<>();
		
		int[] RA = new int[N];
		int[] CA = new int[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			RA[i] = r;
			CA[i] = c;
			q.add(new int[r][c]);
			for (int j = 0; j < r; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < c; k++) {
					q.get(i)[j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		int Rsize = 1;
		int Csize = 1;
		for (int l: RA) {
			Rsize *= l;
		}
		for (int l: CA) {
			Csize *= l;
		}
//		System.out.println(Rsize);
//		System.out.println(Csize);
		
//		int[][] tensor = new int[Rsize][Csize];
		
		int[][] back = q.get(0);
		int backRow = RA[0];
		int backCol = CA[0];
		int[][] result = null;
		for (int i = 1; i < N; i++) {
			int[][] current = q.get(i);
			//multiply current with back
			
			//used to store intermediate result
			int[][] tensor = new int[RA[i] * backRow][CA[i] * backCol];
			
			//for each element inback, multiply with current, and place in right spot
			// X X X
			// X X X --> X
			
			for (int r= 0; r < backRow; r++) {
				for (int c = 0; c < backCol; c++) {
					int element = back[r][c];
//					for (int tR = 0; tR < backRow * RA[i]; tR++) {
//						for (int tC = 0; tC < backRow * CA[i]; tC++) {
//							tensor[1][1] = element * 
//						}
//					}
					for (int cR = 0; cR < RA[i]; cR++) {
						for (int cC = 0; cC < CA[i]; cC++) {
							tensor[r*(RA[i]) + cR][c *(CA[i])+cC] = element * current[cR][cC];
//							System.out.println(r * cR + cR  + " " + c * cC + cC);
						}
					}
				}
			}
			backRow = RA[i] * backRow;
			backCol = CA[i] * backCol;
			result = tensor;
			back = result;
		}
//				
//		for (int[] row: result) {
//			System.out.println(Arrays.toString(row));
//		}
//		System.out.println();
		
		//max element 0
		//min element 1
		
		//max row sum 2
		//min row sum 3
		
		//max col sum 4
		//min col sum 5
		
		long[] ans = new long[6];
		
		ans[0] = result[0][0];
		ans[1] = Long.MAX_VALUE;
		ans[2] = 0;
		ans[3] = Long.MAX_VALUE;
		ans[4] = 0;
		ans[5] = Long.MAX_VALUE;
		
		int[] rowSum = new int[Rsize];
		int[] colSum = new int[Csize];
		
		
		
		for (int i = 0; i < Rsize; i++) { 
			for (int j = 0; j < Csize; j++) {
				int current = result[i][j];
				rowSum[i] += current;
				colSum[j] += current;
				if (current > ans[0]) {
					ans[0] = current;
				}
				if (current < ans[1]) {
					ans[1] = current;
				}
			}
			if (i == 0) ans[2] = rowSum[i];
			if (i == 0) ans[3] = rowSum[i];
			if (rowSum[i] > ans[2]) {
				ans[2] = rowSum[i];
			}
			if (rowSum[i] < ans[3]) {
				ans[3] = rowSum[i];
			}
		}
		for (int i = 0; i < Csize; i++) {
			if (i == 0) ans[4] = colSum[i];
			if (i == 0) ans[5] = colSum[i];
			if (colSum[i] > ans[4]) {
				ans[4] = colSum[i];
			}
			if (colSum[i] < ans[5]) {
				ans[5] = colSum[i];
			}
			
		}
		for (long a: ans) {
			System.out.println(a);
		}
		
	}
	
}