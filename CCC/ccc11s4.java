import java.io.*;
import java.util.*;
//old java code - ...
public class ccc11_s4 {
	static int blood(int row, int col, int pRow, int pCol) {
		int ans = 0;
		ans += Math.min(blood[row][col],patient[pRow][pCol]);
		blood[row][col] -= patient[pRow][pCol];
		patient[pRow][pCol] -= ans;
		blood[row][col] = Math.max(0,blood[row][col]);
		patient[pRow][pCol] = Math.max(0,patient[pRow][pCol]);
//		System.out.println("----------");

//		System.out.printf("%d %d %d %d%n",row,col,pRow,pCol);
//		printType(row,col);
//		System.out.print("Patient: ");
//		printType(pRow,pCol);
//		System.out.println("\t\t" + ans);
		
		return ans;
	}
	static String printType(int row, int col) {
		String s = "";
		
		if (col == 0) s+= "O";
		if (col == 1) s+= "A";
		if (col == 2) s+= "B";
		if (col == 3) s+= "AB";
		
		if (row == 0) {
			s+= "-";
		}
		else {
			s+= "+";
		}
		System.out.println(s);
		return s;
	}
	static int[][] blood;
	static int[][] patient;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
//		int C = Integer.parseInt(st.nextToken());
		
		blood = new int[2][4];
		
		//where first row is negative 0
		//second row is positive 1
		
		patient = new int[2][4];
		
		//col 0 is o
		//1 is A
		// 2 is B
		// 3 is AB
		
		for (int i = 0; i < 4; i++) {
			blood[0][i] = Integer.parseInt(st.nextToken());
			blood[1][i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			patient[0][i] = Integer.parseInt(st.nextToken());
			patient[1][i] = Integer.parseInt(st.nextToken());
		}
		
		
//		for (int[] row: blood) {
//			for (int m: row) {
//				System.out.print(m + " ");
//			}
//			System.out.println();
//		}
//		System.out.println("--");
//		for (int[] row: patient) {
//			for (int m: row) {
//				System.out.print(m + " ");
//			}
//			System.out.println();
//		}
//		
//		System.out.println("------------");
		int ans = 0;
		
//		 TYPE O -
		//O-
		ans += blood(0,0,0,0);

		
//		TYPE A -
		//A-
		ans += blood(0,1,0,1);
		//O-
		ans += blood(0,0,0,1);
		
//		TYPE B -
		//B-
		ans += blood(0,2,0,2);
		//O-
		ans += blood(0,0,0,2);
//		 TYPE O +
		//O+
		ans += blood(1,0,1,0);
		//O-
		ans += blood(0,0,1,0);

		
//		TYPE A +
		//A+
		ans += blood(1,1,1,1);
		//O +
		ans += blood(1,0,1,1);
		//A-
		ans += blood(0,1,1,1);
		//O-
		ans += blood(0,0,1,1);
		

		
		

		
//		TYPE B +
		//B+
		ans += blood(1,2,1,2);
		//O +
		ans += blood(1,0,1,2);
		//B-
		ans += blood(0,2,1,2);
		//O-
		ans += blood(0,0,1,2);
		
		
		
//		TYPE AB-
		//A-
		ans += blood(0,1,0,3);
		//B-
		ans += blood(0,2,0,3);
		//AB -
		ans += blood(0,3,0,3);
		//O-
		ans += blood(0,0,0,3);
		
//		TYPE AB+
		//O+
		ans += blood(1,0,1,3);
		//A+
		ans += blood(1,1,1,3);
		//B+
		ans += blood(1,2,1,3);
		//AB+
		ans += blood(1,3,1,3);
		
		//O-
		ans += blood(0,0,1,3);
		//A-
		ans += blood(0,1,1,3);
		//B-
		ans += blood(0,2,1,3);
		//AB -
		ans += blood(0,3,1,3);

		
		
		
		System.out.println(ans);
		
		//PRINTING
//		for (int[] row: blood) {
//			for (int m: row) {
//				System.out.print(m + " ");
//			}
//			System.out.println();
//		}
//		System.out.println("--");
//		for (int[] row: patient) {
//			for (int m: row) {
//				System.out.print(m + " ");
//			}
//			System.out.println();
//		}
	}

}