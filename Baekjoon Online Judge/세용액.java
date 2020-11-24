package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 세용액 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long arr[] = new long[n];
		long answer = Long.MAX_VALUE ;
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i ++) { arr[i] = Long.parseLong(st.nextToken());}
		Arrays.sort(arr);
		int s=0,m=0,e=n-1;
		int i1=0,i2=0,i3=0;
		top:
		for( s=0 ; s < n ; s++) {
			long now = arr[s];
			m = s+1;
			e = n-1;
			if(m >=n && e <=m) continue;
			for( ; m < e ;) {
				long snumber = arr[m];
				long enumber = arr[e];
				long sum = now+ snumber + enumber;
				if(Math.abs(sum) < Math.abs(answer)) {
					answer = sum;
					i1=s;i2=m;i3=e;
				}
				if(sum >0)e--;
				else if(sum==0) break top;
				else {m++;	}
			}
		}System.out.print(arr[i1] +" "+arr[i2] + " "+arr[i3]);
	}

}
