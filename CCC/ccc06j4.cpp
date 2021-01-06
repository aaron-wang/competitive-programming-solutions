#include <bits/stdc++.h>
#define pb push_back
using namespace std;
using ll=long long; constexpr char nl = '\n';
using vi=vector<int>;
const int MM = 100;
vi adj[MM];short state[MM]; bool yes = true;
vi ans;
void dfs(int s) {
    if (!yes) return;
    if (state[s]==2) return;
    if (state[s] == 1) {
        yes = false;
    }
    state[s] = 1;
    for (auto x: adj[s]) dfs(x);
    state[s] = 2;
    ans.pb(s);
}
inline void f(int a, int b) {adj[a].pb(b);}
int main() {
    cin.sync_with_stdio(false); cin.tie(0);
    f(1,7);f(1,4);f(2,1);f(3,4);f(3,5);
    int a,b; cin >> a >> b;
    while (!(a == 0 && b==0)) {
        //x before y
        f(a,b);
        cin >> a >> b;
    }
    for (int i = 7; i >= 1; i--) dfs(i);
    
    if (!yes) {
        cout << "Cannot complete these tasks. Going to bed."<<nl;
    }
    else {
        for (auto it = ans.rbegin(); it !=ans.rend();it++) {
            cout << *it << " ";
        }
    }
}