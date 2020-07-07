package 카카오;

import java.util.HashMap;

public class 키패드누르기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[] {7,0,8,2,8,3,1,5,7,6,2} , "lgg"));
	}
	
	    public static String solution(int[] numbers, String hand) {
	        String answer = "";
	        HashMap<Integer, int []> hm = new HashMap<>();
	        hm.put(0, new int[] {3,1});
	        hm.put(1, new int[] {0,0});
	        hm.put(2, new int[] {0,1});
	        hm.put(3, new int[] {0,2});
	        hm.put(4, new int[] {1,0});
	        hm.put(5, new int[] {1,1});
	        hm.put(6, new int[] {1,2});
	        hm.put(7, new int[] {2,0});
	        hm.put(8, new int[] {2,1});
	        hm.put(9, new int[] {2,2});
	        int lx=0,ly=3,rx=2,ry=3;
	        for(int i = 0 ; i < numbers.length ; i++) {
	        	int [] now = hm.get(numbers[i]);
	        	if(now[1] ==0) {
	        		answer +="L";
	        		lx = now[1];
	        		ly = now[0];
	        	} else if(now[1] ==2) {
	        		answer +="R";
	        		rx = now[1];
	        		ry = now[0];
	        		
	        	} else {
	        		// 거리계산
	        		if(Math.abs(lx - now[1]) + Math.abs(ly - now[0]) >  Math.abs(rx - now[1]) + Math.abs(ry - now[0]) ) {
	        			// 오른쪽이 가까운경우
	        			rx = now[1]; ry = now[0];
	        			answer +="R";
	        		} else if( Math.abs(lx - now[1]) + Math.abs(ly - now[0]) <  Math.abs(rx - now[1]) + Math.abs(ry - now[0]) ) {
	        			lx = now[1]; ly = now[0];
	        			answer +="L";
	        		} else {
	        			// same
	        			char t = Character.toUpperCase(hand.charAt(0));
	        			if(t == 'R') {
	        				rx = now[1] ; ry = now[0];
	        			} else {
	        				lx = now[1] ; ly = now[0];
	        			}
	        			answer += t;
	        		}
	        	}
	        }
	        
	        return answer;
	    }
	
}
