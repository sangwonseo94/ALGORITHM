package 풀문제2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사탕게임 {
	static int n =0 , answer =0;
	static char map[][];
	static boolean visit[][][];
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		map = new char[n][n];
		for(int i = 0 ; i < n ; i ++) {map[i] = br.readLine().toCharArray();}
		visit = new boolean[n][n][4];
		int dir[][] = {{0,1},{1,0}};
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				char now = map[i][j];
				for(int k = 0 ; k < 2 ; k++) {
					int ny = i + dir[k][0];
					int nx = j + dir[k][1];
					if(isRange(ny,nx) && now != map[ny][nx]) {
						char temp = map[ny][nx];
						map[ny][nx] = map[i][j];
						map[i][j] = temp;
						int res = judge();
						answer = answer > res ? answer : res; 
						temp = map[ny][nx];
						map[ny][nx] = map[i][j];
						map[i][j] = temp;
					}
				}
			}
		}
		System.out.println(answer);
	}
	private static int judge() {
		//연속된것 찾기
		int max =1;
		for(int i = 0 ; i < n ; i ++) {
			char x = map[i][0];
			char y = map[0][i];
			int resx = 1; 
			int resy = 1;
			for(int j = 1 ; j < n ; j++) {
				if(x != map[i][j]) {
					resx =1;
					x = map[i][j];
				} else {
					resx++;
					max  = max > resx? max : resx;
				}
				
				if( y!= map[j][i]) {
					resy=1;
					y = map[j][i];
				} else {
					resy++;
					max = max > resy ? max : resy;
				}
			}
		}
		return max;
	}
	private static boolean isRange(int ny, int nx) {
		return (ny < n && nx < n && ny >=0 && nx>=0);
	}
}
