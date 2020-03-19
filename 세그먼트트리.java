package 풀문제;

public class 세그먼트트리 {
	static int[ ] arr =  {3, 5, 6, 7, 2, 9, 4, 5, 2, 8, 1, 5};
	static int segmenttree[];
	public static int init(int node , int start , int end) {
		if(start== end) {return segmenttree[node] = arr[end];}
		return  segmenttree[node] = init(node*2 , start , (start+end)/2) + init(node*2+1 , ((start+end)/2)+1 , end);
	}
	
	public static void update(int node , int start , int end , int index , int diff) {
		
		if(index < start || index > end) return;
		
		segmenttree[node] += diff;
		
		if(start != end) {
			int mid = (start+end)/2;
			update(node*2 , start , mid ,index , diff);
			update(node*2+1 , mid+1,end ,index , diff);
		}
	}
	public static int sum(int node , int start , int end , int left , int right) {
		if(right < start || left > end) return 0;
		else if(start >= left && end <= right) {
			return segmenttree[node];
		}
		else {
			return sum(node*2 , start , (start+end)/2 , left , right) + sum(node*2 , (start+end)/2 +1 , end , left , right);
		}
	}
	public static void main(String[] args) {
		
		segmenttree = new int[arr.length*4];
		init(0,0,arr.length-1);
		System.out.println(segmenttree[0]);
		update(0,0,arr.length-1,4,8);
		System.out.println(segmenttree[0]);
		
	}
}
