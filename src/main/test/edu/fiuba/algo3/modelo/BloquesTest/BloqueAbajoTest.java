package edu.fiuba.algo3.modelo.BloquesTest;

import edu.fiuba.algo3.modelo.Bloques.BloqueAbajo;
import edu.fiuba.algo3.modelo.Bloques.BloqueArriba;
import edu.fiuba.algo3.modelo.HerramientasDeDibujo.Lapiz;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.SectorDibujo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BloqueAbajoTest {

    @Test
    public void test01MoverAlPersonajeAbajoLoDejaEnLaPosicionCeroYMenosUno(){
        Personaje personaje = new Personaje(new Lapiz(new SectorDibujo()));
        BloqueAbajo bloqueAbajo = new BloqueAbajo();
        Posicion posicionDestino = new Posicion(0,-1);

        bloqueAbajo.ejecutarSobre(personaje);

        assertEquals(personaje.obtenerPosicion(), posicionDestino);

    }

    @Test
    public void test02MoverAlPersonajeAbajoYArribaLoDejaEnLaPosicionCeroYCero(){
        Personaje personaje = new Personaje(new Lapiz(new SectorDibujo()));
        BloqueAbajo bloqueAbajo = new BloqueAbajo();
        BloqueArriba bloqueArriba = new BloqueArriba();
        Posicion posicionOrigen = new Posicion(0,0);

        bloqueAbajo.ejecutarSobre(personaje);
        bloqueArriba.ejecutarSobre(personaje);

        assertEquals(personaje.obtenerPosicion(), posicionOrigen);
    }

    @Test
    public void test03MoverAlPersonajeAbajoCincoVecesLoDejaEnLaPosicionCeroYMenosCinco(){
        Personaje personaje = new Personaje(new Lapiz(new SectorDibujo()));
        BloqueAbajo bloqueAbajo = new BloqueAbajo();

        Posicion posicionDestino = new Posicion(0,-5);

        bloqueAbajo.ejecutarSobre(personaje);
        bloqueAbajo.ejecutarSobre(personaje);
        bloqueAbajo.ejecutarSobre(personaje);
        bloqueAbajo.ejecutarSobre(personaje);
        bloqueAbajo.ejecutarSobre(personaje);

        assertEquals(personaje.obtenerPosicion(), posicionDestino);
    }
    @Test
    public void test04MoverAlPersonajeConBloqueAbajoInvertidoDebeMoverloHaciaArriba(){
        Personaje personaje = new Personaje(new Lapiz(new SectorDibujo()));
        BloqueAbajo bloqueAbajo = new BloqueAbajo();
        Posicion posicionDestino = new Posicion(0,1);


        bloqueAbajo.ejecutarInversoSobre(personaje);

        assertEquals(personaje.obtenerPosicion(), posicionDestino);
    }

    @Test
    public void obtenerElIDDelBloqueDebeDevolverBloqueAbajo(){
        assertEquals("BloqueAbajo", (new BloqueAbajo()).obtenerID());
    }
}