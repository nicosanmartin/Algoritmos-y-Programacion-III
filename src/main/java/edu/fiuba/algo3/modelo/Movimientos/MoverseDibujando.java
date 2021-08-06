package edu.fiuba.algo3.modelo.Movimientos;

import edu.fiuba.algo3.modelo.DireccionesDeMovimiento.Direccion;
import edu.fiuba.algo3.modelo.HerramientasDeDibujo.HerramientaDeDibujo;
import edu.fiuba.algo3.modelo.Posicion;

public class MoverseDibujando implements Movimiento {
    private HerramientaDeDibujo herramienta;

    public MoverseDibujando(HerramientaDeDibujo unaHerramienta){
        this.herramienta = unaHerramienta;
    }

    @Override
    public Posicion cambiarPosicion(Posicion posicionInicial, Direccion unaDireccion) {
        Posicion posicionFinal = posicionInicial.obtenerPosicionHacia(unaDireccion);
        this.herramienta.dibujar(posicionInicial, posicionFinal);
        return posicionFinal;
    }
}
