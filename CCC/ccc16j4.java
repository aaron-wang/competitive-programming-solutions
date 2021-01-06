import java.io.*;
import java.util.*;

public class ccc16_j4 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//no rush hour - 2 hours commute
		
		// rush from 0700 to 1000
		// 1500 1900
		// during rush hour, speed reduced by half
		
		//leaves on 0, 20, or +40
		
		// 1/2 dist per hour
		
		// 1/4 dist per hour during rush hour
		
		
		//120 minutes best, 240 worse - base off worse
		
		String temp = br.readLine();
		
		int hour = Integer.parseInt(temp.split(":")[0]);
		int minute = Integer.parseInt(temp.split(":")[1]);
//		System.out.println(hour + " " + minute);
		
		int time = 60 * hour + minute;
		
		for (int i = 0; i < 240; time++) {
			if (time >= 7 * 60 + 0 && time < 10 * 60) {
				i++;
			} 
			else if (time >= 15 * 60 + 0 && time < 19 * 60) {
				i++;
			}
			else {
				//regular time
				i+= 2;
			}
		}
		System.out.printf("%02d:%02d%n",(time/60)%24,time%60);
		

	}
}