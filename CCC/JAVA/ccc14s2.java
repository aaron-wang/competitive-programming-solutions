import java.util.*;
import java.io.*;

public class ccc14_s2_assigning_partners {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] comp = br.readLine().split(" ");
		String[] comp2 = br.readLine().split(" ");
		
		HashMap<String,String> mop = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			mop.put(comp[i],comp2[i]);
		}
		
		String output = "good";
		for (String name: mop.keySet()) {
//			System.out.printf("%s %s%n",name,mop.get(name));
			if (!name.equals(mop.get(name)) && !mop.get(mop.get(name)).equals(name) || name.equals(mop.get(name))) {
				output = "bad";
				break;
			}
			
		}
		System.out.println(output);
		
	}

}