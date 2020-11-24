package 푼문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 미세먼지안녕 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int airx=0,airy=0;
		int res =0 , Spread_Quantity=0 , Spread_Count =0 , ny = 0 , nx = 0;
		int diry[] = {0,0,-1,1};
		int dirx[] = {1,-1,0,0};
		
		int map[][] = new int[r][c];
		int copymap[][] = new int[r][c];
		for(int y = 0 ; y < r ; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x= 0 ; x < c; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if(map[y][x] == -1) {
					airx =  x;
					airy =  y;
				}
			}
		}
		for(int index = 1 ; index <= t ; index++) {
			for(int y = 0 ; y < r ; y++) {
				for(int x = 0 ; x< c ; x++) {
					if(map[y][x] != 0 && map[y][x] != -1) {
						// 먼지인 경우
						Spread_Quantity = (map[y][x] / 5); 
						// 이만큼이 퍼지거나 퍼지지않는다.
						Spread_Count = 0;
						for(int i = 0 ; i < 4 ; i ++) {
							ny = y + diry[i];
							nx = x + dirx[i];
							if( ny < r && nx < c && ny >= 0 && nx>=0 && map[ny][nx] != -1 ) {
								// 퍼질수 있다면, 
								Spread_Count +=1;
								copymap[ny][nx] += Spread_Quantity;
							}
						}
						copymap[y][x] += (- ((Spread_Count)*(Spread_Quantity)));
					}
				}
			}
			for(int y = 0 ; y < r ; y++) {
				for(int x = 0 ; x< c; x++) {
					if(map[y][x] != -1) {
						map[y][x] += copymap[y][x];
					}
					copymap[y][x] = 0;
				}
			}
			// 맵 갱신, 공기청정기 시뮬 airy-1 은 반시계 airy는 시계
			for(int y = airy-3 ; y >=0 ; y --)map[y+1][0] = map[y][0];
			for(int x = 1 ; x < c ; x++)map[0][x-1] = map[0][x];
			
			for(int y = 1 ; y <= airy-1 ; y++)map[y-1][c-1] = map[y][c-1];
			for(int x = c-2 ; x >= 1 ; x--)map[airy-1][x+1] = map[airy-1][x];
			map[airy-1][airx+1] = 0;
			
			for(int y = airy+1 ; y < r-1 ; y ++)map[y][0] = map[y+1][0];
			for(int x = 1 ; x < c ; x++)map[r-1][x-1] = map[r-1][x];
			
			for(int y = r-1 ; y > airy ; y--)map[y][c-1] = map[y-1][c-1];
			for(int x = c-1 ; x > 1 ; x --)map[airy][x] = map[airy][x-1];
			map[airy][airx+1] =0;
		}
		for(int y = 0 ; y < r ; y++) {
			for(int x = 0 ; x< c; x++) {
				if(map[y][x] != -1) {
					res += map[y][x];
				}
			}
		}
		
		System.out.println(res);
		
	}

}
