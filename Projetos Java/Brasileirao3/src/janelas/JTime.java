/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janelas;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import jogadores.Goleiro;
import jogadores.JogadorDeLinha;
import time.Time;

public class JTime extends javax.swing.JFrame {

    private ArrayList<Time> times;
    private int index;
    private DefaultListModel modelo;

    public JTime() {
        modelo = new DefaultListModel();
        times = new ArrayList<>();
        initComponents();
    }

    public void mudarDados() {
        nomeJogador.setText("");
        posicaoJogador.setText("");
        camisa.setText("");
        idade.setText("");
        altura.setText("");
        peso.setText("");
        gols.setText("");
        assistencias.setText("");
        String estrelas = "";
        int partidas;
        int porc;
        nome.setText(times.get(index).getNome());
        sigla.setText(times.get(index).getSigla());
        estadio.setText(times.get(index).getEstagio());
        vit.setText(String.valueOf(times.get(index).getVitorias()));
        der.setText(String.valueOf(times.get(index).getDerrotas()));
        emp.setText(String.valueOf(times.get(index).getEmpates()));
        jogadores.setText(String.valueOf(times.get(index).getJogadores().size()));
        for (int i = 0; i < times.get(index).getRanking(); i++) {
            estrelas = estrelas.concat("✦");
        }
        ranking.setText(estrelas);
        partidas = times.get(index).getVitorias() + times.get(index).getEmpates() + times.get(index).getDerrotas();
        if(partidas!=0){
            porc = (times.get(index).getVitorias() * 100) /  partidas;
            aproveitamento.setText(String.valueOf(porc) + "%");
        }
        modelo.clear();
        for (int i = 0; i < times.get(index).getJogadores().size(); i++) {
            modelo.addElement(times.get(index).getJogadores().get(i).getNome());
        }
        for (int i = 0; i < times.get(index).getGoleiros().size(); i++) {
            modelo.addElement(times.get(index).getGoleiros().get(i).getNome());
        }
        tabelaJogadores.setModel(modelo);
        icone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logos/"+times.get(index).getLogo()+".png")));
        if (index == times.size()-1) {
            proximo.setEnabled(false);
        }else{
             proximo.setEnabled(true);
        }
        if (index > 0) {
            anterior.setEnabled(true);
        }else{
            anterior.setEnabled(false);
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

        panelTime = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ranking = new javax.swing.JLabel();
        der = new javax.swing.JLabel();
        vit = new javax.swing.JLabel();
        emp = new javax.swing.JLabel();
        aproveitamento = new javax.swing.JLabel();
        nome = new javax.swing.JLabel();
        sigla = new javax.swing.JLabel();
        estadio = new javax.swing.JLabel();
        jogadores = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaJogadores = new javax.swing.JList<>();
        nomeJogador = new javax.swing.JLabel();
        idade = new javax.swing.JLabel();
        altura = new javax.swing.JLabel();
        peso = new javax.swing.JLabel();
        posicaoJogador = new javax.swing.JLabel();
        camisa = new javax.swing.JLabel();
        gols = new javax.swing.JLabel();
        assistencias = new javax.swing.JLabel();
        icone = new javax.swing.JLabel();
        anterior = new javax.swing.JButton();
        proximo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        panelTime.setBorder(javax.swing.BorderFactory.createTitledBorder("Time"));

        jLabel5.setText("Vitorias");

        jLabel6.setText("Empates");

        jLabel7.setText("Derrotas");

        ranking.setText("Raning");

        der.setText("jLabel10");

        vit.setText("jLabel10");

        emp.setText("jLabel10");

        aproveitamento.setText("Aproveitamento");

        nome.setText("Nome do Time");

        sigla.setText("Sigla");

        estadio.setText("Estadio");

        jogadores.setText("Jogadores");

        tabelaJogadores.setBackground(new java.awt.Color(240, 240, 240));
        tabelaJogadores.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Jogador 1", "Jogador 2", "Jogador 3", "Jogador 4", "Jogador 5", "Jogador 6", "Jogador 7", "Jogador 8", "Jogador 9", "Jogador 10", "Jogador 11" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        tabelaJogadores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaJogadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaJogadoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaJogadores);

        nomeJogador.setText("Nome do Jogador");

        idade.setText("Idade");

        altura.setText("Altura");

        peso.setText("Peso");

        posicaoJogador.setText("Poiscao");

        camisa.setText("Camisa");

        gols.setText("Gols");

        assistencias.setText("Assistencias");

        icone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logos/fc_barcelona_footballteam_18015.png"))); // NOI18N

        javax.swing.GroupLayout panelTimeLayout = new javax.swing.GroupLayout(panelTime);
        panelTime.setLayout(panelTimeLayout);
        panelTimeLayout.setHorizontalGroup(
            panelTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTimeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTimeLayout.createSequentialGroup()
                        .addComponent(icone)
                        .addGap(18, 18, 18)
                        .addGroup(panelTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTimeLayout.createSequentialGroup()
                                .addGroup(panelTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(sigla, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                                .addGap(26, 26, 26)
                                .addGroup(panelTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)))
                            .addComponent(estadio, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aproveitamento, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(der, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(emp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(vit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelTimeLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addGroup(panelTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomeJogador)
                            .addComponent(posicaoJogador)
                            .addComponent(camisa))
                        .addGap(49, 49, 49)
                        .addGroup(panelTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idade)
                            .addComponent(altura)
                            .addComponent(peso)
                            .addComponent(assistencias)
                            .addComponent(gols)))
                    .addComponent(ranking, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jogadores))
                .addGap(67, 67, 67))
        );
        panelTimeLayout.setVerticalGroup(
            panelTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTimeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTimeLayout.createSequentialGroup()
                        .addComponent(icone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ranking)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jogadores)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTimeLayout.createSequentialGroup()
                        .addGroup(panelTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nome)
                            .addComponent(jLabel5)
                            .addComponent(vit))
                        .addGroup(panelTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTimeLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(panelTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(emp))
                                .addGap(7, 7, 7)
                                .addGroup(panelTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(der)))
                            .addGroup(panelTimeLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(sigla)))
                        .addGroup(panelTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTimeLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(estadio))
                            .addGroup(panelTimeLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(aproveitamento)))
                        .addGap(113, 113, 113)
                        .addGroup(panelTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomeJogador)
                            .addComponent(idade))
                        .addGroup(panelTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTimeLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(altura)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(peso))
                            .addGroup(panelTimeLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(posicaoJogador)))
                        .addGroup(panelTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTimeLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(camisa))
                            .addGroup(panelTimeLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(gols)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(assistencias)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        anterior.setText("<<<");
        anterior.setEnabled(false);
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });

        proximo.setText(">>>");
        proximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proximoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(anterior)
                .addGap(18, 18, 18)
                .addComponent(proximo)
                .addGap(171, 171, 171))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTime, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anterior)
                    .addComponent(proximo))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void proximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proximoActionPerformed
        index++;
        
        mudarDados();
    }//GEN-LAST:event_proximoActionPerformed

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
        index--;
        
        mudarDados();
    }//GEN-LAST:event_anteriorActionPerformed

    private void tabelaJogadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaJogadoresMouseClicked
        JogadorDeLinha j = null;
        Goleiro g = null;
        boolean verificar;

        for (int i = 0; i < times.get(index).getGoleiros().size(); i++) {
            if (times.get(index).getGoleiros().get(i).getNome().equals(tabelaJogadores.getSelectedValue())) {
                g = times.get(index).getGoleiros().get(i);
            }
        }

        for (int i = 0; i < times.get(index).getJogadores().size(); i++) {
            if (times.get(index).getJogadores().get(i).getNome().equals(tabelaJogadores.getSelectedValue())) {
                j = times.get(index).getJogadores().get(i);
            }
        }

        if (g == null) {
            nomeJogador.setText(j.getNome());
            posicaoJogador.setText(j.getPosicoes().get(0));
            idade.setText(String.valueOf(j.getIdade() + "anos"));
            altura.setText(String.valueOf(j.getTamanho() + "m"));
            peso.setText(String.valueOf(j.getPeso() + "Kg"));
            camisa.setText("Camisa " + String.valueOf(j.getCamisa()));
            gols.setText(String.valueOf(j.getnGols() + " gols na temp."));
            assistencias.setText(String.valueOf(j.getAssistencias() + " assist. na temp."));
        } else {
            nomeJogador.setText(g.getNome());
            posicaoJogador.setText("GL");
            idade.setText(String.valueOf(g.getIdade() + "anos"));
            altura.setText(String.valueOf(g.getTamanho() + "m"));
            peso.setText(String.valueOf(g.getPeso() + "Kg"));
            camisa.setText("Camisa " + String.valueOf(g.getCamisa()));
            gols.setText(String.valueOf(g.getnDefesas() + " defs na temp."));
            assistencias.setText(String.valueOf(g.getAssistencias() + "assist. na temp."));
        }

    }//GEN-LAST:event_tabelaJogadoresMouseClicked

    public ArrayList<Time> getTimes() {
        return times;
    }

    public void setTimes(ArrayList<Time> times) {
        this.times = times;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    
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
            java.util.logging.Logger.getLogger(JTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JTime().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel altura;
    private javax.swing.JButton anterior;
    private javax.swing.JLabel aproveitamento;
    private javax.swing.JLabel assistencias;
    private javax.swing.JLabel camisa;
    private javax.swing.JLabel der;
    private javax.swing.JLabel emp;
    private javax.swing.JLabel estadio;
    private javax.swing.JLabel gols;
    private javax.swing.JLabel icone;
    private javax.swing.JLabel idade;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jogadores;
    private javax.swing.JLabel nome;
    private javax.swing.JLabel nomeJogador;
    private javax.swing.JPanel panelTime;
    private javax.swing.JLabel peso;
    private javax.swing.JLabel posicaoJogador;
    private javax.swing.JButton proximo;
    private javax.swing.JLabel ranking;
    private javax.swing.JLabel sigla;
    private javax.swing.JList<String> tabelaJogadores;
    private javax.swing.JLabel vit;
    // End of variables declaration//GEN-END:variables

}
