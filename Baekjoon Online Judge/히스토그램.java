package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 히스토그램 {
	public static int n;
	public static long answer = -1;
	public static int []seg;
	public static int h[];
	public static int out = 987654321;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if(n==0) break;
			h = new int[n+1];
			seg = new int[4*(n+1)];
			for(int i=1 ; i <=n;i++) {
				h[i] = Integer.parseInt(st.nextToken());
			}
			seginit(1,1,n);
			dfs(1,n);
			sb.append(answer+"\n");
			answer = -1;
		}System.out.println(sb);
	}
	private static void dfs(int s, int e) {
		if(e<s)return;
		if(s==e) {
			long res = h[e];
			answer = answer > res ? answer : res;
			return ;
		}
		int index = findmin(1,1,n,s,e);
		long res = (long)(e-(s-1)) * (long)h[index];
		answer = answer > res ? answer : res;
		dfs(s,index-1);
		dfs(index+1,e);
	}
	private static int seginit(int node, int s, int e) {
		if(s==e) return seg[node] = e;
		int l = seginit(2*node, s , (s+e)>>1);
		int r = seginit(2*node+1, ((s+e)>>1)+1, e);
		return seg[node] = h[l] > h[r] ? r : l;
	}
	private static int findmin(int node, int l, int r , int s  , int e) {
		if(r < s || e < l) return out;
		else if( s <= l && r<= e) return seg[node];
		int rr = findmin(2*node, l, (r+l)>>1, s, e);
		int ll = findmin(2*node+1, ((r+l)>>1)+1, r, s, e);
		if(rr==out && ll!= out) return ll;
		if(rr!=out && ll== out) return rr;
		// 둘다 out인경우가? 존재할수 없다
		return h[rr] > h[ll] ? ll : rr ;
	}
}
