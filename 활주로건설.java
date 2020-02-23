package practice;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 활주로건설 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1 ; tc<=T ;tc++) {
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int map[][] = new int[2*N][N];
		
		for(int y=0;y <N ;y++) {
			st = new StringTokenizer(br.readLine());
			for(int x= 0; x< N; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		int copy[][] = new int[N][N];
		
		for(int y=0;y <N ;y++) {
			for(int x= 0 , i = N-1; x< N; x++ , i--) {
				map[N+y][x] = map[i][y];
			}
		}
		int answer =0;
		for(int y = 0 ; y < 2*N ; y++) {
			boolean visit[] = new boolean[N];
			boolean can = true;
			int now =map[y][0];
			top:
			for(int x=1; x < N ; x++) {
				if(map[y][x]==now) continue;
				if(now+1 < map[y][x] || now-1 > map[y][x]) {
					can = false; break top;
				}
				if(now+1 == map[y][x]) {
					//오르막 경사
					if(x-L <0) {
						can = false; break top;
					}
					for(int k = x -L ; k < x;k++) {
						if(now != map[y][k] || visit[k]) {
							can = false; break top;
						}
					}
					if(can) {
						for(int k = x -L ; k < x;k++) {
							visit[k] = true;
						}
						now = map[y][x];
					}
				}
				if(now-1== map[y][x]) {
					if(x+L-1 >=N) {
						can =false;break top;
					}
					for(int k = x+1 ; k < x+L;k++) {
						if(map[y][x] != map[y][k] || visit[k]) {
							can = false; break top;
						}
					}
					if(can) {
						for(int k = x ; k < x+L;k++) {
							visit[k] = true;
						}
						
						now = map[y][x];
					}
				}
			}
			if(can) answer++;
		}
		sb.append("#"+ tc+" "+answer+"\n");
		answer =0;
		}
		System.out.println(sb);
	}

}


