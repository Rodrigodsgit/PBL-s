/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Controlador;
import Model.Aresta;
import Model.Dijkstra;
import Model.Grafo;
import Model.Vertice;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import View.Alerts;

/**
 *
 * 
 */
public class FXMLDocumentController implements Initializable {
    
    private Controlador controlador = new Controlador();
    private  ArrayList<Line> listaLinhaRed = new ArrayList();
    
    @FXML
    private AnchorPane mainPane;
    
    @FXML
    private TitledPane titledPaneCriar;
    
    @FXML
    private TitledPane titledPaneCriarAresta;
    
    @FXML
    private TitledPane titledPaneRemover;
   
    @FXML
    private TextField txtNome;
    
    @FXML
    private TextField txtNomeRemover;
    
    @FXML
    private TextField txtNomeVerticeOrigem;
    
    @FXML
    private TextField txtNomeVerticeDestino;
    
    @FXML
    private TextField txtPeso;

    @FXML
    private TextField txtCoordenadaX;
    
    @FXML
    private TextField txtCoordenadaY;
    
    @FXML 
    private CheckBox cbRoteador;
    
    @FXML 
    private CheckBox cbTerminal;
    
    @FXML
    private TitledPane titledPaneDEuclidiana;

    @FXML
    private TextField txtVerticeDistanciaEuclidiana1;

    @FXML
    private TextField txtVerticeDistanciaEuclidiana2;  
    
    @FXML
    private TitledPane titledPaneExportArquivo;

    @FXML
    private TextField txtNomeArquivoExport;
    
    @FXML
    private TitledPane titledPaneCaminhoEntreDois;

    @FXML
    private TextField txtNomeVerticeOrigemDED;

    @FXML
    private TextField txtNomeVerticeDestinoDED;
    
    @FXML
    private TitledPane titledPaneCaminhoEntreTodos;
    
    @FXML
    private TextField txtNomeVerticeOrigemDET;
    
    
//------------------------------------------------------------------------------
    @FXML
    private void onMenuBarActionImportArquivo() throws IOException {
        mainPane.getChildren().removeAll(this.controlador.getListaNode());
        mainPane.getChildren().removeAll(this.controlador.getListaLine());
        mainPane.getChildren().removeAll(this.controlador.getListaPeso());
        this.listaLinhaRed = new ArrayList();

        
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("CSV File","*.csv"));
        File f = fc.showOpenDialog(null);
        if(f != null){
          this.controlador.importarArquivo(f.getAbsolutePath());
        
        for (Vertice listaGeralVertice : this.controlador.getGrafo().getListaGeralVertice()) {
            String nome = listaGeralVertice.getNome();
            float corX = listaGeralVertice.getX();
            float corY = listaGeralVertice.getY();
            boolean isTerminal = listaGeralVertice.isTerminal();

            Button bt =  new Button();
            VBox vb = new VBox();
            Label lb = new Label();

            lb.setText(nome);

            vb.setId(nome);
            vb.setLayoutX(corX);
            vb.setLayoutY(corY);

            if(isTerminal){
                Image image = new Image("/icons/comp1.jpg");
                BackgroundImage backgroundimage = new BackgroundImage(image,  
                                                     BackgroundRepeat.NO_REPEAT,  
                                                     BackgroundRepeat.NO_REPEAT,  
                                                     BackgroundPosition.DEFAULT,  
                                                        BackgroundSize.DEFAULT); 
                Background background = new Background(backgroundimage); 
                bt.setBackground(background);       
            }
            else{
                Image image = new Image("/icons/rot.png");
                BackgroundImage backgroundimage = new BackgroundImage(image,  
                                                     BackgroundRepeat.NO_REPEAT,  
                                                     BackgroundRepeat.NO_REPEAT,  
                                                     BackgroundPosition.DEFAULT,  
                                                        BackgroundSize.DEFAULT); 
                Background background = new Background(backgroundimage); 
                bt.setBackground(background);
            }

            bt.setMinHeight(50.0);
            bt.setMinWidth(50.0);
            vb.getChildren().addAll(lb,bt);

            mainPane.getChildren().add(vb);
            this.controlador.getListaNode().add(vb);
        }
        
        for (Aresta listaGeralAresta : this.controlador.getGrafo().getListaGeralArestas()) {
            Vertice origem = listaGeralAresta.getOrigem();
            Vertice destino = listaGeralAresta.getDestino();
            
            Line linha = new Line();
            linha.setEndX(destino.getX());
            linha.setEndY(destino.getY());
            linha.setStartX(origem.getX());
            linha.setStartY(origem.getY());
            linha.setId(origem.getNome() + destino.getNome());
                     
            int peso = listaGeralAresta.getPeso();
            
            Label lb = new Label();
            lb.setText(String.valueOf(peso));
            lb.setId(linha.getId());
            
            float pontoMedioX = (origem.getX() + destino.getX())/2 ;
            float pontoMedioY = (origem.getY() + destino.getY())/2;
            lb.setLayoutX(pontoMedioX);
            lb.setLayoutY(pontoMedioY - 15);
            mainPane.getChildren().add(lb);
            mainPane.getChildren().add(linha);
            this.controlador.getListaLine().add(linha);
            this.controlador.getListaPeso().add(lb);
 
        }
        Alerts.showAlert("Aviso", null, "O arquivo foi importado e seu grafo foi gerado com sucesso", Alert.AlertType.INFORMATION);

        
        }
            
    }
    
    @FXML
    private void onMenuBarActionExportArquivo(){
        titledPaneExportArquivo.setVisible(true);
        for (Line listaLinhaRed1 : listaLinhaRed) {
            mainPane.getChildren().remove(listaLinhaRed1);
            listaLinhaRed1.setStroke(Paint.valueOf("black"));
            mainPane.getChildren().add(listaLinhaRed1);
        }
        mainPane.getChildren().removeAll(this.controlador.getListaNode());
        mainPane.getChildren().removeAll(this.controlador.getListaLine());
        mainPane.getChildren().removeAll(this.controlador.getListaPeso());
        
    }
    
    @FXML
    private void OnMenuBarActionCriarVertice(){
        titledPaneCriar.setVisible(true);
        for (Line listaLinhaRed1 : listaLinhaRed) {
            mainPane.getChildren().remove(listaLinhaRed1);
            listaLinhaRed1.setStroke(Paint.valueOf("black"));
            mainPane.getChildren().add(listaLinhaRed1);
        }
        mainPane.getChildren().removeAll(this.controlador.getListaNode());
        mainPane.getChildren().removeAll(this.controlador.getListaLine());
        mainPane.getChildren().removeAll(this.controlador.getListaPeso());
        
    }
    
    @FXML
    private void OnMenuBarActionCriarAresta(){
        titledPaneCriarAresta.setVisible(true);
        for (Line listaLinhaRed1 : listaLinhaRed) {
            mainPane.getChildren().remove(listaLinhaRed1);
            listaLinhaRed1.setStroke(Paint.valueOf("black"));
            mainPane.getChildren().add(listaLinhaRed1);
        }
        mainPane.getChildren().removeAll(this.controlador.getListaNode());
        mainPane.getChildren().removeAll(this.controlador.getListaLine());
        mainPane.getChildren().removeAll(this.controlador.getListaPeso());        
        
    }
    
    @FXML
    private void OnMenuBarActionRemoverVertice(){
        titledPaneRemover.setVisible(true);
        for (Line listaLinhaRed1 : listaLinhaRed) {
            mainPane.getChildren().remove(listaLinhaRed1);
            listaLinhaRed1.setStroke(Paint.valueOf("black"));
            mainPane.getChildren().add(listaLinhaRed1);
        }
        mainPane.getChildren().removeAll(this.controlador.getListaNode());
        mainPane.getChildren().removeAll(this.controlador.getListaLine());
        mainPane.getChildren().removeAll(this.controlador.getListaPeso());
        
    }
     
    @FXML
    private void OnMenuBarActionDistanciaEuclidiana(){
        titledPaneDEuclidiana.setVisible(true);
        for (Line listaLinhaRed1 : listaLinhaRed) {
            mainPane.getChildren().remove(listaLinhaRed1);
            listaLinhaRed1.setStroke(Paint.valueOf("black"));
            mainPane.getChildren().add(listaLinhaRed1);
        }
        mainPane.getChildren().removeAll(this.controlador.getListaNode());
        mainPane.getChildren().removeAll(this.controlador.getListaLine());
        mainPane.getChildren().removeAll(this.controlador.getListaPeso());
        
    }
    
    @FXML
    private void OnMenuBarActionMenorCaminhoEntreDois(){
        titledPaneCaminhoEntreDois.setVisible(true);
        for (Line listaLinhaRed1 : listaLinhaRed) {
            mainPane.getChildren().remove(listaLinhaRed1);
            listaLinhaRed1.setStroke(Paint.valueOf("black"));
            mainPane.getChildren().add(listaLinhaRed1);
        }
        mainPane.getChildren().removeAll(this.controlador.getListaNode());
        mainPane.getChildren().removeAll(this.controlador.getListaLine());
        mainPane.getChildren().removeAll(this.controlador.getListaPeso());
    
    
    }
    
    @FXML
    private void OnMenuBarActionMenorCaminhoEntreTodos(){
        titledPaneCaminhoEntreTodos.setVisible(true);
        for (Line listaLinhaRed1 : listaLinhaRed) {
            mainPane.getChildren().remove(listaLinhaRed1);
            listaLinhaRed1.setStroke(Paint.valueOf("black"));
            mainPane.getChildren().add(listaLinhaRed1);
        }
        mainPane.getChildren().removeAll(this.controlador.getListaNode());
        mainPane.getChildren().removeAll(this.controlador.getListaLine());
        mainPane.getChildren().removeAll(this.controlador.getListaPeso());
    }
    

//------------------------------------------------------------------------------
    
    @FXML
    private void OnBtActionConfirmaRemoverVertice(){
        titledPaneRemover.setVisible(false);
        mainPane.getChildren().addAll(this.controlador.getListaNode());
        mainPane.getChildren().addAll(this.controlador.getListaLine());
        mainPane.getChildren().addAll(this.controlador.getListaPeso());
        
        Vertice v = controlador.findVertice(txtNomeRemover.getText());
        if (v == null){
            Alerts.showAlert("Aviso", null, "O vertice escolhido não existe", Alert.AlertType.WARNING);
        }
        else{
            controlador.removeVertice(v.getNome());
            VBox vb = controlador.findNode(txtNomeRemover.getText());
            
            controlador.getListaNode().remove(vb);
            mainPane.getChildren().remove(vb);
            ArrayList aux = new ArrayList<>();
            ArrayList auxPeso = new ArrayList<>();
            
            for (int i = 0; i < controlador.getListaLine().size(); i++){
               Line linha = (Line)controlador.getListaLine().get(i);
 
               if(v.getX() == linha.getEndX() && v.getY() == linha.getEndY()){
                   aux.add(linha);
                   mainPane.getChildren().remove(linha);
               }
               if(v.getX() == linha.getStartX() && v.getY()== linha.getStartY()){
                   aux.add(linha);
                   mainPane.getChildren().remove(linha);
               }
            }
            for(int i = 0; i < aux.size() ; i++){
                controlador.getListaLine().remove(aux.get(i));
                
            }
            
            for (int i = 0; i< controlador.getListaPeso().size();i++){
                Label labelPeso = (Label) controlador.getListaPeso().get(i);
                for(int j =  0; j < aux.size(); j++ ){
                     Line linhaPeso = (Line) aux.get(j); 

                    if(linhaPeso.getId().equals(labelPeso.getId()) ){
                        mainPane.getChildren().remove(labelPeso);
                        auxPeso.add(labelPeso);
                    }
                }
            }
            System.out.println(auxPeso.size());
            for ( int i = 0; i < auxPeso.size(); i++){
                Label lb = (Label) auxPeso.get(i);
                controlador.getListaPeso().remove(lb);
        }
            Alerts.showAlert("Aviso", null, "O vertice " + v.getNome() + " foi removido", Alert.AlertType.CONFIRMATION);
        }
        txtNomeRemover.setText(null);
    }

    @FXML
    private void OnBtActionConfirmaCriarVertice() throws FileNotFoundException{
        titledPaneCriar.setVisible(false);
        mainPane.getChildren().addAll(this.controlador.getListaNode());
        mainPane.getChildren().addAll(this.controlador.getListaLine());
        mainPane.getChildren().addAll(this.controlador.getListaPeso());
        
        String nome = txtNome.getText();
        float corX = Float.parseFloat(txtCoordenadaX.getText());
        float corY = Float.parseFloat(txtCoordenadaY.getText());
        boolean isTerminal = cbTerminal.isSelected();

        Vertice v = controlador.addVertice(nome, isTerminal, corX, corY);
        Button bt =  new Button();
        VBox vb = new VBox();
        Label lb = new Label();
        
        lb.setText(nome);
        
        vb.setId(nome);
        vb.setLayoutX(corX);
        vb.setLayoutY(corY);
        
        if(isTerminal){
            Image image = new Image("/icons/comp1.jpg");
            BackgroundImage backgroundimage = new BackgroundImage(image,  
                                                 BackgroundRepeat.NO_REPEAT,  
                                                 BackgroundRepeat.NO_REPEAT,  
                                                 BackgroundPosition.DEFAULT,  
                                                    BackgroundSize.DEFAULT); 
            Background background = new Background(backgroundimage); 
            bt.setBackground(background);       
        }
        else{
            Image image = new Image("/icons/rot.png");
            BackgroundImage backgroundimage = new BackgroundImage(image,  
                                                 BackgroundRepeat.NO_REPEAT,  
                                                 BackgroundRepeat.NO_REPEAT,  
                                                 BackgroundPosition.DEFAULT,  
                                                    BackgroundSize.DEFAULT); 
            Background background = new Background(backgroundimage); 
            bt.setBackground(background);
        }
        
        bt.setMinHeight(50.0);
        bt.setMinWidth(50.0);
        vb.getChildren().addAll(lb,bt);
        
        mainPane.getChildren().add(vb);
        controlador.getListaNode().add(vb);
        
        txtNome.setText(null);
        txtCoordenadaX.setText(null);
        txtCoordenadaY.setText(null);
        cbTerminal.setSelected(false);
        cbRoteador.setSelected(false);
        
        
        
        
    }
    
    @FXML
    private void OnBtActionConfirmaCriarAresta(){
        titledPaneCriarAresta.setVisible(false);
        mainPane.getChildren().addAll(this.controlador.getListaNode());
        mainPane.getChildren().addAll(this.controlador.getListaLine());
        mainPane.getChildren().addAll(this.controlador.getListaPeso());
        
        Vertice origem = controlador.findVertice(txtNomeVerticeOrigem.getText());
        Vertice destino = controlador.findVertice(txtNomeVerticeDestino.getText());
        
        
        if(origem != null && destino != null){
            Line linha = new Line();
            linha.setEndX(destino.getX());
            linha.setEndY(destino.getY());
            linha.setStartX(origem.getX());
            linha.setStartY(origem.getY());
            linha.setId(txtNomeVerticeOrigem.getText()+txtNomeVerticeDestino.getText());
                     
            int peso = Integer.parseInt(txtPeso.getText());
            
            Label lb = new Label();
            lb.setText(String.valueOf(peso));
            lb.setId(linha.getId());
            
            float pontoMedioX = (origem.getX() + destino.getX())/2 ;
            float pontoMedioY = (origem.getY() + destino.getY())/2;
            lb.setLayoutX(pontoMedioX);
            lb.setLayoutY(pontoMedioY - 15);
            
            Alerts.showAlert("Aviso", null, "A aresta foi criada", Alert.AlertType.CONFIRMATION);
            
            mainPane.getChildren().add(lb);
            mainPane.getChildren().add(linha);
            controlador.getListaLine().add(linha);
            controlador.addAresta(origem, destino, peso);
            controlador.getListaPeso().add(lb);
            txtNomeVerticeOrigem.setText(null);
            txtNomeVerticeDestino.setText(null);
            
        }
        else{
            Alerts.showAlert("Aviso", null, "A aresta não pode ser criada, pois o vertice não existe", Alert.AlertType.ERROR);
        }
        txtPeso.setText(null);
        
    } 
    
    @FXML 
    private void OnBtActionConfirmaDistanciaEuclidiana(){
        titledPaneDEuclidiana.setVisible(false);
        mainPane.getChildren().addAll(this.controlador.getListaNode());
        mainPane.getChildren().addAll(this.controlador.getListaLine());
        mainPane.getChildren().addAll(this.controlador.getListaPeso());
        
        Vertice origem = controlador.findVertice(txtVerticeDistanciaEuclidiana1.getText());
        Vertice destino = controlador.findVertice(txtVerticeDistanciaEuclidiana2.getText());

        if ( origem == null || destino == null){
            Alerts.showAlert("Aviso",null, "O vertice digitado não existe", Alert.AlertType.ERROR);
        }
        else{
            float resultado = controlador.distanciaEuclidiana(origem, destino);
            Alerts.showAlert("Calculo", null, "Distância Euclidiana entre os  vértices é: " + String.format("%.2f", resultado) + " unidades", Alert.AlertType.CONFIRMATION);
        }
        txtVerticeDistanciaEuclidiana1.setText(null);
         txtVerticeDistanciaEuclidiana2.setText(null);
    }
    
    @FXML
    private void OnBtActionConfirmaExportArquivo(){
        titledPaneExportArquivo.setVisible(false);
        mainPane.getChildren().addAll(this.controlador.getListaNode());
        mainPane.getChildren().addAll(this.controlador.getListaLine());
        mainPane.getChildren().addAll(this.controlador.getListaPeso());
        String nome = txtNomeArquivoExport.getText();
        boolean isEscrito = controlador.exportarArquivo(nome);
        txtNomeArquivoExport.setText(null);
        if (isEscrito){
            Alerts.showAlert("Aviso", null, "O arquivo foi exportado com sucesso", Alert.AlertType.CONFIRMATION);
        }
        else{ Alerts.showAlert("Aviso", null, "Não foi possível escrever o arquivo", Alert.AlertType.WARNING);}
        
    
    }
    
    @FXML
    private void OnBtActionConfirmaDistanciaEntreDois(){
        titledPaneCaminhoEntreDois.setVisible(false);
        mainPane.getChildren().addAll(this.controlador.getListaNode());
        mainPane.getChildren().addAll(this.controlador.getListaLine());
        mainPane.getChildren().addAll(this.controlador.getListaPeso());
        Vertice  origem = controlador.findVertice(txtNomeVerticeOrigemDED.getText());
        Vertice destino = controlador.findVertice(txtNomeVerticeDestinoDED.getText());
        if(origem != null && destino != null){
            if(origem.isTerminal()){
            ArrayList<Vertice>  caminhos = controlador.menorCaminhoEntreDois(origem, destino);
            String nome;

            for (int i =0; i < caminhos.size(); i++){
                int j = i+1;
                if(i == 0){
                    nome = ((origem.getNome())+(caminhos.get(i).getNome()));
                    Line linha = controlador.findAresta(nome);

                    if(linha != null){
                        mainPane.getChildren().remove(linha);
                        listaLinhaRed.add(linha);
                        linha.setStroke(Paint.valueOf("red"));
                        mainPane.getChildren().add(linha);

                    }
                }
                if(j < caminhos.size()){
                    nome = ((caminhos.get(i).getNome())+ (caminhos.get(j).getNome()));
                    Line linha = controlador.findAresta(nome);
                    listaLinhaRed.add(linha);
                    mainPane.getChildren().remove(linha);
                    linha.setStroke(Paint.valueOf("red"));
                    mainPane.getChildren().add(linha);


                }
            }

            Alerts.showAlert("Aviso", "O menor caminho entre os dois vértices estar destacado de vermelho", "Após selecionar uma próxima ação a cor da aresta voltarar ao normal", Alert.AlertType.INFORMATION);
            }
        
            else{
                Alerts.showAlert("Aviso", null, "O vértice digitado não é um terminal", Alert.AlertType.WARNING);
            }
        }
        else{
            Alerts.showAlert("Aviso", null, "A opção não pode ser mostrada, pois o vertice não existe", Alert.AlertType.ERROR);
        }
        txtNomeVerticeOrigemDED.setText(null);
        txtNomeVerticeDestinoDED.setText(null);
    }
        
    @FXML
    private void OnBtActionConfirmaDistanciaEntreTodos(){
        titledPaneCaminhoEntreTodos.setVisible(false);
        mainPane.getChildren().addAll(this.controlador.getListaNode());
        mainPane.getChildren().addAll(this.controlador.getListaLine());
        mainPane.getChildren().addAll(this.controlador.getListaPeso());
        String nome = txtNomeVerticeOrigemDET.getText();
        Vertice origem  = controlador.findVertice(nome);
        if(origem != null){
            if(origem.isTerminal()){
            ArrayList<ArrayList<Vertice>> todos = controlador.umParaTodos(origem);
            String r = "";
            for ( ArrayList<Vertice> todo : todos) {
                 for(Vertice u: todo){
                    r += u.getNome()+ " -> ";
            }
                r += "\n";
            }

            Alerts.showAlert("Aviso", r, "Caminhos menos custados de "+nome+ " para todos", Alert.AlertType.INFORMATION);
            }
            else{
                Alerts.showAlert("Aviso", null, "O vértice digitado não é um terminal", Alert.AlertType.WARNING);
            }
        }
        else{
            Alerts.showAlert("Aviso", null, "O vértice digitado não existe", Alert.AlertType.ERROR);
        }
        txtNomeVerticeOrigemDET.setText(null);
    }  
//------------------------------------------------------------------------------
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        titledPaneCriar.setVisible(false);
        titledPaneRemover.setVisible(false);
        titledPaneCriarAresta.setVisible(false);
        titledPaneDEuclidiana.setVisible(false);
        titledPaneExportArquivo.setVisible(false);
        titledPaneCaminhoEntreDois.setVisible(false);
        titledPaneCaminhoEntreDois.setVisible(false);

    }    
    
}

