package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 토마토 {
	
	public static void main(String[] args) throws Exception{
		int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
		int answer =0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int map[][] = new int[n][m];
		ArrayDeque<int []> dq = new ArrayDeque<>();
		//  0 번째는 y 좌표 1번째는 x 좌표 2번째는 날짜
		for (int y = 0 ; y<n ;y++) {
			st = new StringTokenizer(br.readLine());
			for(int x= 0 ; x < m ; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if(map[y][x]==1) dq.add(new int[] {y,x,0});		
			}
		}
		while(!dq.isEmpty()) {
			int now[] = dq.poll();
			int now_y =now[0]; int now_x = now[1]; int time = now[2];
			answer = time;
			for(int index = 0 ; index < 4 ; index++) {
				int next_y = now_y + dir[index][0];
				int next_x = now_x + dir[index][1];
				if(next_y >=0 && next_x >= 0 && next_y < n && next_x <m) {
					if(map[next_y][next_x]==0) {
						map[next_y][next_x]=1;
						dq.add(new int[] {next_y , next_x , time+1});
					}
				}
			}
		}
		
		for(int y = 0 ; y < n ; y++) {
			for(int x = 0 ; x < m ; x++) {
				if(map[y][x]==0) answer = -1;
			}
		}
		System.out.println( answer );
	}
	
}
