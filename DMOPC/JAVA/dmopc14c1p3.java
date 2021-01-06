import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int initial = Integer.parseInt(br.readLine());
		
		double average = 0;
		
		int currentSum = 0;
		
		int num = 0;
		
		for (int i = 0; i < initial; i++) {
			currentSum += Integer.parseInt(br.readLine());
			num++;
		}
		
		int s = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < s; i++) {
			currentSum += Integer.parseInt(br.readLine());
			num++;
			
			System.out.println(currentSum/(double)num);
		}
	}
}