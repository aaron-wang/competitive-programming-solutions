import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
		
		int P = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine()); //day 0
		int R = Integer.parseInt(br.readLine());
		
		int current = N;
		int day = 0;
		int count = N;
		count += current * R;
		day++;
		while (count <= P) {
//			System.out.println(current + " " + count + " " + day);
			current *= R;
			count += current * R;
			day++;
		}
		System.out.println(day);
		
	}

}