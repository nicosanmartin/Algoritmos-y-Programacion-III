package edu.fiuba.algo3.modelo.BloquesTest;

import edu.fiuba.algo3.modelo.Bloques.BloqueAbajo;
import edu.fiuba.algo3.modelo.Bloques.BloqueDerecha;
import edu.fiuba.algo3.modelo.Bloques.BloqueLapizAbajo;
import edu.fiuba.algo3.modelo.Bloques.BloqueLapizArriba;
import edu.fiuba.algo3.modelo.HerramientasDeDibujo.Lapiz;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.SectorDibujo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BloqueLapizAbajoTest {
    @Test
    public void test01CreoUnPersonajeYAlBajarSuLapizYMoverseDebeDibujar() {
        SectorDibujo sectorDibujo = new SectorDibujo();
        SectorDibujo otroSectorDibujo = new SectorDibujo();

        Lapiz lapiz = new Lapiz(sectorDibujo);
        Lapiz otroLapiz = new Lapiz(otroSectorDibujo);

        otroLapiz.dibujar(new Posicion(0,0), new Posicion(1,0));

        Personaje personaje = new Personaje(lapiz);

        BloqueLapizAbajo bloqueLapizAbajo = new BloqueLapizAbajo();
        BloqueDerecha bloqueDerecha = new BloqueDerecha();
        bloqueLapizAbajo.ejecutarSobre(personaje);
        bloqueDerecha.ejecutarSobre(personaje);

        assertEquals(sectorDibujo, otroSectorDibujo);
    }

    @Test
    public void test02CreoUnPersonajeBajoSuLapizLoSuboYLoVuelvoABajarConBloquesYAlMoverseDebeDibujar(){
        SectorDibujo sectorDibujo = new SectorDibujo();
        SectorDibujo otroSectorDibujo = new SectorDibujo();
        BloqueLapizArriba bloqueLapizArriba = new BloqueLapizArriba();
        BloqueLapizAbajo bloqueLapizAbajo = new BloqueLapizAbajo();
        BloqueDerecha bloqueDerecha = new BloqueDerecha();
        Lapiz lapiz = new Lapiz(sectorDibujo);
        Lapiz otroLapiz = new Lapiz(otroSectorDibujo);
        Personaje personaje = new Personaje(lapiz);

        otroLapiz.dibujar(new Posicion(0,0), new Posicion(1,0));

        bloqueLapizAbajo.ejecutarSobre(personaje);
        bloqueLapizArriba.ejecutarSobre(personaje);
        bloqueLapizAbajo.ejecutarSobre(personaje);
        bloqueDerecha.ejecutarSobre(personaje);

        assertEquals(sectorDibujo, otroSectorDibujo);
    }

    @Test
    public void obtenerElIDDelBloqueDebeDevolverBloqueLapizAbajo(){
        assertEquals("BloqueLapizAbajo", (new BloqueLapizAbajo()).obtenerID());
    }

}