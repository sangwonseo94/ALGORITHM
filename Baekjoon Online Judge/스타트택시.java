package 풀문제2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 스타트택시 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int init = Integer.parseInt(st.nextToken());
		int map[][] = new int[n+1][n+1];
		int info[][] = new int[m][2];
		for(int i = 1 ; i <= n ; i ++) {
			st=  new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int sy =0  , sx = 0 ;
		st = new StringTokenizer(br.readLine());
		sy = Integer.parseInt(st.nextToken());
		sx = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i < m; i ++) {
			st = new StringTokenizer(br.readLine());
			
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = i+2;
			for(int j = 0 ;  j < 2; j ++) {
				info[i][j] = Integer.parseInt(st.nextToken());
				// 목적지 
			}
		}
		
		// end input 
		
		PriorityQueue<int [] > pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] > o2[0]) {
					return 1;
				} else if (o1[0] == o2[0]){
					 if(o1[1] > o2[1]) {
						 return 1;
					 } else if(o1[1] == o2[1]) {
						 return -1;
					 } else {
						 return 0;
					 }
				} else {
					return -1;
				}
			}
		});
		int visit[][] = new int[n+1][n+1];
		int time = 1;
		boolean used[] = new boolean[m+2];
		int isOn = 0;
		int targetY =0 , targetX =0;
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dq.add(new int[] {sy,sx,init,0});
		int dir[][] = {{1,0},{-1,0},{0,-1},{0,1}};
		visit[sy][sx] = time;
		int answer = 0,cnt=0;
		top :
		while(!dq.isEmpty()) {
			int size = dq.size();
			
			while(size>0) {
				int [] now = dq.poll();
				size--;
				if(isOn >0 && now[0] == targetY && now[1] == targetX) {
					System.out.println("도착" +now[0] + "x" + now[1]);
					System.out.println("연료 : "+now[2] + "거리" + now[3]);
					int oil = now[2];
					int len = now[3];
					
					if(oil-len < 0) {
						answer = -1;
						break top;
					} else {
						now[3] = 0;
						now[2] += (len);
					}
					// 기름계산 
					// dq초기화 다시시작
					// map 도 바꾸어야한다.
					int temp[] = {targetY ,targetX , now[2] , 0};
					dq.clear();
					dq.add(temp);
					used[isOn] = true;
					isOn = 0;
					cnt++;
					if(cnt == m) {
						answer = now[2];
						break top;
					}
					time++;
					
				}
				for(int i = 0 ; i < 4 ; i ++) {
					int ny = now[0] + dir[i][0];
					int nx = now[1] + dir[i][1];
					if( ny > 0 && nx > 0 && ny <=n && nx <=n && visit[ny][nx] < time) {
						if(map[ny][nx] == 0 ) {
							visit[ny][nx] = time;
							if ( isOn == 0) {
								dq.add(new int[] {ny,nx,now[2]-1,now[3]});
							} else {
								dq.add(new int[] {ny,nx,now[2],now[3]+1});
							}
						} else if(map[ny][nx] > 1 && isOn == 0 && !used[map[ny][nx]]) {
							//System.out.println(now[0] + " " + now[1]);
							visit[ny][nx] = time;
							pq.add(new int[]{ny,nx,now[2]-1,now[3]});
						} else if(isOn  > 0) {
							dq.add(new int[] {ny,nx,now[2],now[3]+1});
						}
					}
				}
					
			}
			// 손님 계산
			if(!pq.isEmpty()) {
				int [] client = pq.poll();
				pq.clear();
				isOn = map[client[0]][client[1]];
				System.out.println("손님 위치 " + client[0] + "x" + client[1]);
				System.out.println("연료 : " + client[2] + "주행거리 " + client[3]);
				
				used[isOn] = true;
				targetY = info[isOn-2][0];
				targetX = info[isOn-2][1];
				time++;
				int temp[] = {client[0] ,client[1] , client[2] , 0};
				dq.clear();
				dq.add(temp);
			}
		}System.out.println(answer = answer <=0 ? -1 : answer);
	}

}
