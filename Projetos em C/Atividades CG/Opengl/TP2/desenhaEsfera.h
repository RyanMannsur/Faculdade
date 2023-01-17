#ifndef DESENHAESFERA_H_INCLUDED
#define DESENHAESFERA_H_INCLUDED



#endif // DESENHAESFERA_H_INCLUDED


static bool usarTextura = true;

static float anguloEsfera1 = 0,anguloEsfera2 = 0,anguloEsfera3 = 0,anguloEsfera4 = 0,anguloEsfera5 = 0,anguloEsfera6 = 0;
static float anguloEsfera7 = 0, anguloEsfera8 = 0,anguloEsfera9 = 0;  // Rotação da esfera em torno do sol
static float anguloyEsfera1 = 0,anguloyEsfera2 = 0,anguloyEsfera3 = 0,anguloyEsfera4 = 0,anguloyEsfera5 = 0,anguloyEsfera6 = 0;
static float anguloyEsfera7 = 0, anguloyEsfera8 = 0,anguloyEsfera9 = 0; // rotação em torno do eixo 

void rotacionaEsfera() {
    anguloEsfera1 += .8f;
    anguloEsfera2 += .2f;
    anguloEsfera3 += .5f;
    anguloEsfera4 += .6f;
    anguloEsfera5 += .4f;
    anguloEsfera6 += .5f;
    anguloEsfera7 += .7f;
    anguloEsfera8 += .6f;
    anguloEsfera9 += .8f;
    anguloyEsfera1 += .32f;
    anguloyEsfera2 += .8f;
    anguloyEsfera3 += .50f;
    anguloyEsfera4 += .24f;
    anguloyEsfera5 += .16f;
    anguloyEsfera6 += .20f;
    anguloyEsfera7 += .28f;
    anguloyEsfera8 += .24f;
    anguloyEsfera9 += .32f;
    glutPostRedisplay();
}


void rotaciona(){
    glutIdleFunc(rotacionaEsfera);
}


void solidSphere(float radius, int stacks, int columns)
{
    // cria uma quádrica
    GLUquadric* quadObj = gluNewQuadric();
    // estilo preenchido... poderia ser GLU_LINE, GLU_SILHOUETTE
    // ou GLU_POINT
    gluQuadricDrawStyle(quadObj, GLU_FILL);
    // chama 01 glNormal para cada vértice.. poderia ser
    // GLU_FLAT (01 por face) ou GLU_NONE
    gluQuadricNormals(quadObj, GLU_SMOOTH);
    // chama 01 glTexCoord por vértice
    gluQuadricTexture(quadObj, GL_TRUE);
    // cria os vértices de uma esfera
    gluSphere(quadObj, radius, stacks, columns);
    // limpa as variáveis que a GLU usou para criar
    // a esfera
    gluDeleteQuadric(quadObj);
}


void desenhaEsfera(int esferaLados, float radiano, float translx,float transly,float translz,int textura,float angulo, float angulo2)
{
    if (usarTextura) {
        glEnable(GL_TEXTURE_2D);
        glBindTexture(GL_TEXTURE_2D, textura);
    }
    glPushMatrix();
        glRotatef(angulo, 0, 1, 0); //angulo de rotação em torno do sol
        glRotatef(90, 1, 0, 0);
        glTranslatef(translx,transly,translz); //translação no eixo x 
        glRotatef(angulo2, 0, 1, 0); //angulo de rotação no proprio eixo e eixo
        glRotatef(-90, 1, 0, 0);
        solidSphere(radiano, esferaLados, esferaLados);
        glTranslatef(translx,transly,translz);
    glPopMatrix();
    if (usarTextura) {
        glDisable(GL_TEXTURE_2D);
    }
}
