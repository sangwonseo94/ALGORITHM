package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자정사각형 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char map[][] = new char[n][m];
		int max = n > m ? m : n;
		int answer = 0;
		for(int i = 0 ; i < n ; i ++) {map[i]=br.readLine().toCharArray();}
		int dir[][] = {{0,0},{1,0},{1,1},{0,1}};
		for(int i = 0 ; i < n ; i ++) {
			for(int j = 0 ; j < m ; j++) {
				for(int k = 0 ; k < max ; k++) {
					int cnt=0;
					for(int z = 0 ; z < 4 ; z++) {
						int ni = i+ k*dir[z][0];
						int nj = j +k*dir[z][1];
						if(ni >=0 && nj >=0 && ni <n && nj<m) {
							if(map[i][j] == map[ni][nj]) {
								cnt++;
							}
						}
					}
					if(cnt ==4) {
						answer = answer > (k+1)*(1+k) ? answer :(k+1)*(1+k);
					}
				}
			}
		}System.out.println(answer);
	}

}
