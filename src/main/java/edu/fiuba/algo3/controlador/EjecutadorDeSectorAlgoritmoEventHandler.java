package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.SectorAlgoritmo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class EjecutadorDeSectorAlgoritmoEventHandler implements EventHandler<ActionEvent> {
    private SectorAlgoritmo sectorAlgoritmo;
    private Personaje personaje;

    public EjecutadorDeSectorAlgoritmoEventHandler(SectorAlgoritmo unSectorAlgoritmo, Personaje unPersonaje){
        sectorAlgoritmo = unSectorAlgoritmo;
        personaje = unPersonaje;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        sectorAlgoritmo.ejecutarPrograma(personaje);
    }
}
