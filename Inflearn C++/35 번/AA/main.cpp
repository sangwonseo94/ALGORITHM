#include <iostream>
#include <vector>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;
int main(int argc, char** argv) {
	int N; cin >> N;
	int num[100];
	for(int i =0 ; i <N ; i++){
		cin >> num[i];
	}
	vector<int> res;
	for(int i =0 ; i <N ; i++){
		if(num[i] < 0){
			res.push_back(num[i]);
		}
	}
	
	for(int i =0 ; i <N ; i++){
		if(num[i] > 0){
			res.push_back(num[i]);
		}
	}
	
	for(int k : res) cout << k << " ";
	
	return 0;
}
