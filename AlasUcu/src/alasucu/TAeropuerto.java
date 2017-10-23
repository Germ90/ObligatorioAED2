/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alasucu;

/**
 *
 * @author German
 */
public class TAeropuerto {
    private Comparable id;
    private String descripcion;

    public TAeropuerto(Comparable unId,String unaDescripcion){
        id=unId;
        descripcion=unaDescripcion;
    }
    
    public Comparable getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
