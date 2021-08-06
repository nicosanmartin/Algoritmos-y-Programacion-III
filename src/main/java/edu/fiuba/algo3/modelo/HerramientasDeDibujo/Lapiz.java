package edu.fiuba.algo3.modelo.HerramientasDeDibujo;

import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.SectorDibujo;

public class Lapiz implements HerramientaDeDibujo{
    private SectorDibujo dibujo;

    public Lapiz(SectorDibujo sectorDibujo) {
        this.dibujo = sectorDibujo;
    }

    public void dibujar(Posicion posicionInicial, Posicion posicionFinal){
        dibujo.agregarTrazo(posicionInicial, posicionFinal);
    }
}
