import java.util.Scanner;
// arr.length = 11(row)
// arr[0].lenght = 10(col)
public class MazeRunner
{
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
			if(row>1 && arr[row-1][col]!='#'){
				temp = arr[row][col];
				arr[row][col] = arr[row-1][col];
				arr[row-1][col] = temp;
			}
		}
		if (movementkey == 'A')
		{
			if(col>0 && arr[row][col-1]!='#'){
			temp = arr[row][col];
			arr[row][col] = arr[row][col - 1];
			arr[row][col - 1] = temp;
			}
		}
		if (movementkey == 'S')
		{
			if(row<arr.length-1 && arr[row+1][col]!='#'){
			temp = arr[row][col];
			arr[row][col] = arr[row + 1][col];
			arr[row+1][col] = temp;
			}
		}
		if (movementkey == 'D' )
		{
			if(col<arr[0].length-2 && arr[row][col+1]!='#'){
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
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int flag=0;		int counter=0;
		char[][] maze = {
				{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
				{ '0', ' ', '#', ' ', '#', ' ', '#', ' ', ' ', '#' },
				{ '#', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', '#' },
				{ '#', ' ', '#', ' ', '#', ' ', '#', ' ', '#', '#' },
				{ '#', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', '#' },
				{ '#', ' ', '#', ' ', '#', '#', '#', '#', ' ', '#' },
				{ '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#' },
				{ '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#' },
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#' },
				{ '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#' },
				{ '#', '#', 'X', '#', '#', '#', '#', '#', '#', '#' }
				};
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
			System.out.println("W-UP");
			System.out.println("A-LEFT");
			System.out.println("S-DOWN");
			System.out.println("D-RIGHT");
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
