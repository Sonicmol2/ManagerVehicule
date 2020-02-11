/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managervehiculePrincipal.vistas;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import managervehiculePrincipal.ManagerVehicule;
import modeloPropio.Vehiculo;

/**
 * FXML Controller class
 *
 * @author samuel
 */
public class VistaPrincipalController implements Initializable {
    
    private static final String BD_VEHICULOS = "src/bd/BaseDatosVehiculos.oo";
    managervehiculePrincipal.vistas.VistaAltaVehiculoController vistaAlta;
    
    private Stage primaryStage;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void annadirVehiculo(){
         try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ManagerVehicule.class.getResource("vistas/VistaAltaVehiculo.fxml"));
            BorderPane page = (BorderPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Alta de vehículo");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
        
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            VistaAltaVehiculoController controllerAlta = loader.getController();
            controllerAlta.setVentana(dialogStage);
            
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void consultarVehiculos(){
         try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ManagerVehicule.class.getResource("vistas/VistaConsulta.fxml"));
            BorderPane page = (BorderPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Consulta de vehículos");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
        
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            VistaConsultaController controllerConsulta = loader.getController();
            controllerConsulta.setVentana(dialogStage);
          
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void salirAplicacion(){
        System.exit(0);
    }

    public void setMainApp(Stage primaryStageInicial) {
        this.primaryStage = primaryStageInicial;
    }

    
   
}
