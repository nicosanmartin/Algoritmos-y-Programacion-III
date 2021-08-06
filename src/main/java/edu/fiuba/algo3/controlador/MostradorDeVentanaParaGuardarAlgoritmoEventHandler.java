package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.SectorAlgoritmo;
import edu.fiuba.algo3.modelo.SectorBloques;
import edu.fiuba.algo3.vista.alertas.VentanaGuardarAlgoritmoPersonalizado;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MostradorDeVentanaParaGuardarAlgoritmoEventHandler implements EventHandler<ActionEvent> {
    private SectorAlgoritmo sectorAlgoritmo;
    private SectorBloques sectorBloques;

    public MostradorDeVentanaParaGuardarAlgoritmoEventHandler(SectorAlgoritmo sectorAlgoritmo, SectorBloques sectorBloques) {
        this.sectorAlgoritmo = sectorAlgoritmo;
        this.sectorBloques = sectorBloques;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String titulo = "Guardado de Algoritmo Personalizado";
        String mensaje = "Ingrese un nombre para su bloque personalizado";

        VentanaGuardarAlgoritmoPersonalizado.display(titulo, mensaje, sectorAlgoritmo, sectorBloques);

    }
}
