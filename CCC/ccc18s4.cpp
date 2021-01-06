#include <bits/stdc++.h>
#define pb push_back
using namespace std;
using ll = long long; constexpr char nl = '\n';
// const int MM = 1e6+6;
unordered_map<int,ll> dp;
int n;
ll f(int w) {
    if (w <= 2) return 1;
    if (dp.count(w)) return dp[w];
    ll limit = sqrt(w), tmp = 0;
    for (int k = 2; k <= limit; k++) {
        tmp += f(w/k);
    }
    ll prev = limit;
    for (int curr = limit; curr >= 1; curr--) {
        tmp += (w/curr - prev) * f(curr);
        prev = w/curr;
    }
    return dp[w]=tmp;
}
int main() {
    cin.sync_with_stdio(false); cin.tie(0);
    cin>>n;
    cout << f(n) << nl;
}