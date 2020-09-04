package 풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class pokergame {
	public static ArrayList<Character> card = new ArrayList<>();
	public static ArrayList<Character> number = new ArrayList<>();
	public static char ranks[] ={ 'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
	public static ArrayList<Character> rank = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int t= Integer.parseInt(st.nextToken());
		for(int tc=1;tc<=t;tc++) {
			String []temp = br.readLine().split(" ");
			for(int i = 0 ; i < 5 ; i++) {
				card.add(temp[i].charAt(0));
				number.add(temp[i].charAt(1));
			}
			for(int i = 0 ; i < ranks.length ; i ++) {rank.add(ranks[i]);}
			
			if(sf()) {
				sb.append("#"+tc+" Straight Flush\n");
			} else if(four()) {
				sb.append("#"+tc+" Four of a Kind\n");
			} else if(full()) {
				sb.append("#"+tc+" Full House\n");
			} else if(flush()) {
				sb.append("#"+tc+" Flush\n");
			} else if(straight()) {
				sb.append("#"+tc+" Straight\n");
			} else if(triple()) {
				sb.append("#"+tc+" Three of a kind\n");
			} else if(twopair()) {
				sb.append("#"+tc+" Two pair\n");
			} else if(onepair()) {
				sb.append("#"+tc+" One pair\n");
			} else {
				sb.append("#"+tc+" High card\n");
			} card.clear();number.clear();rank.clear();
		}System.out.println(sb);
		
	}
	private static boolean onepair() {
		char c1 = number.get(0),c2='z',c3='z',c4='z';
		int n1=0,n2=0,n3=0,n4=0;
		for(int i=1;i<5;i++) {
			if(c2 =='z' && c1 != number.get(i)) {
				c2 = number.get(i);
			}
			else if(c2 !='z' && c3=='z' && c1 != number.get(i) &&c2 !=number.get(i)) {
				c3 =number.get(i);
			} 
			else if(c4=='z' && c3 !='z' && c2 !='z' && c1 != number.get(i) &&c2 !=number.get(i) &&c3 !=number.get(i)) {
				c4 =number.get(i);
			}
		}
		for(int i=0;i<5;i++) {
			if(c1 == number.get(i)) n1++;
			if(c2 == number.get(i)) n2++;
			if(c3 == number.get(i)) n3++;
			if(c4 == number.get(i)) n4++;
			
		}
		if((n1==2 && n2 ==1 && n3==1 && n4==1) || (n1==1 && n2 ==2 && n3==1 && n4==1) || (n1==1 && n2 ==1 && n3==2 && n4==1) || (n1==1 && n2 ==1 && n3==1 && n4==2)) return true;
		return false;
	}
	private static boolean twopair() {
		char c1 = number.get(0),c2='z',c3='z';
		int n1=0,n2=0,n3=0;
		for(int i=1;i<5;i++) {
			if(c2 =='z' && c1 != number.get(i)) {
				c2 = number.get(i);
			}
			else if(c3=='z' && c2 !='z' && c1 != number.get(i) && c2!=number.get(i)) {
				c3 =number.get(i);
			}
		}
		for(int i=0;i<5;i++) {
			if(c1 == number.get(i)) n1++;
			if(c2 == number.get(i)) n2++;
			if(c3 == number.get(i)) n3++;
		}
		if((n1==2 && n2 ==2 && n3==1) || (n1==1 && n2==2 && n3==2) || (n1==2 && n2==1 &&n3==2)) return true;
		return false;
	}
	private static boolean straight() {
		int startidx=15;
		top :
			for(int i = 0 ; i < rank.size();i++) {
				for(int j = 0 ; j < 5 ; j++) {
					if(rank.get(i) == number.get(j)) {
						startidx = i;
						break top;
					}
				}
			}
			
			for(int i = 0 ; i < 5 ; i++) {
				char c = rank.get(startidx+i);
				if(number.contains(c)) continue;
				else return false;
			}
			return true;
		
	}
	private static boolean triple() {
		char c1 = number.get(0),c2='z',c3='z';
		int n1=0,n2=0,n3=0;
		for(int i=1;i<5;i++) {
			if(c2 =='z' && c1 != number.get(i)) {
				c2 = number.get(i);
			}
			else if(c3=='z'&&c2 !='z' && c1 != number.get(i) && c2 !=number.get(i)) {
				c3 =number.get(i);
			}
		}
		for(int i=0;i<5;i++) {
			if(c1 == number.get(i)) n1++;
			if(c2 == number.get(i)) n2++;
			if(c3 == number.get(i)) n3++;
			
		}
		if((n1==3 && n2 ==1 && n3==1)|| (n1==1 && n2 ==3 && n3==1)|| (n1==1 && n2 ==1 && n3==3)) return true;
		return false;
	}
	private static boolean flush() {
		char c = card.get(0);
		for(int i = 0 ; i < 5 ; i++) {
			if(c !=card.get(i)) return false;
		}
		return true;
	}
	private static boolean full() {
		char c1 = number.get(0),c2='Z';
		int n=0,m=0;
		for(int i=1;i<5;i++) {
			if(c1 !=number.get(i) && c2=='Z'){
				c2 = number.get(i);
			}
		}
		for(int i = 0 ; i < 5 ; i++) {
			if(c1 == number.get(i)) n++;
			if(c2 ==number.get(i))  m++;
		}
		if((n==3 && m==2) || (m==3 && n==2)) return true;
		return false;
	}
	private static boolean four() {
		char c1 = number.get(0),c2 ='z';
		int n1=0,n2=0;
		for(int i=1;i<5;i++) {
			if(c1 != number.get(i) && c2=='z') c2=number.get(i);
		}
		for(int i=0;i<5;i++) {
			if(c1 == number.get(i)) n1++;
			if(c2 == number.get(i)) n2++;
		}
		if((n1==4 && n2==1) || (n1==1 && n2==4)) return true;
		return false;
	}
	private static boolean sf() {
		char c = card.get(0);
		boolean b = true;
		for(int i = 1 ; i < 5; i++) {
			if(c != card.get(i)) return false;
		}
		int startidx=15;
		top :
			for(int i = 0 ; i < rank.size();i++) {
				for(int j = 0 ; j < 5 ; j++) {
					if(rank.get(i) == number.get(j)) {
						startidx = i;
						break top;
					}
				}
			}
			
			for(int i = 0 ; i < 5 ; i++) {
				 c = rank.get(startidx+i);
				if(number.contains(c)) continue;
				else b = false;
			}
			if(!b) {
				b=true;
				int arr[] = new int[5];
				for(int i = 0 ; i < 5 ; i++) {
					c= number.get(i);
					if(c=='A') {
						arr[0]++;
					}else if(c=='T') {
						arr[1]++;
					}else if(c=='J') {
						arr[2]++;
					}else if(c=='Q') {
						arr[3]++;
					}else if(c=='K') {
						arr[4]++;
					}
				}
				for (int i : arr) {
					if(i != 1) return b=false;
				}
			}
			return b;
			
		
		
		
	}

}
