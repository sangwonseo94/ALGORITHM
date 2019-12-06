#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;

int main(int argc, char** argv) {
	int start, end;
	cin >> start >> end;
	int result = 0;
	for (int i = start ; i <= end ; i++ ){
		result +=i ;
		
		if(i != end){
			cout << i << "+";
		}
		else if( i == end){
			cout << i << "="<< result;
		}
		
	}
	
	return 0;
}
