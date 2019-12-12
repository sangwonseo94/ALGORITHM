#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;
int main(int argc, char** argv) {
	string s; getline(cin , s);
	int cnt =0,res=0;
	
	if(s[0] == 'C' && s[1]=='H'){
		cnt=0;
	}
	else{
		for(cnt = 1 ; cnt <s.size() ; cnt++){
			if(s[cnt] == 'H') break;
		}
	}
	if( cnt == 0){
		res +=12;
		cnt++;
	}
	else{
		res = 12*stoi(s.substr(1,cnt-1));
	}
	
	if( cnt+1 == s.size() ){
		res +=1;
	}
	else{
		res += stoi(s.substr(cnt+1,s.size()-1));
	}
	
	cout << res;
	return 0;
}
