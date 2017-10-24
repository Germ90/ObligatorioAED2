package alasucu.GrafoDirigido;


/**
 *
 * @author German
 */
public interface IArista {

    /**
    * Operacion para obtener el costo de la Arista.
    *
    * @return Costo de la arista
    */
    double getCosto();

    /**
    * Operacion para obtener la etiqueta destino de la Arista.
    *
    * @return Etiqueta vertice destino de la arista
    */
    Comparable getEtiquetaDestino();

    /**
    * Operacion para obtener la Origen de la Arista.
    *
    * @return Identificador del vertice Origen de la arista
    */
    Comparable getEtiquetaOrigen();

    /**
    * Operacion para setear costo de la Arista.
    *
    */
    void setCosto(double costo);

    /**
    * Operacion para setear Etiqueta destino de la Arista.
    *
    */
    void setEtiquetaDestino(Comparable etiquetaDestino);
    
    /**
    * Operacion para setear etiqueta origen de la Arista.
    *
    */
    void setEtiquetaOrigen(Comparable etiquetaOrigen);
    
}
