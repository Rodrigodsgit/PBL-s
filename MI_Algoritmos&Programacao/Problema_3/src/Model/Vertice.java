
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Mestre
 */
public class Vertice {
    private String nome;
    private  boolean visitado;
    private ArrayList<Aresta> ListaArestas;
    private boolean terminal;
    private float x;
    private float y;
    private int d; 
    private ArrayList<Vertice> anterior; 
    private Vertice ant; 
    

    Vertice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


//------------------------------------------------------------------------------
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public ArrayList<Aresta> getListaArestas() {
        return ListaArestas;
    }

    public void setListaArestas(ArrayList<Aresta> ListaArestas) {
        this.ListaArestas = ListaArestas;
    }

    public boolean isTerminal() {
        return terminal;
    }

    public void setTerminal(boolean terminal) {
        this.terminal = terminal;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    
   public int getD() {
		return d;
	}


	public void setD(int d) {
		this.d = d;
	}


	public ArrayList<Vertice> getAnterior() {
		return anterior;
	}


	public void setAnterior(ArrayList<Vertice> anterior) {
		this.anterior = anterior;
	}


	public Vertice getAnt() {
		return ant;
	}


	public void setAnt(Vertice ant) {
		this.ant = ant;
	}

//------------------------------------------------------------------------------
    	
public Vertice(String nome,boolean terminal, float x , float y){
        this.nome = nome;
        this.terminal = terminal;
        this.visitado = false;
        this.x = x;
        this.y = y;
        this.ListaArestas = new ArrayList<Aresta>();
        this.anterior = null;
        this.anterior = new ArrayList<Vertice>();
    }
    
    public void addAresta(Aresta a){
        this.ListaArestas.add(a);
    }
}
