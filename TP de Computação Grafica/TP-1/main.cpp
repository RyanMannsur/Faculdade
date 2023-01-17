#include <SOIL/SOIL.h>
#include <GL/glew.h>
#include <GL/freeglut.h>
#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include <time.h>

#define nInimigos 24
#define nTiros 5

GLuint idTexturaPause;
GLuint idTexturaCenario;
GLuint idTexturaCenario2;
GLuint idTexturaNave;
GLuint idTexturaInimigo;
GLuint idTexturaTelaInicial;

struct Bloco{
	float x;
	float y;
	float comp;
	float alt;
	bool vivo;
	float velX;
	float velY;
}; 


int disparo = 0;
bool jogoPausado = false, iniciar = false;
int p=0;

void inicializaInimigos();
void inicializaNave();
void inicializaTiros();
void inicializaTirosInimigos();
bool colisao(struct Bloco a, struct Bloco b);


struct Bloco inimigos[nInimigos];
struct Bloco nave;
struct Bloco tiro[nTiros];
struct Bloco tirosInimigos[nInimigos];

GLuint carregaTextura(const char* arquivo) {
    GLuint idTextura = SOIL_load_OGL_texture(
                           arquivo,
                           SOIL_LOAD_AUTO,
                           SOIL_CREATE_NEW_ID,
                           SOIL_FLAG_INVERT_Y
                       );

    if (idTextura == 0) {
        printf("Erro do SOIL: '%s'\n", SOIL_last_result());
    }

    return idTextura;
}

void telaInicial(){
	// Habilita o uso de texturas
    glEnable(GL_TEXTURE_2D);

    // Começa a usar a textura que criamos
    glBindTexture(GL_TEXTURE_2D, idTexturaTelaInicial);
    glBegin(GL_TRIANGLE_FAN);
        // Associamos um canto da textura para cada vértice
        glTexCoord2f(0, 0);
        glVertex3f(0, 0,  0);

        glTexCoord2f(1, 0);
        glVertex3f(600, 0,  0);

        glTexCoord2f(1, 1);
        glVertex3f(600,  400,  0);

        glTexCoord2f(0, 1);
        glVertex3f(0,  400,  0);
    glEnd();
    glDisable(GL_TEXTURE_2D);
    
    glFlush();
}

void inicializa() {
    glClearColor(1, 1, 1, 1);
    // habilita mesclagem de cores, para termos suporte a texturas
    // com transparência
    glEnable(GL_BLEND );
    glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

    idTexturaCenario = carregaTextura("cenario.jpg");
    idTexturaCenario2 = carregaTextura("cenario2.jpg");
    idTexturaNave = carregaTextura("nave.png");
    idTexturaInimigo = carregaTextura("inimigo.png");
    idTexturaTelaInicial = carregaTextura("TelaInicial.png");
    idTexturaPause = carregaTextura("Pausa.png");
    
    inicializaInimigos();
    inicializaNave();
    inicializaTiros();
    inicializaTirosInimigos();
    
}

void desenhaQuadrado(struct Bloco b){

	//glClearColor(1, 1, 1, 1);  

	//glColor3f(0, 1, 1);

	glBegin(GL_TRIANGLE_FAN);
		glTexCoord2f(0, 0); //
        glVertex3f(b.x, b.y, 0.0);
        glTexCoord2f(1, 0); //
        glVertex3f(b.x + b.comp, b.y, 0.0);
        glTexCoord2f(1, 1);
        glVertex3f(b.x + b.comp, b.y + b.alt, 0.0);
        glTexCoord2f(0, 1);
        glVertex3f(b.x, b.y + b.alt, 0.0);
    glEnd();
    
    glFlush();

}

void desenha() {
    glClear(GL_COLOR_BUFFER_BIT);
    glColor3f (1, 1, 1);
    
    // Habilita o uso de texturas
    glEnable(GL_TEXTURE_2D);

    // Começa a usar a textura que criamos
    glBindTexture(GL_TEXTURE_2D, idTexturaCenario2);
    glBegin(GL_TRIANGLE_FAN);
        // Associamos um canto da textura para cada vértice
        glTexCoord2f(0, 0);
        glVertex3f(0, 0,  0);

        glTexCoord2f(1, 0);
        glVertex3f(600, 0,  0);

        glTexCoord2f(1, 1);
        glVertex3f(600,  600,  0);

        glTexCoord2f(0, 1);
        glVertex3f(0,  600,  0);
    glEnd();
    glDisable(GL_TEXTURE_2D);
    
	//desenha a nave:
	glEnable(GL_TEXTURE_2D);
	glBindTexture(GL_TEXTURE_2D, idTexturaNave);
	desenhaQuadrado(nave);
	glDisable(GL_TEXTURE_2D);
	
	//DESENHA OS TIROS:
	for(int i=0; i<nTiros; i++){
		if(tiro[i].vivo == true){
			desenhaQuadrado(tiro[i]);
			tiro[i].y += tiro[i].velY;
		}	 	
		if(tiro[i].y > 400){
	 		tiro[i].y = 70;
	 		tiro[i].vivo = false;
	 	}
	}
	
	
	//verifica colisao entre os tiros e os inimigos:
	for(int i=0; i<nInimigos; i++){
		if(inimigos[i].vivo == true){
			for(int j=0; j<nTiros; j++){
				if(colisao(tiro[j], inimigos[i]) == true){
					tiro[j].vivo = false;
					tiro[j].y = 70;
					inimigos[i].vivo = false;
				}
			}
	 	}
	}
	
	//DESENHA OS INIMIGOS:
	//glColor3f(0, 1, 1);
	glEnable(GL_TEXTURE_2D);
	glBindTexture(GL_TEXTURE_2D, idTexturaInimigo);
	for(int i=0; i<nInimigos; i++){
		if(inimigos[i].vivo == true){
    		desenhaQuadrado(inimigos[i]);	
	 	}
	}
	glDisable(GL_TEXTURE_2D);
	
	//DESENHA OS TIROS INIMIGOS:
	glColor3f(1, 1, 1);
	for(int i=0; i<nInimigos; i++){
		if(tirosInimigos[i].vivo == true){
			desenhaQuadrado(tirosInimigos[i]);
		}	 	
		if(tirosInimigos[i].y > 400){
	 		tirosInimigos[i].y = 70;
	 		//tiro[i].vivo = false;
	 	}
	 	tirosInimigos[i].x = inimigos[i].x + (inimigos[i].comp/2 - tirosInimigos[i].comp/2);
		tirosInimigos[i].y = inimigos[i].y - 10;
	}

	//VERIFICA SE ALGUM INIMIGO BATEU NA PAREDE:
	for(int i=0; i<nInimigos; i++){
		if(inimigos[i].x + inimigos[i].comp >= 600 || inimigos[i].x <= 0){
			for(int i=0; i<nInimigos; i++){
				inimigos[i].velX = -inimigos[i].velX;
                inimigos[i].y = inimigos[i].y - 3; //inimigos descem
			}	
		}
	}
	//MOVE OS INIMIGOS:
	for(int i=0; i<nInimigos; i++){
		inimigos[i].x += inimigos[i].velX;
	}
	
	if(iniciar == false){
    	telaInicial();
    }
	
	if(jogoPausado == true){
		glEnable(GL_TEXTURE_2D);
		glBindTexture(GL_TEXTURE_2D, idTexturaPause);
    	glBegin(GL_TRIANGLE_FAN);
        // Associamos um canto da textura para cada vértice
       	glTexCoord2f(0, 0);
        glVertex3f(0, 0,  0);

        glTexCoord2f(1, 0);
        glVertex3f(600, 0,  0);

        glTexCoord2f(1, 1);
        glVertex3f(600,  400,  0);

        glTexCoord2f(0, 1);
        glVertex3f(0,  400,  0);
    glEnd();
    glDisable(GL_TEXTURE_2D);
    }
	
	glutSwapBuffers();
   	
}

void redimensiona(int w, int h) {
    glViewport(0, 0, w, h);

    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    glOrtho(0, 600, 0, 400, -1.0, 1.0);

    glMatrixMode(GL_MODELVIEW);
}

void atualiza() {
	if(jogoPausado == false)
    	glutPostRedisplay();

}

void inicializaInimigos(){
	for(int i=0, x=75, y=340; i<nInimigos; i++, x+=60){    	
    	if(x>=520){
    		x = 75;
    		y -= 50;
    	}
    	inimigos[i].x = x;
    	inimigos[i].y = y;
    	inimigos[i].comp = 20;
    	inimigos[i].alt = 15;
    	inimigos[i].vivo = true;
    	inimigos[i].velX = 2;
    	inimigos[i].velY = 0;
	}	
}

void inicializaNave(){
	nave.x = 280;
	nave.y = 30;
	nave.comp = 40;
	nave.alt = 40;
	nave.vivo = true;
	nave.velX = 6;
	nave.velY = 0;
}

void inicializaTiros(){
	for(int i=0; i<nTiros; i++){
		tiro[i].x = 295;
		tiro[i].y = 70;
		tiro[i].comp = 10;
		tiro[i].alt = 10;
		tiro[i].vivo = false;
		tiro[i].velX = 0;
		tiro[i].velY = 8;
	}
}

void inicializaTirosInimigos(){
	for(int i=0; i<nInimigos; i++){
		tirosInimigos[i].x = inimigos[i].x + inimigos[i].comp/2;
		tirosInimigos[i].y = inimigos[i].y - 10;
		tirosInimigos[i].comp = 10;
		tirosInimigos[i].alt = 10;
		tirosInimigos[i].vivo = true;;
		tirosInimigos[i].velX = 0;
		tirosInimigos[i].velY = 8;
	}
}

void movimentoTeclado(int buttom, int x, int y){
	if(jogoPausado == false){
		if(buttom == GLUT_KEY_RIGHT){
			if(nave.x < 560){
				nave.x += nave.velX;
			}
		}
		if(buttom == GLUT_KEY_LEFT){
			if(nave.x > 0){
				nave.x -= nave.velX;
			}
		}  
	}
}

void keyboard (unsigned char key, int x, int y) 
{
    switch(key)
    {
        case 27:
            exit (0);  
            break;
        case 'P':
        	if(p % 2 == 0){
				jogoPausado = true;
			}
			else{
				jogoPausado = false;
			}
			p++;
			break;
		case 'p':
			if(p % 2 == 0){
				jogoPausado = true;
			}
			else{
				jogoPausado = false;
			}
			p++;
			break;
		case 32:
			if(jogoPausado == false){
				if(iniciar == false){
					iniciar = true;
					break;
				}
				if(tiro[disparo].y == 70){
					tiro[disparo].vivo = true;
					tiro[disparo].x = nave.x + (nave.comp/2 - tiro[disparo].comp/2);
					disparo++;
					if(disparo > 4){
						disparo = 0;
					}
				}
			}
        default:       
            break;
    }
}

bool colisao(struct Bloco a, struct Bloco b){
	if(a.x + a.comp >= b.x && a.x < b.x + b.comp && a.y + a.alt >= b.y && a.y < b.y + b.alt){
		return true;
	} 
	return false;

}


void MouseClick(int button, int state, int x, int y){
    if(button == GLUT_LEFT_BUTTON){
        if(x>=399 && x<=788 && y>=371 && y<=438) 
            if(jogoPausado == false){
				if(iniciar == false){
					iniciar = true;
				}
            }
        //if(x>=386 && x<=814 && y>=487 && y<=549)
          //  glutDisplayFunc(instruções);
        if(x>=498 && x<=651 && y>=586 && y<=656)
            exit(0);
     }
}


int main(int argc, char** argv) {
	int kk = 0;
    glutInit(&argc, argv);
    glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB);
    glutInitWindowSize(1200, 800);
    glutInitWindowPosition(100, 100);

    glutCreateWindow("Carregando textura com SOIL");
	
    glutReshapeFunc(redimensiona);

    glutDisplayFunc(desenha);

    glutMouseFunc(MouseClick);
  
    inicializa();
    
    glutSpecialFunc(movimentoTeclado);
    glutKeyboardFunc(keyboard);
    
    
   	//glutTimerFunc(0, movimentoInimigo, 33);
    
    glutIdleFunc(atualiza);
    glutMainLoop();
    
    return 0;
}

