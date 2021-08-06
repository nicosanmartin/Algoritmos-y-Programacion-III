package edu.fiuba.algo3.modelo.Bloques;

import edu.fiuba.algo3.modelo.Personaje;

public class BloqueRepetidor extends BloqueContenedor {

    private final int cantidadDeRepeticiones;

    public BloqueRepetidor(int unaCantidad){
        this.cantidadDeRepeticiones = unaCantidad;
    }

    @Override
    public void ejecutarSobre(Personaje personaje){
        for (int i = 0; i < cantidadDeRepeticiones; ++i) super.ejecutarSobre(personaje);
    }

    @Override
    public void ejecutarInversoSobre(Personaje personaje) {
        for (int i = 0; i < cantidadDeRepeticiones; ++i) super.ejecutarInversoSobre(personaje);
    }

    @Override
    public String obtenerID() {
        return this.getClass().getSimpleName() + this.cantidadDeRepeticiones;
    }
}
