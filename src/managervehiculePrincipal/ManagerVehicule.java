/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managervehiculePrincipal;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import managervehiculePrincipal.vistas.VistaAltaVehiculoController;
import managervehiculePrincipal.vistas.VistaConsultaController;
import managervehiculePrincipal.vistas.VistaPrincipalController;
import modeloPropio.Vehiculo;

/**
 *
 * @author samuel
 */
public class ManagerVehicule extends Application {
    
    private Stage primaryStage;
    private BorderPane vistaPrincipal;
    
    @Override
    public void start(Stage primaryStage) {
       
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Manager Vehicule");
      
        showVistaInicio();

    
    }
    
    private void showVistaInicio() {
        
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ManagerVehicule.class.getResource("vistas/VistaPrincipal.fxml"));
            vistaPrincipal = (BorderPane) loader.load();
  
            Scene scene = new Scene(vistaPrincipal);
            primaryStage.setScene(scene);
            primaryStage.show();
            
            VistaPrincipalController controlador = loader.getController();
            controlador.setMainApp(primaryStage);
            //primaryStage.show();
            
        }catch(IOException e){
            e.printStackTrace();;
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
