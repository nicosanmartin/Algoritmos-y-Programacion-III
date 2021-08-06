package edu.fiuba.algo3.controlador;
import edu.fiuba.algo3.modelo.Bloques.BloqueInversor;
import edu.fiuba.algo3.modelo.SectorAlgoritmo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CreadorDeBloquesInversoresEventHandler implements EventHandler<ActionEvent> {
    SectorAlgoritmo sectorAlgoritmo;

    public CreadorDeBloquesInversoresEventHandler(SectorAlgoritmo unSector){
        this.sectorAlgoritmo = unSector;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.sectorAlgoritmo.agregarBloqueContenedor((new BloqueInversor()));
    }
}
