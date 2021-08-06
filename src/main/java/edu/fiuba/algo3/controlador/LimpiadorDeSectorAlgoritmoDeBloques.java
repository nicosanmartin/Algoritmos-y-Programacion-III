package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.SectorAlgoritmo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class LimpiadorDeSectorAlgoritmoDeBloques implements EventHandler<ActionEvent> {
    private SectorAlgoritmo sectorAlgoritmo;

    public LimpiadorDeSectorAlgoritmoDeBloques(SectorAlgoritmo unSectorAlgoritmo){
        this.sectorAlgoritmo = unSectorAlgoritmo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.sectorAlgoritmo.vaciarSector();
    }
}
