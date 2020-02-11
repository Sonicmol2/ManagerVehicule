/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloPropio;

import java.util.Objects;
import java.util.regex.Pattern;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author samuel
 */
public class Vehiculo {
    
    private StringProperty marca, modelo, matricula, tipoRevision, fechaUltimaRevision, fechaUltimoSeguro;
    private StringProperty precioSeguro;
    
    public Vehiculo(String marcaInicial, String modeloInicial, String matriculaInicial, String tipoRevisionInicial, String fechaUltimaRevisionInicial, String fechaUltimoSeguroInicial, double precioSeguroInicial){
        this.marca = new SimpleStringProperty(marcaInicial);
        this.modelo = new SimpleStringProperty(modeloInicial);
        this.matricula = new SimpleStringProperty(matriculaInicial);
        this.tipoRevision = new SimpleStringProperty(tipoRevisionInicial);
        this.fechaUltimaRevision = new SimpleStringProperty(fechaUltimaRevisionInicial);
        this.fechaUltimoSeguro = new SimpleStringProperty(fechaUltimoSeguroInicial);
        this.precioSeguro = new SimpleStringProperty(String.valueOf(precioSeguroInicial));
        
    }
    
    public Vehiculo(String matriculaInicial){
        this.matricula = new SimpleStringProperty(matriculaInicial);
        
    }
    
    public Vehiculo(){
        
    }

    public void setMarca(StringProperty marca) {
        this.marca = marca;
    }

    public void setModelo(StringProperty modelo) {
        this.modelo = modelo;
    }

    public void setMatricula(StringProperty matricula) {
        this.matricula = matricula;
    }

    public void setTipoRevision(StringProperty tipoRevision) {
        this.tipoRevision = tipoRevision;
    }

    public void setFechaUltimaRevision(StringProperty fechaUltimaRevision) {
        this.fechaUltimaRevision = fechaUltimaRevision;
    }

    public void setFechaUltimoSeguro(StringProperty fechaUltimoSeguro) {
        this.fechaUltimoSeguro = fechaUltimoSeguro;
    }

    public void setPrecioSeguro(StringProperty precioSeguro) {
        this.precioSeguro = precioSeguro;
    }

    public StringProperty getMarca() {
        return marca;
    }

    public StringProperty getModelo() {
        return modelo;
    }

    public StringProperty getMatricula() {
        return matricula;
    }

    public StringProperty getTipoRevision() {
        return tipoRevision;
    }

    public StringProperty getFechaUltimaRevision() {
        return fechaUltimaRevision;
    }

    public StringProperty getFechaUltimoSeguro() {
        return fechaUltimoSeguro;
    }

    public StringProperty getPrecioSeguro() {
        return precioSeguro;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.matricula);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehiculo other = (Vehiculo) obj;
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Vehiculo{" + "marca=" + marca + ", modelo=" + modelo + ", matricula=" + matricula + ", tipoRevision=" + tipoRevision + ", fechaUltimaRevision=" + fechaUltimaRevision + ", fechaUltimoSeguro=" + fechaUltimoSeguro + ", precioSeguro=" + precioSeguro + '}';
    }
    
    
    
}
