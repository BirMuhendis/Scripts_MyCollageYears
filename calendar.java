
public class calendar {

	public static void main(String[] args) {
		String takvim[][][] = new String[42][12][31];
		for (int yıl = 1; yıl <= 42; yıl++) {
			for (int ay = 1; ay <= 12; ay++) {
				for (int gün = 1; gün <= 31; gün++) {
					takvim[yıl - 1][ay - 1][gün - 1] = (gün) + "/" + (ay) + "/" + (2000 + yıl);
//						OCAKTAN HAZİRANA HAZİRAN DAHİL VE ŞUBAT AYI
					if ((ay <= 6 && ay % 2 == 0 && gün == 31) || (yıl % 4 == 0 && ay == 2 && gün > 28)) {
						takvim[yıl - 1][ay - 1][gün - 1] = null;
					}
//						HAZİRANDAN SONRASI
					if (ay > 6 && ay % 2 != 0 && gün == 31) {
						takvim[yıl - 1][ay - 1][gün - 1] = null;
					}
					System.out.println(takvim[yıl - 1][ay - 1][gün - 1]);
				}
			}
		}

		        String tab = "\t";
		        String halfTabSpace = tab + " ".repeat(tab.length() / 2);
		        System.out.println("\t" + "Metin burada başlıyor.");
		        System.out.println(halfTabSpace + "Metin burada başlıyor.");
		    
		

	}
}