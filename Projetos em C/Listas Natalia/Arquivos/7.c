#include <stdio.h>
#include <string.h>
#define TAM 20

typedef struct ALUNO{
    char nome[100];
    int matri;
    int idade;
    char tel[15];
    char end[100];
    int nivel;
} Aluno;

void Imprime(Aluno a[]){
    int i;
    for(i=0;i<TAM;i++){
        printf("Nome do aluno: %s",a[i].nome);
        printf("Matricula do aluno: %d\n",a[i].matri);
        printf("Idade do aluno: %d\n",a[i].idade);
        printf("Telefone do aluno: %s",a[i].tel);
        printf("Edereco do aluno: %s",a[i].end);
        printf("Nivel do aluno: %d\n\n",a[i].nivel);
    }
}

void Preencher(Aluno a[]){
    int i;
    for(i=0;i<TAM;i++){
        printf("Digite o nome do aluno: ");
        fgets(a[i].nome,100,stdin);
        printf("Digite o numero de matricula do aluno: ");
        scanf("%d",&a[i].matri);
        getchar();
        printf("Digite a idade do aluno: ");
        scanf("%d",&a[i].idade);
        getchar();
        printf("Digite o telefone do aluno: ");
        fgets(a[i].tel,15,stdin);
        printf("Digite o endereco do aluno: ");
        fgets(a[i].end,100,stdin);
        printf("Digite o nivel do aluno: ");
        scanf("%d",&a[i].nivel);
        getchar();
        printf("\n");
    }
}

int main(){
    Aluno a[TAM];
    char menu[5];
    FILE *f;
    printf("Digite as letras necessarias!\n\nwb: Para escrever no arquivo.\nrb: Para ler o Arquivo.\n\n");
    fgets(menu,5,stdin);
    menu[strlen(menu)-1] = '\0';
    f = fopen("Alunos.bin",menu);
    if(f == NULL){
        printf("Erro ao abrir o arquivo\n");
        return 0;
    }
    if(menu[0] == 'w'){
        printf("\n");
        Preencher(a);
        fwrite(a,sizeof(Aluno),TAM,f);
    }
    else{
        printf("\n");
        fread(a,sizeof(Aluno),TAM,f);
        Imprime(a);
    }
    fclose(f);
}   