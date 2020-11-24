package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 드래곤커브 {
	public static boolean isRange(int y , int x) {
		return y>=0&&x>=0&&x<101&&y<101;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		ArrayList<Integer> order[][] = new ArrayList[4][11];
		for(int j=0;j<4; j++) {
			for(int i=0 ; i < 11 ; i++) {
				order[j][i] = new ArrayList<>();
				if(i==0) {
					order[j][i].add(j);
				} else {
					int size = order[j][i-1].size();
					for(int k=0;k< size ; k++) {
						order[j][i].add(order[j][i-1].get(k));
					}
					for(int k=size-1;k>=0; k--) {
						order[j][i].add((order[j][i-1].get(k)+1) %4);
					}
				}
			}
		}
		int n = Integer.parseInt(st.nextToken());
		int map[][]= new int[101][101];
		int dir[][] = {{0,1},{-1,0},{0,-1},{1,0}};
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int ny = y, nx = x;
			if(isRange(ny, nx)) map[ny][nx]=1;
			for(int j = 0 ; j<order[d][g].size() ; j++) {
				ny = ny + dir[order[d][g].get(j)][0];
				nx = nx + dir[order[d][g].get(j)][1];
				if(isRange(ny, nx)) {
					map[ny][nx] = 1;
				}
			}
		}
		int answer=0;
		for(int i=0;i<101;i++) {
			for(int j=0;j<101;j++) {
				if(isRange(i+1, j)&&isRange(i+1, j+1)&&isRange(i, j+1)) {
					if(map[i+1][j]==1&&map[i][j+1]==1&&map[i+1][j+1]==1&&map[i][j]==1) {
						answer++;
					}
				}
			}
		}
		System.out.println(answer);
	}
}
