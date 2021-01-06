import java.util.*;
import java.io.*;
class Graph {
	int N;
	boolean[] visited;
	int[] d;
	ArrayList<LinkedList<Integer>> adj = new ArrayList<>();
	Graph(int N) {
		this.N = N;
		visited = new boolean[N];
		d = new int[N];
		for (int i = 0; i < N; i++) adj.add(new LinkedList<>());
	}
	void add(int v, int u) {
		if (adj.get(v).contains(u)) return;
//		if (adj.get(u).contains(v)) return;
		adj.get(v).add(u);
		adj.get(u).add(v);
	}
	void delete(int v, int u) {
		adj.get(v).remove((Integer) u);
		adj.get(u).remove((Integer) v);
	}
	int smallBfs(int s) {
		//friend of friends
		Arrays.fill(d,0);
		Arrays.fill(visited,false);
		int ff = 0;
		
		Queue<Integer> q = new LinkedList<>();
		
//		visited[s] = true;
		q.add(s);
		d[s] = 0;
		visited[s] = true;
		
		while (!q.isEmpty()) {
			int v = q.poll();
//			if (visited[v]) continue;
//			visited[v] = true;
			for (int i: adj.get(v)) {
				if (visited[i]) continue;
				visited[i] = true;
//				if (d[v] + 1 <= 2) {
					d[i] = d[v] + 1;
//					if (d[i] == 2) {
//						ff++;
//					}
					q.add(i);
//				}
			}
			
		}
		for (int m: d) {
			if (m == 2) ff++;
			
		}
//		if (d[s] == 2) ff--;
//		System.out.println(Arrays.toString(d));
		
		return ff;
		
	}
	void dijkstra(int s) {
		PriorityQueue<Pair> q = new PriorityQueue<>();
		Arrays.fill(d,Integer.MAX_VALUE);
		Arrays.fill(visited,false);
		
//		visited[s] = true;
		d[s] = 0;
		
		q.add(new Pair(s,0));
		
		while (!q.isEmpty()) {
			int a = q.poll().v;
			if (visited[a]) continue;
			visited[a] = true;
			for (int u: adj.get(a)) {
				if (d[a] + 1 < d[u]) {
					d[u] = d[a] + 1;
					q.add(new Pair(u,d[u]));
				}
			}
		}
	}
}
class Pair implements Comparable<Pair>{
	int v;
	int w;
	Pair(int v, int w) {
		this.v = v;
		this.w = w;
	}
	public int compareTo(Pair w2) {
		return this.w - w2.w;
	}
}
public class ccc09_s3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		Graph g = new Graph(50);
		//min 1, max 49
		
		g.add(6,1);
		g.add(6,2);
		g.add(6,3);
		g.add(6,4);
		g.add(6,5);
		g.add(6,7);

		g.add(3,5);
		g.add(4,3);
		g.add(4,5);
		
		g.add(3,15);
		
		g.add(7,8);
		g.add(8,9);
		g.add(9,10);
		g.add(10,11);
		g.add(11,12);
		g.add(9,12);
		
		g.add(12,13);
		g.add(15,13);
		g.add(13,14);
		
		g.add(16,17);
		g.add(17,18);
		g.add(16,18);
		
		
		
		String str = "";
		
		str = br.readLine();
		
		while (!str.equals("q")) {
			if (str.equals("i")) {
				int x = Integer.parseInt(br.readLine());
				int y = Integer.parseInt(br.readLine());
				g.add(x,y);
			}
			if (str.equals("d")) {
				int x = Integer.parseInt(br.readLine());
				int y = Integer.parseInt(br.readLine());
				g.delete(x,y);
			}
			if (str.equals("n")) {
				int x = Integer.parseInt(br.readLine());
				System.out.println(g.adj.get(x).size());
			}
			if (str.equals("f")) {
				int x = Integer.parseInt(br.readLine());
				System.out.println(g.smallBfs(x));
				
			}
			if (str.equals("s")) {
				int x = Integer.parseInt(br.readLine());
				int y = Integer.parseInt(br.readLine());
//				Arrays.fill(g.d,-1);
//				Arrays.fill(g.visited,false);
//				g.d[x] = 0;
				
				g.dijkstra(x);
				
				if (g.d[y] == Integer.MAX_VALUE) System.out.println("Not connected"); 
				else System.out.println(g.d[y]);
			}
			//test input
			
			str = br.readLine();
		}

	}

}