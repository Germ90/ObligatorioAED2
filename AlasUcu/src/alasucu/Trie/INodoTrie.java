package alasucu.Trie;


import java.util.LinkedList;

/**
 *
 * @author German
 */
public interface INodoTrie {

    public Map<Comparable, TNodoTrie> getHijos();
    
    public boolean isEsPalabra();
    
    public void setEsPalabra(boolean esPalabra);
    
    public Comparable getEtiqueta();
        
    public void setEtiqueta(Comparable etiqueta);
    
    void imprimir();

    public LinkedList<Comparable> getEtiquetas();
        
    public TNodoTrie buscarNodoTrie(String s);
    
    void insertar(String unId,String unaPalabra);
    
    public void predecir(String prefijo, LinkedList<String> palabras);
    
}
