#include <bits/stdc++.h>

using namespace std;

int main() {
    int x,y;
    scanf("%d %d", &x, &y);
    
//starting at 0,0
    int cX = 0, cY = 0;
    

    int a,b;
    scanf("%d %d",&a,&b);
    // if (a == 0 && b == 0) {
    //     printf("%d %d",cX+a,cY+b);
    // }
    // else {
        while (a != 0 || b != 0) {
            cX += a;
            cY += b;
            if (cX > x) cX = x;
            if (cX < 0) cX = 0;
            if (cY > y) cY = y;
            if (cY < 0) cY = 0;

            printf("%d %d\n",cX,cY);
            scanf("%d %d",&a,&b);
        }
    // }
}