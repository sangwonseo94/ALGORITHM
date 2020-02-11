package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class SWEA_등산로조성 {
	static int T,N,K,cnt=0, h_max, res,answer;
	static int map[][];
	static boolean visit[][];
	static int heightest_pos[][];
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void input() throws Exception {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken())+1;
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visit = new boolean[N][N];
		
		h_max = -1;
		
		for (int y = 1 ; y <N ; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x = 1 ;x <N ; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				h_max = Math.max(h_max, map[y][x]);
			}
		}
		
		heightest_pos = new int[5][2];
		
		for(int y= 1; y < N ; y++){
			for(int x=1; x< N; x++){
				if(map[y][x]== h_max){
					heightest_pos[cnt][0] = y; // 0 은 y
					heightest_pos[cnt][1] = x; // 1 은 x
					cnt++;
				}
			}
		}
	}
	
	public static void DFS(int y, int x ,boolean breakor, int len , int now_h) {
		
		res = Math.max(res, len);
		
		for(int index = 0 ; index < 4 ; index++) {
			
			int nx = x + dx[index];
			int ny = y + dy[index];
			
			if(nx >=1 && ny >=1 && nx < N && ny < N) {
				
				if(map[ny][nx] < now_h && !visit[ny][nx]){
					
					visit[ny][nx] = true;
					DFS(ny,nx,breakor,len+1 , map[ny][nx]);
					visit[ny][nx] = false;
				}
				else if((map[ny][nx] - K < now_h) && !breakor && !visit[ny][nx]) {
					int hh = 1;
					for(; hh <=K ; hh++) {
						if(now_h-1 == (map[ny][nx]-hh)) break;
					}
					hh--;
					
					breakor= true;
					visit[ny][nx] = true;
					DFS(ny,nx,breakor,len+1, map[ny][nx] -hh);
					visit[ny][nx] = false;
					breakor =false;
						
					
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		T = Integer.parseInt(br.readLine().trim());
		for(int tc =1 ; tc<=T ;tc++) {
			input();
			
			for(int index=0; index< cnt; index++) {
				int y = heightest_pos[index][0];
				int x = heightest_pos[index][1];
				visit[y][x] = true;
				DFS( y, x, false,1, h_max);
				visit[y][x] = false;
				answer = Math.max(answer, res);
				System.out.println(answer);
			}
		
			System.out.println("#"+tc+" "+answer);
			answer =0; res =0; cnt =0;
		}
	}

	
}
