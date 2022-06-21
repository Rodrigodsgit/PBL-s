/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aresta;
import Model.Dijkstra;
import Model.Grafo;
import Model.Vertice;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;

/**
 *
 * 
 */
public class Controlador {
    private   Grafo grafo;
    private  ArrayList<VBox> listaNode;
    private  ArrayList<Line> listaLine;
    private  Dijkstra menorCaminho;
    private ArrayList<Label> listaPeso;

    public Controlador() {
        this.grafo =  new Grafo();
        this.menorCaminho = new Dijkstra(this.grafo);
        this.listaNode = new ArrayList<>();
        this.listaLine = new ArrayList<>();
        this.listaPeso =  new ArrayList<>();
    }
    
    
//------------------------------------------------------------------------------
    public Grafo getGrafo() {
        return grafo;
    }

    public void setMenorCaminho(Dijkstra menorCaminho) {
        this.menorCaminho = menorCaminho;
    }
    
    public ArrayList getListaNode(){
        return listaNode;
    }
    
    public ArrayList getListaLine(){
        return listaLine;
    }
    
    public ArrayList getListaPeso(){
        return listaPeso;
    }
    
    public Dijkstra getMenorCaminho() {
		return menorCaminho;
	}
    
    public void setListaPeso(ArrayList<Label> listaPeso) {
		this.listaPeso = listaPeso;
	}


//------------------------------------------------------------------------------   
    //metodo para adicionar vertice no grafo
    public Vertice addVertice(String nome,boolean terminal, float x , float y){
       return grafo.addVertice(nome, terminal, x, y);
    }
    
    public Vertice addVertice(Vertice v){
        return grafo.addVertice(v);
    }
    
    public Vertice findVertice(String nome){
        return grafo.findVertice(nome);
    }
   
    public Vertice removeVertice(String nome){
        return grafo.removeVertice(nome);
    }
    
    //metodo para encontrar um vertice da interface 
    public VBox findNode(String nome){
        for(int i =0; i < listaNode.size(); i++){
            if(listaNode.get(i).getId().equals(nome))
                return listaNode.get(i);
        }
        return null;
    }
    
    //metodo para encontrar uma aresta da interface
    public Line findAresta(String nome){
        for (Line listaLine1 : this.listaLine) {
            if (listaLine1.getId().equals(nome))
                return listaLine1;
        }
        return null;
    }
    
    public void addAresta(Vertice origem, Vertice destino, int peso){
        grafo.addAresta(origem, destino, peso);
    }
    
    //metodo que calcula a a distancia euclidiana entre dois vertices
    public float distanciaEuclidiana(Vertice origem, Vertice destino){
        float x1 = origem.getX();
        float y1 = origem.getY();
        float x2 = destino.getX();
        float y2 = destino.getY();
        float resultado;
        resultado = (float) sqrt(pow((x2-x1),2) + pow ((y2-y1),2));
        return resultado;
    }
    
    //metodo que exportar um arquivo csv a partir de um grafo criado
    public boolean exportarArquivo(String nome){
         try
        {
            FileWriter writer = new FileWriter(nome+".csv");
            ArrayList aux = new ArrayList<>();
            for(int i = 0; i < grafo.getListaGeralArestas().size(); i++){
                Aresta aresta = (Aresta) grafo.getListaGeralArestas().get(i);
                Vertice origem = aresta.getOrigem();
                Vertice destino = aresta.getDestino();
                
                writer.append(origem.getNome());
                writer.append(';');
                writer.append(String.valueOf(origem.isTerminal()));
                writer.append(';');
                writer.append(String.valueOf(origem.getX()));
                writer.append(';');
                writer.append(String.valueOf(origem.getY()));
                writer.append(';');
                writer.append(destino.getNome());
                writer.append(';');
                writer.append(String.valueOf(destino.isTerminal()));
                writer.append(';');
                writer.append(String.valueOf(destino.getX()));
                writer.append(';');
                writer.append(String.valueOf(destino.getY()));
                writer.append(';');
                writer.append(String.valueOf(aresta.getPeso()));
                writer.append('\n');
            }
            writer.flush();
            writer.close();
            return true;
        }
        catch(IOException e){
             return false;
        } 
    }
    
    //metodo que importar um arquivo csv e cria um grafo a partir dele
    public boolean importarArquivo(String nome) throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader(nome));
        String linha = "";
        this.grafo = new Grafo();
        try{
            
            ArrayList allVertices = new ArrayList<>();
            while((linha = br.readLine()) != null ){
                String[] palavra = linha.split(";");
                String nomeOrigem = palavra[0];
                String nomeDestino = palavra[4];
                float origemX = Float.parseFloat(palavra[2]);
                float origemY = Float.parseFloat(palavra[3]);
                float destinoX = Float.parseFloat(palavra[6]);
                float destinoY = Float.parseFloat(palavra[7]);
                int peso = Integer.parseInt(palavra[8]);
                
                Vertice origem = new Vertice(nomeOrigem,this.isBoolean(palavra[1]),origemX, origemY);
                Vertice destino = new Vertice(nomeDestino,this.isBoolean(palavra[5]),destinoX, destinoY);
                
                if(this.grafo.findVertice(origem.getNome()) == null){
                   this.grafo.addVertice(origem);
                }
                if(this.grafo.findVertice(destino.getNome()) == null){
                   this.grafo.addVertice(destino);
                }
                if(this.grafo.findVertice(origem.getNome()) != null && this.grafo.findVertice(destino.getNome()) != null )
                   this.grafo.addAresta(origem, destino, peso);
                }
            
            br.close();
            this.menorCaminho = new Dijkstra(this.grafo);
            return true;
        }
        catch (IOException e) {
             br.close();
             return false;
        }
    }
    // metodo para ver se uma palabra no arquivo csv é true ou false e converte em boolean
    public boolean isBoolean(String palavra){
        return "true".equals(palavra);
    }
    
    public ArrayList<ArrayList<Vertice>> umParaTodos(Vertice vertice){
    	return menorCaminho.getDijkstra(vertice);
    }
    
    public ArrayList<Vertice> menorCaminhoEntreDois(Vertice vertice1, Vertice vertice2){
    	return menorCaminho.encontrarMenorCaminhoDijkstra(vertice1, vertice2);
   	}
}
