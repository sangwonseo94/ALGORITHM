package 풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 톱니바퀴 {
	static int map[][] = new int[4][8];
	static int r[] = new int[4];
	static boolean v[] = new boolean[4];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc<=t ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			for(int index = 0 ; index< 4 ; index++) {
				st = new StringTokenizer(br.readLine());
				for(int x = 0 ; x < 8 ; x++) {
					map[index][x] = Integer.parseInt(st.nextToken());
				}
			}
			
			int rotate[][] = new int[k][2]; 
			for(int index = 0 ; index < k  ; index++) {
				st = new StringTokenizer(br.readLine());
				rotate[index][0] = Integer.parseInt(st.nextToken())-1;
				rotate[index][1] = Integer.parseInt(st.nextToken());
			}
			
			for(int index = 0 ; index < k ; index++) {
				// 2번과 6번
				for(int i = 0 ; i < 4 ; i++) {
					r[i]=0; v[i] = false;	
				}
				r[rotate[index][0]] = rotate[index][1];
				dfs(rotate[index][0] , rotate[index][1]);
				for(int i = 0 ; i < 4 ; i ++) {
					if(r[i]==0) continue;
					Rotate(i, r[i]);
				}
			}
			
			int answer =0;
			if(map[0][0] ==1) answer+=1;
			if(map[1][0] ==1) answer+=2;
			if(map[2][0] ==1) answer+=4;
			if(map[3][0] ==1) answer+=8;
			System.out.println("#"+tc+" "+answer);
		}
		
	}
	
	public static void dfs(int index, int dir) {
		if(v[index]) return;
		v[index] = true;
		if(index -1 >=0 && !v[index-1]) {
			if(map[index-1][2] != map[index][6]) {
				if(dir==1) {
					r[index-1] = -1;
					dfs(index-1,-1);
				}
				else {
					r[index-1] = 1;
					dfs(index-1,1);
				}
			}
		}
		if(index +1 < 4 && !v[index+1]) {
			if(map[index+1][6] != map[index][2]) {
				if(dir==1) {
					r[index+1] = -1;
					dfs(index+1, -1);
				}
				else {
					r[index+1] = 1;
					dfs(index+1 , 1);
				}
			}
		}
	}

	public static void Rotate(int index, int dir) {
		int temp =0;
		if(dir ==1) {
			temp = map[index][7];
			for(int i = 7 ; i >=1 ; i--) {
				map[index][i] = map[index][i-1];
			}
			map[index][0] = temp;
		}
		else if(dir == -1) {
			temp = map[index][0];
			for(int i = 1 ; i < 8 ; i++) {
				map[index][i-1]=map[index][i];
			}
			map[index][7]=temp;
		}
		else return;
	}
	
	
}
