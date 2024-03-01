import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Location {
    Character character;
    Character enemies;
    String nameloc;

    public static void getLocation(String S_map[][],Location map[][],Character player, ArrayList<Character> enemies)
    {
        for(int i=0;i<S_map.length;i++)
        {
            for(int j=0;j<S_map.length;j++)
            {
                S_map[i][j]="X"; //spaces
                S_map[2][2]="0"; // character
            }
        }
        do
        { 
            System.out.println("Haritiyi Gormek icin <M> ya da devam et.");
            char movementkey=sc.next().toLowerCase().toUpperCase().charAt(0);
            if(movementkey=='M')MAPPRINT();
            System.out.println("\nW-Kuzey A-Bati S-Guney D-Dogu.");
            movementkey=sc.next().toLowerCase().toUpperCase().charAt(0);
            mapMover(movementkey, S_map);
            if(S_map[2][3]=="0") //City
            {
                map[2][3]=new Location.City();
                getMap(map[2][3]);
                Location.City.CityDwellers(player, enemies);
                ////hikayeyi çeken fonksiyon.
            }
            else if(S_map[2][4]=="0") //Royal Castle
            {
                map[2][4]=new Location.RoyalCastle();
                getMap(map[2][4]);
                ////hikayeyi çeken fonksiyon.
            }
            else if(S_map[1][2]=="0") // Forest
            {
                map[1][2]=new Location.Forest();
                getMap(map[1][2]);
                Location.Forest.Story();
                ////hikayeyi çeken fonksiyon.
            }
            else if(S_map[0][2]=="0") // Deep Forest
            {
                map[0][2]=new Location.DeepofForest();
                getMap(map[0][2]);
                Location.DeepofForest.Story(player, enemies);
                ////hikayeyi çeken fonksiyon.
            }
            
            else if(S_map[2][2]=="0") // Start Location
            {   getMap(map[2][2]);
                map[2][2]=new Location.Ruins();
                ////hikayeyi çeken fonksiyon.
                
            }
        }while(true);
    }
    
    public static void getMap(Location location)
    {
        System.out.println("Suanki Konum: " + location.nameloc);
    }
    
    public static void mapMover(char movementkey, String arr[][])
	{
		String temp = "x";	int row = 0;	int col = 0;
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < arr[0].length; j++)
			{
				if (arr[i][j] == "0")
				{
					row = i;
					col = j;
					break;
				}
			}
		}
		if (movementkey == 'W' )
		{
			if(row>=1 && arr[row-1][col]!="*"){
				temp = arr[row][col];
				arr[row][col] = arr[row-1][col];
				arr[row-1][col] = temp;
			}
		}
		if (movementkey == 'A')
		{
			if(col>0 && arr[row][col-1]!="*"){
			temp = arr[row][col];
			arr[row][col] = arr[row][col - 1];
			arr[row][col - 1] = temp;
			}
		}
		if (movementkey == 'S')
		{
			if(row<arr.length-1 && arr[row+1][col]!="*"){
			temp = arr[row][col];
			arr[row][col] = arr[row + 1][col];
			arr[row+1][col] = temp;
			}
		}
		if (movementkey == 'D' )
		{
			if(col<arr[0].length-1 && arr[row][col+1]!="*"){
			temp = arr[row][col];
			arr[row][col] = arr[row][col + 1];
			arr[row][col + 1] = temp;
			}
		}
	}

    public static void MAPPRINT()
    {
        String S_map[][]=new String[5][5];
        for(int i=0;i<S_map.length;i++)
        {
            for(int j=0;j<S_map.length;j++)
            {
                S_map[i][j]="XXXX";
                S_map[0][2]="DFrt";        S_map[1][2]="Frst";        S_map[2][2]="Ruin";        S_map[2][3]="City";        S_map[2][4]="Rctl";
                System.out.print(S_map[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    public static void movementprint(String S_map[][])
    {
        for(int i=0;i<S_map.length;i++)
        {
            System.out.print("\t\t");
            for(int j=0;j<S_map.length;j++)
            {
                S_map[i][j]="X";
                
                System.out.print(S_map[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static ArrayList<Character> createEnemies(ArrayList<Character> enemies,int enemyCount,String enemytype)
    {
        for(int i = 0; i < enemyCount; i++)
        {
            Character enemy;
            
            if(enemytype=="goblin")
            {
                enemy= new Enemies.goblin();
                enemies.add( (Character) enemy);
            }  
            if(enemytype=="bandit")
            {
                enemy= new Enemies.bandit();
                enemies.add( (Character) enemy);
            } 
            if(enemytype=="guard")
            {
                enemy= new Enemies.Guard();
                enemies.add( (Character) enemy);
            } 
            if(enemytype=="slime")
            {
                enemy= new Enemies.slime();
                enemies.add( (Character) enemy);
            } 
            if(enemytype=="witch")
            {
                enemy= new Enemies.witch();
                enemies.add( (Character) enemy);
            } 
            if(enemytype=="wolf")
            {
                enemy= new Enemies.wolf();
                enemies.add( (Character) enemy);
            } 
            else if(enemytype=="random")
            {
                enemy = Enemies.EnemyGenerator();
                enemies.add( (Character) enemy);
            }
        }
        return enemies;
    }
    public static Scanner sc = new Scanner(System.in);
    public static Random rn = new Random();

    public static class City extends Location 
    {
        public static void CityDwellers(Character character,ArrayList<Character> enemies)
        {
            Character Merchant=new Enemies.Merchant();    
            System.out.println("Tuccari <T> ve lonca baskanini <L> goruyorsun.");
            char wasd=sc.next().toLowerCase().toUpperCase().charAt(0);
            if(wasd=='T')
            {
                System.out.println("tuccarin yanina gittin. Onu kucuk bir adamin korudugunu gordun. Ticaret <T> Soygun <S>... ");
                wasd=sc.next().toLowerCase().toUpperCase().charAt(0);
                if(wasd=='T')
                {
                    System.out.println("Esya satmak icin <S> Satin almak icin <A>.");
                    wasd=sc.next().toLowerCase().toUpperCase().charAt(0);
                    if(wasd=='A') character.tradeSystem(character, Merchant, "buy");
                    else if(wasd=='S') character.tradeSystem(character, Merchant, "sell");
                }
                else if(wasd=='S')
                {
                    System.out.println("Ciliz koruma one cikiyor ve seni def etmeye calisiyor.\nSAVASSSSSS....");
                    enemies=createEnemies(enemies,1,"guard");  character.Combat(character, enemies, 1);
                    character.inventoryReplacement(character, Merchant);
                }
            }
            else if(wasd=='L')
            {   
                //lonca sistemi ekle
                System.out.println("Lonca baskani senle gorusmek istiyor. Gorus <G> Kac <K>...");
                wasd=sc.next().toLowerCase().toUpperCase().charAt(0);
            }
        }

        City()
        {
            this.enemies=enemies;
            this.character=character;
            this.nameloc="Sehir";
        }
    }    
    public static class Forest extends Location 
    {
        public static void Story()
        {
            System.out.println("Ormanin Girisindesin. Kucuk nehrin etrafinda dolasan kucuk tatli canlilari goruyorsun. Avcilik icin <H>");
        }
        Forest()
        {
            this.enemies=enemies;
            this.character=character;
            this.nameloc="Orman";
        }
 
    }
    public static class Ruins extends Location 
    {

        Ruins()
        {
            this.enemies=enemies;
            this.character=character;
            this.nameloc="Harabeler";
        }

    }

    public static class DeepofForest extends Location
    {
        public static void Story(Character character,ArrayList<Character> enemies)
        {
            int a=rn.nextInt(3)+1;
            System.out.println("Ormanin derinliklerindesin. Birden bir goblin kampi fark ettin. Ne yazik ki gözcü goblinler tarafindan fark edildin.\nSAVASSSSSSS...");
            enemies = createEnemies(enemies,2,"goblin");
            Character.Combat(character, enemies, a);
        }
        DeepofForest()
        {
            this.enemies=enemies;
            this.character=character;
            this.nameloc="Ormanin Derinlikleri";
        }

    }

    public static class RoyalCastle extends Location
    {
        ///// PAZAR FONKSİYONLARI VS EKLENECEK
        RoyalCastle()
        {
            this.character=character;
            this.enemies= enemies;
            this.nameloc="Kraliyet Kalesi";

        }
    }
}
