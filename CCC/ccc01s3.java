import java.util.*;
import java.io.*;

public class ccc01_s3_strategic_bombing {
	static ArrayList<LinkedList<Integer>> adj = new ArrayList<>();
	static boolean visited[];
	static boolean secondVisited[];
	static int ignoreNode;
	
	public static class Graph {
		static int N;
		Graph(int N) {
			this.N = N;
			visited = new boolean[N];
			secondVisited = new boolean[N];
			for (int i = 0; i < N; i++) {
				adj.add(new LinkedList<>());
			}
		}
		public void addEdge(int source, int dest) {
			adj.get(source).add(dest);
			adj.get(dest).add(source);
		}
		//should be A, and B respectively
		public static void DFS(int source) {
			if (visited[source]) return;
			visited[source] = true;
			for (int u: adj.get(source)) {
				if (u != ignoreNode) {
					DFS(u);
				}
			}
		}
		public static void secondDFS(int source) {
			if (visited[source] || secondVisited[source]) return;
			secondVisited[source] = true;
			for (int u: adj.get(source)) {
				if (u != ignoreNode) {
					secondDFS(u);
				}
			}
			
		}
		public static void resetVisited() {
			for (int i = 0; i < N; i++) {
				visited[i] = false;
			}
		}
		public static void resetSecondVisited() {
			for (int i = 0; i < N; i++) {
				secondVisited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] next = br.readLine().split("");
		int a, b;
		Graph g = new Graph(26);
//		int nodes = 0;
		String alpha = "&ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		while (!next[0].equals("*")) {
			a = next[0].charAt(0) - 64 - 1;
			b = next[1].charAt(0) - 64 - 1;
			g.addEdge(a, b);
//			a = next[0].charAt(0);
//			b = next[1].charAt(0);
//			System.out.printf("%c, %c%n",a,b);
			next = br.readLine().split("");
		}
		ArrayList<Integer> roads = new ArrayList<>();
		int o = -1, p = -1;

		if (adj.get(0).size() <= 1) {
			o = 0 + 1;
			p = adj.get(0).element() + 1;
			roads.add(o);
			roads.add(p);
		}
		if (adj.get(1).size() <= 1) {
			o = 1 + 1;
			p = adj.get(1).element() + 1;
			roads.add(o);
			roads.add(p);
		} else {
			//additional B check - redundant... but whatever
			
			for (int u: adj.get(1)) {
				//must be non cyclic...?
				Graph.resetVisited();
				ignoreNode = 1;
				Graph.DFS(u);
				//either non visited or of under size
				if (!visited[0]) {
					o = 1 + 1;
					p = adj.get(1).element() + 1;
					roads.add(o);
					roads.add(p);
					break;
				}
				if (adj.get(u).size() <= 1) {
					Graph.resetSecondVisited();
					Graph.secondDFS(0);
					if (secondVisited[0]) {
						ignoreNode = u;
						Graph.resetVisited();
						Graph.resetSecondVisited();
						Graph.DFS(1);
						if (!visited[0]) {
							o = 1 + 1;
							p = adj.get(1).element() + 1;
							roads.add(o);
							roads.add(p);
						}
 					}
				}
//				}
			}
		}
		for (int i = 0; i < 26; i++) {
			if (adj.get(i).size() > 0) {
//				System.out.println("hello");
				Graph.resetVisited();
				ignoreNode = i;
				Graph.DFS(0);
				if (!visited[1]) {
					for (int u: adj.get(i)) {
						if (!visited[u] && u != 1) {
							Graph.resetSecondVisited();
							Graph.secondDFS(u);
							if (secondVisited[1]) {
								//check if both satisfy
								ignoreNode = u;
								Graph.resetVisited();
								Graph.resetSecondVisited();
								Graph.DFS(i);
								if (!visited[0] || !visited[1]) {
									o = i + 1;
									p = u + 1;
	//								String add = o + "" + p;
	//								roads.add(add);
									roads.add(o);
									roads.add(p);
								}
							}
						} 
					}
				}
			}
		}
		int counter = 0;
		while (!roads.isEmpty()) {
			int tempA = roads.remove(0);
			int tempB = roads.remove(0);
			counter++;
//			System.out.println(tempA + "" + tempB);
			System.out.printf("%s%s%n", alpha.charAt(tempA),alpha.charAt(tempB));
		}
		System.out.printf("There are %d disconnecting roads.%n",counter);
	}

}