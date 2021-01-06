import java.util.*;
import java.io.*;
import java.math.*;
import java.text.DecimalFormat;

public class ccc05_j1_the_cell_sell {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DecimalFormat df = new DecimalFormat("#0.00");
		
		int day = Integer.parseInt(br.readLine());
		int evening = Integer.parseInt(br.readLine());
		int weekend = Integer.parseInt(br.readLine());
		
		double aCost = Math.max(day - 100,0) * 0.25 + evening * 0.15 + weekend * 0.20;
		double bCost = Math.max(day - 250,0) * 0.45 + evening * 0.35 + weekend * 0.25;
	
		
		System.out.println("Plan A costs " + df.format(aCost));
		System.out.println("Plan B costs " + df.format(bCost));
		
		if (aCost < bCost) {
			System.out.println("Plan A is cheapest.");
		} 
		else if (bCost < aCost) {
			System.out.println("Plan B is cheapest.");
		} else {
			System.out.println("Plan A and B are the same price.");
		}
		
	}

}