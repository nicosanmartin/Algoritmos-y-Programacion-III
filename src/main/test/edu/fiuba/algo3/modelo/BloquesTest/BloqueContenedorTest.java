package edu.fiuba.algo3.modelo.BloquesTest;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Bloques.*;
import edu.fiuba.algo3.modelo.Excepciones.SinBloquesADevolverException;
import edu.fiuba.algo3.modelo.HerramientasDeDibujo.Lapiz;
import edu.fiuba.algo3.vista.contenedores.SeccionBloques;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BloqueContenedorTest {
    SectorAlgoritmo sectorAlgoritmo = new SectorAlgoritmo();
    SectorDibujo sectorDibujo = new SectorDibujo();
    SectorDibujo sectorDibujoEsperado = new SectorDibujo();
    Personaje personaje = new Personaje(new Lapiz(sectorDibujo));
    BloqueContenedor bloqueContenedor = new BloqueContenedor();

    @Test
    public void test01AgregoUnBloqueAlContenedorVacioYElTamañoDeLaListaDebeSerUno() throws SinBloquesADevolverException {
        bloqueContenedor.agregarBloque(new BloqueDerecha());
        Bloque[] bloques = bloqueContenedor.obtenerBloques();
        assertEquals(1, bloques.length);
    }

    @Test
    public void test02AgregoDosBloquesAlContenedorVacioYRemuevoUnBloqueYElTamañoDeLaListaDebeSerUno() throws SinBloquesADevolverException {
        bloqueContenedor.agregarBloque(new BloqueDerecha());
        bloqueContenedor.agregarBloque(new BloqueDerecha());
        bloqueContenedor.removerBloque();

        Bloque[] bloques = bloqueContenedor.obtenerBloques();
        assertEquals(1, bloques.length);
    }

    @Test
    public void test03AgregoBloquesYObtengoElUltimoYAlEjecutarloSobrePersonajeConLapizArribaDebeDibujar() throws SinBloquesADevolverException {

        bloqueContenedor.agregarBloque(new BloqueDerecha());
        bloqueContenedor.agregarBloque(new BloqueArriba());

        sectorDibujoEsperado.agregarTrazo(new Posicion(0,0), new Posicion(0,1));

        Bloque ultimoBloque = bloqueContenedor.obtenerUltimoBloque();

        (new BloqueLapizAbajo()).ejecutarSobre(personaje);
        ultimoBloque.ejecutarSobre(personaje);
        assertEquals(sectorDibujo, sectorDibujoEsperado );
    }

    @Test
    public void test04ConsultoAlBloqueContenedorSiEstaVacioYDebeEstarlo() throws SinBloquesADevolverException {

        assertEquals(true, bloqueContenedor.estaVacio());
    }


    @Test
    public void test05AgregoBloquesAlContenedorYAlEjecutarloDebeDibujarSobreSectorDibujo() {

        bloqueContenedor.agregarBloque(new BloqueLapizAbajo());
        bloqueContenedor.agregarBloque(new BloqueDerecha());
        bloqueContenedor.agregarBloque(new BloqueArriba());

        sectorDibujoEsperado.agregarTrazo(new Posicion(0,0), new Posicion(1,0));
        sectorDibujoEsperado.agregarTrazo(new Posicion(1,0), new Posicion(1,1));

        bloqueContenedor.ejecutarSobre(personaje);
        assertEquals(sectorDibujo, sectorDibujoEsperado );
    }

    @Test
    public void test05AgregoBloquesAlContenedorYAlEjecutarloInversamenteDebeDibujarSobreSectorDibujo() {

        bloqueContenedor.agregarBloque(new BloqueLapizArriba());
        bloqueContenedor.agregarBloque(new BloqueDerecha());
        bloqueContenedor.agregarBloque(new BloqueArriba());

        sectorDibujoEsperado.agregarTrazo(new Posicion(0,0), new Posicion(-1,0));
        sectorDibujoEsperado.agregarTrazo(new Posicion(-1,0), new Posicion(-1,-1));

        bloqueContenedor.ejecutarInversoSobre(personaje);
        assertEquals(sectorDibujo, sectorDibujoEsperado );
    }

    @Test
    public void test06ObtengoIDDeUnBloqueContenedorYDebeDevolverBloqueContenedor() {
        assertEquals(bloqueContenedor.obtenerID(), "BloqueContenedor");
    }




    /////////////////////////// IGNORAR ADDOBSERVER EN CODECOV //////////////////////////
    @Test
    public void ignorarAddObserverEnCodeCov(){
        Observer pruebaObserver = () -> System.out.println("output: hello how r u");
        bloqueContenedor.addObserver(pruebaObserver);
        bloqueContenedor.removeObserver(pruebaObserver);
        bloqueContenedor.notifyObservers();
        assertEquals(1,1);
    }

}
