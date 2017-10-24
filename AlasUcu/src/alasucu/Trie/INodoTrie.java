package alasucu.Trie;


import java.util.LinkedList;

/**
 *
 * @author German
 */
public interface INodoTrie {

    /**
    * Operacion para obtener los hijos del nodo.
    * 
    * @return coleccion de hijos del nodo
    */
    public Map<Comparable, TNodoTrie> getHijos();
    
    /**
    * Saber si el nodo es palabra
    *
    * @return true en caso de ser palabra, false en caso contrario.
    */
    public boolean isEsPalabra();
    
    /**
    * Setear booleano esPalabra
    *
    * @param valor a setear
    */
    public void setEsPalabra(boolean esPalabra);
    
    /**
    * Obtener etiqueta del nodo
    *
    * @return Etiqueta del nodo
    */
    public Comparable getEtiqueta();
        
    /**
    * Setear etiqueta del nodo
    *
    * @param Etiqueta a setear
    */
    public void setEtiqueta(Comparable etiqueta);
    
    /**
    * Imprime las palabras del trie
    *
    */
    void imprimir();

    /**
    * Listado de etiquetas de las palabras del trie.
    *
    * @return Lsita con las etiquetas de las palabras del trie
    */
    public LinkedList<Comparable> getEtiquetas();
        
    /**
    * Obtener nodo con la ultima letra del prefijo pasado como parametro
    *
    * @param parcial del prefijo
    * @return Nodo con la ultima letra de la cadena s
    */
    public TNodoTrie buscarNodoTrie(String s);
    
    /**
    * Insertar una nueva palabra en el trie
    *
    * @param unId     Id de la palabra
    * @param palabra  Palabra a insertar en el trie
    */
    void insertar(String unId,String unaPalabra);
    
    /**
    * Listado de palabras que comienzan con el parametro recibido.
    *
    * @param prefijo prefijo a buscar
    * @return Lsita con las palabras que comienzan con prefijo
    */
    public void predecir(String prefijo, LinkedList<String> palabras);
    
}
