#include <stdio.h>
#include <stdlib.h>

union brecha{
    float f1;
    int f2;
};

int main(){
    union brecha b;
    float g;
    b.f1 = 3.15f;
    g = b.f2 & 0x100; 
    printf("%f",g);
}
