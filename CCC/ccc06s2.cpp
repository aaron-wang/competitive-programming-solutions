#include <bits/stdc++.h>
#define pb push_back
using namespace std;
using ll=long long; constexpr char nl = '\n';
int main() {
    cin.sync_with_stdio(0); cin.tie(0);
    string text; getline(cin,text);
    string key; getline(cin,key);
    string cipher; getline(cin,cipher);
    map<char,char> m;
    for (char c = 'A'; c <= 'Z'; c++) {
        m[c] = '.';
    }
    m[' ']='.';
    for (int i = 0; i < text.length();i++) {
        m[key[i]] = text[i];
    }
    for (auto c: cipher) {
        cout << m[c] << "";
    }cout << nl;
}