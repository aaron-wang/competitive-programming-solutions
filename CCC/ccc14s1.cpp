#include <bits/stdc++.h>
#define pb push_back
using namespace std;
using ll = long long; constexpr char nl= '\n';
int main() {
    ios::sync_with_stdio(0); cin.tie(0);
    int n; cin >> n;
    int m; cin >> m;
    //1 2 3 4 5 6 7 8 9 10
    //  x   x x  x   x   x
    vector<int> a(n+1);
    for (int i = 1; i<= n; i++) a[i] = i;
    for (int i =0 ; i < m; i++) {
        int r; cin >> r;
        int curr =0 ;
        for (int j = 1; j <= n; j++) {
            if (a[j]) curr++;
            if (curr == r) {
                a[j] = 0;
                curr=0;
            }
        }
    }
    for (auto x: a) {
        if (x) cout << x << nl;
    }
}