#include <stdio.h>
#include <stdlib.h>

/****************

LAED1 - Problema da Mochila

Alunos(as): Anélio Gonçalves Caldas e Ryan Eduardo Mansur

Data: 24/02/2021

****************/

typedef struct item
{
    int peso;
    int valor;
} ITEM;

typedef struct Mochila
{
    ITEM itens[20];
    int capacidade;
    int itens_mochila;
} MOCHILA;


int ler_arquivo1(FILE *f, char *arquivo){ //ler o tanto de itens
    int num_itens;
    f = fopen(arquivo,"r");
    if(f == NULL){
        printf("Erro na leitura do arquivo\n");
        exit(1);
    }
    fscanf(f,"%d\n", &num_itens); //jogo fora o numero de capacidade
    fscanf(f,"%d\n",&num_itens); //quantidade de itens no arquivo
    fclose(f);
    return num_itens;
}

MOCHILA ler_arquivo(ITEM *itens_totais ,int num_itens,FILE *f, char *arquivo){ // função que ler o arquivo
    MOCHILA m;
    m.itens_mochila = 0;
    int i;
    int situacao = 0;
    f = fopen(arquivo,"r");
    if(f == NULL){
        printf("Erro na leitura do arquivo\n");
        exit(1);
    }
    fscanf(f,"%d\n", &m.capacidade); //capacidade da mochila
    fscanf(f,"%d\n",&num_itens); //quantidade de itens no arquivo

    for(i=0;i<num_itens;i++){
       fscanf(f,"%d ",&itens_totais[i].peso);
       fscanf(f,"%d ",&itens_totais[i].valor);
    }
    for(i=0;i<num_itens;i++){
       fscanf(f,"%d ",&situacao);
        if(situacao){
            m.itens[m.itens_mochila] = itens_totais[i];
            m.itens_mochila++;
        }
    }
    fclose(f);
    return m;
}

void redefinirSequencia(ITEM *sequencia,ITEM *itens_totais,int tam_seq,int num_itens){ //fazer uma sequencia diferente
    int tam_aux = num_itens-tam_seq; 
    ITEM aux[tam_aux]; //usarei para pegar os itens fora da sequencia
    int contador_aux = 0, contador_seq = 0; //variavies de controle
    for(int i=0;i<num_itens;i++){
        if(itens_totais[i].peso != sequencia[contador_seq].peso){
            if(itens_totais[i].valor != sequencia[contador_seq].valor){ //se nao fazer parte da sequencia
                aux[contador_aux] = itens_totais[i]; //adiciono no aux
                contador_aux++;
            }
        }
        else
            contador_seq++; //se fazer, pulo pro proximo da sequencia
    }
    for(int i=0, j=0;i<num_itens;i++){
        itens_totais[i] = aux[i]; //coloco os itens do aux 
        if(i>=tam_aux){
            itens_totais[i] = sequencia[j]; //coloco os itens da seuquencia no fim
            j++;
        }
        //printf("%d %d\n",itens_totais[i].peso,itens_totais[i].valor);
    }
}

int testarSolucaoOtima(ITEM itens_totais[],int num_itens, MOCHILA m){
    int contador = 0;
    int melhor = 0;
    int pesoTotal = 0;
    int valorTotal = 0; //variaveis de controle
    ITEM sequencia[num_itens]; // usarei para mudar a sequencia
    for(int i=0;i<num_itens;i++){
        pesoTotal = itens_totais[i].peso;
        valorTotal = itens_totais[i].valor;
        sequencia[contador] = itens_totais[i]; //inicializo com o item i na sequencia
        contador++;
        for(int j=0;j<num_itens;j++){ //itens que somarei com item i
            if(i!=j){ //so somo se for diferente de i
                if((itens_totais[j].peso + pesoTotal) <= m.capacidade){ //enquanto não passar a capacidade
                    pesoTotal = pesoTotal + itens_totais[j].peso;
                    valorTotal = valorTotal + itens_totais[j].valor;
                    sequencia[contador] = itens_totais[j];
                    contador++; //adiciono na sequencia
                }
                else //se excedeu o valor
                    if(valorTotal>melhor){ //se o valor deu melhor doq o anterior 
                        melhor = valorTotal; //novo melhor
                        redefinirSequencia(sequencia,itens_totais,contador,num_itens); //redefino a sequencia
                        //printf("teste j = %d, i = %d\n",j,i);
                        i = j = 0;
                        contador = 0;
                        pesoTotal = 0;
                        valorTotal = 0; //zero todos valores importantes
                        break; //recomeço o laço
                    }
                }
        }
        contador = 0;
        pesoTotal = 0;
        valorTotal = 0; //zero tudo se o laço de dentro não achou o melhor
    }
    return melhor; //retorno o melhor
}

int solucaoDadaValor(MOCHILA m){
    int valorTotal = 0;
    for(int i=0;i<(m.itens_mochila); i++)
        valorTotal = valorTotal + m.itens[i].valor;
    return valorTotal;
}

int solucaoDadaPeso(MOCHILA m){
    int valorTotal = 0;
    for(int i=0;i<m.itens_mochila; i++)
        valorTotal = valorTotal + m.itens[i].peso;
    return valorTotal;
}

int main(){
    FILE *f = NULL;
    MOCHILA m;
    char arquivo[20];
    int melhor;
    printf("Digite o nome do arquivo: ");
    scanf("%s",arquivo);
    int num_itens = ler_arquivo1(f,arquivo);
    ITEM itens_totais[num_itens];
    m = ler_arquivo(itens_totais, num_itens,f,arquivo);
    int valorMochila = solucaoDadaValor(m);
    int pesoMochila = solucaoDadaPeso(m);
    melhor = testarSolucaoOtima(itens_totais, num_itens,m);
    if(m.capacidade<pesoMochila)
        printf("Solucao inviavel.\n");
    else
        if(melhor > valorMochila)
            printf("Solucao viavel mas nao otima.\n");
        else
            printf("Solucao otima.");
}