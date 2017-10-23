
package alasucu;

import alasucu.GrafoDirigido.TGrafoDirigido;

/**
 *
 * @author German
 */
public class AlasUcu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("./src/Aeropuertos.csv","./src/vuelos_test.csv","./src/Aerolineas.csv",
                false, TGrafoDirigido.class);
        
        System.out.println("");
        TTodosLosVuelos caminos = gd.todosLosCaminos("LAX", "SFO","AA");
        caminos.imprimir();*/
        FacadeAlasUcu fac = FacadeAlasUcu.getInstance();
        new AlasUcuMain().setVisible(true);
    }

}
