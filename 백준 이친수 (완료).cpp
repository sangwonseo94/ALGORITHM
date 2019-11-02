#include <iostream>

using namespace std;

long long int  m[91] = { 0, };
bool c[91] = { false, };
long long int pm(long long int n) {
	if (c[n]) return m[n];
	c[n] = true;
	m[n] = pm(n - 1) + pm(n - 2);
	return m[n];
}


int main(void) {
	long long int n; cin >> n;

	m[1] = 1; c[1] = true;
	m[2] = 1; c[2] = true;
	cout << pm(n);

}