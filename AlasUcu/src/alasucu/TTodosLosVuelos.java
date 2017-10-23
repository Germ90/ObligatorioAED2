package alasucu;


import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author German
 */
public class TTodosLosVuelos {
    private LinkedList<TOpcionVuelo> caminos;
    private Comparable aerolinea;
    
    public TTodosLosVuelos(Comparable aerolinea){
        caminos = new LinkedList<>();
        this.aerolinea=aerolinea;
    }
    public TTodosLosVuelos(){
        caminos = new LinkedList<>();
    }

    public Comparable getAerolinea() {
        return aerolinea;
    }
    
    public LinkedList<TOpcionVuelo> getCaminos(){
        return caminos;
    }
    
    public void imprimir(){
        caminos.forEach((c)->{
            System.out.println(c.imprimirEtiquetasString() + " COSTO: " + c.getCosto());
        });
    }
    
    public void agregarVuelo(TOpcionVuelo vuelo){
        caminos.add(vuelo);
    }
}
