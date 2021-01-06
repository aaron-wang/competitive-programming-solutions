import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class Main {
	static int[] tr, v, ff;
	static int MAXN;
	static int sum(int x, int[] tr) {
		int sum = 0;
		for (;x > 0; x -= (x&-x)) {
			sum += tr[x];
		}
		return sum;
	}
	static void update(int x, int val, int[] tr) {
		for (;x < tr.length; x+=(x&-x)) {
			tr[x] += val;
		}
	}
	public static void main(String[] args) throws IOException {
//		int N = Integer.parseInt(br.readLine());
		
//		int N = Integer.parseInt(st.nextToken());
//		st = new StringTokenizer(br.readLine());
		int T = rr();
//		MAXN = (int) 1e9;
		sc[] a = new sc[T];
		tr = new int[T+1];
		for (int i= 0; i < T; i++) {			
			a[i] = new sc(rr(),i+1);
		}
	
		Arrays.sort(a);
		double rk = 0;
		for (int i = 0; i < T; i++) {
			update(a[i].b,1,tr);
			rk += a[i].b - sum(a[i].b-1,tr);
		}
		rk = rk/T;
		DecimalFormat df = new DecimalFormat("#.##");
		System.out.printf("%s",df.format(rk));

	}
	static class sc implements Comparable<sc> {
		int a, b;
		sc(int a, int b) {this.a = a; this.b = b;}
		public int compareTo(sc o) {
			return -(o.a-this.a);
		}
		
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