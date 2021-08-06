package edu.fiuba.algo3.modelo.BloquesTest;

import edu.fiuba.algo3.modelo.Bloques.*;
import edu.fiuba.algo3.modelo.HerramientasDeDibujo.Lapiz;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.SectorDibujo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BloqueAlgoritmoTest {

    @Test
    public void test01BloqueAlgoritmoEjecutaCorrectamenteUnBloque () {
        Bloque[] bloques = new Bloque[1];

        bloques[0] = new BloqueArriba();

        BloqueAlgoritmo algoritmo = new BloqueAlgoritmo(bloques);

        Personaje personaje = new Personaje(new Lapiz(new SectorDibujo()));

        algoritmo.ejecutarSobre(personaje);

        Assertions.assertEquals(personaje.obtenerPosicion(), new Posicion(0,1));
    }

    @Test
    public void test02BloqueAlgoritmoEjecutaCorrectamenteElInversoDeUnBloque () {
        Bloque[] bloques = new Bloque[1];

        bloques[0] = new BloqueArriba();

        BloqueAlgoritmo algoritmo = new BloqueAlgoritmo(bloques);

        Personaje personaje = new Personaje(new Lapiz(new SectorDibujo()));

        algoritmo.ejecutarInversoSobre(personaje);

        assertEquals(personaje.obtenerPosicion(), new Posicion(0,-1));
    }

    @Test
    public void test03BloqueAlgoritmoEjecutaCorrectamenteVariosBloque () {
        Bloque[] bloques = new Bloque[7];

        bloques[0] = new BloqueLapizAbajo();
        bloques[1] = new BloqueArriba();
        bloques[2] = new BloqueDerecha();
        bloques[3] = new BloqueAbajo();
        bloques[4] = new BloqueIzquierda();
        bloques[5] = new BloqueLapizArriba();
        bloques[6] = new BloqueIzquierda();

        BloqueAlgoritmo algoritmo = new BloqueAlgoritmo(bloques);

        SectorDibujo sector = new SectorDibujo();
        Personaje personaje = new Personaje(new Lapiz(sector));

        algoritmo.ejecutarSobre(personaje);

        SectorDibujo dibujoEsperado = new SectorDibujo();
        dibujoEsperado.agregarTrazo(new Posicion(0,0), new Posicion(0,1));
        dibujoEsperado.agregarTrazo(new Posicion(0,1), new Posicion(1,1));
        dibujoEsperado.agregarTrazo(new Posicion(1,1), new Posicion(1,0));
        dibujoEsperado.agregarTrazo(new Posicion(1,0), new Posicion(0,0));

        assertEquals(sector, dibujoEsperado);
        assertEquals(personaje.obtenerPosicion(), new Posicion(-1,0));
    }

    @Test
    public void test04BloqueAlgoritmoEjecutaCorrectamenteElInversoDeVariosBloque () {
        Bloque[] bloques = new Bloque[7];

        bloques[0] = new BloqueLapizAbajo();
        bloques[1] = new BloqueArriba();
        bloques[2] = new BloqueDerecha();
        bloques[3] = new BloqueAbajo();
        bloques[4] = new BloqueIzquierda();
        bloques[5] = new BloqueLapizArriba();
        bloques[6] = new BloqueIzquierda();

        BloqueAlgoritmo algoritmo = new BloqueAlgoritmo(bloques);

        SectorDibujo sector = new SectorDibujo();
        Personaje personaje = new Personaje(new Lapiz(sector));

        algoritmo.ejecutarInversoSobre(personaje);

        SectorDibujo dibujoEsperado = new SectorDibujo();
        dibujoEsperado.agregarTrazo(new Posicion(0,0), new Posicion(1,0));

        assertEquals(sector, dibujoEsperado);
        assertEquals(personaje.obtenerPosicion(), new Posicion(1,0));
    }

    @Test
    public void obtenerElIDDelBloqueDebeDevolverBloqueAlgoritmo(){
        Bloque[] bloque = new Bloque[0];
        assertEquals("BloqueAlgoritmo", (new BloqueAlgoritmo(bloque)).obtenerID());
    }

}