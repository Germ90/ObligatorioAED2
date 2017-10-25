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
    
    /**
    * Metodo que imprime por consola las etiquetas del camino.
    *
    */
    public void imprimirEtiquetas(){
        System.out.print(origen.getEtiqueta() + " - ");
        otrosVertices.forEach((c) -> {
            System.out.print(c + " - ");
        });
        System.out.println("Costo: " + getCosto());
    };

    /**
     * Obtiene Id de la aerolinea correspondiente
     * @return Id Aerolinea
     */
    public Comparable getAerolinea() {
        return aerolinea;
    }
    
    /**
     * Devuelve cadena con las etiquetas del vuelo
     * @return Cadena con ids de Aeropuertos
     */
    public String imprimirEtiquetasString(){
        StringBuilder str = new StringBuilder(origen.getEtiqueta().toString());
        otrosVertices.forEach((c) -> {
            str.append("-");
            str.append(c);
        });
        return str.toString();
    };
    

    /**
     * Agrega un nuevo aeropuerto al vuelo
     * @param adyacenciaActual Adyacencia que indica en su destino el aeropuerto agregado
     * @return True en caso de agregarse correctamente, false en caso contrario.
     */
    public boolean agregarAdyacencia(TAdyacencia adyacenciaActual){
        if(adyacenciaActual.getDestino()!=null){
            costoTotal = costoTotal + ((Number) adyacenciaActual.getCosto()).doubleValue();
            return otrosVertices.add(adyacenciaActual.getDestino().getEtiqueta());
        }
        return false;
    }
    
    /**
     * Quita de la Opcion de vuelo un aeropuerto
     * @param adyacenciaActual Adyacencia que indica en su destino el aeropuerto eliminado
     * @return  True en caso de quitarse correctamente, false en caso contrario.
     */
    public boolean eliminarAdyacencia(TAdyacencia adyacenciaActual){
        if(otrosVertices.contains(adyacenciaActual.getDestino().getEtiqueta())){
            costoTotal = costoTotal - ((Number) adyacenciaActual.getCosto()).doubleValue();
            return otrosVertices.remove(adyacenciaActual.getDestino().getEtiqueta());
        }
        return false;
    }
    
    /**
     * Crea una copia exacta de this
     * @return Objeto TOpcionVuelo con los mismos datos que this
     */
    public TOpcionVuelo copiar(){
        TVertice origenCopia = new TVertice(this.getOrigen().getEtiqueta());
        TOpcionVuelo copia = new TOpcionVuelo(origenCopia,this.aerolinea);
        origenCopia.getAdyacentes().addAll(this.getOrigen().getAdyacentes());
        copia.getOtrosVertices().addAll(this.getOtrosVertices());
        copia.setCosto(this.costoTotal); //En la hoja faltaba esta linea, de lo contrario no calcula bien los costos
        return copia;
    }
    
    /**
     * Obtiene el origen del vuelo
     * @return Vertice Origen del vuelo
     */
    public TVertice getOrigen(){
        return this.origen;
    }
    
    /**
     * Obtiene la ruta del vuelo.
     * @return Lista con los vertices del vuelo
     */
    public LinkedList<Comparable> getOtrosVertices(){
        return otrosVertices;
    }
    
    /**
     * Obtiene el costo total del vuelo.
     * @return Costo total del trayecto
     */
    public double getCosto(){
        return costoTotal;
    }
    
    /**
     * Setea el costo total
     * @param unCosto Costo a ser asigando.
     */
    private void setCosto(double unCosto){
        this.costoTotal  = unCosto;
    }
}
