#include <bits/stdc++.h>
#define pb push_back
using namespace std;using ll = long long; constexpr char nl = '\n';
const int MM = 1e5+5;
int main() {
    cin.sync_with_stdio(false); cin.tie(0);
    // freopen("in.txt","r",stdin);
    // freopen("out.txt","w",stdout);
    int n; cin >> n;
    cin.ignore();
    for (int i =0 ; i < n; i++) {
        string s,t; getline(cin,s);stringstream ss; ss << s;
        vector<string> a;
        while (ss >> t) {
            if (t.length() == 4) t = "****";
            t = (a.size() ? " ":"")+ t;a.pb(t);
        }
        for (auto x: a) cout << x;
        cout << nl;
    }
}