package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
class position{
	int y,x,len;
	boolean success;
	position(int y, int x, int len , boolean success){
		this.y = y;
		this.x = x;
		this.len = len;
		this.success = success;
		}
}
public class ±∏ΩΩ≈ª√‚2 {
	static int N,M;
	static char map[][];
	static int red_x,red_y,blue_x,blue_y;
	static int answer=0;
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static boolean suc_r , suc_b;
	public static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for(int y = 0 ; y <N ;y++) {
			st = new StringTokenizer(br.readLine());
			char list_[] = st.nextToken().toCharArray();
			for(int x= 0 ; x < N; x++) {
				map[y][x] = list_[x];
				if(map[y][x] =='B') {
					blue_x =x;
					blue_y =y;
 				}
				if(map[y][x] =='R') {
					red_x = x;
					red_y = y;
				}
			}
		}
		
	}
	public static void main(String[] args) throws Exception{
		input();
		BFS();
		if((suc_r && suc_b) || answer > 10) System.out.println(-1);
		else System.out.println(answer);
	}
	public static void BFS() {
		ArrayDeque<position> dq = new ArrayDeque<>();
		dq.add(new position(red_y,red_x,0,false));
		dq.add(new position(blue_y,blue_x,0,false));
		
		while(!dq.isEmpty()) {
			
			position now_r = dq.poll();
			position now_b = dq.poll();
			
			for(int index = 0; index <4 ; index++) {
				if(now_r.success && now_b.success) {
					answer = -1;
					break;
				} 
				if(now_r.success) {
					answer = Math.min(answer, now_r.len);
					break;
				}
				if(now_b.success) {
					answer = -1;
					break;
				} 
				int red_ny = now_r.y;
				int red_nx = now_r.x;
				int blue_ny = now_b.y;
				int blue_nx = now_b.x;
				if(now_r.len >=10) return;
				while(true) {
					// red ¡¬«• ¿Ãµø
					red_ny +=dy[index];
					red_nx +=dx[index];
					if(map[red_ny][red_nx]=='.') continue;
					if(map[red_ny][red_nx]=='O') {
						now_r.success = true;
						break;
					}
					if(map[red_ny][red_nx]=='#'|| map[red_ny][red_nx]=='B') {
						red_ny -=dy[index]; red_nx -=dx[index];
						break;
					}
				}
				while(true) {
					blue_ny +=dy[index];
					blue_nx +=dx[index];
					if(map[blue_ny][blue_nx]=='.') continue;
					if(map[blue_ny][blue_nx]=='O') {
						now_b.success =true;
						break;
					}
					if(map[blue_ny][blue_nx]=='#' || map[blue_ny][blue_nx]=='R') {
						blue_ny -=dy[index]; blue_nx -=dx[index];
						break;
					}
				}
				
				if(red_ny != now_r.y || red_nx != now_r.x || blue_ny != now_b.y || now_b.x != blue_nx) {
					dq.add(new position (red_ny , red_nx , now_r.len+1 , now_r.success));
					dq.add(new position (blue_ny , blue_nx , now_b.len+1,now_b.success));
				}
			}
		}
	}
}
