import java.io.*;
import java.util.*;

public class ccc13_s2_bridge_transport {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int maxWeight = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[] carts = new int[N + 4]; //0 = 1
		for (int i = 4; i < carts.length; i++) {
			carts[i] = Integer.parseInt(br.readLine());
		}
		// 0 1 2 3 4 5 6 7 8
		// X X X X 1 2 3 4 5
		int current = 0;
		int prev = 0;
		int T = 0;
		
		for (int i = 1; i < carts.length - 3; i++) {
			prev = carts[i - 1];
			current = current - prev + carts[i + 3];
//			System.out.printf("%d, %d\t",i, current);
			T = i;
			if (current > maxWeight) {
				T = i - 1;
//				System.out.println("bob");
				break;
			}
		}
		
		System.out.println(T);
		
//		System.out.println(Arrays.toString(carts));
		
//		int T = 4;
//		if (current > maxWeight) {
//			T = 0;
//			System.out.print("0");
//		}
//		for (int i = 1; i < N - 3; i++) {
////			sumQuery[i] = sumQuery[i - 1] - prev + carts[i + 3];
//			current = current - prev + carts[i + 3];
//			
//		}
		
	}

}