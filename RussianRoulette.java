import java.io.*;
import java.util.*;
public class RussianRoulette {
    public static Scanner sc = new Scanner(System.in);
    public static Random rn = new Random();
    public static File filedeneme = new File("C:\\Users\\ASUS\\Desktop\\deneme.txt");

public static class Players {
    int playerScore=0;
    String playerName;
    boolean liveorDead=true;
    @Override
        public String toString()
        {
            String dead= "oldu";
            String live= "Yasiyor";
            String printvalue=liveorDead ? live:dead;
            return "Player Name: " + playerName + "\n" + "Player Score: " + String.valueOf(playerScore) + "\n" + printvalue;
            
        }
    }

    public static void TextPrinter(Players players) throws IOException
    {
        FileWriter writer = new FileWriter(filedeneme);
        writer.write(String.valueOf(players));
        writer.close();
        return;
    }
    
    public static void TextReader() throws IOException
    {
        FileReader reader = new FileReader(filedeneme);
        int counter = 0;
        while(counter<filedeneme.length())
        {
            reader.read();
            counter++;
        }
        reader.close();
    }
    
    public static ArrayList <Boolean> Remover(ArrayList <Boolean> List,int a )
    {
        if(List.get(a)==true)
        {
            if(a>=0 && a<= List.size())
            {
                List.remove(a);
            }
        }
        return List;
    }

    public static void Shoot(int a,ArrayList <Boolean> List,Players players) throws IOException
    {
        if(List.get(a)==true)
        {
            players.liveorDead=false;
            Remover(List, a);
        }
        else
        {
            System.out.println("Vurulmadin loo");
            players.playerScore+=20;
        }
        TextPrinter(players);
    }
 
    public static void PlayerData(Players players, int line)
    {
        System.out.println("Player" + line + " Name: ");   players.playerName=sc.next();
        System.out.print(players);  System.out.println();   System.out.println();
    }
    public static void main(String[] args) throws IOException
    {    
        Players player1 = new Players();    PlayerData(player1,1);

        Players player2 = new Players();    PlayerData(player2,2);

        Players player3 = new Players();    PlayerData(player3,3);

        Players player4 = new Players();    PlayerData(player4,4);
         
        ArrayList <Boolean> Bullets=new ArrayList <Boolean>();
        Bullets.add(true);  Bullets.add(false); Bullets.add(false);
        Bullets.add(false); Bullets.add(false);  Bullets.add(false);
        do
        {
            System.out.println();
            System.out.println("Press a");
            char Fire = sc.next().toLowerCase().toUpperCase().charAt(0);
            if(Fire=='A')
            {
            System.out.println("1-"+player1.playerName+"\n" +"2-"+player2.playerName+"\n"+"3-"+player3.playerName+"\n"+"4-"+player4.playerName+"\n");
            int turn=sc.nextInt();
            int a= rn.nextInt(0,6);
            if(Bullets.size()<5) a=rn.nextInt(0,6);
            switch(turn){
                case 1:
                Shoot(a, Bullets, player1);
                System.out.print(player1);  System.out.println();
                break;

                case 2:
                Shoot(a, Bullets, player2);
                System.out.print(player2);  System.out.println();
                break;

                case 3:
                Shoot(a, Bullets, player3);
                System.out.print(player3);  System.out.println();
                break;

                case 4:
                Shoot(a, Bullets, player4);
                System.out.print(player4);  System.out.println();
                break;

                default:
                System.out.println("Doğru bas anani gotunden sikerim");
            }
        }
            else{System.out.println("lololoolo");}
        }
        while(Bullets.contains(true));
        System.out.println("************************************************************************************");
        TextReader();
    }
}

