package Campeonato;

import java.util.ArrayList;
import java.util.Random;
import jogadores.JogadorDeLinha;
import time.Time;

public class Partida {

    private Time times[];
    private int estatisticasTimeA[];
    private int estatisticasTimeB[];
    ArrayList<String> golsA;
    ArrayList<String> golsB;

    public Partida() {
        golsA = new ArrayList<>();
        golsB = new ArrayList<>();
        times = new Time[2];
        estatisticasTimeA = new int[7];
        estatisticasTimeB = new int[7];

        for (int i = 0; i < 5; i++) {
            estatisticasTimeA[i] = estatisticasTimeB[i] = 0;
        }
        /*
        estatisticas[0] = gols
        estatisticas[1] = posse de bola
        estatisticas[2] = finalizacoes
        estatisticas[3] = finalizacoesCertas
        estatisticas[4] = passes
        estatisticas[5] = faltas
        estatisticas[6] = escanteios  
         */
    }

    public Time[] getTimes() {
        return times;
    }

    public void setTimes(Time[] times) {
        this.times = times;
    }

    public int[] getEstatisticasTimeA() {
        return estatisticasTimeA;
    }

    public int[] getEstatisticasTimeB() {
        return estatisticasTimeB;
    }

    public ArrayList<String> getGolsA() {
        return golsA;
    }

    public ArrayList<String> getGolsB() {
        return golsB;
    }
    
    

    public void gerarEstatisticas() {
        Random r = new Random();
        //--------------------Gerando o resultado do jogo--------------------------------------------
        double copiaRankingA = times[0].getRanking() + 0.5, copiaRankingB = times[1].getRanking();
        double diferencaDeRanking = Math.abs(copiaRankingA - copiaRankingB), percRankingA, percRankingB;
        if (copiaRankingA > copiaRankingB && diferencaDeRanking != 0) {
            percRankingA = diferencaDeRanking * 100;
            percRankingB = diferencaDeRanking * 10;
        } else {
            if (copiaRankingA < copiaRankingB && diferencaDeRanking != 0) {
                percRankingA = diferencaDeRanking * 10;
                percRankingB = diferencaDeRanking * 100;
            } else {
                diferencaDeRanking = 30;
                percRankingA = percRankingB = diferencaDeRanking;
            }
        }
        do {
            int x = r.nextInt(100);
            if (percRankingA > (double) x) {
                estatisticasTimeA[0]++;
                JogadorDeLinha j = jogadorFezGol(times[0]);
                JogadorDeLinha j2;
                do {
                    j2 = jogadorDeuAssistencia(times[0]);
                } while (j2 == j);
                for (JogadorDeLinha jogador : times[0].getJogadores()) {
                    if (jogador == j) {
                        jogador.fezGol();
                        golsA.add(j.getNome());
                    }
                    if (jogador == j2) {
                        jogador.deuAssistencia();
                    }
                }
            }
            x = r.nextInt(100);
            if (percRankingB > (double) x) {
                estatisticasTimeB[0]++;
                JogadorDeLinha j = jogadorFezGol(times[1]);
                JogadorDeLinha j2;
                do {
                    j2 = jogadorDeuAssistencia(times[1]);
                } while (j2 == j);
                for (JogadorDeLinha jogador : times[1].getJogadores()) {
                    if (jogador == j) {
                        jogador.fezGol();
                        golsB.add(j.getNome());
                        
                    }
                    if (jogador == j2) {
                        jogador.deuAssistencia();
                    }
                }

            }

            if (percRankingA == percRankingB) {
                percRankingA -= 10;
                percRankingB -= 10;
            } else {
                if (percRankingA > percRankingB) {
                    percRankingB -= 1;
                    if ((percRankingA - percRankingB) * 100 > 100) {
                        percRankingA -= 50;
                    } else {
                        percRankingA -= 30;
                    }
                } else {
                    percRankingA -= 1;
                    if ((percRankingB - percRankingA) * 100 > 100) {
                        percRankingB -= 50;
                    } else {
                        percRankingB -= 30;
                    }
                }
            }
        } while (percRankingB > 0 || percRankingB > 0);
        //--------------------------------Outras estatisticas------------------------------------------------
        gerarPosseDeBola();
        gerarFinsPassesEtc();
        gerarNumeroDeDefesas();
        adicionarPontosEOutrosDados();
        //--------------------------------------------------------------------------------------------------------
    }

    private JogadorDeLinha jogadorFezGol(Time time) {
        Random r = new Random();
        ArrayList<JogadorDeLinha> atacantes = new ArrayList<>();
        ArrayList<JogadorDeLinha> meiasATA = new ArrayList<>();
        ArrayList<JogadorDeLinha> meias = new ArrayList<>();
        ArrayList<JogadorDeLinha> outros = new ArrayList<>();

        for (JogadorDeLinha jogador : time.getJogadores()) {
            if (jogador.getPosicoes().contains("ATA") || jogador.getPosicoes().contains("PD")
                    || jogador.getPosicoes().contains("PE") || jogador.getPosicoes().contains("SA")) {
                atacantes.add(jogador);
            } else {
                if (jogador.getPosicoes().contains("MD") || jogador.getPosicoes().contains("ME")
                        || jogador.getPosicoes().contains("MEI")) {
                    meiasATA.add(jogador);
                } else {
                    if (jogador.getPosicoes().contains("MC") || jogador.getPosicoes().contains("VOL")) {
                        meias.add(jogador);
                    } else {
                        outros.add(jogador);
                    }
                }
            }
        }
        int x = r.nextInt(100);
        if (55 > x && atacantes.size() > 0) {
            return atacantes.get(r.nextInt(atacantes.size()));
        } else {
            if (55 >= x && x < 80 && meiasATA.size() > 0) {
                return meiasATA.get(r.nextInt(meiasATA.size()));
            } else {
                if (80 >= x && x < 95 && meias.size() > 0) {
                    return meias.get(r.nextInt(meias.size()));
                } else {
                    return outros.get(r.nextInt(outros.size()));
                }
            }
        }
    }

    private JogadorDeLinha jogadorDeuAssistencia(Time time) {
        Random r = new Random();
        ArrayList<JogadorDeLinha> atacantes = new ArrayList<>();
        ArrayList<JogadorDeLinha> meiasATA = new ArrayList<>();
        ArrayList<JogadorDeLinha> meias = new ArrayList<>();
        ArrayList<JogadorDeLinha> outros = new ArrayList<>();

        for (JogadorDeLinha jogador : time.getJogadores()) {
            if (jogador.getPosicoes().contains("MD") || jogador.getPosicoes().contains("ME")
                    || jogador.getPosicoes().contains("MEI")) {
                meiasATA.add(jogador);
            } else {
                if (jogador.getPosicoes().contains("ATA") || jogador.getPosicoes().contains("PD")
                        || jogador.getPosicoes().contains("PE") || jogador.getPosicoes().contains("SA")) {
                    atacantes.add(jogador);
                } else {
                    if (jogador.getPosicoes().contains("MC") || jogador.getPosicoes().contains("VOL")) {
                        meias.add(jogador);
                    } else {
                        outros.add(jogador);
                    }
                }
            }
        }
        int x = r.nextInt(100);
        if (55 > x && meiasATA.size() > 0) {
            return meiasATA.get(r.nextInt(meiasATA.size()));
        } else {
            if (55 >= x && x < 80 && atacantes.size() > 0) {
                return atacantes.get(r.nextInt(atacantes.size()));
            } else {
                if (80 >= x && x < 95 && meias.size() > 0) {
                    return meias.get(r.nextInt(meias.size()));
                } else {
                    return outros.get(r.nextInt(outros.size()));
                }
            }
        }
    }

    private void gerarPosseDeBola() {
        if (estatisticasTimeA[0] > estatisticasTimeB[0]) {
            if (estatisticasTimeA[0] - estatisticasTimeB[0] == 1) {
                estatisticasTimeA[1] = 53;
                estatisticasTimeB[1] = 47;
            }
            if (estatisticasTimeA[0] - estatisticasTimeB[0] == 2) {
                estatisticasTimeA[1] = 56;
                estatisticasTimeB[1] = 44;
            }
            if (estatisticasTimeA[0] - estatisticasTimeB[0] == 3) {
                estatisticasTimeA[1] = 59;
                estatisticasTimeB[1] = 41;
            }
            if (estatisticasTimeA[0] - estatisticasTimeB[0] > 3) {
                estatisticasTimeA[1] = 65;
                estatisticasTimeB[1] = 35;
            }
        } else {
            if (estatisticasTimeA[0] < estatisticasTimeB[0]) {
                if (estatisticasTimeB[0] - estatisticasTimeA[0] == 1) {
                    estatisticasTimeB[1] = 53;
                    estatisticasTimeA[1] = 47;
                }
                if (estatisticasTimeB[0] - estatisticasTimeA[0] == 2) {
                    estatisticasTimeB[1] = 56;
                    estatisticasTimeA[1] = 44;
                }
                if (estatisticasTimeB[0] - estatisticasTimeA[0] == 3) {
                    estatisticasTimeB[1] = 59;
                    estatisticasTimeA[1] = 41;
                }
                if (estatisticasTimeB[0] - estatisticasTimeA[0] > 3) {
                    estatisticasTimeB[1] = 65;
                    estatisticasTimeA[1] = 35;
                }
            } else {
                estatisticasTimeA[1] = estatisticasTimeB[1] = 50;
            }
        }
    }

    private void gerarFinsPassesEtc() {
        /*
        estatisticas[0] = gols
        estatisticas[1] = posse de bola
        estatisticas[2] = finalizacoes
        estatisticas[3] = finalizacoesCertas
        estatisticas[4] = passes
        estatisticas[5] = faltas
        estatisticas[6] = escanteios  
         */
        Random r = new Random();
        int finCertasA, finCertasB, finA, finB, passesA, passesB, escanteioA, escanteioB, faltasA, faltasB;
        //Finalizacoes
        finCertasA = estatisticasTimeA[0] + r.nextInt(estatisticasTimeA[0]+1) + (r.nextInt(2) + 1);
        finCertasB = estatisticasTimeB[0] + r.nextInt(estatisticasTimeB[0]+1) + (r.nextInt(2) + 1);
        finA = finCertasA * (r.nextInt(2) + 1) + r.nextInt(finCertasA);
        finB = finCertasB * (r.nextInt(2) + 1) + r.nextInt(finCertasB);
        estatisticasTimeA[2] = finA;
        estatisticasTimeA[3] = finCertasA;
        estatisticasTimeB[2] = finB;
        estatisticasTimeB[3] = finCertasB;
        //Passes
        passesA = (estatisticasTimeA[1]*7) + (estatisticasTimeA[1]*r.nextInt(4));
        passesB = (estatisticasTimeB[1]*7) + (estatisticasTimeB[1]*r.nextInt(4));
        estatisticasTimeA[4] = passesA;
        estatisticasTimeB[4] = passesB;
        //Faltas
        faltasA = 5 + r.nextInt(r.nextInt(15)+1);
        faltasB = 5 + r.nextInt(r.nextInt(15)+1);
        estatisticasTimeA[5] = faltasA;
        estatisticasTimeB[5] = faltasB;
        //Escanteios
        escanteioA = finA/2 + (r.nextInt(4)-2);
        escanteioB = finB/2 + (r.nextInt(4)-2);
        estatisticasTimeA[6] = (escanteioA < 0 ? 0 : escanteioA);
        estatisticasTimeB[6] = (escanteioB < 0 ? 0 : escanteioB);
        

    }
    
    private void gerarNumeroDeDefesas(){
        /*
        estatisticas[0] = gols
        estatisticas[3] = finalizacoesCertas
        */
        int defesas;
        defesas = estatisticasTimeA[3] - estatisticasTimeA[0];
        for (int i = 0; i < defesas; i++) {
            times[1].getGoleiros().get(0).defendeu();
        }
        
        defesas = estatisticasTimeB[3] - estatisticasTimeB[0];
        for (int i = 0; i < defesas; i++) {
            times[0].getGoleiros().get(0).defendeu();
        }
        
    }

    private void adicionarPontosEOutrosDados() {
        times[0].setgFeitos(times[0].getgFeitos() + estatisticasTimeA[0]);
        times[0].setgSofridos(times[0].getgSofridos() + estatisticasTimeB[0]);
        times[0].setSaldoDeGols(times[0].getgFeitos() - times[0].getgSofridos());

        times[1].setgFeitos(times[1].getgFeitos() + estatisticasTimeB[0]);
        times[1].setgSofridos(times[1].getgSofridos() + estatisticasTimeA[0]);
        times[1].setSaldoDeGols(times[1].getgFeitos() - times[1].getgSofridos());

        if (estatisticasTimeA[0] > estatisticasTimeB[0]) {
            times[0].setVitorias(times[0].getVitorias() + 1);
            times[0].setPontos(times[0].getPontos() + 3);
            times[1].setDerrotas(times[1].getDerrotas() + 1);
            times[1].setRanking(times[1].getRanking() - 0.2);
            times[0].setRanking(times[0].getRanking() + 0.2);
            if (times[1].getRanking() < 3) {
                times[1].setRanking(3);
            }
            if (times[0].getRanking() > 5) {
                times[0].setRanking(5);
            }
        } else {
            if (estatisticasTimeA[0] < estatisticasTimeB[0]) {
                times[1].setVitorias(times[1].getVitorias() + 1);
                times[1].setPontos(times[1].getPontos() + 3);
                times[0].setDerrotas(times[0].getDerrotas() + 1);
                times[0].setRanking(times[0].getRanking() - 0.2);
                times[1].setRanking(times[1].getRanking() + 0.2);
                if (times[0].getRanking() < 3) {
                    times[0].setRanking(3);
                }
                if (times[1].getRanking() > 5) {
                    times[1].setRanking(5);
                }
            } else {
                times[1].setEmpates(times[1].getEmpates() + 1);
                times[0].setEmpates(times[0].getEmpates() + 1);
                times[1].setPontos(times[1].getPontos() + 1);
                times[0].setPontos(times[0].getPontos() + 1);
            }

        }
    }

}
