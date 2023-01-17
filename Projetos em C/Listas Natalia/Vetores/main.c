#include <stdio.h>

//Atividade 09
void Preencher(int v[]){
    int i;
    for(i=0;i<5;i++)
        scanf(" %d",&v[i]);
}

void Ordenar(int A[]){
    int i,j;
    int aux;
    for( i=0; i<5; i++ ){
        for( j=i+1; j<5; j++ ){
            if( A[i] > A[j] ){
                aux = A[i];
                A[i] = A[j];
                A[j] = aux;
            }
        }
    }

}

void Imprimir(int v[]){
    int i;
    for(i=0;i<5;i++)
        printf("%d\n",v[i]);
}

int main(){
    int v[5];
    printf("Digite 5 numeros: \n");
    Preencher(v);
    Ordenar(v);
    printf("Vetor Ordenado: \n");
    Imprimir(v);
}