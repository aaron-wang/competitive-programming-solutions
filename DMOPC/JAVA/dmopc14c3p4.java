import java.io.*;
import java.util.*;

public class Main {
	static int factors[];
	static int range = 100001;
	static int[] exponents;
	static ArrayList<Integer> primeFactors;
	
	public static void makePrimeFactors() {
		factors = new int[range+1];
		factors[2] = 2;
		
		for (int i = 3; i <= range; i+=2) {
			factors[i] = i;
		}
		
		
		for (int i = 3; i <= range; i+=2) {
			for (int j = 3; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					factors[i] = 0;
					break;
				}
			}
		}
		
		primeFactors = new ArrayList<Integer>();
		
		for (int i = 0; i < factors.length; i++) {
			if (factors[i] != 0) {
				primeFactors.add(factors[i]);
			}
		}
		
		
	}
	
	public static int countFactors(int num) {
//		int count = 1; //add one for "1" as a factor
		
		exponents = new int[primeFactors.size()];
		
//		int originalNum = num;
		
		int i = -1; 
		
		for (int factor: primeFactors) {
			i++;
			if (factor > num || num == 0) {
				break;
			}
			while (num % factor == 0) {
//				System.out.println("b:" + i);
				exponents[i]++;
				num /= factor;
			}
		}
		
//		for (int i = 3; i <= Math.sqrt(num); i+=2) {
//			while (num % i == 0) {
//				count++;
//				num /= i;
//			}
//		}
		int result = 1;
		
//		System.out.println(Arrays.toString(exponents));
		
		for (int j = 0; j < exponents.length; j++) {
			if (exponents[j] != 0) {
				result = result * (exponents[j] + 1);
			}
		}
		
		return result;
	}
	
	static int[] countOfFactors = new int[range + 1];
	
	public static void countFactorsList() {
		countOfFactors[1] = 1;
		countOfFactors[2] = 1;
		for (int f: primeFactors) {
			countOfFactors[f] = 2;
		}
		
		for (int i = 1; i <= range; i++) {
			if (countOfFactors[i] == 0) {
				countOfFactors[i] = countFactors(i);
//				System.out.println("ran");
			}
		}
	}
	
	public static int outputRange(int desiredFactors, int a, int b) {
		int count = 0;
		
		for (int i = a; i <= b; i++) {
			if (countOfFactors[i] == desiredFactors) {
//				System.out.println("i:" + i);
//				if (i == 6) System.out.println(Arrays.toString(exponents));
				count++;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		//rep
//		long start = System.nanoTime();
		makePrimeFactors();
		countFactorsList();
//		long end = System.nanoTime();
		
//		long n = (end - start);
//		System.out.println();
//		System.out.printf("Time: %.2f seconds", n/ 1000000000.0);
//		System.out.println(Arrays.toString(countOfFactors));
		
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(outputRange(k,a,b));
		}
		
	}
}