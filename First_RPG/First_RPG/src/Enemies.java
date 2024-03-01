import java.util.Random;

public class Enemies extends Character{
    public static Random rn=new Random(); 
    
    public static items WeaponGenerator()
    {
        int a=rn.nextInt(4);  //Silah sayısını belirten numeric.
        items arr[]= new items[4];
        arr[0]=new items.bow();
        arr[1]=new items.ironSword();
        arr[2]=new items.Katana();
        arr[3]=new items.wand();
        return arr[a];
    }
    
    public static Character EnemyGenerator()
    {
        int a=rn.nextInt(5);  //Silah sayısını belirten numeric.
        Character arr[]= new Character[5];
        arr[0]=new Enemies.bandit();
        arr[1]=new Enemies.goblin();
        arr[2]=new Enemies.slime();
        arr[3]=new Enemies.witch();
        arr[4]=new Enemies.wolf();
        return arr[a];
    }

    public static class bandit extends Character 
    {
        bandit()
        {
            this.weapone= WeaponGenerator();
            this.type = "Bandit";
            this.CharName=type;
            this.attack = weapone.dmg;
            this.health = 40;
            this.defense = 30;
            this.mana=50;
            this.stamina=50;
            this.award=new items.rustySword();
        }
        @Override
        public String toString()
        {
            return "\tName: "+ type + "\n****************************"+"\nHealth: " + health + "\tDefense: " + defense
            + "\nMana: " + mana + "\tStamina: " + stamina  + "\nAttack: " + attack  + "\n" ;
        }
    }
    
    public static class witch extends Character 
    {
    witch()
    {
        this.weapone=new items.wand();
        this.type="Witch";
        this.CharName=type;
        this.attack=weapone.dmg;
        this.defense=0;
        this.health=50;
        this.mana=100;
        this.award=new items.regenpotion();
        this.stamina=0;
    }
    @Override
    public String toString()
    {
        return "\tName: "+ type + "\n****************************"+"\nHealth: " + health + "\tDefense: " + defense
            + "\nMana: " + mana + "\tStamina: " + stamina  + "\nAttack: " + attack  + "\n" ;
    }
    }
    
    public static class slime extends Character 
    {
        slime()
        {
            this.attack=10;
            this.defense=0;
            this.health=30;
            this.mana=0;
            this.type="Slime";
            this.CharName=type;
            this.stamina=30;
            this.award=new items.gel();
        }
        @Override
    public String toString()
    {
        return "\tName: "+ type + "\n****************************"+"\nHealth: " + health + "\tDefense: " + defense
        + "\nMana: " + mana + "\tStamina: " + stamina  + "\nAttack: " + attack  + "\n" ;
    }
        
    }
    
    public static class goblin extends Character
    {
        goblin()
        {
            this.weapone=WeaponGenerator();
            this.attack=weapone.dmg;
            this.defense=20;
            this.health=30;
            this.mana=30;
            this.type="Goblin";
            this.CharName=type;
            this.stamina=30;
            this.mana=30;
            this.award=new items.brokenSpear();
        }
        @Override
        public String toString()
        {
            return "\tName: "+ type + "\n****************************"+"\nHealth: " + health + "\tDefense: " + defense
            + "\nMana: " + mana + "\tStamina: " + stamina  + "\nAttack: " + attack  + "\n" ;
        }
    }
    
    public static class wolf extends Character {
        wolf()
        {
            this.attack=13;
            this.defense=10;
            this.health=25;
            this.type="Wolf";
            this.CharName=type;
            this.stamina=50;
            this.mana=0;
            this.award=new items.fur();
        }
        @Override
        public String toString()
        {
            return "\tName: "+ type + "\n****************************"+"\nHealth: " + health + "\tDefense: " + defense
            + "\nMana: " + mana + "\tStamina: " + stamina  + "\nAttack: " + attack  + "\n" ;
        }
        
    }
    
    public static class Guard extends Character 
    {
        Guard()
        {
            this.weapone= WeaponGenerator();
            this.type = "Guard";
            this.CharName=type;
            this.attack = weapone.dmg*1.5;
            this.health = 100;
            this.defense = 30;
            this.mana=50;
            this.stamina=50;
            this.award=new items.rustySword();
        }
        @Override
        public String toString()
        {
            return "\tName: "+ type + "\n****************************"+"\nHealth: " + health + "\tDefense: " + defense
            + "\nMana: " + mana + "\tStamina: " + stamina  + "\nAttack: " + attack  + "\n" ;
        }
    }

///////////        BOSESSSSS         ///////////
//Trimo Extra goblin chief
//////////                          ///////////



public static class Merchant extends Character
{
    Merchant()
    {
        this.coins=0;
        this.weapone = new items.ironSword();
        this.type = "Merchant";
        this.attack=weapone.dmg;
        this.health = 20;
        this.original_health=20;
        this.defense = 50;
        this.mana=30;
        this.stamina=50;
        this.original_stamina=50;
        this.Religion=null;
        for(int i=0;i<20;i++)
        {
            this.inventory[i]=new items.regenpotion();
        }
    }
    @Override
    public String toString()
    {
    return "\tClass: " + type + "\n****************************\n\tHealth: " + health + "\nDefense: " + defense
            + "\tMana: " + mana + "\nStamina: " + stamina+ "\tYourReligion: " + Religion + "\nWeapone: " + weapone  + "\n" ;
    }
}
}