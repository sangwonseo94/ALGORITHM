package practice;


import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class SWEA_수영장{
	static int Cost[] = new int[4];
	static int Plan[] = new int[12]; 
	static int Jump[] = {1,1,3,13};
	static int answer = 2147000000;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++){
			
			
			st = new StringTokenizer(br.readLine());
			for(int index = 0 ; index < 4;  index++) {
				Cost[index] = Integer.parseInt(st.nextToken());
			}
			// 하루 한달 3달 1년 
			st = new StringTokenizer(br.readLine());
			for(int index= 0 ; index < 12; index++) {
				Plan[index] = Integer.parseInt(st.nextToken());
			}
			
			DFS(0,0);
			sb.append("#"+ test_case+ " " +answer + "\n");
			answer = 2147000000;
		}
		System.out.println(sb);
	}
	//1일권으로 다이용하거나 , 한달이용하거나, 세달이용하거나, 일년 이용하거나,
	public static void DFS(int cost,int index) {
		if(index >= 12) {
			answer = Math.min(answer, cost);
			return;
		}
		if(Plan[index]==0) DFS(cost,index+1);
		for(int i = 0 ; i < 4 ; i ++) {
			
			if(i==0) cost +=(Plan[index] * Cost[0]);
			else cost +=(Cost[i]);
			DFS(cost,index+Jump[i]);
			if(i==0) cost -=(Plan[index] * Cost[0]);
			else cost -=(Cost[i]);
			
		}
	}
}