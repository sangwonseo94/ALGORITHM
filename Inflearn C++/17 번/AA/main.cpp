#include <iostream>
#include <string>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;
int main(int argc, char** argv) {
	int N; cin >> N;
	string st[10];
	for( int index = 0; index < N ; index++){
		int stud,num; cin>>stud >>num;
		int res =0;
		for ( int i=1 ; i<=stud ; i++){
			res += i;
		}
		if(res == num) st[index] = "YES";
		else st[index] = "NO";
	}
	for(int index = 0 ; index < N; index++){
		cout <<st[index] << "\n";
	}

	return 0;
}
