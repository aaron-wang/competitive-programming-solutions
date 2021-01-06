import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		
//		StringTokenizer st = new StringTokenizer(br.readLine());
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
				
		//small n, small m
//		HashSet<Integer> h = new HashSet<>();
		boolean[] full = new boolean[G+1];
		int count = 0;
		for (int i = 0; i < P; i++) {
			int p = Integer.parseInt(br.readLine());
			boolean added= false;
			for (int j = p; j >= 1; j--) {
//				if (!h.contains(j)) {
//					h.add(j);
//					added = true;
//					break;
//				}
				if (!full[j]) {
					count++;
					full[j] = true;
					added = true;
					break;
				}
			}
			if (!added) {
				break;
			}
		}
//		System.out.println(h);
		System.out.println(count);
		
	}
}