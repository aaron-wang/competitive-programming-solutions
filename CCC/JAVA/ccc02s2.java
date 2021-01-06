import java.util.*;

public class ccc02_s2_fraction_action {
	public static int gcd(int a, int b) {
		if (b==0) return a;
		return gcd(b,a%b);
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numerator = scan.nextInt();
		int denom = scan.nextInt();
		
		int whole = numerator/denom;
		int part = numerator % denom;
		
		int gcd = gcd(part,denom);
		
		part /= gcd;
		denom /= gcd;
		
		if (part != 0 && whole == 0) {
			System.out.println(part + "/" + denom);
		} 
		else if (part != 0) {
			System.out.println(whole + " " + part + "/" + denom);
		}
		else {
			System.out.println(whole);
		}
	}

}