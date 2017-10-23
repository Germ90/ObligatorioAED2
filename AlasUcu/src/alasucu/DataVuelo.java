/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alasucu;

/**
 * DataType para mostrat en pantalla información relevante sobre un vuelo
 * @author German
 */
public class DataVuelo {
    private Comparable aerolinea;
    private TOpcionVuelo vuelo;

    public DataVuelo(Comparable aerolinea, TOpcionVuelo vuelo) {
        this.aerolinea = aerolinea;
        this.vuelo = vuelo;
    }
    
    /**
     * Obtener Aerolinea
     * @return  Aerolinea a la cual pertenece el vuelo
     */
    public Comparable getAerolinea() {
        return aerolinea;
    }

    /**
     * Opcion de Vuelo
     * @return devuelve la opcion del vuelo correspondiente
     */
    public TOpcionVuelo getVuelo() {
        return vuelo;
    }
    
    
}
