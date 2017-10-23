package alasucu.GrafoDirigido;


import alasucu.TAeropuerto;
import alasucu.TOpcionVuelo;
import alasucu.TTodosLosVuelos;
import java.util.LinkedList;

/**
 * Clase que representa un vertice de un grafo, el mismo conta con una etiqueta, que en este caso sera el id del aeropuerto.
 * @author German
 */
public class TVertice implements IVertice{

    private Comparable etiqueta;
    private TAeropuerto datos;
    
    private LinkedList<TAdyacencia> adyacentes;
    private boolean visitado;
    

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    @Override
    public LinkedList<TAdyacencia> getAdyacentes() {
        return adyacentes;
    }

    public TVertice(Comparable unaEtiqueta) {
        this.etiqueta = unaEtiqueta;
        adyacentes = new LinkedList();
        visitado = false;
    }
    
    public TVertice(Comparable unaEtiqueta,TAeropuerto unAeropuerto) {
        this.etiqueta = unaEtiqueta;
        adyacentes = new LinkedList();
        visitado = false;
        datos = unAeropuerto;
    }

    @Override
    public void setVisitado(boolean valor) {
        this.visitado = valor;
    }

    @Override
    public boolean getVisitado() {
        return this.visitado;
    }

    @Override
    public TAdyacencia buscarAdyacencia(TVertice verticeDestino) {
        if (verticeDestino != null) {
            return buscarAdyacencia(verticeDestino.getEtiqueta());
        }
        return null;
    }


    public Double obtenerCostoAdyacencia(TVertice verticeDestino) {
        TAdyacencia ady = buscarAdyacencia(verticeDestino);
        if (ady != null) {
            return ady.getCosto();
        }
        return Double.MAX_VALUE;
    }

    @Override
    public boolean insertarAdyacencia(Double costo, TVertice verticeDestino) {
        if (buscarAdyacencia(verticeDestino) == null) {
            TAdyacencia ady = new TAdyacencia(costo, verticeDestino);
            return adyacentes.add(ady);
        }
        return false;
    }

    @Override
    public boolean eliminarAdyacencia(Comparable nomVerticeDestino) {
        TAdyacencia ady = buscarAdyacencia(nomVerticeDestino);
        if (ady != null) {
            adyacentes.remove(ady);
            return true;
        }
        return false;
    }

    @Override
    public TVertice primerAdyacente() {
        if (this.adyacentes.getFirst() != null) {
            return this.adyacentes.getFirst().getDestino();
        }
        return null;
    }

    

    @Override
    public TAdyacencia buscarAdyacencia(Comparable etiquetaDestino) {
        for (TAdyacencia adyacencia : adyacentes) {
            if (adyacencia.getDestino().getEtiqueta().compareTo(etiquetaDestino) == 0) {
                return adyacencia;
            }
        }
        return null;
    }

    @Override
    public TAeropuerto getDatos() {
        return datos; 
    }

   

    
    @Override
    public TTodosLosVuelos todosLosCaminos(Comparable etVertDestino,TOpcionVuelo caminoPrevio,TTodosLosVuelos todosLosCaminos, int largoMaxCamino){
        this.setVisitado(true);
        for(TAdyacencia adyacencia : this.getAdyacentes()){
            TVertice destino = adyacencia.getDestino(); //Destinos parciales.
            
            /*Si no fue visitado*/
            if(!destino.getVisitado() && largoMaxCamino>caminoPrevio.getOtrosVertices().size()){
                if(destino.getEtiqueta().equals(etVertDestino)){
                    TOpcionVuelo copia = caminoPrevio.copiar();
                    copia.agregarAdyacencia(adyacencia);
                    todosLosCaminos.getCaminos().add(copia);
                }else{
                    caminoPrevio.agregarAdyacencia(adyacencia);
                    destino.todosLosCaminos(etVertDestino, caminoPrevio, todosLosCaminos,largoMaxCamino);
                    caminoPrevio.eliminarAdyacencia(adyacencia);
                }
            }
        }
        this.setVisitado(false);
        return todosLosCaminos;
    }
    
    
}
