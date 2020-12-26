#include <bits/stdc++.h>
using namespace std;
using ll=long long; constexpr char nl = '\n';
int main() {
    // cin.sync_with_stdio(false); cin.tie(0);
    vector<int> a(3,0);
    a[0] = 1;
    string str; cin >> str;
    for (int i = 0; i < str.length(); i++) {
        char x = str[i];
        if (x =='A') {
            swap(a[0],a[1]);
        }
        else if (x=='B') {
            swap(a[1],a[2]);
        }
        else {
            swap(a[0],a[2]);
        }
    }
    for (int i = 0; i< 3; i++) {
        if (a[i] == 1) {
            cout << ++i<< nl;
            break;
        }
    }
}