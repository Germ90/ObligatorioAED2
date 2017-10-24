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
    * 
    *
    * @param palabra Palabra a buscar en el trie
    */
    int buscar(String palabra);

    void insertar(String unId,String palabra);

    LinkedList<String> predecir(String prefijo);
    
}
