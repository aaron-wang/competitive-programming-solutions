import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		/*
		 * looks similar to cco12p2 ?
		 */
		//N - 5 * 10^3
		//M - 10^5
		//W_i - 5 * 10^3
		//int should be fine, memory might exceed, TLE probably
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Graph g= new Graph(N+1);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			g.add(A,B,L);
		}
		//find paths going "forward" and "backwards"
		//1:with one bidirectional and another single?
		//2:with two bidirectional and then regular meet? - or do we need a "third" graph
		g.dijkstra(1,g.d,g.adj);
		g.dijkstra(N,g.d2,g.backadj);
		int ans = Integer.MAX_VALUE;
		//find normal SSSP of 1
		int last = g.d[N];
		//now process each node, sequentially from 1 to N
		//sort of "meet" in the middle
		for (int i = 1; i <= N; i++) {
			for (Edge e: g.adj.get(i)) {
				//*remember that there may be integer overflows if certain paths don't "exist"
//				if (g.d[i] == Integer.MAX_VALUE) continue;
				if (g.d2[e.v] == Integer.MAX_VALUE) continue;
//				System.out.printf("%d %d %d%n",g.d[i],g.d2[e.v],e.w);
				//join two separate paths, add weight in between
				int distance = g.d[i] + g.d2[e.v] + e.w;
				//this will find the next shortest path
				if (distance > last) {
					if (distance < ans) {
						ans = distance;
					}
				}
//				System.out.println(last);
			}
		}
		if (ans == Integer.MAX_VALUE) ans = -1;
		
		System.out.println(ans);
		
	}

}
class Graph {
    int N;
    boolean visited[];
    int d[];
    int d2[];
    //edge list
    ArrayList<LinkedList<Edge>> adj = new ArrayList<>();
    ArrayList<LinkedList<Edge>> backadj = new ArrayList<>();
   
    Graph(int N) {
        this.N = N;
        //omitted visited array for convenience of simple INF dist check
        
//        visited = new boolean[N];
        d = new int[N];
        d2 = new int[N];
        for (int i = 0; i < N; i++) adj.add(new LinkedList<>());
        for (int i = 0; i < N; i++) backadj.add(new LinkedList<>());
    }
    void add(int u, int v, int w) {
        adj.get(u).add(new Edge(v,w));
        adj.get(v).add(new Edge(u,w));
        backadj.get(v).add(new Edge(u,w));
        backadj.get(u).add(new Edge(v,w));
    }
    //special dijkstra for back and forth given the original and "reverse" graphs
    void dijkstra(int s, int[] d, ArrayList<LinkedList<Edge>> adj) {
        PriorityQueue<Edge> q = new PriorityQueue<>(); 
        Arrays.fill(d, Integer.MAX_VALUE);
        d[s] = 0;

        q.add(new Edge(s,0));

        while (!q.isEmpty()) {
            Edge u = q.poll();
//            if (visited[a]) continue;
//            visited[a] = true;
            //if current edge w heavier than current
            //dont use visited array for now...
            if (u.w > d[u.v]) continue;
            for (Edge e: adj.get(u.v)) {
                int b = e.v; 
                int w = e.w;
                if (d[u.v] + w < d[b]) {
                    d[b] = d[u.v] + w;
                    q.add(new Edge(b, d[b]));
                }
            }
        }
    }
}
class Edge implements Comparable<Edge> {
    int v;
    int w;
    Edge(int v, int w) {
        this.v = v;
        this.w = w;
    }
    public int compareTo(Edge e) {
        return this.w - e.w;
    }
}