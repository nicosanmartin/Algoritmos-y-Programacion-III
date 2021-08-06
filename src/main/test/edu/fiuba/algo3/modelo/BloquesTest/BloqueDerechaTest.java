package edu.fiuba.algo3.modelo.BloquesTest;

import edu.fiuba.algo3.modelo.Bloques.BloqueAbajo;
import edu.fiuba.algo3.modelo.Bloques.BloqueDerecha;
import edu.fiuba.algo3.modelo.Bloques.BloqueIzquierda;
import edu.fiuba.algo3.modelo.HerramientasDeDibujo.Lapiz;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.SectorDibujo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BloqueDerechaTest {

    @Test
    public void test01MoverAlPersonajeADerechaLoDejaEnLaPosicionUnoYCero(){
        Personaje personaje = new Personaje(new Lapiz(new SectorDibujo()));
        BloqueDerecha bloqueDerecha = new BloqueDerecha();
        Posicion posicionDestino = new Posicion(1,0);

        bloqueDerecha.ejecutarSobre(personaje);

        assertEquals(personaje.obtenerPosicion(), posicionDestino);
    }

    @Test
    public void test02MoverAlPersonajeADerechaYAIzquierdaLoDejaEnLaPosicionCeroYCero(){
        Personaje personaje = new Personaje(new Lapiz(new SectorDibujo()));
        BloqueDerecha bloqueDerecha = new BloqueDerecha();
        BloqueIzquierda bloqueIzquierda = new BloqueIzquierda();
        Posicion posicionOrigen = new Posicion(0,0);

        bloqueDerecha.ejecutarSobre(personaje);
        bloqueIzquierda.ejecutarSobre(personaje);

        assertEquals(personaje.obtenerPosicion(), posicionOrigen);
    }

    @Test
    public void test03MoverAlPersonajeADerechaCincoVecesLoDejaEnLaPosicionCincoYCero(){
        Personaje personaje = new Personaje(new Lapiz(new SectorDibujo()));
        BloqueDerecha bloqueDerecha = new BloqueDerecha();

        Posicion posicionDestino = new Posicion(5,0);

        bloqueDerecha.ejecutarSobre(personaje);
        bloqueDerecha.ejecutarSobre(personaje);
        bloqueDerecha.ejecutarSobre(personaje);
        bloqueDerecha.ejecutarSobre(personaje);
        bloqueDerecha.ejecutarSobre(personaje);

        assertEquals(personaje.obtenerPosicion(), posicionDestino);
    }


    @Test
    public void test04MoverAlPersonajeConBloqueDerechaInvertidoDebeMoverloHaciaLaIzquierda(){
        Personaje personaje = new Personaje(new Lapiz(new SectorDibujo()));
        BloqueDerecha bloqueDerecha = new BloqueDerecha();
        Posicion posicionDestino = new Posicion(-1,0);


        bloqueDerecha.ejecutarInversoSobre(personaje);

        assertEquals(personaje.obtenerPosicion(), posicionDestino);
    }

    @Test
    public void obtenerElIDDelBloqueDebeDevolverBloqueDerecha(){
        assertEquals("BloqueDerecha", (new BloqueDerecha()).obtenerID());
    }
}