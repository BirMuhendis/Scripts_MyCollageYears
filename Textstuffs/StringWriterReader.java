import java.io.*;
import java.util.*;

public class StringWriterReader {
    

    public static void main(String[] Args) throws IOException
    {
        File file = new File("document.txt");
        Scanner scanner = new Scanner(file);
        FileReader reader = new FileReader(file);
        FileWriter writer = new FileWriter(file);
        ClassA objectA = new ClassA("Deneme", 1, 25.5f, 3.7d);
        writer.write(objectA.toString());
        writer.close();
        System.out.println("For Scanner: ");
        while(scanner.hasNextLine())
        System.out.println(scanner.nextLine());
        scanner.close();
        reader.close();
    }
}