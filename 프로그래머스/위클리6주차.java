package 프로그래머스위클리;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 위클리6주차 {
	 static class boxer {
		 double rate = 0;
		 int overCnt = 0;
		 int weight =0 ;
		 int number =0;
		
		 public boxer(double rate, int overCnt, int weight, int number) {
			this.rate = rate;
			this.overCnt = overCnt;
			this.weight = weight;
			this.number = number;
		 }
	}
	 
	 public static PriorityQueue<boxer> pq = new PriorityQueue<>(new Comparator<boxer>() {
		@Override
		public int compare(boxer o1, boxer o2) {
			if(o1.rate > o2.rate) {
				return 1;
			} else if(o1.rate < o2.rate) {
				return -1;
			} else {
				if(o1.overCnt > o2.overCnt) {
					return 1;
				} else if(o1.overCnt < o2.overCnt) {
					return -1;
				} else {
					if(o1.weight > o2.weight) {
						return 1;
					} else if(o1.weight < o2.weight) {
						return -1;
					} else {
						if(o1.number > o2.number) {
							return 1;
						} else if(o1.number < o2.number) {
							return -1;
						} else {
							return 0;
						}
					}
				}
			}
		}
	 });
			 
	 public static int[] solution(int[] weights, String[] head2head) {
		    int size = weights.length;
	        int[] answer = new int[size];
	        for(int i=0;i<size;i++) {
	        	int cnt = 0;
	        	int weight = weights[i];
	        	int now = i+1;
	        	int Overcnt = 0;
	        	int wins= 0;
	        	String str= head2head[i];
	        	for(int j=0;j<str.length();j++) {
	        		char result = str.charAt(j);
	        		if(result == 'N') {
	        			continue;
	        		} else if(result == 'L') {
	        			cnt++;
	        		} else {
	        			if(weights[j] > weight) {
	        				Overcnt++;
	        			}
	        			cnt++;
	        			wins++;
	        		}
	        	}
	        	
	        	double rate = (wins)/(double)cnt;
	        	pq.add(new boxer(rate, Overcnt, weight, now));
	        }
	       
	        while(!pq.isEmpty()) {answer[--size] = pq.poll().number; }
	        System.out.println(Arrays.toString(answer));
	        return answer;
	}
	 public static void main(String[] args) {
		
		solution(new int[] {50,82,75,120}, new String[] {"NLWL","WNLL","LWNW","WWLN"});
	}
}
