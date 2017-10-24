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

    
    LinkedList<String> predecir(String prefijo);
    
}
