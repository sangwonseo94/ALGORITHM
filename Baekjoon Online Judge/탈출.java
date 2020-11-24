package 풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 탈출 {
	static class node{
		int y,x,path;
		char now;
		public node(int y,int x, int path,char now) {
			this.y = y ; this.x = x;
			this.path= path ; this.now = now;
		}
	}
	static int dy[] = {0,0,-1,1};
	static int dx[] = {-1,1,0,0};
	static int ex,ey , nowx,nowy , ny,nx;
	static char nowc;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringBuilder sb = new StringBuilder();
		ArrayDeque<node> dq = new ArrayDeque<>(); 
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			char map[][] = new char[n][m];
			
			for(int y= 0 ; y< n ; y++) {
				char t[] = br.readLine().toCharArray();
				for(int x = 0 ; x<m ; x++) {
					map[y][x] = t[x];
					if(t[x]=='S') {
						dq.addLast(new node(y,x,0,'S'));
					}else if(t[x] =='*') {
						dq.addFirst(new node(y,x,0,'*'));
					}else if(t[x]=='D') {
						ex =x; ey= y;
					}
				}
			}
		
			int res= 987654321;
			top :
			while(!dq.isEmpty()) {
				node now = dq.poll();
				nowy = now.y ; nowx = now.x;
				nowc = now.now ;
				
				if(nowc =='*') {
					for(int index = 0  ; index < 4 ; index++) {
						ny = nowy + dy[index];
						nx = nowx + dx[index];
						if(ny >= 0 && nx>= 0 && ny <n && nx <m && (map[ny][nx] =='.' || map[ny][nx] =='S' )) {
						map[ny][nx] ='*';	
						dq.add(new node(ny,nx,0,'*'));
						}
					}
				}
				else if(nowc =='S') {
					for(int index = 0  ; index < 4 ; index++) {
						ny = nowy + dy[index];
						nx = nowx + dx[index];
						if(ny >= 0 && nx>= 0 && ny <n && nx <m && (map[ny][nx] =='.' || map[ny][nx] =='D' )) {
							if(map[ny][nx]=='D') {
								res =now.path+1;
								break top;
							}
							map[ny][nx] ='S';	
							dq.add(new node(ny,nx,now.path+1,'S'));
						}
					}
				}
			}
			if(res ==987654321) System.out.println("KAKTUS");
			else System.out.println(res);
			
		}
		
	}

}