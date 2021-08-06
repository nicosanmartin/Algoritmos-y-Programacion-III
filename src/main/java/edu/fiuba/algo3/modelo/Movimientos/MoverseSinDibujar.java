package edu.fiuba.algo3.modelo.Movimientos;

import edu.fiuba.algo3.modelo.DireccionesDeMovimiento.Direccion;
import edu.fiuba.algo3.modelo.Posicion;

public class MoverseSinDibujar implements Movimiento {

    @Override
    public Posicion cambiarPosicion(Posicion posicionInicial, Direccion unaDireccion) {
        return posicionInicial.obtenerPosicionHacia(unaDireccion);
    }
}
