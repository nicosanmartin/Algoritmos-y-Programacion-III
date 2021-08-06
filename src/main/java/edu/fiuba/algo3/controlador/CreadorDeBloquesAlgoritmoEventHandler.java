package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.SectorAlgoritmo;
import edu.fiuba.algo3.modelo.SectorBloques;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class CreadorDeBloquesAlgoritmoEventHandler implements EventHandler<MouseEvent> {
    SectorAlgoritmo sectorAlgoritmo;
    SectorBloques sectorBloques;
    String nombreDeBloqueAlgoritmo;

    public CreadorDeBloquesAlgoritmoEventHandler(SectorAlgoritmo unSectorAlgoritmo, SectorBloques unSectorBloques, String unNombre){
        this.sectorAlgoritmo = unSectorAlgoritmo;
        this.sectorBloques = unSectorBloques;
        this.nombreDeBloqueAlgoritmo = unNombre;

    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        this.sectorAlgoritmo.agregarBloque(this.sectorBloques.seleccionarBloque(this.nombreDeBloqueAlgoritmo));
    }
}
