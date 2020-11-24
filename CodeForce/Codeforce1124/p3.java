package Codeforce1124;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class p3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int nn = Integer.parseInt(st.nextToken());
		for(int n=0 ; n<nn;n++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int num[] = new int[t];
			for(int i=0;i<t;i++)num[i] = Integer.parseInt(st.nextToken());
			int index[] = num.clone();
			Arrays.sort(index);
			HashMap<Integer, Integer> hm = new HashMap<>();
			int s = -1;
			int idx = 0;
			for(int i =0 ; i < t; i++) {
				if(index[i] !=s) {
					s = index[i];
					hm.put(s, idx++);
				} 
			}
			ArrayList<Integer> al[] = new ArrayList[idx];
			for(int i=0;i<idx;i++)al[i] = new ArrayList<>();
			for(int i=0;i<t;i++) {al[hm.get(num[i])].add(i);}
			int answer = 2147000000;
			for(int i=0;i<idx;i++) {
				int res = -1;
				int cnt = 0;
				int size = al[i].size();
				for(int j=0; j<size ;j++) {
					int now = al[i].get(j);
					if(now==res+1) {
						res =now;
					} else if( now > res+1) {
						cnt++;
						res = now;
					}
				}
				if(res < t-1) cnt++;
				answer = answer > cnt ? cnt : answer;
			} sb.append(answer+"\n");
		}
		System.out.print(sb);
	}
}
