package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 차량정비소SWEA {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T =Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int t = 1 ; t <=T ; t++) {
			int answer = -1;
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int an[] = new int[n+1];
			int bn[] = new int[m+1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1 ;i<=n ; i++) {an[i] = Integer.parseInt(st.nextToken());}
			st = new StringTokenizer(br.readLine());
			for(int i = 1 ;i<=m ; i++) {bn[i] = Integer.parseInt(st.nextToken());}
			ArrayList<Integer> user = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for(int i =0; i < k ; i++) {user.add(Integer.parseInt(st.nextToken()));}
			
			
			
			sb.append("#"+t+" "+answer+"\n");
		}System.out.println(sb);
		
	}

}
