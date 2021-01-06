#include <bits/stdc++.h>
#define f first
using namespace std;
int main() {
    vector<map<char,int>> m (2);
    string a,b; getline(cin,a); getline(cin,b);
    for (auto c: a) m[0][c]++;
    for (auto c: b) m[1][c]++;
    if (m[1].size() > m[0].size()) swap(m[1],m[0]);
    for (auto &x: m[0]) {
        if (x.f == ' ') continue;
        if (x.second != m[1][x.f]) {
            cout << "Is not an anagram.\n"; return 0;
        }
    }
    cout << "Is an anagram.\n";
}