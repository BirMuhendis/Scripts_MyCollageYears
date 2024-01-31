import java.util.Scanner;

public class WordReverseShooter {
	public static void main(String[] args) {
		//DURUM BİR : İNDİSLERDE BOŞLUK YOKSA
		String [] arr= {"ila","ilev","krık","zukod","ille","şubab","opa"};
		for(String index:arr) {
			char arrletters[]=index.toCharArray();
			for(int i=arrletters.length-1;i>=0;i--) {
				System.out.print(arrletters[i]);
			}
			System.out.print(",");
		}
		System.out.println();
		// DURUM İKİ: İNDİSLERDE BOŞLUK VARSA
		String[] kelime = { "kalem ", "cetvel ", "silgi ", "kitap ", "defter " };
		for (String index : kelime) {
			char kelimeharf[] = index.toCharArray();
			for (int i = kelimeharf.length - 1; i >= 0; i--) {
				System.out.print(kelimeharf[i]);
			}
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Lütfen Bir Kelime Gİriniz.");
		String word = sc.next();
		char arrword[] = word.toCharArray();
		for (int i = arrword.length - 1; i >= 0; i--) {
			System.out.print(arrword[i]);
		}
		sc.close();
	}
}