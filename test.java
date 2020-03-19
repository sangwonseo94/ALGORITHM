package 푼문제;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class test {
	static class coo {
		int y, x;
		public coo(int y , int x) {
			this.y = y;
			this.x = x;
		}
	}
	public static void main(String[] args) throws Exception{
	Scanner sc = new Scanner(System.in);
	ArrayList<Integer> list[] = (ArrayList<Integer>[])new ArrayList[10001];
	LinkedList<Integer> list2[];
	ArrayDeque<Integer> dq;
	HashMap<String, Integer> hm;
	HashSet<Integer> hs;
	//PriorityQueue<coo> pq = new PriorityQueue<>(0, (coo c1 , coo c2)-> c1.x > c2.x ? 1 : -1);
	
	PriorityQueue<Integer> pq2 = new PriorityQueue<>((Integer num1 , Integer num2 ) ->  num1 > num2 ? 1 : -1 );
	pq2.add(3);
	pq2.add(1);
	pq2.add(0);
	pq2.add(9);
	pq2.add(2);
	System.out.println(pq2.poll());
	System.out.println(pq2.poll());
	System.out.println(pq2.poll());
	System.out.println(pq2.poll());
	System.out.println(pq2.poll());
	}

}
