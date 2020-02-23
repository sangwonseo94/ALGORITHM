package practice;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2048 {
	static int answer = 0,N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int map[][] = new int[N+1][N+1];
		for(int y =1 ; y <=N ;y++) {
			st = new StringTokenizer(br.readLine());
			for(int x= 1; x<= N ; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		DFS(map,0);
		System.out.println(answer);
	}
	public static void DFS(int[][] map, int depth) {
		if(depth == 5) {
			for(int y = 1 ; y <= N ; y++) {
				for(int x = 1; x <=N ; x++) {
					answer = answer > map[y][x] ? answer : map[y][x];
				}
			}
			return;
		}
		for(int index = 0 ; index < 4 ;index++) {
			
			int copy_map[][] = Move(map,index);
			DFS(copy_map,depth+1);
		}
	}
	public static int[][] Move(int[][] map, int dir) {
		int copy[][] = new int[N+1][N+1];
		for(int index = 1 ; index <=N; index++) {
			copy[index] = Arrays.copyOfRange(map[index], 0, N+1);
		}
		if(dir ==0) { // copy를 왼쪽으로 민경우
			for(int  y = 1 ; y<= N ; y++) {
				int arr[] = new int[N+1]; int index= 0; boolean visit[] = new boolean[N+1];// index는 뭐가 들어있는 위치
				for(int x = 1 ; x<=N ; x++) {
					if(copy[y][x]==0) continue;
					else {
						if(index == 0) {
							arr[index+1] = copy[y][x];
							index++; // 0번째에 뭐가 들어있음
						}
						else {
							if(arr[index] == copy[y][x] && !visit[index]) {
								//같은경우 index는 증가시키지 말고 누적해준다.
								arr[index] += copy[y][x];
								visit[index] = true;
							}
							else {
								arr[index+1] = copy[y][x];
								index++;
							}
						}
					}
				}
				copy[y] = Arrays.copyOf(arr, N+1);
			}
			return copy; //완료
		}
		else if(dir ==1) { // 오른쪽으로 민 경우
			for(int  y = 1 ; y<= N ; y++) {
				int arr[] = new int[N+1]; int index= N+1; boolean visit[] = new boolean[N+1];// index는 뭐가 들어있는 위치
				
				for(int x = N ; x >=1 ; x--) {
					
					if(copy[y][x]==0) continue;
					
					else {
						if(index == N+1) {
							arr[index-1] = copy[y][x];
							index--; // 0번째에 뭐가 들어있음
						}
						else {
							if(arr[index] == copy[y][x] && !visit[index]) {
								//같은경우 index는 증가시키지 말고 누적해준다.
								arr[index] += copy[y][x];
								visit[index] = true;
							}
							else {
								arr[index-1] = copy[y][x];
								index--;
							}
						}
					}
				}
				copy[y] = Arrays.copyOf(arr, N+1);
			}
			return copy;
		}
		else if(dir ==2) { // 아래로 민 경우
			for(int  x = 1 ; x<= N ; x++) {
				int arr[] = new int[N+1]; int index= N+1; boolean visit[] = new boolean[N+1];// index는 뭐가 들어있는 위치
				for(int y = N ; y >=1 ; y--) {
					if(copy[y][x]==0) continue;
					else {
						if(index == N+1) {
							arr[index-1] = copy[y][x];
							index--; // 0번째에 뭐가 들어있음
						}
						else {
							if(arr[index] == copy[y][x] && !visit[index]) {
								//같은경우 index는 증가시키지 말고 누적해준다.
								arr[index] += copy[y][x];
								visit[index] = true;
							}
							else {
								arr[index-1] = copy[y][x];
								index--;
							}
						}
					}
				}
				for(int y = N ; y >=1 ; y--) {
					copy[y][x] = arr[y];
				}
			}
			return copy;
		}
		else if(dir ==3) { // 위로 민경우
			for(int  x = 1 ; x<= N ; x++) {
				int arr[] = new int[N+1]; int index= 0; boolean visit[] = new boolean[N+1];// index는 뭐가 들어있는 위치
				for(int y = 1 ; y<=N ; y++){
					
					if(copy[y][x]==0) continue;
					else {
						if(index == 0) {
							arr[index+1] = copy[y][x];
							index++; // 0번째에 뭐가 들어있음
						}
						else {
							if(arr[index] == copy[y][x] && !visit[index]) {
								//같은경우 index는 증가시키지 말고 누적해준다.
								arr[index] += copy[y][x];
								visit[index] = true;
							}
							else {
								arr[index+1] = copy[y][x];
								index++;
							}
						}
					}
				}
				for(int y = 1 ; y <=N ; y++) {
					copy[y][x] = arr[y];
				}
			}
			return copy;
		}	
		return copy;
	}
}
