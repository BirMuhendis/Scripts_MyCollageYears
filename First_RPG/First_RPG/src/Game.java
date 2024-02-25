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
                    flag++;
                    break;

                case '2':
                    hero = new Character.Archer();
                    hero.CharName=charname;
                    weapon = new items.bow();
                    flag++;
                    break;

                case '3':
                    hero = new Character.Wizard();
                    hero.CharName=charname;
                    weapon = new items.wand();
                    flag++;
                    break;

                case '4':
                    hero = new Character.Samurai();
                    hero.CharName=charname;
                    weapon = new items.Katana();
                    flag++;
                    break;
            }
        } while (flag == 0);
        return hero;
    }
    public static void main(String[] args) 
    {
        Character hero = Characterselector();
        Character enemy;
        System.out.println("Act 1"); System.out.println("Bilinmez Kahraman:");
        System.out.println(" Ormandaki bir harabede uyandin. Aklinda ismin ve diyarin engin patikalari disinda hic bir bilgi bulunmamakta. \nHarabe bilmediğin bir dilin yazilariyla dolup tasiyor. En yakin sehri bulmak istiyor ve harabeden cikiyorsun. Karsina birden bir yaratik cikiyor basta anlamasanda savas esnasında ne oldugunu anliyorsun. \nİçgüdülerine güvenmek senin su anlik tek caren! ");
        enemy=Enemies.EnemyGenerator();
        Character.Combat(hero, enemy);
        System.out.println();
        System.out.println("Dusman defedildikten sonra hangi yöne gitmen gerektigine karar veriyorsun.\nW-Kuzey A-Bati S-Guney D-Dogu.");
        do
        {
        char wayArrows=sc.next().toLowerCase().toUpperCase().charAt(0);
        /// go to fonksiyonu istiyoruummmmmm aaaaaaaaa aaaAAAAAAAAA
            switch(wayArrows)
            {
                case 'W':
                do{
                System.out.println("Uzun bir yolculuk sonucu sehre vardin. Sehir devasa tas sutunlarla kendini savunmakta olup arkasinda ise devasa bir sato var. Yakindaki tuccari gordun ve yanina yaklastin.\nTuccarla konusmak icin <F>");
                wayArrows=sc.next().toLowerCase().toUpperCase().charAt(0);
                if(wayArrows=='F')
                {
                    do{
                    System.out.println("Tuccarin yanindasin. Tuccari ciliz bir adamin korudugunu gordun <S>aldir veya <T>icaret");
                    wayArrows=sc.next().toLowerCase().toUpperCase().charAt(0);
                    
                        if(wayArrows=='S')
                        {
                            System.out.println("Savasssss!!!!");
                            Character enemy2=Enemies.Guard;   Character.Combat(hero, enemy2);
                        }
                        if(wayArrows=='T')
                        {
                            System.out.println("Tuccarin ekipmanlarini goruyorsun");
                        }
                        else System.out.println("Yanlis Tus.");
                    }while(wayArrows!='S' && wayArrows!='S');
                }
                else System.out.println("Dogru bas lan.");
                }while(wayArrows!='F');
                break;

                case 'A':
                break;

                case 'S':
                break;

                case 'D':
                break;

                default:
                break;
            }
        }while(true);
    }
}
