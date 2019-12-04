#include <iostream>
#include <string>
#include <vector>

using namespace std;
int answer = 0;

void exchange(int n, vector <int> money_list, int index) {


	if (index == money_list.size()) return;
	if (n - money_list[index] == 0) {
		answer += 1;
		return;
	}
	if (n - money_list[index] < 0) return;

	exchange(n - money_list[index], money_list, index);
	exchange(n, money_list, index + 1);




}

int solution(int n, vector<int> money) {

	exchange(n, money, 0);
	return answer;
}


int main(void) {
	vector <int > m;
	m.push_back(1);
	m.push_back(2);
	m.push_back(5);
	cout << solution(5, m);

}