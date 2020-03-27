package 푼문제;

import java.util.Scanner;

public class 서로소집합 {
	static int parent[];
	public static int find(int a) {
		if(parent[a] == a) return a;
		return find(parent[a]);
	}
	public static void union(int a , int b) {
		// 부모끼리 합친다.
		int pa = find(a);
		int pb = find(b);
		if(pa==pb) return;
		if(pa>pb) { parent[pb] = pa;}
		else { parent[pa] = pb;}
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		parent = new int[n+1];
		for(int i = 0 ; i <= n ; i ++) parent[i] =i;
		for(int i = 0 ; i < m ; i ++) {
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		if(a == 0) {
			union(b,c);
		}else {
			if(find(b) == find(c)) {
				System.out.print("YES\n");
			}else {
				System.out.print("NO\n");
			}
		}
	}
	}
}
