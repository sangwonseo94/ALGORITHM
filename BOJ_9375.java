package algorithm_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_9375 {

	public static void main(String[] args) throws IOException{
	
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for(int tt=0;tt<T;tt++) {
			int n = Integer.parseInt(br.readLine());
			HashMap<String, Integer> hm = new HashMap<>();
			int answer =1;
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				String str1 = st.nextToken();
				String str2 = st.nextToken();
				if(hm.getOrDefault(str2, 0)==0) {
					hm.put(str2, 1);
				} else {
					hm.put(str2, hm.get(str2)+1);
				}
			}
			for ( String key : hm.keySet() ) {
			    answer*=(hm.get(key)+1);	
			}
			sb.append(answer-1).append("\n");
			
		}
        System.out.println(sb.toString());
	}
}
