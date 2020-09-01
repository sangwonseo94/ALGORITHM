package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 장훈이의높은선반 {

	public static void main(String[] args) throws Exception{

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t= Integer.parseInt(st.nextToken());
		for(int a = 1 ; a<= t ;a++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int array[] = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < n ; i ++) {
				array[i]= Integer.parseInt(st.nextToken());
			}
			int answer = 2147000000;
			int choose[] = new int[n];
			for(int i = 1 , size = (1<<n) ; i < size ; i ++) {
				for(int j = 0 ; j < n ; j ++) {
					int bits =(1<<j);
					if((i &bits ) !=0 ) {
						choose[j] =1;
					} else {
						choose[j] =0;
					}
				}
				
				int res = 0;
				for(int j = 0 ; j < n ; j ++) {
					if(choose[j]==1) {
						res +=array[j];
					}
				}
				
				if(m > res) continue;
				int abs = Math.abs(m-res);
				
				answer = answer > abs ? abs : answer;
			}
			sb.append("#" +a+" "+answer+"\n");
		}System.out.println(sb);
		
		
		
		
	}

}
