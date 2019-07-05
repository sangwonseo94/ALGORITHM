#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
using namespace std;

int main(void) {
	int T;
	cin >> T;
	vector<int> num;
	while (T) {
		int temp;
		cin >> temp;
		num.push_back(temp);
		T--;
	}
	sort(num.begin(), num.end());
	
	for (int k = 0; k < num.size(); k++) {
		cout << num[k] << endl;

	}
}
