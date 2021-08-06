package edu.fiuba.algo3.modelo.Movimientos;

import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.DireccionesDeMovimiento.Direccion;

public interface Movimiento {
    Posicion cambiarPosicion(Posicion posicionInicial, Direccion unaDireccion);
}
