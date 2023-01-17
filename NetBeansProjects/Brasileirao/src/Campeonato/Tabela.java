package Campeonato;

import java.util.ArrayList;
import java.util.Random;
import jogadores.JogadorBase;
import jogadores.Goleiro;
import jogadores.JogadorDeLinha;
import time.Time;

public class Tabela {

    private ArrayList<Time> times;
    private Rodada rodadas[];
    private int rodadaAtual;

    public Tabela() {
        times = new ArrayList<>();

    }

    public void definirTimesConfrontosERodadas(ArrayList<Time> times) {
        rodadaAtual = 0;
        this.times = times;
        nRodadas();
        definirConfrontos();
    }

    public ArrayList<Time> getTimes() {
        return times;
    }

    public void setTimes(ArrayList<Time> times) {
        this.times = times;
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

    public void adicionarTime(Time time) {
        times.add(time);
    }

    public void nRodadas() {
        int x = times.size() - 1;
        x *= 2;
        rodadas = new Rodada[x];
        for (int i = 0; i < rodadas.length; i++) {
            rodadas[i] = new Rodada();
            rodadas[i].nPartidas(times.size() / 2);
        }
    }

    private void definirConfrontos() {
        Random r = new Random();
        ArrayList<Time> copiaTimes = new ArrayList<>();
        ArrayList<Time> copiaTimes2 = new ArrayList<>();
        Time timeAux, timeAux2, vetorTimes[] = new Time[2];
        ArrayList<Time[]> pares = new ArrayList<>();
        int x, y;
        boolean verificar;

        for (int i = 0; i < times.size(); i++) {
            copiaTimes.add(times.get(i));
        }
        int cont = 0;
        do {
            for (int i = 0; i < copiaTimes.size(); i++) {
                x = r.nextInt(copiaTimes.size());
                y = r.nextInt(copiaTimes.size());
                timeAux = copiaTimes.get(x);
                copiaTimes.set(x, copiaTimes.get(y));
                copiaTimes.set(y, copiaTimes.get(i));
                copiaTimes.set(i, timeAux);
            }
            cont++;
        } while (cont < 5);

        for (int i = 0; i < copiaTimes.size(); i++) {
            copiaTimes2.add(copiaTimes.get(i));
            copiaTimes.remove(copiaTimes.get(i));
        }

        for (int i = 0; i < rodadas.length / 2; i++) {
            for (int j = 0; j < copiaTimes.size(); j++) {
                if (r.nextBoolean()) {
                    pares.add(new Time[]{copiaTimes.get(j), copiaTimes2.get(j)});
                } else {
                    pares.add(new Time[]{copiaTimes2.get(j), copiaTimes.get(j)});
                }
            }
            for (int j = 0; j < pares.size(); j++) {
                do {
                    verificar = true;
                    x = r.nextInt(10);
                    for (Time time : rodadas[i].getPartidas()[x].getTimes()) {
                        if (time != null) {
                            verificar = false;
                        }
                    }
                } while (!verificar);
                rodadas[i].getPartidas()[x].setTimes(pares.get(j));
                vetorTimes = new Time[]{pares.get(j)[1],pares.get(j)[0]};
                rodadas[i+(rodadas.length/2)].getPartidas()[x].setTimes(vetorTimes);
            }
            pares.clear();
            timeAux = copiaTimes.get(copiaTimes.size() - 1);
            timeAux2 = copiaTimes2.get(0);
            for (int j = copiaTimes.size() - 1; j > 1; j--) {
                copiaTimes.set(j, copiaTimes.get(j - 1));
            }
            for (int j = 0; j < copiaTimes2.size() - 1; j++) {
                copiaTimes2.set(j, copiaTimes2.get(j + 1));
            }
            copiaTimes.set(1, timeAux2);
            copiaTimes2.set(copiaTimes2.size() - 1, timeAux);
        }
        
    }   

    public void atulizarTabela() {
        rodadas[rodadaAtual].resultados();
        for (Time time : times) {
            for (int i = 0; i < rodadas[this.rodadaAtual].getPartidas().length; i++) {
                for (int j = 0; j < 2; j++) {
                    if (time.getNome().equalsIgnoreCase(rodadas[this.rodadaAtual].getPartidas()[i].getTimes()[j].getNome())) {
                        times.set(times.indexOf(time), rodadas[this.rodadaAtual].getPartidas()[i].getTimes()[j]);
                    }
                }
            }

        }
        this.rodadaAtual++;
        ordenarTimes();
    }

    private void ordenarTimes() {
        Time aux;
        for (int i = 0; i < times.size() - 1; i++) {
            for (int j = i + 1; j < times.size(); j++) {
                if (times.get(j).getPontos() > times.get(i).getPontos()) {
                    aux = times.get(i);
                    times.set(i, times.get(j));
                    times.set(j, aux);
                } else {
                    if (times.get(j).getPontos() == times.get(i).getPontos()) {
                        if (times.get(j).getVitorias() > times.get(i).getVitorias()) {
                            aux = times.get(i);
                            times.set(i, times.get(j));
                            times.set(j, aux);
                        } else {
                            if (times.get(j).getVitorias() == times.get(i).getVitorias()) {
                                if (times.get(j).getSaldoDeGols() > times.get(i).getSaldoDeGols()) {
                                    aux = times.get(i);
                                    times.set(i, times.get(j));
                                    times.set(j, aux);
                                }
                            }

                        }
                    }
                }
            }
        }
    }

    public ArrayList<JogadorDeLinha> listaArtilharia() {
        ArrayList<JogadorDeLinha> jogadores = new ArrayList<>();
        JogadorDeLinha aux;
        for (int i = 0; i < times.size(); i++) {
            for (JogadorDeLinha jogador : times.get(i).getJogadores()) {
                jogadores.add(jogador);
            }
        }

        for (int i = 0; i < jogadores.size() - 1; i++) {
            for (int j = i + 1; j < jogadores.size(); j++) {
                if (jogadores.get(j).getnGols() > jogadores.get(i).getnGols()) {
                    aux = jogadores.get(i);
                    jogadores.set(i, jogadores.get(j));
                    jogadores.set(j, aux);
                }
            }
        }
        return jogadores;
    }

    public ArrayList<JogadorDeLinha> listaAssistencias() {
        ArrayList<JogadorDeLinha> jogadores = new ArrayList<>();
        JogadorDeLinha aux;
        for (int i = 0; i < times.size(); i++) {
            for (JogadorDeLinha jogador : times.get(i).getJogadores()) {
                jogadores.add(jogador);
            }
        }

        for (int i = 0; i < jogadores.size() - 1; i++) {
            for (int j = i + 1; j < jogadores.size(); j++) {
                if (jogadores.get(j).getAssistencias() > jogadores.get(i).getAssistencias()) {
                    aux = jogadores.get(i);
                    jogadores.set(i, jogadores.get(j));
                    jogadores.set(j, aux);
                }
            }
        }
        return jogadores;
    }

    public ArrayList<Goleiro> listaDefesas() {
        ArrayList<Goleiro> goleiros = new ArrayList<>();
        Goleiro aux;
        for (int i = 0; i < times.size(); i++) {
            for (Goleiro goleiro : times.get(i).getGoleiros()) {
                goleiros.add(goleiro);
            }
        }

        for (int i = 0; i < goleiros.size() - 1; i++) {
            for (int j = i + 1; j < goleiros.size(); j++) {
                if (goleiros.get(j).getnDefesas() > goleiros.get(i).getnDefesas()) {
                    aux = goleiros.get(i);
                    goleiros.set(i, goleiros.get(j));
                    goleiros.set(j, aux);
                }
            }
        }
        return goleiros;
    }
}
