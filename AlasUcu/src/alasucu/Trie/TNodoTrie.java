package alasucu.Trie;


import com.sun.xml.internal.ws.api.message.saaj.SAAJFactory;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import jdk.nashorn.internal.objects.NativeString;

public class TNodoTrie implements INodoTrie {

    private Map<Comparable,TNodoTrie> hijos;
    private boolean esPalabra;
    private Comparable etiqueta;
    
    public TNodoTrie() {
        hijos = new HashMap<>();
        esPalabra = false;
    }

    public Map<Comparable, TNodoTrie> getHijos() {
        return hijos;
    }

    public boolean isEsPalabra() {
        return esPalabra;
    }

    public void setEsPalabra(boolean esPalabra) {
        this.esPalabra = esPalabra;
    }

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(Comparable etiqueta) {
        this.etiqueta = etiqueta;
    }
    
    @Override
    public void insertar(String unId,String unaPalabra) {
        TNodoTrie nodo = this;

        for (int c = 0; c < unaPalabra.length(); c++) {
            String indice = Character.toString(unaPalabra.charAt(c));
            if(nodo.getHijos().containsKey(indice)){
                nodo=nodo.getHijos().get(indice);
            }else{
                TNodoTrie nuevoNodo = new TNodoTrie();
                nodo.getHijos().put(indice, nuevoNodo);
                nodo= nuevoNodo;
            }
            
        }
        nodo.setEsPalabra(true);
        nodo.setEtiqueta(unId); 
    }

    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);
                
            }
            nodo.getHijos().forEach((k,v)->{
                imprimir(s+v.getEtiqueta().toString(),v);
            });
        }
    }

    @Override
    public void imprimir() {
        
        imprimir("", this);
    }
    
    private void getEtiquetasAux(LinkedList<Comparable> etiquetas, TNodoTrie nodo){
        if (nodo != null) {
            if (nodo.esPalabra) {
                etiquetas.add(nodo.getEtiqueta());
            }
            nodo.getHijos().forEach((k,v)->{
                getEtiquetasAux(etiquetas,v);
            });
        }
    }
    
    public LinkedList<Comparable> getEtiquetas(){
        LinkedList<Comparable> et = new LinkedList<>();
        getEtiquetasAux(et,this);
        return et;
    }
    
    public TNodoTrie buscarNodoTrie(String s) {
        TNodoTrie nodo = this;
        for(int i=0;i<s.length();i++){
            String indice =Character.toString(s.charAt(i));
            if(nodo.getHijos().containsKey(indice)){
                nodo = nodo.getHijos().get(indice);
                if(i==s.length()-1){
                    return nodo;
                }
            }else{
                return null;
            }
        }
       
        return null;
    }
     
    private void predecir(String s, String prefijo, LinkedList<String> palabras, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                palabras.add(prefijo+s);
                
            }
            nodo.getHijos().forEach((k,v)->{
                predecir(s+k.toString(),prefijo,palabras,v);
            });
        }
       
    }

    @Override
    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoTrie nodo = null;
        if(!prefijo.equals("")){
            nodo = this.buscarNodoTrie(prefijo);
        }else{
            nodo = this;
        }
        predecir("",prefijo,palabras,nodo);
    }

}
