import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		/*
		 * edit: use bellman-ford on one node
		 * if there is a negative cycle, then it will be true at any node (negative path guaranteed)
		 * if distance to start is negative then it will be true (likely redundant check, but seems fine regardless)
		 * 
		 */
		for (int t = 0; t < T; t++) {			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			Graph g= new Graph(N+1);
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int L = Integer.parseInt(st.nextToken());
				g.add(A,B,L);
			}
			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int L = Integer.parseInt(st.nextToken());
				//negative edge
				g.add(A,B,-L);
			}
			
			boolean ans = false;

			ans |= g.bellford(1);
			//just test for negative cycle OR distance to start is negative
		
//			for (int[] arr: g.d) {
//				for (int m: arr) {
//					System.out.print(m + " ");
//				}
//				System.out.println();
//			}
			if (ans) System.out.println("YES");
			else System.out.println("NO");
			
		}
		
	}

}
class Graph {
    int N;
    boolean visited[];
    int d[];
    ArrayList<Edge> edges = new ArrayList<>();
    int[][] adja;
    Graph(int N) {
        this.N = N;
        d = new int[N];
    }
    void add(int u, int v, int w) {
    	edges.add(new Edge(u,v,w));
    	if (w > 0) {
    		edges.add(new Edge(v,u,w));
    	}
    }

    boolean bellford(int s) {
    	Arrays.fill(d,Integer.MAX_VALUE);
    	d[s] = 0;
    	for (int i = 1; i < N; i++) {
    		boolean red = false;
    		for (Edge e: edges) {
    			int a = e.u;
    			int b = e.v;
    			int w = e.w;
    			if (d[a] == Integer.MAX_VALUE) continue;
    			if (d[a] + w < d[b]) {
    				d[b] = d[a] + w;
    				red = true;
    			}
    		}
    		//i.e. N
    		if (i == N - 1) {
    			if (red) {
    				return true;
    			}
    		}
    		if (d[s] < 0) {
//    			break;
    			return true;
    		}
    	}
    	return false;
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