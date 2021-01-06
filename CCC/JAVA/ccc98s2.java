import java.util.*;

public class ccc98_s2 {
	public static int sumPDivisors(int num) {
		int sum = 0;
		for (int i = 1; i < num; i++) {
			if (num % i == 0) {
				sum+= i;
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		//1000 - 9999 inc
		//perfect numbers -> equal to sum of proper divisors
		//oneline
		
		for (int i = 1000; i <= 9999; i++) {
			if (sumPDivisors(i) == i) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		
		///100-999 sum of cubes of their digits
		for (int i = 100; i <= 999; i++) {
			int sum = (int) (Math.pow(i/100,3) + Math.pow((i%100)/10,3) + Math.pow(i%10,3));
			if (i == sum) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}

}