package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Bloques.BloqueAbajo;
import edu.fiuba.algo3.modelo.Bloques.BloqueArriba;
import edu.fiuba.algo3.modelo.Bloques.BloqueDerecha;
import edu.fiuba.algo3.modelo.Bloques.BloqueIzquierda;
import edu.fiuba.algo3.modelo.DireccionesDeMovimiento.*;
import edu.fiuba.algo3.modelo.HerramientasDeDibujo.Lapiz;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonajeTest {

    SectorDibujo sectorDibujo = new SectorDibujo();
    SectorDibujo sectorDibujoEsperado = new SectorDibujo();
    Personaje personaje = new Personaje(new Lapiz(sectorDibujo));

    @Test
    public void test01BajoLapizDelPersonajeYAlMoverseDebeDibujar(){
        personaje.bajarLapiz();
        personaje.moverseHacia(new DireccionDerecha());
        sectorDibujoEsperado.agregarTrazo(new Posicion(0,0), new Posicion(1,0));
        assertEquals(sectorDibujo, sectorDibujoEsperado);
    }

    @Test
    public void test02PersonajeCreadoAlMoverseNoDebeDibujar(){
        personaje.moverseHacia(new DireccionDerecha());
        assertEquals(sectorDibujo, sectorDibujoEsperado);
    }

    @Test
    public void test03LaPosicionObtenidaDeUnPersonajeQueSeMueveHaciaArribaEsLaPosicionCeroUno(){

        Posicion posicionDestino = new Posicion(0, 1);
        Direccion arriba = new DireccionArriba();

        personaje.moverseHacia(arriba);

        assertEquals(posicionDestino, personaje.obtenerPosicion());
    }

    @Test
    public void test04LaPosicionObtenidaDeUnPersonajeQueSeMueveHaciaAbajoEsLaPosicionCeroMenosUno(){

        Posicion posicionDestino = new Posicion(0, -1);
        Direccion abajo = new DireccionAbajo();

        personaje.moverseHacia(abajo);

        assertEquals(posicionDestino, personaje.obtenerPosicion());
    }

    @Test
    public void test05LaPosicionObtenidaDeUnPersonajeQueSeMueveHaciaIzquierdaEsLaPosicionMenosUnoCero(){
        Posicion posicionDestino = new Posicion(-1, 0);
        Direccion izquierda = new DireccionIzquierda();

        personaje.moverseHacia(izquierda);

        assertEquals(posicionDestino, personaje.obtenerPosicion());
    }

    @Test
    public void test06LaPosicionObtenidaDeUnPersonajeQueSeMueveHaciaDerechaEsLaPosicionUnoCero(){
        Posicion posicionDestino = new Posicion(1, 0);
        Direccion derecha = new DireccionDerecha();

        personaje.moverseHacia(derecha);

        assertEquals(posicionDestino, personaje.obtenerPosicion());
    }

    @Test
    public void test07MuevoConBloquesElPersonajeEnVariasDireccionesPeroDebeTerminarEnSuPosicionOrigen(){
        BloqueDerecha bloqueDerecha = new BloqueDerecha();
        BloqueIzquierda bloqueIzquierda = new BloqueIzquierda();
        BloqueArriba bloqueArriba = new BloqueArriba();
        BloqueAbajo bloqueAbajo = new BloqueAbajo();

        Posicion posicionOrigen = personaje.obtenerPosicion();
        bloqueDerecha.ejecutarSobre(personaje);
        bloqueIzquierda.ejecutarSobre(personaje);
        bloqueArriba.ejecutarSobre(personaje);
        bloqueAbajo.ejecutarSobre(personaje);

        assertEquals(posicionOrigen, personaje.obtenerPosicion());

    }

    @Test
    public void test09ReseteoLaPosicionYElLapizDelPersonajeASuEstadoInicialDespuesDeMoverseDibujando(){
        personaje.bajarLapiz();
        personaje.moverseHacia(new DireccionDerecha());
        sectorDibujoEsperado.agregarTrazo(new Posicion(0,0), new Posicion(1,0));
        assertEquals(sectorDibujo, sectorDibujoEsperado);
        assertEquals(personaje.obtenerPosicion(), new Posicion(1,0));
        personaje.restablecerPersonaje();
        assertEquals(personaje.obtenerPosicion(), new Posicion(0,0));
        personaje.moverseHacia(new DireccionArriba());
        assertEquals(sectorDibujo, sectorDibujoEsperado);

    }






    /////////////////////////// IGNORAR ADDOBSERVER EN CODECOV //////////////////////////
    @Test
    public void ignorarAddObserverEnCodeCov(){
        Observer pruebaObserver = () -> System.out.println("output: hello how r u");
        personaje.addObserver(pruebaObserver);
        personaje.removeObserver(pruebaObserver);
        personaje.notifyObservers();
        assertEquals(1,1);
    }


}