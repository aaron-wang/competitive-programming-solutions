import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
		
		int result = 0;
		
		for (int i = 1; i <= 3; i++) {
			result += i * Integer.parseInt(br.readLine());
		}
		if (result >= 10) System.out.println("happy");
		else System.out.println("sad");
	}

}