#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;
int main(int argc, char** argv) {
	int size = 'z' + 1;
	int n[size];
	for( int index= 0 ; index <size ; index++) n[index]=0;
	string a,b;
	getline(cin, a); getline(cin , b);
	if( a.size() != b.size())cout << "NO";

	for(int index = 0; index <a.size() ; index++){
		n[char(a[index])]++;
		n[char(b[index])]--;
	}
	
	for(int index = 0; index < size ; index++){
		if(!n[index]){
			cout << "NO";
			return 0;
		}
	}
	cout << "YES";
	return 0;
}
