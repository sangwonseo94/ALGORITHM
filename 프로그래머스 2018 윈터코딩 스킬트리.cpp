#include <iostream>
#include <vector>
#include <string>

using namespace std;
bool index(vector<int> index) {
   bool flag = true;
   if(index.empty()) return true;
   if (index[0] != 0) return false; 
   for (int arr = 0, compare = 0; arr < index.size(); arr++, compare++) {
      if (index[arr] != compare) {
         flag = false;
         break;
      }

   }
   
   return flag; 
}

int solution(string skill, vector<string> skill_trees) {
   int answer = 0;

   for (int i = 0; i < skill_trees.size(); i++) {
      vector <int> indexarg;
      for (int j = 0; j < skill_trees[i].size(); j++) {
         if (skill.find(skill_trees[i][j]) != string::npos) { indexarg.push_back(skill.find(skill_trees[i][j])); }
      }
      
      if(index(indexarg)) answer++;
    }
   return answer;
