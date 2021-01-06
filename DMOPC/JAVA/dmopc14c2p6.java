import java.util.*;
import java.io.*;
public class Main {
	static int[] tr;
//	static int[] a;
	static int MAXN;
	
	static void update(int x, int val) {
		for (int i= x; i <= MAXN; i+=(i&-i))  {
			tr[i] += val;
		}
	}
	
	static int query(int x) {
		int ret = 0;
		for (int i = x; i > 0; i -= (i&-i)) {
			ret += tr[i];
		}
		return ret;
	}
	
	public static void main(String[] args) throws IOException {
//		int N = Integer.parseInt(br.readLine());
//		int M = rr();
//		int N = rr();
		int N = rr();
		MAXN = N;
		tr = new int[N+1];
		Pair[] hh = new Pair[N+1];
		for (int i = 1; i <= N; i++) {
//			a[i] = rr();
			hh[i] = new Pair(-rr(),i);
//			hh.add(new Pair(a[i],i));
		}
//		Collections.sort(hh);
		Arrays.sort(hh,1,N+1);
		
		int Q = rr();
		
		Pair[] qq = new Pair[Q];
		
		for (int i = 0; i < Q; i++) {
			int a = rr(); int b = rr(); int q = rr();
			a++;b++;
			qq[i] = new Pair(-q,a,b,i);
//			qq[i].a= q;
//			qq[i].b= a;
//			qq[i].c= b;
//			qq[i].i = i;
			
		}
		Arrays.sort(qq);
		
		int[] ans = new int[Q];
		int pd = 0;
//		for (Pair p: qq) {
//			if (p == null) continue;
//			System.out.printf("%d %d%n",p.a,p.b);
//		}
		for (int i = 0; i < Q; i++) {
			for (int j = pd+1; j <= N; j++) {
				//where .a is the q (height)
//				System.out.println(qq[i].a);
				if (-qq[i].a <= -hh[j].a) {
//					System.out.printf("%d %d",hh[j].b,hh[j].a);
					update(hh[j].b,-hh[j].a);
					pd++;
				}
				else {
					break;
				}
			}
			ans[qq[i].i] = (query(qq[i].c) - query(qq[i].b - 1));
		}
		//freq update and bit
		
		for (int i = 0; i < Q; i++) out.println(ans[i]);
		
		out.close();
	}
	static class Pair implements Comparable<Pair> {
		int a, b, c, i;
		Pair(int a, int b, int c, int d) {
			this.a =a;
			this.b = b;
			this.c = c;
			this.i = d;
		}
		Pair(int a, int b) {
			this.a = a; this.b = b;
		}
		public int compareTo(Pair o) {
			return this.a-o.a;
		}
		
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine().trim());
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