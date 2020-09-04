package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class pos{
	int start,y,x,len;
	pos(int start,int y, int x, int len){
		this.start = start;
		this.len = len;
		this.y = y;
		this.x = x;
	}
}
public class SWEA_정사각형방{
	static int size;
	static int map[][];
	static int res=Integer.MIN_VALUE,ans=Integer.MAX_VALUE;
	static int dx[]= {0,0,1,-1};
	static int dy[]= {1,-1,0,0};
	static ArrayDeque<pos> dq = new ArrayDeque<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String args[]) throws Exception{
		
		int T = Integer.parseInt(br.readLine().trim());

		for(int test_case = 1; test_case <= T; test_case++){
			
			input();
			
			for(int y= 0 ; y <size; y++) {
				for(int x =0 ; x <size ; x++) {
					BFS(map[y][x] , y ,x); 
				}
			}
			System.out.println("#"+test_case+" "+ans+" "+res);
		}
	}

	public static void BFS(int start_val , int st_y, int st_x ) {
		dq.add(new pos(start_val,st_y,st_x,0));
		
		while(!dq.isEmpty()) {
			
			pos now = dq.poll();
			
			int nowx =now.x;
			int nowy =now.y;
			if(res <= now.len) {
				res = now.len;
			}
			
			for(int index = 0 ; index < 4 ;index++) {
				int nx = nowx + dx[index];
				int ny = nowy + dy[index];
				if(nx <size && ny < size && nx >=0 && ny>=0 && map[ny][nx]-1 == (map[nowy][nowx])) {
					dq.add(new pos(start_val , ny , nx , now.len+1));
				}
			}
		}
		
	}

	public static void input() throws Exception {
		StringTokenizer st =new StringTokenizer(br.readLine());
		size = Integer.parseInt(st.nextToken());
		for(int y= 0 ; y <size; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x =0 ; x <size ; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
	}
}