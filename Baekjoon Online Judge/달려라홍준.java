import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.concurrent.SynchronousQueue;

public class 달려라홍준 {

	public static long seg[] , arr[];
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new long[n];
		for(int i=0;i<n;i++) {arr[i] = Long.parseLong(st.nextToken());}
		seg = new long[4*n];
		seginit(1,0,n-1);
		
		StringBuilder sb = new StringBuilder();
		
		for(int start=m-1 ; start <= n-m; start++) {
			sb.append(find(1,0,n-1,start-(m-1),start+(m-1))+" ");
		}
		
		System.out.print(sb);
	}
	private static long seginit(int node, int s, int e ) {
		if(s==e) {return seg[node]= arr[s];}
		int mid = (s+e)/2;
		return seg[node] = max (seginit(2*node ,s,mid) , seginit(2*node+1,mid+1, e));
	}
	private static long max(long a, long b) {
		return a >= b ? a : b;
	}
	private static long find(int node , int s , int e , int left , int right) {
		if(right < s || left > e) return -1;
		else if(left <= s && e <= right) {
			return seg[node];
		}
		else {
			int mid = (s+e)/2;
			return max(find(node*2 ,s, mid,left,right),find(node*2+1, mid+1 , e , left , right));
		}
	}
}
