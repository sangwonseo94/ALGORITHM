#include <iostream>
#include <string>
#include <vector>
#include <cmath>
#include <string>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;
int main(int argc, char** argv) {
	string s; int res =0, count=0;
	getline(cin, s);
	for (int index = 0; index < s.size() ; index ++){
		
		if(s[index] > '0' && s[index] <'9'){
			res = 10*res + (s[index] -'0');
		}
	}
	cout << res <<"\n";
	for(int index = 1 ; index <=res ; index++){
		if( res%index == 0 ) count++;
	}
	
	cout << count;
}
