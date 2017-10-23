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
    
    public Comparable getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    public TTodosLosVuelos todosLosVuelos(Comparable origen, Comparable destino,int cantEscalas){
        return this.gd.todosLosCaminos(origen, destino,cantEscalas);
    }
    
    public void insertarVuelo(Comparable origen,Comparable destino,String costo){
        gd.insertarArista(origen, destino, costo);
    }

}
