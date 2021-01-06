import java.io.*;
import java.util.Scanner;

public class ccc03_s1_snakes_and_ladders {

	public static void main(String[] args) throws IOException {
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner scan = new Scanner(System.in);
		int current = 1;
		int roll;
		boolean hasWon = false;
		
		do {
			roll = scan.nextInt();
			current+= roll;
			
			if (current == 54) {
				current = 19;
			} 
			else if (current == 90) {
				current = 48;
			}
			else if (current == 99) {
				current = 77;
			}
			
			else if (current == 9) {
				current = 34;
			} 
			else if (current == 40) {
				current = 64;
			}
			else if (current == 67) {
				current = 86;
			}
			
			if (current > 100) {
				current -= roll;
			}
			if (roll != 0) {
				System.out.println("You are now on square " + current);
			}
			if (current >= 100) {
				System.out.println("You Win!");
				hasWon = true;
				break;
			}
			
		} while (roll != 0);
		
		
		if (!hasWon) {
			System.out.println("You Quit!");
		}
	}

}