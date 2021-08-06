package edu.fiuba.algo3.modelo.BloquesTest;

import edu.fiuba.algo3.modelo.Bloques.BloqueAbajo;
import edu.fiuba.algo3.modelo.Bloques.BloqueArriba;
import edu.fiuba.algo3.modelo.HerramientasDeDibujo.Lapiz;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.SectorDibujo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BloqueArribaTest {

    @Test
    public void test01MoverAlPersonajeArribaLoDejaEnLaPosicionCeroYUno(){
        Personaje personaje = new Personaje(new Lapiz(new SectorDibujo()));
        BloqueArriba bloqueArriba = new BloqueArriba();
        Posicion posicionDestino = new Posicion(0,1);

        bloqueArriba.ejecutarSobre(personaje);

        assertEquals(personaje.obtenerPosicion(), posicionDestino);
    }

    @Test
    public void test02MoverAlPersonajeArribaYAbajoLoDejaEnLaPosicionCeroYCero(){
        Personaje personaje = new Personaje(new Lapiz(new SectorDibujo()));
        BloqueArriba bloqueArriba = new BloqueArriba();
        BloqueAbajo bloqueAbajo = new BloqueAbajo();
        Posicion posicionOrigen = new Posicion(0,0);

        bloqueArriba.ejecutarSobre(personaje);
        bloqueAbajo.ejecutarSobre(personaje);

        assertEquals(personaje.obtenerPosicion(), posicionOrigen);
    }

    @Test
    public void test03MoverAlPersonajeArribaCincoVecesLoDejaEnLaPosicionCeroYCinco(){
        Personaje personaje = new Personaje(new Lapiz(new SectorDibujo()));
        BloqueArriba bloqueArriba = new BloqueArriba();

        Posicion posicionDestino = new Posicion(0,5);

        bloqueArriba.ejecutarSobre(personaje);
        bloqueArriba.ejecutarSobre(personaje);
        bloqueArriba.ejecutarSobre(personaje);
        bloqueArriba.ejecutarSobre(personaje);
        bloqueArriba.ejecutarSobre(personaje);

        assertEquals(personaje.obtenerPosicion(), posicionDestino);
    }

    @Test
    public void test04MoverAlPersonajeConBloqueArribaInvertidoDebeMoverloHaciaAbajo(){
        Personaje personaje = new Personaje(new Lapiz(new SectorDibujo()));
        BloqueArriba bloqueArriba = new BloqueArriba();
        Posicion posicionDestino = new Posicion(0,-1);


        bloqueArriba.ejecutarInversoSobre(personaje);

        assertEquals(personaje.obtenerPosicion(), posicionDestino);
    }

    @Test
    public void obtenerElIDDelBloqueDebeDevolverBloqueArriba(){
        assertEquals("BloqueArriba", (new BloqueArriba()).obtenerID());
    }
}