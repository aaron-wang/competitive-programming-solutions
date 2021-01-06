import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 2R = 3S + D
		// high to low

		int n = Integer.parseInt(br.readLine());
		if (n != 0) {
			Map<String,Integer> comp = new HashMap<String,Integer>();
			
			String maxName = "";
			int m1 = 0;
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				int performance = 2 * Integer.parseInt(st.nextToken()) + 
						3 * Integer.parseInt(st.nextToken()) + 
						Integer.parseInt(st.nextToken());
				comp.put(name,performance);
				if (i != 0) {
					if (comp.get(maxName) < performance) {
						maxName = name;
					}
				}
				else {
					maxName = name;
				}
			}
			m1 = comp.get(maxName);
			comp.remove(maxName);
			int m2 = 0;
			if (n != 1) {
				String maxName2 = comp.keySet().iterator().next();
				
				for (String name: comp.keySet()) {
					if (comp.get(name) > comp.get(maxName2)) {
						maxName2 = name;
					}
				}
				m2 = comp.get(maxName2);
				if (m1 != m2) {
					System.out.printf("%s%n%s",maxName,maxName2);
				}
				else {
					if (maxName.compareTo(maxName2) < 0) {
						System.out.printf("%s%n%s",maxName,maxName2);
					}
					else {
						System.out.printf("%s%n%s",maxName2,maxName);
					}
				}
				
			}
			else {
				System.out.printf("%s",maxName);
			}
			
		}
	}

}