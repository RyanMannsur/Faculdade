#ifndef PICARIA_H
#define PICARIA_H

#include <QMainWindow>

QT_BEGIN_NAMESPACE
namespace Ui {
    class Picaria;
}
QT_END_NAMESPACE

class Hole;

class Picaria : public QMainWindow {
    Q_OBJECT
    Q_PROPERTY(Picaria::Mode mode READ mode WRITE setMode NOTIFY modeChanged)

public:
    enum Mode {
        NineHoles,
        ThirteenHoles
    };
    Q_ENUM(Mode)

    enum Player {
        RedPlayer,
        BluePlayer
    };
    Q_ENUM(Player)

    enum Phase {
        DropPhase,
        MovePhase
    };
    Q_ENUM(Phase)

    Picaria(QWidget *parent = nullptr);
    virtual ~Picaria();

    Picaria::Mode mode() const { return m_mode; }
    void setMode(Picaria::Mode mode);


signals:
    void modeChanged(Picaria::Mode mode);
    void gameOver(Player player);
    void phaseChanged(Picaria::Phase phase); //fase 1 cada um tem 3 peças

private:
    Ui::Picaria *ui;
    Hole* m_holes[13];
    Mode m_mode;
    Player m_player;
    Phase m_phase;
    Hole* h_blue[3];
    Hole* h_red[3];
    int count_blue;
    int count_red;
    int m_dropCount;
    Hole* anterior;
    Hole* selecionaveis[6];
    int qntdSelec;

    void switchPlayer();
    void drop(Hole* hole);
    void move(Hole* hole);
    bool isGameOver();
    bool isDiagonal();
    bool diagonalThirteen(Hole* hole[]);
    bool diagonalNine(Hole* hole[]);
    bool isHorizontal();
    bool isVertical();
    void defineVetor(int v[], Hole* hole[]);
    bool vertical(Hole* hole[]);
    bool horizontal(Hole* hole[]);
    bool isSelectable(Hole *hole, int v[]);
    void selectable(Hole *hole);
    int posicao(Hole* h, Hole* hole[], int aux);
    bool norte(Hole* hole);
    bool sul(Hole* hole);
    bool leste(Hole* hole);
    bool oeste(Hole* hole);
    bool nordeste(Hole* hole);
    bool noroeste(Hole* hole);
    bool sudeste(Hole* hole);
    bool suldoeste(Hole* hole);
    void deixarVazio();

private slots:
    void play(int id);
    void reset();

    void showAbout();

    void updateMode(QAction* action);
    void updateStatusBar();
    void showGameOver(Player player);

};

#endif // PICARIA_H
