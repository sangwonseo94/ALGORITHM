package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_줄기세포배양 {
	static int answer = 0;
	static int maxi = 0;
	static int dir[][]= {{1,0},{-1,0},{0,-1},{0,1}};
	static class node{
		boolean on , live;
		int lifetime;
		public node() {
			// TODO Auto-generated constructor stub
		}
		public node(boolean on , boolean live , int lifetime) {
			this.on = on;
			this.live = live;
			this.lifetime = lifetime;
 			// TODO Auto-generated constructor stub
		}
		
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("answer/swea줄기세포.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(st.nextToken());
		for(int tc= 1; tc<=t ; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			node map[][] = new node[n+k+2][m+k+2];
			for(int y = 0 ; y <n+k+2 ; y++) {
				for(int x= 0 ; x < m+k+2 ;x++) {
					map[y][x] = new node();
				}
			}
			for(int y = 0 ; y < n ; y++) {
				st = new StringTokenizer(br.readLine());
				for(int x= 0 ; x <  m ;x++) {
					map[y + k/2][x + k /2].live=true;
					map[y + k/2][x + k /2].lifetime = Integer.parseInt(st.nextToken());
					maxi = Math.max(maxi,map[y + k/2][x + k /2].lifetime);
				}
			}
			for(int index = 1 ; index <= k ; index++) {
				
			
				for(int y= 0 ; y < n+k+2 ; y++) {
					for(int x=  0 ; x< m+k+2 ; x++) {
						for(int a = 1 ; a<= maxi ; a++) {
							if(map[y][x].live) {
								if(k % (a+1) == a || k==map[y][x].lifetime) {
									map[y][x].on=true;
								}
							}
						}
					}
				}
				// 배열을 돌면서 on을 눌러줌 k%n 인것은 on이 된다.
				
				for(int y= 0 ; y < n+k+2 ; y++) {
					for(int x=  0 ; x< m+k+2 ; x++) {
						if(map[y][x].on) {
							for(int a = 0 ; a <4 ; a++) {
								int ny = y +dir[a][0];
								int nx = x +dir[a][1];
								if(ny < 0 || nx <0 || ny >= n+k+2 ||nx >= m+k+2 ) continue;
								if(map[ny][nx].lifetime <=map[y][x].lifetime) {
									map[ny][nx].lifetime =map[y][x].lifetime+1;
									map[ny][nx].live = true;
								}
								// 자기보다 같거나 작으면 배양 크면 안된다.
							}
						}
					}
				}// on인 것들을 처리 뭐가 없으면 자기것을 배양하고 있으면 크기 비교
				
				for(int y= 0 ; y < n+k+2 ; y++) {
					for(int x=  0 ; x< m+k+2 ; x++) {	
						if(map[y][x].live && map[y][x].on)map[y][x].lifetime-=1;
						if(map[y][x].lifetime==0 && map[y][x].on) {
							map[y][x].live =false;
							map[y][x].on =false;
						} 
					}
				}
				// 전체 lifetime을 감소시키면서 lifetime 이 0되는 애들의 live 변수를 꺼줌
				
				
				
			}
			// 그때 맵에 몇개가 살아있는지 live 변수만 세줌
			for(int y= 0 ; y < n+k+2 ; y++) {
				for(int x=  0 ; x< m+k+2 ; x++) {	
					if(map[y][x].live) answer++;
				}
			}
			sb.append("#"+ tc + " "+ answer+"\n");
			answer= 0;
		}
		System.out.println(sb);

	}

}
