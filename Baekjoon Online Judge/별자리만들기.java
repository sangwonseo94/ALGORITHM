package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 별자리만들기 {
	public static class star{
		double x,y;
		int num;
		public star(double x, double y , int num) {
			super();
			this.x = x;
			this.y = y;
			this.num =num;
		}
		
	}
	public static class dist{
		int s ,e ;
		double distance;
		public dist(int s, int e, double distance) {
			super();
			this.s = s;
			this.e = e;
			this.distance = distance;
		}
		
	}
	public static int find(int x) {
		if(x==parent[x]) return x;
		else return parent[x] = find(parent[x]);
	}
	public static void union (int pa , int pb) {
		if(pa > pb) {
			int t = pb;
			pb = pa;
			pa = t;
		}
		parent[pa] = pb;
		return;
	}
	public static int parent[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		star list[] = new star[n];
		parent = new int[n];
		for(int i=0;i<n;i++) parent[i] =i;
		for(int i =0 ; i <  n ; i++) {
			st = new StringTokenizer(br.readLine());
			double xx = Double.parseDouble(st.nextToken());
			double yy = Double.parseDouble(st.nextToken());
			list[i] = new star(xx, yy, i);
		}
		PriorityQueue<dist> pq = new PriorityQueue<>(new Comparator<dist>() {
			@Override
			public int compare(dist o1, dist o2) {
				if(o1.distance > o2.distance) return 1;
				else if(o1.distance == o2.distance) return 0;
				else {
					return -1;
				}
			}
		});
		
		for(int i =0; i< n ; i ++) {
			for(int j=i+1 ; j < n ; j ++) {
				pq.add(new dist(i, j, Math.sqrt((list[i].x - list[j].x)*(list[i].x - list[j].x) + (list[i].y - list[j].y)*(list[i].y - list[j].y))));
			}
		}
		double answer =0;
		int cnt =1;
		while(cnt < n) {
			dist now = pq.poll();
			int pa = find(now.s);
			int pb = find(now.e);
			if(pa !=pb) {
				cnt++;
				union(pa, pb);
				answer += now.distance;
			}
		}
		System.out.println(answer);
	}
}
