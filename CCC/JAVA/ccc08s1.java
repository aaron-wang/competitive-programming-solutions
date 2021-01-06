import java.util.*;

public class ccc08_s1_itscoldhere {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String city, coldestCity = null;
		int minTemp = Integer.MAX_VALUE;
		do {
			city = scan.next();
			int temp = scan.nextInt();
			
			if (temp < minTemp) {
				minTemp = temp;
				coldestCity = city;
			}
		} while(!city.equals("Waterloo"));
		System.out.println(coldestCity);
	}

}