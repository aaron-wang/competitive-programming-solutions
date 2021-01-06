#include <bits/stdc++.h>
#define pb push_back
using namespace std;
using ll = long long; constexpr char nl = '\n';
using pi = pair<int,int>;
int main() {
    cin.sync_with_stdio(false); cin.tie(0);
    int N; cin >> N;
    //<- O ->
    //-1    1
    vector<pi> runs;
    for (int i = 0; i < N; i++) {
        int t,x; cin >> t >> x;
        runs.pb({t,x});
    }
    double ans = 0;
    sort(runs.begin(),runs.end());
    for (int i = 0; i < N-1; i++) {
        double dis = (double) (runs[i+1].second - runs[i].second);
        double delta = ((double) (runs[i+1].first - runs[i].first));
        ans = max(ans,abs(dis/delta));
    }
    cout << std::fixed << setprecision(14)<< ans << nl;
}