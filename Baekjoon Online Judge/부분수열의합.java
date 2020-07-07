package 풀문제2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 부분수열의합 {

	public static int num[] , answer , target , n ;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		num = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i ++) {num[i] = Integer.parseInt(st.nextToken());}
		DFS(0 , new ArrayList<Integer>());
		System.out.println(answer);
	}

	private static void DFS(int index , ArrayList<Integer> arrayList) {
		if(index >=n) {
			if(arrayList.size() !=0) {
				int res = 0;
				for (Integer integer : arrayList) {res +=integer;}
				if(res == target) answer++;
			}
			return;
		}
		
		ArrayList<Integer> al = new ArrayList<>();
		for (Integer integer : arrayList) {al.add(integer);}
	
		DFS(index+1 , arrayList);
		al.add(num[index]);
		DFS(index+1 , al);
	}

}
