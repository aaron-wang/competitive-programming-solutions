import java.util.*;
import java.io.*;

class Graph {
    int N;
    boolean visited[];
    int d[];
    //
    ArrayList<LinkedList<Edge>> adj = new ArrayList<>();
//    ArrayList<LinkedList<Edge>> tree = new ArrayList<>();
    Graph(int N) {
        this.N = N;
        visited = new boolean[N];
        d = new int[N];
        for (int i = 0; i < N; i++) adj.add(new LinkedList<>());
//        for (int i = 0; i < N; i++) tree.add(new LinkedList<>());
    }
    void add(int v, int u, int w) {
        adj.get(v).add(new Edge(u,w));
        //if bidirectional
        adj.get(u).add(new Edge(v,w));
    }
//    void W_dijkstra(int s) {
//    	PriorityQueue<Edge> q = new PriorityQueue<>();
//    	Arrays.fill(d,-1);
//    	d[s] = Integer.MAX_VALUE;
//    	
//    	q.add(new Edge(s, Integer.MAX_VALUE));
//    	
//    	while (!q.isEmpty()) {
//    		Edge a = q.poll();
//    		if (visited[a.v]) continue;
//    		visited[a.v] = true;
//    		for (Edge e: adj.get(a.v)) {
//    			int b = e.v;
//    			int w = e.maxW;
////    			if (w > d[b]) {
//    			d[b] = Math.min(w,a.maxW);
//    			q.add(new Edge(b,d[b]));
////    			}
//    		}
//    	}
//    }
    void W_prim(int s) {
    	PriorityQueue<Edge> q = new PriorityQueue<>();
    	Arrays.fill(d,-1);
    	d[s] = Integer.MAX_VALUE;
    	
    	q.add(new Edge(s, Integer.MAX_VALUE));
    	
    	while (!q.isEmpty()) {
    		Edge a = q.poll();
    		if (visited[a.v]) continue;
    		visited[a.v] = true;
    		for (Edge e: adj.get(a.v)) {
    			int b = e.v;
    			int w = e.maxW;
    			if (w > d[b]) {
    				d[b] = w;
    			}
    			q.add(new Edge(b,d[b]));
    			
    		}
    		
    	}
    }
}
class Edge implements Comparable<Edge> {
    int v;
    int maxW;
    Edge(int v, int maxW) {
        this.v = v;
        this.maxW = maxW;
    }
    public int compareTo(Edge e) {
//        return this.maxW - e.maxW;
        return e.maxW - this.maxW;
        // max to min
    }
}
public class ccc03_s5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int roads = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		//question: what is the largest weight that can be driven
		// through all destination cities, 
//		i.e. which bridge is the bottle neck?/ 
//		choose the bridges with highest weight capacity
//		starting from city one
		
		Graph g = new Graph(N+1);
		
		for (int i = 0; i < roads; i++) {
			//x y w (bi edge x to y, with weight w)
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			g.add(x,y,w);
		}
		
		int vD[] = new int[d];
		
		for (int i = 0; i < d; i++) {
			//v_d (destination cities you must visit)
			vD[i] = Integer.parseInt(br.readLine());
		}
//		g.W_dijkstra(1);
		g.W_prim(1);
		
//		System.out.println(Arrays.toString(g.d));
		int min = Integer.MAX_VALUE;
		for (int vdc: vD) {
			min = Math.min(min,g.d[vdc]);
		}
		System.out.println(min);
	}

}