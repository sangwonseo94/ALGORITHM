package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_벽돌깨기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N,W,H;
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0}; // 상하좌우
	static int answer = 0, res = Integer.MAX_VALUE;
	static int map[][] ;
	static ArrayList<Integer> al = new ArrayList<>();
	static class pos{
		int y,x;
		public pos(int y, int x) {
			this.y =y ;
			this.x = x;
			// TODO Auto-generated constructor stub
		}
	}
	
	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine()); int T= Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1 ; tc<= T ; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); 
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map= new int[H][W];
			for(int j = 0 ; j < H ; j++) {
				st = new StringTokenizer(br.readLine());
				for(int i = 0 ; i < W ;i++) {
					map[j][i] = Integer.parseInt(st.nextToken());
				}
			}
			Dfs();
			sb.append("#"+tc+" "+res+"\n");
			res = Integer.MAX_VALUE;
		}
		System.out.println(sb);
	}
	
	public static void Dfs() {
		if(al.size() == N) {
			Bfs(al);
			return;
		}
		for(int n = 0 ; n < W ; n++) {
			al.add(n);
			Dfs();
			al.remove(al.size()-1);
		}	
	}
	public static void Bfs(ArrayList<Integer> al){
		int Copy_map[][] = new int[H][W];
		boolean Copy_map_Visit[][] = new boolean[H][W];
		DeepCopy(Copy_map,Copy_map_Visit);
		
		for(int index =0 ; index < al.size() ; index++){
			int first_x =al.get(index),first_y=0;
			for(first_y=0 ; first_y < H ; first_y++) {
				if(Copy_map[first_y][first_x] !=0)break;
			}
			if(first_y == H)break;
			ArrayDeque<pos> dq = new ArrayDeque<pos>();
			dq.add(new pos(first_y,first_x));
			while(!dq.isEmpty()){
				pos now = dq.poll();
				int y = now.y; int x= now.x;
				int Coverage = Copy_map[y][x];
				for(int i =0 ;i <4 ;i ++) {
					for(int c =0; c<Coverage;c++) {
						int ny = y+dy[i]*c;
						int nx = x+dx[i]*c;
						if(ny < H && nx <W && ny >=0 && nx>=0 && Copy_map[ny][nx] !=0 && !Copy_map_Visit[ny][nx]){
							Copy_map_Visit[ny][nx] = true;
							dq.add(new pos(ny,nx));
						}
					}
				}
			}
			// 큐가 끝나면 Copy_map_visit에 true로 된곳을 없애준다.
			for(int y = 0 ; y < H ; y++){
				for(int x=0 ; x< W ;x++) {
					if(Copy_map_Visit[y][x]) {
						Copy_map[y][x] =0;
					}
					Copy_map_Visit[y][x] =false; // visit 초기화
				}
			}
			// 내려준다.
			for(int x = 0; x < W ; x++) {
				int k = H -1;
				for(int y = H-1 ; y >=0 ; y--) {
					if(Copy_map[y][x]!=0) {
						Copy_map[k][x] = Copy_map[y][x];
						k--;
					}
				}
				for( ; k >=0; k--) Copy_map[k][x] =0;
			}
			
		}
		for(int y = 0 ; y < H ; y++){
			for(int x=0 ; x< W ;x++) {
				if(Copy_map[y][x] !=0) {
				  answer +=1;
				}
			}
		}
		res = Math.min(res ,answer);
		answer =0;
		
	}

	public static void DeepCopy(int[][] copy_map, boolean[][] copy_map_Visit) {
		for(int y = 0 ; y < H ; y++) {
			for(int x=0 ; x< W ;x++) {
				copy_map[y][x] = map[y][x];
				copy_map_Visit[y][x] = false;
			}
		}
	}
	
}
