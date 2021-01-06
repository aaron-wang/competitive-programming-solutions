#include <bits/stdc++.h>
#define pb push_back
using namespace std;
using ll=long long; constexpr char nl = '\n';
int main() {
    cin.sync_with_stdio(false); cin.tie(0);
    int op; cin >> op;
    int n; cin >> n;
    vector<int> a(n,0),b(n,0);
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    for (int i = 0; i < n; i++) cin >> b[i];
    sort(a.begin(),a.end()); sort(b.begin(),b.end());
    int ans = 0;
    if (op == 1) {
        for (int i = 0; i < n; i++) ans += max(a[i],b[i]);
    }
    else {
        for (int i = 0 ;i < n; i++) ans += max(a[i],b[n-i-1]);
    }
    cout << ans << nl;
}