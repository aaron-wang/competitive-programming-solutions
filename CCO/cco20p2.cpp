#include <bits/stdc++.h>
#define pb push_back
using namespace std;
using ll=long long; constexpr char nl = '\n';
const int MM = 2e5+5;
vector<int> g[MM];
int d[MM];
priority_queue<int> q;
ll tr[MM];
inline void upd(int x, int v) {
    for (int i = x; i < MM; i+=i&-i) tr[i] += v;
}
ll query(int x) {
    ll ret = 0;
    for (int i = x; i > 0; i-=i&-i) ret += tr[i];
    return ret;
}
int main() {
    cin.sync_with_stdio(false); cin.tie(0);
    int n; cin >> n;
    for (int i = 1,x; i <= n; i++) {
        cin >> x; g[x].pb(i);
    }
    for (int i = n; i>=1;i--) {
        for (int x: g[i]) q.push(x);
        if (q.empty()) {cout << -1<<nl; return 0;}
        d[i] = q.top(); q.pop();
    }
    ll ans = 0;
    //main
    for (int i = 1; i <= n;i++) {
        ans += i- 1 - query(d[i]);
        upd(d[i],1);
    }
    cout << ans << nl;
}