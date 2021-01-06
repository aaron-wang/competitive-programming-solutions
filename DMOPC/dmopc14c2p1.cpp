#include <bits/stdc++.h>
using namespace std;
int a[100];
int main() {
    int D; cin >> D;
    for (int i = 1; i <= D; i++) {
        int T; cin >> T;
        int sum = 0;
        while (T--) {
            int x; cin >> x;
            sum+=x;
        }
        a[i] = sum;
    }
    for (int i =1 ; i <= D; i++) {
        if (a[i] == 0) printf("Weekend\n");
        else printf("Day %d: %d\n",i,a[i]);
    }
}