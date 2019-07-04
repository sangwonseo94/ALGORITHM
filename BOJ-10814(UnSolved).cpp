#include <iostream>
#include <vector>
#include <algorithm>
#include <String>

using namespace std;

bool compare(pair<int,String> a, pair<int,String> b){
	if (a.first == b.first) return a.second > b.second ;
	else return a.first > b.first ; 
}

int main(void) {
	ios::sync_with_stdio();
	cin.tie(NULL);
	vector<pair<int,String>> number_info;
	int testcase,age; String name;
	cin >> testcase ;
	while(testcase){
		cin >> age >> name ; 
		number_info.push_back(make_pair(age,name));
		testcase--;
	}
	sort(number_info.begin(),number_info.end(), compare);
	for(auto arr : number_info) cout << arr <<"\n" ;

}