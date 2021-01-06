import java.util.*;
import java.io.*;

public class Main {
	static boolean comp(String a, String b) {
		//old java - replace later
		
		if (a.indexOf(b) == 0) {
			return true;
		}
		if (b.indexOf(a) == 0) {
			return true;
		}
		if (a.indexOf(b) == a.length() - b.length() && a.indexOf(b) >= 0) {
//			System.out.println(3);
			return true;
		}
		if (b.indexOf(a) == b.length() - a.length() && b.indexOf(a) >= 0) {
//			System.out.println(4);
			return true;
		}
		return false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
//		int M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
//			boolean hasFix = false;
			String a = br.readLine();
			String b = br.readLine();
			String c = br.readLine();
			boolean hasFix = comp(a,b);
			hasFix |= comp(a,c);
			hasFix |= comp(c,b);
//			hasFix |= true;
			
			if (hasFix) {
				System.out.println("No");
			}
			else {
				System.out.println("Yes");
			}
		}

	}

}