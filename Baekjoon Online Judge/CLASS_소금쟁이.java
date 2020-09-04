package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CLASS_소금쟁이 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int testcase ;
	static int N ;
	static int insect;
	static boolean map[][];
	static boolean compute = false;
	
	public static void input() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new boolean[N][N];
		insect = Integer.parseInt(st.nextToken());
		for(int index = 1  ; index < insect ; index++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken());
			jump(y,x,direction , index);
			
		}
		
	}
	
	
	
	private static void jump(int y, int x, int direction , int insect_num) {
		
		if(direction == 1) {
			y +=3;
			if( y >= N) return;
		}
		else {
			x +=3;
			if( x >= N) return;
		}
		
		if(!map[y][x]) {
			map[y][x] = true;
			jump_two(y,x , insect_num);
		}
		else {
			System.out.println(insect_num);
		}
	}



private static void jump_two(int y, int x , int insect_num) {
		int dx[] = {0,2};
		int dy[] = {2,0};
		
		for(int index = 0 ; index < 2 ; index ++) {
			
			int ny =y + dy[index];
			int nx =x + dx[index];
			
			if(ny >= 0 && nx >= 0 && ny < N && nx < N) {
				
				if(map[ny][nx]) {
					System.out.println(insect_num);
				}
				else {
					map[ny][nx] = true;
					jump_one( ny, nx , insect_num);
				}
				
			}
			
		}
		
		
	}



	private static void jump_one(int y, int x, int insect_num) {
		int dx[] = {0,1};
		int dy[] = {1,0};
		
		for(int index = 0 ; index < 2 ; index ++) {
			
			int ny =y + dy[index];
			int nx =y + dx[index];
			
			if(ny >= 0 && nx >= 0 && ny < N && nx < N) {
				
				if(map[ny][nx]) {
					System.out.println(insect_num);
					return;
				}
				else {
					map[ny][nx] = true;
					
				}
				
			}
			
		}
		
	
}



	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		testcase = Integer.parseInt(st.nextToken());
		while(testcase > 0) {
			input();
			
			testcase--;
		}
	}

}
