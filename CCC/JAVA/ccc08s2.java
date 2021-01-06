import java.util.Scanner;
import java.io.*;

public class ccc08_s2_pennies_in_the_ring {

	public static void main(String[] args) throws IOException {
//		Scanner scan = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int radius = Integer.parseInt(br.readLine());
		
		while (radius != 0) {	
//			int count = 1 + 4 * radius; //origin
//			for (int x = radius; x >= 1 ; x--) {
//				boolean skip = false;
//				for (int y = x; y >= 1; y--) {
//					if (!skip) {
//						double dist = Math.sqrt(x*x + +y*y);
//					
//						if (dist <= radius) {
//							count+= 4;
//							if (y != x) {
//								count+= 4;
//							}
//							skip = true;
//						} 
//					} else {
//						count+= 8;
//					}
//				}
//			}
			int count = 0;
			for (int x = 1; x <= radius; x++) {
				count += Math.floor(Math.sqrt(radius * radius - x * x)) + 1;
			}
			count = count * 4 + 1;
			System.out.println(count);
			radius = Integer.parseInt(br.readLine());
		}
	}

}