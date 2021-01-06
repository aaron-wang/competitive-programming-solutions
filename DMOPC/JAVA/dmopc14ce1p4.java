import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		Graph g = new Graph(V + 1);
		for (int i = 0; i < E; i++) {			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			g.add(m,n,(d/(s+0.0)) * 60);
			
		}
		g.dijkstra(1);
		//multiply by 4/3
//		System.out.println(Arrays.toString(g.total));
//		System.out.println(Arrays.toString(g.v));
//		System.out.println(Arrays.toString(g.d));
		//least intersections
		System.out.println(g.total[V]);
//		for (Integer e: g.path) {
//			System.out.println(e);
//		}
		System.out.printf("%.0f",(g.d[V] * 4)/3.0 - g.d[V]);
	}

}
class Graph {
    int N;
    boolean v[];
    double d[];
    int total[];
    ArrayList<Integer> path = new ArrayList<>();
    //edge list
    ArrayList<LinkedList<Edge>> adj = new ArrayList<>();
    Graph(int N) {
        this.N = N;
        v = new boolean[N];
        d = new double[N];
        total = new int[N];
        for (int i = 0; i < N; i++) adj.add(new LinkedList<>());
    }
    void add(int v, int u, double w) {
        adj.get(v).add(new Edge(u,w));
        adj.get(u).add(new Edge(v,w));
    }
    void dijkstra(int s) {
    	PriorityQueue<Edge> q = new PriorityQueue<>();
    	Arrays.fill(d,Double.MAX_VALUE);
    	d[s] = 0;
    	
    	q.add(new Edge(s,0));
    	
    	while (!q.isEmpty()) {
    		int a = q.poll().v;
    		if (v[a]) continue;
    		v[a] = true;
    		path.add(a);
    		for (Edge e: adj.get(a)) {
    			int b = e.v;
    			double t = e.t;
    			if (d[a] + t < d[b]) {
    				total[b] = total[a] + 1;
    				d[b] = d[a] + t;
    				q.add(new Edge(b,d[b]));
    			}
    		}
    	}
    }
}
class Edge implements Comparable<Edge> {
    int v;
    double t;
    Edge(int v, double t) {
        this.v = v;
        this.t = t;
    }
    public int compareTo(Edge e) {
        if (this.t - e.t >= 0) {
        	return 1;
        }
        else {
        	return -1;
        }
    }
}