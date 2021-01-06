#include <bits/stdc++.h>
using namespace std;
using ll=long long; constexpr char nl = '\n';
int main() {
    cin.sync_with_stdio(0); cin.tie(0);
    ll ans = 0;
    int n; cin >> n; vector<int> a(n,0);
    for (int i = 0; i < n; i++) cin >> a[i];
    for (int i = 0; i < n-1; i++) ans += max(a[i],a[i+1]);
    std::cout << ans << nl;
}