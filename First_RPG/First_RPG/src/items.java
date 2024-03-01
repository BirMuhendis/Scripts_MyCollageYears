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
        public static double ironBody(Character target)
        {
            if(target.stamina>30){
            double armor = target.defense * (Dices.possibilityD08()) * Dices.possibilityD20();
            System.out.println(target.CharName +" Zirhi " + armor + " artti.");
            return target.defense+=armor;
            }
            else
            {
                System.out.println(target.CharName +" yeterli staminasi yok...");
                return 0;
            }
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
            if(attacker.stamina>35)
            {
                for(int i=1;i<=5;i++)
                {
                    attacker.stamina-=attacker.stamina*Dices.possibilityD20();
                    if(target.health>0)
                    {
                    double dmg=attacker.attack*Dices.possibilityD20()*(Dices.possibilityD10());
                    System.out.println(i+"x Vurdu" + "\nVerilen hasar: "+ dmg);
                    target.health-=dmg;
                    }
                    else{System.out.println("Hedef oldu.");break;}
                }
                return target.health;
            }
            else
            {
                System.out.println(attacker.CharName + " yoruldu dinleniyor...");
                return 0;
            }
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
            double dmg=buffer.attack*(Dices.possibilityD06())*Dices.possibilityD20();
            if(buffer.stamina>20)
            {
                System.out.println( buffer.CharName + " Hedefe kilitlendi");
                System.out.println("Hasar " + dmg + " artti.");
                return buffer.attack=dmg;
            }
            else
            {
                return 0 ;
            }
            
            
        }
        public static double PenetrationAttack(Character attacker,Character target)
        {
            if(attacker.mana>20 && attacker.stamina>20)
            {
                double dmg=attacker.attack*(Dices.possibilityD06()) * Dices.possibilityD20();
                System.out.println(target.CharName + " " + dmg + " hasar aldi.");
                return target.health-=dmg;
            }
            else if(attacker.mana<=20)
            {
                System.out.println(attacker.CharName + " manasi bitti...");
                return 0;
            }
            else
            {
                System.out.println(attacker.CharName + " yoruldu dinleniyor...");
                attacker.stamina+=Dices.possibilityD20();
                return attacker.stamina;
            }
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
            return  " "+name + "\n****************************\nDamage: " + dmg + "\tPenetration: " + penetration+"\nSkill <2>: Target Lock"+"\nSkill <3>: Penetration Attack"+ "\n****************************";    
        }
    }
    
    public static class wand extends items{
        public static double ThrowFireball(Character attacker , Character target)
        {
            double dmg = attacker.attack * (Dices.possibilityD08()) * Dices.possibilityD20();
            System.out.println( attacker.CharName +" Ates topu firlatti.\n" + target.CharName + " " + dmg +" dmg yedi.////////////");
            if(attacker.mana<20)
            {
                System.out.println(attacker.CharName + " manasi bitti...");
                return 0 ;
            }
            else
            {
                return target.health-=dmg;
            }
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
    
    public static class quarterstaff extends items{
        quarterstaff()
        {
            this.name="Quarterstaff";
            this.dmg=20;
            this.healpow=20;
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
            this.healpow=25*Dices.possibilityD08();
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