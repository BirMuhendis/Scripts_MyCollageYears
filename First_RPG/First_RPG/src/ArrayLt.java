import java.util.*;

public class ArrayLt 
{
    public static Scanner sc=new Scanner(System.in);
    public static Random rn=new Random();
    public static ArrayList<Character > createEnemies(ArrayList<Character> enemies,int enemyCount)
    {
        for(int i = 0; i < enemyCount; i++)
        {
            Character enemy;
            enemy = Enemies.EnemyGenerator();
            enemies.add( (Character) enemy);
        }
        return enemies;
    }

    public static items inventroyReplacer(ArrayList <Character> array,Character character)
    {
        int a=0;
        for(int i=0;i<character.inventory.length;i++)
        {
            if(character.inventory[i]==null)
            {
                a=i;
            }
            break;
        }
        character.inventory[a]=array.get(a).award;
        return character.inventory[a];
    }
            public static ArrayList<Character> enemyremover(ArrayList <Character> array,Character character)
            {
                ListIterator <Character> it= array.listIterator();
                for(int i = 0; i < array.size(); i++)
                {
                    if(array.get(i).health <= 0) System.out.println(array.get(i).CharName + " oldu. 1 x "+array.get(i).award.name + " kazandiniz...");
                    inventroyReplacer(array, character);
                }
        
                while(it.hasNext())
                {
                    if(it.next().health<=0) it.remove();
                }
                return array;
            }

    public static boolean HealtETrueFalse(ArrayList <Character> array)
    {
        ListIterator <Character> it= array.listIterator();
        while(it.hasNext())
        {
            if(it.next().health<=0) return true;
        }
        return false;
    }
    
    public static boolean anyEnemiesAlive(ArrayList<Character> enemies) {
        for (Character e : enemies) {
            if (e.health > 0) {
                return true; // En az bir düşman sağlıklı
            }
        }
        return false; // Tüm düşmanlar öldü
    }


    public static void main(String[] args) 
    {
        Character hero=null;
        Character tuccar=new Enemies.Merchant();
        hero=new Character.Samurai();
        ArrayList<Character> enemies = new ArrayList<Character>();
        /////////////////////////////////////////////////////////////////////////////////////////////
        Location ruins=new Location.Ruins();   Location City=new Location.City();
        Location Forest=new Location.Forest();  Location DForst=new Location.DeepofForest();
                    Location RylCstl=new Location.RoyalCastle();
        String S_MAP[][]= new String[5][5];
        Location MAP[][]= { {null   ,   null   ,   DForst   ,   null    ,   null},
                            {null   ,   null   ,   Forest   ,   null    ,   null},                
                            {null   ,   null   ,   ruins,   City    ,   RylCstl},
                            {null   ,   null   ,   null   ,   null    ,   null},
                            {null   ,   null   ,   null   ,   null    ,   null}};

                            S_MAP[0][2]="DFrt";        S_MAP[1][2]="Frst";
                            S_MAP[2][2]="Ruin";        S_MAP[2][3]="City";
                            S_MAP[2][4]="Rctl";
        
        //Location.getLocation(S_MAP, MAP,hero,enemies);
        for(int i=0;i<hero.inventory.length-10;i++) hero.inventory[i]= new items.regenpotion();
        for(int i=0;i<tuccar.inventory.length-10;i++) tuccar.inventory[i]= new items.regenpotion();
        hero.inventory[10]=new items.regenpotion();
        tradeSystem(hero, tuccar, "buy");     
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////
public static void tradeSystem(Character character,Character Merchant,String BUYORSELL)
{
    System.out.println("Your Wallet: " + character.coins);
    if(BUYORSELL=="buy")
    {
        for (int i=0;i<100;i++) if(Merchant.inventory[i]!=null) System.out.println(i+"- "+Merchant.inventory[i].name+" Cost: "+Merchant.inventory[i].cost);
        System.out.println("satin almak icin liste numarasini girin.");
        int selctor=sc.nextInt();
        if(character.coins >= Merchant.inventory[selctor].cost)
        {
        character.inventory[selctor]=Merchant.inventory[selctor];   
        Merchant.coins+=Merchant.inventory[selctor].cost;  
        character.coins-=character.inventory[selctor].cost;
        System.out.println((character.coins-character.inventory[selctor].cost) + " harcadiniz.");
        System.out.println("1 x " + character.inventory[selctor].name + " aldiniz.");
        Merchant.inventory[selctor]=null;
        }
        else System.out.println("Yeterli paraniz yok.");
    }
    else if(BUYORSELL=="sell")
    {
        for (int i=0;i<character.inventory.length;i++) if(character.inventory[i]!=null) {System.out.println(i+"- "+character.inventory[i].name+" Cost: "+character.inventory[i].cost);}
        System.out.println("Satmak almak icin liste numarasini girin.");
        int selctor=sc.nextInt();   
        inventoryReplacement(Merchant, character);     
        Merchant.coins-=Merchant.inventory[selctor].cost;
        character.coins+=character.inventory[selctor].cost;    
        System.out.println(character.inventory[selctor].cost + " kazandiniz.");
        System.out.println("1 x " + character.inventory[selctor].name + " sattiniz.");
        character.inventory[selctor]=null;
    }
}

public static void inventoryReplacement(Character customer,Character seller)
{
    int a=0;
    for(int i=0;i<customer.inventory.length;i++)
    {
        i=a;
        if(customer.inventory[i]==null)
        {
            customer.inventory[i]=seller.inventory[a];
        }
        break;
    }
}

}
