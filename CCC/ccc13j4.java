import java.util.*;
import java.io.*;

public class ccc13_j4_time_on_task {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int totalMinutes = Integer.parseInt(br.readLine());
		int chores = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		for (int i = 0; i < chores; i++) {
			q.add(Integer.parseInt(br.readLine()));
		}
		
		int current = 0;
		int count = 0;
		while (!q.isEmpty()) {
			if (current < totalMinutes) {
				current += q.remove();
				if (current > totalMinutes) {
					break;
				} else {
					count++;
				}
			} else {
				break;
			}
		}
		System.out.println(count);
//		while (!q.isEmpty()) {
//			System.out.println(q.poll());
//		}
	}

}