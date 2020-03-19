package 풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 상범빌딩 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
			while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int z = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			if(z == 0) break;
			int sz = 0 , sy = 0 , sx = 0;
			char map[][][] = new char[z][y][x];
			boolean visit[][][] = new boolean[z][y][x];
			for(int i = 0 ; i < z ; i ++) {
				for(int j = 0 ; j < y ; j++) {
					char[] temp = br.readLine().toCharArray();
					for(int k = 0 ; k < x ; k ++) {
						map[i][j][k] = temp[k]; 
						if(map[i][j][k] =='S') {
							sz = i;
							sy = j;
							sx = k;
						}
					}
				}
				br.readLine();
			}
			
			ArrayDeque<int []> dq = new ArrayDeque<>();
			dq.add(new int[] {sz,sy,sx,0});
			visit[sz][sy][sx] = true;
			int ans = 987654321;
			int dir[][] = {
					{1,0,0},
					{-1,0,0},
					{0,0,-1},
					{0,0,1},
					{0,1,0},
					{0,-1,0}
			};
			while(!dq.isEmpty()) {
				int []now = dq.poll();
				
				if(map[now[0]][now[1]][now[2]] == 'E') {
					ans = now[3];
					break;
				}
				
				for(int index = 0 ; index <6 ;index++) {
					int nz = now[0] + dir[index][0];
					int ny = now[1] + dir[index][1];
					int nx = now[2] + dir[index][2];
					
					if(nz >= 0 && nx >=0 && ny >= 0 && nz < z && nx <x && ny < y) {
						if(!visit[nz][ny][nx] && (map[nz][ny][nx] =='.'||  map[nz][ny][nx] =='E')) {
							visit[nz][ny][nx] = true;
							dq.add(new int[] {nz,ny,nx,now[3]+1});
						}
					}
				}
			}
			
			if(ans == 987654321)sb.append("Trapped!\n");
			else sb.append("Escaped in "+ans+" minute(s).\n");
		}
		System.out.println(sb);
	}
}
