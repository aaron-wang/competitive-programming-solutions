import java.util.*;
import java.io.*;

public class ccc11_j5 {

	public static void main(String[] args) throws IOException{
		//N is always the top
		//N - 1 people below
		
		// input tells us that person "j" (input) invited i 
		
		// j -> i
		
		//so j above i
		
		// N -> ... -> j -> i
		//   \
		//	  `> ... -> ...
		
		//also constraints are very small, N <= 6, so you could 
		//just declare a small initialized array too
		
		//ways[x] = 1 (if creating empty set)
		
		//in other cases: 
//		either remove the inviter (+1) or 
		//remove all friends under the inviter (ways[j])
		//ways[x] = (ways[j] + 1) * ...
		//this will count all sets
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] ways = new int[N+1];
		
		for (int i = 0; i < N+1; i++) {
			ways[i] = 1;
		}
		
		for (int i = 1; i <= N-1; i++) {
			int inviter = Integer.parseInt(br.readLine());
//			ways[i] = 1;
			ways[inviter] = ways[inviter] * (ways[i] + 1);
		}
		System.out.println(ways[N]);
	}

}