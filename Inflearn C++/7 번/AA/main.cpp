#include <iostream>
#include <string>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;
int main(int argc, char** argv) {
	//freopen("input.txt","rt",stdin);
	string s;
	getline(cin,s);
	int differ= 'a'-'A';
	for(int index = 0; index<s.size() ; index++){
		if(s[index]==' ')continue;
		else if('a' <= s[index] && s[index] <='z'){
			cout<< char(s[index]);
		}
		else if('A' <= s[index] && s[index] <= 'Z'){
			cout<< char(s[index]+differ);
		}
		else continue;
	}
	
	return 0;
}
