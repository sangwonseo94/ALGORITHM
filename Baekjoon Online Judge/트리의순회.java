import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 트리의순회 {
	public static class node{
		char now;
		node lnode = null;
		node rnode = null;
		public char getNow() {
			return now;
		}
		public void setNow(char now) {
			this.now = now;
		}
		public node getLnode() {
			return lnode;
		}
		public void setLnode(node lnode) {
			this.lnode = lnode;
		}
		public node getRnode() {
			return rnode;
		}
		public void setRnode(node rnode) {
			this.rnode = rnode;
		}
		
	}
	public static StringBuilder sb = new StringBuilder();
	public static node map[] ;
	public static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		map = new node[n];
		for(int i=0;i<n;i++) map[i] = new node();
		for(int i=0 ; i<n ; i++){
			st = new StringTokenizer(br.readLine());
			char a = st.nextToken().charAt(0);
			char b = st.nextToken().charAt(0);
			char c = st.nextToken().charAt(0);
			map[a-'A'].now = a;
			if(b!='.') {
				// a와 b 연결
				map[a-'A'].lnode = map[b-'A'];
				map[a-'A'].lnode.now = b;
			} 
			if(c!='.') {
				// a와 c 연결
				map[a-'A'].rnode = map[c-'A'];
				map[a-'A'].rnode.now = c;
			}
		}
		pre(0);sb.append("\n");
		mid(0);sb.append("\n");
		post(0);
		System.out.println(sb);
	}
	private static void pre(int n) {
		if(map[n] != null) {
			sb.append(map[n].now);
			if(map[n].lnode!=null) {
				pre(map[n].lnode.now-'A');
			}
			if(map[n].rnode!=null) {
			   pre(map[n].rnode.now-'A');
			}
		}
		
	}
	private static void mid(int n) {
		if(map[n].lnode!=null) {
			mid(map[n].lnode.now-'A');
		}
		sb.append(map[n].now);
		if(map[n].rnode!=null) {
			mid(map[n].rnode.now-'A');
		}
		
	}
	private static void post(int n) {
		if(map[n].lnode!=null) {
			post(map[n].lnode.now-'A');
		}
		if(map[n].rnode!=null) {
			post(map[n].rnode.now-'A');
		}
		sb.append(map[n].now);
		
	}
}
