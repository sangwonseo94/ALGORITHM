package 풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇청소기 {
	static int n,m,nowx,nowy,nextx, nexty ,map[][] , nowdir;
	static int dir[][] = { {-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		nowy = Integer.parseInt(st.nextToken());
		nowx = Integer.parseInt(st.nextToken());
		nowdir = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for(int y = 0 ; y < n ; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=  0 ; x<  m ; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		boolean go = true;
		while(go) {
			
			if(map[nowy][nowx] ==0 ) {map[nowy][nowx] = 2; } // 청소
			
			if(nowdir == 1) {
				nexty = nowy+dir[0][0];
				nextx = nowx+dir[0][1];
				if(map[nexty][nextx] == 0) {
					nowy = nexty; nowx = nextx;
					nowdir =0;
					continue;
				}
				else if(map[nexty][nextx] != 1){
					nowdir = 0;
					continue;
				}
				else if(map[nexty][nextx] == 1 || fourcheck(nowy, nowx)) {
					nexty = nowy + dir[2][0];
					nextx = nowx + dir[2][1];
					if(map[nexty][nextx] ==1) {
						break;
					}
					nowy = nexty;
					nowx = nextx;
					continue;
				}
			}else if(nowdir == 2) {
				nexty = nowy+dir[3][0];
				nextx = nowx+dir[3][1];
				if(map[nexty][nextx] == 0) {
					nowy = nexty; nowx = nextx;
					nowdir =1;
					continue;
				}
				else if(map[nexty][nextx] != 1){
					nowdir = 1;
					continue;
				}
				else if(map[nexty][nextx] == 1 || fourcheck(nowy, nowx)) {
					nexty = nowy + dir[0][0];
					nextx = nowx + dir[0][1];
					if(map[nexty][nextx] ==1) {
						break;
					}
					nowy = nexty;
					nowx = nextx;
					continue;
				}
			}else if(nowdir == 3) {
				nexty = nowy+dir[1][0];
				nextx = nowx+dir[1][1];
				if(map[nexty][nextx] == 0) {
					nowy = nexty; nowx = nextx;
					nowdir =2;
					continue;
				}
				else if(map[nexty][nextx] != 1){
					nowdir = 2;
					continue;
				}
				else if(map[nexty][nextx] == 1 || fourcheck(nowy, nowx)) {
					nexty = nowy + dir[3][0];
					nextx = nowx + dir[3][1];
					if(map[nexty][nextx] ==1) {
						break;
					}
					nowy = nexty;
					nowx = nextx;
					continue;
				}
			}else if(nowdir == 0) {
				nexty = nowy+dir[2][0];
				nextx = nowx+dir[2][1];
				if(map[nexty][nextx] == 0) {
					nowy = nexty; nowx = nextx;
					nowdir =3;
					continue;
				}
				else if(map[nexty][nextx] != 1){
					nowdir = 3;
					continue;
				}
				else if(map[nexty][nextx] == 1 || fourcheck(nowy, nowx)) {
					nexty = nowy + dir[1][0];
					nextx = nowx + dir[1][1];
					if(map[nexty][nextx] ==1) {
						break;
					}
					nowy = nexty;
					nowx = nextx;
					continue;
				}
			}
		}
		int cnt = 0;
		for(int y= 0 ; y < n ; y++) {
			for(int x = 0 ; x < m ; x++) {
				System.out.print(map[y][x] +" ");
				if(map[y][x] ==2) cnt++;
			}
			System.out.println();
		}
		System.out.println(cnt);
	}

	private static boolean fourcheck(int nowy2, int nowx2) {
		
		for(int index = 0 ; index < 4 ; index++) {
			int y = nowy2 + dir[index][0];
			int x = nowx2 + dir[index][1];
			if(map[y][x] != 2) return false;
		}
		return true;
	}
}
