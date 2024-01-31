import java.util.*;

public class tenRandomvalue {
	static Random rn = new Random();
	static Scanner sc = new Scanner(System.in);
	public static void main(String a[]) {
		int toplam2 = 0;
		float ratios[] = new float[5];
		while (toplam2 != 100) {
			int toplam = 0;
			for (int i = 0; i < 5; i++) {
				ratios[i] = rn.nextInt(1, 101);
				System.out.print(ratios[i] + " ");
				toplam += ratios[i];
			}
			for (int i = 0; i < 5; i++) {
				ratios[i] = Math.round(ratios[i] / toplam * 100);
				toplam2 += ratios[i];
			}
			if (toplam2 != 100) {
				toplam2 = 0;
			}
			System.out.println();
		}
	}
}