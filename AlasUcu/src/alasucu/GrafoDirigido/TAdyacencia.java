package alasucu.GrafoDirigido;


public class TAdyacencia implements IAdyacencia {
   
    private Comparable etiqueta;
    private double costo;
    private TVertice destino;
    
    public TAdyacencia(double costo, TVertice destino) {
        this.etiqueta = destino.getEtiqueta();
        this.costo = costo;
        this.destino = destino;

    }
    
   /**
    * Operacion para obtener etiqueta de la Adyacencia.
    *
    * @return Etiqueta de la Adyacencia
    */
    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }
 
   /**
    * Operacion para obtener costo de la Adyacencia.
    *
    * @return Costo de la Adyacencia
    */
    @Override
    public double getCosto() {
        return costo;
    }

   /**
    * Operacion para obtener vertice destino.
    *
    * @return Vertice Destino
    */
    @Override
    public TVertice getDestino() {
        return destino;
    }


    
}
