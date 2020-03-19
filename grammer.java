package 푼문제;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class grammer {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> st=new Stack<Integer>(); 
		Deque<Integer> dq = new ArrayDeque<Integer>();
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		int x = queue.element();
		System.out.println(queue);
	}

}


