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
			if(col>1 && arr[row][col-1]!='#'){
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
		flag=0;		char temp='X';
		int row = 0;	int col = 0;
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < arr[0].length; j++)
			{
				if (arr[i][j] == '0')
				{
					row = i;	col = j;
					break;
				}
			}
		}
		if (movementkey == 'W' )
		{
				temp = arr[row][col];
				arr[row][col] = arr[row-1][col];
				arr[row-1][col] = temp;
		}
		if (movementkey == 'A')
		{
			temp = arr[row][col];
			arr[row][col] = arr[row][col - 1];
			arr[row][col - 1] = temp;
		}
		if (movementkey == 'S')
		{
			temp = arr[row][col];
			arr[row][col] = arr[row + 1][col];
			arr[row+1][col] = temp;
		}
		if (movementkey == 'D' )
		{
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[0].length; j++) {
					temp = arr[i][j];
					arr[i][j] = arr[i][j+1];
					arr[j][j+1] = temp;
				}
			}
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
				{ '#', '#', '#', '#', '#', '#', '#', '#', 'X', '#' }
				};
				System.out.println();
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}
		do {
			char movementkey = sc.next().toLowerCase().toUpperCase().charAt(0);
			moveMazer(movementkey, maze);
			//checker(maze);
			counter++;
			for (int i = 0; i < maze.length; i++) {
				for (int j = 0; j < maze[0].length; j++) {
					System.out.print(maze[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
		} while (flag==0);
		System.out.println("counter: "+ counter);
	}
}
