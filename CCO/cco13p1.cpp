#include <bits/stdc++.h>
#define pb push_back
using namespace std;
using ll = long long; constexpr char nl = '\n';
int x;
bool solve(int b) {
    vector<int> a(1);
    a[0] = x;
    for (int i = 1; i <= 32; i++) {
        a.pb(-1);
        a[i] = a[i-1]/b;
        if (a[i] == 0) {
            a.pop_back();
            break;
        }
        a[i-1]%=b;
    }
    // for (auto x: a) {
    //     cout << x << " ";
    // }cout << nl;
    for (int i =0 ; i < a.size()/2; i++) {
        if (a[i] != a[a.size()-i-1]) {
            return false;
        }
    }return true;
}
int main() {
    cin.sync_with_stdio(false); cin.tie(0);
    cin >> x;
    for (int b = 2; b <= x; b++) {
        if (solve(b)) {
            cout << b << nl;
        }
        else continue;
    }
}