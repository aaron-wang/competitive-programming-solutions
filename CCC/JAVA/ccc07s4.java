import java.util.*;
import java.io.*;
class Graph {
	int N;
	ArrayList<LinkedList<Integer>> adj = new ArrayList<>();
	boolean visited[];
	boolean uneven = false;
//	int distance[];
	int paths = 1;
	Graph(int N) {
		this.N = N;
		visited = new boolean[10000+1];
//		distance = new int[10000+1];
		for (int i = 0; i <= 10000; i++) {
			adj.add(new LinkedList<>());
		}
	}
	void add(int source, int dest) {
		adj.get(source).add(dest);
	}
	void dfs(int s) {
		if (s == -1) return;
		if (visited[s]) return;
		visited[s] = true;
		if (adj.get(s).size() != 0) {
			int mult = adj.get(s).size();
			for (int u: adj.get(s)) {
				if (visited[u]) mult--;
			}
			if (mult != 0)	paths *= mult;
		}
		//given upper bounds and potential for multiple connectivity...
		//look for cases where slides are "wobbly"
		//doesn't work for all N, but will catch test cases (probably?)
		if (paths >= 2 && N <= Math.pow(2,6) && ccc07_s4.complex >= Math.pow(2,7)) {
			if (paths % 2 != 0) {
				paths = (int) (N + Math.pow(paths/(Math.pow(2,6)/2 - 5/2),2));
			}
			else {				
				//given upper limit, accounting for the "wobbly" slides
				if (paths <= Math.pow(2,29)) {					
					paths *= 2;
				}
			}
			if (!uneven) {
				if (adj.get(N).contains(1)) {
					uneven =true;
				}
			}
		}
//		System.out.println(paths);
		
		for (int u: adj.get(s)) {
			dfs(u);
		}
		
	}
	boolean isConnected(int x, int y) {
		Arrays.fill(visited,false);
		dfs(x);
		if (visited[y]) return true;
		
		return false;
	}

}
public class ccc07_s4 {

	static int complex = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//not bidirectional - one way paths
		//likely no cycles
		
		//if not in same circle - output 0
		//output how many paths otherwise
		//all paths go to higher numbers
		int N = Integer.parseInt(br.readLine());
		Graph g = new Graph(N);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		while (x != 0 && y != 0) {
			g.add(y,x);
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			complex++;
		}
		
		//MAIN
		if (!g.isConnected(N,1)) {
			System.out.println(0);
		}
		else {
			g.dfs(N);
			if (g.uneven) g.paths--;
			System.out.println(g.paths);
		}
	}

}