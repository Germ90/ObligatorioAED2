/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alasucu;

import alasucu.GrafoDirigido.TGrafoDirigido;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author German
 */
public class TTodosLosVuelosTest {
    
    public TTodosLosVuelosTest() {
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
     * Test of vueloOptimo method, of class TTodosLosVuelos.
     */
    @Test
    public void testVueloOptimo() {
        System.out.println("vueloOptimo");
        TTodosLosVuelos instance = setDefault().todosLosCaminos("1", "5", 4);
        TOpcionVuelo result = instance.vueloOptimo();
        result.imprimirEtiquetas();
        double expectResult = 3.0;
        assertTrue(expectResult== result.getCosto());

    }
    
    /**
     * Test of vueloOptimo method, of class TTodosLosVuelos.
     */
    @Test
    public void testVueloOptimo2() {
        System.out.println("vueloOptimo2");
        TGrafoDirigido gd = setDefault();
        
        TTodosLosVuelos instance = gd.todosLosCaminos("1", "6", 4);
        
        gd.insertarArista("5", "6", "1");
        TTodosLosVuelos instance2 = gd.todosLosCaminos("1", "6", 4);
        TOpcionVuelo result = instance.vueloOptimo();
        TOpcionVuelo result2 = instance2.vueloOptimo();
        result.imprimirEtiquetas();
        result2.imprimirEtiquetas();

        double expectResult = 9.0;
        double expectResult2 = 4.0;
        assertTrue(expectResult== result.getCosto() && expectResult2== result2.getCosto());

    }
    
}
