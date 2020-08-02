package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 스타트택시 {
	public static class node{
		int y, x ,f;

		public node(int y, int x, int f) {
			super();
			this.y = y;
			this.x = x;
			this.f = f;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		int map[][] = new int[n+1][n+1];
		int humenposition[][] = new int[n+1][n+1];
		int humen[][] = new int[m+1][4];
		for(int i = 1; i <= n; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ;j <= n; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		int starty = Integer.parseInt(st.nextToken());
		int startx = Integer.parseInt(st.nextToken());
		for(int i = 0 ; i < m ; i ++) {
			st= new StringTokenizer(br.readLine());
			for(int j = 0 ; j <4 ; j ++) {
				humen[i][j] = Integer.parseInt(st.nextToken());
			}
			humenposition[humen[i][0]][humen[i][1]] = i+1;
		}
		// end input
		ArrayDeque<node> dq = new ArrayDeque<>();
		PriorityQueue<int []> pq = new PriorityQueue<int[]>( new Comparator<int []>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] < o2[0]) {
					return -1;
				} else if(o1[0] > o2[0]) {
					return 1;
				} else {
					if(o1[1] > o2[1]) {
						return 1;
					} else if(o1[1] < o2[1]){
						return -1;
					} else {
						return 0;
					}
				}
			}
		});
		int dir[][] = {{1,0},{-1,0},{0,-1},{0,1}};
		int visit[][] = new int[n+1][n+1];
		int cnt =1;
		boolean impossible = false;
		dq.add(new node(starty , startx, f)); // 시작지점
		int end = 0;
		top :
		while(true) {
			if(cnt !=1) cnt++;
			// pq에 하나 들어갈 때까지 반복
			while(pq.isEmpty()) {
				int size = dq.size();
				if(size == 0) {
					impossible = true;
					break;
				}
				while(size >0) {
					size--;
					node now = dq.poll();
					int nowy = now.y;
					int nowx = now.x;
					int nowf = now.f;
					if(humenposition[nowy][nowx] !=0 ) {
						pq.add(new int[] {nowy,nowx,humenposition[nowy][nowx],nowf});
					}  
					for(int i = 0 ; i < 4 ; i ++) {
						int ny = nowy+dir[i][0];
						int nx = nowx+dir[i][1];
						if(ny > 0 && nx > 0 && ny <= n && nx <= n) {
							if(map[ny][nx] != 1 && visit[ny][nx] != cnt) {
								visit[ny][nx] = cnt;
								dq.add(new node(ny, nx, nowf-1));
							} else if(nowf < 0) {
								impossible = true;
								break top;
							}
						}
					}
				}
			}
			if(impossible) {
				break;
			}
			cnt++;
			int [] now = pq.poll();
			pq.clear();
			dq.clear();
			
			int sstarty = now[0];
			int sstartx = now[1];
			int endy = humen[now[2]-1][2];
			int endx = humen[now[2]-1][3];
			f = now[3];
			visit[sstarty][sstartx] = cnt;
			dq.add(new node(sstarty , sstartx, 0));
			tip :
			while(!dq.isEmpty()) {
				node nnow = dq.poll();
					for(int i = 0 ; i < 4 ; i++) {
						int ny = nnow.y + dir[i][0];
						int nx = nnow.x + dir[i][1];
						if(ny > 0 && nx >0 && ny<= n && nx<=n) {
							if(map[ny][nx] != 1 && visit[ny][nx] != cnt) {
								visit[ny][nx] = cnt;
								dq.add(new node(ny,nx,nnow.f+1));
							}
							if(ny == endy && nx == endx && f-(nnow.f+1) >=0) {
								f +=(nnow.f+1);
								humenposition[sstarty][sstartx] =0;
								end++;
								break tip;
							} 
						}
					}
			}
			if(end == m) {
				break;
			} else if(f==now[3]) {
				impossible = true;
				break;
			} else if(end < m) {
				dq.clear();
				visit[endy][endx] = cnt+1;
				dq.add(new node(endy, endx , f));
			}
			
		}	
		System.out.println(  impossible ? -1 : f  );
	}
}
