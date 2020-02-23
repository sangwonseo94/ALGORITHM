package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Thread.State;
import java.util.StringTokenizer;

public class SWEA_핀볼게임 {
	static int res =0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1 ; tc <= T ; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int map[][] = new int[n][n];
			int warmhole[][] = new int[11][4];
			for(int index = 6 ; index < 11; index++)warmhole[index][0] = -1;
			for(int y = 0 ; y < n ; y++) {
				st = new StringTokenizer(br.readLine());
				for(int x = 0 ; x< n ; x++) {
					map[y][x] = Integer.parseInt(st.nextToken());
					if(map[y][x] == 6) {
						if(warmhole[6][0] == -1 ) {
							warmhole[6][0] =y ;
							warmhole[6][1] =x ;
						}
						else {
							warmhole[6][2] =y ;
							warmhole[6][3] =x ;
						}
					}
					else if(map[y][x] == 7) {
						if(warmhole[7][0] == -1 ) {
							warmhole[7][0] =y ;
							warmhole[7][1] =x ;
						}
						else {
							warmhole[7][2] =y ;
							warmhole[7][3] =x ;
						}
					}else if(map[y][x] == 8) {
						if(warmhole[8][0] == -1) {
							warmhole[8][0] =y ;
							warmhole[8][1] =x ;
						}
						else {
							warmhole[8][2] =y ;
							warmhole[8][3] =x ;
						}
					}else if(map[y][x] == 9) {
						if(warmhole[9][0] == -1 ) {
							warmhole[9][0] =y ;
							warmhole[9][1] =x ;
						}
						else {
							warmhole[9][2] =y ;
							warmhole[9][3] =x ;
						}
					}else if(map[y][x] == 10) {
						if(warmhole[10][0] == -1 ) {
							warmhole[10][0] =y ;
							warmhole[10][1] =x ;
						}
						else {
							warmhole[10][2] =y ;
							warmhole[10][3] =x ;
						}
					}
				}
			}
			int directionx[] = {0,0,-1,1};
			int directiony[] = {-1,1,0,0};
			for(int y = 0 ; y < n ; y++) {
				for(int x = 0 ; x < n ; x++) {
					if(map[y][x] ==0) {
						
						for(int dir = 0 ; dir < 4 ; dir++) {
							int startx = x , starty = y;
							int startdir = dir;
							boolean end = false;
							int answer =0;
							while(true) {
								
								int nexty =starty + directiony[startdir];
								int nextx =startx + directionx[startdir];
								if(nexty < 0 || nexty >= n || nextx < 0 || nextx >= n) {
									answer++;
									if(startdir ==0) startdir =1;
									else if(startdir==1) startdir=0;
									else if(startdir==2) startdir=3;
									else if(startdir==3) startdir=2;
									starty = nexty; startx = nextx;
									continue;
								}
								 else if(map[nexty][nextx] == -1) {
									break;
								}
								else if(map[nexty][nextx] == 0) {
									if(nexty== y && nextx == x) {break;}
									starty = nexty; startx = nextx;
									continue;
								}
								else if(map[nexty][nextx] == 1) {
									answer++;
									if(startdir==1) startdir=3;
									else if(startdir==0) startdir=1;
									else if(startdir==2) startdir=0;
									else if(startdir==3) startdir=2;
									starty = nexty; startx = nextx;
									continue;
								}else if(map[nexty][nextx] ==2) {
									answer++;
									if(startdir==1) startdir=0;
									else if(startdir==0) startdir=3;
									else if(startdir==2) startdir=1;
									else if(startdir==3) startdir=2;
									starty = nexty; startx = nextx;
									continue;
								}else if(map[nexty][nextx] ==3) {
									answer++;
									if(startdir==1) startdir=0;
									else if(startdir==0) startdir=2;
									else if(startdir==2) startdir=3;
									else if(startdir==3)startdir=1;
									starty = nexty; startx = nextx;
									continue;
								}else if(map[nexty][nextx] ==4) {
									answer++;
									if(startdir==1) startdir=2;
									else if(startdir==0) startdir=1;
									else if(startdir==2) startdir=3;
									else if(startdir==3) startdir=0;
									starty = nexty; startx = nextx;
									continue;
								}else if(map[nexty][nextx] ==5) {
									answer++;
									if(startdir ==0) startdir =1;
									else if(startdir==1) startdir=0;
									else if(startdir==2) startdir=3;
									else if(startdir==3) startdir=2;
									starty = nexty; startx = nextx;
									continue;
								}
								else if(map[nexty][nextx]==6) {
									if(nexty == warmhole[6][0] && nextx == warmhole[6][1]) {
										starty = warmhole[6][2];
										startx = warmhole[6][3];
									}
									else {
										starty= warmhole[6][0];
										startx= warmhole[6][1];
									}
									continue;
								}else if(map[nexty][nextx]==7) {
									if(nexty == warmhole[7][0] && nextx == warmhole[7][1]) {
										starty = warmhole[7][2];
										startx = warmhole[7][3];
									}
									else {
										starty= warmhole[7][0];
										startx= warmhole[7][1];
									}
									continue;
								}else if(map[nexty][nextx]==8) {
									if(nexty == warmhole[8][0] && nextx == warmhole[8][1]) {
										starty = warmhole[8][2];
										startx = warmhole[8][3];
									}
									else {
										starty= warmhole[8][0];
										startx= warmhole[8][1];
									}
									continue;
								}else if(map[nexty][nextx]==9) {
									if(nexty == warmhole[9][0] && nextx == warmhole[9][1]) {
										starty = warmhole[9][2];
										startx = warmhole[9][3];
									}
									else {
										starty= warmhole[9][0];
										startx= warmhole[9][1];
									}
									continue;
								}else if(map[nexty][nextx]==10) {
									if(nexty == warmhole[10][0] && nextx == warmhole[10][1]) {
										starty = warmhole[10][2];
										startx = warmhole[10][3];
									}
									else {
										starty= warmhole[10][0];
										startx= warmhole[10][1];
									}
									continue;
								}
								
							}
							res = res > answer ? res : answer;
						}
					}
				}
			}
			sb.append("#" + tc +" "+res +"\n");
			res =0;
		}
		System.out.println(sb);
		
	}

}
