package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경사로 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int answer =0;
		int map[][] = new int[2*N][N];
		
		for(int y=0;y <N ;y++) {
			st = new StringTokenizer(br.readLine());
			for(int x= 0; x< N; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		int copy[][] = new int[N][N];
		// 기존 배열을 90도 회전시켜 배열 아래에 붙여서 행의 값만 증가시켜서 한번에 확인한다.
		for(int y=0;y <N ;y++) {
			for(int x= 0 , i = N-1; x< N; x++ , i--) {
				map[N+y][x] = map[i][y];
			}
		}
		
		for(int y = 0 ; y < 2*N ; y++) {
			boolean visit[] = new boolean[N]; boolean can = true;
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
					}// 범위를 벗어난 경우
					for(int k = x -L ; k < x;k++) {
						if(now != map[y][k] || visit[k]) {
							can = false; break top;
						}
					}
					// 이전에 사용했던 경우
					if(can) {
						for(int k = x -L ; k < x;k++) {
							visit[k] = true;
						}
						now = map[y][x];
					// 경사로를 놓는다.
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
		System.out.println(answer);
	}

}


