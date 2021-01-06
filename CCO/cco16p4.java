import java.util.*;
import java.io.*;

public class Main {
	static void f(int r, int c) {
		b[r][c] = (!b[r][c]);
	}
	static boolean[][] b;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int M = Integer.parseInt(st.nextToken());
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		int G = Integer.parseInt(br.readLine());
		b = new boolean[N][N];
		HashMap<String,Integer> m = new HashMap<>();
		for (int g = 0; g < G; g++) {
			for (int j = 0; j < N; j++) {				
				String s = br.readLine();
				for (int c = 0 ; c < N; c++) {
					if (s.charAt(c) == 'R') {
						b[j][c] = true;						
					}
					else {
						b[j][c] = false;
					}
				}
			}
			/*
			 # # \
			 # # \
			 \ \ \
			 
			 1 0 - -> 0 1.. etc
			 */
			
			for (int i = 0; i < N - 1; i++) {
				for (int j = 0; j < N-1; j++) {
					if (b[i][j]) {
						f(i,j);
						f(i+1,j);
						f(i,j+1);
						f(i+1,j+1);
					}
				}
			}
			String curr = "";
			//now flatten the boards
			for (int i = 0; i < N; i++) {
				if (b[N-1][i]) {
					curr+= "1";
				}
				else {
					curr += "0";
				}
			}
			for (int i = 0; i < N; i++) {
				if (b[i][N-1]) {
					curr+= "1";
				}
				else {
					curr += "0";
				}
			}
			m.putIfAbsent(curr,0);
			m.put(curr,m.get(curr)+1);
			
		}
		int count = 0;
		
		for (String w: m.keySet()) {
			int ww = m.get(w);
			count += (ww * (ww-1)) /2;
		}
		System.out.println(count);
		
	}

}