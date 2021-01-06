import java.util.*;
import java.io.*;
import java.math.*;

public class ccc15_s1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		int temp = 0;
		
		for (int i = 0; i < total; i++) {
			temp = Integer.parseInt(br.readLine());
			if (temp != 0) {
				stack.push(temp);
			} else {
				stack.pop();
			}
		}
		int sum = 0;
		while (stack.size() > 0) {
			sum += stack.pop();
		}
		System.out.println(sum);
	}
}