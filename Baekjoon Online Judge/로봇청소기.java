package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇청소기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n= Integer.parseInt(st.nextToken());
		int m= Integer.parseInt(st.nextToken());
		int map[][] = new int[n][m];
		st = new StringTokenizer(br.readLine());
		int sy = Integer.parseInt(st.nextToken());
		int sx = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		//0 북,1 동,2 남,3서
		int dir[][] = {{-1,0},{0,1},{1,0},{0,-1}};
		int cnt =0;
		int answer=0;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for( int j=0; j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(true) {
			if(map[sy][sx]==0) {
				map[sy][sx] =2;
				answer++;
				cnt=0;
			}
			if(cnt==4) {
				int ny = sy+dir[(d+2)%4][0];
				int nx = sx+dir[(d+2)%4][1];
				if(map[ny][nx]==2) {
					sy = ny; 
					sx = nx;
					cnt=0;
					continue;
				} else {
					System.out.println(answer);
					break;
				}
			}
			int ny = sy+dir[(d+3)%4][0];
			int nx = sx+dir[(d+3)%4][1];
			if( map[ny][nx] ==0) {
				d = (d+3)%4;
				sy = ny ; sx = nx;
				continue;
			} else {
				d = (d+3)%4;
				cnt++;
			}
		}
	}

}
