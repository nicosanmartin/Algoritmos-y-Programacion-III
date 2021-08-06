package edu.fiuba.algo3.modelo.BloquesTest;

import edu.fiuba.algo3.modelo.Bloques.BloqueAbajo;
import edu.fiuba.algo3.modelo.Bloques.BloqueDerecha;
import edu.fiuba.algo3.modelo.Bloques.BloqueIzquierda;
import edu.fiuba.algo3.modelo.HerramientasDeDibujo.Lapiz;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.SectorDibujo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BloqueIzquierdaTest {

    @Test
    public void test01MoverAlPersonajeAIzquierdaLoDejaEnLaPosicionMenosUnoYCero(){
        Personaje personaje = new Personaje(new Lapiz(new SectorDibujo()));
        BloqueIzquierda bloqueIzquierda = new BloqueIzquierda();
        Posicion posicionDestino = new Posicion(-1,0);

        bloqueIzquierda.ejecutarSobre(personaje);

        assertEquals(personaje.obtenerPosicion(), posicionDestino);
    }

    @Test
    public void test02MoverAlPersonajeAIzquierdaYADerechaLoDejaEnLaPosicionCeroYCero(){
        Personaje personaje = new Personaje(new Lapiz(new SectorDibujo()));
        BloqueIzquierda bloqueIzquierda = new BloqueIzquierda();
        BloqueDerecha bloqueDerecha = new BloqueDerecha();
        Posicion posicionOrigen = new Posicion(0,0);

        bloqueIzquierda.ejecutarSobre(personaje);
        bloqueDerecha.ejecutarSobre(personaje);

        assertEquals(personaje.obtenerPosicion(), posicionOrigen);
    }

    @Test
    public void test03MoverAlPersonajeAIzquierdaCincoVecesLoDejaEnLaPosicionMenosCincoYCero(){
        Personaje personaje = new Personaje(new Lapiz(new SectorDibujo()));
        BloqueIzquierda bloqueIzquierda = new BloqueIzquierda();

        Posicion posicionDestino = new Posicion(-5,0);

        bloqueIzquierda.ejecutarSobre(personaje);
        bloqueIzquierda.ejecutarSobre(personaje);
        bloqueIzquierda.ejecutarSobre(personaje);
        bloqueIzquierda.ejecutarSobre(personaje);
        bloqueIzquierda.ejecutarSobre(personaje);

        assertEquals(personaje.obtenerPosicion(), posicionDestino);
    }

    @Test
    public void test04MoverAlPersonajeConBloqueIzquierdaInvertidoDebeMoverloHaciaLaDerecha(){
        Personaje personaje = new Personaje(new Lapiz(new SectorDibujo()));
        BloqueIzquierda bloqueIzquierda = new BloqueIzquierda();
        Posicion posicionDestino = new Posicion(1,0);


        bloqueIzquierda.ejecutarInversoSobre(personaje);

        assertEquals(personaje.obtenerPosicion(), posicionDestino);
    }

    @Test
    public void obtenerElIDDelBloqueDebeDevolverBloqueIzquierda(){
        assertEquals("BloqueIzquierda", (new BloqueIzquierda()).obtenerID());
    }
}