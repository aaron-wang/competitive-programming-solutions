import java.util.*;
import java.io.*;

public class ccc96_s1_def_perfect_abundant {
	static int findDivisorsSum(int a) {
		int output = 0;
		for (int i = 1; i < a; i++) {
			if (a % i == 0) {
				output+= i;
			}
		}
		return output;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int raw = Integer.parseInt(br.readLine());
			if (findDivisorsSum(raw) == raw) {
				System.out.println(raw + " is a perfect number.");
			}
			else if (findDivisorsSum(raw) > raw) {
				System.out.println(raw + " is an abundant number.");
			}
			else if (findDivisorsSum(raw) < raw) {
				System.out.println(raw + " is a deficient number.");
			}
		}
		
	}

}