package 알고리즘공부;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 무서운아르바이트 {
	
	public static int n;
	public static int arr[];
	public static int seg[];
	public static long answer = -1;
	public static int out = 987654321;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[n]; seg=new int[4*n];
		for(int i=0;i<n;++i) {arr[i]=Integer.parseInt(st.nextToken());}
		seginit(1,0,n-1);
		dfs(0,n-1);
		System.out.println(answer);
	}
	
	private static void dfs(int s, int e) {
		if(e<s)return;
		if(s==e) {
			long res = arr[e];
			answer = answer > res ? answer : res;
			return ;
		}
		int index = findmin(1,0,n-1,s,e);
		long res = (long)(e-(s-1)) * (long)arr[index];
		answer = answer > res ? answer : res;
		dfs(s,index-1);
		dfs(index+1,e);
	}

	private static int seginit(int now, int s, int e) {
		// 구간의 가장작은 높이의 인덱스를 저장
		if(s==e) {return seg[now] = s;}
		else {
			int l = seginit(now*2,s,(s+e)>>1);
			int r = seginit(now*2+1,((s+e)>>1)+1,e);
			return (seg[now] = (arr[l]>arr[r]?r:l));		
		}
	}
	
	private static int findmin(int node, int l, int r , int s  , int e) {
		if(r < s || e < l) return out;
		else if( s <= l && r<= e) return seg[node];
		int rr = findmin(2*node, l, (r+l)>>1, s, e);
		int ll = findmin(2*node+1, ((r+l)>>1)+1, r, s, e);
		if(rr==out && ll!= out) return ll;
		if(rr!=out && ll== out) return rr;
		// 둘다 out인경우가? 존재할수 없다
		return arr[rr] > arr[ll] ? ll : rr ;
	}
}


