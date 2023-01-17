#include <stdio.h>
#include <stdlib.h>

int main(){
    int n,i;
    int *v;
    printf("Digite o tamanho do vetor: ");
    scanf("%d", &n);
    v = (int *) malloc(sizeof(int)*n);
    printf("Digite os numeros do vetor:\n");
    for(i=0;i<n;i++)
        scanf(" %d",&v[i]);
    printf("Elementos do vetor:");
    for(i=0;i<n;i++)
        printf(" %d",v[i]);
    free(v);
}