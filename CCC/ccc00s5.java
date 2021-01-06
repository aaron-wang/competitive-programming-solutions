import java.util.*;
import java.io.*;

public class anythingrandom {
	static double dist(double x, double y, double x1, double y1) {
		return Math.sqrt((x - x1) * (x-x1) + (y - y1) * (y-y1));
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int M = Integer.parseInt(st.nextToken());
//		int S = Integer.parseInt(br.readLine());
//		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		//given low N, brute force is fine
		double[] px = new double[N];
		double[] py = new double[N];
		boolean[] eaten = new boolean[1000];
		//1000 x 1000 field 
		
		/*
		 .		. (1000,1000)
		 
		 
		 
		 .(0,0)	.
		 
		 --------
		 
		 */
		
		for (int i = 0; i < N; i++) {
			px[i] = Double.parseDouble(br.readLine());
			py[i] = Double.parseDouble(br.readLine());
		}
		//sweep across the bottom line
		for (double x = 0; x < 1000.00; x+=0.01) {
			int sheep = 0;
			double min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				double d = dist(px[i],py[i],x,0);
				if (d < min) {
					min = d;
					sheep = i;
				}
			}
			eaten[sheep] = true;
		}
		for (int i = 0; i < 1000; i++) {
			if (eaten[i]) {
				System.out.printf("The sheep at (%.2f, %.2f) might be eaten.%n",px[i],py[i]);
			}
		}
	}
}