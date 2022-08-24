package algorithm_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public  class fenwickTree {

	private long arr[];
	private long tree[];
	private int size;
	public fenwickTree(int size) {
		this.size = size;
		arr = new long[size+1];
		tree = new long[size+1];
	}
	public void fenwickTreeInit(long array[]) {
		this.arr =array.clone();
	}
	
	public long sum(int start , int end) {
		return prefixSum(end) - prefixSum(start-1);
	}
	public long prefixSum(int idx) {
		long sum = 0 ;
		while(idx > 0) {
			sum += tree[idx];
			idx -=(idx& -idx);
		}
		return sum;
	}
	
	public void update(int idx , long diff) {
		while(idx<=size) {
			tree[idx] += diff;
			idx +=(idx& -idx);
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		fenwickTree ftree = new fenwickTree(n);
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			long now = Long.parseLong(st.nextToken());
			ftree.arr[i] = now;
			ftree.update(i, now);
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=m+k;i++) {
			st = new StringTokenizer(br.readLine());
			int now = Integer.parseInt(st.nextToken());
			if(now==1) {
				int idx = Integer.parseInt(st.nextToken());
				long num = Long.parseLong(st.nextToken());
				long diff = num- ftree.arr[idx] ;
				ftree.arr[idx] = num;
				ftree.update(idx, diff);
			} else {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				if(start > end) {
					int iidx = start;
					start = end;
					end = iidx;
				}
				sb.append(ftree.sum(start, end)+"\n");
			}
		}
		System.out.println(sb.toString());
	}
}
