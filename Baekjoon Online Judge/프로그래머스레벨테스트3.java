package 풀문제;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class 프로그래머스레벨테스트3 {

	public static void main(String[] args) {
		int test[][] = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
		int t =solution(5,test,3);
		System.out.println(t);
	}
	
	public static int solution(int N, int[][] road, int K) {
	        int answer = 0;
	        ArrayList<int []> node[];
	        node = new ArrayList[N+1];
	        for(int index = 1 ; index <= N ; index++) {node[index] = new ArrayList<int []>();}
	        boolean visit[] = new boolean[N+1];
	        ArrayDeque<int []> dq = new ArrayDeque<>();
	        int size = road.length;
	        
	        for(int index = 0 ; index < size ; index++) {node[road[index][0]].add(new int[] {road[index][1] , road[index][2]});
	        node[road[index][1]].add(new int[] {road[index][0] , road[index][2]});}
	        
	        dq.add(new int[] {1,0}); visit[1] = true;
	        
	        while(!dq.isEmpty()) {
	        	int now[] = dq.poll();
	        	int cost = now[1];
	        	int pos = now[0];
	        	if(cost > K) continue;
	        	visit[pos] = true;
	        	int nsize = node[pos].size();
	        	for(int index = 0 ; index < nsize ; index++) {
	        		if(visit[node[pos].get(index)[0]]) {
	        			continue;
	        		}
	        		dq.add(new int[] {node[pos].get(index)[0] , cost + node[pos].get(index)[1]});
	        	}
	        }
	        
	        for(int index = 1 ; index <=N;index++) {
	        	if(visit[index])answer++;
	        	System.out.print(visit[index] + " ");
	        }
	        return answer;
	    }
}
