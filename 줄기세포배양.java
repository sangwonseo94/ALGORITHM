package 푼문제;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class �ٱ⼼����� {
	static int answer = 0;
	static int maxi = 0;
	static int dir[][]= {{1,0},{-1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/ans/�ٱ⼼��.txt"));
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
			int map[][] = new int[map_size][map_size]; 	 // ������ �����ð��� �����ϴ� �迭
			int Spread[][] = new int[map_size][map_size];// ���� Ÿ�ӿ� ���� �� �������� Ȯ���ϴ� �迭
			int Born[][] = new int[map_size][map_size];  // ������ �ð��� Ȯ���ϴ� �迭 
			int live[][] = new int[map_size][map_size];  // ������ ��Ҵ��� �׾����� Ȯ���ϴ� �迭
			for(int y = 0 ; y < n ; y++) {
				st = new StringTokenizer(br.readLine());
				for(int x= 0 ; x <  m ;x++) {
					map[y + map_size/2][x + map_size/2]= Integer.parseInt(st.nextToken());
					if(map[y + map_size/2][x + map_size/2]!=0) {
						live[y + map_size/2][x + map_size/2] = 1; // 0�� �ƴϸ� ���� ����
						
					}
				}
			}
			for(int time = 1 ; time <= k ; time++) {
				
				for(int y=map_size/2  - n -1  - time; y <= map_size/2 + time + n  +1; y++){
					for(int x=  map_size/2 - time - m -1 ; x<= map_size/2 + time + m +1  ; x++){
						if( live[y][x]==1 && ((time % (map[y][x] + 1) == map[y][x]))|| time == map[y][x]) {
							// ����ִ� �ֵ��߿� �ڱ� ���ʰ� �Ǹ� ���� �ð��� ���� �� ������
							Spread[y][x] = 1;
						}
					}
				}
				
				for(int y=map_size/2 - time - n -1; y <= map_size/2 + time + n  +1; y++) {
					for(int x=  map_size/2 - time - m  -1; x<= map_size/2 + time + m  +1  ; x++) {
						if(live[y][x] == 1 &&Spread[y][x] == 2) { // ����ְ� �ڱ� ������ �ֵ� �����ؾ���
							for(int a = 0 ; a <4 ; a++) {
								int ny = y +dir[a][0];
								int nx = x +dir[a][1];
								if(ny < 0 || nx <0 || ny >= map_size ||nx >= map_size ) continue;
								if(map[ny][nx] ==0) {
									// ���� ���Ľ� ū���� ���� �ؾ���. 
									// ������ ���� 0�̸� ����
									map[ny][nx] = map[y][x];
									live[ny][nx] = 2;
								}
								else if(live[ny][nx] == 2  && map[ny][nx] < map[y][x]) {
									// �ٸ� ������ �������� ���, �����ð��� 0 �ξֵ� == �� �¾ �ֵ� , �߿��� ������ ������ ���İ���
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
							// ����ִ� �ð��� �����ð��ϰ� �������� 
							live[y][x] =0;
						}
						if(Spread[y][x] ==1) {
							//���� ������ ģ������ ���� �ð��� �����Ҽ� �ְ� ���� 1 �÷��ش�.
							Spread[y][x] =2;
						}
						if(live[y][x]==1 && Spread[y][x] ==2) {
							// ��� ������ ���� �ð��� +1 ���������ش�
							// �� ���� map�̶� �������� �� ������ �״´�.
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
