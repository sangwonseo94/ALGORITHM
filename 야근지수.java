package 풀문제;

import java.util.Arrays;
import java.util.Comparator;

public class 야근지수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(4,new int[] {4,3,3}));
		System.out.println(solution(1,new int[] {2,1,2}));
		System.out.println(solution(3,new int[] {1,1}));
	}
	 static public long solution(int n, int[] works) {
	        long answer = 0;
	        long sum = 0;
	        for (int i : works) {sum+=i;}
	        if(sum <= n) return 0;
	        long avg = sum / works.length;
	        Arrays.sort(works);
	        int size = works.length-1;
	        for(;size >=0 && n > 0 ; size--) {
	        	if(works[size] > avg) {
	        		if(works[size] - avg <= n) {
	        			// 한번에 뺴는게 가능하다면,
	        			 n-= (works[size] - avg);
	        			 works[size] = (int)avg;
	        		} else {
	        			while(n > 0) {
	        				n--;
	        				works[size]--;
	        			}
	        		}
	        	} else break;
	        }
	        while(n>0) {
	        	for(int i = works.length-1 ; i >=0 ; i--) {
	        		works[i]--;
	        		n--;
	        		if(n ==0) break;
	        	}
	        }
	        for (int i : works) {
				answer += (i*i);
			}
	        return answer;
	 }
}
