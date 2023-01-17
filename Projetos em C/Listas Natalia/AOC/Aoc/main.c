#include <stdio.h>
#include <stdlib.h>

typedef struct Num
{
    int binario[8];
    int hex1[7];
    int hex2[7];
    int hex3[7]
} NUM;

#define MAX 50

int main(){
    //FILE *f = NULL;
    NUM bin[256];
	int num = 0;
	int vet_bin[8];
	int i,j,k,aux;
    int aux_num = num;
    for(int k=0;k<256;k++){
        printf("%d em binario e: ",k);
        for (aux = 7; aux >= 0; aux--) {
            if (num % 2 == 0) {
                vet_bin[aux] = 0;
                num = num / 2;
            }
            else {
                vet_bin[aux] = 1;
                num = num / 2;
            }
        }
        for(j=0;j<8;j++){
           bin[k].binario[j] = vet_bin[j];
           printf("%d",bin[k].binario[j]);
        }
        aux_num++;
        num = aux_num;
        printf("\n");
    }
    /*for(i=0,j=0,k=0,num=0;i<256;i++){
        switch (k){
            case 0: bin[i].hex1 = {0,1,1,1,1,1,1}; break;
            case 1: bin[i].hex1 = {0,0,0,0,1,1,0}; break;
            case 2: bin[i].hex1 = {1,0,1,1,0,1,1}; break;
            case 3: bin[i].hex1 = {1,0,0,1,1,1,1}; break;
            case 4: bin[i].hex1 = {1,1,0,0,1,1,0}; break;
            case 5: bin[i].hex1 = {1,1,0,1,1,0,1}; break;
            case 6: bin[i].hex1 = {1,1,1,1,1,0,0}; break;
            case 7: bin[i].hex1 = {0,0,0,0,1,1,1}; break;
            case 8: bin[i].hex1 = {1,1,1,1,1,1,1}; break;
            case 9: bin[i].hex1 = {1,1,0,1,1,1,1}; break; 
        }
        switch (j){
            case 0: bin[i].hex2 = {0,1,1,1,1,1,1}; break;
            case 1: bin[i].hex2 = {0,0,0,0,1,1,0}; break;
            case 2: bin[i].hex2 = {1,0,1,1,0,1,1}; break;
            case 3: bin[i].hex2 = {1,0,0,1,1,1,1}; break;
            case 4: bin[i].hex2 = {1,1,0,0,1,1,0}; break;
            case 5: bin[i].hex2 = {1,1,0,1,1,0,1}; break;
            case 6: bin[i].hex2 = {1,1,1,1,1,0,0}; break;
            case 7: bin[i].hex2 = {0,0,0,0,1,1,1}; break;
            case 8: bin[i].hex2 = {1,1,1,1,1,1,1}; break;
            case 9: bin[i].hex2 = {1,1,0,1,1,1,1}; break; 
        }
        switch (num){
            case 0: bin[i].hex3 = {0,1,1,1,1,1,1}; break;
            case 1: bin[i].hex3 = {0,0,0,0,1,1,0}; break;
            case 2: bin[i].hex3 = {1,0,1,1,0,1,1}; break;
            case 3: bin[i].hex3 = {1,0,0,1,1,1,1}; break;
            case 4: bin[i].hex3 = {1,1,0,0,1,1,0}; break;
            case 5: bin[i].hex3 = {1,1,0,1,1,0,1}; break;
            case 6: bin[i].hex3 = {1,1,1,1,1,0,0}; break;
            case 7: bin[i].hex3 = {0,0,0,0,1,1,1}; break;
            case 8: bin[i].hex3 = {1,1,1,1,1,1,1}; break;
            case 9: bin[i].hex3 = {1,1,0,1,1,1,1}; break; 
        }
        k++;
        if(k==10){
            k = 0;
            j++;
        }
        if(j==10){
            j = 0;
            num++;
        }*/
}
