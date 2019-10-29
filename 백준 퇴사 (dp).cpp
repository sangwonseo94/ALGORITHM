#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

string st;
int answer;

void solve(string st) {
	if (st.size() % 2 == 0) {
		solve(st.substr(1, st.size()));
		solve(st.substr(0, st.size() -1));
	}
	if (st.size() % == 0)
	{
		int half = st.size() / 2;
		int left = 0 , right = 0;
		for (int arr = 0; arr < half; arr++) left += stoi(st[arr]);
		for (int arr = half; arr < st.size(); arr++) right += stoi(st[arr]);
		if (left == right) if (answer < left) answer = right;
		
	}

}

int main(void) {

	cin >> st;
	
	solve(st);
	cout << answer;
}