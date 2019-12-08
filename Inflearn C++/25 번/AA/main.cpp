#include <iostream>
#include <vector>
#include <algorithm>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;
int main(int argc, char** argv) {
	int n ; cin >> n;
	vector <int> num;
	for( int index = 0 ; index <n ; index++){
		int temp; cin >> temp;
		num.push_back(temp); 
	}	
	for( int i = 0 ; i < n ; i ++){
		int record_num = 1;
		
		for ( int j = 0 ; j < n ; j ++){
			if (num[i] < num[j]){
				record_num+=1;
			}
		}
		cout << record_num << " ";
	}
	
	return 0;
}
