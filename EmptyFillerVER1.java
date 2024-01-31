import java.util.*;

public class EmptyFillerVER1 {
	static Random rn = new Random();
	static Scanner sc = new Scanner(System.in);
	static int x1, y1, x2, y2;

	static void SmallerMatrixMaker(int arr[][], int arr2[][]) {
		System.out.println();
		System.out.println("Arr:");
		for (int i = 0; i < x1; i++) {
			for (int j = 0; j < y1; j++) {
				arr[i][j] = rn.nextInt(1, 10);
				arr2[i][j] = arr[i][j];
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void EmptyFiller(int arr[][]) {
		for (int i = 0; i < x1; i++) {
			arr[i][x1] = 0;
			arr[x1][i] = 0;
		}
	}

	static void BiggerMatrixMaker(int arr[][]) {
		System.out.println("arryedek:");
		for (int i = 0; i < x2; i++) {
			for (int j = 0; j < y2; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		System.out.println("x1,y1,x2,y2");
		x1 = sc.nextInt();
		y1 = sc.nextInt();
		x2 = sc.nextInt();
		y2 = sc.nextInt();
		if ((x1 != x2 || x1 != y2) && (y1 != y2 || y1 != x2)) {
			int arr[][] = new int[x1][y1];
			int arryedek[][] = new int[x2][y2];
			SmallerMatrixMaker(arr, arryedek);
			EmptyFiller(arryedek);
			System.out.println();
			BiggerMatrixMaker(arryedek);
		}

	}

}
