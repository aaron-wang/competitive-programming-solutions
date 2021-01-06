import java.util.Scanner;

public class ccc16_j1_tournament_selection {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String game_sequence = "";
//		note, problem sets limit to 6 games, input W, L...
		for (int i = 0; i < 6; i++) {
			game_sequence += scan.next();
		}
		scan.close();
//		losses are cut from string in the game seq string
//		leaving you with only Ws in string...
		int num_wins = game_sequence.replaceAll("L","").length(); 
		if (num_wins >= 5) {
			System.out.println("1");
		}
		else if (num_wins >= 3) {
			System.out.println("2");
		}
		else if (num_wins >= 1) {
			System.out.println("3");
		}
		else {
			System.out.println("-1");
		}
		
	}
}