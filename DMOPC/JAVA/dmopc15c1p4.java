import java.io.*;
import java.util.*;

public class Main {
	static int limit = 148734;
	static boolean[] isPrime = new boolean[limit + 1];
	static ArrayList<Integer> primes = new ArrayList<>();
	
	public static void sieve() {
		isPrime[2] = true;
		for (int i = 3; i <= limit; i+= 2) { 
			isPrime[i] = true;
			for (int j = 3; j <= Math.sqrt(i); j+= 2) {
				if (i % j == 0) {
					isPrime[i] = false;
					break;
				}
			}
		}
		
		for (int i = 0; i <= limit; i++) {
			if (isPrime[i]) {
				primes.add(i);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		/*
		Rory - multiples of X
		Tuka - 0 or 1
		Leiei - prime number
		Itami - destroy remainders
		 */
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int candies = Integer.parseInt(st.nextToken());
		
		limit = candies;
		sieve();
		
		int X = Integer.parseInt(st.nextToken());
		
		long ways = 0;
		//OLD
//		System.out.println((primes));
//		for (int r = 0; r <= 1; r++) {
//			candies -= r;
//			for (int i = primes.size() - 1; i >= 0; i--) {
//				
//				int currentPrime = primes.get(i);
//				
////				if (candies - currentPrime > 0) {
//				candies-= currentPrime;					
////				}
////				if (candies > 0) {					
////					ways = ways + candies/X + 1;
////				}
////				else {
////					ways++;
////				}
//				
//				for (int j = 0; j <= candies; j += X) {
////					if (j > candies) break;
//					ways++;
////					System.out.printf("%d,%d,%d%n",r,currentPrime,j);
//				}
//				
//				candies = limit - r;
//			}			
//		}
//		System.out.println(ways);
		//OLD ^^
//			candies -= r;
		int bufferWays = 0;
		
		for (int i = primes.size() - 1; i >= 0; i--) {
//			for (int r = 0; r <= 1; r++) {
//			candies -= r;
			int currentPrime = primes.get(i);
			
//				if (candies - currentPrime > 0) {
			candies-= currentPrime;					
//				}
//				if (candies > 0) {					
//					ways = ways + candies/X + 1;
//				}
//				else {
//					ways++;
//				}
			
			for (int j = 0; j <= candies; j += X) {
//					if (j > candies) break;
				ways++;
				bufferWays++;
//					System.out.printf("%d,%d,%d%n",r,currentPrime,j);
			}
			
			candies %= X;
			
			if (candies > 0) ways += bufferWays;
			else ways += bufferWays -1;
			
			candies = limit;
			bufferWays = 0;
//			}
		}			
//		}
		System.out.println(ways);
	}
}