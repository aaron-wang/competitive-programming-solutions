import java.util.*;
import java.io.*;

public class ccc19_s2_pretty_average {
	public static boolean isPrime(int num) {
		for (int i = 2; i <= (int) Math.floor(Math.sqrt(num)); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		int N = -1;
		for (int i = 0; i < cases; i++) {
			N = Integer.parseInt(br.readLine());
			int A = N + 2;
			int B = N - 2;
			//jump - eg. for N = 9 and N = 8
			// 7 *9* 11
			// 7 *8* 9 // V accounts for difference
			if (N % 2 == 0) {
				A-= 1;
				B+= 1;
			}
			
			
			for (int j = 0; j < N/2; j++) {
				if (isPrime(A) && isPrime(B)) {
					System.out.println(A + " " + B);
					break;
				}
				
				A += 2;
				B -= 2;
				

 			}
			
		}
		
	}

}