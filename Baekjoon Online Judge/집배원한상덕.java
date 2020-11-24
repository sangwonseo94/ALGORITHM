package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 집배원한상덕 {
	public static int n ;
	public static char map[][];
	public static int visit[][] , h[][];
	public static int cnt =0 , step=0;
	public static int sy=0,sx=0;
	public static int[][] dir= {{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,1},{1,-1},{-1,-1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		map= new char[n][n];
		h  = new int[n][n];
		visit = new int[n][n];
		for(int i = 0 ; i < n ; i ++) {
			String str = br.readLine();
			for(int j=0; j<n ; j++) {
				map[i][j] = str.charAt(j);
				if( map[i][j] =='K') {
					cnt++;
				} else if(map[i][j]=='P') {
					sy= i; sx=j;
				}
			}
		}
		int max = -1;
		int min =987654321;
		for(int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j= 0 ;j < n ; j++) {
				h[i][j] = Integer.parseInt(st.nextToken());
				max = max > h[i][j] ? max:h[i][j];
				min = min > h[i][j] ? h[i][j] :min;
			}
		}
		max = max-min;
		min =0;
		int answer= 0;
		while(min < max) {
			int mid = ((min+max)>>1);
			if(bfs(mid)) {
				max = mid -1;
				answer = mid;
			} else {
				min = mid +1;
			}
		}
		System.out.println(answer);
	}
	private static boolean bfs(int mid) {
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		step++;
		int ccnt=0;
		int max = -1;
		int min = 987654321;
		dq.add(new int[] {sy,sx});
		visit[sy][sx] = step;
		while(!dq.isEmpty()) {
			int now[] = dq.poll();
			if(map[now[0]][now[1]]=='K') ccnt++;
			for(int i=0;i<8;i++) {
				int ny=now[0]+dir[i][0];
				int nx=now[1]+dir[i][1];
				if(ny>=0&&nx>=0&&ny<n&&nx<n&&visit[ny][nx]<step&&Math.abs(h[now[0]][now[1]]-h[ny][nx])<=mid) {
					visit[ny][nx] =step;
					max  = max > h[ny][nx] ? max : h[ny][nx];
					min = min > h[ny][nx] ? h[ny][nx] : min;
					dq.add(new int[] {ny,nx});
				}
			}
		}
		
		if(ccnt==cnt&&(max-min)<=mid)return true;
		return false;
	}
}

