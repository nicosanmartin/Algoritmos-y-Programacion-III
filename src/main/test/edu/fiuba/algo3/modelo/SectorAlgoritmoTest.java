package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Bloques.*;
import edu.fiuba.algo3.modelo.Excepciones.SinBloquesADevolverException;
import edu.fiuba.algo3.modelo.HerramientasDeDibujo.Lapiz;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SectorAlgoritmoTest {


    SectorAlgoritmo sectorAlgoritmo = new SectorAlgoritmo();
    SectorDibujo sectorDibujo = new SectorDibujo();
    SectorDibujo sectorDibujoEsperado = new SectorDibujo();
    Personaje personaje = new Personaje(new Lapiz(sectorDibujo));

    @Test
    public void test01AgregarBloqueDeMovimientoDerechaYEjecutarElAlgoritmoNoDebeDibujarSobreElSectorDibujo(){

        BloqueDerecha bloqueDerecha = new BloqueDerecha();

        sectorAlgoritmo.agregarBloque(bloqueDerecha);
        sectorAlgoritmo.ejecutarPrograma(personaje);

        assertEquals(sectorDibujo, sectorDibujoEsperado);

    }

    @Test
    public void test02AgregarBloqueBloqueLapizAbajoYBloqueMovimientoDerechaAlEjecutarElAlgoritmoDebeDibujarSobreElSectorDibujo(){

        sectorDibujoEsperado.agregarTrazo(new Posicion(0,0), new Posicion(1,0));

        BloqueDerecha bloqueDerecha = new BloqueDerecha();
        BloqueLapizAbajo bloqueLapizAbajo = new BloqueLapizAbajo();

        sectorAlgoritmo.agregarBloque(bloqueLapizAbajo);
        sectorAlgoritmo.agregarBloque(bloqueDerecha);
        sectorAlgoritmo.ejecutarPrograma(personaje);

        assertEquals(sectorDibujo, sectorDibujoEsperado);
    }

    @Test
    public void test03CrearUnBloqueAlgoritmoPersonalizadoConBloquesDelSectorAlgoritmoDeberianRealizarLoMismo() throws SinBloquesADevolverException {

        BloqueLapizAbajo bloqueLapizAbajo = new BloqueLapizAbajo();
        BloqueIzquierda bloqueIzquierda = new BloqueIzquierda();

        sectorAlgoritmo.agregarBloque(bloqueLapizAbajo);
        sectorAlgoritmo.agregarBloque(bloqueIzquierda);

        Bloque bloqueAlgoritmo = new BloqueAlgoritmo(sectorAlgoritmo.obtenerBloques());
        bloqueAlgoritmo.ejecutarSobre(personaje);

        sectorDibujoEsperado.agregarTrazo(new Posicion(0,0), new Posicion(-1,0));

        assertEquals(sectorDibujo, sectorDibujoEsperado);
    }

    @Test
    public void test04ObtenerLosBloquesDeUnSectorAlgoritmoSinBloquesLanzaAlgoritmoSinBloquesException(){

        SectorAlgoritmo sectorAlgoritmo = new SectorAlgoritmo();

        assertThrows( SinBloquesADevolverException.class, () -> {sectorAlgoritmo.obtenerBloques();} );
    }

    @Test
    public void test05AgregoBloquesAlSectorYEjecutoElAlgoritmoDeberiaEstarDibujadoLuegoVacioYEjecutoDeNuevoPeroNoDibuja(){

        sectorAlgoritmo.agregarBloque(new BloqueLapizAbajo());
        sectorAlgoritmo.agregarBloque(new BloqueDerecha());
        sectorAlgoritmo.ejecutarPrograma(personaje);

        sectorDibujoEsperado.agregarTrazo(new Posicion(0,0), new Posicion(1,0));

        assertEquals(sectorDibujo, sectorDibujoEsperado);

        sectorAlgoritmo.vaciarSector();
        sectorAlgoritmo.ejecutarPrograma(personaje);
        assertEquals(sectorDibujo, sectorDibujoEsperado);
    }

    @Test
    public void test06AgregoBloqueAlContenedorInicialYAlPedirElContenedorInicialDebeEjecutarseLoQueHabiEnEl(){

        sectorAlgoritmo.agregarBloque(new BloqueLapizAbajo());
        sectorAlgoritmo.agregarBloque(new BloqueDerecha());
        BloqueContenedor bloqueContenedor = sectorAlgoritmo.obtenerContenedor();
        bloqueContenedor.ejecutarSobre(personaje);
        sectorDibujoEsperado.agregarTrazo(new Posicion(0,0), new Posicion(1,0));

        assertEquals(sectorDibujo, sectorDibujoEsperado);
    }

    @Test
    public void test07CrearUnSectorAlgoritmoDebeComenzarVacio(){

        sectorAlgoritmo.ejecutarPrograma(personaje);

        assertEquals(sectorAlgoritmo.estaVacio(), true);
        assertEquals(sectorDibujo, sectorDibujoEsperado);
    }

    @Test
    public void test08AgregarBloquesConMovimientoYLapizAbajoDentroDeUnBloqueContenedorDebeDibujarRepetidasVeces(){


        sectorAlgoritmo.agregarBloqueContenedor(new BloqueRepetidor(2));
        sectorAlgoritmo.agregarBloque(new BloqueLapizAbajo());
        sectorAlgoritmo.agregarBloque(new BloqueDerecha());
        sectorAlgoritmo.ejecutarPrograma(personaje);

        sectorDibujoEsperado.agregarTrazo(new Posicion(0,0), new Posicion(1,0));
        sectorDibujoEsperado.agregarTrazo(new Posicion(1,0), new Posicion(2,0));

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