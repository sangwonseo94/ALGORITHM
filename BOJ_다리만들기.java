package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class pos{
	
	int x,y;
	pos(int x,int y){
		this.x =x;
		this.y =y;
	}
}
class check{
	
	int x,y,m,len;
	check(int x,int y,int m , int len){
		this.x =x;
		this.y =y;
		this.m =m;
		this.len = len;
	}
}

public class asd {
	static int N;
	static int map[][];
	static int dx[]= {0 , 0 , -1, +1};
	static int dy[]= {1, -1, 0 ,0 };
	static int road_max = Integer.MAX_VALUE;
	public static void SplitMap() {
		int mark = 0;
		Deque<pos> dq = new ArrayDeque<pos>();
		boolean visit[][] = new boolean [N+1][N+1];
		for(int y=0 ; y < N ; y++) {
			for(int x=0; x< N ; x++) {
				if(map[y][x] == 1 && !visit[y][x]) {
					visit[y][x] = true;
					dq.add(new pos(x,y));
					mark++;
					map[y][x] = mark;
					while(!dq.isEmpty()) {
						
						pos now = dq.poll();
						
						for(int index = 0; index < 4; index++) {
							int nx  = now.x + dx[index];
							int ny =  now.y + dy[index];
							if(nx >= 0 && ny >= 0 && nx <N && ny <N && !visit[ny][nx] && map[ny][nx]==1) {
								visit[ny][nx] = true;
								map[ny][nx] = mark;
								dq.add(new pos(nx,ny));
							}
						}
						
					}
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) throws Exception {
		
		input();
		SplitMap();
		Bridge();
		System.out.println(road_max);
	}

	
	private static void Bridge() {
		
		for(int y = 0; y < N ; y++) {
			for(int x= 0 ; x< N ;x++) {
				if(map[y][x] !=0 && judge(y,x)  ) {
					boolean visit[][] = new boolean[N+1][N+1];
					Deque<check> dq = new ArrayDeque<check>();
					dq.add(new check(x,y,map[y][x],0));
					while(!dq.isEmpty()) {
						check now = dq.poll();
						if(now.m != map[now.y][now.x] && map[now.y][now.x] !=0) {
						road_max = Math.min(road_max, now.len);
						break;
						}
						for(int index = 0 ; index < 4 ; index++) {
							
							int ny = y + dy[index];
							int nx = x + dx[index];
							
							if(nx >= 0 && ny >= 0 && nx <N && ny <N) {
								if(map[ny][nx] == 0 && !visit[ny][nx]) {
									visit[ny][nx] = true;
									dq.add(new check(nx,ny,now.m,(now.len)+1));
								}
								
							}
						}
					}
				}
				
			}
		}
		
	}


	private static boolean judge(int y, int x) {
		for(int index = 0 ; index < 4 ;index++) {
			int ny = y + dy[index];
			int nx = x + dx[index];
			if(nx >= 0 && ny >= 0 && nx <N && ny <N) {
				if(map[ny][nx] != map[y][x]) {
					return true;
				}
			}
		}
		return false;
	}


	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		
		for(int y = 0 ; y < N ; y++) {
			String str_[] = br.readLine().split(" ");
			for(int x = 0 ; x < N ; x++) {
				map[y][x] = Integer.parseInt(str_[x]);
			}
		}
		
	}

}
