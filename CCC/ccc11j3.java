import java.util.*;
import java.io.*;

public class ccc11_j3_sumac_sequences {
	static int count = 2;
	public static int sumac(int prev, int prevprev) {
		if (prevprev < prev) return 0;
		count++;
		
		return sumac(prevprev - prev,prev);
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int t1 = scan.nextInt();
		int t2 = scan.nextInt();
//		System.out.printf("%d, %d",a,b);
		
		sumac(t2,t1);
		System.out.println(count++);
	}

}