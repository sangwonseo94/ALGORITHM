package algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class test {
	public static void main(String[] args) {
	
		Stack<Integer> s[] = new Stack[10];
		PriorityQueue<Stack<Integer>> pq  = new PriorityQueue<>(new Comparator<Stack<Integer>>() {
			@Override
			public int compare(Stack o1, Stack o2) {
				return o1.peek() - o2.peek();
			}
		});
		
	}
}
