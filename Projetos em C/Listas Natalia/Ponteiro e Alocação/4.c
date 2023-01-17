#include <stdio.h>
#include <stdlib.h>

void ordena(int *x,int *y,int *z){
    int i,j ,aux,v[3];
    v[0] = *x;
    v[1] = *y;
    v[2] = *z;
    for(i=0;i<3;i++)
        for(j=i+1;j<3;j++)
            if(v[i]>v[j]){
                aux = v[i];
                v[i] = v[j];
                v[j] = aux;
            }
    *x = v[0];
    *y = v[1];
    *z = v[2];
}

int main(){
    int x,y,z;
    printf("Digite o X, Y e o Z nessa sequencia: ");
    scanf("%d %d %d", &x, &y, &z);
    ordena(&x,&y,&z);
    printf("Numeros ordenados:\nX = %d\nY = %d\nZ = %d\n",x,y,z);
}