package 풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 러시아국기같은 {
	static int n,m;
	static int color[] = new int[3];
	static char colorinfo[] = {'W','B','R'};
	static char[][] map;
	static int ans = 987654321;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for(int tc= 1 ; tc<= T ;tc++) {
			st = new StringTokenizer(br.readLine());
			 n = Integer.parseInt(st.nextToken());
			 m = Integer.parseInt(st.nextToken());
			 map= new char[n][m];
			 for(int index = 0 ; index < n ; index++) {
				 map[index] = br.readLine().toCharArray();
			}
			
			for(int x =1 ; x <= n ; x++) {
				for(int y = 1 ; y <= n ; y++) {
					for(int z =1 ; z <= n ; z++) {
						if(x+y+z == n) {
							color[0] = x;
							color[1] = y;
							color[2] = z;
							dfs(0,0,0);
							
						}
					}
				}
			}
			System.out.println("#"+tc+" "+ans);
			ans =987654321;
		}

	}
	private static void dfs(int index, int res , int depth) {
		if(res > ans) return;
		if(depth ==3) {
			ans = res;
			return;
		}
		
		for(int i = index ; i < index+color[depth] ; i ++) {
			for(int j = 0 ; j < m ; j ++) {
				if(map[i][j] != colorinfo[depth]) {
					res++;
				}
			}
		}
		dfs(index+color[depth],res,depth+1);
		
	}

}
