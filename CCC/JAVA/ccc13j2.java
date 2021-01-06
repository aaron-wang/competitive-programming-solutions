import java.util.Scanner;

public class ccc13_j2_rotating_letters {

	public static void main(String[] args) {
		
		String accepted = "IOHSZXN";
		
		Scanner scan = new Scanner(System.in);
		
		String input = scan.next();
		scan.close();
		
		boolean is_rotate = true;
		for (int i = 0; i < input.length(); i++) {
			if (accepted.indexOf(input.charAt(i)) < 0) {
				is_rotate = false;
				break;
			}
		}
		if (is_rotate) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		
		
	}

}