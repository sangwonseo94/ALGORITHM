package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 히스토그램에서가장큰직사각형과쿼리 {
	public static int n ,answer = -1  , answer_h =0;
	public static int []seg;
	public static int h[];
	public static int out = 987654321;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		h = new int[n+1];
		seg = new int[4*(n+1)];
		st = new StringTokenizer(br.readLine());
		for(int i=1 ; i <=n;i++) {h[i] = Integer.parseInt(st.nextToken());}
		seginit(1,1,n);
		int q = Integer.parseInt(br.readLine());
		while(q-->0) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			dfs(s,e,w);
			sb.append(answer_h+"\n");
			answer = -1;
			answer_h= 0;
		}System.out.println(sb);
	
	}
	private static void dfs(int s, int e , int w) {
		if(e<s)return;
		if(s==e) {
			if(1 == w) {
				int res = w* h[s];
				if(answer < res) {
					answer = res;
					answer_h = h[s];
				}
			}
			return ;
		}
		int index = findmin(1,1,n,s,e);
		int width = (e-(s-1));
		if(width == w) {
			int res = w* h[index];
			if(answer < res) {
				answer = res;
				answer_h = h[index];
			}
		}
		if(width > w) {
			dfs(s,index-1,w);
			dfs(index+1,e,w);
		}
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
