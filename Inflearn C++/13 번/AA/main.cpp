#include <iostream>
#include <string>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;

int main(int argc, char** argv) {
	char num[10]={0,};
	string s;
	int max = -1, res;
	getline(cin,s);
	for (int index = 0 ; index < s.size(); index ++){
		num[char(s[index])-'0']++;
	}
	for (int index = 0; index <10; index++){
		if(num[index] >=max){
			max = num[index];
			res = index;
		}
	}
	cout << res;
	return 0;
}
