#include <bits/stdc++.h>
using namespace std;
using ll = long long; constexpr char nl = '\n';
int main() {
    ios::sync_with_stdio(0); cin.tie(0);
    vector<vector<int>> a(4,vector<int>(4));
    int n = 4;
    for (int i = 0; i < n; i++) {
        for (int j =0 ; j < n; j++) {
            cin >> a[i][j];
        }
    }
    set<int> m;
    for (int i = 0 ; i < n; i++) {
        int x = 0, y = 0;
        for (int j = 0; j < n; j++) {
            x += a[i][j];
            y += a[j][i];
        }
        m.insert(x);m.insert(y);
    }
    cout << (m.size() == 1 ? "magic" : "not magic") << nl;
}