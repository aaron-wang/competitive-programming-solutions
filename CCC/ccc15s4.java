import java.util.*;
import java.io.*;
//old java code; fix in c++ when needed.
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
//		st = new StringTokenizer(br.readLine());
		Graph g = new Graph(N+1);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			g.add(a,b,w,h);
		}
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		g.dijkstra(A);
		//dijk A, d B
		int ans = 0x3f3f3f3f;
		for (int k = 0; k < K; k++) {
			ans = Math.min(g.d[B][k],ans);
		}
		for (int i = 0; i < g.N; i++) {
			for (int j = 0; j <= 200; j++) {
				g.d[i][j] = 0;
			}
		}
		for (int i = 0; i < g.N; i++) {
			g.v[i] = false;
		}
		g.dijkstra(B);
		//dijk A, d B
		for (int k = 0; k < K; k++) {
			ans = Math.min(g.d[A][k],ans);
		}
		ans = (ans == 0x3f3f3f3f ? -1 : ans);
		System.out.println(ans);

//		1413D
	}
}
class Graph {
    int N;
    boolean v[];
    int d[][];
    ArrayList<LinkedList<Edge>> adj = new ArrayList<>();
    Graph(int N) {
        this.N = N;
        v = new boolean[N];
        d = new int[N][201];
        for (int i = 0; i < N; i++) adj.add(new LinkedList<>());
    }
    void add(int u, int v, int w, int h) {
        adj.get(u).add(new Edge(v,w,h));
        adj.get(v).add(new Edge(u,w,h));
    }
    void dijkstra(int s) {
        PriorityQueue<Edge> q = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {        	
        	Arrays.fill(d[i], 0x3f3f3f3f);
        }
        d[s][0] = 0;

        q.add(new Edge(s,0,0));

        while (!q.isEmpty()) {
            Edge a = q.poll();
            if (v[a.v]) continue;
            v[a.v] = true;
            for (Edge e: adj.get(a.v)) {
                int b = e.v; 
                int w = e.w;
                int h = e.h;
                for (int k = 0; k <= 200; k++) {
                	if (k + h > 200) continue;
                	if (d[a.v][k] == 0x3f3f3f3f) continue;
		              if (d[a.v][k] + w < d[b][k+h]) {
		              	d[b][k+h] = d[a.v][k] + w ;
		                  q.add(new Edge(b, d[b][k+h],k+h));
		              }
                }
//                if (d[a.v][a.h] == Integer.MAX_VALUE) continue;
//                if (d[a.v][a.h] + w < d[b][a.h+h]) {
//                	d[b][a.h+h] = d[a.v][a.h] + w ;
//                    q.add(new Edge(b, d[b][a.h+h],a.h+h));
//                }
            }
        }
    }
}
class Edge implements Comparable<Edge> {
    int v;
    int w;
    int h;
    Edge(int v, int w, int h) {
        this.v = v;
        this.w = w;
        this.h = h;
    }
    public int compareTo(Edge e) {
        return this.w - e.w;
    }
}