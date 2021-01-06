import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
				
		StringTokenizer st = new StringTokenizer(br.readLine());		
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		HashMap<Integer,Integer> map = new HashMap<>();
		
		//A - right
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < a; i++) {
			int input = Integer.parseInt(st.nextToken());
			if (map.get(input) == null) {
				map.put(input,1);				
			}
		}
		
		int full = 0;
		
		//B - left
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < b; i++) {
			int input = Integer.parseInt(st.nextToken());
			if (map.get(input) != null) {
				full++;
				map.remove(input);
			}
		}
		
		int part = map.size();
		
		int total = N - full;
		
		System.out.println(total);
	}
}