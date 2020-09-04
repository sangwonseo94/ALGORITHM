package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_가운데를말해요 {

	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		for(int index = 0 ; index < n ; index++) {
			st = new StringTokenizer(br.readLine());
			pq.add(Integer.parseInt(st.nextToken()));
			sb.append(pq.toArray()[index/2] + "\n");
		}
		System.out.println(sb);
	}
}


//1,new Comparator<Integer>() {
//	public int compare(Integer num1 , Integer num2) {
//		if( num1 < num2) return -1;
//		else if(num1 == num2) return 0;
//		else return 1;
//	}
//}