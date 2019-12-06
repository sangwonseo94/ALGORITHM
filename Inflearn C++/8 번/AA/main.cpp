#include <iostream>
#include <string>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;
int main(int argc, char** argv) {
	string s;
	getline(cin , s);
	int count=0;
	for(int index = 0; index < s.size() ; index ++){
			if(char(s[index]) =='('){
				count++;
			}
			else if( char(s[index]) ==')'){
				count--;
				if(count <0)break;
			}	
			else continue;
	}
	if(!count) cout<<"YES\n";
	else cout<<"NO\n";
	return 0;
}
