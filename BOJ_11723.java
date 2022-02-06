package algorithm_2022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11723 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S[] = new int[21];
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String order  = st.nextToken();
			if(order.equals("all")||order.equals("empty")) {
				if(order.equals("all")) {
					for(int j=1;j<=20;j++) {S[j] =1;}
				} else {
					for(int j=1;j<=20;j++) {S[j] =0;}
				}
			} else {
				int num = Integer.parseInt(st.nextToken());
				if(order.equals("add")) {
					S[num]=1;
				} else if(order.equals("remove")) {
					S[num]=0;
				} else if(order.equals("toggle")) {
					S[num]=(S[num]==1 ? 0:1);
				} else {
					// check
					if(S[num]==1) {
						sb.append("1\n");
					} else {
						sb.append("0\n");
					}
				}
			}
		}
		br.close();
		System.out.println(sb.toString());
		
	}
}
