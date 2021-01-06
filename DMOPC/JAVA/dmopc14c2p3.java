import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> saws = new PriorityQueue<>();
		PriorityQueue<Integer> logs = new PriorityQueue<>(Collections.reverseOrder());

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {			
			saws.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {			
			logs.add(Integer.parseInt(st.nextToken()));
		}
		
		//total energy to saw log = e * length
		
		long min = 0;
		
		for (int i = 0; i < N; i++) {
			min += logs.poll() * saws.poll();
		}
		
		System.out.println(min);
		
	}
}