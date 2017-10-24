package alasucu;


import alasucu.GrafoDirigido.TAdyacencia;
import alasucu.GrafoDirigido.TVertice;
import java.util.LinkedList;

/**
 *
 * @author German
 */
public class TOpcionVuelo {
    public TVertice origen;
    public LinkedList<Comparable> otrosVertices;
    public Comparable aerolinea;
    
    private double costoTotal;
    
    /**
    * Metodo que imprime por consola las etiquetas del camino.
    *
    */
    public void imprimirEtiquetas(){
        System.out.println(origen.getEtiqueta());
        otrosVertices.forEach((c) -> {
            System.out.println(c);
        });
    };

    public Comparable getAerolinea() {
        return aerolinea;
    }
    
    public String imprimirEtiquetasString(){
        StringBuilder str = new StringBuilder(origen.getEtiqueta().toString());
        otrosVertices.forEach((c) -> {
            str.append("-");
            str.append(c);
        });
        return str.toString();
    };
    
    public TOpcionVuelo(TVertice v,Comparable aerolinea){
        this.origen=v;
        this.otrosVertices=new LinkedList<>();
        this.aerolinea=aerolinea;
        this.costoTotal=0.0;
    }
    
    public TOpcionVuelo(TVertice v){
        this.origen=v;
        this.otrosVertices=new LinkedList<>();
        
        this.costoTotal=0.0;
    }
    
    public boolean agregarAdyacencia(TAdyacencia adyacenciaActual){
        if(adyacenciaActual.getDestino()!=null){
            costoTotal = costoTotal + ((Number) adyacenciaActual.getCosto()).doubleValue();
            return otrosVertices.add(adyacenciaActual.getDestino().getEtiqueta());
        }
        return false;
    }
    
    public boolean eliminarAdyacencia(TAdyacencia adyacenciaActual){
        if(otrosVertices.contains(adyacenciaActual.getDestino().getEtiqueta())){
            costoTotal = costoTotal - ((Number) adyacenciaActual.getCosto()).doubleValue();
            return otrosVertices.remove(adyacenciaActual.getDestino().getEtiqueta());
        }
        return false;
    }
    
    public TOpcionVuelo copiar(){
        TVertice origenCopia = new TVertice(this.getOrigen().getEtiqueta());
        TOpcionVuelo copia = new TOpcionVuelo(origenCopia,this.aerolinea);
        origenCopia.getAdyacentes().addAll(this.getOrigen().getAdyacentes());
        copia.getOtrosVertices().addAll(this.getOtrosVertices());
        copia.setCosto(this.costoTotal); //En la hoja faltaba esta linea, de lo contrario no calcula bien los costos
        return copia;
    }
    
    public TVertice getOrigen(){
        return this.origen;
    }
    
    public LinkedList<Comparable> getOtrosVertices(){
        return otrosVertices;
    }
    
    public double getCosto(){
        return costoTotal;
    }
    
    private void setCosto(double unCosto){
        this.costoTotal  = unCosto;
    }
}
