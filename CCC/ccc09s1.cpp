#include <bits/stdc++.h>
using namespace std;
int main() {
    int a,b;cin>>a>>b;int cnt = 0;
    for (int i = 1; i <= 32; i++) {
        long long x = pow(i,6);
        if (x > 1e8) break;
        if (x>b) break;
        if (x>= a) cnt++;
    }
    cout << cnt << endl;
}