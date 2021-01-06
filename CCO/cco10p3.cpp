#include <bits/stdc++.h>
#include <ext/pb_ds/tree_policy.hpp>
#include <ext/pb_ds/assoc_container.hpp>
using namespace std;
using namespace __gnu_pbds;

typedef
tree<pair<int,int>,null_type,less<pair<int,int>>,rb_tree_tag,
tree_order_statistics_node_update> set_t;
const int MAXN = 1e6+1;
int a[MAXN];
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int N;
    cin >> N;
    set_t t;
    for (int i = 0;i < N; i++) {
        char op;
        cin >> op;
        int x,r,k;
        if (op == 'N') {
            cin >> x>>r;
            a[x] = r;
            t.insert({r,x});
            // t.insert({x,r});
        }
        else if (op == 'M') {
            cin>>x;
            t.erase({a[x],x});
            // t.erase({x,a[x]});
            cin>>r;
            a[x] = r;
            t.insert({r,x});
            // t.insert({x,r});
        }
        else {
            //Q
            cin>>k;
            // pair<int,int> ans = 
            cout << (*t.find_by_order(t.size()-k)).second << '\n';
        }
    }
}