package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 미생물격리 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int tt=1 ; tt<= t ;tt++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int dir[][] = {{0,0},{-1,0},{1,0},{0,-1},{0,1}};
			ArrayList<int []> al = new ArrayList<>();
			for(int i=0;i<k;i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int dirr = Integer.parseInt(st.nextToken());
				al.add(new int[] {y,x,cnt,dirr});
			}
			for(int i=0;i<m;i++) {
				int maxdir[][][] = new int[3][n][n];
				for(int j=0;j<al.size();j++) {
					// al 내용을 maxdir에 업데이트
					int now[] = al.get(j);
					// 0 에는 총합 1에는 방향 2에는 가장 큰 값
					// 가장자리라면 /2 0이면 총합을 0으로
					int ny = now[0] + dir[now[3]][0];
					int nx = now[1] + dir[now[3]][1];
					if(ny==0||nx==0||ny==n-1||nx==n-1) {
						//가장자리라면,
						now[2]/=2;
						// 방향 바꿔주기
						if(now[3]==1) {
							now[3] =2;
						} else if(now[3]==2) {
							now[3]=1;
						} else if(now[3]==3) {
							now[3]=4;
						} else {
							now[3]= 3;
						}
					}
					// now 가변경됬으므로 그냥 now를 써도된다.
					maxdir[0][ny][nx] += now[2];
					// 방향이 바뀌는 건, 기존의 값보다 클때
					if(now[2]>maxdir[2][ny][nx]) {
						maxdir[1][ny][nx] = now[3];
						maxdir[2][ny][nx] = now[2];
					}
				}
				// maxdir에서 al로 업데이트
				al.clear();
				for(int y=0;y<n;y++) {
					for(int x=0;x<n;x++) {
						if(maxdir[0][y][x]!=0) {
							// 총합 양이 존재하면
							al.add(new int[] {y,x,maxdir[0][y][x],maxdir[1][y][x]});
						}
					}
				}
			}
			int answer =0;
			for (int[] is : al) {answer+=is[2];}
			sb.append("#"+tt+" "+answer+"\n");
		}System.out.println(sb);
	}

}
