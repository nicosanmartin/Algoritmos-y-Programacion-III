package edu.fiuba.algo3.modelo.Bloques;

import edu.fiuba.algo3.modelo.Personaje;

public class BloqueInversor extends BloqueContenedor {

    @Override
    public void ejecutarSobre(Personaje personaje){
        super.ejecutarInversoSobre(personaje);
    }

    @Override
    public void ejecutarInversoSobre(Personaje personaje) {
        super.ejecutarSobre(personaje);
    }

    @Override
    public String obtenerID() {
        return this.getClass().getSimpleName();
    }
}