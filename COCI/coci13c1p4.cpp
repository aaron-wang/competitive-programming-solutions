 #include <bits/stdc++.h>
using namespace std;
typedef long long ll; constexpr char nl = '\n'; 
typedef pair<int,int> pi;
typedef vector<int> vi;
const int MM = 3e5+5;
multiset<int> b;
pi jj[MM];
bool comp(pi A, pi B) {
    if (A.first == B.first) return A.second < B.second;
    return A.first > B.first;
}
int main() {
    cin.sync_with_stdio(false); cin.tie(0);
    int N, K;
    cin >> N>> K;
    for (int i = 0; i < N; i++) {
        int m,v; cin >> m>>v;
        jj[i] = {v,m};
    }
    sort(jj,jj+N,comp);
    for (int i = 0; i< K; i++) {
        int c; cin >> c; b.insert(c);
    }
    ll ans = 0;
    for (int i = 0; i< N; i++) {
        if (!b.empty()) {
            //mass jewel compare to masses in bag
            auto here = b.lower_bound(jj[i].second);
            if (here != b.end()) {
                //add val then
                ans += jj[i].first;
                b.erase(here);
            }
        }
        else break;
    }
    cout << ans;
}