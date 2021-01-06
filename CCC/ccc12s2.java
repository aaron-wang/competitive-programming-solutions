import java.util.*;
import java.io.*;

public class ccc12_s2_aromatic_numbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] raw = scan.next().split("");
		scan.close();
		
		HashMap<Character,Integer> roman = new HashMap<>();
		roman.put('I',1);
		roman.put('V',5);
		roman.put('X',10);
		roman.put('L',50);
		roman.put('C',100);
		roman.put('D',500);
		roman.put('M',1000);
		
		String[] pairs = new String[raw.length/2];
//		separate into pairs
//		1M 9C ...
		for (int i = 0; i < pairs.length; i++) {
			pairs[i] = raw[i*2] + raw[i*2 + 1];
		}
		//calc values for each
		int[] sums = new int[pairs.length];
		boolean[] subtract = new boolean[pairs.length];
		//all false
		
		for (int i = 0; i < pairs.length; i++) {
			sums[i] = (pairs[i].charAt(0) - '0') * roman.get(pairs[i].charAt(1));
		}
		
		for (int i = 1; i < pairs.length; i++) {
			if (roman.get(pairs[i].charAt(1)) > roman.get(pairs[i-1].charAt(1))) {
				subtract[i - 1] = true;
			}
		}
		
		int outputSum = 0;
		
		for (int i = 0; i < pairs.length; i++) {
			if (subtract[i]) {
				outputSum -= sums[i];
			}
			else {
				outputSum += sums[i];
			}
		}
		System.out.println(outputSum);
	}

}