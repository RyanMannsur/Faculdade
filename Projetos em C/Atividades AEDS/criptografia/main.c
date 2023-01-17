#include <stdio.h>
#include <stdlib.h>


int tamanho_arquivo(FILE *f,char *nome_arquivo){
    int i = 0;
    char lixo = ' ';
    int tamanho = 0;
    printf("Digite o nome do arquivo: ");
    scanf("%s", nome_arquivo);
    f = fopen(nome_arquivo,"r");
    if (f == NULL)
        printf("Arquivo inexistente\n");
    for(i=0; (!feof(f) && lixo !='\0'); i++){
        lixo = fgetc(f);
        tamanho++;
     }
    fclose(f);
    if(tamanho%2==0)
        return tamanho - 1;
    else
        return tamanho;
}


void ler_arquivo(FILE *f,char *nome_arquivo,char *mensagem){
    int i = 0;
    f = fopen(nome_arquivo,"r");
    for(i=0; (!feof(f)); i++){
        mensagem[i] = fgetc(f);
    }
    mensagem[i-1] = '\0';
    fclose(f);
}


void permutar(int tamanho,char *mensagem){
    char troca;
    int indice = 0; //conta os blocos
    int j = tamanho - 2; //primeiro elemento do ultimo bloco
    for(int i=0; ((i!=j) && (i!=j+2) && (i!= (tamanho/2)+2)) ; i++){ //ideal j=i; i=j+2 e i=tam/2+2 qnd o meio troca
        troca = mensagem[i];
        mensagem[i] = mensagem[j];
        mensagem[j] = troca; //troca os blocos
        j++;
        if(indice==1){ //se o bloco acabou, pula 1 bloco de tras pra frente e de frente pra tras
            j = j-6;
            i = i+2;
            indice = 0;
        }
        else 
            indice++;
    }
}

void cifra_cesar(char *c1,char *c2){
    int integerc1 = *c1;
    int integerc2 = *c2;
    if(*c1 == '#')
        *c1 = ' ';
    else{
        switch (integerc1){ //tratando o problema com as letras v,w,x,y,z
            case 65: *c1 = 86; break;
            case 66: *c1 = 87; break;
            case 67: *c1 = 88; break;
            case 68: *c1 = 89; break;
            case 69: *c1 = 90; break;
            case 97: *c1 = 118; break;
            case 98: *c1 = 119; break;
            case 99: *c1 = 120; break;
            case 100: *c1 = 121; break;
            case 101: *c1 = 122; break;
            default: *c1 = integerc1-5; //cifra de cesar
        }
    }
    if(*c2 == '#')
        *c2 = ' ';
    else{
        switch (integerc2){ //tratando os problemas com letras v,w,x,y,z
            case 65: *c2 = 86; break;
            case 66: *c2 = 87; break;
            case 67: *c2 = 88; break;
            case 68: *c2 = 89; break;
            case 69: *c2 = 90; break;
            case 97: *c2 = 118; break;
            case 98: *c2 = 119; break;
            case 99: *c2 = 120; break;
            case 100: *c2 = 121; break;
            case 101: *c2 = 122; break;
            default: *c2 = integerc2-5; //cifra de cesar
        }
    }
}

void descodifica(int tamanho, char *mensagem){
    char troca;
    for(int i = tamanho-1;i>0;i=i-2){ //começa na ultima posição e volta 2
        troca = mensagem[i];
        mensagem[i] = mensagem[i-1];
        mensagem[i-1] = troca; //troca os blocos de mensagem
        cifra_cesar(&mensagem[i],&mensagem[i-1]); //cifra de cesar
        if((i==1 && mensagem[i-1] == ' ')) //se a ultima letra for [espaço] termina string
            mensagem[i-1] = '\0';
    }
}

void mensagem_codificada(char *mensagem,int tamanho){ //imprime na formatação do run codes
    printf("\n--------------------\n");
    printf("Mensagem codificada:\n");
    printf("--------------------\n");
    puts(mensagem);
}

void mensagem_decodificada(char *mensagem,int tamanho){ //imprime na formatação do run codes
    printf("----------------------\n");
    printf("Mensagem decodificada:\n");
    printf("----------------------\n");
    printf("%s",mensagem);
}

int main(){
    FILE *f = NULL; 
    int tamanho;
    char nome_arquivo[20];
    tamanho = tamanho_arquivo(f,nome_arquivo) - 1;
    char mensagem[tamanho];//String do tamanho do arquivo
    ler_arquivo(f,nome_arquivo,mensagem); //ler o arquivo e coloca na string
    mensagem_codificada(mensagem,tamanho); //imprime msgm codificada
    permutar(tamanho,mensagem); //permuta os blocos
    descodifica(tamanho,mensagem); //reflete e faz a cifra de cesar
    mensagem_decodificada(mensagem,tamanho);//imprime msgm decodificada
}
