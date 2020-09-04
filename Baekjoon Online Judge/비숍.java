package 풀문제;

import java.util.Scanner;

public class 비숍 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int map[][] = new int[n][n];
		for(int y= 0 ;y < n ; y++) {
			for(int x= 0 ; x < n ; x++) {
				map[y][x] = sc.nextInt();
			}
		}
		int cnt = 0 ,ny = 0 ,nx = 0;
		int dir[][] = {{1,1},{1,-1}};
		for(int y = 0 ; y < n ; y ++) {
			if(y == n-1) {
				for(int x = 0 ; x< n ; x++) {
					if(map[y][x] ==1) cnt++;
				}
				break;
			}
			for(int x = 0 ; x < n ; x++) {
				if(map[y][x] == 0) continue;
				else if(map[y][x]==1) {
					cnt++;
					//오른쪽 아래 대각선 파생
					ny = y + dir[0][0];
					nx = x + dir[0][1];
					if(ny < n && nx <n && nx >=0) {
						if(map[ny][nx]==1 || map[ny][nx] == 0)map[ny][nx] = 2;
						else if(map[ny][nx] ==3) map[ny][nx] = 5;
					}
					// 왼쪽 아래 대각선 파생
					ny = y + dir[1][0];
					nx = x + dir[1][1];
					if(ny < n && nx <n && nx >=0) {
						if(map[ny][nx]==1 || map[ny][nx] == 0)map[ny][nx] = 3;
						else if(map[ny][nx] ==2) map[ny][nx] = 5;
					}
				}
				else if(map[y][x] == 2) {
					ny = y + dir[0][0];
					nx = x + dir[0][1];
					if(ny < n && nx <n && nx >=0) {
						if(map[ny][nx]==3) {
							map[ny][nx] =5;
						}
							
						else map[ny][nx] = 2;
					}
				}
				else if(map[y][x] == 3) {
					ny = y + dir[0][0];
					nx = x + dir[0][1];
					if(ny < n && nx <n && nx >=0) {
						if(map[ny][nx]==2) {
							map[ny][nx] = 5;
						}
						else map[ny][nx] = 3;
					}
				}
				else if(map[y][x]==5) {
					ny = y + dir[0][0];
					nx = x + dir[0][1];
					if(ny < n && nx <n && nx >=0) {
						if(map[ny][nx]==1 || map[ny][nx] == 0)map[ny][nx] = 2;
						else if(map[ny][nx] ==3) map[ny][nx] = 5;
					}
					// 왼쪽 아래 대각선 파생
					ny = y + dir[1][0];
					nx = x + dir[1][1];
					if(ny < n && nx <n && nx >=0) {
						if(map[ny][nx]==1 || map[ny][nx] == 0)map[ny][nx] = 3;
						else if(map[ny][nx] ==2) map[ny][nx] = 5;
					}
				}
			}
		}
		System.out.print(cnt);
	}
}
