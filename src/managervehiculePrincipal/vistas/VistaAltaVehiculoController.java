/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managervehiculePrincipal.vistas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import managervehiculePrincipal.ManagerVehicule;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;


import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import modeloPropio.Vehiculo;

/**
 * FXML Controller class
 *
 * @author samuel
 */
public class VistaAltaVehiculoController implements Initializable {
    
    private static final String BD_VEHICULOS = "src/bd/BaseDatosVehiculos.oo";
    private Stage primaryStage;
    
    @FXML
    private Button botonAceptar;
    
    @FXML
    private Button botonSalir;
    
    @FXML
    private TextField textMarca;
    
    @FXML
    private TextField textModelo;
    
    @FXML
    private TextField textMatricula;
    
    @FXML
    private ComboBox<String> comboTipoRevision;
    
    @FXML
    private TextField textFechaRevision;
    
    @FXML
    private TextField textFechaSeguro;
    
    @FXML
    private TextField textPrecioSeguro;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        //Cargamos el comboBox con sus valores
        comboTipoRevision.getItems().addAll("6 meses", "1 año", "2 años", "4 años");
        comboTipoRevision.getSelectionModel().select("6 meses");
        
    }  
    
    @FXML
    public void insertarVehiculo(){
        ObjectContainer db;
        EmbeddedConfiguration configuracion = Db4oEmbedded.newConfiguration();
        Vehiculo vehiculo;
        
        db = abrirBaseDeDatos(configuracion);
        
        vehiculo = obtenerDatos();
        
        insertarVehiculo(db, vehiculo);
        
        db.close();
    }
    
    @FXML
    public void salirAltaVehiculo(){
        primaryStage.close();
    }
    
    private static ObjectContainer abrirBaseDeDatos(EmbeddedConfiguration configuracion) {
       
        EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
        ObjectContainer db = Db4oEmbedded.openFile(config, BD_VEHICULOS);

       return db;
    
    }

    private Vehiculo obtenerDatos() {
       
        String marca, modelo, matricula, tipoRevisionITV, fechaRevision, fechaseguro;
        double precioSeguro;
        Vehiculo vehiculo = null;
        
        marca = textMarca.getText();
        modelo = textModelo.getText();
        matricula = textMatricula.getText();
        tipoRevisionITV = comboTipoRevision.getValue();
        fechaRevision = textFechaRevision.getText();
        fechaseguro = textFechaSeguro.getText();
        precioSeguro = Double.parseDouble(textPrecioSeguro.getText());
        
        vehiculo = new Vehiculo(marca, modelo, matricula, tipoRevisionITV, fechaRevision, fechaseguro, precioSeguro);
        
        return vehiculo;
        
    }

    private void insertarVehiculo(ObjectContainer db, Vehiculo vehiculo) {
        
        Vehiculo vehiculoPatron;
        String matriculaObtenida;
       
        matriculaObtenida = String.valueOf(vehiculo.getMatricula());
        
        vehiculoPatron = new Vehiculo(matriculaObtenida);
       
        ObjectSet<Vehiculo> resul= db.queryByExample(vehiculoPatron);
        
        if(resul.size() == 0){
            Alert alertaInformacion = new Alert(AlertType.INFORMATION);
            alertaInformacion.setTitle("Información de registro");
            alertaInformacion.setHeaderText("Vehículo registrado correctamente");
            alertaInformacion.setContentText(null);
            
            db.store(vehiculo);
            
            alertaInformacion.showAndWait();
        }else{
            Alert alertaError = new Alert(AlertType.WARNING);
            alertaError.setTitle("Información de registro");
            alertaError.setHeaderText("Error. Ya existe un vehículo con esa matrícula");
            alertaError.setContentText(null);
            
            alertaError.showAndWait();
        }
        
        
    }

    void setVentana(Stage dialogStage) {
       this.primaryStage = dialogStage;
    }
    
}
