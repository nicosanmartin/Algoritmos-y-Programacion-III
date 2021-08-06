package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.DireccionesDeMovimiento.Direccion;

import java.util.Objects;

public class Posicion {
    private int x;
    private int y;

    public Posicion(int unaCoordenada, int otraCoordenada){
        this.x = unaCoordenada;
        this.y = otraCoordenada;
    }

    public Posicion obtenerPosicionHacia(Direccion unaDireccion){
        int nuevaX = this.x + unaDireccion.cambioEnX();
        int nuevaY = this.y + unaDireccion.cambioEnY();

        return new Posicion(nuevaX, nuevaY);
    }

    public int obtenerX() {
        return x;
    }

    public int obtenerY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posicion posicion = (Posicion) o;
        return x == posicion.x && y == posicion.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Posicion(" + this.x + " , " + this.y + " )";
    }
}
