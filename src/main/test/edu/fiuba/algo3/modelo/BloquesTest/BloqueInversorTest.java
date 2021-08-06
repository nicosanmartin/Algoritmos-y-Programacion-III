package edu.fiuba.algo3.modelo.BloquesTest;

import edu.fiuba.algo3.modelo.Bloques.BloqueAbajo;
import edu.fiuba.algo3.modelo.Bloques.BloqueDerecha;
import edu.fiuba.algo3.modelo.Bloques.BloqueInversor;
import edu.fiuba.algo3.modelo.Bloques.BloqueRepetidor;
import edu.fiuba.algo3.modelo.HerramientasDeDibujo.Lapiz;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.SectorDibujo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BloqueInversorTest {
    @Test
    public void test01AgregoUnBloqueDerechaABloqueInversorYAlEjecutarloSobrePersonajeDebeMoverloALaIzquierda(){
        Personaje personaje = new Personaje(new Lapiz(new SectorDibujo()));
        BloqueDerecha bloqueDerecha = new BloqueDerecha();
        Posicion posicionDestino = new Posicion(-1,0);

        BloqueInversor bloqueInversor = new BloqueInversor();
        bloqueInversor.agregarBloque(bloqueDerecha);
        bloqueInversor.ejecutarSobre(personaje);

        assertEquals(personaje.obtenerPosicion(), posicionDestino);
    }
    @Test
    public void test02AgregoUnBloqueRepetidorConMovimientoADerechaABloqueInversorYAlEjecutarloSobrePersonajeDebeMoverloALaIzquierda(){
        Personaje personaje = new Personaje(new Lapiz(new SectorDibujo()));
        BloqueDerecha bloqueDerecha = new BloqueDerecha();

        BloqueRepetidor bloqueRepetidor = new BloqueRepetidor(2);
        bloqueRepetidor.agregarBloque(bloqueDerecha);

        Posicion posicionDestino = new Posicion(-2,0);

        BloqueInversor bloqueInversor = new BloqueInversor();
        bloqueInversor.agregarBloque(bloqueRepetidor);
        bloqueInversor.ejecutarSobre(personaje);

        assertEquals(personaje.obtenerPosicion(), posicionDestino);
    }

    @Test
    public void test03AgregoUnBloqueInversorConMovimientoADerechaABloqueInversorYAlEjecutarloSobrePersonajeDebeMoverloALaDerecha(){
        Personaje personaje = new Personaje(new Lapiz(new SectorDibujo()));
        BloqueDerecha bloqueDerecha = new BloqueDerecha();

        BloqueInversor bloqueInversorDentro = new BloqueInversor();
        bloqueInversorDentro.agregarBloque(bloqueDerecha);

        Posicion posicionDestino = new Posicion(1,0);

        BloqueInversor bloqueInversorFuera = new BloqueInversor();
        bloqueInversorFuera.agregarBloque(bloqueInversorDentro);
        bloqueInversorFuera.ejecutarSobre(personaje);

        assertEquals(personaje.obtenerPosicion(), posicionDestino);
    }

    @Test
    public void obtenerElIDDelBloqueDebeDevolverBloqueInversor(){
        assertEquals("BloqueInversor", (new BloqueInversor()).obtenerID());
    }

}
