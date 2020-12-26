import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		int M = Integer.parseInt(st.nextToken());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		//every r consecutive row of houses must have at least two cameras:
		
		boolean[] cam = new boolean[N];
		for (int i = 0; i < K; i++) {
			int a= Integer.parseInt(br.readLine());
//			cam[i] = a;
			cam[a-1] = true;
		}
		
//		System.out.println(
		int ans = 0;
		int count[] = new int[N];
		
		count[0] = 0;
		for (int i = 0; i < R; i++) {
			if (cam[i]) count[0]++;
		}
//		System.out.println(count[0]);
		if (count[0] <= 1) {
			for (int j = R-1; j >= 0; j--) {
				if (!cam[j]) {
					cam[j] = true;
					ans++;
					count[0]++;
				}
				if (count[0] >= 2) break;
			}
		}
//		for (int x = 0; x <= 0 + R - 1; x++) {
//			char out = 'X';
//			if (cam[x]) {
//				out = 'C';
//			}
//			System.out.print(out);
//		}
//		System.out.println();
		
		for (int i = 1; i <= N - R; i++) {
			//subarray (i,i+R)
			count[i] = count[i-1];
			if (cam[i-1]) count[i]--;
			if (cam[i+R-1]) count[i]++;
//			System.out.println(count[i] + " " + i);
			while (count[i] <= 1) {
				for (int j = R+i-1; j >= i; j--) {
					if (!cam[j]) cam[j] = true;
					ans++;
					count[i]++;
					if (count[i] >= 2) break;
				}
			}
//			for (int x = i; x <= i + R - 1; x++) {
//				char out = 'X';
//				if (cam[x]) {
//					out = 'C';
//				}
//				System.out.print(out);
//			}
//			System.out.println();
		}
		
//		System.out.println(Arrays.toString(count));
		System.out.println(ans);
//		for (boolean b: cam) {
//			char C = 'X';
//			if (b) {
//				C = 'C';
//			}
//			System.out.print(C+ " ");
//			
//		}
	}

}