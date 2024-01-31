import java.util.Random;
import java.util.Scanner;

public class ArrayRowColumnChanger {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rn = new Random();
		int arr1[][] = new int[5][5];
		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < 5; y++) {
				arr1[x][y] = rn.nextInt(1, 10);
				System.out.print(arr1[x][y] + "\t");
			}
			System.out.println();
		}
		System.out.println();
		int temp[] = new int[5];
		int temp2[] = new int[5];

		for (int i = 0; i < 5; i++) {
			temp[i] = arr1[i][0];
			System.out.print(temp[i]);
		}
		System.out.println();
		System.out.println("değiştirilmek istenen sütun : (0-4)");
		int colunm = sc.nextInt();
		System.out.println("temp2	 |	temp");
		System.out.println("---------------------");
		for (int i = 0; i < 5; i++) {
			temp2[i] = arr1[i][colunm];
			System.out.print(" " + temp2[i] + "\t " + "\t ");
			arr1[i][colunm] = temp[i];
			arr1[i][0] = temp2[i];
			System.out.println(temp[i]);
		}
		System.out.println();
		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < 5; y++) {
				System.out.print(arr1[x][y] + "\t");
			}
			System.out.println();
		}
		sc.close();
	}
}
