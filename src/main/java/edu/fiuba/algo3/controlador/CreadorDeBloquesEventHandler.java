package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Bloques.Bloque;
import edu.fiuba.algo3.modelo.SectorAlgoritmo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CreadorDeBloquesEventHandler implements EventHandler<ActionEvent> {
    SectorAlgoritmo sectorAlgoritmo;
    Bloque bloque;

    public CreadorDeBloquesEventHandler(SectorAlgoritmo unSector, Bloque unBloque){
        this.sectorAlgoritmo = unSector;
        this.bloque = unBloque;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.sectorAlgoritmo.agregarBloque(this.bloque);
    }
}
