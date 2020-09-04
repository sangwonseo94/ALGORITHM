package algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class 기능개발 {

	public static void main(String[] args) {
		System.out.println(
				Arrays.toString(
		solution(new int[] {95} , new int[] {4})
		)
				);
	}
	  public static int[] solution(int[] progresses, int[] speeds) {
	        int[] answer;
	        ArrayList<Integer> ans = new ArrayList<>();
	        ArrayList<Integer> n = new ArrayList<>();
	        int index = -1;
	        for(int i  = 0 ; i < progresses.length; i++) {
	        	int cday = (int) Math.ceil( (100 - progresses[i]) / (double)speeds[i]);
	        	if(n.size()==0) {
	        		n.add(cday);
	        		index = 0;
	        	} else {
	        		int tail = n.get(index);
	        		if(cday <= tail) {
	        			n.add(n.get(index));
	        		} else {
	        			n.add(cday);
	        			index++;
	        		}
	        	}
	        }
	        index = -1;
	        for(int i = 0 ; i < n.size() ; i ++) {
	        	if(ans.size()==0) {
	        		ans.add(1);
	        		index = i;
	        	} else {
	        		if(n.get(i) == n.get(index)) {
	        			int t =  ans.get(ans.size()-1)+1;
	        			ans.remove(ans.size()-1);
	        			ans.add(t);
	        		} else {
	        			ans.add(1);
	        			index = i;
	        		}
	        	}
	        }
	        answer = new int[ans.size()];
	        for(int i = 0 ; i < ans.size() ; i ++) {
	        	answer[i] = ans.get(i);
	        }
	        return answer;
	    }
}
