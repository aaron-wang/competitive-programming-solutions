#include <bits/stdc++.h>
using namespace std;
typedef long long ll; constexpr char nl = '\n';
int W, D, V;
vector<int> d,check; 
bool vis[10];
bool f[6][5000005];
void solve(int val, int cnt) {
    if (cnt == W) {
        for (int i = 0; i < V; i++) {
            if (val == check[i]) vis[i] = true;
        }
    }
    else {
        //has this particular position already occured? (if so, avoid)
        if (f[cnt][val]) return; f[cnt][val] = true;
        for (int i = 0; i < D; i++) {
            solve(val * d[i],cnt+1); solve(val + d[i],cnt+1);
        }
    }
}
int main() {
    cin.sync_with_stdio(false); cin.tie(0);
    cin >> W >> D;
    for (int i = 0; i < D; i++) {
        int x; cin >> x;d.push_back(x);
    }
    cin >> V;
    for (int i = 0; i < V; i++) {
        int x; cin >> x;check.push_back(x);
    }
    //starting dig (always the case)
    for (int i = 0; i < D; i++) solve(d[i],0);
    for (int i = 0; i < V; i++) {
        if (vis[i])cout << "Y" << nl;
        else cout << "N" << nl;
    }
}