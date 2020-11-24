package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자끼워넣기 {
	public static int n,min=2147000000,max= -2147000000;
	public static int arr[];
	public static int tar[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 n =Integer.parseInt(st.nextToken());
		 arr = new int[n];
		 st = new StringTokenizer(br.readLine());
		 for(int i = 0 ; i < n ; i ++) {
			 arr[i] = Integer.parseInt(st.nextToken());
		 }
		 tar = new int[4];
		 st = new StringTokenizer(br.readLine());
		 for(int i =0; i<4 ; i++) {
			 tar[i] = Integer.parseInt(st.nextToken());
		 }
		 dfs(0,arr[0]);		
		 System.out.println(max);
		 System.out.println(min);
				 
	}
	private static void dfs(int index, int total) {
		if(index ==n-1) {
			min = min > total ? total : min;
			max = max > total ? max : total;
			return;
		}
		for(int i=0;i<4;i++) {
			if(tar[i] >0) {
				tar[i]--;
				int next = total;
				if(i==0) next +=arr[index+1];
				if(i==1) next -=arr[index+1];
				if(i==2) next *=arr[index+1];
				if(i==3) next /=arr[index+1];
				dfs(index+1,next);
				tar[i]++;
			}
		}
	}

}
