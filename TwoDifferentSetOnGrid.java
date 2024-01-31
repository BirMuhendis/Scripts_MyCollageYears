import java.util.Random;
import java.util.Scanner;

public class TwoDifferentSetOnGrid {
static Scanner sc = new Scanner(System.in);
	static Random rn = new Random();
	public static void main(String[] args) {
		System.out.print("coordinate sq1 (x1 y1): ");
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		System.out.print("size of the sq1: ");
		int sq1 = sc.nextInt();
		System.out.print("coordinate sq2 (x2 y2): ");
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		System.out.print("size of the sq2: ");
		int sq2 = sc.nextInt();
		char[][] area = new char[100][100];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				boolean sq1opt1 = (i >= y1 && i < y1 + sq1 && j >= x1 && j < x1 + sq1)&& (i >= y2 && i < y2 + sq2 && j >= x2 && j < x2 + sq2);
				boolean sq1loca = i >= y1 && i < y1 + sq1 && j >= x1 && j < x1 + sq1;
				boolean sq2opt2 = i >= y2 && i < y2 + sq2 && j >= x2 && j < x2 + sq2;
				if (sq1opt1) {
					area[i][j] = 'C';
				} else if (sq1loca) {
					area[i][j] = 'A';
				} else if (sq2opt2) {
					area[i][j] = 'B';
				} else {
					area[i][j] = '*';
				}
			}
		}
		System.out.println("FINAL AREA:");
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(area[i][j] + " ");
			}
			System.out.println();
		}
		sc.close();
	}
}