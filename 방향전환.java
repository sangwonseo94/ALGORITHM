package 풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 방향전환 {
	static int answer =0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		int x1=0,x2=0,y1=0,y2=0;
		int nowx =0,nowy=0,dir=0,time=0;
		ArrayDeque<int []> dq = new ArrayDeque<>();
		for(int tc=1 ; tc<=T ; tc++) {
			st = new StringTokenizer(br.readLine());
			 x1 = Integer.parseInt(st.nextToken())+100;
			 y1 = Integer.parseInt(st.nextToken())+100;
			 x2 = Integer.parseInt(st.nextToken())+100;
			 y2 = Integer.parseInt(st.nextToken())+100;
			 boolean visit[][][] = new boolean[201][201][2];
			 dq.add(new int[] {y1,x1,1,0});
			 dq.add(new int[] {y1,x1,0,0});
			 visit[y1][x1][1] = true;
			 visit[y1][x1][0] = true;
			 while(!dq.isEmpty()){
				 int now[] = dq.poll();
				 nowx = now[1]; nowy= now[0];
				 dir=now[2]; time= now[3];
				 if(nowy == y2 && nowx == x2) {answer = time;break;}
				 if(dir==0) {
					if(nowy+1 <= 200 && !visit[nowy+1][nowx][1]) {
						dq.add(new int[] {nowy+1,nowx,1,time+1});
						visit[nowy+1][nowx][1] = true;
					}
					if(nowy-1 >= 0 && !visit[nowy-1][nowx][1]) {
						dq.add(new int[] {nowy-1,nowx,1,time+1});	
						visit[nowy-1][nowx][1] = true;
					}
				 }
				 else {
					if(nowx+1 <= 200 && !visit[nowy][nowx+1][0]) {
						dq.add(new int[] {nowy,nowx+1,0,time+1});
						visit[nowy][nowx+1][0] = true;
					}
					if(nowx-1 >= 0 && !visit[nowy][nowx-1][0]) {
						dq.add(new int[] {nowy,nowx-1,0,time+1});
						visit[nowy][nowx-1][0] = true;
					}
				}
			 }
			sb.append("#"+tc+" "+answer +"\n");
			answer = 0; 
			dq.clear(); 
		}
		System.out.print(sb);
	}

}
