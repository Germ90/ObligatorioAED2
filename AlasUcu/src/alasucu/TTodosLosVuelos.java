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

    /**
     * Obtiene el ID de la Aerolinea a la cual pertenecen los vuelos.
     * @return ID Aerolinea
     */
    public Comparable getAerolinea() {
        return aerolinea;
    }
    
    /**
     * Obtiene todas las opciones de vuelo.
     * @return Lista con las opciones de vuelo
     */
    public LinkedList<TOpcionVuelo> getCaminos(){
        return caminos;
    }
    
    /**
     * Imprime en consola los vuelos, cada uno junto a su costo
     */
    public void imprimir(){
        caminos.forEach((c)->{
            System.out.println(c.imprimirEtiquetasString() + " COSTO: " + c.getCosto());
        });
    }
    
    /**
     * Agrega una nueva opcion de vuelo
     * @param vuelo vuelo a ser agregado
     */
    public void agregarVuelo(TOpcionVuelo vuelo){
        caminos.add(vuelo);
    }
    
    public TOpcionVuelo vueloOptimo(){
        TOpcionVuelo vueloOpt=null;
        double minCosto = Integer.MAX_VALUE;
        for(TOpcionVuelo v:this.getCaminos()){
            if(v.getCosto()<minCosto){
                vueloOpt=v;
                minCosto=v.getCosto();
            }
        }
        return vueloOpt;
    
    }
}
