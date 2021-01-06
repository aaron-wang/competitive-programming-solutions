import java.io.*;

public class ccc00s1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int coins = Integer.parseInt(br.readLine());
		
		int m1 = Integer.parseInt(br.readLine());
		int m2 = Integer.parseInt(br.readLine());
		int m3 = Integer.parseInt(br.readLine());
		
		int plays = 0;
		
		while (coins > 0) {
			if (coins <= 0) break;
			//1
			coins--;
			m1++;
			m1 %= 35;
			if (m1 == 0) {
				coins+= 30;
			}
			plays++;
			
			if (coins <= 0) break;
			//2
			coins--;
			m2++;
			m2 %= 100;
			if (m2 == 0) {
				coins+= 60;
			}
			plays++;
			if (coins <= 0) break;
			//3
			m3++;
			m3 %= 10;
			coins--;
			if (m3 == 0) {
				coins+= 9;
			}
			plays++;
		}
		System.out.printf("Martha plays %d times before going broke.",plays);

		
	}

}