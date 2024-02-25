import java.util.*;

public class Dices {
    public static float diceD20[]= new float[20];
    public static Random rn = new Random();
    public static float possibility() {
       
        int total=0;
        int total2=0;
        do
        {
            total=0;
            total2=0;
            for(int i=0;i<20;i++)
            {
                int a=rn.nextInt(1,101);
                diceD20[i]=a;
                //System.out.println(("olasilik"+i)+" " +diceD20[i]);
                total+=diceD20[i];
            }
             //System.out.println(total);
            for(int i=0;i<20;i++)
            {
                diceD20[i]=Math.round((diceD20[i]/total)*100);
                //System.out.println(("olasilik"+i)+" " +diceD20[i]);
                total2+=diceD20[i];
            }
            //System.out.println(total2);
        }while(total!=total2 &&total2!=100);
        for(int i=0;i<20;i++) 
        {
        diceD20[i]=diceD20[i]/10;
        }
        int selector=rn.nextInt(0,20);
        System.out.println(diceD20[selector]);
        return diceD20[selector];
    }
}
