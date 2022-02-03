package algorithm_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1021 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[] = new int[M+1];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			arr[i+1] = Integer.parseInt(st.nextToken());
		}
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		ArrayList<Integer> al = new ArrayList<>();
		for(int i=0;i<N;i++) {dq.add(i+1);}
		int cnt=1;
		int answer =0;
		while(cnt<=M) {
			while(!dq.isEmpty()) {al.add(dq.poll());}
			int s=0, e=al.size();
			int left =0, right =1;
			for(int i=0;i<e;i++) {if(al.get(i)==arr[cnt]) {break;} else {left++;}}
			for(int i=e-1;i>=0;i--) {if(al.get(i)==arr[cnt]) {break;} else {right++;}}
			if(left<=right) {
				answer += left;
				for(int i=0;i<left;i++){dq.add(al.get(i));}
				for(int i=al.size()-1;i>left;i--){dq.addFirst(al.get(i));}
			} else {
				answer += right;
				right--;
				for(int i=0;i<right;i++){dq.addFirst(al.get(al.size()-1-i));}
				for(int i=0;i<e-right-1;i++){dq.add(al.get(i));}
			}
			cnt++;
			al.clear();
		}System.out.println(answer);
	}

}
