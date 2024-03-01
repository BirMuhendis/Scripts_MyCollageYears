import java.util.*;

public class Dices {
    public static Random rn = new Random();
    public static double possibilityD20() {
       
        int a= rn.nextInt(1,21);
        double diceRatio=Math.pow(Math.log10(a), Math.log10(a));
        return diceRatio;
    }
    public static double possibilityD10() {
       
        int a= rn.nextInt(1,11);
        double diceRatio=Math.pow(Math.log10(a), Math.log10(a));
        return diceRatio;
    }
    public static double possibilityD08() {
       
        int a= rn.nextInt(1,9);
        double diceRatio=Math.pow(Math.log10(a), Math.log10(a));
        return diceRatio;
    }
    public static double possibilityD06() {
       
        int a= rn.nextInt(1,7);
        double diceRatio=Math.pow(Math.log10(a), Math.log10(a));
        return diceRatio;
    }
    
}
