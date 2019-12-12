#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;
int check ( int *cache , int task,int s){
	for (int i =0 ; i < s ; i++) {
		if(cache[i] == task)return i;
	}
	return 0;
}

int main(int argc, char** argv) {
	int s,n; cin >> s >> n;
	int cache[1000] = {0,} , task[1000] = { 0,};
	for (int i = 0 ; i < n ; i ++){
		cin >> task[i];
	}
	for (int i = 0 ; i < n ; i ++){
		int index = check(cache , task[i],s);
		int item = cache[index];
		if(check(cache , task[i], s)){
			for(int j = index ; j >0 ; j --){
				cache[j] = cache[j-1];
			}
			cache[0] = item;
		}
		else{
			for (int j = s-1 ; j >0 ; j --){
				cache[j] = cache[j-1];
			}
			cache[0] = task[i];
		}
	}
	
	for(int i = 0 ; i < s ; i++) cout << cache[i] <<" ";
	return 0;
}
