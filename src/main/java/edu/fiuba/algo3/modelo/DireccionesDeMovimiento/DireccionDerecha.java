package edu.fiuba.algo3.modelo.DireccionesDeMovimiento;

public class DireccionDerecha implements Direccion{

    @Override
    public int cambioEnX() { return 1; }

    @Override
    public int cambioEnY() { return 0; }
}