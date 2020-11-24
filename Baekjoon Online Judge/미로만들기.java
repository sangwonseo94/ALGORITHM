package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 미로만들기 {
 
	
	public static void main(String[] args)throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		char map[][] = new char[n][n];
		for(int i = 0 ; i < n ; i ++) {map[i] = br.readLine().toCharArray();}
		// end of input
		
		boolean visit[][][] = new boolean[n*n][n][n];
		ArrayDeque<int[]> dq= new ArrayDeque<>();
		visit[0][0][0] = true;
		dq.add(new int[] {0,0,0});
		int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};
		while(!dq.isEmpty()) {
			
			int[] now = dq.poll();
			
			if(now[0] == n-1 && now[1] == n-1) {
				System.out.println(now[2]);
				break;
			}
			
			else {
				for(int i = 0 ; i < 4 ; i++) {
					int ny = now[0] + dir[i][0];
					int nx = now[1] + dir[i][1];
					if(ny>=0 && nx >=0 && ny < n && nx < n) {
						if(!visit[now[2]][ny][nx] && map[ny][nx]=='1') {
							visit[now[2]][ny][nx]= true;
							dq.addFirst(new int[] {ny,nx,now[2]});
						} else if(!visit[now[2]][ny][nx] && map[ny][nx]=='0') {
							visit[now[2]+1][ny][nx]= true;
							dq.addLast(new int[] {ny,nx,now[2]+1});
						}
					}
				}
			}
			
			
			
		}
		
	}
}
