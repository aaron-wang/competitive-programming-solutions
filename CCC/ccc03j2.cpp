#include <bits/stdc++.h>
using namespace std;
int main() {
    int c; cin >> c;
    while (c) {
        int ans= 1e9;
        int a = -1,b=-1;
        for (int i = 1; i * i <= c; i++) {
            if (c%i==0) {
                int x = 2*i + 2 * c/i; 
                if (x < ans ) {
                    a = i; b = c/i;
                    ans = x;
                }
            }
        }
        printf("Minimum perimeter is %d with dimensions %d x %d\n",ans,a,b);
        cin >> c;
    }
}