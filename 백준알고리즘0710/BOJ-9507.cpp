#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
vector<long long> vec(70,0);

long long compute(long long x){
	if(x ==0){return 1;}
	if(x ==1){return 1;}
	if(x ==2){return 2;}
	if(x ==3){return 4;}
	if(vec[x]!=0)return vec[x];
	if(vec[x]==0)return vec[x] =(compute(x-1)+compute(x-2)+compute(x-3)+compute(x-4));
}


int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int testcase ;
	cin >> testcase;
	while(testcase){
	int temp; cin >> temp;
		cout << compute(temp) <<"\n";
	testcase--;
	}
	
	return 0;
}