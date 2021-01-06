import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ccc12_s3_abs_acidic {
	public static void moveMaps(HashMap<Integer,Integer> oldMap, HashMap<Integer,Integer> newMap ) {
		newMap.clear();
		for (int key: oldMap.keySet()) {
			newMap.put(key, oldMap.get(key));
		}
		oldMap.clear();
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numSensors = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> readings = new HashMap<>();
//		..(reading, frequency)
		
		for (int i = 0; i < numSensors; i++) {
			int tempReading = Integer.parseInt(br.readLine());
			if (!readings.containsKey(tempReading)) {
				readings.put(tempReading, 1);
			} else { //+ 1
				readings.replace(tempReading, readings.get(tempReading) + 1);
			}

		}
		
		HashMap<Integer, Integer> highs = new HashMap<>();
		HashMap<Integer, Integer> seconds = new HashMap<>();
		
		int mostFrequent = 0;
		int secondMostFrequent = 0;
		
		for (int key: readings.keySet()) {
			int value = readings.get(key);
//			System.out.println("key: " + key + "\tvalue: " + value);
			if (value >= mostFrequent) {
				if (value > mostFrequent) {
					moveMaps(highs,seconds);
					highs.put(key, value);
					secondMostFrequent = mostFrequent;
					mostFrequent = value;
//					System.out.println("value bigger than mostFrequent");
				}
				else if (value == mostFrequent) {
					highs.put(key, value);
//					System.out.println("value same to mostFrequent");
				}
			} else { //check second frequent
				if (value > secondMostFrequent) {
					seconds.clear();
					seconds.put(key, value);
					secondMostFrequent = value;
//					System.out.println("value bigger than secondFrequent");
				}
				else if (value == secondMostFrequent) {
					seconds.put(key, value);
//					System.out.println("value same to secondFrequent");
				}
			}
		}
		
//		System.out.println(highs);
//		System.out.println(seconds);
		int output = Integer.MIN_VALUE;
//		int firstFreq = Integer.MIN_VALUE;
//		int secondFreq = Integer.MAX_VALUE;
		
		if (highs.size() == 1 && seconds.size() == 1) {
			for (int key: highs.keySet()) {
				for (int key2: seconds.keySet()) {
					output = Math.abs(key - key2);
				}
			}
		}
		else if (highs.size() > 1) {
			for (int key: highs.keySet()) {
				for (int key2: highs.keySet()) {
					output = Math.max(Math.abs(key - key2), output);
				}
			}
		}
		else if (highs.size() == 1 && seconds.size() > 1) {
			for (int key: highs.keySet()) {
				for (int key2: seconds.keySet()) {
					output = Math.max(Math.abs(key - key2), output);
				}
			}
		}
	
		System.out.println(output);
	}

}