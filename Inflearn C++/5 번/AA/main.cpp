#include <iostream>
#include <string>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;
int main(int argc, char** argv) {

	
	string s;
	getline(cin, s);
	int age, year;
	if(s[7] =='1' || s[7] == '2'){
		age = 2020 - (1900 + (s[0] -'0')*10 +(s[1]-'0'));	
	}
	else {
		age = 2020- (2000 + (  (s[0] -'0')*10 +(s[1]-'0') ));
	}
	
	cout << age; 
	if(s[7] =='1' || s[7] =='3'){
		cout << " M";
	}

	else{
		cout << " W";
	}
	return 0;
}
