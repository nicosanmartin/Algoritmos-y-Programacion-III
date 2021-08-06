package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Bloques.BloqueContenedor;
import edu.fiuba.algo3.modelo.SectorAlgoritmo;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class SelectorDeContenedoresEventHandler implements EventHandler<MouseEvent> {
    private SectorAlgoritmo sectorAlgoritmo;
    private BloqueContenedor contenedor;

    public SelectorDeContenedoresEventHandler(SectorAlgoritmo unSector, BloqueContenedor unContenedor){
        this.sectorAlgoritmo = unSector;
        this.contenedor = unContenedor;
    }

    @Override
    public void handle(MouseEvent actionEvent) {
        this.sectorAlgoritmo.establecerContenedor(this.contenedor);
    }
}
