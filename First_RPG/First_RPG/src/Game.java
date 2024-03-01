import java.util.*;

public class Game {
    public static Scanner sc = new Scanner(System.in);
    public static Random rn = new Random();

    public static Character Characterselector() {
        System.out.println("Karakter adini gir.");
        String charname=sc.nextLine();
        System.out.println("Sinifini sec.");
        System.out.println("1-Warrior   2-Archer    3-Wizard    4-Samurai");
        Character hero = null;
        items weapon = null;
        int flag = 0;
        do {
            char key = sc.next().toLowerCase().toUpperCase().charAt(0);
            switch (key) {
                default:
                    flag = 0;
                    System.out.println("yanlis komut tekrar deneyin.");
                    flag++;
                    break;

                case '1':
                    System.out.println("Warrior sinifini sectiniz.");
                    hero = new Character.Warrior();
                    hero.CharName=charname;
                    weapon = new items.ironSword();
                    Character.ReligionBuffer(hero);
                    flag++;
                    break;

                case '2':
                    hero = new Character.Archer();
                    hero.CharName=charname;
                    weapon = new items.bow();
                    Character.ReligionBuffer(hero);
                    flag++;
                    break;

                case '3':
                    hero = new Character.Wizard();
                    hero.CharName=charname;
                    weapon = new items.wand();
                    Character.ReligionBuffer(hero);
                    flag++;
                    break;

                case '4':
                    hero = new Character.Samurai();
                    hero.CharName=charname;
                    weapon = new items.Katana();
                    Character.ReligionBuffer(hero);
                    flag++;
                    break;
            }
        } while (flag == 0);
        return hero;
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
    public static void main(String[] args) 
    {
        Location ruins=new Location.Ruins();   Location City=new Location.City();
        Location Forest=new Location.Forest();  Location DForst=new Location.DeepofForest();
                    Location RylCstl=new Location.RoyalCastle();
        Location MAP[][]= new Location[5][5];
        String S_MAP[][]= new String[5][5];
        MAP[0][2]=DForst;   MAP[1][2]=Forest;        MAP[2][2]=ruins;        MAP[2][3]=City;        MAP[2][4]=RylCstl;
        ArrayList<Character> players=new ArrayList<Character>();
        ArrayList<Character> enemies = new ArrayList<Character>();
        ////Yeni bir arraylist ekleyici yap ve character selctor fonksiyonu ile doğru çalışşın.
        Character hero = Characterselector();
        System.out.println("Act 1"); System.out.println("Bilinmez Kahraman:");
        System.out.println(" Ormandaki bir harabede uyandin. Aklinda ismin ve diyarin engin patikalari disinda hic bir bilgi bulunmamakta. \nHarabe bilmediğin bir dilin yazilariyla dolup tasiyor. En yakin sehri bulmak istiyor ve harabeden cikiyorsun. Karsina birden bir yaratik cikiyor basta anlamasanda savas esnasinda ne oldugunu anliyorsun. \nİçgüdülerine güvenmek senin su anlik tek caren! ");
        enemies = createEnemies(enemies,2,"random");
        Character.Combat(hero, enemies,2);
        System.out.println();
        System.out.println("Dusman defedildikten sonra hangi yöne gitmen gerektigine karar veriyorsun.\nW-Kuzey A-Bati S-Guney D-Dogu.");
        Location.getMap(ruins);
        Location.getLocation(S_MAP, MAP, hero, enemies);
    }
}
