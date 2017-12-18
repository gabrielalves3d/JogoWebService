/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jogowebservice;

import javax.ws.rs.Path;

/**
 *
 * @author Gabriel Alves
 */
@Path("kkk")
public class Tabuleiro {
   static int[][] tabuleiro = {{0,0,0},{0,0,0},{0,0,0}};

    
    
    public Tabuleiro(int [][]tabuleiro) {
        Tabuleiro.tabuleiro=tabuleiro;
    }

    public Tabuleiro() {
    }
    
    

    public void gerarTabuleiro() {
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; linha < 3; linha++) {
                tabuleiro[linha][coluna] = 0;
            }
        }
    }

    public static void setTabuleiro(int[][] tabuleiro) {
        Tabuleiro.tabuleiro = tabuleiro;
    }
    public String exibirTabuleiro() {
        String tab ="";
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                if (tabuleiro[linha][coluna] == 3) {
                    tab+=" X ";
                } else if (tabuleiro[linha][coluna] == 2) {
                    tab+=" O ";
                } else {
                    tab+=" - ";
                }
                if (coluna == 0 || coluna == 1) {
                    tab+=" | ";
                }
            }
            tab+="<br>";
        }
        return tab;
    }

    public int verPosicao(int[] tentativa) {
        return tabuleiro[tentativa[0]][tentativa[1]];
    }

    public void mudarTabuleiro(int[] tentativa, int jogador) {
        if (jogador == 1) {
            tabuleiro[tentativa[0]][tentativa[1]] = 3;
        } else {
            tabuleiro[tentativa[0]][tentativa[1]] = 2;
        }
    }

    public int checarLinhas() {
        for (int linha = 0; linha < 3; linha++) {
            if (tabuleiro[linha][0] * tabuleiro[linha][1] * tabuleiro[linha][2] == 27) {
                return 1;
            } else if (tabuleiro[linha][0] * tabuleiro[linha][1] * tabuleiro[linha][2] == 8) {
                return 2;
            }
        }
        return 0;
    }

    public int checarColunas() {
        for (int coluna = 0; coluna < 3; coluna++) {
            if (tabuleiro[0][coluna] * tabuleiro[1][coluna] * tabuleiro[2][coluna] == 27) {
                return 1;
            } else if (tabuleiro[0][coluna] * tabuleiro[1][coluna] * tabuleiro[2][coluna] == 8) {
                return 2;
            }
        }
        return 0;
    }

    public int checarDiagonais() {
        if (tabuleiro[0][0] * tabuleiro[1][1] * tabuleiro[2][2] == 27) {
            return 1;
        } else if (tabuleiro[0][0] * tabuleiro[1][1] * tabuleiro[2][2] == 8) {
            return 2;
        } else if (tabuleiro[0][2] * tabuleiro[1][1] * tabuleiro[2][0] == 27) {
            return 1;
        } else if (tabuleiro[0][2] * tabuleiro[1][1] * tabuleiro[2][0] == 8) {
            return 2;
        }

        return 0;
    }

    public boolean checarEmpate() {
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                if (tabuleiro[linha][coluna] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
