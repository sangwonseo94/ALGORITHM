package 풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 미네랄 {
	static char map[][] ; 
	static int r,c,ny,nx,nowx,nowy,arrow[];
	static int dy[] = {0,0,-1,1} ,dx[] = {-1,1,0,0};
	static ArrayDeque<int []> dq = new ArrayDeque<>();
	static boolean visit[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c= Integer.parseInt(st.nextToken());
		map= new char[r][c];
		for(int y= 0 ; y < r ; y++) map[y] = br.readLine().toCharArray();
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		arrow = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int index= 0 ; index < n ; index++) {arrow[index] = r-(Integer.parseInt(st.nextToken()));}
		
		
		for(int index= 0 ; index < n ; index++) {
			int row = arrow[index]; int i;
			if(index % 2 == 0) {
				for( i = 0 ; i < c ; i ++) {
					if(map[row][i] =='x') {
						map[row][i] ='.';break;
						}
					}
				}
			else {
				for( i = c-1 ; i >=0 ; i --) {
					if(map[row][i] =='x') {
						map[row][i] ='.';break;
						}
					}
				}
			
			if((index%2==0 && i ==c) || (index%2==1 && i == -1)) continue;	// 맵에 변화가 없음
			
			visit = new boolean[r][c];
			
			spread();
			down();
		}	
		
		
		
		// 답 출력
		for(int y = 0 ; y < r ; y++) {
			for(int x= 0 ; x< c ; x++) {
				System.out.print(map[y][x]);
			}
			System.out.println();
		}
	}

	private static void spread() {
		// 미네랄이 한개 깨진 맵
		// 클러스터가 나뉘어져 공중에 떠있는것을 확인하기 위해서 바닥 R-1 행만 BFS를 돌려본다
		// 이와 연결되어있지 않다면, 공중에 떠있는것
		for(int x  = 0 ; x < c ; x++) {
			if(!visit[r-1][x] && map[r-1][x] =='x') {
				visit[r-1][x] = true;
				dq.add(new int[] { r-1,x});
				while(!dq.isEmpty()) {
					int now[] = dq.poll();
					nowx = now[1]; nowy = now[0];
					for(int j= 0 ; j< 4 ; j++) {
						ny = nowy + dy[j];
						nx = nowx + dx[j];
						if(ny >= 0 && nx >= 0 && ny < r && nx < c) {
							if(map[ny][nx]=='x' && !visit[ny][nx]) {
								visit[ny][nx] = true;
								dq.add(new int[] {ny,nx});
							}
						}
					}
				}
			}
		}
		
	}

	private static void down() {
		// 공중에 떠있는 미네랄은 MAP값이 X이고 방문처리가 되지않았을것
		// BOOL 변수 2개를 사용해 계속내릴것인지 그만내릴것인지 판별한다.
		// connect = 공중에 클러스터가 떠있는지를 표시하는변수
		// conti = 공중의 클러스터가 내려오면서 기존에 땅과 연결된 클러스터랑 만났는지 여부
		boolean connect = true , conti = false;
		while(connect) {
			connect = false;
			for(int y = r-1 ; y >= 0 ; y--) {
				for(int x= c-1 ; x >= 0 ; x--) {
					if(map[y][x] =='x' && !visit[y][x]) {
						connect = true;
						// 내릴 대상들
						map[y+1][x] = map[y][x]; map[y][x] ='.';
						if((y+1 == r-1) ||(map[y+2][x] == 'x' && visit[y+2][x])) {
							conti =true;
						}
					}
				}
			}
			if(conti) connect = false;
		}
	}
}
