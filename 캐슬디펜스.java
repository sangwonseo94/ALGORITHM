package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 캐슬디펜스 {
	static int N,M,D;
	static int map[][] = new int[20][20];
	static int copy_map[][] = new int[20][20];
	static boolean visit[][]= new boolean[20][20];
	static int answer = Integer.MIN_VALUE;
	public static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		for(int y = 1 ; y <=N ; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x= 1 ; x <=M ; x++) {
				map[y][x]=Integer.parseInt(st.nextToken());
			}
		}
	}
	public static int pos_compute(int x1, int y1, int x2, int y2) {
		return Math.abs(x1-x2) + Math.abs(y1-y2);
	}
	
	
	public static void main(String[] args) throws Exception {
		input();
		// M개 중에 3개를 선택합니다.
		int archer[] = new int[M];
		for(int index = 7 , size = (1<<M) ; index < size ; index++) {
			int cnt =0;
			for(int j = 0 ; j < M; j++) {
				if((index & (1<<j)) !=0) {
					cnt++;
					archer[j] = 1;
				}
				else archer[j] = 0;
			}
			if(cnt ==3) {
				for(int i = 1; i <=M ; i++) copy_map[N+1][i] = archer[i-1];
				copy();
				answer = Math.max(answer, Compute());
			}
		}
		System.out.println(answer);
	}
	
	public static void copy() {
		for(int y = 1 ; y <=N ; y++) {
			for(int x = 1;  x<=M ; x++) {
				copy_map[y][x] = map[y][x];
			}
		}
	}
	public static int Compute() {
		int res =0;
		int bound =N-(D-1);
		while(check()) {
			for(int i = 1 ; i <=M ;i ++) {
		
				if(copy_map[N+1][i]==1) {
					int min_ = Integer.MAX_VALUE;
					int minlocal_x =M+1, minlocal_y =0 , len;
					if(bound < 0 ) bound =1;
					for(int y = N ; y >= bound ; y --) {
						for(int x = 1 ; x <= M ; x++) {
							if(copy_map[y][x] == 1) {
								len =pos_compute(i, N+1, x, y);
								if(len <= D) {
									if(min_ > len) {
											min_ = len;
											minlocal_x = x;
											minlocal_y = y; 		
									
									}
									else if(min_ == len) {
										if(minlocal_x > x) {
											minlocal_x = x;
											minlocal_y = y; 
										}
									}
								}
							}
						}			
					}
					visit[minlocal_y][minlocal_x] = true;
				}
			}
			for(int y = N ; y >= bound ; y --) {
					for(int index = 1 ; index <=M ; index++) {
						if(visit[y][index]){
							visit[y][index] = false;
							copy_map[y][index] = 0;
							res++;
					} 
				}
			}
			// 한줄씩 내려오고 처리를 해준다. 방문배열하고 , Map배열을 한칸씩 내려 준다.
			
			for(int y  = N ; y > 1 ; y--) {
				for(int x = 1 ; x <= M ; x++) {
					copy_map[y][x] = copy_map[y-1][x];
					visit[y][x] = visit[y-1][x];
				}
			}
			for(int index = 1 ; index <=M ; index++) copy_map[1][index] = 0;
		}
		return res;
	}
	public static boolean check() {
		for(int y = 1 ; y  <= N ; y++) {
			for(int x = 1 ; x <=M ; x++) {
				if(copy_map[y][x] ==1) return true;
			}
		}
		return false;
	}

}
