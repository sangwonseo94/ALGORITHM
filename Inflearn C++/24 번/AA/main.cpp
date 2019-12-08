#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;
int main(int argc, char** argv) {
	vector <int> num;
	int N,pre; cin >> N;
	for ( int index =0 ; index < N ; index++){
		if(index == 0){
			cin >> pre;
		}
		else {
			int temp; cin>> temp;
			num.push_back(abs(pre-temp));
			if(abs(pre-temp) > (N)){
				cout  << "NO";
				return 0;
			}
			pre =temp;
		}
	}
	if(num.size() != (N-1)){
		cout  << "NO";
		return 0;
	}
	sort(num.begin() , num.end());
	for ( int index = 1;  index < N ; index++){
		
		if( index  != num[index-1] ) {
			cout  << "NO";
			return 0;
		}
	}
	cout << "YES";
	
	return 0;
}
