
package alasucu;

import alasucu.Utiles.ManejadorArchivosGenerico;
import alasucu.Trie.TArbolTrie;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * SINGLETON - Clase manejadora de vuelos. Encapsula la logica del programa
 * @author German
 */
public class FacadeAlasUcu {
    private static FacadeAlasUcu instance = null;
    private TArbolTrie trieAerolineas;
    private TArbolTrie trieAeropuertos;
    private Map<Comparable, TAerolinea> aerolineas;
    private Map<Comparable, TAeropuerto> aeropuertos;

    private static final String archivoAerolineas="./src/Aerolineas.csv";
    private static final String archivoAeropuertos="./src/Aeropuertos.csv";
    private static final String archivoVuelos="./src/vuelos_produccion.csv";
    
    private FacadeAlasUcu(){
        cargarTries();
        cargarAeropuertos();
        cargarAerolineas();
        
    }
    
    public boolean existeAerolinea(Comparable aerolinea){
        return this.aerolineas.containsKey(aerolinea);
    }
    
    /**
     * @return coleccion de aerolineas
     */
    public Map<Comparable, TAerolinea> getAerolineas(){
        return aerolineas;
    }
    
    /**
     * Inserta una nueva aerolinea a la facade
     * @param aero nueva aerolinea
     * @return 
     */
    public boolean insertarAerolinea(TAerolinea aero){
        if(!aerolineas.containsKey(aero.getId())){
            aerolineas.put(aero.getId(),aero);
        }
        return aerolineas.containsKey(aero.getId());
    }
        
    public static FacadeAlasUcu getInstance(){
        if(instance==null){
            instance = new FacadeAlasUcu();
        }
        return instance;
    }
    
    public TArbolTrie getTrieAerolineas() {
        return trieAerolineas;
    }

    public TArbolTrie getTrieAeropuertos() {
        return trieAeropuertos;
    }
     
    private void cargarTries(){
        /*carga de aerolineas*/
        this.trieAerolineas           = new TArbolTrie();
        String[] palabras = ManejadorArchivosGenerico.leerArchivo(archivoAerolineas, false);
        
        //TODO: CARGAR PALABRAS CON EL LECTOR DE ARCHIVOS GENÉRICO
        for (String linea : palabras) {
            String[] p = linea.split(",");
            trieAerolineas.insertar(p[0].trim(),p[1].trim());
        }
        System.out.println("Carga de Trie Aerolineas Finalizada.");
        
        this.trieAeropuertos           = new TArbolTrie();
        palabras = ManejadorArchivosGenerico.leerArchivo(archivoAeropuertos, false);
        //TODO: CARGAR PALABRAS CON EL LECTOR DE ARCHIVOS GENÉRICO
        for (String linea : palabras) {
            String[] p = linea.split(",");
            trieAeropuertos.insertar(p[0].trim(),p[1].trim());
        }
        System.out.println("Carga de Trie Aeropuertos Finalizada.");
    }
    
    private void cargarAerolineas(){
        this.aerolineas           = new HashMap<>();
        String[] archAerolineas = ManejadorArchivosGenerico.leerArchivo(archivoAerolineas, false);
        
        //TODO: CARGAR PALABRAS CON EL LECTOR DE ARCHIVOS GENÉRICO
        for (String linea : archAerolineas) {
            String[] p = linea.split(",");
            aerolineas.put(p[0].trim(),new TAerolinea(p[0].trim(), p[1].trim(),aeropuertos));
        }
        System.out.println("Carga de Aerolineas Finalizada.");
        
        String[] archVuelos = ManejadorArchivosGenerico.leerArchivo(archivoVuelos, false);
        for (String linea : archVuelos) {
            String[] p = linea.split(",");
            TAerolinea aerolineaActual = this.aerolineas.get(p[0].trim());
            if(aerolineaActual!=null){
                aerolineaActual.insertarVuelo(p[1].trim(),p[2].trim(),p[3].trim());
            }
        }
    }

    private void cargarAeropuertos(){
        this.aeropuertos           = new HashMap<>();
        String[] palabras = ManejadorArchivosGenerico.leerArchivo(archivoAeropuertos, false);
        
        //TODO: CARGAR PALABRAS CON EL LECTOR DE ARCHIVOS GENÉRICO
        for (String linea : palabras) {
            String[] p = linea.split(",");
            aeropuertos.put(p[0].trim(),new TAeropuerto(p[0].trim(), p[1].trim()));
        }
        System.out.println("Carga de Aeropuertos Finalizada.");
    }
    
    /*public TTodosLosVuelos todosLosVuelos(String aerolinea,String origen,String destino){
        TAerolinea aero = this.aerolineas.get(aerolinea);
        TTodosLosVuelos vuelos =null;
        if(aero!=null){
            vuelos = aero.todosLosVuelos(origen,destino);
        }
        return vuelos;
    }*/
    
    public TOpcionVuelo vueloOptimo(TTodosLosVuelos vuelos){

        return vuelos.vueloOptimo();
    }
    
    public TOpcionVuelo vueloOptimo(LinkedList<DataVuelo> vuelos,int escalas){
        TOpcionVuelo vueloOpt=null;
        double minCosto = Integer.MAX_VALUE;
        for(DataVuelo v:vuelos){
            if(v.getVuelo().getCosto()<minCosto && (v.getVuelo().getOtrosVertices().size()<=escalas || escalas==0)){
                vueloOpt=v.getVuelo();
                minCosto=v.getVuelo().getCosto();
            }
        }
        return vueloOpt;
    }
    
    public String getDescripcionAeropuerto(Comparable idAerolinea){
        return (this.aeropuertos.containsKey(idAerolinea)?this.aeropuertos.get(idAerolinea).getDescripcion():"");
    }
    
    public String getDescripcionAerolinea(Comparable idAeropuerto){
        return (this.aerolineas.containsKey(idAeropuerto)?this.aerolineas.get(idAeropuerto).getDescripcion():"");
    }
    
    public LinkedList<DataVuelo> todasLasAerolineas(String origen,String destino,Integer escalas){
        LinkedList<DataVuelo> todos_optimos=new LinkedList<>();
        for (Map.Entry<Comparable,TAerolinea> eAerolineas : this.aerolineas.entrySet()){
            
            TTodosLosVuelos optimos=eAerolineas.getValue().todosLosVuelos(origen, destino,escalas); 
            TOpcionVuelo vuelo = vueloOptimo(optimos);
            if(vuelo!=null){
                todos_optimos.add(new DataVuelo(eAerolineas.getKey(),vuelo));
            }
            
        }
        return todos_optimos;
    }
}
