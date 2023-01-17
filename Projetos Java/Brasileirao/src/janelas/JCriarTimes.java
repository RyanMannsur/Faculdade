/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janelas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import jogadores.*;
import textFilesApps.Configuracoes;
import textFilesApps.CreateTextFile;
import textFilesApps.ReadTextFile;
import time.Time;

/**
 *
 * @author Tata_
 */
public class JCriarTimes extends javax.swing.JFrame {

    private ArrayList<Time> timesCriados;
    private ArrayList<JogadorBase> jogadoresDisponiveis;
    private ArrayList<JogadorBase> jogadoresAdicionados;
    private ArrayList<Goleiro> goleiros;
    private ArrayList<JogadorDeLinha> jogadoresDeLinha;
    private ArrayList<String> logos;
    private ReadTextFile read;
    private CreateTextFile create;
    private int indexLogo;

    public JCriarTimes() throws IOException, FileNotFoundException, ClassNotFoundException {
        jogadoresAdicionados = new ArrayList<>();
        create = new CreateTextFile();
        read = new ReadTextFile();
        timesCriados = new ArrayList<>();
        jogadoresDisponiveis = new ArrayList<>();
        goleiros = new ArrayList<>();
        jogadoresDeLinha = new ArrayList<>();
        logos = new ArrayList<>();
        indexLogo = 0;
        procurarLogosDisponiveis();
        buscarJogadoresDisponiveis();

        initComponents();

        mudarIcone();
        mudarDadosTabelas();
    }

    public void mudarIcone() {
        String logo = logos.get(indexLogo);
        icone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logos/" + logo + ".png")));
        numeroDeLogos.setText((indexLogo + 1) + "/" + logos.size());
    }

    private void procurarLogosDisponiveis() {
        Configuracoes config = new Configuracoes();
        ArrayList<Time> times = config.getTimes();
        for (Time time : times) {
            logos.add(time.getLogo());
        }

        for (int i = 1; i < 12; i++) {
            logos.add("default_" + i);
        }
    }

    private void buscarListaTimesCriados() throws IOException, FileNotFoundException, ClassNotFoundException {
        timesCriados = read.buscarTimesCriados();
    }

    private void buscarJogadoresDisponiveis() throws IOException, FileNotFoundException, ClassNotFoundException {
        jogadoresDisponiveis = read.buscarJogares();
    }

    private void mudarDadosTabelas() {
        DefaultListModel modeloLista1 = new DefaultListModel();
        DefaultListModel modeloLista2 = new DefaultListModel();

        for (JogadorBase jogadores : jogadoresDisponiveis) {
            modeloLista1.addElement(jogadores.getNome());
        }

        listaJogadoresDisp.setModel(modeloLista1);

        if (!jogadoresAdicionados.isEmpty()) {
            for (JogadorBase jogador : jogadoresAdicionados) {
                modeloLista2.addElement(jogador.getNome());
            }
        }

        listaJogadoresAdd.setModel(modeloLista2);
    }

    private void salvarTime() {
        String nome, estadio, sigla;
        Time time;

        try {
            String copia = nomeTime.getText().replace(" ", "");
            String copia2 = siglaTime.getText().replace(" ", "");
            String copia3 = estadioTime.getText().replace(" ", "");
            if (copia.length() == 0 || copia2.length() == 0 || copia3.length() == 0) {
                throw new Exception();
            } else {
                if (siglaTime.getText().length() != 3) {
                    throw new Exception();
                } else {
                    nome = nomeTime.getText();
                    sigla = siglaTime.getText().toUpperCase();
                    estadio = estadioTime.getText();
                }
            }
            int raking = Integer.parseInt(rankingTime.getText());
            time = new Time(nome, sigla, estadio, raking);
            time.setLogo(logos.get(indexLogo));
            time.setJogadores(jogadoresDeLinha);
            time.setGoleiros(goleiros);
            timesCriados.add(time);
            for (JogadorDeLinha jogador : time.getJogadores()) {
                jogador.setTime(time.getNome());
            }

            for (Goleiro goleiro : time.getGoleiros()) {
                goleiro.setTime(time.getNome());
            }
            salvarTimeNoArquivo();
            JOptionPane.showMessageDialog(this, "Time Criado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Valores invalidos para os dados do time");
        }
    }

    private void salvarTimeNoArquivo() throws IOException {
        create.gravarTimesCriados(timesCriados);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaJogadoresAdd = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        addJogador = new javax.swing.JButton();
        removerJogador = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaJogadoresDisp = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        nomeTime = new javax.swing.JTextField();
        siglaTime = new javax.swing.JTextField();
        estadioTime = new javax.swing.JTextField();
        icone = new javax.swing.JLabel();
        numeroDeLogos = new javax.swing.JLabel();
        proximoIcone = new javax.swing.JButton();
        iconeAnterior = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        rankingTime = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        posicaoJogador = new javax.swing.JLabel();
        Criar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Criar Times"));

        jLabel1.setText("Nome:");

        jLabel2.setText("Sigla:");

        jLabel3.setText("Estádio:");

        listaJogadoresAdd.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Jogador 1 - ATA", "Jogador 1 - ATA", "Jogador 1 - ATA", "Jogador 1 - ATA", "Jogador 1 - ATA", "Jogador 1 - ATA", "Jogador 1 - ATA", "Jogador 1 - ATA", "Jogador 1 - ATA", "Jogador 1 - ATA", "Jogador 1 - ATA", "Jogador 1 - ATA", "Jogador 1 - ATA", "Jogador 1 - ATA", "Jogador 1 - ATA", "Jogador 1 - ATA" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaJogadoresAdd.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaJogadoresAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaJogadoresAddMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaJogadoresAdd);

        jLabel4.setText("Jogadores Disponíveis:");

        addJogador.setText(">>");
        addJogador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJogadorActionPerformed(evt);
            }
        });

        removerJogador.setText("<<");
        removerJogador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerJogadorActionPerformed(evt);
            }
        });

        listaJogadoresDisp.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Jogador 1 - ATA", "Jogador 1 - ATA", "Jogador 1 - ATA", "Jogador 1 - ATA", "Jogador 1 - ATA", "Jogador 1 - ATA", "Jogador 1 - ATA", "Jogador 1 - ATA", "Jogador 1 - ATA", "Jogador 1 - ATA", "Jogador 1 - ATA", "Jogador 1 - ATA", "Jogador 1 - ATA", "Jogador 1 - ATA", "Jogador 1 - ATA", "Jogador 1 - ATA" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaJogadoresDisp.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaJogadoresDisp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaJogadoresDispMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listaJogadoresDisp);

        jLabel5.setText("Jogadores Adicionados:");

        icone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logos/fc_barcelona_footballteam_18015.png"))); // NOI18N

        numeroDeLogos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numeroDeLogos.setText("1/1");

        proximoIcone.setText(">>");
        proximoIcone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proximoIconeActionPerformed(evt);
            }
        });

        iconeAnterior.setText("<<");
        iconeAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iconeAnteriorActionPerformed(evt);
            }
        });

        jLabel6.setText("Ranking:");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Posicao:");

        posicaoJogador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(addJogador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(removerJogador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(posicaoJogador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addContainerGap(74, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nomeTime)
                                    .addComponent(siglaTime)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3))
                                .addGap(7, 7, 7)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rankingTime, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(estadioTime))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(icone)
                                .addGap(53, 53, 53))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(iconeAnterior)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(numeroDeLogos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(proximoIcone)
                                .addGap(26, 26, 26))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(nomeTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(siglaTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(estadioTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(icone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(numeroDeLogos)
                            .addComponent(proximoIcone)
                            .addComponent(iconeAnterior))))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rankingTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(posicaoJogador, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addJogador)
                        .addGap(18, 18, 18)
                        .addComponent(removerJogador))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        Criar.setText("Criar");
        Criar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CriarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(Criar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Criar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void proximoIconeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proximoIconeActionPerformed
        if (indexLogo + 1 == logos.size()) {
            indexLogo = 0;
        } else {
            indexLogo++;
        }
        mudarIcone();
    }//GEN-LAST:event_proximoIconeActionPerformed

    private void removerJogadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerJogadorActionPerformed
        JogadorBase jogadorBase = null;
        if (!listaJogadoresAdd.isSelectionEmpty()) {
            for (JogadorBase jogador : jogadoresAdicionados) {
                if (jogador.getNome().equals(listaJogadoresAdd.getSelectedValue())) {
                    jogadorBase = jogador;
                }
            }
            jogadoresDisponiveis.add(jogadorBase);
            jogadoresAdicionados.remove(jogadorBase);
            mudarDadosTabelas();
        }
    }//GEN-LAST:event_removerJogadorActionPerformed

    private void CriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CriarActionPerformed
        int meias = 0, pontas = 0, zagueiros = 0, atacantes = 0, laterais = 0;

        for (JogadorBase jogador : jogadoresAdicionados) {
            if (jogador.getClass() == JogadorDeLinha.class) {
                jogadoresDeLinha.add((JogadorDeLinha) jogador);
            } else {
                goleiros.add((Goleiro) jogador);
            }
        }

        for (JogadorDeLinha jogador : jogadoresDeLinha) {
            if (jogador.getPosicoes().contains("ATA") || jogador.getPosicoes().contains("PD")
                    || jogador.getPosicoes().contains("PD")) {
                atacantes++;
            }
            if (jogador.getPosicoes().contains("MC") || jogador.getPosicoes().contains("VOL")) {
                meias++;
            }
            if (jogador.getPosicoes().contains("ZAG")) {
                zagueiros++;
            }
            if (jogador.getPosicoes().contains("LD") || jogador.getPosicoes().contains("LE")) {
                laterais++;
            }
            if (jogador.getPosicoes().contains("ME") || jogador.getPosicoes().contains("MD")
                    || jogador.getPosicoes().contains("MEI")) {
                pontas++;
            }
        }

        if (goleiros.size() + jogadoresDeLinha.size() < 11) {
            JOptionPane.showMessageDialog(this, "O time precisa ter no minimo 11 jogadores");
        } else {
            if (goleiros.isEmpty()) {
                JOptionPane.showMessageDialog(this, "O time precisa ter no minimo 1 goleiro");
            } else {
                if (jogadoresDeLinha.size() < 10) {
                    JOptionPane.showMessageDialog(this, "O time precisa ter no minimo 10 jogadores de linha");
                } else {
                    if (atacantes < 1 || meias < 1 || zagueiros < 1 || laterais < 1 || pontas < 1) {
                        JOptionPane.showMessageDialog(this, "O time precisa ter no minimo 1 jogador de cada posição");
                    } else {
                        salvarTime();
                    }
                }
            }
        }
    }//GEN-LAST:event_CriarActionPerformed

    private void listaJogadoresDispMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaJogadoresDispMouseClicked
        String posicao = "";
        if (!listaJogadoresDisp.isSelectionEmpty()) {
            for (JogadorBase jogador : jogadoresDisponiveis) {
                if (jogador.getNome().equals(listaJogadoresDisp.getSelectedValue())) {
                    if (jogador.getClass() == JogadorDeLinha.class) {
                        JogadorDeLinha j = (JogadorDeLinha) jogador;
                        posicao = j.getPosicoes().get(0);
                    } else {
                        posicao = "GL";
                    }
                }
            }
            posicaoJogador.setText(posicao);
        }

    }//GEN-LAST:event_listaJogadoresDispMouseClicked

    private void listaJogadoresAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaJogadoresAddMouseClicked
        String posicao = "";
        if (!listaJogadoresAdd.isSelectionEmpty()) {
            for (JogadorBase jogador : jogadoresAdicionados) {
                if (jogador.getNome().equals(listaJogadoresAdd.getSelectedValue())) {
                    if (jogador.getClass() == JogadorDeLinha.class) {
                        JogadorDeLinha j = (JogadorDeLinha) jogador;
                        posicao = j.getPosicoes().get(0);
                    } else {
                        posicao = "GL";
                    }
                }
            }
        }

        posicaoJogador.setText(posicao);
    }//GEN-LAST:event_listaJogadoresAddMouseClicked

    private void addJogadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJogadorActionPerformed
        JogadorBase jogadorBase = null;
        boolean verificar;
        int camisa = 0;
        do {
            verificar = true;
            try {
                camisa = Integer.parseInt(JOptionPane.showInputDialog(this, "Digite o numero da camisa", "Numero da camisa", 1));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Digite apenas numeros", "Erroa", 0);
                verificar = false;
            }
        } while (!verificar);

        if (!listaJogadoresDisp.isSelectionEmpty()) {
            for (JogadorBase jogador : jogadoresDisponiveis) {
                if (jogador.getNome().equals(listaJogadoresDisp.getSelectedValue())) {
                    jogadorBase = jogador;
                }
            }
            jogadorBase.setCamisa(camisa);
            jogadoresDisponiveis.remove(jogadorBase);
            jogadoresAdicionados.add(jogadorBase);
            mudarDadosTabelas();
        }


    }//GEN-LAST:event_addJogadorActionPerformed

    private void iconeAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconeAnteriorActionPerformed
        if (indexLogo == 0) {
            indexLogo = logos.size() - 1;
        } else {
            indexLogo--;
        }
        mudarIcone();
    }//GEN-LAST:event_iconeAnteriorActionPerformed

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
            java.util.logging.Logger.getLogger(JCriarTimes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JCriarTimes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JCriarTimes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JCriarTimes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JCriarTimes().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(JCriarTimes.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JCriarTimes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Criar;
    private javax.swing.JButton addJogador;
    private javax.swing.JTextField estadioTime;
    private javax.swing.JLabel icone;
    private javax.swing.JButton iconeAnterior;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listaJogadoresAdd;
    private javax.swing.JList<String> listaJogadoresDisp;
    private javax.swing.JTextField nomeTime;
    private javax.swing.JLabel numeroDeLogos;
    private javax.swing.JLabel posicaoJogador;
    private javax.swing.JButton proximoIcone;
    private javax.swing.JTextField rankingTime;
    private javax.swing.JButton removerJogador;
    private javax.swing.JTextField siglaTime;
    // End of variables declaration//GEN-END:variables
}
