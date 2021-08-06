package edu.fiuba.algo3.modelo.BloquesTest;

import edu.fiuba.algo3.modelo.Bloques.BloqueAbajo;
import edu.fiuba.algo3.modelo.Bloques.BloqueDerecha;
import edu.fiuba.algo3.modelo.Bloques.BloqueLapizAbajo;
import edu.fiuba.algo3.modelo.Bloques.BloqueLapizArriba;
import edu.fiuba.algo3.modelo.HerramientasDeDibujo.Lapiz;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.SectorDibujo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BloqueLapizArribaTest {

    @Test
    public void test01CreoUnPersonajeYAlMoverseNoDebeDibujar() {
        SectorDibujo sectorDibujo = new SectorDibujo();
        Personaje personaje = new Personaje(new Lapiz(sectorDibujo));
        BloqueDerecha bloqueDerecha = new BloqueDerecha();
        bloqueDerecha.ejecutarSobre(personaje);

        SectorDibujo sectorDibujoVacio = new SectorDibujo();
        assertEquals(sectorDibujo, sectorDibujoVacio);
    }

    @Test
    public void test02CreoUnPersonajeConElLapizArribaBajoYSuboSuLapizUsandoBloquesYNoDebeDibujar() {
        SectorDibujo sectorDibujo = new SectorDibujo();
        SectorDibujo sectorDibujoVacio = new SectorDibujo();

        Personaje personaje = new Personaje(new Lapiz(sectorDibujo));

        BloqueLapizAbajo bloqueLapizAbajo = new BloqueLapizAbajo();
        BloqueLapizArriba bloqueLapizArriba = new BloqueLapizArriba();

        bloqueLapizAbajo.ejecutarSobre(personaje);
        bloqueLapizArriba.ejecutarSobre(personaje);

        BloqueDerecha bloqueDerecha = new BloqueDerecha();
        bloqueDerecha.ejecutarSobre(personaje);


        assertEquals(sectorDibujo, sectorDibujoVacio);

    }

   @Test
    public void test03CreoUnPersonajeYLeOrdenoSubirElLapizDosVecesYAlMoverseNoDebeDibujar() {
       SectorDibujo sectorDibujo = new SectorDibujo();
       Personaje personaje = new Personaje(new Lapiz(sectorDibujo));
       BloqueLapizArriba bloqueLapizArriba = new BloqueLapizArriba();
       BloqueDerecha bloqueDerecha = new BloqueDerecha();

       bloqueLapizArriba.ejecutarSobre(personaje);
       bloqueLapizArriba.ejecutarSobre(personaje);
       bloqueDerecha.ejecutarSobre(personaje);

       SectorDibujo sectorDibujoVacio = new SectorDibujo();
       assertEquals(sectorDibujo, sectorDibujoVacio);

    }

    @Test
    public void obtenerElIDDelBloqueDebeDevolverBloqueLapizArriba(){
        assertEquals("BloqueLapizArriba", (new BloqueLapizArriba()).obtenerID());
    }

}