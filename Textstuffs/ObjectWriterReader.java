import java.io.*;

public class ObjectWriterReader {
    
    public static void main(String[] args) throws IOException , ClassNotFoundException
    {
        ClassA objectA = new ClassA("Deneme", 1, 25.5f, 3.7d);
        File file = new File("document.txt");
        FileOutputStream writer = new FileOutputStream(file);
        ObjectOutputStream objecWtriter = new ObjectOutputStream(writer);
        objecWtriter.writeObject(objectA);
        objecWtriter.close();
        writer.close();

        FileInputStream reader = new FileInputStream(file);
        try (ObjectInputStream objectReader = new ObjectInputStream(reader)) 
        {
            ClassA tempObject= (ClassA) objectReader.readObject();
            System.out.println(tempObject);
        }



    }
}
