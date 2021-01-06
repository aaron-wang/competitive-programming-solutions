import java.util.Scanner;

public class ccc17_s1 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int days_repeat = scan.nextInt();
		int[][] teamScores = new int[2][days_repeat];
		int[] sums = new int[2];
		int temp = 0;
		
		// initializing values
		for (int teamNum = 0; teamNum <= 1; teamNum++) {
			for (int i = 0; i < days_repeat; i++) {
				temp = scan.nextInt(); 
				teamScores[teamNum][i] = temp; //add to array
				sums[teamNum] += temp; // array to total sum
			}
		}
//		Start at the max, and work backwards
//		long startTime = System.currentTimeMillis();
		for (int i = days_repeat; i >= 0; i--) {
			if (sums[0] == sums[1]) {
				System.out.println(i);
				break;
			} else {
				sums[0] -= teamScores[0][i - 1];
				sums[1] -= teamScores[1][i - 1];
			}
		}
		
//		long endTime = System.currentTimeMillis();
//		System.out.println(endTime - startTime + "ms");
		scan.close();
	}

}