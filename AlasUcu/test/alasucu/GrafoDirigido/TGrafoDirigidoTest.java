/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alasucu.GrafoDirigido;

import alasucu.TAeropuerto;
import alasucu.TTodosLosVuelos;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author German
 */
public class TGrafoDirigidoTest {
    
    public TGrafoDirigidoTest() {
        
    }

    public TGrafoDirigido setDefault(){
        Map<Comparable,TAeropuerto> vertices = new HashMap<>();
        vertices.put("1",new TAeropuerto("1", "Uno"));
        vertices.put("2",new TAeropuerto("2", "Dos"));
        vertices.put("3",new TAeropuerto("3", "Tres"));
        vertices.put("4",new TAeropuerto("4", "Cuatro"));
        vertices.put("5",new TAeropuerto("5", "Cinco"));
        vertices.put("6",new TAeropuerto("6", "Seis"));
        
        TGrafoDirigido gd = new TGrafoDirigido(vertices);
        gd.insertarArista("1","2","1");
        gd.insertarArista("2","3","1");
        gd.insertarArista("4","3","5");
        gd.insertarArista("2","4","3");
        gd.insertarArista("1","3","3");
        gd.insertarArista("3","5","1");
        gd.insertarArista("4","5","6");
        gd.insertarArista("6","5","1");
        gd.insertarArista("4","6","5");
        return gd;
    }
    
    /**
     * Test of eliminarArista method, of class TGrafoDirigido.
     */
    @Test
    public void testEliminarArista() {
        System.out.println("eliminarArista");
        
        
        Comparable nomVerticeOrigen = "1";
        Comparable nomVerticeDestino = "3";
        TGrafoDirigido instance = setDefault();
        boolean expResult = true;
        boolean result = instance.eliminarArista(nomVerticeOrigen, nomVerticeDestino);
        assertEquals(expResult, (result && !instance.existeArista(nomVerticeOrigen, nomVerticeDestino)));

    }

    /**
     * Test of eliminarVertice method, of class TGrafoDirigido.
     */
    @Test
    public void testEliminarVertice() {
        System.out.println("eliminarVertice");
        Comparable nombreVertice = "4";
        TGrafoDirigido instance = setDefault();
        boolean expResult = false;
        boolean result = instance.eliminarVertice(nombreVertice);
        assertEquals(expResult, (!result && instance.existeVertice(nombreVertice)));

    }

    /**
     * Test of existeArista method, of class TGrafoDirigido.
     */
    @Test
    public void testExisteArista() {
        System.out.println("existeArista");
        Comparable etiquetaOrigen = "1";
        Comparable etiquetaDestino = "5";
        TGrafoDirigido instance = setDefault();
        boolean expResult = false;
        boolean result = instance.existeArista(etiquetaOrigen, etiquetaDestino);
        
        Comparable etiquetaOrigen2 = "4";
        Comparable etiquetaDestino2 = "6";
        
        boolean expResult2 = true;
        boolean result2 = instance.existeArista(etiquetaOrigen2, etiquetaDestino2);
        assertTrue(result==expResult && result2==expResult2);
    }

    /**
     * Test of existeVertice method, of class TGrafoDirigido.
     */
    @Test
    public void testExisteVertice() {
        System.out.println("existeVertice");
        Comparable unaEtiqueta = "1";
        Comparable unaEtiqueta2 = "7";
        TGrafoDirigido instance = setDefault();
        boolean expResult = true;
        boolean result = instance.existeVertice(unaEtiqueta);
        
        boolean expResult2 = false;
        boolean result2 = instance.existeVertice(unaEtiqueta2);
        assertTrue(result==expResult && result2==expResult2);

    }

    /**
     * Test of insertarArista method, of class TGrafoDirigido.
     */
    @Test
    public void testInsertarArista_TArista() {
        System.out.println("insertarArista");
        Comparable origen="1"; 
        Comparable destino ="6";
        TArista arista = new TArista(origen, destino, 10);
        TGrafoDirigido instance = setDefault();
        boolean expResult = true;
        boolean result = instance.insertarArista(arista);
        assertEquals(expResult, (result && instance.existeArista(origen, destino)));
    }

    /**
     * Test of insertarVertice method, of class TGrafoDirigido.
     */
    @Test
    public void testInsertarVertice_Comparable() {
        System.out.println("insertarVertice");
        Comparable unaEtiqueta = "7";
        TGrafoDirigido instance = setDefault();
        boolean expResult = true;
        boolean result = instance.insertarVertice(unaEtiqueta);
        assertEquals(expResult, result && instance.existeVertice(unaEtiqueta));

    }

    /**
     * Test of insertarVertice method, of class TGrafoDirigido.
     */
    @Test
    public void testInsertarVertice_TVertice() {
        System.out.println("insertarVertice");
        TVertice vertice = new TVertice("7");
        TGrafoDirigido instance = setDefault();
        boolean expResult = true;
        boolean result = instance.insertarVertice(vertice);
        assertEquals(expResult, result && instance.existeVertice(vertice.getEtiqueta()));
    }

    /**
     * Test of insertarArista method, of class TGrafoDirigido.
     */
    @Test
    public void testInsertarArista_3args() {
        System.out.println("insertarArista");
        /*Metodo utilizado en seteo por default*/
        TGrafoDirigido instance = setDefault();
        boolean expResult = true;
        boolean result = instance.existeArista("1", "2") && instance.existeArista("4", "3") && instance.existeArista("4", "5") && instance.existeArista("6", "5");
        assertEquals(expResult, result);

    }

    /**
     * Test of todosLosCaminos method, of class TGrafoDirigido.
     */
    @Test
    public void testTodosLosCaminos_grafoVacio() {
        System.out.println("todosLosCaminos");
        Map<Comparable,TAeropuerto> vertices = new HashMap<>();
        vertices.put("1",new TAeropuerto("1", "Uno"));
        vertices.put("2",new TAeropuerto("2", "Dos"));
        vertices.put("3",new TAeropuerto("3", "Tres"));
        vertices.put("4",new TAeropuerto("4", "Cuatro"));
        vertices.put("5",new TAeropuerto("5", "Cinco"));
        vertices.put("6",new TAeropuerto("6", "Seis"));
        TGrafoDirigido gd = new TGrafoDirigido(vertices);
        
        Comparable etiquetaOrigen = "1";
        Comparable etiquetaDestino = "2";
        int cantEscalas = 5;
        TGrafoDirigido instance = gd;
        TTodosLosVuelos result = instance.todosLosCaminos(etiquetaOrigen, etiquetaDestino, cantEscalas);
        assertTrue(result.getCaminos().isEmpty());

    }
    
    /**
     * Test of todosLosCaminos method, of class TGrafoDirigido.
     */
    @Test
    public void testTodosLosCaminos_grafoSinAristas() {
        System.out.println("todosLosCaminos");
        
        Comparable etiquetaOrigen = "5";
        Comparable etiquetaDestino = "6";
        int cantEscalas = 1;
        TGrafoDirigido instance = setDefault();
        TTodosLosVuelos result = instance.todosLosCaminos(etiquetaOrigen, etiquetaDestino, cantEscalas);
        assertTrue(result.getCaminos().isEmpty());
    }
    
    /**
     * Test of todosLosCaminos method, of class TGrafoDirigido.
     */
    @Test
    public void testTodosLosCaminos_largo3() {
        System.out.println("todosLosCaminos");
        
        Comparable etiquetaOrigen = "1";
        Comparable etiquetaDestino = "5";
        int cantEscalas = 3;
        TGrafoDirigido instance = setDefault();
        TTodosLosVuelos result = instance.todosLosCaminos(etiquetaOrigen, etiquetaDestino, cantEscalas);
        result.imprimir();
        /*caminos 
        * 1-2-3-5
        * 1-2-4-5
        * 1-3-5
        ******
        * Quedan descartados caminos de largo 4: 
        * 1-2-4-3-5
        * 1-2-4-6-5
        */
        assertTrue(result.getCaminos().size()==3);
    }
    
    /**
     * Test of todosLosCaminos method, of class TGrafoDirigido.
     */
    @Test
    public void testTodosLosCaminos_largo4() {
        System.out.println("todosLosCaminos");
        
        Comparable etiquetaOrigen = "1";
        Comparable etiquetaDestino = "5";
        int cantEscalas = 4;
        TGrafoDirigido instance = setDefault();
        TTodosLosVuelos result = instance.todosLosCaminos(etiquetaOrigen, etiquetaDestino, cantEscalas);
        result.imprimir();
        /*caminos 
        * 1-2-3-5
        * 1-2-4-5
        * 1-3-5
        * 1-2-4-3-5
        * 1-2-4-6-5
        */
        assertTrue(result.getCaminos().size()==5);
    }
}
