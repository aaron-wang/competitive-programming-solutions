#include <bits/stdc++.h>
using namespace std;
constexpr char nl = '\n';
int v,h;
int main() {
    cin.sync_with_stdio(false); cin.tie(0);
    string s; cin >> s;
    for (auto c: s) {
        if (c=='V')v++;
        if (c=='H')h++;
    }
    h%=2, v%=2;
    vector<vector<int>> a = {{1,2},{3,4}};
    if (v) {
        swap(a[0][0],a[0][1]);
        swap(a[1][0],a[1][1]);
    }
    if (h) {
        swap(a[0][0],a[1][0]);
        swap(a[0][1],a[1][1]);
    }
    cout << a[0][0] << " " << a[0][1] << nl;
    cout << a[1][0] << " " << a[1][1] << nl;
}