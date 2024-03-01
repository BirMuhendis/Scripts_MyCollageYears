import java.util.*;
public class Character
{
    double original_health;
    double original_stamina;
    String Religion;
    double health;
    double attack;
    double defense;
    String type;
    String CharName; // karakter ismi
    double mana;
    double stamina;
    items award;
    items weapone;
    items inventory[]=new items[100];
    int coins;
    public static Random rn=new Random();
    public static Scanner sc=new Scanner(System.in);

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
    
    public static double ReligionBuffer(Character character)
    {   
        System.out.println("\t\tBIR DIN SEC:\n 1-SeyhDavut Inanci\n*******************\nKahramana Isigin gösterdiği yol ile hasar buffi verir.\n \n2-ApoKilliPopo Inanci\n****************************\nKahramana Killi Popsundan defence bahseder.\n \n3-HamsiUgur Inanci\n****************************\nKahramana Hamsiden gelen saglik buffi bahseder.\n \n4-DeliFindikDeniz Inanci\n****************************\nKahramana Findiğin yasam ozunden(mana) bahseder. ");
        char selector=sc.next().charAt(0);
        
        if(selector=='1')
        {
            character.Religion="SeyhDavut Inanci";
            return character.attack+= character.attack*Dices.possibilityD10();
        }
        else if(selector=='2')
        {
            character.Religion="ApoKilliPopo Inanci";
            return character.defense += character.defense*Dices.possibilityD10();
        }
        else if(selector=='3')
        {
            character.Religion ="HamsiUgur Inanci";
            return character.health+= character.health*Dices.possibilityD10();
        }
        else
        {
            character.Religion="DeliFindikDeniz Inanci";
            return character.mana+= character.mana*Dices.possibilityD10();
        }
    }
    
    public double attack_basic(Character attacker,Character target)
    {
        double dmg=(attacker.attack * Dices.possibilityD20());
        attacker.stamina-=attacker.stamina * Dices.possibilityD20();
        {
            if(attacker.stamina> 0)
            {
                if(target.defense>0)
                {
                    target.defense= target.defense - dmg;
                    System.out.println(target.CharName + " Savundu. "+ target.CharName + " zirhi "+ dmg +" parcalandi.");
                    return  target.defense;
                }
                else 
                {
                    System.out.println(target.CharName + " Savunamadi. "+ target.CharName+ " sagligi "+ dmg +" hasar aldi.");
                    target.health = target.health-dmg;
                    return target.health;
                }
            }
            else 
            {
                System.out.println( attacker.CharName + " Yoruldu Dinleniyor...");
                attacker.stamina+=attacker.TakeBreathe(attacker);
                return 0;
            }
        }
    }   
    
    public static items AwardReplacer(ArrayList <Character> array,Character character)
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
        for(int i = 0; i < array.size(); i++)
        {
            if(array.get(i).health <= 0)
            { 
                System.out.println(array.get(i).CharName + " oldu. 1 x "+array.get(i).award.name + " kazandiniz...");
            }
        }
        character.inventory[a]=array.get(a).award;
        return character.inventory[a];
    }   
    
    public static ArrayList<Character> enemyremover(ArrayList <Character> array,Character character)
    {
        ListIterator <Character> it= array.listIterator();
        while(it.hasNext())
        {
            if(it.next().health<=0) it.remove();
        }
        return array;
    }
    
    public static void Combat(Character player,ArrayList<Character> enemies,int enemyCount) 
    {
        int maxvalue= enemies.size();
        int a=0;
        while(player.health > 0 && (anyEnemiesAlive(enemies))) 
        {
            int escapeRatio=rn.nextInt(0,2);
            System.out.println(player);
            System.out.println(enemies);
            System.out.println("<V>Vur ; <K>Kac ; <T>Nefeslen ; <1>"+player.Religion+"'in Kutsamasi; ");
            char command = sc.next().toLowerCase().toUpperCase().charAt(0);
            if(command == 'K' && escapeRatio==0)
            {
                System.out.println("Kacabildin.");
                return;
            }
            else if(command=='K' && escapeRatio==1)
            {
                System.out.println("kacma tesebbusun basarisiz oldu ve yaralandin.");
                for(int i=0;i< enemyCount ;i++)enemies.get(i).attack_basic(enemies.get(i),player);
            }
            else if(command == 'V') 
            {
                System.out.println("Hangi dusmana saldiriyosun. 1-" + enemies.size());
                a=sc.nextInt()-1;
                player.attack_basic(player,enemies.get(a));
                if(anyEnemiesAlive(enemies)) 
                {
                    AwardReplacer(enemies, player);
                    enemies = enemyremover(enemies,player);
                    enemyCount=maxvalue-enemies.size();
                    for(int i=0;i< enemyCount ;i++) enemies.get(i).attack_basic(enemies.get(i),player);
                } 
                else 
                {
                    System.out.println("Butun dusmanlar oldu...");
                    return;
                }
            }
            else if(command == 'T') 
            {
                TakeBreathe(player);
                for(int i=0;i< enemyCount ;i++)enemies.get(i).attack_basic(enemies.get(i),player);
            }
            else if(command == '1') 
            {
                player.Blessing_of_Gods(player);
                for(int i=0;i< enemyCount ;i++)enemies.get(i).attack_basic(enemies.get(i),player);
            }
            else if(command == '2') 
            {
                if(player.weapone.name=="Katana"){System.out.println("Hangi dusmana saldiriyosun. 1-" + enemies.size());
                a=sc.nextInt()-1;items.Katana.Kenjutsu(player, enemies.get(a));}
                else if(player.weapone.name=="Iron Sword"){System.out.println("Hangi dusmana saldiriyosun. 1-" + enemies.size());
                a=sc.nextInt()-1; items.ironSword.ironBody(player);}
                else if(player.weapone.name=="Wand"){System.out.println("Hangi dusmana saldiriyosun. 1-" + enemies.size());
                a=sc.nextInt()-1; items.wand.ThrowFireball(player, enemies.get(a));}
                else if(player.weapone.name=="Bow") items.bow.targetlock(player);
                if(anyEnemiesAlive(enemies)) 
                {
                    AwardReplacer(enemies, player);
                    enemies = enemyremover(enemies,player);
                    enemyCount=maxvalue-enemies.size();
                    for(int i=0;i< enemyCount ;i++) enemies.get(i).attack_basic(enemies.get(i),player);
                } 
                else 
                {
                    System.out.println("Butun dusmanlar oldu...");
                    return;
                }
            }
            else if(command=='3')
            {
                if(player.weapone.name=="Bow") 
                {
                    System.out.println("Hangi dusmana saldiriyosun. 1-" + (enemies.size()));
                    a=sc.nextInt(); items.bow.PenetrationAttack(player, enemies.get(a));
                }
                if(anyEnemiesAlive(enemies)) 
                {
                    AwardReplacer(enemies, player);
                    enemies = enemyremover(enemies,player);
                    enemyCount=maxvalue-enemies.size();
                    for(int i=0;i< enemyCount ;i++) enemies.get(i).attack_basic(enemies.get(i),player);
                } 
                else 
                {
                    System.out.println("Butun dusmanlar oldu...");
                    return;
                }
            }
        }
    }
    
    public static boolean anyEnemiesAlive(ArrayList<Character> enemies) {
        for (Character e : enemies) {
            if (e.health > 0) {
                return true; // En az bir düşman sağlıklı
            }
        }
        return false; // Tüm düşmanlar öldü
    }

    public void Blessing_of_Gods( Character target)
    {
        System.out.println("le le ley le le le le ley le le le le ley le le ley le ley ley...\n" + target.Religion + "kutsamasini kazandin.");
        target.stamina=original_stamina;
        System.out.println(target.CharName + " staminasi yenilendi.////////////");
        double health=original_health;
        System.out.println(target.CharName + " sagligi yenilendi.////////////");
        if(target.Religion=="SeyhDavut Inanci")
        {
            target.attack+=target.attack*(Dices.possibilityD20());
            System.out.println(target.CharName + " saldirisi " + target.attack + " artti.////////////");
        }
        else if(target.Religion=="DeliFindikDeniz Inanci")
        {
            target.mana+=target.mana*(Dices.possibilityD20());
            System.out.println(target.CharName + " manasi "  + target.mana + " artti.////////////");
        }
        else if(target.Religion=="ApoKilliPopo Inanci")
        {
            target.defense+=target.defense*(Dices.possibilityD20());
            System.out.println(target.CharName + " defansi "  + target.defense + " artti.////////////");
        }
        else
        {
            target.health+=target.health*(Dices.possibilityD20());
            System.out.println(target.CharName + " sagligi "  + target.health + " artti.////////////");
        }
    }
    
    public static double TakeBreathe(Character anyone)
    {   
        anyone.stamina+=1;
        anyone.stamina+=anyone.stamina*(Dices.possibilityD06())*Dices.possibilityD20();
        System.out.println(anyone.CharName + " dinlendi ve " + anyone.stamina + " stamina yeniledi.");
        return anyone.stamina;
    }
    
    public static class Wizard extends Character {
        Wizard()
        {
            this.coins=0;
            this.weapone = new items.wand();
            this.type = "Wizard";
            this.attack=weapone.dmg;
            this.CharName=null;
            this.health = 20;
            this.original_health=20;
            this.original_stamina=20;
            this.defense = 30;
            this.mana=50;
            this.stamina=20;
            this.Religion=null;
        }
        @Override
        public String toString()
        {
            return "\tName: "+ CharName + "\n****************************\nClass: " + type + "\tHealth: " + health + "\nDefense: " + defense
            + "\tMana: " + mana + "\nStamina: " + stamina + "\tYourReligion: " + Religion  + "\nWeapone: " + weapone  + "\n" ;
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
            this.coins=0;
            this.weapone = new items.ironSword();
            this.type = "Warrior";
            this.attack=weapone.dmg;
            this.CharName=null;
            this.health = 50;
            this.original_health=50;
            this.original_stamina=50;
            this.defense = 50;
            this.mana=0;
            this.stamina=50;
            this.Religion=null;
        }

        @Override
        public String toString()
        {
            return "\tName: "+ CharName + "\n****************************\nClass: " + type + "\tHealth: " + health + "\nDefense: " + defense
            + "\tMana: " + mana + "\nStamina: " + stamina + "\tYourReligion: " + Religion + "\nWeapone: " + weapone  + "\n" ;
        }
    }
    
    public static class Samurai extends Character {
        Samurai()
        {
            this.coins=0;
            this.weapone = new items.Katana();
            this.type = "Samurai";
            this.attack=weapone.dmg;
            this.CharName=null;
            this.health = 50;
            this.original_health=50;
            this.original_stamina=50;
            this.defense = 50;
            this.mana=0;
            this.stamina=50;
            this.Religion=null;
        }
        @Override
        public String toString()
        {
            return "\tName: "+ CharName + "\n****************************\nClass: " + type + "\tHealth: " + health + "\nDefense: " + defense
            + "\tMana: " + mana + "\nStamina: " + stamina + "\tYourReligion: " + Religion + "\nWeapone: " + weapone  + "\n" ;
        }
    }
    
    public static class Archer extends Character
    {
        Archer()
        {
            this.coins=0;
            this.weapone = new items.bow();
            this.type = "Archer";
            this.attack=weapone.dmg;
            this.CharName=null;
            this.health = 20;
            this.original_health=20;
            this.defense = 50;
            this.mana=30;
            this.stamina=50;
            this.original_stamina=50;
            this.Religion=null;
        }
        @Override
        public String toString()
        {
            return "\tName: "+ CharName + "\n****************************\nClass: " + type + "\tHealth: " + health + "\nDefense: " + defense
            + "\tMana: " + mana + "\nStamina: " + stamina+ "\tYourReligion: " + Religion + "\nWeapone: " + weapone  + "\n" ;
        }
    }

    public static class Healer extends Character {
        Healer()
        {
            this.coins=0;
            this.weapone = new items.quarterstaff();
            this.type = "Healer";
            this.attack=weapone.dmg;
            this.CharName=null;
            this.health = 20;
            this.original_health=20;
            this.defense = 50;
            this.mana=30;
            this.stamina=50;
            this.original_stamina=50;
            this.Religion=null;
        }
        
    }    
}
