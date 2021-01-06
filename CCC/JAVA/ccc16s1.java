import java.util.*;
import java.io.*;

public class ccc16_s1_ragaman {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] temp = scan.next().split("");
		//create two maps, counting the number of letters in each
		//e.g. a 1, b 3, c 4, d, 0, * 1
		Map<String,Integer> strA = new HashMap<>();
		for (int i = 0; i < temp.length; i++) {
			if (!strA.containsKey(temp[i])) {
				strA.put(temp[i], 1);
			} else {
				strA.replace(temp[i], strA.get(temp[i]) + 1);
			}
		}
		
		temp = scan.next().split("");
		
		Map<String,Integer> strB = new HashMap<>();
		for (int i = 0; i < temp.length; i++) {
			if (!strB.containsKey(temp[i])) {
				strB.put(temp[i], 1);
			} else {
				strB.replace(temp[i], strB.get(temp[i]) + 1);
			}
		}
		
		
		boolean isAnagram = true;
		//compare b string to a
		for (String key: strB.keySet()) {
			if (key.equals("*")) {}
			//if b has more than a, then false
			else if (strA.containsKey(key)) {
				if (strA.get(key) - strB.get(key) < 0) {
					isAnagram = false;
				}
			} 
			else {
				isAnagram = false;
			}
		}
		
		
		if (isAnagram) System.out.println("A");
		if (!isAnagram) System.out.println("N");
		
		
		
	}

}