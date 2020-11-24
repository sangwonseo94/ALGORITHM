package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 아기상어 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int map[][] = new int[n][n];
		int sharky=0,sharkx=0;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					map[i][j]=0;
					sharky = i;
					sharkx =j ;
				}
			}
		}
		boolean isContinue = true;
		int visit[][] = new int[n][n];
		int step =1;
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		// dq y,x좌표 얼마나 걸린시간?
		PriorityQueue<int[]> pq= new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
			if(o1[2]==o2[2]) {
					// 같으면,
					if(o1[0]==o2[0]) {
						return o1[1]- o2[1];
					} else {
						return o1[0]- o2[0];
					}
				} else {
					return o1[2] - o2[2];
				}
			};
		});
		
		dq.add(new int[] {sharky , sharkx , 0});
		visit[sharky][sharkx] = step;
		
		int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
		int sharksize = 2;
		int sharkatecnt = 0;
		int answer = 0;
		while(isContinue) {
			isContinue = false;
			while(!dq.isEmpty()) {
				int size = dq.size();
				while(size-->0) {
					int []now = dq.poll();
					for(int i=0;i<4;i++) {
						int ny = now[0] + dir[i][0];
						int nx = now[1] + dir[i][1];
						if(ny>=0 && ny<n&&nx>=0 && nx<n) {
							if(visit[ny][nx] <step && map[ny][nx] <=sharksize) {
								visit[ny][nx] = step;
								dq.add(new int[] {ny,nx,now[2]+1});
								if(map[ny][nx]!=0 && sharksize > map[ny][nx]) {
									// 먹을 수 있는 경우 
									pq.add(new int[] {ny,nx,now[2]+1});
								}
							}
						}
					}
				}
			}
			
			
			if(pq.isEmpty()) {
				break;
			}
			int target[] = pq.poll();
			pq.clear();
			sharkatecnt++;
			if(sharkatecnt == sharksize) {
				sharksize++;
				sharkatecnt=0;
			}
			step++;
			sharky = target[0];
			sharkx = target[1];
			answer += target[2];
			map[sharky][sharkx] = 0;
			isContinue = true;
			dq.add(new int[] {sharky , sharkx,0});
		}
		System.out.println(answer);
		
	}

}
