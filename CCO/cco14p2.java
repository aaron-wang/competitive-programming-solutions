import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		ArrayList<Edge> tm = new ArrayList<>();
		Graph g = new Graph(N+1,A,B);
		//note: directed, and A TO B not vice versa
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			g.add(u,v,w,c);
			tm.add(new Edge(u,v,w,c));
		}
		//check from A to B
		g.dijkstra(A, g.d,g.adj);
		g.dijkstra(B, g.d2,g.rev);
		
//		System.out.println(Arrays.toString(g.d));
//		System.out.println(Arrays.toString(g.d2));
		ArrayList<Edge> m = new ArrayList<>();
		for (Edge e: tm) {
			if (g.d[e.u] != Integer.MAX_VALUE && g.d2[e.v] != Integer.MAX_VALUE) {
				m.add(new Edge(e.c,g.d[e.u] + g.d2[e.v] + e.w));
			}
		}
//		System.out.println(m.size());
		Collections.sort(m);
		int[] cost = new int[m.size()+1];
	
//		cost[0] = m.get(0).w;
		for (int i = 0; i < m.size(); i++) {
			cost[i] = m.get(i).w;
			if (i >= 1) {				
				cost[i] += cost[i-1];
			}
		}
		
//		System.out.println(Arrays.toString(cost));
//		int asd = 0;
//		for (Edge e: m) {
//			System.out.printf("%d %d %d %n",e.w,e.c,asd);
//			asd++;
//		}
		//query each request value;
		int Q = Integer.parseInt(br.readLine());
		
		//now with prefix sum just calculate the loss
		for (int t = 0; t < Q; t++) {
			int D = Integer.parseInt(br.readLine());
			//query D
//			System.out.println("--------");
			int ans = Collections.binarySearch(m, new Edge(0,D));
//			System.out.println(ans + " D: " + D);
			boolean ran = false;
			
			if (ans < 0) { 
				ans =- (ans+1)-1;
				ran = true;
			}
			
			if (ans < 0) {
				System.out.println(0); 
			}
			else {
//			else ans++;
				int i = ans;
				if (!ran) {		
						for (i = ans; i < m.size(); i++) {						
//							System.out.println(m.get(i).c + " " + ans +" "+ m.get(ans).c);
							if (m.get(i).c == m.get(ans).c) {
//								System.out.println("HELLO" + i);
								continue;
							}
							else {
								break;
							}
						}
						i--;
					
				}
				System.out.println(cost[i]);
				
			}
			
		}
	
	}

}

class Graph {
    int N;
    boolean v[];
    int d[];
    int d2[];
    int A, B;
    ArrayList<LinkedList<Edge>> adj = new ArrayList<>();
    ArrayList<LinkedList<Edge>> rev = new ArrayList<>();
    Graph(int N, int A, int B) {
        this.A = A;
        this.B = B;
    	this.N = N;
        v = new boolean[N];
        d = new int[N];
        d2 = new int[N];
        for (int i = 0; i < N; i++) adj.add(new LinkedList<>());
        for (int i = 0; i < N; i++) rev.add(new LinkedList<>());
    }
    void add(int u, int v, int w, int c) {
        adj.get(u).add(new Edge(v,w));
        rev.get(v).add(new Edge(u,w));
    }
    void dijkstra(int s, int[] d, ArrayList<LinkedList<Edge>> A) {
        PriorityQueue<Edge> q = new PriorityQueue<>();
        Arrays.fill(d, Integer.MAX_VALUE);
        Arrays.fill(v,false);
        ArrayList<LinkedList<Edge>> adj = A;
        d[s] = 0;
        q.add(new Edge(s,0));

        while (!q.isEmpty()) {
            int a = q.poll().w;
//            System.out.println(a);
            if (v[a]) continue;
            v[a] = true;
            for (Edge e: adj.get(a)) {
            	int b = e.w; 
                int w = e.c;
                if (d[a] + w < d[b]) {
                    d[b] = d[a] + w;
                    q.add(new Edge(b, d[b]));
                }
            }
        }
    }
//    int dfsfind(int s) {
//    	if (v[s]) return -1;
//    	v[s] = true;
//    	if (adj.get(s).size() == 0) {
//    		if (s == B) {
//    			return 1;
//    		}
//    	}
//    	for (Edge e : adj.get(s)) {
//    		dfsfind(e.v);
//    	}
//    	return -10000;
//    }
}
class Edge implements Comparable<Edge>  {
    int u;
	int v;
    int w;
    int c;
    Edge(int w, int c) {
        this.w = w;
        this.c = c;
    }
//    Edge(int v, int w, int c) {
//        this.v = v;
//        this.w = w;
//        this.c = c;
//    }
    Edge(int u, int v, int w, int c) {
        this.u = u;
    	this.v = v;
        this.w = w;
        this.c = c;
    }
    public int compareTo(Edge e) {
        return this.c - e.c;
    }
}