/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 *
 * @author Rita Kassiane and Rodrigo Damasceno
 */
public class View extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        stage.setTitle("Grafo");
        stage.setResizable(false);
    
        Scene scene = new Scene(root, 1200, 650);
        
        stage.setScene(scene);
        stage.show();
        Alerts.showAlert("Aviso", "Seja Bem vindo ao sistema de redes modo desenvolvedor", "Para facilitar o uso do seu grafo estaremos retirando a restrição de operar somente com 30 vértices", Alert.AlertType.INFORMATION);

        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
