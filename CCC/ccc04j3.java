import java.io.*;

public class ccc04_j3_smiles_with_similes {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num_adj = Integer.parseInt(br.readLine());
		int num_noun= Integer.parseInt(br.readLine());
		
		String[] adjectives = new String[num_adj];
		String[] nouns = new String[num_noun];
		
		for (int i = 0; i < num_adj; i++) {
			adjectives[i] = br.readLine();
		}
		for (int j = 0; j < num_noun; j++) {
			nouns[j] = br.readLine();
		}
		
		for (int i = 0; i < num_adj; i++) {
			for (int j = 0; j < num_noun; j++) {
				System.out.println(adjectives[i] + " as " + nouns[j]);
			}
		}
	}

}