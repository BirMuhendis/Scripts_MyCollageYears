import java.util.Random;

public class RandomJetons {
	static Random rn = new Random();

	public static void main(String[] args) {
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
		System.err.println();
		for (int i = 0; i < 5; i++)
			System.out.print(ratios[i] + " ");
		int jetonsint[] = new int[100];
		for (int i = 0; i < 100; i++) {
			while (jetonsint[i] + jetonsint[i] == 100) {
				for (int j = 0; j < ratios[i]; j++) {
					jetonsint[i] += i;
				}
			}
			System.out.println(jetonsint[i]);
		}
	}
}
