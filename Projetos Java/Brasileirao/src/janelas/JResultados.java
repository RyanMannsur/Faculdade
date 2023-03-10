/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janelas;

import jogadores.*;
import time.Time;

/**
 *
 * @author Tata_
 */
public class JResultados extends javax.swing.JFrame {

    private JogadorDeLinha artilheiro;
    private JogadorDeLinha assistente;
    private Goleiro goleiro;
    private Time campeao;
    private Time rebaixados[];
    private Time classificados[];
    
    public JResultados() {
        
        initComponents();
    }
    
    public void mudarDados(){
        nomeArtilheiro.setText(artilheiro.getNome()+" ā½");
        nomeAssistente.setText(assistente.getNome()+"\nš");
        nomeGoleiro.setText("š "+goleiro.getNome());
        nomeTime.setText("š "+campeao.getNome()+" š");
        poontos.setText(String.valueOf(campeao.getPontos())+"p");
        vitorias.setText(String.valueOf(campeao.getVitorias())+"ā");
        golsTime.setText(String.valueOf(campeao.getgFeitos())+"ā½");
        golsArtilheir.setText(String.valueOf(artilheiro.getnGols())+"ā½");
        assistencias.setText(String.valueOf(assistente.getAssistencias())+"\nš");
        defesas.setText(String.valueOf("š "+goleiro.getnDefesas()));
        reb1.setText(rebaixados[0].getNome()+"ā¬");
        reb2.setText(rebaixados[1].getNome()+"ā¬");
        reb3.setText(rebaixados[2].getNome()+"ā¬");
        reb4.setText(rebaixados[3].getNome()+"ā¬");
        cla1.setText("ā«"+classificados[0].getNome());
        cla2.setText("ā«"+classificados[1].getNome());
        cla3.setText("ā«"+classificados[2].getNome());
        cla4.setText("ā«"+classificados[3].getNome());
        icone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/" + campeao.getLogo() + ".png")));
    }

    public JogadorDeLinha getAssistente() {
        return assistente;
    }

    public void setAssistente(JogadorDeLinha assistente) {
        this.assistente = assistente;
    }

    public Time[] getRebaixados() {
        return rebaixados;
    }

    public void setRebaixados(Time[] rebaixados) {
        this.rebaixados = rebaixados;
    }

    public Time[] getClassificados() {
        return classificados;
    }

    public void setClassificados(Time[] classificados) {
        this.classificados = classificados;
    }
    
    

    public JogadorDeLinha getArtilheiro() {
        return artilheiro;
    }

    public void setArtilheiro(JogadorDeLinha artilheiro) {
        this.artilheiro = artilheiro;
    }

    public Goleiro getGoleiro() {
        return goleiro;
    }

    public void setGoleiro(Goleiro goleiro) {
        this.goleiro = goleiro;
    }

    public Time getCampeao() {
        return campeao;
    }

    public void setCampeao(Time campeao) {
        this.campeao = campeao;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        nomeArtilheiro = new javax.swing.JLabel();
        nomeGoleiro = new javax.swing.JLabel();
        golsArtilheir = new javax.swing.JLabel();
        defesas = new javax.swing.JLabel();
        nomeTime = new javax.swing.JLabel();
        poontos = new javax.swing.JLabel();
        vitorias = new javax.swing.JLabel();
        golsTime = new javax.swing.JLabel();
        icone = new javax.swing.JLabel();
        nomeAssistente = new javax.swing.JLabel();
        assistencias = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        reb1 = new javax.swing.JLabel();
        reb2 = new javax.swing.JLabel();
        reb3 = new javax.swing.JLabel();
        reb4 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cla1 = new javax.swing.JLabel();
        cla2 = new javax.swing.JLabel();
        cla3 = new javax.swing.JLabel();
        cla4 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultados"));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Fim do Campeonato");

        nomeArtilheiro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nomeArtilheiro.setText("Artilheiro");

        nomeGoleiro.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nomeGoleiro.setText("Melhor goleiro");

        golsArtilheir.setText("Numero de gols");

        defesas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        defesas.setText("Numero de defesas");

        nomeTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nomeTime.setText("Time Campeao");

        poontos.setText("Pontos");

        vitorias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vitorias.setText("Viorias");

        golsTime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        golsTime.setText("Gols");

        icone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/default_1.png"))); // NOI18N

        nomeAssistente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nomeAssistente.setText("Assistencia");

        assistencias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        assistencias.setText("Assistencias");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Rebaixados");

        reb1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        reb1.setText("Time rabaixado 1");

        reb2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        reb2.setText("Time rebaixado 2");

        reb3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        reb3.setText("Time rabaixado 3");

        reb4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        reb4.setText("Time rabaixado 4");

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Classificados");

        cla1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cla1.setText("Time classificado 1");

        cla2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cla2.setText("Time classificado 1");

        cla3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cla3.setText("Time classificado 1");

        cla4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cla4.setText("Time classificado 1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(poontos)
                    .addComponent(nomeArtilheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(golsArtilheir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(assistencias, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeAssistente, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vitorias, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeTime, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(defesas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomeGoleiro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(golsTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(icone)
                .addGap(162, 162, 162))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(reb4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cla4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel20))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(reb1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cla1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(reb2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cla2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(reb3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cla3)))
                .addGap(10, 10, 10))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addComponent(jSeparator1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(icone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nomeTime)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(poontos, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(vitorias, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(golsTime, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomeAssistente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(nomeArtilheiro, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(nomeGoleiro, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(golsArtilheir, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(assistencias, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(defesas, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(21, 21, 21)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reb1)
                    .addComponent(cla1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reb2)
                    .addComponent(cla2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reb3)
                    .addComponent(cla3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reb4)
                    .addComponent(cla4))
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(JResultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JResultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JResultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JResultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JResultados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel assistencias;
    private javax.swing.JLabel cla1;
    private javax.swing.JLabel cla2;
    private javax.swing.JLabel cla3;
    private javax.swing.JLabel cla4;
    private javax.swing.JLabel defesas;
    private javax.swing.JLabel golsArtilheir;
    private javax.swing.JLabel golsTime;
    private javax.swing.JLabel icone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel nomeArtilheiro;
    private javax.swing.JLabel nomeAssistente;
    private javax.swing.JLabel nomeGoleiro;
    private javax.swing.JLabel nomeTime;
    private javax.swing.JLabel poontos;
    private javax.swing.JLabel reb1;
    private javax.swing.JLabel reb2;
    private javax.swing.JLabel reb3;
    private javax.swing.JLabel reb4;
    private javax.swing.JLabel vitorias;
    // End of variables declaration//GEN-END:variables
}
