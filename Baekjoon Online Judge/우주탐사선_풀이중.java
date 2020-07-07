package 풀문제2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 우주탐사선_풀이중 {
	public static int answer = Integer.MAX_VALUE , n , k , map[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		for(int i = 0 ; i <  n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j <n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean visit[][] = new boolean[n][n];
		for(int i = 0 ; i < n ; i++) {
			if(k!=i) {
				visit[k][i] = true;
				DFS(i , visit , map[k][i] ,(1<<n)|(1<<k));
				visit[k][i] = false;
			}
		}
		System.out.println(answer);
		
	}
	private static void DFS(int row, boolean[][] visit , int sum , int flag) {
		flag |= (1<<row);
		if(sum > answer ) return ;
		if(flag == (Math.pow(2, n+1)-1)) {
			if(sum < answer) {
				answer = sum;
			}
			return;
		} else {
			boolean Cvisit[][] = new boolean[n][n];
			for(int i = 0 ; i < n ; i ++) Cvisit[i] = visit[i].clone();
			for(int i = 0 ; i < n ; i ++) {
				if(!Cvisit[row][i] && (row != i)) {
					Cvisit[row][i] = true;
					DFS(i,Cvisit, sum+map[row][i], flag );
					Cvisit[row][i] = false;
				}
			}
		}
	}
}
