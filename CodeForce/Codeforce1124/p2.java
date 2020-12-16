package Codeforce1124;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tt = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < tt ; i ++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int max = 2*100000+1;
			int o[] = new int[max];
			int num[] = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n ;j++) {
				num[j] = Integer.parseInt(st.nextToken());
				o[num[j]]++;
			}
			boolean isfail = true;
			int answer = 0;
			for(int j = 0 ; j < max ; j++) {
				if(o[j] ==0) continue;
				if(answer == 0 && o[j]==1) {
					isfail = false;
					for(int jj=0;jj<n;jj++) {
						if(num[jj] == j) {
							answer = jj+1;
							break;
						}
					}
					break;
				}
			}
			if(isfail)sb.append("-1\n");
			else {
				sb.append(answer+"\n");
			}
		}System.out.println(sb);
	}
}
