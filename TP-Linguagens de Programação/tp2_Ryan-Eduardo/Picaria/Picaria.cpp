#include "Picaria.h"
#include "ui_Picaria.h"

#include <QDebug>
#include <QMessageBox>
#include <QActionGroup>
#include <QSignalMapper>
#include <vector>

Picaria::Player state2player(Hole::State state) {
    switch (state) {
        case Hole::RedState:
            return Picaria::RedPlayer;
        case Hole::BlueState:
            return Picaria::BluePlayer;
        default:
            Q_UNREACHABLE();
    }
}

Hole::State player2state(Picaria::Player player) {
    return player == Picaria::RedPlayer ? Hole::RedState : Hole::BlueState;
}

Picaria::Picaria(QWidget *parent)
    : QMainWindow(parent),
      ui(new Ui::Picaria),
      m_mode(Picaria::NineHoles),
      m_player(Picaria::RedPlayer),
      m_phase(Picaria::DropPhase),
      count_blue(0),
      count_red(0),
      m_dropCount(0),
      qntdSelec(0) {

    ui->setupUi(this);

    QActionGroup* modeGroup = new QActionGroup(this);
    modeGroup->setExclusive(true);
    modeGroup->addAction(ui->action9holes);
    modeGroup->addAction(ui->action13holes);

    QObject::connect(ui->actionNew, SIGNAL(triggered(bool)), this, SLOT(reset()));
    QObject::connect(ui->actionQuit, SIGNAL(triggered(bool)), qApp, SLOT(quit()));
    QObject::connect(modeGroup, SIGNAL(triggered(QAction*)), this, SLOT(updateMode(QAction*)));
    QObject::connect(this, SIGNAL(modeChanged(Picaria::Mode)), this, SLOT(reset()));
    QObject::connect(ui->actionAbout, SIGNAL(triggered(bool)), this, SLOT(showAbout()));
    QObject::connect(this, SIGNAL(gameOver(Player)), this, SLOT(showGameOver(Player)));
    QObject::connect(this, SIGNAL(gameOver(Player)), this, SLOT(reset()));

    QSignalMapper* map = new QSignalMapper(this);
    for (int id = 0; id < 13; ++id) {
        QString holeName = QString("hole%1").arg(id+1, 2, 10, QChar('0'));
        Hole* hole = this->findChild<Hole*>(holeName);
        Q_ASSERT(hole != nullptr);

        m_holes[id] = hole;
        map->setMapping(hole, id);
        QObject::connect(hole, SIGNAL(clicked(bool)), map, SLOT(map()));
    }
#if QT_VERSION < QT_VERSION_CHECK(6,0,0)
    QObject::connect(map, SIGNAL(mapped(int)), this, SLOT(play(int)));
#else
    QObject::connect(map, SIGNAL(mappedInt(int)), this, SLOT(play(int)));
#endif

    this->reset();
    this->adjustSize();
    this->setFixedSize(this->size());
}

Picaria::~Picaria() {
    delete ui;
}

void Picaria::setMode(Picaria::Mode mode) {
    if (m_mode != mode) {
        m_mode = mode;
        emit modeChanged(mode); //se o modo novo for dirente emite um sinal.
    }
}

void Picaria::switchPlayer() {
    m_player = m_player == Picaria::RedPlayer ? //é vermelho, se sim vira azul, se não vermelho
                    Picaria::BluePlayer : Picaria::RedPlayer;
    this->updateStatusBar();
}

void Picaria::play(int id) {
    Hole* hole = m_holes[id];
    switch (m_phase) {
        case
            Picaria::DropPhase: drop(hole); break;
        case
            Picaria::MovePhase: move(hole); break;
        default:
            Q_UNREACHABLE();
    }
}

void Picaria::drop(Hole* hole){ //fase de colocar
    if(hole->state() == Hole::EmptyState){
        hole->setState(player2state(m_player));
        if(player2state(m_player) == Hole::BlueState){
            h_blue[count_blue] = hole; //vetor util pra ver se ganhou
            count_blue++;
            //qDebug() << "clicked on: " << hole->objectName();
        }else{
                h_red[count_red] = hole;
                count_red++;
        }
        if(isGameOver()){
            emit gameOver(m_player);
        }
        else{
            this->switchPlayer();
            ++m_dropCount;
            if(m_dropCount > 5)
                m_phase = Picaria::MovePhase;
        }
    }
    updateStatusBar();
}

int Picaria::posicao(Hole* h, Hole* hole[],int aux){ //função util para fase move
    int posicao = 0;
    for(int i=0;i<aux;i++){
        if(h == hole[i]){
            posicao = i;
        }
    }
    return posicao;
}

bool Picaria::norte(Hole* hole){ //função para ver vizinhança do buraco
    int id = posicao(hole,m_holes,13);
    switch (id) {
        case 5:
        case 6:
        case 7:
        case 10:
        case 11:
        case 12:
            if(m_holes[id-5]->state() == Hole::EmptyState){
                return true;
            }break;
        default: return false;
    }
    return false;
}

bool Picaria::sul(Hole* hole){
    int id = posicao(hole,m_holes,13);
    switch (id) {
        case 5:
        case 6:
        case 7:
        case 0:
        case 1:
        case 2:
            if(m_holes[id+5]->state() == Hole::EmptyState){
                return true;
            }break;
        default: return false;
    }
    return false;
}

bool Picaria::leste(Hole* hole){
    int id = posicao(hole,m_holes,13);
    switch (id) {
        case 0:
        case 1:
        case 5:
        case 6:
        case 10:
        case 11:
            if(m_holes[id+1]->state() == Hole::EmptyState){
                return true;
            }break;
        default: return false;
    }
    return false;
}

bool Picaria::oeste(Hole* hole){
    int id = posicao(hole,m_holes,13);
    switch (id) {
        case 1:
        case 2:
        case 6:
        case 7:
        case 11:
        case 12:
            if(m_holes[id-1]->state() == Hole::EmptyState){
                return true;
            }break;
        default: return false;
    }
    return false;
}

bool Picaria::nordeste(Hole* hole){
    int id = posicao(hole,m_holes,13);
    switch (id) {
        case 3:
        case 4:
        case 5:
        case 6:
        case 8:
        case 9:
        case 10:
        case 11:
            if( m_mode == Picaria::ThirteenHoles){
                if(m_holes[id-2]->state() == Hole::EmptyState)
                    return true;
            }else
                if(m_holes[id-(2*2)]->state() == Hole::EmptyState){
                    return true;
                } break;
        default: return false;
    }
    return false;
}

bool Picaria::noroeste(Hole* hole){
    int id = posicao(hole,m_holes,13);
    switch (id) {
        case 3:
        case 4:
        case 6:
        case 7:
        case 8:
        case 9:
        case 11:
        case 12:
            if( m_mode == Picaria::ThirteenHoles){
                if(m_holes[id-3]->state() == Hole::EmptyState)
                    return true;
            }else
                if(m_holes[id-(3*2)]->state() == Hole::EmptyState){
                    return true;
                } break;
        default: return false;
    }
    return false;
}

bool Picaria::sudeste(Hole* hole){
    int id = posicao(hole,m_holes,13);
    switch (id) {
        case 0:
        case 1:
        case 3:
        case 4:
        case 5:
        case 6:
        case 8:
        case 9:
            if(m_mode == Picaria::ThirteenHoles){
                if(m_holes[id+3]->state() == Hole::EmptyState)
                    return true;
            }else
                if(m_holes[id+(3*2)]->state() == Hole::EmptyState){
                    return true;
                } break;
        default: return false;
    }
    return false;
}

bool Picaria::suldoeste(Hole* hole){
    int id = posicao(hole,m_holes,13);
    switch (id) {
        case 1:
        case 2:
        case 3:
        case 4:
        case 6:
        case 7:
        case 8:
        case 9:
            if( m_mode == Picaria::ThirteenHoles){
                if(m_holes[id+2]->state() == Hole::EmptyState)
                    return true;
            }else
                if(m_holes[id+(2*2)]->state() == Hole::EmptyState){
                    return true;
            }break;
        default: return false;
    }
    return false;
}



void Picaria::selectable(Hole *hole){ //funão que defino os selecionaveis
    int id = posicao(hole,m_holes,13);
    if(norte(hole)){ //C
        m_holes[id-5]->setState(Hole::SelectableState);
        selecionaveis[qntdSelec] = m_holes[id-5];
        qntdSelec++;
    }
    if(sul(hole)){//C
        m_holes[id+5]->setState(Hole::SelectableState);
        selecionaveis[qntdSelec] = m_holes[id+5];
        qntdSelec++;
    }
    if(leste(hole)){//C
        m_holes[id+1]->setState(Hole::SelectableState);
        selecionaveis[qntdSelec] = m_holes[id+1];
        qntdSelec++;
    }
    if(oeste(hole)){//C
        m_holes[id-1]->setState(Hole::SelectableState);
        selecionaveis[qntdSelec] = m_holes[id-1];
        qntdSelec++;
    }
    if(noroeste(hole)){//C
        if(m_mode == Picaria::ThirteenHoles){
            m_holes[id-3]->setState(Hole::SelectableState);
            selecionaveis[qntdSelec] = m_holes[id-3];
            qntdSelec++;
         }
        else{ //diferença do de 13 para o de 9
            m_holes[id-(3*2)]->setState(Hole::SelectableState);
            selecionaveis[qntdSelec] = m_holes[id-(3*2)];
            qntdSelec++;
        }
    }
    if(nordeste(hole)){//C
        if(m_mode == Picaria::ThirteenHoles){
            m_holes[id-2]->setState(Hole::SelectableState);
            selecionaveis[qntdSelec] = m_holes[id-2];
            qntdSelec++;
       }else{
            m_holes[id-(2*2)]->setState(Hole::SelectableState);
            selecionaveis[qntdSelec] = m_holes[id-(2*2)];
            qntdSelec++;
        }
    }
    if(suldoeste(hole)){//C
        if(m_mode == Picaria::ThirteenHoles){
            m_holes[id+2]->setState(Hole::SelectableState);
            selecionaveis[qntdSelec] = m_holes[id+2];
            qntdSelec++;
         }else{
            m_holes[id+(2*2)]->setState(Hole::SelectableState);
            selecionaveis[qntdSelec] = m_holes[id+(2*2)];
            qntdSelec++;
        }
    }
    if(sudeste(hole)){//C
        if(m_mode == Picaria::ThirteenHoles){
            m_holes[id+3]->setState(Hole::SelectableState);
            selecionaveis[qntdSelec] = m_holes[id+3];
            qntdSelec++;
        }else{
            m_holes[id+(3*2)]->setState(Hole::SelectableState);
            selecionaveis[qntdSelec] = m_holes[id+(3*2)];
            qntdSelec++;
        }
    }
}

void Picaria::deixarVazio(){ //deixa vazio o vetor com selecionaveis
    for(int i=0; i<qntdSelec;i++){
        selecionaveis[i]->setState(Hole::EmptyState);
    }
}

void Picaria::move(Hole* hole){ //fase de mover
    int aux = 0;
    if(hole->state() == Hole::SelectableState){
        deixarVazio(); //limpar vetor de selecionaveis
        hole->setState(player2state(m_player));
        qntdSelec = 0;
        if(player2state(m_player) == Hole::BlueState){
            aux = posicao(anterior, h_blue, 3);
            h_blue[aux] = hole;
        }else{
            aux = posicao(anterior, h_red, 3);
            h_red[aux] = hole;
        }
        anterior->setState(Hole::EmptyState);
        if(isGameOver()){
            emit gameOver(m_player);
        }else{
            this->switchPlayer();
        }
    }else{
        deixarVazio();
        qntdSelec = 0;
        if(hole->state() == player2state(m_player)){
            anterior = hole;
            deixarVazio();
            qntdSelec = 0;
            selectable(hole);
        }
    }
}

bool Picaria::isGameOver(){ //saber quando alguem ganha
    if(isDiagonal() || isHorizontal() || isVertical()){
        return true;
    }
    return false;
}

void Picaria::defineVetor(int v[], Hole* hole[]){ //vetor util para as definições de vencedor
    int aux = 0;
    for(int i=0; i<3; i++){
        for(int j=0;j<13;j++){
            //qDebug()<<"Buraco jogo: "<<m_holes[j]->objectName()<<"Buraco colorido: "<<hole[i]->objectName();
            if(m_holes[j] == hole[i]){
                v[aux] = j;
                aux++;
                break;
            }
        }
    }
    //qDebug()<<"\n";
    for(int i=0; i<3;i++){
        for(int j=0;j<3;j++){
         if(v[i]<v[j]){
             aux = v[i];
             v[i] = v[j];
             v[j] = aux;
         }
        }
    }
}

bool Picaria::diagonalNine(Hole* hole[]){ //se é diagonal com jogo de 9 buracos
    int v[3];
    defineVetor(v,hole);
    switch (v[0]) {
    case 0:
        if(v[1] == v[0]+6 && v[2] == v[0]+12){
            return true;
        } break;
    case 2:
        if(v[1] == v[0]+4 && v[2] == v[0]+8){
            return true;
        } break;
    default: return false;
    }
    return false;
}

bool Picaria::diagonalThirteen(Hole* hole[]){ //se é diagonal com jogo de 13 buracos
    int v[3];
    defineVetor(v,hole);
    switch (v[0]) {
    case 0:
    case 3:
    case 5:
        if(v[1] == v[0]+3 && v[2] == v[0]+6){
            return true;
        } break;
    case 1:
    case 6:
        if((v[1] == v[0]+3 && v[2] == v[0]+6) ||
           (v[1] == v[0]+2 && v[2] == v[0]+4)){
            return true;
        }break;
    case 2:
    case 4:
    case 7:
        if(v[1] == v[0]+2 && v[2] == v[0]+4){
            return true;
        }break;
    default: return false;

    }
    return false;
}

bool Picaria::isDiagonal(){
    if(m_mode == Picaria::ThirteenHoles){ //13 buracos
        if(player2state(m_player) == Hole::BlueState && count_blue == 3){
            if(diagonalThirteen(h_blue)){
                return true;
            }
      } else{
                if(count_red == 3)
                    if(diagonalThirteen(h_red)){
                        return true;
                    }
            }
    } //9 buracos
    else{
        if(player2state(m_player) == Hole::BlueState && count_blue == 3){
            if(diagonalNine(h_blue)){
                return true;
            }
      } else{
                if(count_red == 3)
                    if(diagonalNine(h_red)){
                        return true;
                    }
            }
    }

    return false;
}

bool Picaria::horizontal(Hole* hole[]){
    int v[3];
    defineVetor(v,hole);
    switch (v[0]) {
    case 0:
    case 5:
    case 10:
        if(v[1] == v[0]+1 && v[2] == v[0]+2){
            return true;
        }break;
    default: return false;
    }
    return false;
}

bool Picaria::vertical(Hole* hole[]){
    int v[3];
    defineVetor(v,hole);
    switch (v[0]) {
    case 0:
    case 1:
    case 2:
        if(v[1] == v[0]+5 && v[2] == v[0]+10){
            return true;
        }break;
    default: return false;
    }
    return false;
}

bool Picaria::isHorizontal(){
    if(player2state(m_player) == Hole::BlueState && count_blue == 3){
        if(horizontal(h_blue)){
            return true;
        }
    }else
        if(count_red == 3)
            if(horizontal(h_red)){
                return true;
            }
    return false;
}

bool Picaria::isVertical(){
    if(player2state(m_player) == Hole::BlueState && count_blue == 3){
        if(vertical(h_blue)){
            return true;
        }
    }else
        if(count_red == 3)
            if(vertical(h_red)){
                return true;
            }
    return false;
}

void Picaria::reset() { //reseta o jogo, metodo pego pronto no codigo base disponivel
    // Reset each hole.
    for (int id = 0; id < 13; ++id) {
        Hole* hole = m_holes[id];
        hole->reset();

        // Set the hole visibility according to the board mode.
        switch (id) {
            case 3:
            case 4:
            case 8:
            case 9:
                hole->setVisible(m_mode == Picaria::ThirteenHoles);
                break;
            default:
                break;
        }
    }

    // Reset the player and phase.
    m_player = Picaria::RedPlayer;
    m_phase = Picaria::DropPhase;
    m_dropCount = 0;
    count_blue = 0;
    count_red = 0;
    qntdSelec = 0;
    deixarVazio();

    // Finally, update the status bar.
    this->updateStatusBar();
}

void Picaria::showAbout() {
    QMessageBox::information(this, tr("About"), tr("Picaria\n\nRyan Eduardo Mansur Vasconcelos\nEmail: ryan.emv@gmail.com"));
}

void Picaria::showGameOver(Player player) {
    switch (player) {
        case Picaria::RedPlayer:
            QMessageBox::information(this, tr("Vencedor"), tr("Parabéns, o jogador vermelho venceu."));
            break;
        case Picaria::BluePlayer:
            QMessageBox::information(this, tr("Vencedor"), tr("Parabéns, o jogador azul venceu."));
            break;
        default:
            Q_UNREACHABLE();
    }
}

void Picaria::updateMode(QAction* action) {
    if (action == ui->action9holes)
        this->setMode(Picaria::NineHoles);
    else if (action == ui->action13holes)
        this->setMode(Picaria::ThirteenHoles);
    else
        Q_UNREACHABLE();
}

void Picaria::updateStatusBar() {
    QString player(m_player == Picaria::RedPlayer ? "vermelho" : "azul");
    QString phase(m_phase == Picaria::DropPhase ? "colocar" : "mover");

    ui->statusbar->showMessage(tr("Fase de %1: vez do jogador %2").arg(phase).arg(player));
}
