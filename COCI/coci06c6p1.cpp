#include <bits/stdc++.h>
#define pb push_back
using namespace std;using ll = long long; constexpr char nl = '\n';
int main() {
    cin.sync_with_stdio(false); cin.tie(0);
    // freopen("in.txt","r",stdin);
    int n;cin >> n;
    map<string,int> m;
    cin.ignore();
    int ans =0 ;
    for (int i = 0; i < n; i++) {
        string name;getline(cin,name);
        int tot = 0;
        for (auto x: m) {
            if (x.first == name) continue;
            tot += x.second;
        }
        if (m[name] > tot) ans++;
        m[name]++;
    }
    cout << ans << nl;
}