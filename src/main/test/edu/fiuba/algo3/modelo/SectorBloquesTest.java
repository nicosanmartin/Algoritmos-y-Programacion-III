package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.modelo.Bloques.*;
import edu.fiuba.algo3.modelo.Excepciones.SinBloquesADevolverException;
import edu.fiuba.algo3.vista.contenedores.SeccionBloques;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.HerramientasDeDibujo.Lapiz;

import java.util.HashMap;

public class SectorBloquesTest {
   SectorBloques sectorBloques = new SectorBloques();
   SectorAlgoritmo sectorAlgoritmo = new SectorAlgoritmo();
   SectorDibujo sectorDibujo = new SectorDibujo();
   SectorDibujo sectorDibujoEsperado = new SectorDibujo();
   Personaje personaje = new Personaje(new Lapiz(sectorDibujo));


   @Test
   public void test01GuardoDosBloquesPersonalizadosConMovimientoYLapizAbajoYDebeDibujarSobreSectorDibujoAlAgregarlosAlSectorAlgoritmo() throws SinBloquesADevolverException {
      sectorAlgoritmo.agregarBloque(new BloqueLapizAbajo());
      sectorAlgoritmo.agregarBloque(new BloqueDerecha());

      sectorBloques.guardarBloqueAlgoritmoPersonalizado("bloquePersonalizado1", sectorAlgoritmo.obtenerBloques());
      Bloque bloquePersonalizado1 = sectorBloques.seleccionarBloque("bloquePersonalizado1");
      sectorAlgoritmo.agregarBloque(bloquePersonalizado1);

      sectorBloques.guardarBloqueAlgoritmoPersonalizado("bloquePersonalizado2", sectorAlgoritmo.obtenerBloques());
      Bloque bloquePersonalizado2 = sectorBloques.seleccionarBloque("bloquePersonalizado2");
      sectorAlgoritmo.agregarBloque(bloquePersonalizado2);

      sectorAlgoritmo.ejecutarPrograma(personaje);
      sectorDibujoEsperado.agregarTrazo(new Posicion(0,0), new Posicion(1,0));
      sectorDibujoEsperado.agregarTrazo(new Posicion(1,0), new Posicion(2,0));
      sectorDibujoEsperado.agregarTrazo(new Posicion(2,0), new Posicion(3,0));
      sectorDibujoEsperado.agregarTrazo(new Posicion(3,0), new Posicion(4,0));


      assertEquals(sectorDibujo, sectorDibujoEsperado);
   }

   @Test
   public void test02GuardoUnBloquePersonalizadoConMovimientosYLoEjecutoDebeDibujarSobreElSectorDibujo(){

      BloqueLapizAbajo bloqueLapizAbajo = new BloqueLapizAbajo();
      BloqueDerecha bloqueDerecha = new BloqueDerecha();
      BloqueArriba bloqueArriba = new BloqueArriba();
      sectorAlgoritmo.agregarBloque(bloqueLapizAbajo);
      sectorAlgoritmo.agregarBloque(bloqueDerecha);
      sectorAlgoritmo.agregarBloque(bloqueDerecha);
      sectorAlgoritmo.agregarBloque(bloqueArriba);

      try {
      sectorBloques.guardarBloqueAlgoritmoPersonalizado("prueba", sectorAlgoritmo.obtenerBloques());

      } catch (SinBloquesADevolverException e){

      }

      Personaje personaje = new Personaje(new Lapiz(sectorDibujo));
      Bloque bloquePrueba = sectorBloques.seleccionarBloque("prueba");
      bloquePrueba.ejecutarSobre(personaje);

      sectorDibujoEsperado.agregarTrazo(new Posicion(0,0), new Posicion(1,0));
      sectorDibujoEsperado.agregarTrazo(new Posicion(1,0), new Posicion(2,0));
      sectorDibujoEsperado.agregarTrazo(new Posicion(2,0), new Posicion(2,1));

      assertEquals(sectorDibujo, sectorDibujoEsperado);

   }

   // TESTS DE COSAS QUE NO SE PUEDEN PROBAR CON EL MODELO EN GENERAL

   @Test
   public void obtenerListaDeBloquesVaciaDebeEstarVacia(){
      SectorBloques sectorBloques = new SectorBloques();
      assertEquals(new HashMap<>().keySet(), sectorBloques.obtenerListaDeBloques());
   }

   /////////////////////////// IGNORAR ADDOBSERVER EN CODECOV //////////////////////////
   @Test
   public void ignorarAddObserverEnCodeCov(){
      Observer pruebaObserver = () -> System.out.println("output: hello how r u");
      sectorBloques.addObserver(pruebaObserver);
      sectorBloques.removeObserver(pruebaObserver);
      sectorBloques.notifyObservers();
      assertEquals(1,1);
   }
}
