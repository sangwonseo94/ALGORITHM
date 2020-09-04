package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 최대유량 {
	private static int size = 702;
	public static void main(String[] args) throws Exception {
		//포드 풀커슨 알고리즘
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		int Capacity[][] = new int[size][size];
		for(int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			int s = st.nextToken().charAt(0) -'A';
			int e = st.nextToken().charAt(0) -'A';
			int f = Integer.parseInt(st.nextToken());
			Capacity[s][e] += f;
			Capacity[e][s] += f;
		}
		
		// end of input
		System.out.println(networkflow('A'-'A','Z'-'A',Capacity));
	}

	private static int networkflow(int start, int end, int[][] capacity) {
		
		int size = capacity.length;
		// a->b에서 정방향이면 b->a의 역방향의 -유량을 표시해준다.
		int flow[][] = new int[size][size];
		
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		int res = 0;
		while(true) {
			dq.clear();
			int parent[] = new int[size];
			for(int i = 0 ; i < size ; i++) {parent[i] = -1;}
			dq.add(start); parent[start] = start;
			while(!dq.isEmpty() && parent[end] == -1) {
				int now = dq.poll();
				for(int i = 0 ; i < size ; i++) {
					if(capacity[now][i]-flow[now][i]>0 && parent[i]== -1) {
						// 연결되어서 유량을 보낼수 있는 경우 
						// 경로가 결정되지 않았을 경우
						dq.add(i);
						parent[i] = now;
					}
				}
			}
			
			
			if(parent[end]==-1) {
				break;
				// 유량경로가없으면 종료
			}
		
			// 한스텝에 얼마의 유량을 흘릴것인지?
			int flowamount = 2147000000;
			
			for(int s = end ; s != start ; s = parent[s]) {
				// 거꾸로 올라가면서 유량의 최솟값을 찾음
				flowamount = Math.min(flowamount, capacity[parent[s]][s] - flow[parent[s]][s]);
			}
			
			for(int s = end ; s!= start ; s = parent[s]) {
				// 부모 -> 자식으로 flowamount가 흐르면 자식->부모로 -flowamount가 흐른다.
				flow[parent[s]][s] +=flowamount;
				flow[s][parent[s]] -=flowamount;
			}
			res+=flowamount;
				
		}
		return res;
		
	}
}
