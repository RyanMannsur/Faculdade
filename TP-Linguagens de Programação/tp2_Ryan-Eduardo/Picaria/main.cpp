#include "Picaria.h"

#include <QApplication>

//Feito por Ryan Eduardo, algumas partes do codigo foram pega do codigo base disponivel no site
// da diciplina: http://rimsa.com.br/page/classes/decom009/

int main(int argc, char *argv[]) {
    QApplication a(argc, argv);
    Picaria w;

    w.show();

    return a.exec();
}
