import java.util.*;
import java.io.*;
public class Main {
	
	static int[] dfn, low,stk, sz,last;
	static boolean[] v;
	static int bcc,cnt,N,stt,ans;
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//	static HashSet<Integer> last = new HashSet<>();
//	static boolean[] last;
	static void tarjan(int s, int prev) {
		cnt++;
		dfn[s] = cnt; low[s] = cnt;
		stk[++stt] = s;
		v[s] = true;
		for (int u: adj.get(s)) {
			if (u == prev) continue;
			if (v[u]) {//if visited
				low[s] = Math.min(low[s],dfn[u]);
			}
			else {//not
				tarjan(u,s);
				low[s] = Math.min(low[s],low[u]);
			}
		}
		if (dfn[s] == low[s]) {
			int temp = 0,x=0;
			do {
				x=stk[stt--];
				temp++;
				v[x] = false;
			} while (x!=s);
//			out.println("HERE :" + x);
//			last.add(s);
//			last[s] = true;
			sz[++bcc] = temp;
		}
	}
	static void add(int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	public static void main(String[] args) throws IOException {
		N = rr()+1;
		for (int i = 0; i < N; i++) adj.add(new ArrayList<>());
		dfn = new int[N+1];
		low = new int[N+1];
		stk = new int[N+1];
		sz = new int[N+1];
		last = new int[N+1];
		v = new boolean[N+1];
//		last = new boolean[N+1];
		
		int R = rr();
		for (int i = 0; i < R; i++) {
			int a = rr(), b =rr();
			add(a,b);
		}
		
		tarjan(1,-1);
		
//		for (int i = 1; i <= bcc; i++) {
//			if (sz[i] == 1) ans++;
//			out.println("SIZE: " + sz[i]);
			
//		}
		for (int i = 1; i < N; i++) {
			for (int u: adj.get(i)) {
				if ((low[i] ^ low[u])!=0) ++last[low[i]];
			}
		}
		for (int i = 1; i < N; i++) if (last[i] == 1) ans++;
		out.println((ans + 1)/2);
//		if (bcc != 1) {			
//			for (int m: last) {
//				int aa = 2;
//				for (int u: adj.get(m)) {
//					if (last.contains(u)) {
//						aa--;
//						if (aa <= 0) {
//							break;
//						}
//					}
//				}
//				out.println(m +" "+aa);
//				ans+= aa;
//			}
//		}
		
		
//		out.println((int) Math.ceil(ans/2.0));
		//print min roads needed
		
		
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
	static double parseDouble() throws IOException {return Double.parseDouble(next());}
}