package 풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 파핑파핑지뢰찾기 {
	static char[][] map;
	static boolean [][] visit;
	static int dir[][] = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		ArrayDeque<int []> dq = new ArrayDeque<>();
		for(int tc= 1 ; tc<=T ;tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			map = new char[n][n];
			visit = new boolean[n][n];
			for(int y = 0 ; y < n ; y++) {map[y] = br.readLine().toCharArray();}
			for(int y= 0 ; y < n ; y++) {
				for(int x = 0 ; x < n ; x++) {
					if(map[y][x]=='.') {
						int mine=0;
						for(int index = 0 ; index < 8 ; index++) {
							int ny = y + dir[index][0];
							int nx = x + dir[index][1];
							if(ny >= 0 && nx >=0 && ny < n && nx < n && map[ny][nx] =='*') {
								mine++;
							}
						}
						map[y][x] = (char)(mine+'0');
						if(map[y][x]=='0') {
							dq.add(new int[] {y,x});
						} 
					}
				}
			}
			int click =0;
			while(!dq.isEmpty()) {
				int now[] = dq.poll();
				int ny = now[0];
				int nx = now[1];
				
				if(map[ny][nx] =='0' &&  !visit[ny][nx]) {
					visit[ny][nx] = true;
					click++;
				}
				
				for(int index = 0 ; index < 8 ; index++) {
					int nexty = ny + dir[index][0];
					int nextx = nx + dir[index][1];
					if(nexty >=0 && nextx >= 0 && nextx < n && nexty < n ) {
						if(map[nexty][nextx]=='0' && !visit[nexty][nextx]) {
							dq.addFirst(new int[] {nexty,nextx});
							visit[nexty][nextx] = true;
						}else if(map[nexty][nextx]=='*') {
							continue;
						}else {
							visit[nexty][nextx] = true;
						}
					}
				}
			}
			for(int y = 0 ; y < n ; y++) {
				for(int x = 0 ; x < n ; x++) {
					if(map[y][x] != '*' && !visit[y][x]) click++;
				}
			}
			sb.append("#"+tc+" "+click+"\n");
		}
		System.out.print(sb);
	}

}
