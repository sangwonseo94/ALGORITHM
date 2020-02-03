package practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class pos{
	int index;
	int prior;
	pos(int index , int prior){
		this.index = index;
		this.prior = prior;
	}
}

public class PrintQueue {
	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		int tc= sc.nextInt();
		while(tc > 0) {
			int size = sc.nextInt();
			int want = sc.nextInt();
			int step = 0;
			ArrayList<pos> arr = new ArrayList<pos>();
			
			for(int index = 0 ; index < size ; index++) {
				int p = sc.nextInt();
				arr.add(new pos(index ,p));
			}
			boolean com = false;
			pos now = arr.get(0);
			if(arr.size() == 1) {
				step=1;
				tc--;
				System.out.println(step);
			}
			else {
				while(true) {
					
					for(int index = 1; index < arr.size() ; index++) {
						int nowp = arr.get(index).prior;
						if(nowp > now.prior) {
							pos temp = arr.get(0);
							arr.remove(0);
							arr.add(temp);
							com = true;
							break;
						}
							
					}
					if(!com) {
						step++;
						if(arr.get(0).index == want) break;
						arr.remove(0);
						
					}
					
					now = arr.get(0);
					com = false;
				}
				System.out.println(step);
				tc--;
			}
		}
		
	}

}
