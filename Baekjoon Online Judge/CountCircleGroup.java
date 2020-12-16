package 알고리즘잘하고싶다;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class CountCircleGroup {
	public static int find(int x) {
		if(parent[x] ==x ) return x;
		else return parent[x] = find(parent[x]);
	}
	public static void union(int x, int y){
		if(x > y) {
			int rr = x ;
			x = y ;
			y = rr;
		}
		parent[y] = x;
		return;
	}
	public static int parent[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int t = 0 ; t < T ; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int arr[][] = new int[n][3];
			parent = new int[n];
			for(int i=0;i<n;i++) parent[i] = i;
			for(int i = 0 ; i < n ; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				arr[i][0] = x;
				arr[i][1] = y;
				arr[i][2] = r;
			}
			int answer = n;
			for(int i = 0 ; i < n ; i++){
				for(int j=0; j< n ; j++){
					if(i==j)continue;
					int xx = (arr[i][0]-arr[j][0])*(arr[i][0]-arr[j][0]);
					int yy = ( arr[i][1] - arr[j][1])*( arr[i][1] - arr[j][1]);
					int rr = (arr[i][2] + arr[j][2])*(arr[i][2] + arr[j][2]);
					int pi = find(i);
					int pj =  find(j);
					if(pi != pj &&xx+yy<=rr  ) {
						union(pi , pj);
						answer--;
					}
				}
			}
			
			sb.append(answer+"\n");
		}System.out.println(sb);
	}

}
