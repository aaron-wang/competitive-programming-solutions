import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		int N = Integer.parseInt(br.readLine());
//		long closest = ((N-1)*(N+1-1))/2 + 1;
//	
		int i = 1;
		int mop = 1;
		long sum= 0 ;
		while (true) {
//			System.out.println(i);
			if (i > N) {
				int count = i - (i - mop + 1);
//				System.out.println(count);
//				System.out.println(i - mop + 1);
				for (int j = 0; j < count; j++) {
					sum+= i - mop + 1;
					i++;
				}
				break;
			}
			i += mop;
			mop++;
		}
		System.out.println(sum);
	}
}