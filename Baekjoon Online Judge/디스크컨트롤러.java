package algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 디스크컨트롤러 {

	
  public static int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<int []> pq = new PriorityQueue<>(new Comparator<int []>() {
        	@Override
        	public int compare(int[] o1, int[] o2) {
        		return o1[1]-o2[1];
        	}
		});
        
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{0,3},{1,9},{2,6}}));
	}

}
