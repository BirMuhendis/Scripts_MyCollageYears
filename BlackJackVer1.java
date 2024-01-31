import java.util.Random;
import java.util.Scanner;
public class BlackJackVer1 {
	static Random rn= new Random();
	static Scanner sc= new Scanner(System.in);
	static String []cardsname={"As"+"2"+"3"+"4"+"5"+"6"+"7"+"8"+"9"+"10"+"vale"+"queen"+"king"};
	static int []cards={1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,8,8,8,8,9,9,9,9,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
	static int size = cards.length;
	static void shuffleArray(int[] array) {
        int n = size;
        for (int i = n - 1; i > 0; i--) {
            int j = rn.nextInt(i + 1);
            Integer temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
	static int[] CARDSDEALER(int main[],int deck[],int newArr[], int size){
		int a=rn.nextInt(0,size);
		main[0]=main[0] + deck[a];
		int index = 0;
        for (int i = 0; i < size; i++) {
            if (i != a) {
				if(i==a) continue;
                newArr[index++] = deck[i];
            }
        }
		return newArr;
	}
	public static void main(String[] args) {
		System.out.println("Hello Gambler");
		int deck[]=new int[1];
		int Systdeck[]= new int[1];
		int temp=deck[0];
		int flag=0;
		deck[0]=rn.nextInt(0,11);
		Systdeck[0]=rn.nextInt(0,11);
		while ((deck[0]>21 || Systdeck[0]<21) && flag==0) {
			if(Systdeck[0]<16)
			{
				CARDSDEALER(Systdeck, cards, cards, size);
				if(Systdeck[0]>21 && deck[0]<=21)
				{
					System.out.println("YOU WIN"); System.out.println("***************************************");	System.out.println("Dealer deck: "+Systdeck[0]); System.out.println("Your deck: "+deck[0]);
					flag=1;
				}
			}
			size--;
			System.out.println("***************************************");
			System.out.print("DEBUG: CARDS ARRY: ");
			for (int i = 0; i < size; i++) {System.out.print(cards[i]+",");}
			System.out.println();
			System.out.println("Dealer deck: "+Systdeck[0]);
			if(flag!=1)
			{
				System.out.println("***************************************");
				System.out.println("Your deck: "+deck[0]);
				System.out.println("Hit-h");
				System.out.println("Out-o");
				System.out.println("Shuffle-s");
				char mainkey=sc.nextLine().toUpperCase().toLowerCase().charAt(0);
				if(mainkey=='h')
				{
					CARDSDEALER(deck,cards,cards, size);
					if(deck[0]-temp==1)
					{
						System.out.println("What is the value of the ace?");
						System.out.println("1 --> 1");
						System.out.println("2 --> 11");
						mainkey=sc.nextLine().toUpperCase().toLowerCase().charAt(0);
						if(mainkey=='1')deck[0]=deck[0];
						if(mainkey=='2')deck[0]=deck[0]+10;
					}
						if(deck[0]>21 && Systdeck[0]<=21)
						{
							System.out.println("YOU LOSE"); System.out.println("***************************************");	System.out.println("Dealer deck: "+Systdeck[0]); System.out.println("Your deck: "+deck[0]);
							flag=1;
						}
						else{System.out.println("Your deck: "+deck[0]);}
				}
					if(mainkey=='o')
					{
						if(Systdeck[0]<16) CARDSDEALER(Systdeck, cards, cards, size);
						flag=1;
					}
					size--;
					if(mainkey=='s') shuffleArray(cards);
			}
				if (flag==1)
				{
					if((deck[0]>21 && Systdeck[0]==21) || (Systdeck[0]>deck[0] && Systdeck[0]<=21))
					{
						System.out.println("YOU LOSE"); System.out.println("***************************************");	System.out.println("Dealer deck: "+Systdeck[0]); System.out.println("Your deck: "+deck[0]);
					}
					if((Systdeck[0]<deck[0] && deck[0]<=21) || (deck[0]<=21 && Systdeck[0]>21))
					{
						System.out.println("YOU WIN"); System.out.println("***************************************");	System.out.println("Dealer deck: "+Systdeck[0]); System.out.println("Your deck: "+deck[0]);
					}
			}
		}
	}
}