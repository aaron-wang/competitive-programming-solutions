import java.util.*;
import java.io.*;

public class ccc09_j2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*
		 brown trout X
		 northern pike X
		 yellow pickerel X
		 total P <= TOTAL
		 */
		
		int[] points = new int[3];
		
		int total = 0;
		
		points[0] = Integer.parseInt(br.readLine());
		points[1] = Integer.parseInt(br.readLine());
		points[2] = Integer.parseInt(br.readLine());
		
		total = Integer.parseInt(br.readLine());
		int currentTotal = total;
		int count = 0;
		
		//trout
		for (int i = 0; i <= total/points[0]; i++) {
			//pike
//			currentTotal -= i;
			for (int j = 0; j <= total/points[1]; j++) {
//				currentTotal = -= j;
				for (int k = 0; k <= total/points[2]; k++) {
					if (i > 0 || j > 0 || k > 0) {
						if (points[0] * i + points[1] * j + points[2] * k <= total) {
							System.out.printf("%d Brown Trout, %d Northern Pike, %d Yellow Pickerel%n",
									i,j,k);							
							count++;						
						}
					}
//					currentTotal = total - j;
				}
//				currentTotal = total - i;
			}
//			currentTotal = total;
			//pickerel
		}
		System.out.println("Number of ways to catch fish: " + count);
		
		
	}

}