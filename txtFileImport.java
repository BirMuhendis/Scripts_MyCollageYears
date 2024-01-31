import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

public class txtFileImport {
static Random rn = new Random();

public static void main(String[] args) {
    // Dosya yolu belirtin
    String dosyaYolu = "C:\\Users\\Goktu\\Desktop\\TDK.DIL.LIST.txt";

    // Hedef satır numarası (5. satır)
    int hedefSatir =rn.nextInt(1,76188) ;

    try {
        // FileReader ve BufferedReader kullanarak dosyayı oku
        FileReader fileReader = new FileReader(dosyaYolu);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // Veriyi depolamak için ArrayList oluştur
        ArrayList<String> hedefSatirListesi = new ArrayList<>();

        // Belirli satıra kadar olan satırları geç
        for (int i = 1; i < hedefSatir; i++) {
            bufferedReader.readLine();
        }

        // Hedef satırı oku
        String hedefSatirVerisi = bufferedReader.readLine();

        // Hedef satırı diziye ekle
        hedefSatirListesi.add(hedefSatirVerisi);

        // Diziyi kullan veya ekrana yazdır
        for (String veri : hedefSatirListesi) {
            System.out.println(veri.replaceAll("\\s+", ""));
        }

        // Kaynakları serbest bırak
        bufferedReader.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}