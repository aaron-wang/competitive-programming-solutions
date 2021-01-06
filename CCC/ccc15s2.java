import java.util.*;
import java.io.*;

public class ccc15_s2_jerseys {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String sizeStr = "SML";
		// s, 0 = m, 1 = l, 2
		int J = Integer.parseInt(br.readLine());
		int ath = Integer.parseInt(br.readLine());
		int size = 0;
		int athNum = 0;
		
		HashMap<Integer,Integer> jerseys = new HashMap<>();
//		HashMap<Integer,Integer> athPref = new HashMap<>();
		boolean[] isJTaken = new boolean[J + 1];
		
		for (int i = 1 ; i <= J; i++) {
			size = sizeStr.indexOf(br.readLine());
			jerseys.put(i, size);
		}
		int count = 0;
		for (int i = 0; i < ath; i++) {
			String[] temp = br.readLine().split(" ");
			size = sizeStr.indexOf(temp[0]);
			athNum = Integer.parseInt(temp[1]);
//			athPref.put(athNum,size);
			if (athNum <= J && !isJTaken[athNum] && jerseys.get(athNum) >= size) {
				count++;
				isJTaken[athNum] = true;
//				System.out.println(size + " " + athNum);
			}
		}
		System.out.println(count);
	}

}