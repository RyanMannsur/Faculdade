#include <iostream>
#include <fstream>

#include <SOIL/SOIL.h>
#include <GL/glew.h>
#include <GL/freeglut.h>
#include <cmath>
#include "desenhaEsfera.h"
#include "iteracao.h"
using namespace std;

static int solTexture , mercurioTexture, venusTexture, terraTexture ,marsTexture; 
static int jupterTexture, saturnoTexture, uranoTexture, neturnoTexture, plutaoTexture;


// Configuração inicial do OpenGL e GLUT
void setup(void)
{
    glClearColor(0,0,0, 0.0);
    glEnable(GL_DEPTH_TEST);                        // Ativa teste Z

    // Propriedades do material da esfera
    float matAmbAndDif[] = {1.0, 1.0, 1.0, 1.0};    // cor ambiente e difusa: branca
    float matSpec[] = { 1.0, 1.0, 1,0, 1.0 };       // cor especular: branca

    // Definindo as propriedades do material
    glMaterialfv(GL_FRONT, GL_AMBIENT_AND_DIFFUSE, matAmbAndDif);
    glMaterialfv(GL_FRONT, GL_SPECULAR, matSpec);
    glMaterialfv(GL_FRONT, GL_SHININESS, matShine);

    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);

	// Carrega a textura
    marsTexture = SOIL_load_OGL_texture
	(
		"mars-small.jpg",
		SOIL_LOAD_AUTO,
		SOIL_CREATE_NEW_ID,
		SOIL_FLAG_INVERT_Y | SOIL_FLAG_NTSC_SAFE_RGB | SOIL_FLAG_COMPRESS_TO_DXT
	);
    solTexture = SOIL_load_OGL_texture
	(
		"sol.jpg",
		SOIL_LOAD_AUTO,
		SOIL_CREATE_NEW_ID,
		SOIL_FLAG_INVERT_Y | SOIL_FLAG_NTSC_SAFE_RGB | SOIL_FLAG_COMPRESS_TO_DXT
	);
        mercurioTexture = SOIL_load_OGL_texture
	(
		"mercurio.jfif",
		SOIL_LOAD_AUTO,
		SOIL_CREATE_NEW_ID,
		SOIL_FLAG_INVERT_Y | SOIL_FLAG_NTSC_SAFE_RGB | SOIL_FLAG_COMPRESS_TO_DXT
	);
        venusTexture = SOIL_load_OGL_texture
	(
		"venus.jfif",
		SOIL_LOAD_AUTO,
		SOIL_CREATE_NEW_ID,
		SOIL_FLAG_INVERT_Y | SOIL_FLAG_NTSC_SAFE_RGB | SOIL_FLAG_COMPRESS_TO_DXT
	);
        terraTexture = SOIL_load_OGL_texture
	(
		"terra.jfif",
		SOIL_LOAD_AUTO,
		SOIL_CREATE_NEW_ID,
		SOIL_FLAG_INVERT_Y | SOIL_FLAG_NTSC_SAFE_RGB | SOIL_FLAG_COMPRESS_TO_DXT
	);
        jupterTexture = SOIL_load_OGL_texture
	(
		"jupter.jfif",
		SOIL_LOAD_AUTO,
		SOIL_CREATE_NEW_ID,
		SOIL_FLAG_INVERT_Y | SOIL_FLAG_NTSC_SAFE_RGB | SOIL_FLAG_COMPRESS_TO_DXT
	);
        saturnoTexture = SOIL_load_OGL_texture
	(
		"saturno.jpg",
		SOIL_LOAD_AUTO,
		SOIL_CREATE_NEW_ID,
		SOIL_FLAG_INVERT_Y | SOIL_FLAG_NTSC_SAFE_RGB | SOIL_FLAG_COMPRESS_TO_DXT
	);
        uranoTexture = SOIL_load_OGL_texture
	(
		"urano.jpg",
		SOIL_LOAD_AUTO,
		SOIL_CREATE_NEW_ID,
		SOIL_FLAG_INVERT_Y | SOIL_FLAG_NTSC_SAFE_RGB | SOIL_FLAG_COMPRESS_TO_DXT
	);
        neturnoTexture = SOIL_load_OGL_texture
	(
		"neturno.jpg",
		SOIL_LOAD_AUTO,
		SOIL_CREATE_NEW_ID,
		SOIL_FLAG_INVERT_Y | SOIL_FLAG_NTSC_SAFE_RGB | SOIL_FLAG_COMPRESS_TO_DXT
	);
        plutaoTexture = SOIL_load_OGL_texture
	(
		"plutao.jpg",
		SOIL_LOAD_AUTO,
		SOIL_CREATE_NEW_ID,
		SOIL_FLAG_INVERT_Y | SOIL_FLAG_NTSC_SAFE_RGB | SOIL_FLAG_COMPRESS_TO_DXT
	);
    if(marsTexture == 0 || solTexture ==0 || mercurioTexture==0 || venusTexture==0 || terraTexture==0 || 
        jupterTexture==0 || saturnoTexture==0 || uranoTexture==0 || neturnoTexture==0 || plutaoTexture==0)
    {
        cout << "Problema ao carregar textura: " << SOIL_last_result() << endl;
    }

    // Não mostrar faces do lado de dentro
    glEnable(GL_CULL_FACE);
    glCullFace(GL_BACK);

    // Esconder o ponteiro do mouse quando dentro da janela
    glutSetCursor(GLUT_CURSOR_NONE);
}



// Callback de desenho
void desenhaCena()
{
    // Propriedades das fontes de luz
    float lightAmb[] = { 0.0, 0.0, 0.0, 1.0 };
    float lightDif0[] = { d, d, d, 1.0 };
    float lightSpec0[] = { e, e, e, 1.0 };
    float lightPos0[] = { 0.0, 0.0, 0.0, p };
    float lightDifAndSpec1[] = { 0.0, 1.0, 0.0, 1.0 };
    float lightPos1[] = { 0.0, 0.0, 0.0, 0.0 };
    float globAmb[] = { m, m, m, 1.0 };

    // Propriedades da fonte de luz LIGHT0
    glLightfv(GL_LIGHT0, GL_AMBIENT, lightAmb);
    glLightfv(GL_LIGHT0, GL_DIFFUSE, lightDif0);
    glLightfv(GL_LIGHT0, GL_SPECULAR, lightSpec0);

    // Propriedades da fonte de luz LIGHT1
    glLightfv(GL_LIGHT1, GL_AMBIENT, lightAmb);
    glLightfv(GL_LIGHT1, GL_DIFFUSE, lightDifAndSpec1);
    glLightfv(GL_LIGHT1, GL_SPECULAR, lightDifAndSpec1);

    glLightModelfv(GL_LIGHT_MODEL_AMBIENT, globAmb);        // Luz ambiente global
    glLightModeli(GL_LIGHT_MODEL_LOCAL_VIEWER, localViewer);// Enable local viewpoint

    // Ativa as fontes de luz (branca e verde)
    if (light0Ligada) {
        glEnable(GL_LIGHT0);
    } else {
        glDisable(GL_LIGHT0);
    }
    if (light1Ligada) {
        glEnable(GL_LIGHT1);
    } else {
        glDisable(GL_LIGHT1);
    }

    // Limpa a tela e o z-buffer
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

    glLoadIdentity();

    informacoesTela();

    // Posiciona a câmera de acordo com posição x,y do mouse na janela
   gluLookAt((xMouse-larguraJanela/2)/(larguraJanela/16), -1*(yMouse-alturaJanela/2)/(alturaJanela/16) + 3, zMouse,
              0, 0, 0,
              0, 1, 0);
    
     // Desabilita iluminação para desenhar as esferas que representam as luzes
    glDisable(GL_LIGHTING);

    // Light0 e esfera indicativa (ou seta)
    glPushMatrix();
        glRotatef(xAngle, 1.0, 0.0, 0.0); // Rotação no eixo x
        glRotatef(yAngle, 0.0, 1.0, 0.0); // Rotação no eixo y
        glLightfv(GL_LIGHT0, GL_POSITION, lightPos0);
        glTranslatef(lightPos0[0], lightPos0[1], lightPos0[2]);
        glColor3f(d, d, d);
    
        if (light0Ligada)
        {
            if (p) glutWireSphere(0.05, 8, 8); // Esfera indicativa
            else // Seta apontando na direção da fonte de luz direcional
            {
                glLineWidth(3.0);
                glBegin(GL_LINES);
                glVertex3f(0.0, 0.0, 0.25);
                glVertex3f(0.0, 0.0, -0.25);
                glVertex3f(0.0, 0.0, -0.25);
                glVertex3f(0.05, 0.0, -0.2);
                glVertex3f(0.0, 0.0, -0.25);
                glVertex3f(-0.05, 0.0, -0.2);
                glEnd();
                glLineWidth(1.0);
            }
        }
    glPopMatrix();

    // Light1 e sua esfera indicativa
    glPushMatrix();
        glLightfv(GL_LIGHT1, GL_POSITION, lightPos1);
        glTranslatef(lightPos1[0], lightPos1[1], lightPos1[2]);
        glColor3f(0.0, 1.0, 0.0);
        if (light1Ligada) glutWireSphere(0.05, 8, 8);
    glPopMatrix();

    if (isLightingOn) {
        glEnable(GL_LIGHTING);
    }

    // Define (atualiza) o valor do expoente de especularidade
    matShine[0] = s;
    glMaterialfv(GL_FRONT, GL_SHININESS, matShine);
    glColor3f(1, 1, 1);

    // Desenha a esfera grande e bem arredondada
    desenhaEsfera(2000, 1, 0.0, 0, 0,solTexture, 0, 0);
    desenhaEsfera(200, 0.2, 1.5, 0, 0, mercurioTexture, anguloEsfera1, anguloyEsfera1);
    desenhaEsfera(200, 0.5, 2.5, 0, 0, venusTexture, anguloEsfera2, anguloyEsfera2);
    desenhaEsfera(200, 0.35, 3.5, 0, 0, terraTexture, anguloEsfera3, anguloyEsfera3);
    desenhaEsfera(200, 0.25, 4.5, 0, 0, marsTexture, anguloEsfera4, anguloyEsfera4);
    desenhaEsfera(200, 0.5, 6, 0, 0, jupterTexture, anguloEsfera5, anguloyEsfera5);
    desenhaEsfera(200, 0.4, 8, 0, 0, saturnoTexture, anguloEsfera6, anguloyEsfera6);
    desenhaEsfera(200, 0.3, 8.5, 0, 0, uranoTexture, anguloEsfera7, anguloyEsfera7);
    desenhaEsfera(200, 0.3, 9.0, 0, 0, neturnoTexture, anguloEsfera8, anguloyEsfera8);
    desenhaEsfera(200, 0.2, 9.5, 0, 0, plutaoTexture, anguloEsfera9, anguloyEsfera9);

    glutSwapBuffers();
}

// Callback de redimensionamento
void resize(int w, int h)
{
    larguraJanela = w;
    alturaJanela = h;

    glViewport (0, 0, w, h);
    glMatrixMode (GL_PROJECTION);
    glLoadIdentity();
    gluPerspective(60.0, (float)w/(float)h, 1.0, 20.0);
    glMatrixMode(GL_MODELVIEW);
}

void posicionaCamera(int x, int y) {
    xMouse = xMouse;
    yMouse = yMouse;
    glutPostRedisplay();
}


int main(int argc, char *argv[])
{
    imprimirAjudaConsole();
    glutInit(&argc, argv);

    glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGBA | GLUT_DEPTH);
    glutInitWindowSize(500, 500);
    glutInitWindowPosition (100, 100);
    glutCreateWindow("Luz e Materiais");
    glutDisplayFunc(desenhaCena);
    glutReshapeFunc(resize);
    glutKeyboardFunc(keyInput);
    glutPassiveMotionFunc(posicionaCamera);
    glutSpecialFunc(specialKeyInput);
    rotaciona();

    setup();

    glutMainLoop();
}
