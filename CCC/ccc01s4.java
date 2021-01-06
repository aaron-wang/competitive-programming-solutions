import java.util.*;

import java.io.*;

public class ccc01_s4 {
	public static double distance(double x1, double x2, double y1, double y2) {
		return Math.sqrt(Math.pow(x1 - x2,2) + Math.pow(y1-y2,2));
	}
	public static boolean fitsTriangleInequality(double a, double b, double c) {
		if (Math.pow(a,2) + Math.pow(b,2) > Math.pow(c,2)) {
			if (Math.pow(a,2) + Math.pow(c,2) > Math.pow(b,2)) {
				if (Math.pow(b,2) + Math.pow(c,2) > Math.pow(a,2)) {
					return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		//since n  < 10, just brute force circumscribing triangles
			// i.e. choose 3, create triangles = total --> 10C3 = 120 - so not too long
		// double since approximation needed
		
		double[] x = new double[n];
		double[] y = new double[n];
		double diameter = -1;
		
		//in[put
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x[i] = Double.parseDouble(st.nextToken());
			y[i] = Double.parseDouble(st.nextToken());
		}
		//iterate through all pairs
		double s,a,b,c,current;
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				for (int k = j+1; k <n; k++) {
					//do heron's formula for good approximation
					//side a,b,c distance formula to gen lengths
//					points i, j, and k
//					i[x] and i[y] etc.
					
//					3C2 = 3 ways total
					a = distance(x[i],x[j],y[i],y[j]);
					b = distance(x[i],x[k],y[i],y[k]);
					c = distance(x[j],x[k],y[j],y[k]);
					//semi perimeter
					s = (a+b+c)/2.0;
					current = 0;
					if (s== 0) {
						continue;
					}
					// triangle inequality check
					if (fitsTriangleInequality(a,b,c)) {
						current = 0.5 * a * b *c * (1.0/ (Math.sqrt(s * (s-a) * (s-b) * (s-c))));
					}
					//otherwise just take raw input
					else {
						current = Math.max(current,a);
						current = Math.max(current,b);
						current = Math.max(current,c);
					}
					
					diameter = Math.max(diameter,current);
				}
			}
		}
		System.out.printf("%.2f",diameter);
	}

}