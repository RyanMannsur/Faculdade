#include <gl/glut.h>

GLfloat angle, fAspect;
GLdouble obsX=0, obsY=0, obsZ=200; //acrescente esta linha

// Função callback chamada para fazer o desenho
void Desenha(void)
{
	//glClear(GL_COLOR_BUFFER_BIT);
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

	glColor3f(0.0f, 0.0f, 1.0f);
    

	// Desenha o teapot com a cor corrente (wire-frame)
	//glutWireTeapot(50.0f);
    glutSolidTeapot(50.0f);


    /* // Desenha um cubo
	glBegin(GL_POLYGON);	// Face posterior
		glNormal3f(0,0,1);  // Normal da face
		glVertex3f(50.0, 50.0, 50.0);
		glVertex3f(-50.0, 50.0, 50.0);
		glVertex3f(-50.0, -50.0, 50.0);
		glVertex3f(50.0, -50.0, 50.0);
	glEnd();

	glBegin(GL_POLYGON);	// Face frontal
		glNormal3f(0,0,-1); // Normal da face
		glVertex3f(50.0, 50.0, -50.0);
		glVertex3f(50.0, -50.0, -50.0);
		glVertex3f(-50.0, -50.0, -50.0);
		glVertex3f(-50.0, 50.0, -50.0);
	glEnd();

	glBegin(GL_POLYGON);	// Face lateral esquerda
		glNormal3f(-1,0,0); // Normal da face
		glVertex3f(-50.0, 50.0, 50.0);
		glVertex3f(-50.0, 50.0, -50.0);
		glVertex3f(-50.0, -50.0, -50.0);
		glVertex3f(-50.0, -50.0, 50.0);
	glEnd();

	glBegin(GL_POLYGON);	// Face lateral direita
		glNormal3f(1,0,0);  // Normal da face
		glVertex3f(50.0, 50.0, 50.0);
		glVertex3f(50.0, -50.0, 50.0);
		glVertex3f(50.0, -50.0, -50.0);
		glVertex3f(50.0, 50.0, -50.0);
	glEnd();

	glBegin(GL_POLYGON);	// Face superior
		glNormal3f(0,1,0);  // Normal da face
		glVertex3f(-50.0, 50.0, -50.0);
		glVertex3f(-50.0, 50.0, 50.0);
		glVertex3f(50.0, 50.0, 50.0);
		glVertex3f(50.0, 50.0, -50.0);
	glEnd();

	glBegin(GL_POLYGON);	// Face inferior
		glNormal3f(0,-1,0); // Normal da face
		glVertex3f(-50.0, -50.0, -50.0);
		glVertex3f(50.0, -50.0, -50.0);
		glVertex3f(50.0, -50.0, 50.0);
		glVertex3f(-50.0, -50.0, 50.0);
	glEnd();*/

	// Executa os comandos OpenGL
	glutSwapBuffers();
 }

// Inicializa parâmetros de rendering
void Inicializa (void)
{ 
	GLfloat luzAmbiente[4]={0.2,0.2,0.2,1.0};
    //GLfloat luzAmbiente[4]={0.1,0.1,0.1,1.0};
    //GLfloat luzAmbiente[4]={0.4,0.4,0.4,1.0};
    //GLfloat luzAmbiente[4]={0.8,0.8,0.8,1.0};
	GLfloat luzDifusa[4]={0.7,0.7,0.7,1.0};	   // "cor" 
	GLfloat luzEspecular[4]={1.0, 1.0, 1.0, 1.0};// "brilho" 
    //GLfloat luzEspecular[4]={1.0, 0.0, 0.0, 1.0};
	GLfloat posicaoLuz[4]={0.0, 50.0, 50.0, 1.0};

	// Capacidade de brilho do material
	//GLfloat especularidade[4]={1.0,1.0,1.0,1.0}; 
	//GLint especMaterial = 60;
    //GLint especMaterial = 10;

    // GLfloat especularidade[4]={1.0,1.0,1.0,1.0}; 
    // GLint especMaterial = 60; 
    // glMaterialfv(GL_FRONT,GL_SPECULAR, especularidade); 
    // glMateriali(GL_FRONT,GL_SHININESS,especMaterial); 
    // glLightfv(GL_LIGHT0, GL_SPECULAR, luzEspecular );

 	// Especifica que a cor de fundo da janela será preta
	glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
	
	// Habilita o modelo de colorização de Gouraud
	//glShadeModel(GL_SMOOTH);
    glShadeModel(GL_FLAT);

	// Define a refletância do material 
	//glMaterialfv(GL_FRONT,GL_SPECULAR, especularidade);
	// Define a concentração do brilho
	//glMateriali(GL_FRONT,GL_SHININESS,especMaterial);

	// Ativa o uso da luz ambiente 
	glLightModelfv(GL_LIGHT_MODEL_AMBIENT, luzAmbiente);

	// Define os parâmetros da luz de número 0
	glLightfv(GL_LIGHT0, GL_AMBIENT, luzAmbiente); 
	glLightfv(GL_LIGHT0, GL_DIFFUSE, luzDifusa );
	//glLightfv(GL_LIGHT0, GL_SPECULAR, luzEspecular );
	glLightfv(GL_LIGHT0, GL_POSITION, posicaoLuz );

	// Habilita a definição da cor do material a partir da cor corrente
	glEnable(GL_COLOR_MATERIAL);
	//Habilita o uso de iluminação
	glEnable(GL_LIGHTING);  
	// Habilita a luz de número 0
	glEnable(GL_LIGHT0);
	// Habilita o depth-buffering
	glEnable(GL_DEPTH_TEST);

	angle=45;
}

/*void Inicializa (void)
{ 
    glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
    angle=45;
}*/

// Função usada para especificar o volume de visualização
void EspecificaParametrosVisualizacao(void)
{
	// Especifica sistema de coordenadas de projeção
	glMatrixMode(GL_PROJECTION);
	// Inicializa sistema de coordenadas de projeção
	glLoadIdentity();

	// Especifica a projeção perspectiva
    gluPerspective(angle,fAspect,0.5,500);

	// Especifica sistema de coordenadas do modelo
	glMatrixMode(GL_MODELVIEW);
	// Inicializa sistema de coordenadas do modelo
	glLoadIdentity();

	// Especifica posição do observador e do alvo
    gluLookAt(0,80,200, 0,0,0, 0,1,0);
    //gluLookAt(obsX,obsY,obsZ, 0,0,0, 0,1,0);
}

// Função callback chamada quando o tamanho da janela é alterado 
void AlteraTamanhoJanela(GLsizei w, GLsizei h)
{
	// Para previnir uma divisão por zero
	if ( h == 0 ) h = 1;

	// Especifica o tamanho da viewport
    glViewport(0, 0, w, h);
 
	// Calcula a correção de aspecto
	fAspect = (GLfloat)w/(GLfloat)h;

	EspecificaParametrosVisualizacao();
}

// Função callback chamada para gerenciar eventos do mouse
void GerenciaMouse(int button, int state, int x, int y)
{
	if (button == GLUT_LEFT_BUTTON)
		if (state == GLUT_DOWN) {  // Zoom-in
			if (angle >= 10) angle -= 5;
		}
	if (button == GLUT_RIGHT_BUTTON)
		if (state == GLUT_DOWN) {  // Zoom-out
			if (angle <= 130) angle += 5;
		}
	EspecificaParametrosVisualizacao();
	glutPostRedisplay();
}

void SpecialKeys(int key, int x, int y)
        {
		switch (key) {
			case GLUT_KEY_LEFT : 
								obsX -=10;
								break;
			case GLUT_KEY_RIGHT : 
								obsX +=10;
								break;
			case GLUT_KEY_UP : 
								obsY +=10;
								break;
			case GLUT_KEY_DOWN : 
								obsY -=10;
								break;

			case GLUT_KEY_HOME : 
								obsZ +=10;
								break;
			case GLUT_KEY_END : 
								obsZ -=10;
								break;
		}
		glLoadIdentity();
		gluLookAt(obsX,obsY,obsZ, 0,0,0, 0,1,0);
        	glutPostRedisplay();
        }


// Programa Principal
int main(int argc, char *argv[])
{
	glutInit(&argc, argv);
    glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB);
    //glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB | GLUT_DEPTH);
    glutInitWindowSize(350,300);
	glutCreateWindow("Visualizacao 3D");
	glutDisplayFunc(Desenha);
    glutReshapeFunc(AlteraTamanhoJanela);
	glutMouseFunc(GerenciaMouse);
    glutSpecialFunc(SpecialKeys);
	Inicializa();
	glutMainLoop();
}
