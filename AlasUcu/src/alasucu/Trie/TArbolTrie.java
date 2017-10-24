package alasucu.Trie;



import java.util.LinkedList;


public class TArbolTrie implements IArbolTrie {

    private TNodoTrie raiz;

    @Override
    public void insertar(String unId,String palabra) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(unId,palabra);
    }

    @Override
    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }
    
    @Override
    public Comparable buscarEtiqueta(String prefijo) {
        if(raiz!= null){
           TNodoTrie n= raiz.buscarNodoTrie(prefijo);
           return (n==null)?"":n.getEtiqueta();
        }else{
            return null;
        }
    }
    
    @Override
    public LinkedList<String> predecir(String prefijo) {
        LinkedList<String> lista = null;
        if(raiz!= null){
           lista = new LinkedList<>();
           raiz.predecir(prefijo,lista);
        }
        return lista;
        
    }
    
    @Override
    public LinkedList<Comparable> getEtiquetas(){
        LinkedList<Comparable> et = new LinkedList<>();
        if(raiz == null){
            return new LinkedList<>();
        }
        return raiz.getEtiquetas();
    }
}
