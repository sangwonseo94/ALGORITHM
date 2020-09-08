package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 스타트와링크 {

	public static int n,answer=987654321;
	public static int map[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());map=new int[n][n];
		for(int i =0;i<n;i++){st = new StringTokenizer(br.readLine());for(int j=0;j<n;j++)map[i][j]=Integer.parseInt(st.nextToken());};
		int index[]=new int[n];
		int c=0,l=0;
		for(int i=0,size=((1<<n)-1);i<size;i++){
			for(int j=0;j<n;j++) {
				if( (i&(1<<j))!=0) {c++;index[j]=1;}
				else {l++;index[j]=0;}
			}
			if(c==(n>>1)) {
				c=0;l=0;
				for(int y=0;y<n;y++)for(int x=0;x<n;x++) {
					if(y==x)continue;
					if(index[y]==index[x]) {
						if(index[y]==1)c+=map[y][x];
						else l+=map[y][x];
					}
				}
				answer=answer>Math.abs(c-l)?Math.abs(c-l):answer;
			}
			c=0;l=0;
		}System.out.println(answer);
	}
}
