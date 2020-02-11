package practice;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 줄기세포배양 {
	static int answer = 0;
	static int maxi = 0;
	static int dir[][]= {{1,0},{-1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/ans/줄기세포.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(st.nextToken());
		for(int tc= 1; tc<=t ; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int map_size = 701;
			int map[][] = new int[map_size][map_size]; 	 // 세포의 생존시간을 저장하는 배열
			int Spread[][] = new int[map_size][map_size];// 다음 타임에 번식 할 세포인지 확인하는 배열
			int Born[][] = new int[map_size][map_size];  // 번식후 시간을 확인하는 배열 
			int live[][] = new int[map_size][map_size];  // 세포가 살았는지 죽었는지 확인하는 배열
			for(int y = 0 ; y < n ; y++) {
				st = new StringTokenizer(br.readLine());
				for(int x= 0 ; x <  m ;x++) {
					map[y + map_size/2][x + map_size/2]= Integer.parseInt(st.nextToken());
					if(map[y + map_size/2][x + map_size/2]!=0) {
						live[y + map_size/2][x + map_size/2] = 1; // 0이 아니면 살은 세포
						
					}
				}
			}
			for(int time = 1 ; time <= k ; time++) {
				
				for(int y=map_size/2  - n -1  - time; y <= map_size/2 + time + n  +1; y++){
					for(int x=  map_size/2 - time - m -1 ; x<= map_size/2 + time + m +1  ; x++){
						if( live[y][x]==1 && ((time % (map[y][x] + 1) == map[y][x]))|| time == map[y][x]) {
							// 살아있는 애들중에 자기 차례가 되면 다음 시간에 번식 할 세포들
							Spread[y][x] = 1;
						}
					}
				}
				
				for(int y=map_size/2 - time - n -1; y <= map_size/2 + time + n  +1; y++) {
					for(int x=  map_size/2 - time - m  -1; x<= map_size/2 + time + m  +1  ; x++) {
						if(live[y][x] == 1 &&Spread[y][x] == 2) { // 살아있고 자기 차례인 애들 번식해야함
							for(int a = 0 ; a <4 ; a++) {
								int ny = y +dir[a][0];
								int nx = x +dir[a][1];
								if(ny < 0 || nx <0 || ny >= map_size ||nx >= map_size ) continue;
								if(map[ny][nx] ==0) {
									// 동시 번식시 큰쪽이 번식 해야함. 
									// 가려는 쪽이 0이면 번식
									map[ny][nx] = map[y][x];
									live[ny][nx] = 2;
								}
								else if(live[ny][nx] == 2  && map[ny][nx] < map[y][x]) {
									// 다른 세포가 번식했을 경우, 생존시간이 0 인애들 == 갓 태어난 애들 , 중에서 나보다 작으면 번식가능
									map[ny][nx] = map[y][x];
									live[ny][nx] = 2;
								}
								
							}
						}
					}
				}
				
				
				for(int y=map_size/2 - time - n-1; y <= map_size/2 + time + n +1; y++) {
					for(int x=  map_size/2 - time - m-1 ; x<= map_size/2 + time + m  +1  ; x++) {	
						if(live[y][x]==2) {
							live[y][x] =1;	
						}
						if(Born[y][x]== map[y][x]) {
							// 살아있는 시간이 생존시간하고 같아지면 
							live[y][x] =0;
						}
						if(Spread[y][x] ==1) {
							//번식 예정인 친구들이 다음 시간에 번식할수 있게 값을 1 늘려준다.
							Spread[y][x] =2;
						}
						if(live[y][x]==1 && Spread[y][x] ==2) {
							// 살아 있으면 생존 시간을 +1 증가시켜준다
							// 이 값이 map이랑 같아지면 그 세포는 죽는다.
							Born[y][x] +=1;
						} 
						
						if(time==k &&live[y][x] == 1) answer++;
						
					}
				}
			}
			sb.append("#"+ tc + " "+ answer+"\n");
			answer= 0;
		}
		System.out.println(sb);
	}
}
