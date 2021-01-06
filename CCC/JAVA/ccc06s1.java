import java.util.*;
import java.io.*;

public class ccc06_s1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String m = br.readLine();
		String f = br.readLine();
		
		//generate all possible permutations
		String[] m2 = new String[5];
		String[] f2 = new String[5];
		for (int i = 0; i < 5; i++) {
			m2[i] = m.substring(i*2,i*2+2);
			f2[i] = f.substring(i*2,i*2+2);
		}
		
//		System.out.println(Arrays.toString(m2));
//		System.out.println(Arrays.toString(f2));
		
		String[][] pos = new String[5][4];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k =0; k < 2; k++) {
					pos[i][j*2+k] = m2[i].charAt(j) +""+ f2[i].charAt(k);
					if (pos[i][j*2+k].charAt(0) == pos[i][j*2+k].charAt(1)) {
						if (pos[i][j*2+k].charAt(0) >= 'a') {
							pos[i][j*2+k] = Character.toString(pos[i][j*2+k].charAt(0));
						}
						else {
							pos[i][j*2+k] = Character.toString(pos[i][j*2+k].charAt(0)).toUpperCase();
						}
					}
					else {
						pos[i][j*2+k] = Character.toString(pos[i][j*2+k].charAt(0)).toUpperCase();
					}
				}
			}
		}
		
//		for (String[] s: pos) {
//			System.out.println(Arrays.toString(s));
//		}
		
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String baby = br.readLine();
			boolean isBaby = true;
			for (int j = 0; j < 5; j++) {
				boolean cur = false;
				for (String s: pos[j]) {
					if (s.equals(baby.substring(j,j+1))) {
						cur = true;
						break;
					}
				}
				if (!cur) {
					isBaby = false;
					break;
				}
			}
			if (isBaby) {
				System.out.println("Possible baby.");
			}
			else {
				System.out.println("Not their baby!");
			}
		}
	}

}