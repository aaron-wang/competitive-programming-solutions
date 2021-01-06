import java.util.*;

import java.io.*;

public class ccc10_j5_knight_hop {
	static boolean[][] visited;
	static int[][] distance;
	
	public static class Pos {
		int x; 
		int y;
		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public static ArrayList<Pos> knightJump(Pos pos) {
			int x = pos.x;
			int y = pos.y;
			ArrayList<Pos> possible = new ArrayList<>();
			
			// 2 up down
			for (int i = -1; i <= 1; i+=2) {
				for (int j = -1; j <= 1; j+=2) {
//					System.out.printf("%d,%d %n",i,j);
					int moveX = pos.x + j;
					int moveY = pos.y + i * 2;
//					System.out.println(moveX + " " + moveY);
					if (moveY >= 0 && moveY < 8) { 
						if (moveX >= 0 && moveX < 8) {
							if (!visited[moveX][moveY]) {
								possible.add(new Pos(moveX, moveY));
							}
						}
					}
				}
			}
			// 1 up down
			for (int i = -1; i <= 1; i+=2) {
				for (int j = -1; j <= 1; j+=2) {
					int moveX = pos.x + j * 2;
					int moveY = pos.y + i;
//					System.out.println(moveX + " " + moveY);
					if (moveY >= 0 && moveY < 8) { 
						if (moveX >= 0 && moveX < 8) {
							if (!visited[moveX][moveY]) {
								possible.add(new Pos(moveX, moveY));
							}
						}
					}
				}
			}
			return possible;
		}
	}
	public static void BFS(Pos source, Pos end) {
		LinkedList<Pos> q = new LinkedList<>();
		distance = new int[8][8];
		
		q.add(source);
		visited[source.x][source.y] = true;
		
		while (!q.isEmpty()) {
			Pos current = q.pop();
			
			for (Pos pos: Pos.knightJump(current)) {
				if (!visited[pos.x][pos.y]) {
					visited[pos.x][pos.y] = true;
					distance[pos.x][pos.y] = distance[current.x][current.y]+ 1;
					q.add(pos);
					if (pos == end) {
						return;
					}
				}
			}
			
//			for (int i = 0; i < 8; i++) {
//				for (int j = 0; j < 8; j++) {
//					System.out.print(distance[i][j] + "\t");
//				}
//				System.out.println();
//			}
//			System.out.println(">>>");
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		int[][] board = new int[8][8];
		visited = new boolean[8][8];
		
		String[] temp = br.readLine().split(" ");
		Pos start = new Pos(Integer.parseInt(temp[0]) - 1,Integer.parseInt(temp[1]) - 1);
		
		temp = br.readLine().split(" ");
		Pos end = new Pos(Integer.parseInt(temp[0]) - 1,Integer.parseInt(temp[1]) - 1);

		BFS(start, end);
		
//		for (int i = 0; i < 8; i++) {
//			for (int j = 0; j < 8; j++) {
//				System.out.print(distance[i][j] + "\t");
//			}
//			System.out.println();
//		}
//		System.out.println(Arrays.deepToString(distance));
//		System.out.println
		System.out.println(distance[end.x][end.y]);
	}

}