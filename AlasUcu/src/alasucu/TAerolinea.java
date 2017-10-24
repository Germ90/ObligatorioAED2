/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alasucu;

import alasucu.GrafoDirigido.TAdyacencia;
import alasucu.GrafoDirigido.TGrafoDirigido;
import alasucu.GrafoDirigido.TVertice;
import java.util.Map;

/**
 *
 * @author German
 */
public class TAerolinea {
    private Comparable id;
    private String descripcion;
    private TGrafoDirigido gd;
    
    public TAerolinea(Comparable unId,String unaDescripcion,Map<Comparable, TAeropuerto> vertices){
        id=unId;
        descripcion=unaDescripcion;
        gd = new TGrafoDirigido(vertices);
    }
    
    /**
    * Obtener Id de Aerolinea
    * 
    * @return Id de la Aerolinea
    */
    public Comparable getId() {
        return id;
    }

    /**
    * Obtener Descripcion de Aerolinea
    * 
    * @return Descripcion de la Aerolinea
    */
    public String getDescripcion() {
        return descripcion;
    }
    
    /**
    * Obtener todos los vuelos entre origen-destino con un maximo de cantEscalas
    * 
    * @param origen Identificador del vertice origen del vuelo
    * @param destino Identificador del vertice destino del vuelo
    * @param cantEscalas Cantidad maxima de escalas del vuelo
    * @return Todos los vuelos entre origen-destino con un maximo de cantEscalas
    */
    public TTodosLosVuelos todosLosVuelos(Comparable origen, Comparable destino,int cantEscalas){
        return this.gd.todosLosCaminos(origen, destino,cantEscalas);
    }
    
    public void insertarVuelo(Comparable origen,Comparable destino,String costo){
        gd.insertarArista(origen, destino, costo);
    }

}
