package 푼문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_나무재테크 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int Nutri_map[][] = new int[n+1][n+1];
		int Robot_map[][] = new int[n+1][n+1];
		int dirx[] = {1,1,-1,-1,0,0,-1,1};
		int diry[] = {1,-1,1,-1,1,-1,0,0};
		
		PriorityQueue<int []> pq = new PriorityQueue<>( new Comparator<int []>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] > o2[0]) return 1;
				else return -1;
			}
		});

		ArrayDeque<int []> dq = new ArrayDeque<>();
		ArrayDeque<int []> dead = new ArrayDeque<>();
		
		for(int y= 1 ; y <= n ; y ++) {
			st = new StringTokenizer(br.readLine());
			for(int x= 1 ; x <= n ; x++) {
				Robot_map[y][x] = Integer.parseInt(st.nextToken());
				Nutri_map[y][x] = 5;
			}
		}
		for(int i = 0 ; i < m ; i ++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			pq.add(new int[] {age,x,y});
		}
		
		for(int year = 1 ; year <= k ; year++) {
			// 봄
			while(!pq.isEmpty()) {
				int now[] = pq.poll();
				int age = now[0];
				int y = now[1] , x = now[2];
				if(Nutri_map[y][x] < age) {
					dead.add(new int[] {age, y,x});
					continue;
				}
				Nutri_map[y][x] -= age;
				dq.add(new int[] {age+1,y,x});
			}
			// 여름
			while(!dead.isEmpty()) {
				int now[] = dead.poll();
				Nutri_map[now[1]][now[2]] += (now[0]/2);
			}
			// 가을
			while(!dq.isEmpty()) {
				int now[] = dq.poll();
				int y = now[1] , x = now[2];
				int age = now[0];
				if( (age % 5) ==0) {
					for(int index = 0 ; index < 8 ; index++) {
						int ny= y + diry[index];
						int nx= x + dirx[index];
						if(ny >= 1 && nx>=1 && ny <= n && nx <= n) {
							pq.add(new int[] {1,ny,nx});
						}
					}
				}
				pq.add(new int[]{age,y,x});
			}
			
			// 겨울
			for(int y = 1 ; y <= n ; y++) {
				for(int x = 1 ; x<= n ; x++) {
					Nutri_map[y][x] += Robot_map[y][x];
				}
			}
		}
		System.out.print(pq.size());
	}
}
