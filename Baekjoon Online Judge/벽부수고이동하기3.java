package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 벽부수고이동하기3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		char map[][] = new char[n][m];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			map[i] = st.nextToken().toCharArray();
		}
		boolean visit[][][] = new boolean[k+1][n][m];
		ArrayDeque<int []> dq = new ArrayDeque<>();
		dq.add(new int[] {0,0,0,0});
		visit[0][0][0] = true;
		int dir[][] = {{1,0},{-1,0},{0,-1},{0,1}};
		int answer = -1;
		while(!dq.isEmpty()) {
			int now[] = dq.poll();
			int y = now[0];
			int x = now[1];
			int breaknumber = now[2]; // 내가 부순 벽의 개수 
			int time = now[3];
			if(y==n-1 && x ==m-1) {
				answer =time+1;
				break;
			}
			for(int i = 0 ; i < 4 ; i++) {
				int ny = y+ dir[i][0];
				int nx = x+ dir[i][1];
				if(ny >=0 && nx >=0 && nx< m && ny < n) {
					if(map[ny][nx]=='0' && !visit[breaknumber][ny][nx]) {
						// 0 이여서 갈수있는경우,
						visit[breaknumber][ny][nx] = true;
						dq.add(new int[] {ny,nx,breaknumber,time+1});
					} else if(map[ny][nx]=='1' && breaknumber+1<=k && !visit[breaknumber+1][ny][nx]) {
						visit[breaknumber+1][ny][nx] = true;
						dq.add(new int[] {ny,nx,breaknumber+1, time+1});
					}
				}
			}
			
		}System.out.println(answer);
	}
}
