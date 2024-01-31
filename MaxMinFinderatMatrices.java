import java.util.*;
public class MaxMinFinderatMatrices {
		static Random rn= new Random();
		static Scanner sc= new Scanner(System.in);
		static int x,y;
		static int min=0,max=0;
//		MATRIX MAKER
		static void matrixMaker(int arr[][]) {
			System.out.println("*MATRIX*");
			for(int i=0 ; i<x ; i++) {
				for(int j=0 ; j<y ; j++) {
					arr[i][j]=rn.nextInt(1,9);
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
//		MAX MIN FINDER IN MATRIX
		static void MaxMinFinder(int arr[][],int min,int max) {
			for(int i=0 ; i<x ; i++) {
				min=arr[i][0];
				max=arr[i][0];
				for(int j=0 ; j<y ; j++) {
					if(min>arr[i][j]) min=arr[i][j];
					if(max<arr[i][j]) max=arr[i][j];
				}
				System.out.println((i+1) +".satır min değer "+ min+" *** max değer "+max);
				System.out.println();
			}
		}
		public static void main(String[] args) {
		System.out.println("x değeri:");
		 x=sc.nextInt();
		System.out.println("y değeri:");
		 y=sc.nextInt();
		int matrix[][]= new int [x][y];
		System.out.println();
		matrixMaker(matrix);
		System.out.println();
		MaxMinFinder(matrix,min,max);
		}
	}