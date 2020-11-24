package CodeForce0908;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2 {
	public static int gcd(int a,int b) {
		return b==0 ? a : gcd(b,a%b);
	}
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t= Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		while(t-->0) {
			st = new StringTokenizer(br.readLine()); 
			int n = Integer.parseInt(st.nextToken());
			int num[] = new int[n];
			int visit[]=new int [n];
			int max=0,maxi=0;
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				num[i] = Integer.parseInt(st.nextToken());
				if(num[i] >max) {
					max = num[i];
					maxi=i;
				}
			}
			sb.append(max+" ");
			visit[maxi]=1;
			int nowg= max;
			for(int i = 0 ; i < n ; i ++) {
				if(visit[i]==1) continue;
				max=0;maxi=0;
				for(int j = 0 ;j < n ; j++) {
					if(visit[j]==1) continue;
					int res = gcd(nowg,num[j]);
					if(res>max) {
						max=res;
						maxi=j;
					}
				}
				visit[maxi]=1;
				sb.append(num[maxi]+" ");
				nowg=max;
			}
			for(int i=0;i<n;i++)if(visit[i]==0)sb.append(num[i]+" ");
			if(t!=0)sb.append("\n");
		}System.out.println(sb);
		
	}

}
