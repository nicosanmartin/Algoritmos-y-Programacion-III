package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.DireccionesDeMovimiento.DireccionAbajo;
import edu.fiuba.algo3.modelo.DireccionesDeMovimiento.DireccionArriba;
import edu.fiuba.algo3.modelo.DireccionesDeMovimiento.DireccionDerecha;
import edu.fiuba.algo3.modelo.DireccionesDeMovimiento.DireccionIzquierda;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PosicionTest {

    @Test
    public void test01UnaPosicionConLasCoordenadasCeroCeroEsIgualAOtraPosicionConLasCoordenadasCeroCero(){
        Posicion unaPosicion = new Posicion(0, 0);
        Posicion otraPosicion = new Posicion(0, 0);

        assertEquals(unaPosicion, otraPosicion);
    }

    @Test
    public void test02ObtenerPosicionHaciaDerechaDesdeLaCoordenadaCeroCeroDebeDevolverCoordenadaUnoCero(){
        Posicion unaPosicion = new Posicion(0, 0);
        Posicion posicionALaDerecha = new Posicion(1, 0);

        Posicion posicionObtenida = unaPosicion.obtenerPosicionHacia(new DireccionDerecha());

        assertEquals(posicionALaDerecha, posicionObtenida);
    }

    @Test
    public void test03ObtenerPosicionHaciaIzquierdaDesdeLaCoordenadaCeroCeroDebeDevolverCoordenadaMenosUnoCero(){
        Posicion unaPosicion = new Posicion(0, 0);
        Posicion posicionALaIzquierda = new Posicion(-1, 0);

        Posicion posicionObtenida = unaPosicion.obtenerPosicionHacia(new DireccionIzquierda());

        assertEquals(posicionALaIzquierda, posicionObtenida);
    }

    @Test
    public void test04ObtenerPosicionHaciaArribaDesdeLaCoordenadaCeroCeroDebeDevolverCoordenadaCeroUno(){
        Posicion unaPosicion = new Posicion(0, 0);
        Posicion posicionArriba = new Posicion(0, 1);

        Posicion posicionObtenida = unaPosicion.obtenerPosicionHacia(new DireccionArriba());

        assertEquals(posicionArriba, posicionObtenida);
    }

    @Test
    public void test05ObtenerPosicionHaciaAbajoDesdeLaCoordenadaCeroCeroDebeDevolverCoordenadaCeroMenosUno(){
        Posicion unaPosicion = new Posicion(0, 0);
        Posicion posicionAbajo = new Posicion(0, -1);

        Posicion posicionObtenida = unaPosicion.obtenerPosicionHacia(new DireccionAbajo());

        assertEquals(posicionAbajo, posicionObtenida);
    }

    @Test
    public void test06ObtengoCoordenadaXDeUnaPosicionConCoordenadaXEnTres(){
        Posicion posicion = new Posicion(1,3);
        assertEquals(1, posicion.obtenerX());
    }


    @Test
    public void test07ObtengoCoordenadaYDeUnaPosicionConCoordenadaYEnTres(){
        Posicion posicion = new Posicion(1,3);
        assertEquals(3, posicion.obtenerY());
    }

    @Test
    public void test06TestEquals(){

        Posicion p1 = new Posicion(0,0);
        Posicion p2 = new Posicion(0, 0);
        assertEquals(true, p1.equals(p2));
        assertEquals(true, p1.equals(p1));
        assertEquals((p1.obtenerX() == p1.obtenerY()), p2.obtenerX() == p2.obtenerY() );
        assertEquals(false,p1.equals(null));
    }


}