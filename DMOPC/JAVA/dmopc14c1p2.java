import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner scan = new Scanner(System.in);
		
		int length = scan.nextInt();
		int width = scan.nextInt();
		
		int square = scan.nextInt();
		
		int aL = length / square;
		int aW = width / square;
		
		System.out.println(aL * aW);
		
	}
}