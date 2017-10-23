package alasucu.GrafoDirigido;


import alasucu.TOpcionVuelo;
import alasucu.TTodosLosVuelos;
import java.util.LinkedList;


/**
 * Clase que representa un vertice de un grafo, el mismo conta con una etiqueta, que en este caso sera el id del aeropuerto.
 * @author German
 */
public interface IVertice {

    /**
     * DAdo un vertice destino, veo si existe una arista entre el verice actual, y el destino.
     * @param verticeDestino Vertice destino
     * @return En caso de existir adyacencia, devuelve la misma, en caso contrario null.
     */
    TAdyacencia buscarAdyacencia(TVertice verticeDestino);

    /**
     * Dado el id de un vertice, veo si existe una arista entre el verice actual, y el destino.
     * @param etiquetaDestino Etiqueta del vertice destino
     * @return En caso de existir adyacencia, devuelve la misma, en caso contrario null.
     */
    TAdyacencia buscarAdyacencia(Comparable etiquetaDestino);

    /**
     * Dado el id de un vertice, veo si existe una arista entre el verice actual, y el destino, si existe se elimina.
     * @param nomVerticeDestino Etiqueta del vertice destino.
     * @return En caso de existir adyacencia,se elimina la misma. En caso contrario no hace nada
     */
    boolean eliminarAdyacencia(Comparable nomVerticeDestino);

    /**
     * Obtener coleccion de adyacentes de un vertice.
     * @return Devuelve una coleccion con los adyacentes del grafo.
     */
    LinkedList<TAdyacencia> getAdyacentes();

    /**
     * Obtener datos
     * @return Devuelve los datos guardados en el vertice
     */
    Object getDatos();

    /**
     * Obtener Etiqueta
     * @return Devuelve la etiqueta del grafo.
     */
    Comparable getEtiqueta();

    /**
     * Ver si el grafo fue visitado.
     * @return True en caso de ser visitado, false en caso contrario
     */
    boolean getVisitado();

    /**
     * Insertar una nueva adyacencia
     * @param costo Costo de la arista
     * @param verticeDestino Destino
     * @return True en caso de insertar correctamente, false en caso contrario
     */
    boolean insertarAdyacencia(Double costo, TVertice verticeDestino);

    /**
     * Obtener primer adyacente al vertice
     * @return Devuelve el primer elemento de la lista de adyacentes
     */
    public TVertice primerAdyacente();

    /**
     * Setear el valor del atributo visitado
     * @param valor Valor a setear
     */
    void setVisitado(boolean valor);

    /**
     * Dado un vertice destino, obtiene el costo de la adyacencia si es que existe
     * @param verticeDestino Vertice destino de la adyacecia
     * @return El costo de la adyacencia entre this y verticeDestino
     */
    public Double obtenerCostoAdyacencia(TVertice verticeDestino);
    
    /**
     * Obtener todos los caminos de latdo menores o igual a cantEscalas entre this y verticeDestino
     * @param etVertDestino Vertice final del camino solicitado
     * @param caminoPrevio Camino parcial. Recibe una lista vacia, que se va completando con el camino previo
     * @param todosLosCaminos Variable donde se van almacenando los caminos que fueron completados
     * @param largoMaxCamino LArgo maximo posible de los caminos
     * @return 
     */
    public TTodosLosVuelos todosLosCaminos(Comparable etVertDestino,TOpcionVuelo caminoPrevio,TTodosLosVuelos todosLosCaminos, int largoMaxCamino);
}
