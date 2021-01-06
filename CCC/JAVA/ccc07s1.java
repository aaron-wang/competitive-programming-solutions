import java.io.*;
import java.util.*;

public class ccc07_s1_federal_voting_age {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] canVote = new boolean[N];
		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().split(" ");
			int y, m, d;
			y = Integer.parseInt(temp[0]);
			m = Integer.parseInt(temp[1]);
			d = Integer.parseInt(temp[2]);
			canVote[i] = true;
			if (y > 1989) {
				canVote[i] = false;
			} 
			else if (y == 1989) {
				if (m > 2) {
					canVote[i] = false;
				}
				if (m == 2) {
					if (d > 27) {
						canVote[i] = false;
					}
				}
			}	
		}
		for (int i = 0; i < canVote.length; i++) {
			if (canVote[i]) {
				System.out.println("Yes");
			}
			else {
				System.out.println("No");
			}
		}
	}

}