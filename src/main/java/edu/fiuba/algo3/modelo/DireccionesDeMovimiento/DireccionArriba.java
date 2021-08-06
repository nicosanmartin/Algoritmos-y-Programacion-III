package edu.fiuba.algo3.modelo.DireccionesDeMovimiento;

public class DireccionArriba implements Direccion{

    @Override
    public int cambioEnX() { return 0; }

    @Override
    public int cambioEnY() { return 1; }
}