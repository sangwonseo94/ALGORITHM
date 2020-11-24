package 알고리즘잘하고싶다;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 좌표압축 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int num[] = new int[n];
		for(int i=0;i<n;i++) {num[i] = Integer.parseInt(st.nextToken());}
		HashMap<Integer, Integer> hm = new HashMap<>();
		int index =0;
		int tnum[] = num.clone();
		Arrays.sort(num);
		int s = 2147000000;
		for(int i=0;i<n;i++) {
			if(s!=num[i]) {
				hm.put(num[i], index++);
				s=num[i];
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			sb.append(hm.get(tnum[i])+" ");
		}System.out.println(sb);
	}

}
