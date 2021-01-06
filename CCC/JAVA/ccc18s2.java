import java.util.*;
import java.io.*;

public class ccc18_s2_sunflowers {

	public static boolean isRowIncreasing(int[][] array, int index) {
		for (int i = 1; i < array[index].length; i++) {
			if (array[index][i] <= array[index][i - 1]) {
				return false;
			}
		}
		return true;
	}
	public static boolean isColIncreasing(int[][] array, int index) {
		//note for squares only
		for (int i = 1; i < array[index].length; i++) {
			if (array[i][index] <= array[i - 1][index]) {
				return false;
			}
		}
		return true;
	}
	public static boolean isTopBottomMinMax(int[][] array) {
		int size = array[0].length;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < size; i++) {
			max = Math.max(max, array[i][0]);
			min = Math.min(min, array[i][0]);
		}
		if (array[0][0] != min || array[size - 1][0] != max) {
			return false;
		}
		else {
			return true;
		}
	}
	public static int[][] flowerSort(int[][] array) {
		int[] raw = new int[array.length];
		HashMap<Integer,Integer> firstCol = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			firstCol.put(array[i][0], i);
			raw[i] = array[i][0];
		}
		int[] sorted = raw.clone();
		Arrays.sort(sorted);

		int[][] output = new int[array.length][array.length];
		for (int i = 0; i < array.length; i++) {
			output[i] =  array[firstCol.get(sorted[i])];
		}
		return output;
	}
	public static int[][] rotateClockwise(int[][] array) {
		int size = array[0].length;
		int[][] output = new int[size][size];

		for (int i = 0; i < size; i++) {
			int[] tempRow = array[i];
			for (int j = 0; j < size; j++) {
				output[j][size - i - 1] = tempRow[j];
			}
		}
		return output;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		int[][] rawGrid = new int[size][size];
		for (int i = 0; i < size; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < size; j++) {
				rawGrid[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] changingGrid = rawGrid.clone();
		boolean correct = true;
		int rotatedCount = 0;

		do {
			if (isTopBottomMinMax(changingGrid)) {
				int[][] cleanGrid = flowerSort(changingGrid);

				correct = true;
				for (int i = 0; i < size; i++) {
					if (!isRowIncreasing(cleanGrid, i) || !isColIncreasing(cleanGrid, i)) {
						correct = false;
						break;
					}
				}
			}
			else {
				correct = false;
			}
			if (!correct) {
				changingGrid = rotateClockwise(changingGrid);
				rotatedCount++;
			}
		} while (!correct);


		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(changingGrid[i][j] + " ");
			}
			System.out.println();
		}
	}

}