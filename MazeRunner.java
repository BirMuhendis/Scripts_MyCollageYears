import java.util.Random;
import java.util.Scanner;
// arr.length = 11(row)
// arr[0].lenght = 10(col)
public class MazeRunner
{
    static Scanner sc = new Scanner(System.in);
    static Random rn= new Random();
	static void moveMazer(char movementkey, char arr[][])
	{
		char temp = 'x';	int row = 0;	int col = 0;
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < arr[0].length; j++)
			{
				if (arr[i][j] == '0')
				{
					row = i;
					col = j;
					break;
				}
			}
		}
		if (movementkey == 'W' )
		{
			if(row>1 && arr[row-1][col]!='*'){
				temp = arr[row][col];
				arr[row][col] = arr[row-1][col];
				arr[row-1][col] = temp;
			}
		}
		if (movementkey == 'A')
		{
			if(col>0 && arr[row][col-1]!='*'){
			temp = arr[row][col];
			arr[row][col] = arr[row][col - 1];
			arr[row][col - 1] = temp;
			}
		}
		if (movementkey == 'S')
		{
			if(row<arr.length-1 && arr[row+1][col]!='*'){
			temp = arr[row][col];
			arr[row][col] = arr[row + 1][col];
			arr[row+1][col] = temp;
			}
		}
		if (movementkey == 'D' )
		{
			if(col<arr[0].length-2 && arr[row][col+1]!='*'){
			temp = arr[row][col];
			arr[row][col] = arr[row][col + 1];
			arr[row][col + 1] = temp;
			}
		}
	}
	static void checker(char movementkey,char arr[][],int flag)
	{
		flag=0;
		int row=0;	int col=0;
		// FOR PLAYER LOCATION
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < arr[0].length; j++)
			{
				if (arr[i][j] == '0')
				{
					row = i;
					col = j;
					break;
				}
			}
		}
		if((arr[row+1][col]=='X' || arr[row-1][col]=='X' || arr[row][col+1]=='X' || arr[row][col-1]=='X') ||
		(arr[row+1][col]=='X' || arr[row-1][col]=='X' || arr[row][col+1]=='X' || arr[row][col-1]=='X'))
		{
			flag++;
			System.out.println("Congratulations,You find the exit!");
		}
	}
	static void MazerMaker(char arr[][])
	{
		int a=rn.nextInt(1,10);
		int b=rn.nextInt(1,10);
		for (int i = 0; i < 11; i++) 
		{
			int locationRandom1=rn.nextInt(1,10);
			int locationRandom2=rn.nextInt(1,10);
			for (int j = 0; j < 10; j++) 
			{
				if (i == 0 || i == arr.length-1 || j == 0 || j == arr[0].length-1) 
				{
					arr[i][j] = '#';
				} 
				else {arr[i][j] = ' ';}
				if((arr[a][1]!='*' )||(arr[1][b]!='*'))
				{
					arr[a][0]='0';	arr[0][b]='X';
					if(arr[0][b]=='X')arr[1][b]=' ';
					if(arr[a][0]=='0')arr[a][1]=' ';
				}
				if(a<6 && arr[i][j]==' ' && arr[i][j]!='#')
				{
					if(i!=arr.length-1 && j!=arr[0].length-1)arr[locationRandom1][i]='*';
				}
				if(a>5 && a<10 && arr[i][j]==' ' && arr[i][j]!='#')
				{
					if(i!=arr.length-1 && j!=arr[0].length-1)arr[j][locationRandom2]='*';
				}
			}
		}
	}
	public static void main(String[] args) {
		int flag=0;		int counter=0;
		// first arr 11x10
		char[][] maze = {
			{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
			{ '0', ' ', '*', ' ', '*', ' ', '*', ' ', ' ', '#' },
			{ '#', ' ', '*', ' ', ' ', ' ', '*', ' ', ' ', '#' },
			{ '#', ' ', '*', ' ', '*', ' ', '*', ' ', '*', '#' },
			{ '#', ' ', '*', ' ', '*', ' ', ' ', ' ', ' ', '#' },
			{ '#', ' ', '*', ' ', '*', '*', '*', '*', ' ', '#' },
			{ '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#' },
			{ '#', '*', '*', '*', '*', '*', '*', '*', ' ', '#' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', '*', ' ', '#' },
			{ '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#' },
			{ '#', '#', 'X', '#', '#', '#', '#', '#', '#', '#' }
			};
		MazerMaker(maze);
		System.out.println();
		for (int i = 0; i < maze.length; i++)
		{
			for (int j = 0; j < maze[0].length; j++)
			{
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}
		do {
			System.out.println("W-UP");	System.out.println("A-LEFT");
			System.out.println("S-DOWN");	System.out.println("D-RIGHT");
			char movementkey = sc.next().toLowerCase().toUpperCase().charAt(0);
			moveMazer(movementkey, maze);
			counter++;
			for (int i = 0; i < maze.length; i++)
			{
				for (int j = 0; j < maze[0].length; j++)
				{
					System.out.print(maze[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			checker(movementkey,maze,flag);
			System.out.println("counter: "+ counter);
		} while (flag==0);
	}
}
