package edu.fiuba.algo3.modelo.BloquesTest;

import edu.fiuba.algo3.modelo.Bloques.*;
import edu.fiuba.algo3.modelo.HerramientasDeDibujo.Lapiz;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.SectorDibujo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BloqueRepetidorTest {

    @Test
    public void test01RepitoMovimientoHaciaArriba(){
        Personaje personaje = new Personaje(new Lapiz(new SectorDibujo()));
        BloqueRepetidor bloqueRepetidor = new BloqueRepetidor(2);
        Posicion posicionDestino = new Posicion(0,2);

        bloqueRepetidor.agregarBloque(new BloqueArriba());

        bloqueRepetidor.ejecutarSobre(personaje);

        assertEquals(personaje.obtenerPosicion(), posicionDestino);
    }

    @Test
    public void test02RepitoMovimientoHaciaAbajo(){
        Personaje personaje = new Personaje(new Lapiz(new SectorDibujo()));
        BloqueRepetidor bloqueRepetidor = new BloqueRepetidor(2);
        Posicion posicionDestino = new Posicion(0,-2);

        bloqueRepetidor.agregarBloque(new BloqueAbajo());

        bloqueRepetidor.ejecutarSobre(personaje);

        assertEquals(personaje.obtenerPosicion(), posicionDestino);
    }

    @Test
    public void test03RepitoMovimientoHaciaLaDerecha(){
        Personaje personaje = new Personaje(new Lapiz(new SectorDibujo()));
        BloqueRepetidor bloqueRepetidor = new BloqueRepetidor(2);
        Posicion posicionDestino = new Posicion(2,0);

        bloqueRepetidor.agregarBloque(new BloqueDerecha());

        bloqueRepetidor.ejecutarSobre(personaje);

        assertEquals(personaje.obtenerPosicion(), posicionDestino);
    }

    @Test
    public void test04RepitoMovimientoHaciaLaIzquierda(){
        Personaje personaje = new Personaje(new Lapiz(new SectorDibujo()));
        BloqueRepetidor bloqueRepetidor = new BloqueRepetidor(2);
        Posicion posicionDestino = new Posicion(-2,0);

        bloqueRepetidor.agregarBloque(new BloqueIzquierda());

        bloqueRepetidor.ejecutarSobre(personaje);

        assertEquals(personaje.obtenerPosicion(), posicionDestino);
    }

    @Test
    public void test05RepitoConBloqueMovimientoHaciaLaIzquierdaYAlInvertirElBloqueSeDebeMoverALaDerecha(){
        Personaje personaje = new Personaje(new Lapiz(new SectorDibujo()));
        BloqueRepetidor bloqueRepetidor = new BloqueRepetidor(2);
        Posicion posicionDestino = new Posicion(2,0);

        bloqueRepetidor.agregarBloque(new BloqueIzquierda());

        bloqueRepetidor.ejecutarInversoSobre(personaje);

        assertEquals(personaje.obtenerPosicion(), posicionDestino);
    }

    /*
    @Test
    public void test05RepitoLapizArriba(){
        Personaje personaje = new Personaje(new Lapiz(new SectorDibujo()));
        BloqueRepetidor bloqueRepetidor = new BloqueRepetidor(2);

        bloqueRepetidor.agregarBloque(new BloqueLapizArriba());

        bloqueRepetidor.ejecutarSobre(personaje);
        int resultado = personaje.dibujar();

        assertEquals(0, resultado);
    }

    @Test
    public void test06RepitoLapizAbajo(){
        Personaje personaje = new Personaje(new Lapiz(new SectorDibujo()));
        BloqueRepetidor bloqueRepetidor = new BloqueRepetidor(2);
        bloqueRepetidor.agregarBloque(new BloqueLapizAbajo());

        bloqueRepetidor.ejecutarSobre(personaje);
        int resultado = personaje.dibujar();

        assertEquals(1, resultado);
    }

    @Test
    public void test07RepitoVariosMovimientos(){
        Personaje personaje = new Personaje(new Lapiz(new SectorDibujo()));
        BloqueRepetidor bloqueRepetidor = new BloqueRepetidor(2);

        bloqueRepetidor.agregarBloque(new BloqueArriba());
        bloqueRepetidor.agregarBloque(new BloqueArriba());
        bloqueRepetidor.agregarBloque(new BloqueAbajo());

        Posicion posicionDestino = new Posicion(0,2);

        bloqueRepetidor.ejecutarSobre(personaje);

        assertEquals(personaje.obtenerPosicion(), posicionDestino);
    }
    */

    @Test
    public void test08AgregoVariosBloquesDeRepeticionDentroDeUnBloqueDeRepeticionYSeRepitenMovimientos (){
        Personaje personaje = new Personaje(new Lapiz(new SectorDibujo()));
        BloqueRepetidor zigzag = new BloqueRepetidor(2);

        zigzag.agregarBloque(new BloqueDerecha());
        zigzag.agregarBloque(new BloqueArriba());
        zigzag.agregarBloque(new BloqueIzquierda());
        zigzag.agregarBloque(new BloqueArriba());

        BloqueRepetidor bajar = new BloqueRepetidor(4);

        bajar.agregarBloque(new BloqueAbajo());

        BloqueRepetidor bloqueRepetidor = new BloqueRepetidor(2);

        bloqueRepetidor.agregarBloque( zigzag );
        bloqueRepetidor.agregarBloque( bajar );
        bloqueRepetidor.agregarBloque( new BloqueDerecha());
        bloqueRepetidor.agregarBloque( new BloqueDerecha());

        bloqueRepetidor.ejecutarSobre(personaje);

        assertEquals(personaje.obtenerPosicion(), new Posicion(4,0));
    }

    @Test
    public void obtenerElIDDelBloqueDebeDevolverBloqueRepetidor(){
        assertEquals("BloqueRepetidor2", (new BloqueRepetidor(2)).obtenerID());
        assertEquals("BloqueRepetidor3", (new BloqueRepetidor(3)).obtenerID());
    }

}
