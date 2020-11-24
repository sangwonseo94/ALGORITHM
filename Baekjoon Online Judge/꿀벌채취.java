package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ²Ü¹úÃ¤Ãë {
	static int answer =0;
	static int start_x,start_y;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		int t = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <=t ; tc++) {
			st = new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int m= Integer.parseInt(st.nextToken());
			int c= Integer.parseInt(st.nextToken());
			int map[][] = new int[n][n];
			for(int y=0; y<n;y++) {
				st= new StringTokenizer(br.readLine());
				for(int x=0;x<n; x++) {
					map[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			for(int y = 0 ; y < n ; y++) {
				for(int x=0; x < n ; x++) {
					if(x+(m-1) >=n) continue;
					start_x =x;
					start_y =y;
					if(start_x+m <n) dfs(y,start_x+m);
					else dfs(y+1,0);
				}
			}
			sb.append("#"+tc+" "+answer+"\n");
			answer=0;
		}
		System.out.println(sb);
	}
	public static void dfs(int y,int x) {
		if() {
			
			return;
		}
		
		
		
	}

}
