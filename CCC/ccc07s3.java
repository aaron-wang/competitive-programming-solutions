import java.util.*;
import java.io.*;
class Graph {
	int N;
	ArrayList<Integer> adj = new ArrayList<>();
	boolean visited[];
	int distance[];
	Graph(int N) {
		this.N = N;
		visited = new boolean[10000+1];
		distance = new int[10000+1];
		for (int i = 0; i <= 10000; i++) {
			adj.add(-1);
		}
	}
	void add(int source, int dest) {
		adj.set(source,dest);
	}
	void dfs(int s) {
		if (s == -1) return;
		if (visited[s]) return;
		visited[s] = true;
		
		dfs(adj.get(s));
		
	}
	boolean isConnected(int x, int y) {
		Arrays.fill(visited,false);
		dfs(x);
		if (visited[y]) return true;
		
		return false;
	}
	void dijkstra(int root) {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int i =0; i <= 10000; i++) distance[i] = Integer.MAX_VALUE;
		Arrays.fill(visited,false);
		distance[root] = 0;
		q.add(root);
		while (!q.isEmpty()) {
			int a = q.poll();
			if (visited[a]) continue;

			visited[a] = true;
			
			int b = adj.get(a);
			if (b != -1) {
//				if (distance[a] + 1 < distance[b]) {
				q.add(b);
				distance[b] = distance[a] + 1;	
//					System.out.println(b + ":" + distance[b]);
//				}				
			}
		}
	}
}
public class ccc07_s3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//not bidirectional - one way paths
		//identify cycles
		
		//if not in same circle - output no
		//if yes, then yes X - where X is the separation
		int N = Integer.parseInt(br.readLine());
		//add one to account for 0
		Graph g = new Graph(N);
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			g.add(x,y);
//			System.out.println(x + " " + y);
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		while (x != 0 && y != 0) {
//			System.out.println("is connected?:" +g.isConnected(x,y));
//			System.out.println(x + "" + y);
//			Arrays.fill(g.visited,false);
			boolean x1 = g.isConnected(x,y);

			if (!x1) {
				System.out.println("No");
			}
			else {

				g.dijkstra(x);
				System.out.printf("Yes %d%n",g.distance[y] - 1);

			}
	
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			Arrays.fill(g.visited,false);
		}
	}

}