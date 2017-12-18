/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jogowebservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author ogi
 */
@Path("jogorest")
public class JogoRest {
    public Jogo jogo = new Jogo();
    
    @Path("status")
    @GET
    public String statusDaRodada() {
        return jogo.statusDaRodada();
    }
    @Path("jogar")
    @GET
    public String gerenciarJogo(@QueryParam("linha") int linha, @QueryParam("coluna") int coluna) {
        return jogo.gerenciarJogo(linha, coluna);
    }
    @Path("resetar")
    @GET
    public String resetar(){
        jogo.resetar();
        jogo= new Jogo();
        return jogo.statusDaRodada();
    }
    
    
    
}
