/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managervehiculePrincipal.vistas;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import com.sun.deploy.uitoolkit.impl.fx.HostServicesFactory;
import com.sun.javafx.application.HostServicesDelegate;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import modeloPropio.Vehiculo;

/**
 * FXML Controller class
 *
 * @author samuel
 */
public class VistaConsultaController extends Application implements Initializable {

    private Stage primaryStage;

    private static final String BD_VEHICULOS = "src/bd/BaseDatosVehiculos.oo";
    private static final String URL_ITV = "https://www.itvcita.com/Welcome.do";

    private ObservableList<Vehiculo> vehiculosObser = FXCollections.observableArrayList();

    @FXML
    TableView<Vehiculo> tableDatos = new TableView();
    @FXML
    TableColumn<Vehiculo, String> columnaMarca = new TableColumn<>("Marca");
    @FXML
    TableColumn<Vehiculo, String> columnaModelo = new TableColumn<>("Modelo");
    @FXML
    TableColumn<Vehiculo, String> columnaMatricula = new TableColumn<>("Matrícula");
    @FXML
    TableColumn<Vehiculo, String> columnaTipoRevision = new TableColumn<>("Tipo Revisión");
    @FXML
    TableColumn<Vehiculo, String> columaFechaRevision = new TableColumn<>("Fecha Revisión ITV");
    @FXML
    TableColumn<Vehiculo, String> columnaFechaSeguro = new TableColumn<>("Fecha Seguro");
    @FXML
    TableColumn<Vehiculo, String> columnaPrecioSeguro = new TableColumn<>("Precio Seguro");

    @FXML
    private Button botonITV;


    public VistaConsultaController() {
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //tableDatos.getColumns().addAll(columnaMarca, columnaModelo, columnaMatricula, columnaTipoRevision, columaFechaRevision, columnaFechaSeguro, columnaPrecioSeguro);
        columnaMarca.setCellValueFactory(vehiculo -> vehiculo.getValue().getMarca());
        columnaModelo.setCellValueFactory(vehiculo -> vehiculo.getValue().getModelo());
        columnaMatricula.setCellValueFactory(vehiculo -> vehiculo.getValue().getMatricula());
        columnaTipoRevision.setCellValueFactory(vehiculo -> vehiculo.getValue().getTipoRevision());
        columaFechaRevision.setCellValueFactory(vehiculo -> vehiculo.getValue().getFechaUltimaRevision());
        columnaFechaSeguro.setCellValueFactory(vehiculo -> vehiculo.getValue().getFechaUltimoSeguro());
        columnaPrecioSeguro.setCellValueFactory(vehiculo -> vehiculo.getValue().getPrecioSeguro());

        consultarBaseDeDatos();

        tableDatos.setItems(vehiculosObser);
    }

    void setVentana(Stage dialogStage) {
        this.primaryStage = dialogStage;

    }

    public void consultarBaseDeDatos() {

        ObjectContainer db;
        EmbeddedConfiguration configuracion = Db4oEmbedded.newConfiguration();

        db = abrirBaseDeDatos(configuracion);

        List<Vehiculo> listaVehiculos = db.queryByExample(new Vehiculo());

        for (Vehiculo vehiculo : listaVehiculos) {
            this.vehiculosObser.add(vehiculo);
        }

        db.close();
    }

    private static ObjectContainer abrirBaseDeDatos(EmbeddedConfiguration configuracion) {

        EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
        ObjectContainer db = Db4oEmbedded.openFile(config, BD_VEHICULOS);

        return db;

    }

    @FXML
    public void abrirNavegador() {

        HostServicesDelegate hostServices = HostServicesFactory.getInstance(this);
        hostServices.showDocument(URL_ITV);

    }

    @FXML
    public void salirAltaVehiculo() {
        primaryStage.close();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
