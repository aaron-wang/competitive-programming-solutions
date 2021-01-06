import java.util.*;
import java.io.*;

public class ccc17_s3_nailed_it {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] boards = new int[2001];
		int[] sums = new int[4001];
		
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			boards[temp]++;
		}
		//list all pairs
		for (int i = 1; i <= 2000; i++) {
			//if the board exists
			if (boards[i] > 0) {
				//start at i, since all nums before should have been paired already
				for (int j = i; j <= 2000; j++) {
					//if equal pairs exist... don't overcount
					if (boards[j] > 0) {
						//else needed, one or the other - debugged (~5 mins)
						if (j == i) {
							sums[i*2] += boards[i]/2;
						}
						else {
							sums[i+j] += Math.min(boards[i], boards[j]);
						}
						//3 3 3 2 2
						//2 pairs of (3,2) max, so take limiting one
					}
				}
			}
		}
		int maxFenceLength = -1, diffHeights = -1;
		
		for (int i = 1; i <= 4000; i++) {
			//if # of sums is greater than current
			if (sums[i] > maxFenceLength) {
				maxFenceLength = sums[i];
				//reset count
				diffHeights = 1;
			}
			//counts # of heights, given same length
			else if (sums[i] == maxFenceLength) {
				diffHeights++;
			}
		}
//		diffHeights
		System.out.print(maxFenceLength + " " + diffHeights);
//		System.out.println();
//		System.out.println(Arrays.toString(sums));
//		System.out.println(Arrays.toString(boards));
	}
}