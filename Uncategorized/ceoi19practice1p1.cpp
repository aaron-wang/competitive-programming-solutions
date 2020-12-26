#include <bits/stdc++.h>
using namespace std;
typedef long long ll; constexpr char nl = '\n';
const int MM = 1505; 
int h[MM], v[MM];
map<int,int> m;
int main() {
    cin.sync_with_stdio(false); cin.tie(0);
    int H, V;
    cin >> H >> V;
    for (int i = 0; i < H; i++) cin >> h[i];
    for (int i = 0; i < V; i++) cin >> v[i];
    ll ans = 0;
    for (int i = 0; i < H; i++) {
        for (int j = i+1; j < H; j++) {
            m[h[j]-h[i]]++;
        }
    }
    for (int i = 0; i < V; i++) {
        for (int j = i+1; j < V; j++) {
            ans += m[v[j]-v[i]];
        }
    }
    cout << ans << nl;
    // for (int i = 0; i < H; i++) {
    //     for (int j = i+1; j < H; j++) {
    //             if (binary_search(v,++;

}