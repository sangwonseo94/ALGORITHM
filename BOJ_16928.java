package algorithm_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_16928 {

	public static void main(String[] args) throws IOException {
	   BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       int N = Integer.parseInt(st.nextToken()); 
       int M = Integer.parseInt(st.nextToken());
       int max = 987654321;
       int time [] = new int[101];
       int up   [] = new int[101];
       int down [] = new int[101];
       for(int i=1;i<101;i++) time[i] = max;
       
       for(int i=0;i<N;i++) {
    	   st = new StringTokenizer(br.readLine());
    	   int index =  Integer.parseInt(st.nextToken());
    	   int tar   =  Integer.parseInt(st.nextToken());
    	   up[ index ] = tar ;
    	}
       for(int i=0;i<M;i++) {
    	   st = new StringTokenizer(br.readLine());
    	   int index =  Integer.parseInt(st.nextToken());
    	   int tar   =  Integer.parseInt(st.nextToken());
    	   down[ index ] = tar ;
       }
       
       int answer = max;
       ArrayDeque<int []> dq = new ArrayDeque<>(); // 1좌표 , 2횟수
       dq.add(new int[] {1,0});
       while(!dq.isEmpty()) {
    	   int now[] = dq.poll();
    	      for(int i=1;i<=6;i++) {
                	int next = now[0]+i ;
                	if(next>=101) continue;
                	if(up[next]!=0) {next = up[next];}
                	if(down[next]!=0) {next = down[next];}
                	if(time[next] >=now[1]+1) {
                		time[next] =now[1]+1;
                		if(next==100) {
                			answer = answer > now[1]+1 ? now[1]+1 : answer;
                		}
                		dq.add(new int[] {next, now[1]+1});
                	}
                }
    	   
    	}
        System.out.println(answer);
	}
}
