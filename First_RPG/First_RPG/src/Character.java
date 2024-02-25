import java.util.*;;
public  class Character
{
    double health;
    double attack;
    double defense;
    String type;
    String CharName; // karakter ismi
    double mana;
    double stamina;
    items award;
    items weapone;
    items inventory[]=new items[10];
    int coins;
    public static Random rn=new Random();
    public static Scanner sc=new Scanner(System.in);
    public static void Combat(Character player,Character enemy) 
    {
        while((player.health > 0 && enemy.health > 0)) 
        {
            int escapeRatio=rn.nextInt(0,2);
            System.out.println(player);
            System.out.println(enemy);
            System.out.println("<V>Vur ; <K>Kac ; <d>Savunma ; <1>SeyhDavut'un Kutsamasi; ");
            char command = sc.next().toLowerCase().toUpperCase().charAt(0);
            if(command == 'K' && escapeRatio==0)
            {
            System.out.println("Kacabildin.");
            return;
            }
            else if(command=='K' && escapeRatio==1)
            {
                System.out.println("kacma tesebbusun basarisiz oldu ve yaralandin.");
                enemy.attack_basic(enemy,player,false);
            }
            else if(command == 'V') 
            {
                player.attack_basic(player,enemy,true);
                if(enemy.health > 0) 
                {
                    enemy.attack_basic(enemy,player,false);
                } 
                else 
                {
                    player.inventory[0]=enemy.award;
                    System.out.println("Düşman indirildi. Bir ödül kazandiniz: " + 1 + " x " + enemy.award.name);
                    return;
                }
            }
            else if(command == 'D') 
            {
                player.defend(player, enemy);
            }
            else if(command == '1') 
            {
                player.Blessing_of_SeyhDavut(player);
                enemy.attack_basic(enemy, player, false);
            }
            else if(command == '2') 
            {
                if(player.weapone.name=="Katana")items.Katana.Kenjutsu(player, enemy);
                else if(player.weapone.name=="Iron Sword") items.ironSword.ironBody(player, true);
                else if(player.weapone.name=="Wand")items.wand.ThrowFireball(player, enemy, true);
                else if(player.weapone.name=="Bow") items.bow.targetlock(player);
                //diğer tür silah skillerini ekleyebilirsin veri çekme komutu için.
                if(enemy.health > 0) 
                {
                    enemy.attack_basic(enemy,player,false);
                } 
                else 
                {
                    player.inventory[0]=enemy.award;
                    System.out.println("Düşman indirildi. Bir ödül kazandiniz: " + 1 + " x " + enemy.award.name);
                    return;
                }
            }
        }
    }
    public double attack_basic(Character attacker,Character target,Boolean itsYou)
    {
        double dmg=(attacker.attack * Dices.possibility());
        stamina=(attacker.stamina-20) * Dices.possibility();
        System.out.println();
        if(itsYou==true) System.out.println("Dusmana "+ dmg +" dmg vurdun.");
        else System.out.println("Dusman sana "+ dmg +" dmg vurdu.");
        return target.health=target.health-dmg;
    }
    public double Blessing_of_SeyhDavut( Character target)
    {
        System.out.println("le le ley le le le le ley le le le le ley le le ley le ley ley... \nSeyhDavutun kutsamasini kazandin.");
        target.attack*=(1.5f)*Dices.possibility();
        double health=target.health*(1.5f)*Dices.possibility();
        System.out.println("Saldirin " + target.attack + " artti.////////////");
        System.out.println("Sagligin " + health + " artti.////////////");
        return health;
    }
    public double defend(Character defender , Character attacker)
    {
        double dmg = attacker.attack;
        if(defender.defense > 0) 
        {
            defender.defense= defender.defense - dmg;
            System.out.println("Savunuldu. Zirh "+ dmg +" hasar aldi.");
            return  defender.defense;
        }    
        else 
        {
            System.out.println("Savunulmadi. Saglik "+ dmg +" hasar aldi.");
            defender.health-=defender.health-dmg;
            return defender.health;
        }
    }
    public static class Wizard extends Character {
        Wizard()
        {
            this.weapone = new items.wand();
            this.type = "Wizard";
            this.attack=weapone.dmg;
            this.CharName=null;
            this.health = 25;
            this.defense = 30;
            this.mana=0;
            this.stamina=0;
        }
        @Override
        public String toString()
        {
            return "\tName: "+ CharName + "\n****************************\nClass: " + type + "\tHealth: " + health + "\nDefense: " + defense
            + "\tMana: " + mana + "\nStamina: " + stamina  + "\nWeapone: " + weapone  + "\n" ;
        }
        /*
        Name:adadad
****************************
Class: Warrior  Attack: 20.0    
Health: 25.0    Defense: 30.0   
Mana: 0.0       Stamina: 0.0
 */
    }
    public static class Warrior extends Character
{
    Warrior()
    {
        this.weapone = new items.ironSword();
        this.type = "Warrior";
        this.attack=weapone.dmg;
        this.CharName=null;
        this.health = 25;
        this.defense = 30;
        this.mana=0;
        this.stamina=0;
    }
    
    @Override
    public String toString()
    {
        return "\tName: "+ CharName + "\n****************************\nClass: " + type + "\tHealth: " + health + "\nDefense: " + defense
        + "\tMana: " + mana + "\nStamina: " + stamina  + "\nWeapone: " + weapone  + "\n" ;
    }
}
    public static class Samurai extends Character {
    Samurai()
    {
        this.weapone = new items.Katana();
        this.type = "Samurai";
        this.attack=weapone.dmg;
        this.CharName=null;
        this.health = 25;
        this.defense = 30;
        this.mana=0;
        this.stamina=0;
    }
    @Override
    public String toString()
    {
        return "\tName: "+ CharName + "\n****************************\nClass: " + type + "\tHealth: " + health + "\nDefense: " + defense
            + "\tMana: " + mana + "\nStamina: " + stamina  + "\nWeapone: " + weapone  + "\n" ;
    }
}
    public static class Archer extends Character
{
    Archer()
    {
        this.weapone = new items.bow();
        this.type = "Archer";
        this.attack=weapone.dmg;
        this.CharName=null;
        this.health = 25;
        this.defense = 30;
        this.mana=0;
        this.stamina=0;
    }
        @Override
        public String toString()
        {
            return "\tName: "+ CharName + "\n****************************\nClass: " + type + "\tHealth: " + health + "\nDefense: " + defense
            + "\tMana: " + mana + "\nStamina: " + stamina  + "\nWeapone: " + weapone  + "\n" ;
        }
}
}
