package 풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 보물섬 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int answer = Integer.MIN_VALUE;
		char map[][] = new char[n][m];
		int dir[][] = {{1,0},{-1,0},{0,-1},{0,1}};
		for(int y= 0 ;  y< n ; y++) map[y] = br.readLine().toCharArray();
		ArrayDeque<int []> dq = new ArrayDeque<>();
		for(int y= 0 ; y < n  ; y++) {
			for(int x = 0 ; x < m ; x++) {
				if(map[y][x] !='W') {
					boolean visit[][] = new boolean[n][m];
					dq.add(new int[] {y,x,0}); visit[y][x] = true;
					while(!dq.isEmpty()) {
						int now[] = dq.poll();
						answer = (answer > now[2]) ? answer : now[2];
						for(int index = 0 ; index < 4 ; index++) {
							int ny = now[0] +dir[index][0];
							int nx = now[1] +dir[index][1];
							if(ny >=0 && nx>=0 && ny < n && nx < m) {
								if(map[ny][nx]=='L' && !visit[ny][nx]) {
									visit[ny][nx] = true;
									dq.add(new int[] {ny,nx,now[2]+1});
								}
							}
						}
					}
				}
			}
		}
		System.out.println(answer);
	}

}
