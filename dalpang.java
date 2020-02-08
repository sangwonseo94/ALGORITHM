package practice;

import java.util.Scanner;

public class dalpang {
	static int number = 1 ,  x = 0 , y = 0 , End=0  ;

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int map[][] = new int[N][N];
		if(N%2 ==1) map[N/2][N/2] = N*N;
		int loop = N/2;
		while(End != loop) {
		for( ; x < N-1 ; x++) {map[y][x] =number; number++;}
		for( ; y < N-1 ; y++) {map[y][x] =number; number++;}
		for( ; x > End ; x--) {map[y][x] =number; number++;}
		for( ; y > End ; y --){map[y][x] =number; number++;}
		x++; y++;
		N -=1;
		End +=1;
		}
		for(int j = 0 ; j < 2*loop ; j ++) {
			for(int i = 0 ; i < 2*loop ; i ++) {
				System.out.print(map[j][i]+ " ");
			}
			System.out.println();
		}
	}

}
