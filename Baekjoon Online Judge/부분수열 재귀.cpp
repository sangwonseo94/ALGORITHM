#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

string st;
int answer;

void solve(string st) {
	if (st.size() % 2 == 1) {
		solve(st.substr(1, st.size()));
		solve(st.substr(0, st.size() - 1));
	}
	if (st.size() % 2 == 0)
	{
		int half = st.size() / 2;
		int left = 0, right = 0; 
		for (int arr = 0; arr < half; arr++) left += (st[arr] - '0');
		for (int arr = half; arr < st.size(); arr++) right += (st[arr] - '0' );
		if (left == right) if (answer < st.size() ) answer = st.size();
		else {
			solve(st.substr(2, st.size() ));
			solve(st.substr(0, st.size()-2 ));
			solve(st.substr(1, st.size() - 1));
		}
	}
}

int main(void) {

	cin >> st;
	cout << st.substr(1, st.size()-1);
	///solve(st);
	cout << answer;
}