package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 맥주마시면서걸어가기 {

	public static int n,ex,ey;
	public static int cov[][];
	public static boolean visit[];
	public static String answer ="sad";
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(st.nextToken());
		for(int i = 0 ; i < t ;  i++) {
			st = new  StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			cov = new int[n][2];
			visit = new boolean[n];
			for(int j= 0; j < n ; j++) {
				st = new StringTokenizer(br.readLine());
				cov[j][0] = Integer.parseInt(st.nextToken());
				cov[j][1] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			 ex = Integer.parseInt(st.nextToken());
			 ey = Integer.parseInt(st.nextToken());
			 DFS(sx,sy);
			 sb.append(answer+"\n");
			 answer ="sad";
		}
		System.out.print(sb);
	}

	private static void DFS(int sx, int sy) {
		if(dist(sx,ex,sy,ey)) {
			answer ="happy";
			return ;
		}
		for(int i=0 ; i < n ; i ++) {
			int nx = cov[i][0];
			int ny = cov[i][1];
			if(dist(sx,nx,sy,ny) && !visit[i]) {
				visit[i] = true;
				DFS(nx,ny);
			}
		}
	}

	private static boolean dist(int sx, int ex2, int sy, int ey2) {
		return ( Math.abs(ex2-sx) + Math.abs(ey2-sy) ) <= 1000 ;
	}
}
