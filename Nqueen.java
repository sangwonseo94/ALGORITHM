package practice;

import java.util.Scanner;

public class Nqueen {
	static int n ;
	static int visit[][];
	static int answer =0;
	public static void main(String[] args) {
		input();
		Put_Queen(0,0,0);
		System.out.println(answer);
	}

	public static void input() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		visit= new int[n][n];
		sc.close();
	}
	
	public static void Put_Queen(int a , int b,int cnt) {
		if(cnt == n) {
			answer++;
			return;
		}
		for(int y = 0 ; y < n ; y ++) {
			for(int x = 0 ; x < n ; x++) {
				if(visit[y][x]==0) {
					check(y,x,1);
					Put_Queen(y, x, cnt+1);
					check(y,x,-1);
				}
			}
		}
	}

	public static void check(int y, int x, int i) {
		for(int index = x+1 ; index <n ; index++)visit[y][index] +=i; // 오른쪽
		for(int index = y+1 ; index <n ; index++)visit[index][x] +=i; // 아래쪽
		for(int index = x-1 ; index >=0 ; index--)visit[y][index] +=i; // 왼쪽
		for(int index = y-1 ; index >=0 ; index--)visit[index][x] +=i; // 위쪽
		visit[y][x] +=i;
		for(int index = 1 ; index <n ; index++)if(y-index >=0 && x+index< n)visit[y-index][x+index] +=i; // 오른쪽 위
		for(int index = 1 ; index <n ; index++)if(y+index < n && x+index< n)visit[y+index][x+index] +=i; // 오른쪽 아래
		for(int index = 1 ; index <n ; index++)if(y-index >=0 && x-index>=0)visit[y-index][x-index] +=i; // 왼쪽 위
		for(int index = 1 ; index <n ; index++)if(y+index < n && x-index>=0)visit[y+index][x-index] +=i; // 왼쪽 아래	
	}
}
