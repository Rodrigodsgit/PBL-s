/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Mestre
 */
public class Grafo {
    private ArrayList<Aresta> ListaGeralArestas;
    private ArrayList<Vertice> ListaGeralVertice;
    
//------------------------------------------------------------------------------

    public ArrayList<Aresta> getListaGeralArestas() {
        return ListaGeralArestas;
    }

    public void setListaGeralArestas(ArrayList<Aresta> ListaGeralArestas) {
        this.ListaGeralArestas = ListaGeralArestas;
    }

    public ArrayList<Vertice> getListaGeralVertice() {
        return ListaGeralVertice;
    }

    public void setListaGeralVertice(ArrayList<Vertice> ListaGeralVertice) {
        this.ListaGeralVertice = ListaGeralVertice;
    }
    
//-----------------------------------------------------------------------------------------------------------------------------\\
    
    public Grafo(){
        this.ListaGeralArestas =  new ArrayList<Aresta>();
        this.ListaGeralVertice =  new ArrayList<Vertice>();   
    }
    
    public Vertice addVertice(String nome,boolean terminal, float x , float y){
        Vertice v =  new Vertice(nome, terminal, x ,  y);
        this.ListaGeralVertice.add(v);
        return v;
    }
    
    public Vertice addVertice(Vertice v){
        this.ListaGeralVertice.add(v);
        return v;
    }
    
    public void addAresta(Vertice origem, Vertice destino, int peso){
        Aresta a =  new Aresta(origem, destino, peso);
        origem.getListaArestas().add(a);
        destino.getListaArestas().add(a);
        this.ListaGeralArestas.add(a);
    }
    
    public int findIndiceVertice(String key){
        for (int i = 0; i < this.ListaGeralVertice.size(); i++){
            if (this.ListaGeralVertice.get(i).getNome().equals(key)){
                return i;
            }
        }
        return -1;
       
    }
    
    public Vertice findVertice(String key){
        int aux = findIndiceVertice(key);
        if (aux != -1){
        return this.ListaGeralVertice.get(aux);
        }
        else{
            return null;
        }
    }
    
    public Vertice removeVertice(String nome){
        Vertice v;
        int indice= this.findIndiceVertice(nome);
        if ( indice== -1){return null;}
        else{
           v = this.ListaGeralVertice.remove(indice);
           for(int i = 0; i < this.ListaGeralArestas.size(); i++){
               if (this.ListaGeralArestas.get(i).getOrigem() == v || this.ListaGeralArestas.get(i).getDestino()== v){
                   this.ListaGeralArestas.remove(i);
               }
           }
           for (int j = 0; j< this.ListaGeralVertice.size(); j++){
               Vertice aux = this.ListaGeralVertice.get(j);
               for(int k = 0; k < aux.getListaArestas().size(); k++){
                   if(aux.getListaArestas().get(k).getDestino() == v || aux.getListaArestas().get(k).getOrigem() == v ){
                       aux.getListaArestas().remove(k);
                   }
               }
           }
        }
    return v;
    }
    
    public void print(){
        for (Vertice ListaGeralVertice1 : this.ListaGeralVertice) {
            System.out.println(ListaGeralVertice1.getNome());
        }
        System.out.println(this.ListaGeralArestas.size());
    }
    
    
    
    
    
    
    
}
