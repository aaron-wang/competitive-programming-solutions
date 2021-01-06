import java.util.*;
import java.io.*;

public class Main {
	static int[] tr, a, tr2;
	static int MAXN = (int) 1e5 * 5;
	static int sum(int x, int[] tr) {
	    int sum = 0;
	    for (int i = x; i > 0; i-=(i&-i)) {			
	        sum += tr[i];
	    }
	    return sum;
	}
	static void update(int x, int val, int[] tr) {
	    for (int i = x; i < tr.length; i+=(i&-i)) {
	        tr[i] += val;
	    }
	}
	static int sum(int a, int b, int[] tr) {
		return sum(b,tr) - sum(a-1,tr);
	}

	public static void main(String[] args) throws IOException {
//		int N = Integer.parseInt(br.readLine());
		
		
		int N = rr();
		tr = new int[MAXN+1];
		tr2 = new int[MAXN+1];
//		int[] arr = new int[N];
//		int end = 0, start = 0, mid=-1;
		long ans = 0;
		for (int i = 0; i < N; i++) {
			int p = rr();
//			int x = sum(p,tr);
//			int y = sum(N-p+1,tr2);
			ans+= Math.min(sum(p,tr),sum(N-p+1,tr2));
			update(p,1,tr);
			update(N-p+1,1,tr2);
//			if (i == 0) {
//				update(p,p,tr);
//				mid = p;
//				end = p+1;
//				start = p-1;
//			}
//			else {
//				if (p > mid) {
//					//tail
//					if (end <= N) {
//						update(end,p,tr);
//						end++;
//					}
//				}
//				else {
//					//head
//					if (start >= 1) {
//						update(start,p,tr);
//						start--;
//					}
//				}
//			}
		}
		System.out.println(ans);
		
		
		
	}
	
	
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static String next() throws IOException {
		if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}
	static int rr() throws IOException {
		return Integer.parseInt(next());
	}
	static long parseLong() throws IOException {
		return Long.parseLong(next());
	}
	static double parseDouble() throws IOException {
		return Double.parseDouble(next());
	}
}