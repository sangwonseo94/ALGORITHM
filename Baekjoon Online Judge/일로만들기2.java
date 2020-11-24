package algorithm;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.BufferedReader;

public class 일로만들기2 {
	public static int dp[] = new int[100001];
	public static ArrayList<Integer> answer = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> al = new ArrayList<>();
		dp[1] = 100001;
		al.add(n);
		if(n > 1)
		DFS(n,al);
		if(n==1) {
			System.out.println("1\n1");
			return;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(dp[1]+"\n");
		for (Integer integer : answer) {
			sb.append(integer +" ");
		}System.out.println(sb);
	}
	private static void DFS(int n, ArrayList<Integer> al) {
		if(n==1) {
			if(dp[n] >= al.size()) {
				dp[n] = al.size()-1;
				answer.clear();
				for (Integer integer : al) {	answer.add(integer);}
			}
			return;
		} else if(n < 0) return;
		if(dp[n] > 0 && dp[n] < al.size()) {
			return;
		} else {
			if(n%3 ==0) {
				n/=3;
				ArrayList<Integer> al2 = new ArrayList<>();
				for (Integer integer : al) {al2.add(integer);}
				al2.add(n);
				dp[n] = al2.size();
				DFS(n,al2);
			}  if( (n&1) ==0) {
				n/=2;
				ArrayList<Integer> al3 = new ArrayList<>();
				for (Integer integer : al) {al3.add(integer);}
				al3.add(n);
				dp[n] = al3.size();
				DFS(n,al3);
			}
			if(n >1) {
				n-=1;
				ArrayList<Integer> al4 = new ArrayList<>();
				for (Integer integer : al) {al4.add(integer);}
				al4.add(n);
				dp[n] = al4.size();
				DFS(n,al4);
			}
		}
	}
}
