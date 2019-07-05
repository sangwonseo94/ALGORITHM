#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <stack>
#include <set>
using namespace std;
bool comp(pair<int, int> a, pair<int, int> b);
int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(0);
	
	vector<pair<int, int>> coordi;
	int test,x,y;
	cin >> test;
	while (test) {
		cin >> x >> y;
		coordi.push_back(make_pair(x,y));
		test--;
	}
	sort(coordi.begin(), coordi.end(), comp);
	for (auto arr : coordi) {
		cout << arr.first << " " << arr.second << "\n"; 
	}

}

bool comp(pair<int, int> a, pair<int, int> b)
{
	if (a.first == b.first) return a.second < b.second;
	else return a.first < b.first;
}

 