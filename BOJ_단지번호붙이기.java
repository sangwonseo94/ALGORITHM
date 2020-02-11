package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class BOJ_단지번호붙이기 {
	static int dir[][] = {
			{1,0},
			{-1,0},
			{0,-1},
			{0,1}
	};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("answer/Baekjoon/BFS/단지번호붙이기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int map[][] = new int[n][n]; int no =1;
		for(int y = 0 ; y< n ;y++) {
			String temp = br.readLine();
			for(int x = 0 ; x < n ; x++) {
				map[y][x] = temp.charAt(x) -'0';
			}
		}
	
		ArrayDeque<int []> dq = new ArrayDeque<>();
		for(int y = 0 ;y < n ; y++) {
			for(int x= 0 ; x < n ; x++) {
				if(map[y][x] ==1) {
					map[y][x] +=no;
					dq.add(new int[] {y,x});
					while(!dq.isEmpty()) {
						int []now = dq.poll();
						int now_y = now[0];
						int now_x = now[1];
						for(int index= 0 ; index < 4 ; index++) {
							int ny = now_y + dir[index][1];
							int nx = now_x + dir[index][0];
							if(ny >= 0 && nx >=0 && ny < n && nx < n) {
								if(map[ny][nx] + no == map[y][x]) {
									map[ny][nx] +=no;
									dq.add(new int[] {ny,nx});
								}
							}
						}	
					}
					no++;
				}
			}
		}
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
}
