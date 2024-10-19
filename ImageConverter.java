import java.io.*;
import java.util.Scanner;
public class Converter {
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException
    {
        
        String origFileName=null;
        String coppiedformat=null;
        String Original_Path=null;
        String coppied_path=null;

        System.out.println("Enter that original file's name of format | '.jpg' , '.png' , '.bmp' ...");
        origFileName=sc.next();
        System.out.println("Enter that you want file's name of format | '.jpg' , '.png' , '.bmp' ...");
        coppiedformat=sc.next();
        Original_Path="C:\\Users\\ASUS\\Desktop\\PROJECTS\\main\\" + origFileName;
        coppied_path="kopya" + coppiedformat;
    
        File OrigImg = new File(Original_Path);
        File coppiedImg = new File(coppied_path);

        FileInputStream fi = new FileInputStream(OrigImg);
        FileOutputStream fo = new FileOutputStream(coppiedImg);
        BufferedInputStream bis = new BufferedInputStream(fi);
        BufferedOutputStream bos = new BufferedOutputStream(fo);
        byte[] map = new byte[1024];

        int length;

        while((length = bis.read(map)) > 0)
        {
            bos.write(map, 0, length);
        }
        bos.close();
    }
}
