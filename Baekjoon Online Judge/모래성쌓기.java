package 풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 모래성쌓기 {
	
	
	public static void main(String[] args)throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int map[][] ;
		int r,c;
		int answer=0,ny=0,nx=0,count=0;
		int nowy,nowx,size;
		int diry[] = {0,0,1,-1,1,1,-1,-1};
		int dirx[] = {-1,1,0,0,1,-1,1,-1};
		ArrayDeque<int []> minus = new ArrayDeque<>();
		ArrayDeque<int []> coordi = new ArrayDeque<>();
		for(int tc = 1 ; tc<=T ; tc++) {
			answer =0;
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			map = new int[r][c];
			for(int y = 0 ; y < r ; y++) {
				char temp[] = br.readLine().toCharArray();
				for(int x = 0 ; x < c ; x++) {
					if(temp[x] =='.') {map[y][x] =0;}
					else {map[y][x] = temp[x] -'0';
						if(map[y][x] != 9){coordi.add(new int[] {y,x});}
					}
				}
			}
			
			while(true){
				boolean ischange = false;
				size = coordi.size();
				while(size >0) {
					int now[] = coordi.poll();
					nowy = now[0]; nowx = now[1];
					for(int index = 0 ; index < 8 ; index++) {
						ny = nowy + diry[index];
						nx = nowx + dirx[index];
						if(ny >=0 && nx >= 0 && nx < c && ny < r && map[ny][nx] == 0) count++;
					}
					if(map[nowy][nowx] <= count) {
						minus.add(new int[] {nowy,nowx});
						ischange = true;
					} 
					else coordi.add(new int [] {nowy,nowx});
					size--; count =0;
				}
				answer++;
				if(!ischange) break;
				while(!minus.isEmpty()) {int now[] = minus.poll(); map[now[0]][now[1]] =0;}
			}
			System.out.println("#"+tc+" "+(answer-1));
			answer =0;
		}
		//System.out.print(sb);
	}
	
}
