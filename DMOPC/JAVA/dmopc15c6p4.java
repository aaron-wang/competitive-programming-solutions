import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int M = Integer.parseInt(st.nextToken());

//		int n = Integer.parseInt(st.nextToken());
//		int m = Integer.parseInt(st.nextToken());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Graph g = new Graph(N + 1);
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
//			g.add(a,a+1,1);
//			arr[i] = a;
			g.add(i,i+1,a);
		}
		for (int i = 1; i <= N-K; i++) {
			g.add(i,i+K,0);
		}
		
		//find 2nd min of all 
		System.out.println(g.kruskal());
		
	}
}

class Graph {
	int N;
	ArrayList<Edge> edges = new ArrayList<>();

	// ArrayList<LinkedList<Edge>> adj = new ArrayList<>();
	Graph(int N) {
		this.N = N;
	}

	void add(int u, int v, int w) {
		edges.add(new Edge(u, v, w));
	}

	int kruskal() {
		Collections.sort(edges);
		link = new int[N];
		size = new int[N];
		int weight = 0;
		for (int i = 1; i < N; i++)
			link[i] = i;
		for (int i = 1; i < N; i++)
			size[i] = 1;
		for (Edge e : edges) {

			int a = e.u;
			int b = e.v;
			if (!same(a, b)) {
				unite(a, b);
				weight += e.w;
			}
		}
		return weight;
		
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

	Edge(int u, int v, int w) {
		this.u = u;
		this.v = v;
		this.w = w;
	}

	public int compareTo(Edge e) {
		return this.w - e.w;
	}
}