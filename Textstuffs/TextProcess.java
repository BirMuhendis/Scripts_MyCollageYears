import java.util.*;
import java.io.*;

public class TextProcess {
    public static void main(String[] args) throws IOException
    {
        File file = new File("document.txt");
        ArrayList <String> list = new ArrayList<>();
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine())
        {
            String s = sc.nextLine();
            list.add(s);
        }
        System.out.println(list);
        sc.close();
        list.clear();
        FileReader reader = new FileReader(file);
        BufferedReader buffReader = new BufferedReader(reader);
        while(buffReader.readLine()!=null)
        {
            String s = buffReader.readLine();
            list.add(s);
        }
        System.out.println(list);
        reader.close();
        buffReader.close();
    }
}
