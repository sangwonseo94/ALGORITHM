package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_게리멘더링2 {

	public static void main(String[] args)  throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int answer = Integer.MAX_VALUE;
		int map[][] = new int[n+1][n+1];
		for(int y = 1 ; y <= n ; y++ ) {
			st = new StringTokenizer(br.readLine());
			for(int x = 1; x <=n ; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		for(int y = 2 ; y < n ; y++) {
			for(int x = 1 ; x < n-1 ; x++) {
				// 가능한 d1,d2의 최대범위를 구한다
				// d1,d2범위까지 돌면서 map을 나누어준다.
				// map기준으로 적힌 숫자들의 합을 구하고, 가장많은 선거구와 가장 적은 선거구를 돌면서 확인한다
				// 둘의 차이를 answer에 담고, 다음번에는 answer와 res중 작은값을 answer에 담는다.
				// (d1, d2 ≥ 1, 1 ≤ x < x+d1+d2 ≤ N, 1 ≤ y-d1 < y < y+d2 ≤ N)
				
				int d1max =y -1; int d2max = n - y -1;
				for(int d1 = 1 ; d1 <= d1max ; d1++) {
					for(int d2 =1 ; d2 <= d2max ; d2++) {
						int Seperate_Map[][] = new int[n+1][n+1];
						int start_x = x , start_y = y;
						Seperate_Map[start_y][start_x] =5;
						if(start_x+d1+d2 > n) break;
						for(int nx = start_x , ny = start_y ; nx <= start_x +d1 && ny >= start_y -d1 ; nx++, ny--) { Seperate_Map[ny][nx] = 5;} 
						for(int nx = start_x , ny = start_y ; nx <= start_x +d2 && ny <= start_y +d2 ; nx++, ny++) { Seperate_Map[ny][nx] = 5;} 
						for(int nx = start_x+d1 , ny = start_y-d1 ; nx <= start_x +d1+d2 && ny <= start_y-d1+d2; nx++, ny++) { Seperate_Map[ny][nx] = 5;} 
						for(int nx = start_x+d2 , ny = start_y+d2 ; nx <= start_x+d2 +d1 && ny >= start_y-d1+d2; nx++, ny--) { Seperate_Map[ny][nx] = 5;} 
						
						for(int ny =1 ; ny < start_y; ny++) {
							for(int nx = 1 ; nx <= start_x +d1 ; nx++) {
								if(Seperate_Map[ny][nx]== 5) break;
								Seperate_Map[ny][nx] =1;
							}
						}
						for(int ny =y ; ny <= n ; ny++) {
							for(int nx = 1 ; nx <= start_x +d2-1 ; nx++) {
								if(Seperate_Map[ny][nx]== 5) break;
								Seperate_Map[ny][nx] =3;
							}
						}
						for(int nx =start_x +d1+1 ; nx <= n ; nx++) {
							for(int ny = 1 ; ny <= start_y-d1+d2 ; ny++) {
								if(Seperate_Map[ny][nx]== 5) break;
								Seperate_Map[ny][nx] =2;
							}
						}
						for(int nx =start_x +d2; nx <= n ; nx++) {
							for(int ny = n ; ny > start_y-d1+d2 ; ny--) {
								if(Seperate_Map[ny][nx]== 5) break;
								Seperate_Map[ny][nx] =4;
							}
						}
						int numbers[] = new int[5];
						
						for(int ny =1; ny <= n ; ny++) {
							for(int nx = 1 ; nx <= n ; nx++) {
								if(Seperate_Map[ny][nx] == 1) {numbers[0] +=map[ny][nx];}
								else if(Seperate_Map[ny][nx] == 2) {numbers[1] +=map[ny][nx];}
								else if(Seperate_Map[ny][nx] == 3) {numbers[2] +=map[ny][nx];}
								else if(Seperate_Map[ny][nx] == 4) {numbers[3] +=map[ny][nx];}
								else {numbers[4] +=map[ny][nx];}
							}
						}
						Arrays.sort(numbers);
						answer = Math.min(answer, numbers[4] - numbers[0]);
					}
				}
			}
		}
		System.out.print(answer);
	}
}
