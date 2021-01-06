import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		//old; update with new template+methods when possible 09/27
		Graph g = new Graph(N+1);
	
		
		for (int i = 1; i <= N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			g.add(u,v);
		}
		g.dfs2(1,-1);
		System.out.println(g.L + 1 +" " + g.group);
		//omitted ex
	}

}

class Graph {
	int N;
	boolean v[];
	long d[];
	long md[];
	int[] p;
	int truemax = 0;
	long group = 0;
	long L = 0;
	int max = 0;
	ArrayList<LinkedList<Integer>> adj = new ArrayList<>();

	Graph(int N) {
		this.N = N;
		v = new boolean[N];
		d = new long[N];
		md = new long[N];
		p = new int[N];
		for (int i = 0; i < N; i++)
			adj.add(new LinkedList<>());
	}

	void add(int v, int u) {
		adj.get(v).add(u);
		adj.get(u).add(v);
	}

	void dfs2(int s, int prev) {
		d[s] = 0;
		md[s] = 1;
		for (int u: adj.get(s)) {
			if (u == prev) continue;
			dfs2(u,s);
			if (d[s] + d[u] > L - 1) {
				L = d[s] + d[u] +1;
				group = md[s] * md[u];
			}
			else if (d[s] + d[u] == L - 1) {
				group += (md[s] * md[u]);
			}
			if (d[s] - 1 < d[u]) {
				md[s] = md[u];	
				d[s] = d[u]; d[s]++;
			}
			else if (d[s] - 1 == d[u]) {
				md[s] += md[u];
			}
		}
	}
}