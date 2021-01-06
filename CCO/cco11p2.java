import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int M = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		Graph g = new Graph(N,S);
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			if (u == 1) {				
				g.add(s,t,d,d);
			}
			else {
				g.add(s,t,d,0);
			}
		}
		g.dijkstra(0);
//		System.out.println(Arrays.toString(g.d));
//		System.out.println(Arrays.toString(g.sun));
//		System.out.println(Arrays.toString(g.mincost));
		if (g.d[N-1] == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(g.d[N-1]);
		}
	}
	
}
class Graph {
    int N;
    boolean vi[];
    int d[];
    int mincost[];
    int S;
    ArrayList<LinkedList<Edge>> adj = new ArrayList<>();
    Graph(int N, int S) {
        this.N = N;
        this.S = S;
        vi = new boolean[N];
        d = new int[N];
        mincost = new int[N];
        for (int i = 0; i < N; i++) adj.add(new LinkedList<>());
    }
    void add(int u, int v, int w, int SUN) {
        adj.get(u).add(new Edge(v,w,SUN));
        adj.get(v).add(new Edge(u,w,SUN));
    }
    void dijkstra(int s) {
    	PriorityQueue<Edge> q = new PriorityQueue<>();
    	Arrays.fill(d,Integer.MAX_VALUE);
    	Arrays.fill(mincost,Integer.MAX_VALUE);
    	
//    	d[s] = 0;
//    	mincost[s] = 0;
    	q.add(new Edge(s,0,0));
    	
    	while(!q.isEmpty()) {
    		Edge a= q.poll();
    		int u = a.v;
//    		int w = a.w;
    		int cost = a.cost;
//    		if (vi[u]) continue;
//    		vi[u] = true;
    		
    		if (a.w < d[u]) {    		
    			d[u] = a.w;
				for (Edge e: adj.get(u)) {
					int v = e.v;
					int w = e.w;
	//    				int x =0;
					if (e.cost + a.cost <= S) {
						mincost[v] = e.cost + a.cost;
//						d[v] = d[u] + w;
						q.add(new Edge(v,a.w + w,a.cost+e.cost));
					}
				}
    		}
    	}
    }
}
class Edge implements Comparable<Edge> {
    int v;
    int w;
//    boolean SUN;
    int cost;
//    int e;
    Edge(int v, int w, int COST) {
        this.v = v;
        this.w = w;
        this.cost = COST;
    }
//    Edge(int v, int w, int u, int e) {
//        this.v = v;
//        this.w = w;
//        this.suno = u;
//        this.e = e;
//    }
    public int compareTo(Edge e) {
//        return this.w - e.w;
    	return this.cost - e.cost;
    }
}