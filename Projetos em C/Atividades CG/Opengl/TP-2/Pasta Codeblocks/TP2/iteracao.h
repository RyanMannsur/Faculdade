#ifndef ITERACAO_H_INCLUDED
#define ITERACAO_H_INCLUDED



#endif // ITERACAO_H_INCLUDED
using namespace std;
static long font = (long)GLUT_BITMAP_8_BY_13;   // Fonte usada para imprimir na tela
static char theStringBuffer[10];                // String buffer 
static bool isLightingOn = false;
static float d = 1.0;           // Intensidade da cor difusa da luz branca
static float e = 1.0;           // Intensidade da cor especular da luz branca
static float m = 0.2;           // Intensidade da luz ambiente global
static float p = 0.0;           // A luz branca é posicional?
static float s = 50.0;   
static bool light0Ligada = 0;   // Luz branca ligada?
static bool light1Ligada = 0;  
float matShine[] = { s };                       // expoente especular (shininess)
static float xAngle = 0.0, yAngle = 0.0;        // Rotação da luz branca
static float xMouse = 250, yMouse = 250, zMouse = 8;        // (x,y) do ponteiro do mouse
static float larguraJanela, alturaJanela;       // (w,h) da janela 
static bool localViewer = false;                 // Quantas subdivisões latitudinais/longitudinais da esfera



// Escreve uma cadeia de caracteres
void escreveTextoNaTela(void *font, char *string)
{
    char *c;
    for (c = string; *c != '\0'; c++) glutBitmapCharacter(font, *c);
}

// Converte um número decimal em string
void floatParaString(char * destStr, int precision, float val)
{
    sprintf(destStr,"%f",val);
    destStr[precision] = '\0';
}

// Escreve as informações variáveis na tela
void informacoesTela(void)
{
    glDisable(GL_LIGHTING); // Desabilita iluminação
    glColor3f(.85f, .85f, .85f);

    glRasterPos3f(-1.0, 1.10, -2.0);
    escreveTextoNaTela((void*)font, (char*)"Iluminacao (l): ");
    escreveTextoNaTela((void*)font, (char*)(isLightingOn ? "ligada" : "desligada"));

    glRasterPos3f(-1.0, 1.00, -2.0);
    escreveTextoNaTela((void*)font, (char*)"- Movimentar Camera: (setas/+/-)");
    glRasterPos3f(-1.0, 0.95, -2.0);
    escreveTextoNaTela((void*)font, (char*)"- Mudar Camera (1/2) ");
    escreveTextoNaTela((void*)font, theStringBuffer);
}


void keyInput(unsigned char key, int x, int y)
{
    switch (key)
    {
    case '1':
        xMouse = 250; yMouse = 250; zMouse = 8;
        break;
    case '2':
         xMouse = 0; yMouse = 20; zMouse = 0;
        //gluLookAt(0,20,0,  0,0,0,  1,0,0);
        break;
    case 'l':
    case 'L':
        isLightingOn = !isLightingOn;
        break;
    case 't':
    case 'T':
        usarTextura = !usarTextura;
        break;
    case '+':
        zMouse = zMouse+3;
        break;
    case '-':
        zMouse = zMouse-3;
        break;
    default:
        break;
    }
    glutPostRedisplay();
}

// Callback para setas do teclado
void specialKeyInput(int key, int x, int y)
{
    if(key == GLUT_KEY_DOWN)
    {
        xMouse = (xMouse+5);
    }
    if(key == GLUT_KEY_UP)
    {
        xMouse = (xMouse-5);
    }
    if(key == GLUT_KEY_RIGHT)
    {
        yMouse = (yMouse+5);
    }
    if(key == GLUT_KEY_LEFT)
    {
        yMouse = (yMouse-5);
    }
    glutPostRedisplay();
}

void imprimirAjudaConsole(void)
{
    cout << "Ajuda:" << endl;
    cout << "  Aperte 'l' para ligar/desligar a iluminacao do OpenGL." << endl
         << "  Aperte 't' para alternar entre modo com/sem textura." << endl
         << "  Aperte '+/-' para mover a camera." << endl
         << "  Aperte as setas para rotacionar a Camera" << endl;
}
