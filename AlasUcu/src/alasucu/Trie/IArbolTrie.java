package alasucu.Trie;


import java.util.LinkedList;

/**
 *
 * @author ernesto
 */
public interface IArbolTrie {

    /**
    * Imprime las palabras del trie
    *
    */
    void imprimir();
    

    /**
    * Insertar una nueva palabra en el trie
    *
    * @param unId     Id de la palabra
    * @param palabra  Palabra a insertar en el trie
    */
    void insertar(String unId,String palabra);

    /**
    * Listado de palabras que comienzan con el parametro recibido.
    *
    * @param prefijo prefijo a buscar
    * @return Lsita con las palabras que comienzan con prefijo
    */
    LinkedList<String> predecir(String prefijo);
    
    /**
    * Identificador de la palabra
    *
    * @param prefijo prefijo a buscar
    * @return Etiqueta de la palabra
    */
    public Comparable buscarEtiqueta(String prefijo);
    
    /**
    * Listado de etiquetas de las palabras del trie.
    *
    * @return Lsita con las etiquetas de las palabras del trie
    */
    public LinkedList<Comparable> getEtiquetas();
}
