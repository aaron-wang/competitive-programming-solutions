import java.util.*;
import java.io.*;

public class ccc12_s1_dontpassmetheball {

	public static void main(String[] args) {
		//players from 1 - 99
		//given last person who touched it
		// 1 2 3 4 min
		Scanner scan = new Scanner(System.in);
		int last = scan.nextInt();
		int count = 0;
		
		for (int i = last - 1; i >= 1; i--) {
			for (int j = last - 1; j >= 1; j--) {
				for (int k = last - 1; k >= 1; k--) {
					if (i > j && j > k) {
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}

}