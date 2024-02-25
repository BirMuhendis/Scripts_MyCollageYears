public class items {
 
    String name;
    double dmg;
    double healpow;
    double penetration;
    double armor;
    double cost;
        /*
        Name:adadad
****************************
Class: Warrior  Attack: 20.0    
Health: 25.0    Defense: 30.0   
Mana: 0.0       Stamina: 0.0
 */
// "\nSkill <2>: ???"
    public static class ironSword extends items
    {
        public static double ironBody(Character target,Boolean itsYou)
        {
            double armor = target.defense * (1.5f) * Dices.possibility();
            if(itsYou==true)System.out.println("Zirhin " + armor + " artti.");
            if(itsYou==false)System.out.println("Dusman zirhi " + armor + " artti.");
            System.out.println();
            return target.defense+=armor;
        }
        ironSword()
        {
            this.name="Iron Sword";
            this.dmg=20;
            this.penetration=10;
            this.cost=100;
        }
        @Override
        public String toString()
        {
            return  " "+name + "\n****************************\nDamage: " + dmg + "\tPenetration: " + penetration+ "\nSkill <2>: Iron Body" +"\n****************************";    
        }
    }    
    public static class Katana extends items
    {
        public static double Kenjutsu(Character attacker,Character target)
        {
            for(int i=1;i<=5;i++)
            {
                double dmg=attacker.attack*Dices.possibility()*(0.5);
                System.out.println(i+"x Vurdu" + "\nVerilen hasar:"+ dmg);
                target.health-=dmg;
            }
            return target.health;
        }
        Katana()
        {
            this.name="Katana";
            this.dmg=20;
            this.penetration=20;
            this.cost=100;
        }
        @Override
        public String toString()
        {
            return  " "+name + "\n****************************\nDamage: " + dmg + "\tPenetration: " + penetration+ "\nSkill <2>: Kenjutsu" + "\n****************************";    
        }
    }
    public static class bow extends items{
        public static double targetlock(Character buffer)
        {
            double dmg=buffer.attack*(1.5f)*Dices.possibility();
            System.out.println("Hedefe kilitlenidi");
            System.out.println("Hasar " + dmg + " artti.");
            return buffer.attack=dmg;
        }
        bow()
        {
            this.name="Bow";
            this.dmg=20;
            this.penetration=10;
            this.cost=100;
        }
        @Override
        public String toString()
        {
            return  " "+name + "\n****************************\nDamage: " + dmg + "\tPenetration: " + penetration+"\nSkill <2>: Target Lock"+ "\n****************************";    
        }
    }
    public static class wand extends items{
        public static double ThrowFireball(Character attacker , Character target,Boolean itsYou)
        {
            double dmg = attacker.attack * (1.5f) * Dices.possibility();
            if(itsYou==true)System.out.println("Ates topu firlattin.\nDüsman "+ dmg +" dmg yedi.////////////");
            if(itsYou==false)System.out.println("Dusman ates topu firlatti.\nSen "+ dmg +" dmg yedin.////////////");
            return target.health-=dmg;
        }
        wand()
        {
            this.name="Wand";
            this.dmg=20;
            this.healpow=0;
            this.penetration=10;
            this.cost=100;
        }
        @Override
        public String toString()
        {
            return  " "+name + "\n****************************\nDamage: " + dmg + "\tPenetration: " + penetration+"\nSkill <2>: Throw Fireball" +"\n****************************";    
        }
    }
    public static class regenpotion extends items {
        regenpotion()
        {
            this.name="Regen Potion";
            this.healpow=25;
            this.cost=10;
        }
        @Override 
        public String toString()
        {
            return "Name: " + name + "\n****************************\nCost: " + cost;
        }
    }
    public static class rustySword extends items {
        rustySword()
        {
            this.name="Rusty Sword";
            this.cost=35;
        }
        @Override
        public String toString()
        {
            return "Name: " + name + "\n****************************\nCost: " + cost;
        }
        
    }
    public static class gel extends items {
        gel()
        {
            this.name="Gel";
            this.cost=5;
        }
        @Override
        public String toString()
        {
            return "Name: " + name + "\n****************************\nCost: " + cost;
        }
    }
    public static class brokenSpear extends items {
        brokenSpear()
        {
            this.name="Broken Spear";
            this.cost=15;
        }
        @Override
        public String toString()
        {
            return "Name: " + name + "\n****************************\nCost: " + cost;
        }
        
    }
    public static class fur extends items {
        fur()
        {
            this.name="Fur";
            this.cost=20;
        }
        @Override
        public String toString()
        {
            return "Name: " + name + "\n****************************\nCost: " + cost;
        }
    }
    public static class Tooth extends items {
        Tooth()
        {
            this.name="Tooth";
            this.cost=5;
        }
        @Override
        public String toString()
        {
            return "Name: " + name + "\n****************************\nCost: " + cost;
        }
    }
}