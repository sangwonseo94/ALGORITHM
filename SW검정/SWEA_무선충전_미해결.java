package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_무선충전_미해결 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int dir[][] = {{0,0},{-1,0},{0,1},{1,0},{0,-1}}; // 0이 y 1이 x
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1 ; tc <=T ; tc++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken()); int A = Integer.parseInt(st.nextToken());	
			int map[][][] = new int[A+1][11][11];
			int A_Move[] = new int[M+1]; 
			int B_Move[] = new int[M+1]; 
			st = new StringTokenizer(br.readLine());
			for(int index = 1; index < 11; index++) A_Move[index] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int index = 1; index < 11; index++) B_Move[index] = Integer.parseInt(st.nextToken());
			for(int index = 1; index <=A ; index++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int power = Integer.parseInt(st.nextToken());
				map[index][y][x] = power;
				boolean visit[][]= new boolean[11][11];
				Cover_map(map[index],y,x,c,power,0,visit);
			}
			// A의 이동 결과
			int res_A[][] = new int[M+1][A+1];
			int res_B[][] = new int[M+1][A+1];
			// 맨 처음 0 번 위치 계산
			int x=0; int y=0;
			for(int a = 1; a< A+1; a++) {
				if(map[a][x][y] >0) {
					res_A[0][a] = map[a][x][y];
				}
			}
			
			for(int m = 1; m < M+1; m++) {
				y += (dir[A_Move[m]][0]);
				x += (dir[A_Move[m]][1]);
				for(int a = 1; a< A+1; a++) {
					if(map[a][y][x] >0) {
						res_A[m][a] = map[a][y][x];
					}
					else res_A[m][a] = 0;
				}
			}
			
			System.out.println("ge");
			
		}
		
	}
	public static void Cover_map(int map[][], int  y, int x, int c,int power,int depth,boolean visit[][]){
		if(depth==c)return;
		for(int j = 1; j <=4 ; j++) {
			int ny = y + dir[j][0];
			int nx = x + dir[j][1];
			if( ny < 11 && nx <11 && ny >=1 && nx >=1 && !visit[ny][nx]) {
				map[ny][nx] = power; visit[ny][nx] = true;
				Cover_map(map,  ny, nx, c, power,depth+1,visit);
				visit[ny][nx] = false;
			}
		}
	
	}

}
