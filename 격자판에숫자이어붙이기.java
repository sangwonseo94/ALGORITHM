package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 격자판에숫자이어붙이기 {
	static public class name{
		
	}
	final static int answer= 0;
	static String map[][] = new String[4][4];
	static HashSet<String> HS = new HashSet<>();
	static int dir[][] = {{1,0},{-1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(st.nextToken());
		for(int tc = 1 ;tc <= t ; tc++) {
			
			for(int y = 0 ; y< 4 ; y++) {
				st = new StringTokenizer(br.readLine());
				for(int x= 0 ; x < 4 ; x++) {
					map[y][x] = st.nextToken();
				}
			}
			
			for(int y = 0 ; y < 4 ; y++) {
				for(int x = 0; x< 4 ; x++) {
					DFS(y,x,"");
				}
			}
			answer = HS.size();
			sb.append("#"+tc + " "+answer+"\n");
			answer = 0;
			HS.clear();
		}
		System.out.println(sb);
	
	}
	public static void DFS(int y, int x, String string) {
		if(string.length()==7) {
			HS.add(string);
			return;
		}
		else {
			for(int index = 0 ; index < 4;  index++) {
				int ny = y + dir[index][0];
				int nx = x + dir[index][1];
				if(ny >= 0 && nx >= 0  && ny< 4 && nx < 4) {
					System.out.println(string +" " + string.hashCode());
					DFS(ny,nx,string+map[ny][nx]);
				}
			}
		}
		
	}
}
