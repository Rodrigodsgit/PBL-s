/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Dijkstra;
import Model.Grafo;
import Model.Vertice;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mestre
 */
public class ControladorTest {
    Controlador controlador = new Controlador();
    Vertice v = new Vertice("A",true, 200, 200);
    Vertice v2 = new Vertice("B",false,400, 200);
    public ControladorTest() {
    
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getGrafo method, of class Controlador.
     */
    @Test
    public void testeadd(){
        Vertice aux = controlador.addVertice(v);
        assertEquals(v,aux);
    }
    
    @Test
    public void testeadd2(){
        Vertice aux = controlador.addVertice(v2);
        assertEquals(v2,aux);
    }
    
    @Test
    public void remove(){
        controlador.addVertice(v);
        Vertice aux = controlador.removeVertice(v.getNome());
        assertEquals(v,aux);
        
    }
    
    @Test
    public void remove2(){
        controlador.addVertice(v2);
        Vertice aux = controlador.removeVertice(v2.getNome());
        assertEquals(v2,aux);
        
    }
    
    @Test
    public void remove3(){
        controlador.addVertice(v);
        controlador.addVertice(v2);
        Vertice aux = controlador.removeVertice(v2.getNome());
        assertEquals(v2,aux);
        
    }
    
    @Test
    public void remove4(){
        controlador.addVertice(v);
        controlador.addVertice(v2);
        Vertice aux = controlador.removeVertice(v.getNome());
        assertEquals(v,aux);
        
    }
    
    @Test
    public void find(){
        controlador.addVertice(v);
        assertEquals(v,controlador.findVertice(v.getNome()));
        
    }
    
    @Test
    public void find2(){
        controlador.addVertice(v2);
        assertEquals(v2,controlador.findVertice(v2.getNome()));
        
    }
    
    @Test
    public void find3(){
        controlador.addVertice(v);
        controlador.addVertice(v2);
        assertEquals(v2,controlador.findVertice(v2.getNome()));
        
    }
    
    @Test
    public void find4(){
        controlador.addVertice(v);
        controlador.addVertice(v2);
        assertEquals(v,controlador.findVertice(v.getNome()));
        
    }
    
    @Test
    public void deistanciaEuclidiana(){
        controlador.addVertice(v);
        controlador.addVertice(v2);
        assertEquals(200.00, controlador.distanciaEuclidiana(v, v2),0);
        
    }
    
    @Test
    public void deistanciaEuclidiana2(){
        controlador.addVertice(v);
        controlador.addVertice(v2);
        assertEquals(200.00, controlador.distanciaEuclidiana(v2, v),0);
        
    }
    
    @Test
    public void exportar(){
        controlador.addVertice(v);
        controlador.addVertice(v2);
        controlador.addAresta(v, v2, 5);
        assertEquals(true,controlador.exportarArquivo("teste"));
        
        
    }
    
    @Test
    public void importar() throws IOException{
        controlador.addVertice(v);
        controlador.addVertice(v2);
        controlador.addAresta(v, v2, 5);
        controlador.exportarArquivo("teste");
        assertEquals(true,controlador.importarArquivo("teste.csv"));
        
        
    }
    
    @Test
    public void importar2() throws IOException{
        controlador.addVertice(v);
        controlador.addVertice(v2);
        controlador.addAresta(v, v2, 5);
        controlador.exportarArquivo("teste");
        controlador = new Controlador();
        controlador.importarArquivo("teste.csv");
        Vertice v3 = controlador.findVertice(v.getNome());
        assertEquals(v.getNome(),v3.getNome());
        
        
    }
    
}
