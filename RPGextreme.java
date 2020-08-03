package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class RPGExtreme {
	private static int n =0, m =0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 n = Integer.parseInt(st.nextToken());
		 m = Integer.parseInt(st.nextToken());
		 String dyingMessage ="";
		int starty =0 , startx =0;
		char map[][] = new char[n+1][m+1];
		for(int i = 1 ; i <= n ; i ++) {
			String temp = br.readLine();
			for(int j = 1 ; j <= m ; j++) {
				map[i][j] = temp.charAt(j-1);
				if(map[i][j]=='@') {
					starty=i;
					startx=j;
					map[i][j]='.';
				}
			}
		}
		int monster_index = 1;
		int item_index = 1;
		ArrayList<String> monster_name = new ArrayList<>();
		ArrayList<int[]> monster_info = new ArrayList<>();
		ArrayList<String> item_name = new ArrayList<>();
		ArrayList<String> item_info = new ArrayList<>();
 		int monsterMap[][] = new int[n+1][m+1];
		int itemMap[][] = new int[n+1][m+1];
		char move[] = br.readLine().toCharArray();
		String line = null;
		while( (line = br.readLine()) != null) {
			String info[] = line.split(" ");
			int size = info.length;
			if(size == 7) {
				monsterMap[Integer.parseInt(info[0])][Integer.parseInt(info[1])] = monster_index ;
				monster_index++;
				monster_name.add(info[2]);
				monster_info.add(new int[] {Integer.parseInt(info[3]) ,Integer.parseInt(info[4]) ,Integer.parseInt(info[5]) ,Integer.parseInt(info[6]) });
			} else if(size ==4) {
				itemMap[Integer.parseInt(info[0])][Integer.parseInt(info[1])] = item_index;
				item_index++;
				item_name.add(info[2]);
				item_info.add(info[3]);
			} else {
				break;
			}
		}
		// end of input
		int movesize = move.length;
		int posy = starty;
		int posx = startx;
		int hp = 20;
		int maxhp = 20;
		int attack_point = 2;
		int defence_point = 2;
		int add_attack_pointby_W =0;
		int add_defence_pointby_A =0;
		int need_exp = 5;
		int level = 1;
		int now_exp = 0;
		int nposy = 0 , nposx = 0;
		boolean clearBoss = false;
		boolean die = false;
		ArrayList<String> item = new ArrayList<>();
		int i= 0;
		top :
		for(  ; i < movesize ; i++) {
			char mover = move[i];
			if(mover=='R') {
				nposy = posy; nposx = posx +1;
			} else if(mover=='L') {
				nposy = posy; nposx = posx -1;
			} else if(mover=='D') {
				nposy = posy +1; nposx = posx ;
			} else if(mover=='U') {
				nposy = posy-1; nposx = posx ;
			} else {
				nposy = posy; nposx = posx ;
			}
			
			if(OutRange(nposy,nposx) || map[nposy][nposx] =='#'  ) {
				nposy = posy;
				nposx = posx;
			}
			posy = nposy; posx = nposx;
			
			if(map[posy][posx] =='.') {
				continue;
			} else if(map[posy][posx] =='^') {
				if(item.contains("DX")) {
					hp-=1;
				} else {
					hp-=5;
				}
				if(hp <=0) {
					if(item.contains("RE")) {
						posy = starty;
						posx = startx;
						hp =maxhp;
						item.remove("RE");
						continue;
					}
					i++;
					hp =0;
					die = true;
					dyingMessage="SPIKE TRAP";
					break top;
				}
			} else if(map[posy][posx] =='B') {
				
				int index = itemMap[posy][posx];
				index-=1;
				
				String itemName = item_name.get(index);
				if(itemName.equals("W")){
					add_attack_pointby_W = Integer.parseInt(item_info.get(index));
				} else if(itemName.equals("A")) {
					add_defence_pointby_A = Integer.parseInt(item_info.get(index));
				} else if(itemName.equals("O")){
					if(item.size()<4) {
						if(!item.contains(item_info.get(index))) {
							item.add(item_info.get(index));
						}
					}
				}
				map[posy][posx] ='.';
				
			} else if(map[posy][posx] =='&'||map[posy][posx] =='M') {
				
				int monsterindex = monsterMap[posy][posx];
				monsterindex-=1;
				
				 
					String monsterName = monster_name.get(monsterindex);
					int monsterinfo[] = monster_info.get(monsterindex);
					int monsterAtt= monsterinfo[0];
					int monsterDef= monsterinfo[1];
					int monsterHp=  monsterinfo[2];
					int monsterExp= monsterinfo[3];
					// fight
					for(int step = 1;;step++) {
						// user first
					
						int mul = 1;
						if(step==1 &&item.contains("CO")) {
							 mul = 2;
							if(item.contains("DX")) {
								mul= 3;
							}
						}
						int userdemage = (attack_point + add_attack_pointby_W)*mul - monsterDef;
						if(userdemage <=1) userdemage=1;
						monsterHp -= userdemage;
						if(monsterHp <=0) {
							// monster die
							
							if(item.contains("EX")) {
								monsterExp = (int) (monsterExp* 1.2);
							}
							now_exp+=monsterExp;
							if(now_exp >= need_exp) {
								now_exp =0;
								level++;
								need_exp +=5;
								maxhp +=5;
								defence_point+=2;
								attack_point +=2;
								hp =maxhp;
							}
							if(item.contains("HR")) {
								hp = hp+3 > maxhp ? maxhp : hp+3;
							}
							if(map[posy][posx] =='M') {
								map[posy][posx] ='@';
								clearBoss = true;
								i++;
								break top;
							}
							map[posy][posx]='.';
							break;
						}
						
						int mondemage = monsterAtt - (defence_point+add_defence_pointby_A);
						if(mondemage <=1) mondemage =1;
						if(map[posy][posx] =='M' &&item.contains("HU")&&step==1) {
							hp = maxhp;
							mondemage=0;
						}
						hp -= mondemage;
						if(hp <=0) {
							// user die
							if(item.contains("RE")) {
								hp = maxhp;
								item.remove("RE");
								posx = startx;
								posy = starty;
								break;
							} else {
								hp=0;
								dyingMessage= monsterName;
								i++;
								die = true;
								break top;
							}
						}
					}
			}
		}
	
		if(i == movesize && !clearBoss && !die) {
			map[posy][posx] ='@';
		}
		StringBuilder sb = new StringBuilder();
		for(int k = 1 ; k <=n ; k ++) {
			for(int j = 1 ; j <= m ; j++) {
				sb.append(map[k][j]);
			}
			sb.append("\n");
		}
		
		sb.append("Passed Turns : "+ i+"\n");
		sb.append("LV : " +level +"\n");
		sb.append("HP : "+ hp+"/"+maxhp+"\n");
		sb.append("ATT : " + attack_point+"+"+add_attack_pointby_W+'\n');
		sb.append("DEF : " + defence_point+"+"+add_defence_pointby_A+'\n');
		sb.append("EXP : " + now_exp+"/"+need_exp+'\n');
		if(dyingMessage.equals("")) {
			if(clearBoss) {
				sb.append("YOU WIN!\n");
			} else {
				sb.append("Press any key to continue.\n");
			}
		} else {
			sb.append("YOU HAVE BEEN KILLED BY "+dyingMessage+"..\n");
		}
		System.out.print(sb);
	}

	private static boolean OutRange(int nposy, int nposx) {
		return !(nposy > 0 && nposx>0 && nposy <=n && nposx <=m);
	}
}
