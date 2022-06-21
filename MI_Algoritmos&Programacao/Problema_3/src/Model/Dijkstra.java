package Model;

import java.util.ArrayList;
import java.util.Collections;

public class Dijkstra {
	
	ArrayList<Vertice> menorCaminho;
	ArrayList<Vertice> naoVisitados;
	Vertice verticeCaminho;
	Vertice atual;
	Vertice vizinho;
	private Grafo grafo;
	
	public Dijkstra(Grafo grafo){
	this.grafo = grafo;
	this.menorCaminho = new ArrayList<Vertice>();	
	this.naoVisitados = new ArrayList<Vertice>();
	}
	
	
	
//-----------------------------------------------------------------------------------------------------------------------------------
	
	
	public ArrayList<ArrayList<Vertice>> getDijkstra(Vertice v){
		ArrayList<ArrayList<Vertice>> resultados = new ArrayList<ArrayList<Vertice>>();
		for (Vertice auxiliar : grafo.getListaGeralVertice()) {
			if(auxiliar != v) {
				resultados.add(encontrarMenorCaminhoDijkstra(v, auxiliar));
			}
		}
		return resultados;
	}
	
	public ArrayList<Vertice> encontrarMenorCaminhoDijkstra(Vertice v1, Vertice v2){
		restauraAtributos(v1);
		while (!this.naoVisitados.isEmpty()) {
			atual = this.menorCusto(naoVisitados);
			naoVisitados.remove(atual);

			for (Vertice vizinho : getAdjacentes(atual)) {
                               // System.out.println(atual.getNome());
                               // System.out.println(atual.getD());
                               // System.out.println(retornaPeso(atual, vizinho));
                               // System.out.println(vizinho.getNome());
                              //  System.out.println(vizinho.getD());
                               // System.out.println("---------");
				int totalCusto = atual.getD() + retornaPeso(atual, vizinho);
				if (totalCusto < vizinho.getD()){
					vizinho.setD(totalCusto);
					vizinho.getAnterior().add(atual);
					vizinho.setAnt(atual);
				}
			}

			if (atual == v2) {

				return resultado(atual);
			}
		}
		return naoVisitados;
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------
	
	/**
     * Dado um vértice u e um vértice b, retorna o peso da aresta que liga eles
     *
     * @param v Vértice
     * @return Lista de Vértice
     */
			
	private int retornaPeso(Vertice u, Vertice b){
        for (int i = 0; i < u.getListaArestas().size(); i++) {
            Aresta k = u.getListaArestas().get(i);
            if (k != null) {
                if(((k.getDestino()).getNome().equals(u.getNome()) && k.getOrigem().getNome().equals(b.getNome())) ||(k.getDestino().getNome().equals(b.getNome()) && k.getOrigem().getNome().equals(u.getNome())) )
                    return k.getPeso();
                    }
                }
        return 0;
    }


		/**
	     * Dado um vértice v, retorna uma lista de  vértices adjacentes a ele
	     *
	     * @param v Vértice
	     * @return Lista de Vértice
	     */
	private ArrayList<Vertice> getAdjacentes(Vertice v){
		ArrayList<Aresta> arestas = v.getListaArestas();
		ArrayList<Vertice> adjacentes = new ArrayList<>();
		for(int i = 0; i < arestas.size(); i++) {
			Vertice aux = arestas.get(i).getDestino();
			adjacentes.add(aux);
			
		}
		return adjacentes;
	}
	
		/**
	     * Dado uma lista de vértices, retorna o vértice que tem 
	     * a aresta com o menor peso
	     *
	     * @param listaDeVertices Lista de Vértices 
	     * @return Vértice cujo o peso da sua aresta é o menor presente na lista 
	     */
		
	private Vertice menorCusto(ArrayList<Vertice> listaDeVertices) {
		int custo = listaDeVertices.get(0).getD();
		int posicao = 0;
		for(Vertice aux : listaDeVertices) {
			if (aux.getD() < custo) {
				custo = aux.getD();
				posicao = listaDeVertices.indexOf(aux);
			}
		return listaDeVertices.get(posicao);
		}
		return listaDeVertices.get(posicao);
	}
	private void restauraAtributos(Vertice v1) {
		for (int i = 0; i < grafo.getListaGeralVertice().size(); i++) {
			// Vertice atual tem custo zero, e todos os outros "infinita"			
			if (grafo.getListaGeralVertice().get(i).getNome().equals(v1.getNome())) {
				grafo.getListaGeralVertice().get(i).setD(0);
			} 
			else {
				grafo.getListaGeralVertice().get(i).setD(Integer.MAX_VALUE);
			}
			// Insere o vertice na lista de vertices nao visitados
			this.naoVisitados.add(grafo.getListaGeralVertice().get(i));
		}
		
		
	}
	
	
	private ArrayList<Vertice> resultado(Vertice primeiro){
		ArrayList<Vertice> listaFinal = new ArrayList<Vertice>();
		listaFinal.add(primeiro);
		Vertice aux = primeiro;
		while(aux.getAnt() != null) {
			Vertice novo = aux.getAnt();
			listaFinal.add(novo);
			aux = novo;
		}
		Collections.reverse(listaFinal);
		
		return listaFinal;
		}
	}
