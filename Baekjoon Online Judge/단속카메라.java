package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class 단속카메라 {

	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{-20,15},{-14,-5},{-18,-13},{-5,-3},{7,10},{7,5}}));
	}

	
	 public static int solution(int[][] routes) {
	        int answer = 1;
	        ArrayList<int[]> al = new ArrayList<>();
	        int size = routes.length;

	        for(int i = 0 ; i < size ; i++) al.add(routes[i]);
	        Collections.sort(al, new Comparator<int[]>() {
	        	@Override
	        	public int compare(int[] o1, int[] o2) {
	        		 return o1[0]-o2[0];
	        	}
			});
	        int CoverMax =  al.get(0)[1];
	        int CoverMin =  al.get(0)[0];
	        int LocalMax = 0;
            int LocalMin = 0;
	        for(int i = 1 ; i < size; i++) {
	        	if(al.get(i)[1] < CoverMax) {
	        		CoverMax = al.get(i)[1];
	        	} else if(al.get(i)[0] > CoverMax) {
	        		CoverMax = al.get(i)[1];
	        		answer++;
	        	}
	        }
	        return answer;
	    }
}
