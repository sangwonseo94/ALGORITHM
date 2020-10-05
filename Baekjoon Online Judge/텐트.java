package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class 텐트 {

	public static void main(String[] args) throws Exception {

		System.out.println(solution(4, new int[][] { {0,0},{1,1},{2,0},{0,2}}));
		System.out.println(solution(4, new int[][] { {0,0},{5,5},{10,0},{0,10}}));
	}
	
	  public static int solution(int n, int[][] data) {
	        int answer = 0;
	        int size = data.length;
	        ArrayList<Integer> x = new ArrayList<>();
	        ArrayList<Integer> y = new ArrayList<>();
	        HashMap<Integer, Integer> xco = new HashMap<>();
	        HashMap<Integer, Integer> yco = new HashMap<>();
	        for(int i = 0 ; i < size ; i++) {
	        	x.add(data[i][0]);
	        	y.add(data[i][1]);
	        }
	        
	        Collections.sort(x);
	        Collections.sort(y);
	        for(int i = 0 ; i < size ; i ++) {
	        	xco.put(x.get(i), i);
	        	yco.put(y.get(i), i);
	        }
	        int newdata[][] = new int[size][2];
	        for(int i = 0 ; i < size ; i++) {
	        	newdata[i][0] = xco.get(data[i][0]);
	        	newdata[i][1] = yco.get(data[i][1]);
	        }
	        
	        return answer;
	    }
}
