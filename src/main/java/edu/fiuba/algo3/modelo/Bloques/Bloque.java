package edu.fiuba.algo3.modelo.Bloques;

import edu.fiuba.algo3.modelo.Personaje;

public interface Bloque {
    void ejecutarSobre(Personaje personaje);
    void ejecutarInversoSobre(Personaje personaje);
    String obtenerID();
}