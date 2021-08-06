package edu.fiuba.algo3.modelo.Bloques;

import edu.fiuba.algo3.modelo.DireccionesDeMovimiento.Direccion;
import edu.fiuba.algo3.modelo.DireccionesDeMovimiento.DireccionDerecha;
import edu.fiuba.algo3.modelo.DireccionesDeMovimiento.DireccionIzquierda;
import edu.fiuba.algo3.modelo.Personaje;

public class BloqueDerecha implements Bloque {

    @Override
    public void ejecutarSobre(Personaje personaje){
        Direccion derecha = new DireccionDerecha();
        personaje.moverseHacia(derecha);
    }

    @Override
    public void ejecutarInversoSobre(Personaje personaje){
        Direccion izquierda = new DireccionIzquierda();
        personaje.moverseHacia(izquierda);
    }

    @Override
    public String obtenerID() {
        return this.getClass().getSimpleName();
    }
}
