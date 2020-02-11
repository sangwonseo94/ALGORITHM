package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class mover{int time;char dir;mover(int time,char dir){
		this.time = time;
		this.dir = dir;
	}}
class coordi{int y,x;coordi(int y,int x){
		this.y = y;
		this.x = x;}}

public class BOJ_뱀_미해결 {
	static int N,K,L;
	static int map[][];
	static boolean visit[][];
	static coordi pos[] = new coordi[100];
	static mover move[] = new mover[100];
	static int ans =0;
	static int mover_index =0;
	public static void input() throws Exception  {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	N = Integer.parseInt(st.nextToken());
	map = new int[N+1][N+1];
	st = new StringTokenizer(br.readLine());
	K = Integer.parseInt(st.nextToken()); 
	for(int index = 0 ; index < K ; index++){
		st = new StringTokenizer(br.readLine());
		map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]= 2; // 2는 사과
	}
	st = new StringTokenizer(br.readLine());
	L =Integer.parseInt(st.nextToken());
	for(int index = 0; index < L ; index++) {
		st=new StringTokenizer(br.readLine());
		move[index] = new mover(Integer.parseInt(st.nextToken()) , st.nextToken().charAt(0));
	}
	pos[0] = new coordi(1,1);
	}
	public static void main(String[] args) throws Exception {
		input();
		Sol();
		System.out.println(ans);
	}
	public static void Sol() {
		
		
		char direc= move[mover_index].dir;
		int go = move[mover_index].time;
		int x = pos[0].x;
		int y = pos[0].y;
		visit[y][x] = true;
		for(int index = 0 ; index < go; index++) {
			
			if(direc =='D') {
				int nx = (x+1);
				if(nx >= N) {// 뱀이 맵을 나갈경우
					return;}
				if(visit[y][nx]) {
					//뱀이 자신의 꼬리와 부딫혔을 경우
					return;}
				if(map[y][nx] == 2){ //뱀이 사과를 먹을경우 현재 좌표를 좌표 배열에 꼬리에 넣어준다.
					pos[pos.length] = new coordi(y,nx);
					visit[y][nx]= true;}
				if(map[y][nx] == 0) {
					// 사과를 안먹고 이동할 경우 현재좌표를 false처리 가려고하는 방향을 현재 좌표 자리에 넣어줌
					pos[0] = new coordi(y,nx);
					visit[y][x] = false;}
				x =nx; // x좌표 업데이트
			}
			else {
				int ny = (y+1);
				if(ny >= N) {// 뱀이 맵을 나갈경우
					return;}
				if(visit[y][nx]) {
					//뱀이 자신의 꼬리와 부딫혔을 경우
					return;
				}
				if(map[y][nx] == 2){ //뱀이 사과를 먹을경우 현재 좌표를 좌표 배열에 꼬리에 넣어준다.
					pos[pos.length] = new coordi(y,nx);
					visit[y][nx]= true;
				}
				if(map[y][nx] == 0) {
					// 사과를 안먹고 이동할 경우 현재좌표를 false처리 가려고하는 방향을 현재 좌표 자리에 넣어줌
					pos[0] = new coordi(y,nx);
					visit[y][x] = false;
				}
				x =nx; // x좌표 업데이트
				
			}
			
		}
		
	}
	

}
