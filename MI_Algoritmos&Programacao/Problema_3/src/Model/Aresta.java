/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Mestre
 */
public class Aresta {
    private int peso;
    private Vertice origem;
    private Vertice destino;
    
//------------------------------------------------------------------------------

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Vertice getOrigem() {
        return origem;
    }

    public void setOrigem(Vertice origem) {
        this.origem = origem;
    }

    public Vertice getDestino() {
        return destino;
    }

    public void setDestino(Vertice destino) {
        this.destino = destino;
    }

//------------------------------------------------------------------------------
    
    public Aresta(Vertice origem, Vertice destino, int peso){
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }
    
}
