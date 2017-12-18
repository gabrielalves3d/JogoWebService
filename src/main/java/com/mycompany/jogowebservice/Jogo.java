/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jogowebservice;

import java.util.Scanner;
import javax.ws.rs.Path;

/**
 *
 * @author Gabriel Alves
 */
@Path("jogodavelha")
public final class Jogo {

    public Tabuleiro tabuleiro = new Tabuleiro();
    public static int rodada = 1, vez = 1;
    private final int[] tentativa = new int[2];
    public Scanner teclado = new Scanner(System.in);

    public String statusDaRodada() {
        return "RODADA:" + rodada + "<br> VEZ DO JOGADOR:" + vez() + "<br>" + tabuleiro.exibirTabuleiro() + "<br>" + finalizarJogo();

    }

    public String realizarTentativa() {
        if (tentativa[0] > 3 || tentativa[0] < 1) {
            return "Linha Inválida! Jogue novamente";
        } else if (tentativa[1] > 3 || tentativa[1] < 1) {
            return "Coluna inválida! Jogue novamente";
        }
        if (!checarTentativa(tentativa, tabuleiro)) {
            return "Esse local já foi marcado. Tente outro.";
        }
        tabuleiro.mudarTabuleiro(tentativa, vez());
        vez++;
        rodada++;
        return "a";
    }

    public boolean checarTentativa(int[] tentativa, Tabuleiro tabuleiro) {
        return tabuleiro.verPosicao(tentativa) == 0;
    }

    public String gerenciarJogo(int linha, int coluna) {

        if (linha > 3 || linha < 1) {
            return "Linha invalida! Jogue novamente<br>" + statusDaRodada();
        } else if (coluna > 3 || coluna < 1) {
            return "Coluna invalida! Jogue novamente<br>" + statusDaRodada();
        }
        tentativa[0] = linha - 1;
        tentativa[1] = coluna - 1;
        if (tabuleiro.checarEmpate()) {
            return "Tabuleiro Completo. Jogo empatado <br>" + tabuleiro.exibirTabuleiro();

        }
        if (!checarTentativa(tentativa, tabuleiro)) {
            return "Esse local ja foi marcado. Tente outro. <br>" + statusDaRodada();
        }
        else {tabuleiro.mudarTabuleiro(tentativa, vez());
            vez++;
            rodada++;
            return statusDaRodada();
        }

    }

    public String finalizarJogo() {
        if (tabuleiro.checarLinhas() == 1) {
            return ("Jogador 1 ganhou!");
        } else if (tabuleiro.checarColunas() == 1) {
            return ("Jogador 1 ganhou!");
        } else if (tabuleiro.checarDiagonais() == 1) {
            return ("Jogador 1 ganhou!");
        } else if (tabuleiro.checarLinhas() == 2) {
            return ("Jogador 2 ganhou!");
        } else if (tabuleiro.checarColunas() == 2) {
            return ("Jogador 2 ganhou!");
        } else if (tabuleiro.checarDiagonais() == 2) {
            return ("Jogador 2 ganhou!");
        }
        return "";
    }

    public int vez() {
        if (vez % 2 == 1) {
            return 1;
        } else {
            return 2;
        }
    }

    public void resetar() {
        rodada = 1;
        vez = 1;
        int[][] tab = {{0,0,0},{0,0,0},{0,0,0}};

        tabuleiro.setTabuleiro(tab);
    }
}
