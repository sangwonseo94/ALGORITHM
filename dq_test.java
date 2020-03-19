package 푼문제;

import java.util.ArrayDeque;

public class dq_test {

	public static void main(String[] args) {
		
		ArrayDeque<Integer> Dq = new ArrayDeque<>();
		Dq.add(3);
		Dq.add(4);
		Dq.add(5);
		Dq.add(6);
		System.out.println(Dq.poll());
		System.out.println(Dq.pollFirst());
		System.out.println(Dq.pollLast());
		System.out.println(Dq.peekLast());
		System.out.println(Dq.peekFirst());
		Dq.push(7);
		Dq.push(8);
		
		System.out.println(Dq.pop());
		Dq.addLast(9);
		Dq.addFirst(10);
		System.out.println(Dq.size());
	}

	
	
}
