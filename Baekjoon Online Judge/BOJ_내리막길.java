package 푼문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_�������� {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
		int map[][] = new int[n][m];
		int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
		PriorityQueue<int[]> pq = new PriorityQueue<>(n*m,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] < o2[1]) return 1;
				else return 0;
			}
		});
 		
		for(int y = 0 ; y < n ; y++){
			st = new StringTokenizer(br.readLine());
			for(int x = 0 ; x < m ; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		pq.add(new int[] {0,map[0][0]});
		int ans[][] = new int[n][m];
		boolean visit[][] = new boolean[n][m];
		
		ans[0][0] = 1  ; visit[0][0] = true;
		while(!pq.isEmpty()){
			
			int now[] = pq.poll();
			int x = now[0] % m;
			int y = now[0] / m;
			for(int index = 0 ;index < 4 ; index++) {
				int ny = y + dir[index][0];
				int nx = x + dir[index][1];
				
				if( ny >=0 && nx >=0 && ny< n && nx < m) {
					if(now[1] > map[ny][nx]) {
						ans[ny][nx] +=ans[y][x];
						if(!visit[ny][nx]) {
							visit[ny][nx] = true;
							pq.add(new int[] {ny*m+nx ,map[ny][nx]});
						}
						
					}		
				}
			}
		}
		System.out.println(ans[n-1][m-1]);
	}

}
