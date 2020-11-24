package 푼문제;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class pq_test {
	static class node{
		int edge, number, order;
		public node(int edge , int number , int order) {
			this.edge = edge ; this.number = number ; this.order = order;
		}
	}
	public static void main(String[] args) {
		
		PriorityQueue<node> Pq= new PriorityQueue<>( (node n1 , node n2) -> n1.edge > n2.edge ? 1 : -1 );
		Pq.add(new node(5,3,1)); Pq.add(new node(4,7,3));
		Pq.add(new node(10,20,30)); Pq.add(new node(5,4,3)); 
		
		while(!Pq.isEmpty()) {
		node now = Pq.poll();
		System.out.println(now.edge + " " + now.number +" " + now.order);
		} 
	}
	


}
