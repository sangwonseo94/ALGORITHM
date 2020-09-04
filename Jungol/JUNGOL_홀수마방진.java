package practice;

import java.util.Scanner;

public class JUNGOL_홀수마방진 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int map[][] = new int[n][n];
		int y = 0; int x = n/2;
		map[y][x] = 1;
		for(int index =2 ; index <= n*n; index++) {
			if(map[y][x] % n == 0) {
				y+=1;map[y][x] = (index); continue;
			}
			
			else {
				if( y-1 >= 0 && x -1 >= 0) {
					map[--y][--x] = (index);
					continue;
				}
				else if(y-1 <0){
					y=(n-1); x--;
					map[y][x]=index;
					continue;
				}
				else if(x-1<0) {
					x =(n-1); y--;
					map[y][x]=index;
					continue;
				}
			}
		}
		for(int b=0;b<n;b++) {
			for(int a=0;a<n;a++) {
				System.out.print(map[b][a] +" ");
			}
			System.out.println();
		}
	}
}
