package 풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class ladder2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb= new StringBuilder();
		int map[][] = new int[100][100];
		int answer =Integer.MAX_VALUE , res = -1;
		ArrayDeque<int []> dq = new ArrayDeque<>();
		for(int tc=1;tc<=10;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			for(int y = 0 ; y < 100 ; y++) {
				st= new StringTokenizer(br.readLine());
				for(int x= 0 ; x< 100;x++) {
					map[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			for(int x = 0 ; x < 100 ; x++) {
				if(map[0][x] == 1) {
					boolean visit[][] = new boolean[100][100];
					dq.add(new int[] {0,x,1});
					visit[0][x] = true;
					while(!dq.isEmpty()) {
						
						int now[] = dq.poll();
						
						if(now[0]==99) {
							if(answer >= now[2]) {
								answer = now[2];
								res = x;
							}
							break;
						}
						if((now[1]+1 < 100 && now[1]-1 >=0) && map[now[0]][now[1]+1] == 0 && map[now[0]][now[1]-1] == 0) {
								visit[now[0]+1][now[1]] = true;
								dq.add(new int[] {now[0]+1 , now[1],now[2]+1});
						}
						else {
							if(now[1]-1 >=0  && map[now[0]][now[1]-1] == 1 && !visit[now[0]][now[1]-1]) {
									visit[now[0]][now[1]-1] = true;
									dq.add(new int[] {now[0] , now[1]-1,now[2]+1});
							}
							if( now[1]+1 <100  &&  map[now[0]][now[1]+1] ==1 && !visit[now[0]][now[1]+1]){
									visit[now[0]][now[1]+1] = true;
									dq.add(new int[] {now[0] , now[1]+1,now[2]+1});
							}
						}
							
					}
					answer =Integer.MAX_VALUE ;
					dq.clear();
				}
				
			}
			System.out.println("#"+tc+" "+res);
			res = -1;
		}
	}

}
