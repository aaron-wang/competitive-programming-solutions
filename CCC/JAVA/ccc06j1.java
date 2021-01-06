import java.util.Scanner;

public class ccc06_j1_calorie_counting {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] burg = {461,431,420,0};
		int[] side = {100,57,70,0};
		int[] drink = {130,160,118,0};
		int[] des = {167,266,75,0};
		
		int b = scan.nextInt() - 1;
		int sid = scan.nextInt() - 1;
		int dr = scan.nextInt() - 1;
		int d = scan.nextInt() - 1;
		int total = burg[b] + drink[dr] + side[sid] + des[d];
		System.out.println("Your total Calorie count is " + total + ".");
		scan.close();
	}

}