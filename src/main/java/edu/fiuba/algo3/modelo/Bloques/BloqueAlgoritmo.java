package edu.fiuba.algo3.modelo.Bloques;

import edu.fiuba.algo3.modelo.Personaje;

public class BloqueAlgoritmo implements Bloque{

    private Bloque[] bloques;

    public BloqueAlgoritmo(Bloque[] unosBloques){
        this.bloques = unosBloques;
    }

    @Override
    public void ejecutarSobre(Personaje personaje) {
        for (Bloque unBloque: this.bloques){
            unBloque.ejecutarSobre(personaje);
        }
    }

    @Override
    public void ejecutarInversoSobre(Personaje personaje) {
        for (Bloque unBloque: this.bloques){
            unBloque.ejecutarInversoSobre(personaje);
        }
    }

    @Override
    public String obtenerID() {
        return this.getClass().getSimpleName();
    }
}
