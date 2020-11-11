package sort;

import java.util.Arrays;

public class sort {
	public static int num[] = {0,3,2,1,4,7,6,5,8};
	
	public static void printarr(int [] arr) {
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String[] args) {

		printarr(num);
		//selectsort(num);
		//bubblesort(num);
		//insertsort(num);
		//mergesort(num, 0 , num.length-1);
		quicksort(num , 0 , num.length-1);
		printarr(num);
	}
	private static void quicksort(int[] num, int s, int e) {
		// index
		int part2 = partition(num , s , e);
		if(s < part2-1) {
			quicksort(num, s, part2-1);
		}
		if(part2 < e) {
			quicksort(num, part2, e);
		}
		
	}

	private static int partition(int[] num, int s, int e) {
		int pivot = num[(s+e)>>1];
		while(s<=e) {
			while(num[s] < pivot) s++;
			while(num[e] > pivot) e--;
			if(s<=e) {
				int t = num[s];
				num[s] = num[e];
				num[e] = t;
			} s++;e--;
		}
		return s;
	}

	private static void mergesort(int[] num, int i, int j) {
		int tmp[] = new int[num.length];
		mergesort(num, tmp , i , j);
		
	}

	private static void mergesort(int[] num, int[] tmp, int s, int e) {
		
		if(s<e) {
			int m = (s+e)>>1;
			mergesort(num,tmp,s,m);
			mergesort(num , tmp ,m+1 , e );
			merge(num , tmp , s ,m, e);
		}
	}

	private static void merge(int[] num, int[] tmp, int s, int m, int e) {
		for(int i = s ; i <= e ; i++) {
			tmp[i] = num[i];
		}
		int index = s;
		int part1 = s ;
		int part2 = m+1 ;
		while(part1 <=m && part2 <=e ) {
			if(tmp[part1] > tmp[part2]) {
				num[index] = tmp[part2++];
			} else {
				num[index] = tmp[part1++];
			}
			index++;
		}
		
		for(int i = 0 ; i <= m - part1; i++) {
			num[index+i] = tmp[part1+ i];
		}
	}

	private static void insertsort(int[] num) {
		int size = num.length;
		for(int i =1 ; i < size ; i++) {
			for(int j=0 ; j < i ; j++) {
				if(num[i] > num[j]) {
					int t = num[i];
					num[i] = num[j];
					num[j] = t;
					
				}
			}
		}
		
	}

	private static void bubblesort(int[] num2) {
		for(int i=0; i < num2.length ; i ++) {
			for(int j=0 ; j < num2.length-1 ; j++) {
				if(num2[j] > num2[j+1]) {
					int t = num2[j];
					num2[j] = num2[j+1];
					num2[j+1] = t;
				}
			}
		}
		
	}
	private static void selectsort(int[] num2) {
		int size = num2.length;
		for(int i=0; i < size ; i++) {
			for(int j =i+1 ; j < size ; j++) {
				if(num2[i] > num2[j]) {
					int t = num2[i];
					num2[i] = num2[j];
					num2[j] = t;
				}
			}
		}
		
	}
}
