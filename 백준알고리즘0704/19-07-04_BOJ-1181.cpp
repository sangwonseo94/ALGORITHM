#include <iostream>
#include <vector>
#include <string>
#include<algorithm>

using namespace std;

bool comp(string a, string b) {
	if (a.size() == b.size()) return a < b;
	else return a.size() < b.size();
}

int main(void) {
	int test;
	cin >> test;
	vector<string> words;
	string word;
	while (test) {
		cin >> word;
		words.push_back(word);
		test--;
	}
	sort(words.begin(), words.end(), comp);
	words.erase(unique(words.begin(), words.end()), words.end());
	for (auto arr : words) cout << arr << "\n";


}

