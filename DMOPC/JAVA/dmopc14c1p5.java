import java.util.*;
import java.io.*;

//class Graph {
//	int N;
//	boolean visited[];
//	boolean isTel[][];
//	int d[];
//	Graph(int R, int C) {
////		this.N = N;
//		
//	}
//}
class Pair {
	int r, c;
	Pair(int r, int c) {
		this.r = r; this.c = c;
	}
}
public class dmopc_14_c1_p5 {
	static int R, C;
	static String[][] board;
	static boolean[][] visited;
	static int[][] d;
	static Queue<Pair> q;
	static boolean[][] isTel;
	static int minD = Integer.MAX_VALUE;
	static void search(int r, int c, int dX) {
		if (r < 0 || c < 0) {
			return;
		}
		if (r >= R || c >= C) {
			return;
		}
		
		if (board[r][c].equals("O")) {
//			return true;
//			System.out.println(board[r][c]);
			if (visited[r][c]) return;
			visited[r][c] = true;
			d[r][c] = dX + 1;
			q.add(new Pair(r,c));
			if (isTel[r][c]) {
				minD = Math.min(d[r][c],minD);
			}
		}
		else {
//			return false;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//O open
		//X wall - non existent
		
		//given teleportation device locations
		//how much time can be saved
		
		//zero indexed!!
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		//starting point
		int startR, startC;
		
		st = new StringTokenizer(br.readLine());
		startR = Integer.parseInt(st.nextToken());
		startC = Integer.parseInt(st.nextToken());

		int officeR, officeC;
		
		st = new StringTokenizer(br.readLine());
		officeR = Integer.parseInt(st.nextToken());
		officeC = Integer.parseInt(st.nextToken());
		
		board = new String[R][C];
		
		for (int i = 0; i < R; i++) {
			String row = br.readLine();
			for (int j = 0; j < C; j++) {
				//blah[j] = row.substring(i,i+1);
				board[i][j] = row.charAt(j) + "";
			}
		}
		
		
		isTel = new boolean[R][C];
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			//coord of T
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			isTel[x][y] = true;
		}
		
		visited = new boolean[R][C];
		d = new int[R][C];
		//BFS
		q = new LinkedList<>();
		
		d[startR][startC] = 0;
		visited[startR][startC] = true;
		q.add(new Pair(startR,startC));
		
		while (!q.isEmpty()) {
			Pair place = q.poll();
			//process here
			int rX = place.r;
			int cX = place.c;
			//up down left right
			search(rX-1,cX,d[rX][cX]);
			search(rX+1,cX,d[rX][cX]);
			search(rX,cX+1,d[rX][cX]);
			search(rX,cX-1,d[rX][cX]);
		}
		
		
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(d[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		if (isTel[startR][startC]) {
			minD = 0;
		}
		
		
		
//		System.out.println(Math.max(d[officeR][officeC] - minD,0));
//		System.out.println(d[officeR][officeC] - minD);
		
		System.out.println(d[officeR][officeC] - minD);
//		System.out.println(minD);
//		https://dmoj.ca/problem/dmopc14c1p5
	}

}