package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_원자충돌시뮬레이션 {
	static int answer =0 ;
	static int max_num=0;
	
	static class atom{
		int y, x,  quantity ,  dir;
		public atom(int y , int x , int dir , int quantity) {
			this.y =y;
			this.x =x;
			this.quantity =quantity; 
			this.dir = dir;
		}
	}
	static int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}}; // 상 0 하 1 좌 2 우 3
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine().trim());
		for(int tc = 1 ; tc <= t ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			LinkedList<atom> LL = new LinkedList<atom>();
			
			for(int index = 0 ; index < n ; index++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken())*2;
				int y = Integer.parseInt(st.nextToken())*2;
				int dir = Integer.parseInt(st.nextToken());
				int quantity = Integer.parseInt(st.nextToken());
				max_num = Math.max(Math.abs(y), Math.max(Math.abs(x), max_num));
				 // 모든좌표에 더해주는 값 가장작은 값은 0,0 이되고, x,y를 더해주면서 큰값을 계산하고 map 설정
				LL.add(new atom(y, x, dir, quantity));
			}
			
			// map = new int[map_size_y+1][map_size_x+1];
			// 준비 작업 완료 // 
			
			for(int i = 0 ; i < 4002 ; i++) {
				
				int LLsize = LL.size();
				for(int index = 0 ;  index < LLsize ; index++){
					LL.get(index).x += dir[LL.get(index).dir][1];
					LL.get(index).y += dir[LL.get(index).dir][0];
					// 좌표이동
				}
				boolean compute = false;
				boolean visit[] = new boolean[LLsize];
				for(int j=0 ; j < LLsize ; j++) {
					int ny = LL.get(j).y;
					int nx = LL.get(j).x;
					for(int k = j+1 ; k< LLsize; k++) {
						if(visit[k]) continue;
						if(LL.get(k).y == ny && LL.get(k).x == nx) {
							visit[k] = true;
							visit[j] = true;
							compute = true;
						}
					}
				}
				if(compute) {
					for(int index = 0 ; index < LLsize; index++) {
						if(visit[index]){
						answer+= LL.get(index).quantity;
						LL.remove(index);
						index--;
						LLsize--;
						}
					}
				}
				
			}
			sb.append("#"+tc+" "+answer+"\n");
			answer =0;
			max_num =0;
		}
		System.out.println(sb);
	}

}
