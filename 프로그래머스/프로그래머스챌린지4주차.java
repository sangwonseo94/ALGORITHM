package 알고리즘공부;

import java.util.Comparator;
import java.util.PriorityQueue;

import 푼문제.pq_test;

public class 프로그래머스챌린지4주차 {

	public static void main(String[] args) {
	System.out.println(
		solution(
				
				new String[]{"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"},
				new String[]{"PYTHON", "C++", "SQL"},
				new int[] {7, 5, 5}
		)
		
			);
		
	}
	
    public static String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        int max = -1;
        int score[] = new int[6];
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
        	@Override
        	public int compare(String o1, String o2) {
        		return o1.compareTo(o2);
        	}
		});
        for(int i=0;i<table.length;i++) {
        	String str[] = table[i].split(" ");
        	for(int j =1;j < str.length;j++ ) {
        		for(int k=0;k<languages.length;k++) {
        			if(str[j].equals(languages[k])) {
        				score[i] += ((6-j)*preference[k]);
        			}
        		}
        	}
        	max = max > score[i] ? max : score[i];
       }
       for(int i=0;i<table.length;i++) {
    	   if(max==score[i]) {
    		   pq.add(table[i].split(" ")[0]);
    	   }
       }
       
        
        return pq.peek();
    }
}
