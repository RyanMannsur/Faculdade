#include <stdio.h>

void preencher(double m[][3]){
    int i,j;
    for(i=0;i<3;i++)
        for(j=0;j<3;j++)
            scanf(" %lf",&m[i][j]);

}

double Determinante3x3(double mat[][3]){
    double m[3][5];
    int i,j, aux;
    int l=0,c=0;
    double sinal = -1.0;
    double res=0;
    for(i=0;i<3;i++)
        for(j=0;j<5;j++){
        if(j>=3){
            m[i][j]=mat[l][c];
            c++;
            if(c>=2){
                c=0;
                l++;
            }
        }
        else
            m[i][j]=mat[i][j];
    } //Criei a matriz com a repetição da linha 1 e 2!
    j=i=aux=0;
    while(aux<6){
        if(aux<=2){
            res= res+(m[i][j]*m[i+1][j+1]*m[i+2][j+2]);
            j++;
            if(aux==2)
                j=4;
        }
        else{
            res= res+(sinal*(m[i][j]*m[i+1][j-1]*m[i+2][j-2]));
            j--;
        }
        aux++;
    }
    //res=(m[0][0]*m[1][1]*m[2][2])+(m[0][1]*m[1][2]*m[2][3])+(m[0][2]*m[1][3]*m[2][4])+sinal*((m[0][4]*m[1][3]*m[2][2])+(m[0][3]*m[1][2]*m[2][1])+(m[0][2]*m[1][1]*m[2][0]));
    
    return res;
            
}

int main(){
    double m[3][3];
    printf("Digite os numeros da matriz:\n");
    preencher(m);
    printf("Resultado = %.1lf\n",Determinante3x3(m));
}