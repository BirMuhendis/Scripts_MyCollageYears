public class WordReverseShootervol2 {

	public static void main(String[] args) {
		String[] arr2 = { "kalem ", "silgi ", "cetvel ", "telefon ", "bilgisayar " };
//		String[] arr2 = { "kahpe", "fişek", "nasıl", "delmiş", "taşın", "arası" };
		for (int i = 0; i < arr2.length - 1; i++) {
			String temp = arr2[i];
			arr2[i] = arr2[i + 1];
			arr2[i + 1] = temp;
		}
		for (int i = 0; i < arr2.length; i++)
			System.out.print(arr2[i]);
		System.out.println();
		int counter = 0;
		for (String index : arr2) {
			char kelimeharf[] = index.toCharArray();
			if (counter % 2 == 0) {
				for (int i = kelimeharf.length - 1; i >= 0; i--) {
					System.out.print(kelimeharf[i]);
				}
			} else
				System.out.print(index);
			System.out.print(",");
			counter++;
		}
	}
}