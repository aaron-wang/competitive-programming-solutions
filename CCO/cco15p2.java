import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
				
		//small n, small m
		Graph g = new Graph(n);
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			g.add(s,d,l);
		}
		int[] dp = new int[n];
		dp[0] = 0;
		for (int i = 1; i < n; i++) {
			for (Edge e: g.adj.get(i)) {
				dp[i] = Math.max(dp[i],dp[e.v] + e.w);
			}
		}
		System.out.println(dp[n-1]);
	}
}
class Graph {
	int N;
	int[] d;
	ArrayList<LinkedList<Edge>> adj = new ArrayList<>();
	Graph(int N) {
		this.N = N;
		d = new int[N];
		for (int i =0; i <N; i++) adj.add(new LinkedList<>());
	}
	void add(int u, int v, int w) {
		adj.get(v).add(new Edge(u,w));
	}
}
class Edge implements Comparable<Edge> {
	int v;
	int w;
	Edge(int v, int w) {
		this.v = v; this.w = w;
	}
	public int compareTo(Edge o) {
		return w - o.w;
	}
}