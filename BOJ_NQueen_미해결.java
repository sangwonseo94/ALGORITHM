package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_NQueen_미해결{
	
	static int N;
	static int ans;
	
	public static void NQueen(int y, int x, int cnt, boolean visit[][]) {
		if(!visit[y][x]) {
			if(cnt == N){
				ans++;
				return;
			}
			
			
			for(int i = 0 ; i < N ; i++) visit[y][i] = true;
			for(int i = 0 ; i < N ; i++) visit[i][x] = true;
			for(int i = x ,j = y ; i <N&& j >=0; i++ ,j--) visit[j][i] = true;
			for(int i = x ,j = y ; i <N&& j <N;  i++, j++) visit[j][i] = true;
			for(int i = x ,j = y ; i >=0&& j <N; i-- ,j++) visit[j][i] = true;
			for(int i = x ,j = y ; i >=0&& j >=0; i-- ,j--) visit[j][i] = true;
			
			if(check(visit)) return;
			
			for(int j= y ; j < N ; j++) {
				for(int i=0; i < N ;i++) {
					if(!visit[j][i]) {
						NQueen(j, i, cnt++ , visit);
					}
				}
			}
		}
		else {
			return;
		}
		
		
	}
	private static boolean check(boolean[][] visit) {
		for(int y = 0 ; y <N ; y++) {
			for(int x= 0 ; x <N; x++ ) {
				if(!visit[y][x]) return false;
			}
		}
		return true;
	}
	public static void main(String[] args)  throws Exception{
		
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int tc = Integer.parseInt(st.nextToken());
		
		for(int test  = 1 ; test <= tc ; test++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			boolean visit[][]= new boolean[N][N];
			
			for(int y= 0 ; y < N ; y++){
				for(int x = 0 ; x < N ; x++){
					if(!visit[y][x]) {
						NQueen(y,x,1,visit);	
					}
				}
			}		
			System.out.println(ans);
		}
	}
	
}
