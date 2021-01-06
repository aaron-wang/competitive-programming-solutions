import java.util.*;
import java.io.*;
//very old java code..
//replace #4 ... - alt dec
public class ccc17_s4 {
	static int D;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		Graph g = new Graph(N + 1,M,D);
		for (int i = 1; i <= M; i++) {
			boolean b = false;
			if (i <= N-1) {
				b = true;
			}
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			g.add(A,B,C,b);
		}
//		for (Edge e: g.edges) {
//			if (e.active) {
//				System.out.println("ACTIVE");
//			}
//			System.out.printf("%d %d %d%n",e.u,e.v,e.w);
//		}
//		if (D == 0) {
		int ans = g.kruskal();
//		} 
//		else {
//			System.out.println(g.k2());
//		}
//		System.out.println(!g.edges.get(g.BW-1).active);
		if (!g.edges.get(g.BW-1).active) {
//			System.out.println("ran");
			if (g.k2()) {
				ans--;
//				System.out.println("can remove");
			}
		}
//		System.out.println(g.weight);
//		for (Edge e: g.edges) {
//			System.out.printf("%d %d %d %b%n",e.u,e.v,e.w,e.active);
//		}
//		if (!g.edges.get(Math.min(N-1,M-1)).active) {
//			if (g.k2()) {
//				ans--;
//			}
//		}
		
		System.out.println(ans);
		
	}
}

class Graph {
	int N;
	int D = 0;
	int BW = 0;
	int ww = 0;
	int M = 0;
	int max = 0;
	ArrayList<Edge> edges = new ArrayList<>();
	int weight = 0;
	// ArrayList<LinkedList<Edge>> adj = new ArrayList<>();
	Graph(int N, int M, int D) {
		this.N = N;
		this.M = M;
		this.D = D;
	}

	void add(int u, int v, int w, boolean b) {
		edges.add(new Edge(u, v, w,b));
	}

	int kruskal() {
		Collections.sort(edges);
		link = new int[N];
		size = new int[N];
		int count = 0;
		for (int i = 1; i < N; i++) link[i] = i;
		for (int i = 1; i < N; i++) size[i] = 1;
		for (Edge e : edges) {
			if (ww == N-2) break;
			BW++;
			int a = e.u;
			int b = e.v;
			if (!same(a, b)) {
				unite(a, b);
				ww++;
				if (!e.active) {
					count++;
				}
				weight += e.w;
				max = e.w;
			}
			
		}
//		BW = edges.get(N-1).w;
		return count;
		
	}
	boolean k2() {
//		Collections.sort(edges);
		
		int count = 0;
		for (int i = 1; i < N; i++) link[i] = i;
		for (int i = 1; i < N; i++) size[i] = 1;
		for (Edge e : edges) {
//			if (e.v == N-1) break;
			int a = e.u;
			int b = e.v;

			if (!same(a, b)) {
//				System.out.printf("%d %d %d %b%n",e.u,e.v,e.w,e.active);
//				System.out.println(D);
				if (e.w < max || (e.w == max && e.active)) {					
					unite(a, b);
				}
				else if (e.active && e.w <= D) {
					return true;
				}
//				if (!e.active) count++;
//				else if (e.w <= D) {
//				}
			}
		}
	
		return false;
	}

	int[] link;
	int[] size;

	int find(int x) {
		while (x != link[x])
			x = link[x];
		return x;
	}

	boolean same(int a, int b) {
		return find(a) == find(b);
	}

	void unite(int a, int b) {
		a = find(a);
		b = find(b);
		if (size[a] < size[b]) {
			size[b] += size[a];
			link[a] = b;
		} else {
			size[a] += size[b];
			link[b] = a;

		}
	}
}

class Edge implements Comparable<Edge> {
	int u;
	int v;
	int w;
	boolean active;

	Edge(int u, int v, int w, boolean b ) {
		this.u = u;
		this.v = v;
		this.w = w;
		this.active =b ;
	}

	public int compareTo(Edge e) {
		return this.w - e.w;
	}
}