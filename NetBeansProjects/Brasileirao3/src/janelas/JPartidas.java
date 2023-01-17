/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janelas;

import Campeonato.Rodada;
import java.util.ArrayList;
import time.Time;

public class JPartidas extends javax.swing.JFrame {

    private int rodada;
    private int partidas;
    private Rodada[] rodadas;
    private int rodadaAtual;

    public JPartidas() {
        rodada = 0;
        initComponents();
    }

    public int getRodada() {
        return rodada;
    }

    public void setRodada(int rodada) {
        this.rodada = rodada;
    }

    public int getPartidas() {
        return partidas;
    }

    public void setPartidas(int partidas) {
        this.partidas = partidas;
    }

    public Rodada[] getRodadas() {
        return rodadas;
    }

    public void setRodadas(Rodada[] rodadas) {
        this.rodadas = rodadas;
    }

    public int getRodadaAtual() {
        return rodadaAtual;
    }

    public void setRodadaAtual(int rodadaAtual) {
        this.rodadaAtual = rodadaAtual;
    }
    
    

    public void mudarDados() {
        /*
        estatisticas[0] = gols
        estatisticas[1] = posse de bola
        estatisticas[2] = finalizacoes
        estatisticas[3] = finalizacoesCertas
        estatisticas[4] = passes
        estatisticas[5] = faltas
        estatisticas[6] = escanteios  
         */
        Time timeA = rodadas[rodada].getPartidas()[partidas].getTimes()[0];
        Time timeB = rodadas[rodada].getPartidas()[partidas].getTimes()[1];
        String quemFezGolA = "", quemFezGolB = "";
        int gols = 0;
        siglatimeA.setText(timeA.getSigla());
        siglatimeB.setText(timeB.getSigla());
        golsA.setText(String.valueOf(rodadas[rodada].getPartidas()[partidas].getEstatisticasTimeA()[0]));
        golsB.setText(String.valueOf(rodadas[rodada].getPartidas()[partidas].getEstatisticasTimeB()[0]));

        posseA.setText(String.valueOf(rodadas[rodada].getPartidas()[partidas].getEstatisticasTimeA()[1]));
        posseB.setText(String.valueOf(rodadas[rodada].getPartidas()[partidas].getEstatisticasTimeB()[1]));

        chuteA.setText(String.valueOf(rodadas[rodada].getPartidas()[partidas].getEstatisticasTimeA()[2]));
        chuteB.setText(String.valueOf(rodadas[rodada].getPartidas()[partidas].getEstatisticasTimeB()[2]));

        chuteAGolA.setText(String.valueOf(rodadas[rodada].getPartidas()[partidas].getEstatisticasTimeA()[3]));
        chuteAGolB.setText(String.valueOf(rodadas[rodada].getPartidas()[partidas].getEstatisticasTimeB()[3]));

        passeA.setText(String.valueOf(rodadas[rodada].getPartidas()[partidas].getEstatisticasTimeA()[4]));
        passeB.setText(String.valueOf(rodadas[rodada].getPartidas()[partidas].getEstatisticasTimeB()[4]));

        faltasA.setText(String.valueOf(rodadas[rodada].getPartidas()[partidas].getEstatisticasTimeA()[5]));
        faltasB.setText(String.valueOf(rodadas[rodada].getPartidas()[partidas].getEstatisticasTimeB()[5]));

        escanteiosA.setText(String.valueOf(rodadas[rodada].getPartidas()[partidas].getEstatisticasTimeA()[6]));
        escanteiosB.setText(String.valueOf(rodadas[rodada].getPartidas()[partidas].getEstatisticasTimeB()[6]));

        golsTimeA.setText("");
        golsTimeB.setText("");
        ArrayList<String> jogadoresA = rodadas[rodada].getPartidas()[partidas].getGolsA();
        ArrayList<String> jogadoresB = rodadas[rodada].getPartidas()[partidas].getGolsB();
        for (int i = 0; i < jogadoresA.size(); i++) {
            for (int j = 0; j < jogadoresA.size(); j++) {
                if (jogadoresA.get(i).equals(jogadoresA.get(j))) {
                    gols++;
                }
            }
            if (!quemFezGolA.contains(jogadoresA.get(i) + " " + gols + "x⚽")) {
                quemFezGolA = quemFezGolA.concat(jogadoresA.get(i) + " " + gols + "x⚽\n");
            }
            gols = 0;
        }
        for (int i = 0; i < jogadoresB.size(); i++) {
            for (int j = 0; j < jogadoresB.size(); j++) {
                if (jogadoresB.get(i).equals(jogadoresB.get(j))) {
                    gols++;
                }
            }
            if (!quemFezGolB.contains(jogadoresB.get(i) + " " + gols + "x⚽")) {
                quemFezGolB = quemFezGolB.concat(jogadoresB.get(i) + " " + gols + "x⚽\n");
            }
            gols = 0;
        }
        golsTimeA.setText(quemFezGolA);
        golsTimeB.setText(quemFezGolB);
        iconTimeA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/" + timeA.getLogo() + ".png")));
        iconTimeB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/" + timeB.getLogo() + ".png")));
        txtRodada.setText(String.valueOf(rodada + 1));

        if (rodadas[rodada].getPartidas().length - 1 == partidas) {
            proximaPartida.setEnabled(false);
        } else {
            proximaPartida.setEnabled(true);
        }

        if (partidas > 0) {
            partidaAnteiros.setEnabled(true);
        } else {
            partidaAnteiros.setEnabled(false);
        }

        if ((rodadaAtual <=1) || (rodada == rodadaAtual - 1)|| rodada >= 37) {
            proximaRodada.setEnabled(false);
        } else {
            proximaRodada.setEnabled(true);
        }
        if (rodada == 0) {
            rodadaAnterior.setEnabled(false);
        }else{
            rodadaAnterior.setEnabled(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        iconTimeA = new javax.swing.JLabel();
        iconTimeB = new javax.swing.JLabel();
        siglatimeA = new javax.swing.JLabel();
        siglatimeB = new javax.swing.JLabel();
        golsA = new javax.swing.JLabel();
        golsB = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        chuteA = new javax.swing.JLabel();
        chuteB = new javax.swing.JLabel();
        chuteAGolA = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        chuteAGolB = new javax.swing.JLabel();
        posseA = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        posseB = new javax.swing.JLabel();
        passeA = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        passeB = new javax.swing.JLabel();
        faltasA = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        faltasB = new javax.swing.JLabel();
        escanteiosA = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        escanteiosB = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        golsTimeA = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        golsTimeB = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        proximaPartida = new javax.swing.JButton();
        partidaAnteiros = new javax.swing.JButton();
        rodadaAnterior = new javax.swing.JButton();
        proximaRodada = new javax.swing.JButton();
        txtRodada = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Partidas"));

        iconTimeA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/default_1.png"))); // NOI18N

        iconTimeB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/default_1.png"))); // NOI18N

        siglatimeA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        siglatimeA.setText("Sigla");

        siglatimeB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        siglatimeB.setText("Sigla");

        golsA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        golsA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        golsA.setText("0");
        golsA.setPreferredSize(new java.awt.Dimension(32, 32));

        golsB.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        golsB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        golsB.setText("0");
        golsB.setPreferredSize(new java.awt.Dimension(32, 32));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("x");
        jLabel3.setPreferredSize(new java.awt.Dimension(20, 20));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Chutes");

        chuteA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chuteA.setText("Sigla");

        chuteB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chuteB.setText("Sigla");

        chuteAGolA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chuteAGolA.setText("Sigla");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Chutes a gol");

        chuteAGolB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chuteAGolB.setText("Sigla");

        posseA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        posseA.setText("Sigla");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Posse de bola");

        posseB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        posseB.setText("Sigla");

        passeA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passeA.setText("Sigla");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Passes");

        passeB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passeB.setText("Sigla");

        faltasA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        faltasA.setText("Sigla");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Faltas");

        faltasB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        faltasB.setText("Sigla");

        escanteiosA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        escanteiosA.setText("Sigla");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Escanteios");

        escanteiosB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        escanteiosB.setText("Sigla");

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane3.setEnabled(false);

        golsTimeA.setBackground(new java.awt.Color(240, 240, 240));
        golsTimeA.setColumns(20);
        golsTimeA.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        golsTimeA.setRows(5);
        golsTimeA.setText("jogador1\njogador2\njogador3\njogador4\njogador5\n");
        golsTimeA.setBorder(null);
        golsTimeA.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        golsTimeA.setEnabled(false);
        jScrollPane3.setViewportView(golsTimeA);

        jScrollPane4.setBorder(null);
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane4.setEnabled(false);

        golsTimeB.setBackground(new java.awt.Color(240, 240, 240));
        golsTimeB.setColumns(20);
        golsTimeB.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        golsTimeB.setRows(5);
        golsTimeB.setText("Jogador1\nJogador2\nJogador3\nJogador4\nJogador5\nJogador6\n");
        golsTimeB.setBorder(null);
        golsTimeB.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        golsTimeB.setEnabled(false);
        golsTimeB.setPreferredSize(new java.awt.Dimension(150, 100));
        jScrollPane4.setViewportView(golsTimeB);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chuteAGolA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(siglatimeA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(iconTimeA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chuteA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(posseA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passeA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(faltasA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(escanteiosA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(golsA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(golsB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(iconTimeB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(siglatimeB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(chuteB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(chuteAGolB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(posseB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(passeB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(faltasB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(escanteiosB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(56, 56, 56))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(golsA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(golsB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(iconTimeB)
                    .addComponent(iconTimeA))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(siglatimeA)
                    .addComponent(siglatimeB))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(chuteA)
                    .addComponent(chuteB))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(chuteAGolA)
                    .addComponent(chuteAGolB))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(posseA)
                    .addComponent(jLabel6)
                    .addComponent(posseB))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passeA)
                    .addComponent(jLabel7)
                    .addComponent(passeB))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(faltasA)
                    .addComponent(jLabel8)
                    .addComponent(faltasB))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(escanteiosA)
                    .addComponent(jLabel9)
                    .addComponent(escanteiosB))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel1.setText("Partida");

        jLabel2.setText("Rodada");

        proximaPartida.setText(">>");
        proximaPartida.setPreferredSize(new java.awt.Dimension(50, 50));
        proximaPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proximaPartidaActionPerformed(evt);
            }
        });

        partidaAnteiros.setText("<<");
        partidaAnteiros.setEnabled(false);
        partidaAnteiros.setPreferredSize(new java.awt.Dimension(50, 50));
        partidaAnteiros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partidaAnteirosActionPerformed(evt);
            }
        });

        rodadaAnterior.setText("<<");
        rodadaAnterior.setEnabled(false);
        rodadaAnterior.setPreferredSize(new java.awt.Dimension(50, 50));
        rodadaAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rodadaAnteriorActionPerformed(evt);
            }
        });

        proximaRodada.setText(">>");
        proximaRodada.setEnabled(false);
        proximaRodada.setPreferredSize(new java.awt.Dimension(50, 50));
        proximaRodada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proximaRodadaActionPerformed(evt);
            }
        });

        txtRodada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtRodada.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(partidaAnteiros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rodadaAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtRodada, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(proximaRodada, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(proximaPartida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(112, 112, 112))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(proximaPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(partidaAnteiros, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(rodadaAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(proximaRodada, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRodada)
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void proximaPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proximaPartidaActionPerformed
        partidas++;
        mudarDados();
    }//GEN-LAST:event_proximaPartidaActionPerformed

    private void partidaAnteirosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partidaAnteirosActionPerformed
        partidas--;
        mudarDados();
    }//GEN-LAST:event_partidaAnteirosActionPerformed

    private void proximaRodadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proximaRodadaActionPerformed
        rodada++;
        partidas = 0;
        mudarDados();
    }//GEN-LAST:event_proximaRodadaActionPerformed

    private void rodadaAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rodadaAnteriorActionPerformed
        rodada--;
        partidas = 0;
        mudarDados();
    }//GEN-LAST:event_rodadaAnteriorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JPartidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JPartidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JPartidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JPartidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JPartidas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel chuteA;
    private javax.swing.JLabel chuteAGolA;
    private javax.swing.JLabel chuteAGolB;
    private javax.swing.JLabel chuteB;
    private javax.swing.JLabel escanteiosA;
    private javax.swing.JLabel escanteiosB;
    private javax.swing.JLabel faltasA;
    private javax.swing.JLabel faltasB;
    private javax.swing.JLabel golsA;
    private javax.swing.JLabel golsB;
    private javax.swing.JTextArea golsTimeA;
    private javax.swing.JTextArea golsTimeB;
    private javax.swing.JLabel iconTimeA;
    private javax.swing.JLabel iconTimeB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton partidaAnteiros;
    private javax.swing.JLabel passeA;
    private javax.swing.JLabel passeB;
    private javax.swing.JLabel posseA;
    private javax.swing.JLabel posseB;
    private javax.swing.JButton proximaPartida;
    private javax.swing.JButton proximaRodada;
    private javax.swing.JButton rodadaAnterior;
    private javax.swing.JLabel siglatimeA;
    private javax.swing.JLabel siglatimeB;
    private javax.swing.JLabel txtRodada;
    // End of variables declaration//GEN-END:variables
}
