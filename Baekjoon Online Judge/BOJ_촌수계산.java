package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class node{
	int no;
	int depth;
	node(int no, int depth){
		this.no = no;
		this.depth = depth;
	}
}
public class �̼���� {
	static int map[][] = new int[101][101];
	static boolean visit[]= new boolean[101];
	public static void main(String[] args) throws Exception {
		int ans = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n  = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int m =  Integer.parseInt(st.nextToken());
		while(m >0) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			map[y][x] = 1;
			map[x][y] = 1;
			m--;
		}
		if(start == end) System.out.println(0);
		else {
			Deque<node> dq = new ArrayDeque<node>();
			dq.add(new node(start,0));
			visit[start] = true; 
			while(!dq.isEmpty()) {
				node now = dq.poll();
				if(now.no == end) {
					ans = now.depth;
					break;
				}
				for(int index = 0; index < n +1 ; index++) {
					if(map[now.no][index]==0) continue;
					if(map[now.no][index]==1 && !visit[index]) {
						visit[index] = true; 
						dq.add(new node(index,now.depth+1));
					}
				}
				
				
			}
			if(ans ==0) System.out.println(-1);
			else System.out.println(ans);
		}
	}

}
