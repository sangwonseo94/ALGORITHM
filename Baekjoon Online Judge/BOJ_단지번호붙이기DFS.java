package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class BOJ_단지번호붙이기DFS {
	static int dir[][] = {
			{1,0},
			{-1,0},
			{0,-1},
			{0,1}
	};
	static int n , map[][];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("answer/Baekjoon/BFS/단지번호붙이기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 n = Integer.parseInt(br.readLine());
		 map = new int[n][n]; int no =1;
		
		for(int y = 0 ; y< n ;y++) {
			String temp = br.readLine();
			for(int x = 0 ; x < n ; x++) {
				map[y][x] = temp.charAt(x) -'0';
			}
		}
	
		for(int y = 0 ; y< n ;y++) {
			for(int x = 0 ; x < n ; x++) {
				if(map[y][x] == 1) {
					map[y][x] = ++no;
					DFS(y,x, no);
				}		
			}
		}
		int t= 10;
		System.out.println(no-1);
		int count[] = new int[no];
		for(int y = 0 ; y< n ;y++) {
			for(int x = 0 ; x < n ; x++) {
				if(map[y][x] != 0) {
					count[map[y][x] -1] +=1;
				}		
			}
		}
		Arrays.sort(count);
		if(count.length==0) System.out.println(0);
		else {
			for(int index = 1; index < no ; index++) {
				System.out.println(count[index]);
			}
		}
	
	}
	
	public static void DFS(int y, int x , int no) {
		for(int index = 0 ; index < 4 ; index++){
			int ny = y +dir[index][0];
			int nx = x +dir[index][1];
			if ( ny >= 0 && nx >=0 && nx < n && ny < n && map[ny][nx] ==1 ) {
				map[ny][nx] = no;
				DFS(ny,nx,no);
			}
		}
	}
	
	
}










