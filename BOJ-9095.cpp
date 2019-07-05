#include <iostream>
#include <vector>
using namespace std;
vector<int> memo(100);
int how_many(int x){
	if(x==1) return memo[1];
	if(x==2) return memo[2];
	if(x==3) return memo[3];
	else return memo[x] = how_many(x-1)+how_many(x-2)+how_many(x-3);
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);cout.tie(NULL);
	memo[1] = 1;
	memo[2] = 2;
	memo[3] = 4;
	int testcase,x;
	cin>>testcase;
	while(testcase){
		int sum ;
		cin >> x ;
		sum = how_many(x);
		cout << sum <<"\n";
		testcase--;
	}
	return 0;
}