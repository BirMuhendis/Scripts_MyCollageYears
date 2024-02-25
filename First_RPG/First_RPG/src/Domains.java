import java.util.Random;
import java.util.Scanner;

public class Domains {
    String name;
    int level;
    items awards;
    Character player;
    public static Scanner sc = new Scanner(System.in);
    public static class Cave extends Domains {
        Cave()
        {
            this.player=player;
            this.name="Magara";
            this.level=sc.nextInt();
            if(level==0)System.out.println("Giris");
            if(level==1)System.out.println("Level 1");
            if(level==2)System.out.println("Level 2");
            if(level==3)System.out.println("Level 3");
        }

    }
}
