#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
map<int,int> d;
int main() {
    // freopen("in.txt","r",stdin);
    // freopen("out.txt","w",stdout);
    cin.sync_with_stdio(false); cin.tie(0);
    int N; cin >> N;
    ll cnt = 0;
    for (int i = 0; i < N; i++) {
        int x;
        cin >> x;
        auto it = d.lower_bound(x);
        int D1 = 0, D2 = 0;
        //end
        if (it == d.end()) {}
        else {
            D1 = max(D1,1+(*it).second);
        }
        //cannot go down
        if (it == d.begin()) {}
        else {
            D2 = max(D2,1+(*(--it)).second);
        }
        //defined for each node x
        d[x] = max(D1,D2);
        cnt+=d[x];
        cout << cnt << '\n';
    }
}