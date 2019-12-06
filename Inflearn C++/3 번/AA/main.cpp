#include <iostream>
#include <vector>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;
vector<int> numbers; 
int main(int argc, char** argv) {
	int n, sum = 0 ; cin >> n;
	
	for (int i = 1 ; i <= n ; i ++){
		if(i==n) break;
		if ( n % i == 0){
			numbers.push_back(i);
			sum += i;
		}
	}
	for (int index = 0 ; index < numbers.size() ; index ++){
		if(index == ( numbers.size() -1 ) ){
			break;
		}	
		else {
			cout << numbers[index] << " + " ; 
		}
	}
	cout << numbers[numbers.size()-1] <<" = " << sum ; 
	return 0;
}
