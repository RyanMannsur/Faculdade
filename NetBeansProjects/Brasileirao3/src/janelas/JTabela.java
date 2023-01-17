/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janelas;

import Campeonato.Tabela;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import textFilesApps.*;
import time.Time;

public class JTabela extends javax.swing.JFrame {

    private Tabela tabela;
    private JArtilheiros jArtilheiros;
    private JTime jTime;
    private JPartidas jPartidas;
    private ReadTextFile read;
    private JResultados jResultado;
    private CreateTextFile create;
    private Configuracoes config;
    

    private ArrayList<Time> buscarTimesDoArquivo() throws IOException, FileNotFoundException, ClassNotFoundException {
        return read.buscarTime();
    }

    public JTabela() throws IOException, FileNotFoundException, ClassNotFoundException {
        
        config = new Configuracoes();
        create = new CreateTextFile();
        jResultado = new JResultados();
        read = new ReadTextFile();
        jPartidas = new JPartidas();
        jTime = new JTime();
        jArtilheiros = new JArtilheiros();
        tabela = new Tabela();
        tabela.definirTimesConfrontosERodadas(buscarTimesDoArquivo());
        initComponents();
    }

    private void atualizarTabela() {
        int x = tabela.getTimes().size();
        DefaultTableModel teste = new DefaultTableModel();
        Object objTeste[][] = new Object[x][9];
        for (int l = 0; l < x; l++) {
            objTeste[l][0] = tabela.getTimes().get(l).getNome();
            objTeste[l][1] = tabela.getTimes().get(l).getPontos();
            objTeste[l][2] = tabela.getRodadaAtual();
            objTeste[l][3] = tabela.getTimes().get(l).getVitorias();
            objTeste[l][4] = tabela.getTimes().get(l).getEmpates();
            objTeste[l][5] = tabela.getTimes().get(l).getDerrotas();
            objTeste[l][6] = tabela.getTimes().get(l).getgFeitos();
            objTeste[l][7] = tabela.getTimes().get(l).getgSofridos();
            objTeste[l][8] = tabela.getTimes().get(l).getSaldoDeGols();
        }
        String colunas[] = new String[]{"Clube", "Pts", "PJ", "VIT", "EMP", "DER", "GP", "GC", "SG"};
        tabelaBrasileirao.setModel(new DefaultTableModel(objTeste, colunas));
        tabelaBrasileirao.setEnabled(false);
        TableCellRenderer tcr = new CellRenderer();
        TableColumn column;
        for (int i = 1; i < 9; i++) {
            column = tabelaBrasileirao.getColumnModel().getColumn(i);
            column.setCellRenderer(tcr);
        }
    }

    public void simulacaoNova() {
        try {
            tabela.definirTimesConfrontosERodadas(buscarTimesDoArquivo());
        } catch (IOException ex) {
            Logger.getLogger(JTabela.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JTabela.class.getName()).log(Level.SEVERE, null, ex);
        }
        verPartidas.setEnabled(false);
        verAssistencias.setEnabled(true);
        verArtilheiros.setEnabled(true);
        mostarTimes.setEnabled(true);
        proximaRodada.setEnabled(true);
        jResultado.dispose();
        txtRodada.setText("");
        atualizarTabela();
    }

    private void resultado() {
        verPartidas.setEnabled(false);
        verAssistencias.setEnabled(false);
        verArtilheiros.setEnabled(false);
        mostarTimes.setEnabled(false);
        proximaRodada.setEnabled(false);
        jPartidas.dispose();
        jTime.dispose();
        jArtilheiros.dispose();
        jResultado.setArtilheiro(tabela.listaArtilharia().get(0));
        jResultado.setAssistente(tabela.listaAssistencias().get(0));
        jResultado.setCampeao(tabela.getTimes().get(0));
        jResultado.setGoleiro(tabela.listaDefesas().get(0));
        Time rebaixados[] = new Time[4], classificados[] = new Time[4];
        for (int i = 0, x = 3, j = tabela.getTimes().size() - 1; i < 4; i++, j--, x--) {
            rebaixados[x] = tabela.getTimes().get(j);
            classificados[i] = tabela.getTimes().get(i);
        }
        jResultado.setClassificados(classificados);
        jResultado.setRebaixados(rebaixados);
        jResultado.mudarDados();
        jResultado.setLocation((this.getWidth() / 2) - (jResultado.getWidth() / 2), (this.getHeight() / 2) - (jResultado.getHeight() / 2));
        jResultado.setVisible(true);
        int x = JOptionPane.showConfirmDialog(jResultado, "Deseja começar uma nova simulação?", "Nova Simulação", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (x == 0) {
            simulacaoNova();
        } else {
            JOptionPane.showMessageDialog(jResultado, "Fim do Programa! Obrigado por ter jogado", "Fim do Programa", 1);
            jResultado.dispose();
            this.dispose();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        painel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaBrasileirao = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        proximaRodada = new javax.swing.JButton();
        txtRodada = new javax.swing.JLabel();
        verPartidas = new javax.swing.JButton();
        verArtilheiros = new javax.swing.JButton();
        verAssistencias = new javax.swing.JButton();
        mostarTimes = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        novaSimulacao = new javax.swing.JMenuItem();
        timesDefault = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        criarTimes = new javax.swing.JMenuItem();
        criarJogadores = new javax.swing.JMenuItem();
        mudarTimes = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simulação de Pontos Corridos");
        setPreferredSize(new java.awt.Dimension(1366, 768));

        painel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        painel1.setPreferredSize(new java.awt.Dimension(501, 572));

        tabelaBrasileirao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Time", null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Clube", "Pts", "PJ", "VIT", "EMP", "DER", "GP", "GC", "SG"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaBrasileirao.setColumnSelectionAllowed(true);
        tabelaBrasileirao.setPreferredSize(new java.awt.Dimension(675, 500));
        tabelaBrasileirao.setRowHeight(25);
        tabelaBrasileirao.setRowSelectionAllowed(false);
        tabelaBrasileirao.setShowVerticalLines(false);
        tabelaBrasileirao.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelaBrasileirao);
        tabelaBrasileirao.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tabelaBrasileirao.getColumnModel().getColumnCount() > 0) {
            tabelaBrasileirao.getColumnModel().getColumn(1).setResizable(false);
            tabelaBrasileirao.getColumnModel().getColumn(2).setResizable(false);
            tabelaBrasileirao.getColumnModel().getColumn(3).setResizable(false);
            tabelaBrasileirao.getColumnModel().getColumn(4).setResizable(false);
            tabelaBrasileirao.getColumnModel().getColumn(5).setResizable(false);
            tabelaBrasileirao.getColumnModel().getColumn(6).setResizable(false);
            tabelaBrasileirao.getColumnModel().getColumn(7).setResizable(false);
            tabelaBrasileirao.getColumnModel().getColumn(8).setResizable(false);
        }
        atualizarTabela();

        javax.swing.GroupLayout painel1Layout = new javax.swing.GroupLayout(painel1);
        painel1.setLayout(painel1Layout);
        painel1Layout.setHorizontalGroup(
            painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        painel1Layout.setVerticalGroup(
            painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        proximaRodada.setText(">>");
        proximaRodada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proximaRodadaActionPerformed(evt);
            }
        });

        txtRodada.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        txtRodada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtRodada.setText(" ");
        txtRodada.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        verPartidas.setText("Partidas");
        verPartidas.setEnabled(false);
        verPartidas.setPreferredSize(new java.awt.Dimension(150, 23));
        verPartidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verPartidasActionPerformed(evt);
            }
        });

        verArtilheiros.setText("Artilheiros");
        verArtilheiros.setPreferredSize(new java.awt.Dimension(150, 23));
        verArtilheiros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verArtilheirosActionPerformed(evt);
            }
        });

        verAssistencias.setText("Assistencias");
        verAssistencias.setPreferredSize(new java.awt.Dimension(150, 23));
        verAssistencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verAssistenciasActionPerformed(evt);
            }
        });

        mostarTimes.setText("Times");
        mostarTimes.setPreferredSize(new java.awt.Dimension(150, 23));
        mostarTimes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostarTimesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(402, 402, 402)
                .addComponent(verPartidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtRodada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(verArtilheiros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mostarTimes, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(verAssistencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(proximaRodada, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(435, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(proximaRodada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRodada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(verAssistencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verPartidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verArtilheiros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mostarTimes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Arquivo");

        novaSimulacao.setText("Nova Simulação");
        novaSimulacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novaSimulacaoActionPerformed(evt);
            }
        });
        jMenu1.add(novaSimulacao);

        timesDefault.setText("Carregar Times Default");
        timesDefault.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timesDefaultActionPerformed(evt);
            }
        });
        jMenu1.add(timesDefault);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");

        criarTimes.setText("Criar Time");
        criarTimes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                criarTimesActionPerformed(evt);
            }
        });
        jMenu2.add(criarTimes);

        criarJogadores.setText("Criar Jogadores");
        criarJogadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                criarJogadoresActionPerformed(evt);
            }
        });
        jMenu2.add(criarJogadores);

        mudarTimes.setText("Mudar times do campeonato");
        mudarTimes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mudarTimesActionPerformed(evt);
            }
        });
        jMenu2.add(mudarTimes);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Sair");

        jMenuItem6.setText("Sair");
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1346, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painel1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void proximaRodadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proximaRodadaActionPerformed
        //tabela.definirPartidas2();
        tabela.atulizarTabela();
        atualizarTabela();
        verPartidas.setEnabled((verPartidas.isEnabled() ? true : true));
        jPartidas.dispose();
        jTime.dispose();
        jArtilheiros.dispose();
        txtRodada.setText(tabela.getRodadaAtual() + "º Rodada");
        if (tabela.getRodadaAtual() > 37) {
            resultado();
        }
    }//GEN-LAST:event_proximaRodadaActionPerformed

    private void verArtilheirosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verArtilheirosActionPerformed
        jArtilheiros.dispose();
        jArtilheiros.setArtilheiros(tabela.listaArtilharia());
        jArtilheiros.setAssistentes(tabela.listaAssistencias());
        jArtilheiros.setGoleiros(tabela.listaDefesas());
        jArtilheiros.setIndex(0);
        jArtilheiros.criarTabela();
        jArtilheiros.setLocation((this.getWidth() / 2) - (jArtilheiros.getWidth() / 2), (this.getHeight() / 2) - (jArtilheiros.getHeight() / 2));
        jArtilheiros.setVisible(true);
    }//GEN-LAST:event_verArtilheirosActionPerformed

    private void verAssistenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verAssistenciasActionPerformed
        jArtilheiros.dispose();
        jArtilheiros.setArtilheiros(tabela.listaArtilharia());
        jArtilheiros.setAssistentes(tabela.listaAssistencias());
        jArtilheiros.setGoleiros(tabela.listaDefesas());
        jArtilheiros.setIndex(1);
        jArtilheiros.criarTabela();
        jArtilheiros.setLocation((this.getWidth() / 2) - (jArtilheiros.getWidth() / 2), (this.getHeight() / 2) - (jArtilheiros.getHeight() / 2));
        jArtilheiros.setVisible(true);
    }//GEN-LAST:event_verAssistenciasActionPerformed

    private void mostarTimesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostarTimesActionPerformed
        jTime.dispose();
        jTime.setTimes(tabela.getTimes());
        jTime.setIndex(0);
        jTime.mudarDados();
        jTime.setLocation((this.getWidth() / 2) - (jTime.getWidth() / 2), (this.getHeight() / 2) - (jTime.getHeight() / 2));
        jTime.setVisible(true);
    }//GEN-LAST:event_mostarTimesActionPerformed

    private void verPartidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verPartidasActionPerformed
        jPartidas.dispose();
        jPartidas.setRodadas(tabela.getRodadas());
        jPartidas.setPartidas(0);
        jPartidas.setRodada(tabela.getRodadaAtual() - 1);
        jPartidas.setRodadaAtual(tabela.getRodadaAtual());
        jPartidas.mudarDados();
        jPartidas.setLocation((this.getWidth() / 2) - (jPartidas.getWidth() / 2), (this.getHeight() / 2) - (jPartidas.getHeight() / 2));
        jPartidas.setVisible(true);
    }//GEN-LAST:event_verPartidasActionPerformed

    private void novaSimulacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novaSimulacaoActionPerformed
        simulacaoNova();
    }//GEN-LAST:event_novaSimulacaoActionPerformed

    private void timesDefaultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timesDefaultActionPerformed
        try {                                             
            ArrayList<Time> timesRemovidos = new ArrayList<>();
            ArrayList<Time> timesNoCamp = read.buscarTime();
            ArrayList<String> nomeTimesCamp = new ArrayList<>();
            ArrayList<String> nomeTimesRemovidos = new ArrayList<>();
            ArrayList<String> nomeTimesDef = new ArrayList<>();
            try {
                timesRemovidos = read.buscarTimesCriados();
            } catch (IOException ex) {
                Logger.getLogger(JTabela.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(JTabela.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            for (Time time : timesRemovidos) {
                nomeTimesRemovidos.add(time.getNome());
            }
            
            for (Time time : timesNoCamp) {
                nomeTimesCamp.add(time.getNome());
            }
            
            for (Time time : config.getTimes()) {
                nomeTimesDef.add(time.getNome());
            }
            
            for (String nomeTimeRem : nomeTimesRemovidos) {
                if (nomeTimesDef.contains(nomeTimeRem)) {
                    for (int i = 0; i < timesRemovidos.size(); i++) {
                        if (timesRemovidos.get(i).getNome().equals(nomeTimeRem)) {
                            timesRemovidos.remove(timesRemovidos.get(i));
                        }
                    }
                }
            }
            
            for (String nomeTime : nomeTimesCamp) {
                if (!nomeTimesDef.contains(nomeTime)) {
                    for (int i = 0; i < timesNoCamp.size(); i++) {
                        if (timesNoCamp.get(i).getNome().equals(nomeTime)) {
                            timesRemovidos.add(timesNoCamp.get(i));
                        }
                    }
                }
            }
            
            
            try {
                create.gravar(config.getTimes());
                create.gravarTimesCriados(timesRemovidos);
            } catch (IOException ex) {
                Logger.getLogger(JTabela.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            novaSimulacaoActionPerformed(evt);
        } catch (IOException ex) {
            Logger.getLogger(JTabela.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JTabela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_timesDefaultActionPerformed

    private void mudarTimesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mudarTimesActionPerformed
        try {
            JMudarCampeonato jMudarCamp = new JMudarCampeonato();
            jMudarCamp.setjTabela(this);
            jMudarCamp.mudarTabelas();
            jMudarCamp.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(JTabela.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JTabela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mudarTimesActionPerformed

    private void criarTimesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_criarTimesActionPerformed
        try {
            JCriarTimes jCriarTimes = new JCriarTimes();
            jCriarTimes.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(JTabela.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JTabela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_criarTimesActionPerformed

    private void criarJogadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_criarJogadoresActionPerformed
        try {
            JCriarJogadores jCriarJogadores = new JCriarJogadores();
            jCriarJogadores.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(JTabela.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JTabela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_criarJogadoresActionPerformed

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
            java.util.logging.Logger.getLogger(JTabela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JTabela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JTabela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JTabela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    try {
                        new JTabela().setVisible(true);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(JTabela.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(JTabela.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(JTabela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem criarJogadores;
    private javax.swing.JMenuItem criarTimes;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mostarTimes;
    private javax.swing.JMenuItem mudarTimes;
    private javax.swing.JMenuItem novaSimulacao;
    private javax.swing.JPanel painel1;
    private javax.swing.JButton proximaRodada;
    private javax.swing.JTable tabelaBrasileirao;
    private javax.swing.JMenuItem timesDefault;
    private javax.swing.JLabel txtRodada;
    private javax.swing.JButton verArtilheiros;
    private javax.swing.JButton verAssistencias;
    private javax.swing.JButton verPartidas;
    // End of variables declaration//GEN-END:variables
}
