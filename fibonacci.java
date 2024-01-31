import java.util.Scanner;

public class fibonacci {

	public static void main(String[] args) {
		// 1 1 2 3 5 8 13 21 34
		Scanner sc = new Scanner(System.in);
		String addCancel;
		long num1 = 1;
		long num2 = 0;
		long sum = 0;
		do {
			addCancel = sc.next();
			if(num1>=0 && num2>=0 && sum>=0) {
			switch (addCancel) {
			case "+":
				sum = num1 + num2;
				num1 = num2;
				num2 = sum;
				System.out.println(sum);
				break;
			case "-":
				sum = num1;
				num1 = num2 - sum;
				num2 = sum;
				System.out.println(sum);
				break;
			}
		}
			else {System.out.println("Fibonacci Array cannot take negative values.");
			num1 = 1;
		num2 = 0;
		sum = 0;
			}
		}
		while (addCancel != "+" || addCancel == "-");
		sc.close();
	}
}