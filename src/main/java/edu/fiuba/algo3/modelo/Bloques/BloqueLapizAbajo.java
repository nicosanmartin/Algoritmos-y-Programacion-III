package edu.fiuba.algo3.modelo.Bloques;

import edu.fiuba.algo3.modelo.Personaje;

public class BloqueLapizAbajo implements Bloque {

    @Override
    public void ejecutarSobre(Personaje personaje){ personaje.bajarLapiz(); }

    @Override
    public void ejecutarInversoSobre(Personaje personaje){
        personaje.subirLapiz();
    }

    @Override
    public String obtenerID() {
        return this.getClass().getSimpleName();
    }
}
