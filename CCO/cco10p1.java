import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		// t=0, 1
		
		//n when sleep, wake, 
		//wait n+1 to n+w_i-1]
		//n+w_i bark, sleep next second
		//if during wait or bark, ignore (so n)
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		int D = rr();
		for (int i = 0; i < D+1; i++) adj.add(new ArrayList<>());
		int[] w = new int[D+1];
		int[] dog = new int[D+1];
		Arrays.fill(dog,Integer.MIN_VALUE);
		dog[1] = 0;
		
		for (int i = 1; i <= D; i++) {
			w[i] = rr();
		}
		int F = rr();
		for (int i = 0; i < F; i++) {
			int a = rr(), b = rr();
			adj.get(a).add(b);
		}
		int T = rr();
		//inc
		int[] bark = new int[D+1];
		for (int t =0 ; t <= T; t++) {
			for (int i = 1; i <= D; i++) {
				if (t > dog[i] || t < dog[i]) continue;
				if (t == dog[i]) {
					bark[i]++;
				}
				for (int k: adj.get(i)) {
					int u = k;
					if (dog[u] < t) {
						dog[u] = t+ w[u];
					}
				}
				
			}
		}
		for (int i = 1; i <= D; i++) {
			out.println(bark[i]);
		}
		
		out.close();
		
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
	static String next() throws IOException {
		if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}
	static int rr() throws IOException {
		return Integer.parseInt(next());
	}
	
	static long rll() throws IOException {
		return Long.parseLong(next());
	}
	static double parseDouble() throws IOException {
		return Double.parseDouble(next());
	}
}