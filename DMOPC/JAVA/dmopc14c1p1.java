import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		
		int[] marks = new int[N];
		
		for (int i = 0; i < N; i++) {
			marks[i] = scan.nextInt();
		}
		Arrays.sort(marks);
		
		
		if (marks.length % 2 == 0) {
			int output = marks[marks.length/2 - 1] + marks[marks.length/2];
			output = (int) Math.round(output/2.0);
			
			
			System.out.println(output);
		}
		else {
			System.out.println(marks[marks.length/2]);
		}
//		0 1 2 3
//		2 3 4 5
	}
}