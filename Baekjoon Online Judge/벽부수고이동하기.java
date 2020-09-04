package 풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 벽부수고이동하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int map[][] = new int[n][m];
		int dir[][] = {{0,1},{1,0},{-1,0},{0,-1}};
		boolean visit[][][] = new boolean[n][m][2];
		
		for(int y = 0 ; y < n ; y++) {
			char[] temp = br.readLine().toCharArray();
			for(int x = 0 ; x< m ; x++) {
				map[y][x] = temp[x]-'0';
			}
		}
		ArrayDeque<int []> dq= new ArrayDeque<>();
		dq.push(new int[] {0,0,0,1});
		visit[0][0][0] = true;
		int ans = 987654321;
		while(!dq.isEmpty()) {
			
			int []now = dq.poll();
			if(now[0]==n-1 && now[1] ==m-1) {
				if(ans > now[3]) {
					ans = now[3];
				}
				break;
			}
			
			for(int index = 0 ; index < 4 ; index++) {
				
				int ny = now[0] + dir[index][0];
				int nx = now[1] + dir[index][1];
				if(ny >= 0 && nx >=0 && ny < n && nx <m) {
					
					if(!visit[ny][nx][now[2]]  && map[ny][nx] ==0) {
						visit[ny][nx][now[2]] = true;
						dq.add(new int[] {ny,nx,now[2],now[3]+1});
					}
					
					if(!visit[ny][nx][1] && map[ny][nx]==1 && now[2]==0) {
						visit[ny][nx][1] = true;
						dq.add(new int[] {ny,nx,1,now[3]+1});
					}
				}
			}
		}
		System.out.println((ans = ans == 987654321 ? -1 : ans));
		
	}

}
