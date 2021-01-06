import java.util.*;
import java.io.*;
import java.math.*;
import java.text.*;

public class ccc09_j1_ISBN {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//last 3 nums
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		String first = "9780921418" + a + b + c;
		
//		System.out.println(first);
		int sum13 = 0;
		for (int i = 0; i < 13; i++) {
			if (i % 2 == 0) {
				sum13 += (first.charAt(i) - '0') * 1;
			} else {
				sum13 += (first.charAt(i) - '0') * 3;
			}
		}
		System.out.println("The 1-3-sum is " + sum13);
	}

}