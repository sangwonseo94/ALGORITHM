package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 냄새싫어 {

	public static class node{
		int y,x,index;

		public node(int y, int x, int index) {
			super();
			this.y = y;
			this.x = x;
			this.index = index;
		}
		
	}
	public static class position{
		int y,x;

		public position(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
	public static int dist(int x1, int x2 , int y1 , int y2) {
		return (x2-x1)*(x2-x1)+(y1-y2)*(y1-y2);
	}
	public static int wx,wy,sx,sy,ex,ey,n,x,y,ny,nx;
	public static int map[][];
	public static boolean visit[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 wx = Integer.parseInt(st.nextToken());
		 wy = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		 sx = Integer.parseInt(st.nextToken())-1;
		 sy = Integer.parseInt(st.nextToken())-1;
		 ex = Integer.parseInt(st.nextToken())-1;
		 ey = Integer.parseInt(st.nextToken())-1;
		st = new StringTokenizer(br.readLine());
		 n = Integer.parseInt(st.nextToken());
		 position pos[] = new position[n];
		 map = new int[wy][wx];
		ArrayDeque<node> dq = new ArrayDeque<>();
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			 x = Integer.parseInt(st.nextToken())-1;
			 y = Integer.parseInt(st.nextToken())-1;
			 pos[i] = new position(y, x);
		
			dq.add(new node(y,x,i));
		}
		for(int i = 0 ; i < wy ; i ++) {
			for(int j = 0 ; j <wx ; j++) {
				map[i][j] = 2147000000;
			}
		}
		int dir[][] = {{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{1,1},{-1,-1}};
		while(!dq.isEmpty()) {
			node now = dq.poll();
			if(map[now.y][now.x] < dist(now.x , pos[now.index].x, now.y, pos[now.index].y)) {
				continue;
			}
			map[now.y][now.x] = dist(now.x , pos[now.index].x, now.y, pos[now.index].y);
			for(int i = 0 ; i < 8 ; i ++) {
				 ny = dir[i][0] + now.y;
				 nx = dir[i][1] + now.x;
				if(ny >=0 && nx >= 0 && ny < wy && nx < wx) {
					if(map[ny][nx] <= dist(nx ,pos[now.index].x, ny, pos[now.index].y)) {
						continue;
					}
					map[ny][nx] = dist(nx , pos[now.index].x, ny, pos[now.index].y);
					dq.add(new node(ny,nx,now.index));
				}
			}
		}
		
		PriorityQueue<node> pq = new PriorityQueue<>(new Comparator<node>() {
			@Override
			public int compare(node o1, node o2) {
				return o2.index - o1.index;
			}
		});
		visit= new boolean[wy][wx];
		visit[sy][sx] = true;
		pq.add(new node(sy,sx,map[sy][sx]));
		while(!pq.isEmpty()) {
			node now = pq.poll();
			if(now.y==ey&&now.x==ex) {
				System.out.print(now.index);
				break;
			} for(int i = 0 ; i < 4 ; i ++) {
				 ny = dir[i][0] + now.y;
				 nx = dir[i][1] + now.x;
				if(ny>=0&& nx>=0&& ny < wy&&nx<wx &&!visit[ny][nx]) {
					visit[ny][nx] = true;
					pq.add(new node(ny,nx,Math.min(now.index, map[ny][nx])));
				}
			}
		}
	}
}
